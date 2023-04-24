package com.kiran.emploeeDao;

import java.util.List;

import com.kiran.model.Emploee;

public interface EmploeeDao {
	int saveEmploee(Emploee e);
	int deleteEmloee(Emploee id);
	int updateEmploee(Emploee e);
	Emploee readEmploee(int id);
	List<Emploee> readAllEmploee();
}
