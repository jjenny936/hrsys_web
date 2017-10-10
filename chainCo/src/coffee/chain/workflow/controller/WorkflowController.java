package coffee.chain.workflow.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import coffee.chain.workflow.service.WorkflowService;
import coffee.chain.workflow.vo.WorkflowVO;
import coffee.chain.emp.vo.EmpVO;



@Controller
@RequestMapping(value="/workflow")
public class WorkflowController {

	@Autowired
	private WorkflowService workflowService;

	Logger logger = Logger.getLogger(WorkflowController.class);
	
	//메인 페이지에서 전자결재 클릭시 전자결재의 처음화면으로 이동
	@RequestMapping(value="/mainScreen")
	public String mainScreen(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{
		EmpVO login = (EmpVO)session.getAttribute("login");
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		logger.info("전자결재에서 login.geteName()" + login.geteName());
		
		//WorkflowVO view1 = workflowService.login(wvo);

		return "workflow/main";}
	}
	
	
	//전자결재페이지에서 상신함 클릭
	@RequestMapping(value="/submitBox")
	public String submitBox(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{
		EmpVO login = (EmpVO)session.getAttribute("login");
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		logger.info("상신함 login.geteName()" + login.geteName());
		
		wvo.seteNo(login.geteNo());
		wvo.setwCode("임시저장됨");
		List<WorkflowVO> viewTempList = workflowService.viewTempList(wvo);
		model.addAttribute("viewTempList", viewTempList);
		
		wvo.setwFirstState("미결재");
		wvo.setwCode("대기");
		List<WorkflowVO> viewSubmitList = workflowService.viewSubmitList(wvo);
		model.addAttribute("viewSubmitList", viewSubmitList);

		return "workflow/submitBox";}
	}


	
	//상신함에서 일일업무보고 문서 작성하기 버튼 누름
	@RequestMapping(value="/insertJobreportForm")
	public String insertJobreportForm(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{		
		return "workflow/insertJobreportForm";
	}
	

	//문서 작성하고 임시저장 버튼 클릭
	@RequestMapping(value="/saveDoc", method=RequestMethod.POST)
	public String saveDoc(@ModelAttribute WorkflowVO wvo, Model model
			,HttpSession session, HttpServletRequest request)					
	{		
		logger.info("임시저장");
		EmpVO login = (EmpVO)session.getAttribute("login");
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		
		//나중에 조건문으로 분기 시킴
		wvo.setwCode("임시저장됨");
		wvo.setwFormat("일일업무보고");
		wvo.seteNo(login.geteNo());
		
		

		int result = 0; 

		
		result = workflowService.insertDocTemp(wvo);
		
		if (result != 0) {
			logger.info("result값 : " + result);
		}
		//여기서부터 jsp로 뷰하는 부분
		

		wvo.seteNo(login.geteNo());
		wvo.setwCode("임시저장됨");
		List<WorkflowVO> viewTempList = workflowService.viewTempList(wvo);
		model.addAttribute("viewTempList", viewTempList);
		
		wvo.setwFirstState("미결재");
		wvo.setwCode("대기");
		List<WorkflowVO> viewSubmitList = workflowService.viewSubmitList(wvo);
		model.addAttribute("viewSubmitList", viewSubmitList);
		
		return "workflow/submitBox";}
	}
	

