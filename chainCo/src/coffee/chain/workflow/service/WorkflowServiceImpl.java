package coffee.chain.workflow.service;

import java.util.List;

import org.apache.log4j.Logger;

import coffee.chain.emp.dao.EmpDAO;
import coffee.chain.emp.vo.EmpVO;
import coffee.chain.workflow.dao.WorkflowDAO;
import coffee.chain.workflow.vo.WorkflowVO;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class WorkflowServiceImpl implements WorkflowService {
	
	Logger logger = Logger.getLogger(WorkflowServiceImpl.class);
	
	@Autowired
	private WorkflowDAO workflowDAO;

	@Override
	public int insertDocTemp(WorkflowVO wvo){
		logger.info("서비스 submit!!!");
		int login = 0;
		login = workflowDAO.insertDocTemp(wvo);
		return login;
	}
	
	@Override
	public int insertDoc(WorkflowVO wvo){
		logger.info("서비스 submit!!!");
		int login = 0;
		login = workflowDAO.insertDoc(wvo);
		return login;
	}

	@Override
	public List<WorkflowVO> viewTempList(WorkflowVO wvo){
		List<WorkflowVO> myList = null;
		myList = workflowDAO.viewTempList(wvo);
		return myList;
	}
	
	@Override
	public List<WorkflowVO> viewSubmitList(WorkflowVO wvo){
		List<WorkflowVO> myList = null;
		myList = workflowDAO.viewSubmitList(wvo);
		return myList;
	}

	@Override
	public List<WorkflowVO> viewReceptionBox(WorkflowVO wvo){
		List<WorkflowVO> myList = null;
		myList = workflowDAO.viewReceptionBox(wvo);
		return myList;		
	}
	
	@Override
	public WorkflowVO viewDetail(WorkflowVO wvo){
		WorkflowVO myList = null;
		myList = workflowDAO.viewDetail(wvo);
		return myList;
	}
	
	@Override
	public int doDenyApproval(WorkflowVO wvo){
		int myList = 0;
		myList = workflowDAO.doDenyApproval(wvo);
		return myList;
	}
	
	@Override
	public List<WorkflowVO> viewApprovalHistory(WorkflowVO wvo){
		List<WorkflowVO> myList = null;
		myList = workflowDAO.viewApprovalHistory(wvo);
		return myList;
	}
	
	@Override
	public List<WorkflowVO> viewSubmitOKList(WorkflowVO wvo){
		List<WorkflowVO> myList = null;
		myList = workflowDAO.viewSubmitOKList(wvo);
		return myList;
	}
	
	@Override
	public int insertDocResign(WorkflowVO wvo){
		int login = 0;
		login = workflowDAO.insertDocResign(wvo);
		return login;
	}
}















