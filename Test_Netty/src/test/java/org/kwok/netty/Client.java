package org.kwok.netty;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.string.StringEncoder;

public class Client {

	public static void main(String[] args) throws URISyntaxException {

		Bootstrap bootstrap = new Bootstrap();
		NioEventLoopGroup group = new NioEventLoopGroup();

		bootstrap.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(new HttpResponseDecoder(), new HttpRequestEncoder(),
						new StringEncoder(Charset.forName("UTF-8")), new ChannelInboundHandlerAdapter() {

							@Override
							public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
								if (msg instanceof HttpResponse) {
									HttpResponse response = (HttpResponse) msg;
									System.out.println(response.status());
								}
								if (msg instanceof HttpContent) {
									HttpContent content = (HttpContent) msg;
									ByteBuf buf = content.content();
									System.out.println(buf.toString(Charset.forName("UTF-8")));
									buf.release();
								}
							}

						});
			}
		});

		try {
			ChannelFuture f = bootstrap.connect("127.0.0.1", 18080).sync();
			DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET,
					new URI("/index").toString(), Unpooled.wrappedBuffer("client".getBytes()));

			// 构建http请求
			request.headers().set(HttpHeaderNames.HOST, "");
			request.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderNames.CONNECTION);
			request.headers().set(HttpHeaderNames.CONTENT_LENGTH, request.content().readableBytes());

			// 发送http请求
			f.channel().write(request);
			f.channel().flush();
			Thread.sleep(500);
			f.channel().close().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			group.shutdownGracefully();
		}

	}

}
