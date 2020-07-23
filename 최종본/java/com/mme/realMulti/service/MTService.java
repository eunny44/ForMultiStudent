package com.mme.realMulti.service;

import java.util.List;

import com.mme.realMulti.dto.MT;

public interface MTService {
	public MT addMT(MT mt);
	public List<MT> getMTs();
	public int deleteMT(String phoneNumber);
}