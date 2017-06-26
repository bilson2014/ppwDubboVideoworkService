package com.paipianwang.facade.fastdfs.service;

import java.io.File;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FastDFSFacade {
	/**
	 * 文件上传
	 * @param file
	 *            文件
	 * @param fileName
	 *            文件名
	 * @return 返回Null则为失败
	 */
	public String uploadFile(final File file, final String fileName);
	
	/**
	 * 文件上传
	 * @param fis
	 *            文件输入流
	 * @param fileName
	 *            文件名
	 * @return 返回Null则为失败
	 */
	public String uploadFile(final InputStream fis, final String fileName);
	
	/**
	 * 文件上传
	 * @param file
	 *            Spring代理文件
	 * @param fileName
	 *            文件名
	 * @return 返回Null则为失败
	 */
	public String uploadFile(final MultipartFile file);
	
	/**
	 * 删除文件
	 * 根据组名和远程文件名来删除一个文件
	 * 
	 * @param groupName
	 *            例如 "group1" 如果不指定该值，默认为group1
	 * @param fileName
	 *            例如"M00/00/00/wKgxgk5HbLvfP86RAAAAChd9X1Y736.jpg"
	 * @return 0为成功，非0为失败，具体为错误代码
	 */
	public int deleteFile(final String groupName, final String fileName);
	
	/**
	 * 删除文件
	 * 根据fileId来删除一个文件（我们现在用的就是这样的方式，上传文件时直接将fileId保存在了数据库中）
	 * 
	 * @param fileId
	 *            file_id源码中的解释file_id the file id(including group name and filename);例如 group1/M00/00/00/ooYBAFM6MpmAHM91AAAEgdpiRC0012.xml
	 * @return 0为成功，非0为失败，具体为错误代码
	 */
	public int deleteFile(final String fileId);
	
	/**
	 * 文件修改
	 * 修改一个已经存在的文件
	 * 
	 * @param oldFileId
	 *            原来旧文件的fileId, file_id源码中的解释file_id the file id(including group name and filename);例如 group1/M00/00/00/ooYBAFM6MpmAHM91AAAEgdpiRC0012.xml
	 * @param file
	 *            新文件
	 * @param filePath
	 *            新文件路径
	 * @return 返回空则为失败
	 */
	public String modifyFile(final String oldFileId, final File file, final String filePath);
	
	/**
	 * 文件下载
	 * 
	 * @param 
	 * 		fileId 源码中的解释file_id the file id(including group name and filename);例如 group1/M00/00/00/ooYBAFM6MpmAHM91AAAEgdpiRC0012.xml
	 * @return 
	 * 			inputStream 返回一个输入流
	 */
	public InputStream downloadFile(final String fileId);
	
	/**
	 * 获取当前最优的文件存储节点服务器
	 * @return 
	 * 		当前最优文件存储节点IP地址 (如果为null，说明没有找到存储节点，返回IP地址则成功)
	 */
	public String locateBestStorage();
	
}
