package coffee.chain.emp.dao;

import java.util.HashMap;
import java.util.List;
import coffee.chain.emp.service.EmpServiceImpl;
import coffee.chain.emp.vo.EmpVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAOImpl implements EmpDAO {

	Logger logger = Logger.getLogger(EmpServiceImpl.class);
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<EmpVO> empList(String eDept){
		return session.selectList("empList");
	}
	
	@Override
	public EmpVO login(HashMap<String, Object> map){
		logger.info("login 호출성공 in dao");
		return session.selectOne("login");
	}
	
	@Override
	public int empDelete(String eNo){
		int i =0;
		logger.info("empDelete 호출성공 in dao");
		i= (int)session.update("empDelete");
		return i;
	}
	
	@Override
	public int empUpdate(EmpVO ev){
		int i = 0;
		logger.info("empUpdate 호출성공 in dao");
		i= (int)session.update("empUpdate");
		return i;
	}
	
	public EmpVO empMyPage(String eNo){
		EmpVO ev = null;
		logger.info("empMyPage 호출성공 in dao");
		ev= (EmpVO)session.selectOne("empMyPage");
		return ev;
	}
	
	public EmpVO empEntry(){
		EmpVO ev = null;
		logger.info("empEntry 호출성공 in dao");
		ev= (EmpVO)session.selectOne("empEntry");
		return ev;
	}
}