	//문서 작성하고 보내기 버튼 클릭
	@RequestMapping(value="/submitDoc")
	public String submitDoc(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{	
		EmpVO login = (EmpVO)session.getAttribute("login");
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		
		
		wvo.setwFirstState("미결재");
		wvo.setwFirstOKState("미결재");
		wvo.setwFinalState("미결재");
		wvo.setwFinalOKState("미결재");
		wvo.setwCode("대기");
		wvo.seteNo(login.geteNo());
		
		
		//나중에 조건문으로 분기 시킴
		wvo.setwFormat("일일업무보고");
		
		
		

		int result = 0; 

		
		result = workflowService.insertDoc(wvo);
		
		if (result != 0) {
			logger.info("result값 : " + result);
		}
		//여기서부터 jsp로 뷰하는 부분
		wvo.seteNo(login.geteNo());
		wvo.setwCode("임시저장됨");
		List<WorkflowVO> viewTempList = workflowService.viewTempList(wvo);
		model.addAttribute("viewTempList", viewTempList);
		
		wvo.setwFirstState("미결재");
		wvo.setwCode("대기");
		List<WorkflowVO> viewSubmitList = workflowService.viewSubmitList(wvo);
		model.addAttribute("viewSubmitList", viewSubmitList);
				
		return "workflow/submitBox";}
	}
	
	

