package coffee.chain.branch.service;

import java.util.List;
import java.util.ArrayList;
import coffee.chain.branch.vo.BranchVO;

public interface BranchService {
	
	public List<BranchVO> branchEntry();
	public List<BranchVO> list();
	public List<BranchVO> branchList(String bName);
	public int update(BranchVO bv);
	public int delete(String bName);
	public List<BranchVO> branchDelete();
	public int reopen(String bName);
	public ArrayList sales();
	public ArrayList lastYear();
}
