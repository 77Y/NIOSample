package com.nio.sample.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelSample {

	public static void main(String[] args) {

		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile(
					"/Users/yangpeng/Documents/360/code/QiwooSample/NIOSample/src/com/nio/sample/file.txt", "rw");
			randomAccessFile.seek(0);

			FileChannel fileChannel = randomAccessFile.getChannel();
			System.out.println("FileChannel position " + fileChannel.position());

			ByteBuffer buffer = ByteBuffer.allocate(100);
			// fileChannel中读出来，写到buffer中
			int read = fileChannel.read(buffer);
			System.out.println("read " + read);
			System.out.println("buffer position " + buffer.position());
			System.out.println("buffer limit " + buffer.limit());

			buffer.flip();

			while (buffer.hasRemaining()) {
				System.out.print((char) buffer.get());
			}

			String str = " is best";
			buffer.clear();
			buffer.put(str.getBytes());
			buffer.flip();
			// 从buffer中读出来，通过channel写入到文件中
			while (buffer.hasRemaining()) {
				fileChannel.write(buffer);
			}

			randomAccessFile.close();
			fileChannel.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
