package coffee.chain.emp.service;

import java.util.HashMap;
import java.util.List;
import coffee.chain.emp.vo.EmpVO;

public interface EmpService {
	
	public List<EmpVO> empList(String eDept);
	public EmpVO login(HashMap<String, Object> map);
	public int empUpdate(EmpVO ev);
	public int empDelete(String eNo);
	public EmpVO empMyPage(String eNo);
	public EmpVO empEntry();
}
