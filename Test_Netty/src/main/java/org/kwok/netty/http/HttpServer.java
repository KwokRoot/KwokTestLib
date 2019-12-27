package org.kwok.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpServer {
	private int port;

public HttpServer(int port) {
    this.port = port;
}

public void run() throws Exception {
	
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    try {
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup)
         .channel(NioServerSocketChannel.class)
         .option(ChannelOption.SO_BACKLOG, 1024)
         .childOption(ChannelOption.SO_KEEPALIVE, true)
         .childHandler(new ChannelInitializer<SocketChannel>() { 
             @Override
             public void initChannel(SocketChannel ch) throws Exception {
            	 ChannelPipeline pipeline = ch.pipeline();
            	 //pipeline.addLast("decoder", new HttpRequestDecoder());
                 //pipeline.addLast("encoder", new HttpResponseEncoder());            	 
                 pipeline.addLast("http-coder",new HttpServerCodec());
                 pipeline.addLast(new HttpServerHandler());
             }
         });

        ChannelFuture f = b.bind(port).sync();
        f.channel().closeFuture().sync();
        
    } finally {
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }
}

public static void main(String[] args) throws Exception {
    int port = 8080;
    if (args.length > 0) {
        port = Integer.parseInt(args[0]);
    }

    new HttpServer(port).run();
}}
