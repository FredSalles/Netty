/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nettyserver;

import io.netty.buffer.ByteBuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Handles a server-side channel.
 */
//public class EchoServerHandler extends ChannelInboundHandlerAdapter { // (1)
public class EchoServerHandler extends SimpleChannelInboundHandler<String> { // (1)

    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg) { // (2)
        String s = (String) msg;
        System.out.print(s);
        System.out.flush();
    }

    /**
     * @Override public void channelRead(ChannelHandlerContext ctx, Object msg)
     * { // (2) ByteBuf in = (ByteBuf) msg; try { while (in.isReadable()) { //
     * (1) System.out.print((char) in.readByte()); System.out.flush(); } }
     * finally { ((ByteBuf) msg).release(); // (3) }
    }*
     */
    /*@Override
     public void channelRead(ChannelHandlerContext ctx, Object msg) {
     ctx.write(msg); // (1)
     ctx.flush(); // (2)
     }*/
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
