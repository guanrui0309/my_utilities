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
				System.out.println("文件夹:" + FILE_PATH + "中子目录为:"
						+ file.getAbsolutePath());
			} else {
				System.out.println("文件夹:" + FILE_PATH + "中文件为:"
						+ file.getAbsolutePath());
			}
		}
	}

	public static void main(String[] args) {
		getFiles(FILE_PATH);
	}

}
