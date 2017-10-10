package coffee.chain.emp.dao;

import java.util.HashMap;
import java.util.List;
import coffee.chain.emp.vo.EmpVO;

public interface EmpDAO {
	
	public List<EmpVO> empList(String eDept);
	public EmpVO login(HashMap<String, Object> map);
	public int empDelete(String eNo);
	public int empUpdate(EmpVO ev);
	public EmpVO empMyPage(String eNo);
	public EmpVO empEntry();
}
