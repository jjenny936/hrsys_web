package coffee.chain.branch.service;

import java.util.ArrayList;
import java.util.List;

import coffee.chain.branch.dao.*;
import coffee.chain.branch.vo.BranchVO;
import coffee.chain.emp.service.EmpServiceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {
	
	Logger logger = Logger.getLogger(EmpServiceImpl.class);
	
	@Autowired
	private BranchDAO branchDAO;
	
	public List<BranchVO> branchEntry(){
		logger.info("branchEntry ȣ�� ���� in service");
		List<BranchVO> branchEntry = null;
		branchEntry = branchDAO.branchEntry();
		return branchEntry;
	}
	
	public List<BranchVO> list(){
		logger.info("list ȣ�� ���� in service");
		List<BranchVO> list = null;
		list = branchDAO.list();
		return list;
	}
	
	public List<BranchVO> branchList(String bName){
		logger.info("branchList ȣ�� ���� in service");
		List<BranchVO> branchList = null;
		branchList = branchDAO.branchList(bName);
		return branchList;
	}
	
	public int update(BranchVO bv){
		logger.info("update ȣ�⼺�� in service");
		int i = 0;
		i=branchDAO.update(bv);
		return i;		
	}
	
	public int delete(String bName){
		logger.info("delete ȣ�⼺�� in service");
		int i = 0;
		i=branchDAO.delete(bName);
		return i;		
	}
	
	public int reopen(String bName){
		logger.info("reopen ȣ�⼺�� in service");
		int i = 0;
		i=branchDAO.reopen(bName);
		return i;		
	}
	
	public List<BranchVO> branchDelete(){
		logger.info("branchDelete ȣ�� ���� in service");
		List<BranchVO> branchDelete = null;
		branchDelete = branchDAO.branchDelete();
		return branchDelete;
	}

	public ArrayList sales(){
		logger.info("sales ȣ�� ���� in service");
		ArrayList sales = null;
		sales= branchDAO.sales();
		return sales;
	}
	
	public ArrayList lastYear(){
		logger.info("lastYear ȣ�� ���� in service");
		ArrayList lastYear = null;
		lastYear= branchDAO.lastYear();
		return lastYear;
	}
}
