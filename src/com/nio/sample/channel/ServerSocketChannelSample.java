package com.nio.sample.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelSample {

	public static void main(String[] args) throws IOException {

		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(8000));

		while (true) {

//			System.out.println("bind");

			SocketChannel socketChannel = serverSocketChannel.accept();

			if (socketChannel != null) {
//				System.out.println("accept");
				ByteBuffer buffer = ByteBuffer.allocate(256);
				socketChannel.read(buffer);

				buffer.flip();

				StringBuilder receiveData = new StringBuilder();
				
//				while (buffer.hasRemaining()) {
//					System.out.print((char) buffer.get());
					
					receiveData.append(new String(buffer.array()));
//				}
					
				System.err.println(receiveData.toString());
			}
			
			 

			// socketChannel.close();

		}
		// serverSocketChannel.close();

	}

}
