package com.nio.sample.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelServerSample {

	public static void main(String[] args) throws IOException {

		DatagramChannel datagramChannel = DatagramChannel.open();
		datagramChannel.socket().bind(new InetSocketAddress(8889));

		System.out.println("bind");
		ByteBuffer buffer = ByteBuffer.allocate(100);
		buffer.clear();
		datagramChannel.receive(buffer);
		System.out.println("receive");
		buffer.flip();
		while (buffer.hasRemaining()) {
			System.out.print((char) buffer.get());
		}
	}
}
