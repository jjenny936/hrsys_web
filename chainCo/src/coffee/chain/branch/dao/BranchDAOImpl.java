package coffee.chain.branch.dao;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import coffee.chain.branch.vo.BranchVO;
import coffee.chain.emp.service.EmpServiceImpl;

@Repository
public class BranchDAOImpl implements BranchDAO {
	
	Logger logger = Logger.getLogger(EmpServiceImpl.class);
	
	@Autowired
	private SqlSession session;
	
	public List<BranchVO> branchEntry(){
		logger.info("branchEntry 호출 성공 in dao");
		List<BranchVO> branchEntry = null;
		branchEntry = session.selectList("branchEntry");
		return branchEntry;
	}
	
	public List<BranchVO> list(){
		logger.info("list 호출 성공 in dao");
		List<BranchVO> list = null;
		list = session.selectList("list");
		return list;
	}
	
	public List<BranchVO> branchList(String bName){
		logger.info("branchList 호출 성공 in dao");
		List<BranchVO> branchList = null;
		branchList = session.selectList("branchList");
		return branchList;
	}
	
	public int update(BranchVO bv){
		int i = 0;
		logger.info("update 호출성공 in dao");
		i= (int)session.update("update");
		return i;
	}
	
	public int delete(String bName){
		int i = 0;
		logger.info("delete 호출성공 in dao");
		i= (int)session.update("delete");
		return i;
	}
	
	public int reopen(String bName){
		int i = 0;
		logger.info("reopen 호출성공 in dao");
		i= (int)session.update("reopen");
		return i;
	}
	
	public List<BranchVO> branchDelete(){
		logger.info("branchDelete 호출 성공 in dao");
		List<BranchVO> branchDelete = null;
		branchDelete = session.selectList("branchDelete");
		return branchDelete;
	}
	
	public ArrayList sales(){
		ArrayList sales = null;
		sales = (ArrayList)session.selectList("sales");
		return sales;
	}
	
	public ArrayList lastYear(){
		ArrayList lastYear = null;
		lastYear = (ArrayList)session.selectList("lastYear");
		return lastYear;
	}
}
