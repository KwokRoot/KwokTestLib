package org.kwok.netty.http;

import java.net.URI;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpVersion;

public class HttpClient {
    public static void main(String[] args) throws Exception {

    	EventLoopGroup workerGroup = new NioEventLoopGroup();
        
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                	ch.pipeline().addLast("http-decoder", new HttpResponseDecoder());
                    ch.pipeline().addLast("http-encoder", new HttpRequestEncoder());
                    ch.pipeline().addLast(new HttpClientHandler());
                }
            });
            
            // Start the client.
            ChannelFuture future = b.connect("127.0.0.1", 8080).sync();
			URI uri = new URI("http://127.0.0.1:8080");
			DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET,  
                    uri.toASCIIString(), Unpooled.wrappedBuffer("hello Netty".getBytes("UTF-8")));  
			request.headers().set(HttpHeaderNames.CONTENT_LENGTH,request.content().capacity());
            if(future.isSuccess()){
            	System.out.println("success");
				ChannelFuture f = future.channel().writeAndFlush(request).sync();
				// Wait until the connection is closed.
				f.channel().closeFuture().sync();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			workerGroup.shutdownGracefully();
		}
    }
}
