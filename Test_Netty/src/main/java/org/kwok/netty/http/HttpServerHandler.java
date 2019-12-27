package org.kwok.netty.http;

import java.util.HashMap;
import java.util.Map;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;

public class HttpServerHandler extends ChannelInboundHandlerAdapter {
	private String content = "Hello World";
	private final static String LOC = "302";
	private final static String NOT_FOND = "404";
	private final static String BAD_REQUEST = "400";
	private final static String INTERNAL_SERVER_ERROR = "500";
	private static Map<String, HttpResponseStatus> mapStatus = new HashMap<String, HttpResponseStatus>();
	static {
		mapStatus.put(LOC, HttpResponseStatus.FOUND);
		mapStatus.put(NOT_FOND, HttpResponseStatus.NOT_FOUND);
		mapStatus.put(BAD_REQUEST, HttpResponseStatus.BAD_REQUEST);
		mapStatus.put(INTERNAL_SERVER_ERROR, HttpResponseStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (msg instanceof HttpRequest) {
			HttpRequest request = (HttpRequest) msg;
			boolean keepaLive = HttpUtil.isKeepAlive(request);
			System.out.println("method:" + request.method().name().toUpperCase());
			System.out.println("uri:" + request.uri());
			String uri = request.uri().replace("/", "").trim();
			FullHttpResponse httpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
			if (mapStatus.get(uri) != null) {
				httpResponse.setStatus(mapStatus.get(uri));
				httpResponse.content().writeBytes(mapStatus.get(uri).toString().getBytes());
			} else {
				httpResponse.content().writeBytes(content.getBytes());
			}
			// 重定向处理
			if (httpResponse.status().equals(HttpResponseStatus.FOUND)) {
				httpResponse.headers().set(HttpHeaderNames.LOCATION, "https://www.baidu.com/");
			}
			httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html;charset=UTF-8");
			httpResponse.headers().setInt(HttpHeaderNames.CONTENT_LENGTH, httpResponse.content().readableBytes());
			if (keepaLive) {
				httpResponse.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
				ctx.writeAndFlush(httpResponse);
			} else {
				ctx.writeAndFlush(httpResponse).addListener(ChannelFutureListener.CLOSE);
			}
		}
	}
}
