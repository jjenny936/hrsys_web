package coffee.chain.workflow.dao;

import java.util.List;

import coffee.chain.emp.service.EmpServiceImpl;
import coffee.chain.emp.vo.EmpVO;
import coffee.chain.workflow.vo.WorkflowVO;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WorkflowDAOImpl implements WorkflowDAO {

	Logger logger = Logger.getLogger(WorkflowDAOImpl.class);
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int insertDocTemp(WorkflowVO wvo){
		return (int)session.insert("insertDocTemp");
	}
	
	@Override
	public int insertDoc(WorkflowVO wvo){
		return (int)session.insert("insertDoc");
	}

	@Override
	public List<WorkflowVO> viewTempList(WorkflowVO wvo){
		return session.selectList("viewTempList");
	}
	
	@Override
	public List<WorkflowVO> viewSubmitList(WorkflowVO wvo){
		return session.selectList("viewSubmitList");
	}
	
	@Override
	public List<WorkflowVO> viewReceptionBox(WorkflowVO wvo){
		return session.selectList("viewReceptionBox");
	}
	
	@Override
	public WorkflowVO viewDetail(WorkflowVO wvo){
		return (WorkflowVO)session.selectList("viewDetail");
	}

	@Override
	public int doDenyApproval(WorkflowVO wvo){
		// TODO Auto-generated method stub
		return session.update("doDenyApproval");
	}
	
	@Override
	public List<WorkflowVO> viewApprovalHistory(WorkflowVO wvo){
		return session.selectList("viewApprovalHistory");
	}
		
	@Override
	public List<WorkflowVO> viewSubmitOKList(WorkflowVO wvo){
		return session.selectList("viewSubmitOKList");
	}
	
	@Override
	public int insertDocResign(WorkflowVO wvo){
		return (int)session.insert("insertDocResign");
	}
}














