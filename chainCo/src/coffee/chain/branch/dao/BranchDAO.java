package coffee.chain.branch.dao;

import java.util.List;
import java.util.ArrayList;
import coffee.chain.branch.vo.BranchVO;

public interface BranchDAO {
	public List<BranchVO> branchEntry();
	public List<BranchVO> list();
	public List<BranchVO> branchList(String bName);
	public int update(BranchVO bv);
	public int delete(String bName);
	public int reopen(String bName);
	public List<BranchVO> branchDelete();
	public ArrayList sales();
	public ArrayList lastYear();
}
