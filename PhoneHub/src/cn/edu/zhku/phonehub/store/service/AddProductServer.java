package cn.edu.zhku.phonehub.store.service;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.edu.zhku.phonehub.store.dao.ProductDao;
import cn.edu.zhku.phonehub.store.util.FileUtil;

public class AddProductServer {
	
	public boolean addProduct(HttpServletRequest request){
		
		boolean resualt = false;
		
		// 商品图片的临时存放路径
		String tempPath = request.getSession().getServletContext().getRealPath("\\")+"Image\\temp\\";
		
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			tmpFile.mkdirs();
		}
		
		try{
			// 获得磁盘文件条目工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 缓冲区大小为100k
			factory.setSizeThreshold(1024 * 100);
			// 设置临时存放路径
			factory.setRepository(tmpFile);
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			upload.setHeaderEncoding("utf-8");
			
			// 设置上传单个文件的最大值为4M
			upload.setFileSizeMax(4096 * 1024);
			
			//存储普通表单字段名及字段值
			Map<String,String> map = new HashMap<String,String>();
			//文件存储的绝对路径
			String savePath = "";
			//文件存储的相对路径
			String relativePath = "";
			
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iteratorItem = items.iterator();
			
			while(iteratorItem.hasNext()){
				FileItem item = (FileItem) iteratorItem.next();
				if(item.isFormField()){
					map.put((String)item.getFieldName(), (String)item.getString());
				}
				else{
					savePath = request.getSession().getServletContext().getRealPath("\\")+"Image\\Product\\";
					//测试----打印路径
					//System.out.println(savePath);
					
					relativePath = FileUtil.saveFile(item,savePath);
					
					//提取相对路径
					relativePath = FileUtil.getRelativePath(relativePath);
					
					if(map.containsKey(item.getFieldName())){
						relativePath = map.get(item.getFieldName())+","+relativePath;
						map.put(item.getFieldName(),relativePath);
					}
					else{
						map.put(item.getFieldName(), relativePath);
					}
					
				}
			}
			
			map.put("storeId",(String)request.getSession().getAttribute("storeId"));
			//测试-----打印map
			Iterator iter = map.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				System.out.println((String)entry.getKey()+":"+entry.getValue());
			}
			ProductDao pd = new ProductDao();
			if(pd.insertProduct(map)){
				resualt=true;
				return resualt;
			}
		}catch(Exception e){
			e.printStackTrace();
			return resualt;
		}
		return resualt;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
