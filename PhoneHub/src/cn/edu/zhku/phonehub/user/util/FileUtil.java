package cn.edu.zhku.phonehub.user.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUtil {

	/**
	 * 对上传文件进行重命名
	 * 
	 * @return String 返回重命名后的文件名,.jpg格式
	 */
	public static String makeFileName(int userId) {
		long uuid = UUID.randomUUID().toString().hashCode();
		if (uuid < 0) {
			uuid = -uuid;
		}
		return uuid + "user" + userId + ".jpg";
	}

	/**
	 * 保存文件
	 * 
	 * @param item
	 *            FileItem
	 * @param savePath
	 *            String
	 * @return String 返回保存文件的绝对路径
	 */
	public static String saveFile(FileItem item, String savePath, int userId) {

		// 获取上传文件的文件名，可能会带路径
		String uploadFileName = item.getName();

		// 除去路径的文件名
		if (uploadFileName == "") {
			System.out.println("2353333" + uploadFileName);
			return null;
		}

		String fileName = uploadFileName.substring(uploadFileName
				.lastIndexOf("\\") + 1);
		// 重命名保存的文件名
		String saveFilename = makeFileName(userId);

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
	 * 
	 * @param savePath
	 *            String 绝对路径
	 * @return relativePath String 相对路径
	 */
	public static String getRelativePath(String savePath) {

		// 存放截取的相对路径
		String relativePath = "";

		int i = savePath.lastIndexOf("\\");
		// 测试----打印最后一个\\索引值
		// System.out.println("最后一个索引值："+i);

		i = savePath.lastIndexOf("\\", i - 1);
		// 测试----打印倒数第二个\\索引值
		// System.out.println("倒数第二个索引值："+i);

		// 已存放相对路径
		relativePath = savePath.substring(i);
		// 测试---打印相对路径
		System.out.println("getRea   " + relativePath);
		return relativePath;
	}

	public static ServletFileUpload createUpload(File tempFile,
			int max_file_size) {
		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 缓冲区大小为100k
		factory.setSizeThreshold(1024 * 100);
		// 设置临时存放路径
		factory.setRepository(tempFile);

		ServletFileUpload upload = new ServletFileUpload(factory);

		upload.setHeaderEncoding("utf-8");

		// 设置上传单个文件的最大值为4M
		upload.setFileSizeMax(max_file_size);

		return upload;
	}
}
