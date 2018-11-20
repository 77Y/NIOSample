package com.nio.sample.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SelectorServerSocketChannelSample {

	public static void main(String[] args) throws Exception {

		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

		serverSocketChannel.socket().bind(new InetSocketAddress(9000));
		serverSocketChannel.configureBlocking(false);

		Selector selector = Selector.open();

		// configureBlocking 如果不设置非阻塞，register的时候会报异常
		// java.nio.channels.IllegalBlockingModeException
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		while (true) {
			// System.err.println("hello");
			int selected = selector.select();
			// System.err.println("hello2 " + selected);

			if (selected > 0) {

				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
				while (iterator.hasNext()) {

					SelectionKey selectionKey = iterator.next();

					if (selectionKey.isAcceptable()) {
						// System.err.println("Acceptable");

						SocketChannel socketChannel = serverSocketChannel.accept();
						socketChannel.configureBlocking(false);
						socketChannel.register(selector, SelectionKey.OP_READ);

					} else if (selectionKey.isConnectable()) {
						System.err.println("Connectable");
					} else if (selectionKey.isReadable()) {
						// System.err.println("Readable");
						SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

						ByteBuffer buffer = ByteBuffer.allocate(128);
						socketChannel.read(buffer);
						buffer.flip();
						while (buffer.hasRemaining()) {
							System.out.print((char) buffer.get());
							System.out.println("--");
						}
						// System.out.println("*****");

					} else if (selectionKey.isWritable()) {
						System.err.println("Writable");
					}

					iterator.remove();
				}

			}

		}
	}

}
