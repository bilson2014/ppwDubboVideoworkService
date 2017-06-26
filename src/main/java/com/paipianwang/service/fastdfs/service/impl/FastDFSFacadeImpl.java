package com.paipianwang.service.fastdfs.service.impl;

import java.io.File;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.paipianwang.facade.fastdfs.service.FastDFSFacade;
import com.paipianwang.service.fastdfs.biz.FastDFSBiz;

@Service("fastDFSFacade")
public class FastDFSFacadeImpl implements FastDFSFacade{

	@Autowired
	final FastDFSBiz fastDFSBiz = null;
	
	@Override
	public String uploadFile(final File file, final String fileName) {
		return fastDFSBiz.uploadFile(file, fileName);
	}

	@Override
	public String uploadFile(final InputStream fis, final String fileName) {
		return fastDFSBiz.uploadFile(fis, fileName);
	}

	@Override
	public String uploadFile(final MultipartFile file) {
		return fastDFSBiz.uploadFile(file);
	}

	@Override
	public int deleteFile(final String groupName, final String fileName) {
		return fastDFSBiz.deleteFile(groupName, fileName);
	}

	@Override
	public int deleteFile(final String fileId) {
		return fastDFSBiz.deleteFile(fileId);
	}

	@Override
	public String modifyFile(final String oldFileId, final File file, final String filePath) {
		return fastDFSBiz.modifyFile(oldFileId, file, filePath);
	}

	@Override
	public InputStream downloadFile(final String fileId) {
		return fastDFSBiz.downloadFile(fileId);
	}

	@Override
	public String locateBestStorage() {
		return fastDFSBiz.locateBestStorage();
	}

}
