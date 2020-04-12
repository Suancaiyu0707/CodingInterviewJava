package com.xuzf;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * 文件工具
 *
 * @author yujia.cheng@zhangmen.com
 * @since 2018/12/3 16:52
 */
public class FileHelper {

	/**
	 * 获取 uuid
	 *
	 * @author yujia.cheng@zhangmen.com
	 * @since 2019/7/22 16:29
	 *
	 * @return
	 */
	public static String generateUuid() {
		return UUID.randomUUID().toString();
	}

	/**
	 * upload local
	 *
	 * @author yujia.cheng@zhangmen.com
	 * @since 2019/7/22 21:14
	 *
	 * @param fileName
	 * @param uploadDir
	 * @param inputStream
	 */
	public static String uploadFile2Local(String fileName, String uploadDir, InputStream inputStream) {
		String uuid = generateUuid();
		String parentPath = uploadDir+"/"+uuid+"/";

		File parent = new File(parentPath);
		if (!parent.exists() || parent.isFile()) {
			parent.mkdirs();
		}
//		try {
//			System.out.println("inputStream.size="+inputStream.available());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		String fullPath = parentPath+fileName;
		try {
			Files.copy(inputStream, Paths.get(fullPath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		File file = new File(fullPath);
		return file.getAbsolutePath();
	}

	public static void fileCopyWithFileChannel(File fromFile, File toFile) {
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		FileChannel fileChannelInput = null;
		FileChannel fileChannelOutput = null;
		try {
			fileInputStream = new FileInputStream(fromFile);
			fileOutputStream = new FileOutputStream(toFile);
			//得到fileInputStream的文件通道
			fileChannelInput = fileInputStream.getChannel();
			//得到fileOutputStream的文件通道
			fileChannelOutput = fileOutputStream.getChannel();
			//将fileChannelInput通道的数据，写入到fileChannelOutput通道
			fileChannelInput.transferTo(0, fileChannelInput.size(), fileChannelOutput);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileInputStream != null)
					fileInputStream.close();
				if (fileChannelInput != null)
					fileChannelInput.close();
				if (fileOutputStream != null)
					fileOutputStream.close();
				if (fileChannelOutput != null)
					fileChannelOutput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	static void download(String fileName, InputStream inputStream){
		FileOutputStream out = null;
		FileChannel channel = null;
		ByteBuffer buffer = null;
		try {

			out = new FileOutputStream(fileName);
			channel = out.getChannel();
			int size = inputStream.available();
//			System.out.println("size="+size);
			byte buf[] = new byte[size];
			inputStream.read(buf);
			buffer = ByteBuffer.wrap(buf);
//			System.out.println("remaining="+buffer.remaining());
			out.flush();
			channel.write(buffer);
		} catch (Exception e) {
			System.out.println("下载文件失败");
		} finally {
			try {
				channel.close();
				out.close();
			} catch (IOException e) {
				System.out.println("下载文件失败");
			}
		}
	}


	public static String uploadFile2LocalNew(String fileName, InputStream inputStream) {

		String uuid = generateUuid();
		String parentPath = "/Users/xuzhifang/Desktop"+"/"+ uuid+ "/";

		File parent = new File(parentPath);
		if (!parent.exists() || parent.isFile()) {
			parent.mkdirs();
		}

		String fullPath = parentPath+fileName;

		download(fullPath, inputStream);

		File file = new File(fullPath);

		return file.getAbsolutePath();
	}

	public static void main(String[] args) throws Exception {
		File file = new File("/Users/xuzhifang/Documents/Suancaiyu/pdf/");
		if(file.isDirectory()){
			long beginTime = System.currentTimeMillis();
			File[] files = file.listFiles();
			for(File f:files){
				InputStream redis = new FileInputStream(f);

				uploadFile2Local( f.getName(),"/Users/xuzhifang/Desktop",redis);
			}
			System.out.println("cost time="+(System.currentTimeMillis()-beginTime));
			beginTime = System.currentTimeMillis();
			for(File f:files){
				InputStream redis = new FileInputStream(f);

				uploadFile2LocalNew( f.getName(),redis);
			}
			System.out.println("cost time="+(System.currentTimeMillis()-beginTime));
		}


	}
}
