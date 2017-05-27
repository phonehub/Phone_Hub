package cn.edu.zhku.phonehub.store.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import cn.edu.zhku.phonehub.store.dao.StoreDao;
import cn.edu.zhku.phonehub.store.util.FileUtil;

public class CreateStoreSever {
	
	
	public boolean createStore(HttpServletRequest request){
		// 文件临时存放路径
		String tempPath = request.getSession().getServletContext().getRealPath("\\")+"Image\\temp\\";
		//测试---打印temp绝对路径
		//System.out.println(tempPath);
		
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			tmpFile.mkdirs();
		}
		
		try{
			ServletFileUpload upload = FileUtil.createUpload(tmpFile, 4096 * 1024);
			
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
					savePath = request.getSession().getServletContext().getRealPath("\\")+"Image\\"+item.getFieldName()+"\\";
					//测试----打印路径
					//System.out.println(savePath);
					
					relativePath = FileUtil.saveFile(item, savePath);
					//测试----打印绝对路径
					//System.out.println("绝对路径:"+relativePath);
					
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
			
			map.put("userId",(String)request.getSession().getAttribute("userId"));
			//测试-----打印map
			Iterator iter = map.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				System.out.println((String)entry.getKey()+":"+entry.getValue());
			}
			
			StoreDao storeDao = new StoreDao();
			if(storeDao.insertStore(map))
				return true;
			else
				return false;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		CreateStoreSever cs = new CreateStoreSever();
//		cs.createStore(request);
//
//	}

}
