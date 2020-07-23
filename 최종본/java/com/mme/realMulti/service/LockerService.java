package com.mme.realMulti.service;

import java.util.List;
import com.mme.realMulti.dto.Locker;

public interface LockerService {
	public List<Locker> getLockers();
	public Locker addLocker(Locker locker);
	public int deleteLocker(int lockerid);
}