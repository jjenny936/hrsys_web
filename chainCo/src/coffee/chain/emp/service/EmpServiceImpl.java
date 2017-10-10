package coffee.chain.emp.service;

import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import coffee.chain.emp.dao.EmpDAO;
import coffee.chain.emp.vo.EmpVO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
	
	Logger logger = Logger.getLogger(EmpServiceImpl.class);
	
	@Autowired
	private EmpDAO empDAO;
	
	@Override
	public List<EmpVO> empList(String eDept){
		List<EmpVO> empList = null;
		empList = empDAO.empList(eDept);
		return empList;
	}
	
	@Override
	public EmpVO login(HashMap<String, Object> map){
		logger.info("login 호출성공 in service");
		EmpVO login = null;
		login = empDAO.login(map);
		return login;
	}
	
	@Override
	public int empDelete(String eNo){
		logger.info("empDelete 호출성공 in service");
		int i = 0;
		i=empDAO.empDelete(eNo);
		return i;		
	}
	
	@Override
	public int empUpdate(EmpVO ev){
		logger.info("empUpdate 호출성공 in service");
		int i = 0;
		i=empDAO.empUpdate(ev);
		return i;		
	}
	
	public EmpVO empMyPage(String eNo){
		logger.info("empMyPage 호출성공 in service");
		EmpVO ev = null;
		ev=empDAO.empMyPage(eNo);
		return ev;	
	}
	
	public EmpVO empEntry(){
		logger.info("empEntry 호출성공 in service");
		EmpVO ev = null;
		ev = empDAO.empEntry();
		return ev;
	}
}
