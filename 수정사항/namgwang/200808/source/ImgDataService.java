package com.mme.realMulti.service;

import java.util.List;

import com.mme.realMulti.dto.ImgData;

public interface ImgDataService {
	public int updateMTInfoImg(ImgData imgdata);
	public ImgData getImgName(String imgid);	
	public List<ImgData> getImgDatas();
	
	//200808
	public ImgData addImgData(ImgData img);	
}
