package com.mme.realMulti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mme.realMulti.dao.ImgDataDao;
import com.mme.realMulti.dto.ImgData;
import com.mme.realMulti.service.ImgDataService;

@Service
public class ImgDataServiceImpl implements ImgDataService{
	@Autowired
	ImgDataDao imgDataDao;
	
	@Override
	@Transactional
	public int updateMTInfoImg(ImgData imgdata) { //MT이미지 변경.
		int ret = imgDataDao.update(imgdata);
		return ret;
	}
	
	@Override
	@Transactional
	public ImgData getImgName(String imgid) { //MT이미지 이름 가져오기.
		return imgDataDao.getImgName(imgid);
		//ImgData tmp = new ImgData();
		//tmp = imgDataDao.getImgName(imgid);
		//return tmp.getImgName();
		//return imgname;
	}
	
	
	@Override
	@Transactional
	public List<ImgData> getImgDatas(){
		List<ImgData> list = imgDataDao.selectAll();
		return list;
	}
}
