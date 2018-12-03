package com.nio.sample.scatter;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ScatterSample {

	public static void main(String[] args) {
		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile(
					"/Users/yangpeng/Documents/360/code/QiwooSample/NIOSample/src/com/nio/sample/file.txt", "rw");
			randomAccessFile.seek(0);

			FileChannel fileChannel = randomAccessFile.getChannel();

			ByteBuffer buffer = ByteBuffer.allocate(5);

			ByteBuffer buffer2 = ByteBuffer.allocate(100);

			ByteBuffer[] bufferArray = { buffer, buffer2 };

			fileChannel.read(bufferArray);

			buffer.flip();
			while (buffer.hasRemaining()) {
				System.out.print((char) buffer.get());
			}

			System.out.println("");

			buffer2.flip();
			while (buffer2.hasRemaining()) {
				System.out.print((char) buffer2.get());
			}

			randomAccessFile.close();
			fileChannel.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
