package cn.edu.zhku.phonehub.store.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;

public class FileUtil {
	
	/**
	 * 对上传文件进行重命名
	 * @return String
	 * 返回重命名后的文件名
	 */
	public  static String  makeFileName() {
		long uuid = UUID.randomUUID().toString().hashCode();
		if (uuid < 0) {
			uuid = -uuid;
		}
		return uuid + ".jpg";
	}
	
	/**
	 * 保存文件
	 * @param item
	 * @param savePath
	 * @return String
	 * 返回保存文件的绝对路径
	 */
	public static String saveFile(FileItem item, String savePath) {
		
		// 获取上传文件的文件名，可能会带路径
		String uploadFileName = item.getName();
		// 除去路径的文件名
		String fileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
		// 重命名保存的文件名
		String saveFilename = makeFileName();
		
		String path = savePath + saveFilename;

		try {
			InputStream in = item.getInputStream();
			byte[] b = new byte[1024];
			int len = -1;
			FileOutputStream fos = new FileOutputStream(path);
			while ((len = in.read(b)) != -1) {
				fos.write(b, 0, len);
			}
			fos.close();
			in.close();
			return path;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	/**
	 * 提取相对路径
	 * @param savePath
	 * @return relativePath
	 */
	public static String getRelativePath(String savePath){
		
		//存放截取的相对路径
		String relativePath = "";
		
		int i = savePath.lastIndexOf("\\");
		//测试----打印最后一个\\索引值
		//System.out.println("最后一个索引值："+i);
		
		i = savePath.lastIndexOf("\\", i-1);
		//测试----打印倒数第二个\\索引值
		//System.out.println("倒数第二个索引值："+i);
		
		//已存放相对路径
		relativePath = savePath.substring(i);
		//测试---打印相对路径
		//System.out.println(relativePath);
		return relativePath;
	}

}
