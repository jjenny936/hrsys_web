package coffee.chain.workflow.dao;

import java.util.List;

import coffee.chain.workflow.vo.WorkflowVO;

public interface WorkflowDAO {
	
	public int insertDocTemp(WorkflowVO wvo);
	public int insertDoc(WorkflowVO wvo);
	public List<WorkflowVO> viewTempList(WorkflowVO wvo);
	public List<WorkflowVO> viewSubmitList(WorkflowVO wvo);
	public List<WorkflowVO> viewReceptionBox(WorkflowVO wvo);
	public WorkflowVO viewDetail(WorkflowVO wvo);
	public int doDenyApproval(WorkflowVO wvo);
	public List<WorkflowVO> viewApprovalHistory(WorkflowVO wvo);
	public List<WorkflowVO> viewSubmitOKList(WorkflowVO wvo);
	public int insertDocResign(WorkflowVO wvo);
}
