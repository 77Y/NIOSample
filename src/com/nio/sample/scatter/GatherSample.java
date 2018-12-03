package com.nio.sample.scatter;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GatherSample {

	public static void main(String[] args) {

		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile(
					"/Users/yangpeng/Documents/360/code/QiwooSample/NIOSample/src/com/nio/sample/file.txt", "rw");
			randomAccessFile.seek(0);

			FileChannel fileChannel = randomAccessFile.getChannel();
			System.out.println("FileChannel position " + fileChannel.position());

			ByteBuffer buffer = ByteBuffer.allocate(100);
			String str = "hello";
			buffer.clear();
			buffer.put(str.getBytes());
			buffer.flip();

			ByteBuffer buffer2 = ByteBuffer.allocate(100);
			String str2 = " world";
			buffer2.clear();
			buffer2.put(str2.getBytes());
			buffer2.flip();

			ByteBuffer[] bufferArray = { buffer, buffer2 };
			fileChannel.write(bufferArray);

			randomAccessFile.close();
			fileChannel.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
