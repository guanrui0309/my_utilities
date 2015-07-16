package com.cola.getdir;

import java.io.File;
import java.util.ArrayList;

public class GetDir {

	private static ArrayList<String> fileList = new ArrayList<String>();
	private static String FILE_PATH = "D:\\tools\\nike-bot-master";

	private static void getFiles(String filePath) {
		File root = new File(filePath);
		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				getFiles(file.getAbsolutePath());
				fileList.add(file.getAbsolutePath());
				System.out.println("�ļ���:" + FILE_PATH + "����Ŀ¼Ϊ:"
						+ file.getAbsolutePath());
			} else {
				System.out.println("�ļ���:" + FILE_PATH + "���ļ�Ϊ:"
						+ file.getAbsolutePath());
			}
		}
	}

	public static void main(String[] args) {
		getFiles(FILE_PATH);
	}

}
