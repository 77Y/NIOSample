package com.nio.sample.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelSample {

	public static void main(String[] args) throws IOException, InterruptedException {

		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));

		int count = 0;
		while (count < 5) {

			boolean isConnect = socketChannel.isConnected();
			System.out.println("is connect: " + isConnect + " count: " + count);

			ByteBuffer buffer = ByteBuffer.allocate(128);
			buffer.clear();
			buffer.put(("qiwoo").getBytes());

			buffer.flip();
			while (buffer.hasRemaining()) {
				socketChannel.write(buffer);
			}

			// socketChannel.close();
			Thread.sleep(5000);
			count++;

		}
	}

}