	//상신함에서 휴가신청서 문서 작성하기 버튼 누름
	@RequestMapping(value="/insertVacationForm")
	public String insertVacationForm(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{		
		return "workflow/insertVacationForm";
	}
	
	//상신함에서 사직서 문서 작성하기 버튼 누름
	@RequestMapping(value="/insertResignForm")
	public String insertResignForm(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{		
		return "workflow/insertResignForm";
	}


	//전자결재페이지에서 수신함 클릭
	@RequestMapping(value="/receptionBox")
	public String receptionBox(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{
		
		EmpVO login = (EmpVO)session.getAttribute("login");
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		wvo.seteNo(login.geteNo());
		wvo.seteDept(login.geteDept());
		wvo.setePos("사원");
		
		
		//wvo.setePos("부장"); // 사장인 경우
		
		//사원 ->부장으로 미리 박아놓은 상태
		List<WorkflowVO> viewReceptionBox = workflowService.viewReceptionBox(wvo);
		model.addAttribute("viewReceptionBox", viewReceptionBox);
		
		
		return "workflow/receptionBox";}
	}
	
	
	//수신함에서 문서 자세히 보기 jsp로 이동
	@RequestMapping(value="/viewDetail", method=RequestMethod.POST)
	public String viewDetail(@ModelAttribute WorkflowVO wvo, Model model
							,HttpSession session)
	{
		
		EmpVO login = (EmpVO)session.getAttribute("login");
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		wvo.seteNo(login.geteNo());
		
		wvo.getwNo();		
		logger.info("jsp의 hidden에서 문서번호 받아오기 : " + wvo.getwNo());
		
		logger.info("wvo에 eNo 넣어보기  : " + wvo.geteNo());
		WorkflowVO viewDetail = workflowService.viewDetail(wvo);
		model.addAttribute("viewDetail", viewDetail);

		
		return "workflow/jobReportDetail";}
	}

	//결재할 문서 자세히보기를 한 다음 승인 버튼 혹은 반려 버튼 클릭함
	@RequestMapping(value="/doDenyApproval", method=RequestMethod.POST)
	public String doDenyApproval(@ModelAttribute WorkflowVO wvo, Model model
							,HttpSession session)
	{
		
		EmpVO login = (EmpVO)session.getAttribute("login");
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		wvo.seteNo(login.geteNo());
		
		logger.info("반려버튼 클릭시 wvo.getwNo() : " + wvo.getwNo());		
		
		String reason = wvo.getwDenyReason();
		
		if (reason.equals("")) { // 승인인 경우
			wvo.setwFirstokEno(login.geteNo());
			wvo.setwSecondokEno(login.geteNo());
			wvo.setwFirstState("결재");
			wvo.setwFirstOKState("승인");
			wvo.setwFinalState("결재");
			wvo.setwFinalOKState("승인");
		}else { // 반려인 경우
			wvo.setwFirstokEno(login.geteNo());
			wvo.setwSecondokEno(login.geteNo());
			wvo.setwFirstState("결재");
			wvo.setwFirstOKState("반려");
			wvo.setwFinalState("결재");
			wvo.setwFinalOKState("반려");			
		}

		workflowService.doDenyApproval(wvo);

		
		//여기서부터 view함 수신함의 결재할 문서 list를 view 조건은 '미결재'
		wvo.seteNo(login.geteNo());
		wvo.seteDept(login.geteDept());
		wvo.setePos("사원");
		

		List<WorkflowVO> viewReceptionBox = workflowService.viewReceptionBox(wvo);
		model.addAttribute("viewReceptionBox", viewReceptionBox);	
		
		return "workflow/receptionBox";}
	}
	
	
	//전자결재페이지에서 수신함 클릭
	@RequestMapping(value="/approvalHistory")
	public String viewApprovalHistory(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{
		
		EmpVO login = (EmpVO)session.getAttribute("login");
		if(login == null){
			return "workflow/sessionEnd";
		}else{
        wvo.setwSecondokEno(login.geteNo());
        
        logger.info("asdasdsasd");
        
        wvo.setwFinalOKState("반려");
		List<WorkflowVO> denyHistory = workflowService.viewApprovalHistory(wvo);
		model.addAttribute("denyHistory", denyHistory);
		
		//logger.info("asdad : " + denyHistory.get(0).getwTitle());
		
		wvo.setwFinalOKState("승인");
		List<WorkflowVO> approvalHistory = workflowService.viewApprovalHistory(wvo);
		model.addAttribute("approvalHistory", approvalHistory);
		
		return "workflow/approvalHistory";}
	}

	
	

	//전자결재페이지에서 승인함 클릭
	@RequestMapping(value="/approvalBox")
	public String viewApprovalBox(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{
		
		EmpVO login = (EmpVO)session.getAttribute("login");	
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		wvo.seteNo(login.geteNo());
		
        wvo.setwFinalOKState("승인");
		List<WorkflowVO> viewApprovalBox = workflowService.viewSubmitOKList(wvo);
		model.addAttribute("viewApprovalBox", viewApprovalBox);
		
		//logger.info("asdad : " + viewApprovalBox.get(0).getwTitle());

		return "workflow/approvalBox";	}
	}
	
	//전자결재페이지에서 반려함 클릭
	@RequestMapping(value="/denyBox")
	public String viewDenyBox(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{
		
		EmpVO login = (EmpVO)session.getAttribute("login");	
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		wvo.seteNo(login.geteNo());
		
        wvo.setwFinalOKState("반려");
		List<WorkflowVO> viewDenyBox = workflowService.viewSubmitOKList(wvo);
		model.addAttribute("viewDenyBox", viewDenyBox);
		
		//logger.info("asdad : " + viewDenyBox.get(0).getwTitle());

		return "workflow/denyBox";}
	}
	
	//문서 작성하고 보내기 버튼 클릭 -- 사직서
	@RequestMapping(value="/submitDocResign")
	public String submitDocResign(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{	
		EmpVO login = (EmpVO)session.getAttribute("login");
		
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		
		wvo.setwFirstState("미결재");
		wvo.setwFirstOKState("미결재");
		wvo.setwFinalState("미결재");
		wvo.setwFinalOKState("미결재");
		wvo.setwCode("대기");
		wvo.seteNo(login.geteNo());
		
		
		//나중에 조건문으로 분기 시킴
		wvo.setwFormat("사직서");
		wvo.setwTitle("사직서입니다");
		
		

		int result = 0; 

		
		result = workflowService.insertDocResign(wvo);
		
		if (result != 0) {
			logger.info("result값 : " + result);
		}
		
		//여기서부터 jsp로 뷰하는 부분
		wvo.seteNo(login.geteNo());
		wvo.setwCode("임시저장됨");
		List<WorkflowVO> viewTempList = workflowService.viewTempList(wvo);
		model.addAttribute("viewTempList", viewTempList);
		
		wvo.setwFirstState("미결재");
		wvo.setwCode("대기");
		List<WorkflowVO> viewSubmitList = workflowService.viewSubmitList(wvo);
		model.addAttribute("viewSubmitList", viewSubmitList);

				
		return "/workflow/submitBox";}
	}
} // end of class













