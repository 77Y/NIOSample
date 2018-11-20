package com.nio.sample.channel;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelClientSample {

	public static void main(String[] args) throws IOException {

		DatagramChannel datagramChannel = DatagramChannel.open();
		datagramChannel.socket().bind(new InetSocketAddress(8888));

		ByteBuffer buffer = ByteBuffer.allocate(100);

		buffer.put("qiwoo".getBytes());
		buffer.flip();

		InetAddress address = InetAddress.getLocalHost();
		datagramChannel.send(buffer, new InetSocketAddress(address, 8889));
	}

}
