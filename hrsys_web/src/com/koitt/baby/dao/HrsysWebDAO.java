package com.koitt.baby.dao;

import com.koitt.baby.vo.HrsysMemberVO;
import com.koitt.baby.vo.HrsysReserveVO;
import java.util.ArrayList;

public interface HrsysWebDAO {
	
	public int memberInsertWork(HrsysMemberVO mv);
	public int idCheckWork();
	public ArrayList loginWork(HrsysMemberVO mv);
	public int memberUpdateWork(HrsysMemberVO mv);
	public ArrayList memberSelectWork(HrsysMemberVO mv);
	public int memberDeleteWork(HrsysMemberVO mv);
	public int reserveWork(HrsysReserveVO rv);
	public ArrayList reserveSelectWork(HrsysReserveVO rv);
	public ArrayList reserveChangeWork(HrsysReserveVO rv);
	public int reserveUpdate(HrsysReserveVO rv);
	public int reserveDelete(HrsysReserveVO rv);
}