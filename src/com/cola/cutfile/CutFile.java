package com.cola.cutfile;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.RandomAccessFile;

public class CutFile {
	public String fileName = "c:\\tornado.log";
	// 每个小文件的大小
	public long unitSize = 200 * 1024 * 1024;
	// 分割后小文件所在的文件夹
	public String targetDir = "c:\\";

	public int cutFile() throws Exception {
		File file = new File(fileName);
		// 总字节数
		long size = file.length();
		// 小文件数
		int count = 0;
		// 当前位置
		long pos = 0;
		// 剩余字节数
		long last = 0;
		DataInputStream dis = new DataInputStream(new BufferedInputStream(
				new FileInputStream(file), (int) unitSize));
		byte[] databuf = new byte[(int) unitSize];
		while (pos < size) {
			count++;
			last = size - pos;
			if (last < unitSize)
				databuf = new byte[(int) last];
			dis.read(databuf);
			System.out.println("count=" + count + ";pos=" + pos
					+ ";databuf.length=" + databuf.length);
			pos = pos + databuf.length;
			// 写小文件
			try {
				RandomAccessFile raFile = new RandomAccessFile(targetDir
						+ file.getName() + "_" + count, "rw");
				raFile.write(databuf);
				raFile.close();
			} catch (Exception e) {
				throw e;
			}
		}
		// 记载小文件数
		File file1 = new File(targetDir + file.getName() + "_count");
		FileWriter fWriter = new FileWriter(file1);
		BufferedWriter bWriter = new BufferedWriter(fWriter);
		String string = (new Integer(count)).toString();
		bWriter.write(string, 0, string.length());
		bWriter.flush();
		bWriter.close();
		return count;
	}

	public static void main(String args[]) {
		CutFile cf = new CutFile();
		try {
			cf.cutFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}