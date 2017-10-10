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
	
	//���� ���������� ���ڰ��� Ŭ���� ���ڰ����� ó��ȭ������ �̵�
	@RequestMapping(value="/mainScreen")
	public String mainScreen(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{
		EmpVO login = (EmpVO)session.getAttribute("login");
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		logger.info("���ڰ��翡�� login.geteName()" + login.geteName());
		
		//WorkflowVO view1 = workflowService.login(wvo);

		return "workflow/main";}
	}
	
	
	//���ڰ������������� ����� Ŭ��
	@RequestMapping(value="/submitBox")
	public String submitBox(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{
		EmpVO login = (EmpVO)session.getAttribute("login");
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		logger.info("����� login.geteName()" + login.geteName());
		
		wvo.seteNo(login.geteNo());
		wvo.setwCode("�ӽ������");
		List<WorkflowVO> viewTempList = workflowService.viewTempList(wvo);
		model.addAttribute("viewTempList", viewTempList);
		
		wvo.setwFirstState("�̰���");
		wvo.setwCode("���");
		List<WorkflowVO> viewSubmitList = workflowService.viewSubmitList(wvo);
		model.addAttribute("viewSubmitList", viewSubmitList);

		return "workflow/submitBox";}
	}


	
	//����Կ��� ���Ͼ������� ���� �ۼ��ϱ� ��ư ����
	@RequestMapping(value="/insertJobreportForm")
	public String insertJobreportForm(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{		
		return "workflow/insertJobreportForm";
	}
	

	//���� �ۼ��ϰ� �ӽ����� ��ư Ŭ��
	@RequestMapping(value="/saveDoc", method=RequestMethod.POST)
	public String saveDoc(@ModelAttribute WorkflowVO wvo, Model model
			,HttpSession session, HttpServletRequest request)					
	{		
		logger.info("�ӽ�����");
		EmpVO login = (EmpVO)session.getAttribute("login");
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		
		//���߿� ���ǹ����� �б� ��Ŵ
		wvo.setwCode("�ӽ������");
		wvo.setwFormat("���Ͼ�������");
		wvo.seteNo(login.geteNo());
		
		

		int result = 0; 

		
		result = workflowService.insertDocTemp(wvo);
		
		if (result != 0) {
			logger.info("result�� : " + result);
		}
		//���⼭���� jsp�� ���ϴ� �κ�
		

		wvo.seteNo(login.geteNo());
		wvo.setwCode("�ӽ������");
		List<WorkflowVO> viewTempList = workflowService.viewTempList(wvo);
		model.addAttribute("viewTempList", viewTempList);
		
		wvo.setwFirstState("�̰���");
		wvo.setwCode("���");
		List<WorkflowVO> viewSubmitList = workflowService.viewSubmitList(wvo);
		model.addAttribute("viewSubmitList", viewSubmitList);
		
		return "workflow/submitBox";}
	}
	

	//���� �ۼ��ϰ� ������ ��ư Ŭ��
	@RequestMapping(value="/submitDoc")
	public String submitDoc(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{	
		EmpVO login = (EmpVO)session.getAttribute("login");
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		
		
		wvo.setwFirstState("�̰���");
		wvo.setwFirstOKState("�̰���");
		wvo.setwFinalState("�̰���");
		wvo.setwFinalOKState("�̰���");
		wvo.setwCode("���");
		wvo.seteNo(login.geteNo());
		
		
		//���߿� ���ǹ����� �б� ��Ŵ
		wvo.setwFormat("���Ͼ�������");
		
		
		

		int result = 0; 

		
		result = workflowService.insertDoc(wvo);
		
		if (result != 0) {
			logger.info("result�� : " + result);
		}
		//���⼭���� jsp�� ���ϴ� �κ�
		wvo.seteNo(login.geteNo());
		wvo.setwCode("�ӽ������");
		List<WorkflowVO> viewTempList = workflowService.viewTempList(wvo);
		model.addAttribute("viewTempList", viewTempList);
		
		wvo.setwFirstState("�̰���");
		wvo.setwCode("���");
		List<WorkflowVO> viewSubmitList = workflowService.viewSubmitList(wvo);
		model.addAttribute("viewSubmitList", viewSubmitList);
				
		return "workflow/submitBox";}
	}
	
	

	//����Կ��� �ް���û�� ���� �ۼ��ϱ� ��ư ����
	@RequestMapping(value="/insertVacationForm")
	public String insertVacationForm(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{		
		return "workflow/insertVacationForm";
	}
	
	//����Կ��� ������ ���� �ۼ��ϱ� ��ư ����
	@RequestMapping(value="/insertResignForm")
	public String insertResignForm(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{		
		return "workflow/insertResignForm";
	}


	//���ڰ������������� ������ Ŭ��
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
		wvo.setePos("���");
		
		
		//wvo.setePos("����"); // ������ ���
		
		//��� ->�������� �̸� �ھƳ��� ����
		List<WorkflowVO> viewReceptionBox = workflowService.viewReceptionBox(wvo);
		model.addAttribute("viewReceptionBox", viewReceptionBox);
		
		
		return "workflow/receptionBox";}
	}
	
	
	//�����Կ��� ���� �ڼ��� ���� jsp�� �̵�
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
		logger.info("jsp�� hidden���� ������ȣ �޾ƿ��� : " + wvo.getwNo());
		
		logger.info("wvo�� eNo �־��  : " + wvo.geteNo());
		WorkflowVO viewDetail = workflowService.viewDetail(wvo);
		model.addAttribute("viewDetail", viewDetail);

		
		return "workflow/jobReportDetail";}
	}

	//������ ���� �ڼ������⸦ �� ���� ���� ��ư Ȥ�� �ݷ� ��ư Ŭ����
	@RequestMapping(value="/doDenyApproval", method=RequestMethod.POST)
	public String doDenyApproval(@ModelAttribute WorkflowVO wvo, Model model
							,HttpSession session)
	{
		
		EmpVO login = (EmpVO)session.getAttribute("login");
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		wvo.seteNo(login.geteNo());
		
		logger.info("�ݷ���ư Ŭ���� wvo.getwNo() : " + wvo.getwNo());		
		
		String reason = wvo.getwDenyReason();
		
		if (reason.equals("")) { // ������ ���
			wvo.setwFirstokEno(login.geteNo());
			wvo.setwSecondokEno(login.geteNo());
			wvo.setwFirstState("����");
			wvo.setwFirstOKState("����");
			wvo.setwFinalState("����");
			wvo.setwFinalOKState("����");
		}else { // �ݷ��� ���
			wvo.setwFirstokEno(login.geteNo());
			wvo.setwSecondokEno(login.geteNo());
			wvo.setwFirstState("����");
			wvo.setwFirstOKState("�ݷ�");
			wvo.setwFinalState("����");
			wvo.setwFinalOKState("�ݷ�");			
		}

		workflowService.doDenyApproval(wvo);

		
		//���⼭���� view�� �������� ������ ���� list�� view ������ '�̰���'
		wvo.seteNo(login.geteNo());
		wvo.seteDept(login.geteDept());
		wvo.setePos("���");
		

		List<WorkflowVO> viewReceptionBox = workflowService.viewReceptionBox(wvo);
		model.addAttribute("viewReceptionBox", viewReceptionBox);	
		
		return "workflow/receptionBox";}
	}
	
	
	//���ڰ������������� ������ Ŭ��
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
        
        wvo.setwFinalOKState("�ݷ�");
		List<WorkflowVO> denyHistory = workflowService.viewApprovalHistory(wvo);
		model.addAttribute("denyHistory", denyHistory);
		
		//logger.info("asdad : " + denyHistory.get(0).getwTitle());
		
		wvo.setwFinalOKState("����");
		List<WorkflowVO> approvalHistory = workflowService.viewApprovalHistory(wvo);
		model.addAttribute("approvalHistory", approvalHistory);
		
		return "workflow/approvalHistory";}
	}

	
	

	//���ڰ������������� ������ Ŭ��
	@RequestMapping(value="/approvalBox")
	public String viewApprovalBox(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{
		
		EmpVO login = (EmpVO)session.getAttribute("login");	
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		wvo.seteNo(login.geteNo());
		
        wvo.setwFinalOKState("����");
		List<WorkflowVO> viewApprovalBox = workflowService.viewSubmitOKList(wvo);
		model.addAttribute("viewApprovalBox", viewApprovalBox);
		
		//logger.info("asdad : " + viewApprovalBox.get(0).getwTitle());

		return "workflow/approvalBox";	}
	}
	
	//���ڰ������������� �ݷ��� Ŭ��
	@RequestMapping(value="/denyBox")
	public String viewDenyBox(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{
		
		EmpVO login = (EmpVO)session.getAttribute("login");	
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		wvo.seteNo(login.geteNo());
		
        wvo.setwFinalOKState("�ݷ�");
		List<WorkflowVO> viewDenyBox = workflowService.viewSubmitOKList(wvo);
		model.addAttribute("viewDenyBox", viewDenyBox);
		
		//logger.info("asdad : " + viewDenyBox.get(0).getwTitle());

		return "workflow/denyBox";}
	}
	
	//���� �ۼ��ϰ� ������ ��ư Ŭ�� -- ������
	@RequestMapping(value="/submitDocResign")
	public String submitDocResign(@ModelAttribute WorkflowVO wvo, Model model
						,HttpSession session)
	{	
		EmpVO login = (EmpVO)session.getAttribute("login");
		
		if(login == null){
			return "workflow/sessionEnd";
		}else{
		
		wvo.setwFirstState("�̰���");
		wvo.setwFirstOKState("�̰���");
		wvo.setwFinalState("�̰���");
		wvo.setwFinalOKState("�̰���");
		wvo.setwCode("���");
		wvo.seteNo(login.geteNo());
		
		
		//���߿� ���ǹ����� �б� ��Ŵ
		wvo.setwFormat("������");
		wvo.setwTitle("�������Դϴ�");
		
		

		int result = 0; 

		
		result = workflowService.insertDocResign(wvo);
		
		if (result != 0) {
			logger.info("result�� : " + result);
		}
		
		//���⼭���� jsp�� ���ϴ� �κ�
		wvo.seteNo(login.geteNo());
		wvo.setwCode("�ӽ������");
		List<WorkflowVO> viewTempList = workflowService.viewTempList(wvo);
		model.addAttribute("viewTempList", viewTempList);
		
		wvo.setwFirstState("�̰���");
		wvo.setwCode("���");
		List<WorkflowVO> viewSubmitList = workflowService.viewSubmitList(wvo);
		model.addAttribute("viewSubmitList", viewSubmitList);

				
		return "/workflow/submitBox";}
	}
} // end of class













