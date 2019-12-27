package org.kwok.netty.httpproxy;

import java.net.SocketAddress;
import java.nio.charset.Charset;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

public class HttpProxyServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

		FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
	
		response.headers().set(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON);
		response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);

		if (msg instanceof FullHttpRequest) {

			// InetSocketAddress inetSocketAddress =
			// (InetSocketAddress)ctx.channel().remoteAddress();
			SocketAddress socketAddress = ctx.channel().remoteAddress();
			System.out.println(SocketAddressUtil.getIp(socketAddress));

			FullHttpRequest request = (FullHttpRequest) msg;
			String uri = request.uri();
			if ("/favicon.ico".equals(uri)) {
				return;
			}
			
			
			System.out.println(request.content().toString(Charset.defaultCharset()));
			
			response.content().writeBytes(Unpooled.wrappedBuffer("SUCCESS".getBytes()));

		} else {
			response.content().writeBytes(Unpooled.wrappedBuffer("Error, No Http Request".getBytes()));

		}
		
		response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
		ctx.writeAndFlush(response);

	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.close();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}

}
