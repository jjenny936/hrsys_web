package coffee.chain.emp.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

import coffee.chain.emp.service.EmpService;
import coffee.chain.emp.vo.EmpVO;

@Controller
@RequestMapping(value="/emp")
public class EmpController {
	Logger logger = Logger.getLogger(EmpController.class);
	
	@Autowired
	private EmpService empService;
	
	//������
	@RequestMapping(value="/empList", method=RequestMethod.POST)
	public String empList(@RequestParam("eDept") String eDept, Model model){

		logger.info("empList ȣ�� ����");
		
		List<EmpVO> empList = empService.empList(eDept);
		model.addAttribute("empList", empList);
		return "emp/empList";
		
	}
	
	//�α���
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Param("eId") String eId, @Param("ePw") String ePw, Model model
						,HttpServletRequest request, HttpSession session){
		String str="";
		logger.info("login ȣ�� ���� in controller");
		logger.info("eId >> " + eId);
		logger.info("ePw >> " + ePw);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("eId", eId);
		map.put("ePw", ePw);
		
		EmpVO login = empService.login(map);
		session.setAttribute("login", login);
		model.addAttribute("login", login);
		
		str="emp/login";
		
		return str;
	}
	
	//���ó��
	@RequestMapping(value="/empDelete", method=RequestMethod.POST)
	public String empDelete(@Param("eNo") String eNo, @Param("eDept") String eDept, Model model){
		
		String str="";
		logger.info("empDelete ȣ�� ���� in controller");
		logger.info("eNo for delete>> " + eNo);
		logger.info("eDept for delete>> " + eDept);
		
		int i = empService.empDelete(eNo);
		
		if(i>0){//������ �Ͼ����,
			str="���� �Ϸ�!";
		}else{//������ �Ͼ�� �ʾ�����,
			str="������ ������ �־� �Ϸ����� ���߽��ϴ�.";
		}
		
		model.addAttribute("result", str);
		model.addAttribute("dept", eDept);
		
		return "emp/result";
	}
	
	//�� ���� ����
	@RequestMapping(value="/empUpdate", method=RequestMethod.POST)
	public String empUpdate(@Param("eNo") String eNo,
							@Param("ePw") String ePw,
							@Param("eName") String eName,
							@Param("eAddr") String eAddr,
							@Param("ePos") String ePos,
							@Param("eDept") String eDept,
							@Param("ePhone") String ePhone,
							@Param("eEmail") String eEmail,
							@Param("eId") String eId, 
							@Param("ePhoto") String ePhoto,
							@Param("eSignature") String eSignature,
							HttpServletRequest request,
						    Model model) throws IllegalStateException, IOException{

		String str="";
		String path="../img/";
		EmpVO ev = null;
		ev = new EmpVO();
		
		ev.seteNo(eNo);
		ev.setePw(ePw);
		ev.seteName(eName);
		ev.seteAddr(eAddr);
		ev.setePos(ePos);
		ev.setePhone(ePhone);
		ev.seteEmail(eEmail);
		ev.seteId(eId);
		ev.seteDept(eDept);
		logger.info("empUpdate ȣ�� ���� in controller");
		
		HttpSession session = request.getSession();
		String sessionEphoto = (String)session.getAttribute("sessionEphoto");
		String sessionEsignature = (String)session.getAttribute("sessionEsignature");
		
		logger.info("ePhoto >> " + ePhoto);
		logger.info("eSignature >> " + eSignature);
		logger.info("sessionEphoto >> " + sessionEphoto);
		logger.info("sessionEsignature >> " +sessionEsignature);
		
		if(sessionEphoto.equals(ePhoto)){//�������� ����
			ev.setePhoto(sessionEphoto);
		}else{//���ο� ���� ��Ϲ޾�����
			ev.setePhoto(path+ePhoto);
		}
		
		if(sessionEsignature.equals(ePhoto)){//���κ��� ����
			ev.seteSignature(sessionEsignature);
		}else{//���ο� ������ ��ϵǾ����� 
			ev.seteSignature(path+eSignature);
		}
	
		int i = empService.empUpdate(ev);
		
		if(i>0){//������ �Ͼ����,
			str="���� �Ϸ�!";
		}else{//������ �Ͼ�� �ʾ�����,
			str="������ ������ �־� �Ϸ����� ���߽��ϴ�.";
		}
		
		model.addAttribute("result", str);
		
		return "emp/updateResult";
	}
	
	//�����ڰ� �������� ������� ����
	@RequestMapping(value="/empUpdate_1", method=RequestMethod.POST)
	public String empUpdate_1(@Param("eNo") String eNo,
							@Param("ePw") String ePw,
							@Param("eName") String eName,
							@Param("eAddr") String eAddr,
							@Param("ePos") String ePos,
							@Param("eDept") String eDept,
							@Param("ePhone") String ePhone,
							@Param("eEmail") String eEmail,
							@Param("eId") String eId, 
							@Param("ePhoto") String ePhoto,
							@Param("eSignature") String eSignature,
						    Model model){
		String str="";
		EmpVO ev = null;
		ev = new EmpVO();
		
		ev.seteNo(eNo);
		ev.setePw(ePw);
		ev.seteName(eName);
		ev.seteAddr(eAddr);
		ev.setePos(ePos);
		ev.setePhone(ePhone);
		ev.seteEmail(eEmail);
		ev.seteId(eId);
		ev.seteDept(eDept);
		ev.setePhoto(ePhoto);
		ev.seteSignature(eSignature);
		logger.info("empUpdate_1 ȣ�� ���� in controller");
		
		int i = empService.empUpdate(ev);
		
		if(i>0){//������ �Ͼ����,
			str="���� �Ϸ�!";
		}else{//������ �Ͼ�� �ʾ�����,
			str="������ ������ �־� �Ϸ����� ���߽��ϴ�.";
		}
		
		model.addAttribute("result", str);
		
		return "emp/updateResult";
	}
	
	//�� ���� ����
	@RequestMapping(value="/empMyPage", method=RequestMethod.POST)
	public String empMyPage(@Param("eNo") String eNo, Model model, HttpServletRequest request){

		String str="";
		logger.info("empMyPage ȣ�� ���� in controller");
		logger.info("eNo >> " + eNo);
		EmpVO ev = empService.empMyPage(eNo);
		model.addAttribute("empMyPage", ev);
		request.setAttribute("empMyPage", ev);
		
		return "emp/empUpdate";
	}
	
	//������� ������ ����Ʈ
	@RequestMapping(value="/empEntry", method={RequestMethod.POST, RequestMethod.GET})
	public String empEntry(Model model, HttpServletRequest request){

		logger.info("empEntry ȣ�� ���� in controller");
		
		EmpVO ev = empService.empEntry();
		model.addAttribute("empEntry", ev);
		request.setAttribute("empEntry", ev);
		
		return "emp/empEntry";
	}
}
