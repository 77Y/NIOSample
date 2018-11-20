package com.nio.sample.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SelectorSample {

	public static void main(String[] args) throws IOException {

		con(1);
		con(2);
		con(3);
	}

	static void con(int i) throws IOException {

		SocketChannel socketChannel = SocketChannel.open();

		socketChannel.configureBlocking(false);
		Selector selector = Selector.open();
		socketChannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);

		socketChannel.connect(new InetSocketAddress("127.0.0.1", 9000));

		while (true) {
			int selected = selector.select();

			if (selected > 0) {

				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
				while (iterator.hasNext()) {

					SelectionKey selectionKey = iterator.next();

					if (selectionKey.isConnectable()) {
						System.err.println("Connectable");
						socketChannel.finishConnect();
						socketChannel.register(selector, SelectionKey.OP_WRITE);
					} else if (selectionKey.isReadable()) {
						System.err.println("Readable");

					} else if (selectionKey.isWritable()) {
						
						System.err.println("Writable");
						
						ByteBuffer buffer = ByteBuffer.allocate(128);
						buffer.clear();
						buffer.put(("qiwoo:" + i).getBytes());

						buffer.flip();
						while (buffer.hasRemaining()) {
							socketChannel.write(buffer);
						}
						
						socketChannel.close();
					}
					// 注意remove调，否则会一直存在
					iterator.remove();
				}
			}
		}

		// socketChannel.close();
	}

}
