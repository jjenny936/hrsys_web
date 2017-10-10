package coffee.chain.branch.controller;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
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

import coffee.chain.branch.service.BranchService;
import coffee.chain.branch.vo.BranchVO;
import coffee.chain.emp.controller.EmpController;
import coffee.chain.emp.service.EmpService;
import coffee.chain.emp.vo.EmpVO;

@Controller
@RequestMapping(value="/branch")
public class BranchController {
	
	Logger logger = Logger.getLogger(BranchController.class);
	
	@Autowired
	private BranchService branchService;
	
	//�ʱ�ȭ��
	@RequestMapping(value="/branchEntry", method={RequestMethod.POST, RequestMethod.GET})
	public String branchEntry(Model model){

		logger.info("branchEntry ȣ�� ���� in controller");
		
		List<BranchVO> branchEntry = branchService.branchEntry();
		model.addAttribute("branchEntry", branchEntry);
		return "branch/branchEntry";
		
	}
	
	//������ �⺻����
	@RequestMapping(value="/branchList", method={RequestMethod.POST, RequestMethod.GET})
	public String branchList(@Param("bName") String bName, Model model){

		logger.info("branchList ȣ�� ���� in controller");
		
		List<BranchVO> branchList = branchService.branchList(bName);
		model.addAttribute("branchList", branchList);
		return "branch/branchList";		
	}
	
	//������Ʈ�� �������� �Ѹ���
	@RequestMapping(value="/branchUpdate", method={RequestMethod.POST, RequestMethod.GET})
	public String branchUpdate(@Param("bName") String bName, Model model){
		
		logger.info("branchUpdate ȣ�� ���� in controller");
		logger.info("bName for updateSelect >> " + bName);
		
		List<BranchVO> branchUpdate = branchService.branchList(bName);
		model.addAttribute("branchUpdate", branchUpdate);
		return "branch/branchUpdate";	
	}
	
	//������Ʈ ����
	@RequestMapping(value="/update", method={RequestMethod.POST, RequestMethod.GET})
	public String update(@Param("bName") String bName, 
						 @Param("bNo") String bNo, 
						 @Param("bLocation") String bLocation, 
						 @Param("eName") String eName,
						 @Param("eNo") String eNo, 
						 @Param("bUpdateDate") String bUpdateDate, 
						 Model model){
		
		String str="";
		logger.info("update ȣ�� ���� in controller");
		logger.info("bNo for update>> " + bNo);
		logger.info("bName for update>> " + bName);
		
		BranchVO bv = null;
		bv = new BranchVO();
		
		bv.setbName(bName);
		bv.setbNo(bNo);
		bv.setbLocation(bLocation);
		bv.seteName(eName);
		bv.seteNo(eNo);
		bv.setbUpdateDate(bUpdateDate);
		
		int i = branchService.update(bv);
		
		if(i>0){//������ �Ͼ����,
			str="���� �Ϸ�!";
		}else{//������ �Ͼ�� �ʾ�����,
			str="������ ������ �־� �Ϸ����� ���߽��ϴ�.";
		}
		
		model.addAttribute("update", str);
		
		return "branch/result";
	}
	
	//��������
	@RequestMapping(value="/delete", method={RequestMethod.POST, RequestMethod.GET})
	public String delete(@Param("bName") String bName, Model model){
		
		String str="";
		logger.info("delete ȣ�� ���� in controller");
		logger.info("bName for delete>> " + bName);

		int i = branchService.delete(bName);
		
		if(i>0){//������ �Ͼ����,
			str="���� �Ϸ�!";
		}else{//������ �Ͼ�� �ʾ�����,
			str="������ ������ �־� �Ϸ����� ���߽��ϴ�.";
		}
		
		model.addAttribute("delete", str);
		
		return "branch/result";
	}
	
	//������ ��������Ʈ �̱�
	@RequestMapping(value="/branchDelete", method={RequestMethod.POST, RequestMethod.GET})
	public String branchDelete(Model model){
		
		logger.info("branchDelete ȣ�� ���� in controller");
		
		List<BranchVO> branchDelete = branchService.branchDelete();
		model.addAttribute("branchDelete", branchDelete);
		return "branch/branchDelete";	
	}
	
	//�簳��(BDELETEYN N -> Y)
	@RequestMapping(value="/reopen", method={RequestMethod.POST, RequestMethod.GET})
	public String reopen(@Param("bName") String bName, Model model){
		
		String str="";
		logger.info("reopen ȣ�� ���� in controller");
		logger.info("bName for delete>> " + bName);

		int i = branchService.reopen(bName);
		
		if(i>0){//������ �Ͼ����,
			str="���� �Ϸ�!";
		}else{//������ �Ͼ�� �ʾ�����,
			str="������ ������ �־� �Ϸ����� ���߽��ϴ�.";
		}
		
		model.addAttribute("reopen", str);
		
		return "branch/result";
	}
	
	//��ü���� ����Ʈ(����/������ ���)
	@RequestMapping(value="/list", method={RequestMethod.POST, RequestMethod.GET})
	public String list(Model model){

		logger.info("list ȣ�� ���� in controller");
		
		List<BranchVO> list = branchService.list();
		model.addAttribute("list", list);
		return "branch/branchChoice";
		
	}
	
	//����ȭ��
	@RequestMapping(value="/sales", method={RequestMethod.POST, RequestMethod.GET})
	public String sales(HttpServletRequest request){

		logger.info("sales ȣ�� ���� in controller");
		ArrayList sales = branchService.sales();
		request.setAttribute("sales", sales);
		return "branch/sales";
	}
	
	//�����⵵ ����ȭ��
	@RequestMapping(value="/lastYear", method={RequestMethod.POST, RequestMethod.GET})
	public String lastYear(HttpServletRequest request){

		logger.info("lastYear ȣ�� ���� in controller");
		ArrayList lastYear = branchService.lastYear();
		request.setAttribute("lastYear", lastYear);
		return "branch/lastYear";
	}
}
