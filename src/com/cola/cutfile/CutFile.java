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
	// ÿ��С�ļ��Ĵ�С
	public long unitSize = 200 * 1024 * 1024;
	// �ָ��С�ļ����ڵ��ļ���
	public String targetDir = "c:\\";

	public int cutFile() throws Exception {
		File file = new File(fileName);
		// ���ֽ���
		long size = file.length();
		// С�ļ���
		int count = 0;
		// ��ǰλ��
		long pos = 0;
		// ʣ���ֽ���
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
			// дС�ļ�
			try {
				RandomAccessFile raFile = new RandomAccessFile(targetDir
						+ file.getName() + "_" + count, "rw");
				raFile.write(databuf);
				raFile.close();
			} catch (Exception e) {
				throw e;
			}
		}
		// ����С�ļ���
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