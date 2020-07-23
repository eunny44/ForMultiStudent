package com.mme.realMulti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mme.realMulti.dao.StudentDao;
import com.mme.realMulti.dto.Student;
import com.mme.realMulti.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentDao studentDao;

	//transactional을 붙이면 read only. 아니면 false를 붙여준다.
	@Override
	@Transactional
	public List<Student> getStudents() { //모든 학생 정보 가져오기.
		List<Student> list = studentDao.selectAll();
		return list;
	}
}