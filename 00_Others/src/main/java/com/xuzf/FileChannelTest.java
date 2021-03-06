package com.xuzf;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/4/7
 * Time: 11:11 AM
 * Description: No Description
 */
public class FileChannelTest {

    public static void main( String[] args ) throws IOException {
        FileChannelTest fileChannelTest = new FileChannelTest();
//        fileChannelTest.fileCopyWithFileChannel
//                (new File("/Users/shoutenshi/Desktop/a.txt"), new File("/Users/shoutenshi/Desktop/c.txt"));

        InputStream in = new FileInputStream("/Users/shoutenshi/Desktop/7cde6e95-f4c3-418e-8a38-e6f67c3a3804.pdf");
        fileChannelTest.test("/Users/shoutenshi/Desktop/09e521bd-d807-429a-931e-172c6389f432/test.pdf", in);


    }


    public void test(String fileName, InputStream inputStream){
        FileOutputStream out = null;
        FileChannel channel = null;
        ByteBuffer buffer = null;
        try {

            out = new FileOutputStream(fileName);
            channel = out.getChannel();
            int size = inputStream.available();
            byte buf[] = new byte[size];
            inputStream.read(buf);
            buffer = ByteBuffer.wrap(buf);
            out.flush();
            channel.write(buffer);
            channel.force(true);
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
    public void fileCopyWithFileChannel(File fromFile, File toFile) {
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
}
