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
	
	//초기화면
	@RequestMapping(value="/branchEntry", method={RequestMethod.POST, RequestMethod.GET})
	public String branchEntry(Model model){

		logger.info("branchEntry 호출 성공 in controller");
		
		List<BranchVO> branchEntry = branchService.branchEntry();
		model.addAttribute("branchEntry", branchEntry);
		return "branch/branchEntry";
		
	}
	
	//지점별 기본정보
	@RequestMapping(value="/branchList", method={RequestMethod.POST, RequestMethod.GET})
	public String branchList(@Param("bName") String bName, Model model){

		logger.info("branchList 호출 성공 in controller");
		
		List<BranchVO> branchList = branchService.branchList(bName);
		model.addAttribute("branchList", branchList);
		return "branch/branchList";		
	}
	
	//업데이트할 지점정보 뿌리기
	@RequestMapping(value="/branchUpdate", method={RequestMethod.POST, RequestMethod.GET})
	public String branchUpdate(@Param("bName") String bName, Model model){
		
		logger.info("branchUpdate 호출 성공 in controller");
		logger.info("bName for updateSelect >> " + bName);
		
		List<BranchVO> branchUpdate = branchService.branchList(bName);
		model.addAttribute("branchUpdate", branchUpdate);
		return "branch/branchUpdate";	
	}
	
	//업데이트 구현
	@RequestMapping(value="/update", method={RequestMethod.POST, RequestMethod.GET})
	public String update(@Param("bName") String bName, 
						 @Param("bNo") String bNo, 
						 @Param("bLocation") String bLocation, 
						 @Param("eName") String eName,
						 @Param("eNo") String eNo, 
						 @Param("bUpdateDate") String bUpdateDate, 
						 Model model){
		
		String str="";
		logger.info("update 호출 성공 in controller");
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
		
		if(i>0){//수정이 일어났으면,
			str="수정 완료!";
		}else{//수정이 일어나지 않았으면,
			str="수정에 문제가 있어 완료하지 못했습니다.";
		}
		
		model.addAttribute("update", str);
		
		return "branch/result";
	}
	
	//삭제구현
	@RequestMapping(value="/delete", method={RequestMethod.POST, RequestMethod.GET})
	public String delete(@Param("bName") String bName, Model model){
		
		String str="";
		logger.info("delete 호출 성공 in controller");
		logger.info("bName for delete>> " + bName);

		int i = branchService.delete(bName);
		
		if(i>0){//삭제가 일어났으면,
			str="삭제 완료!";
		}else{//삭제가 일어나지 않았으면,
			str="삭제에 문제가 있어 완료하지 못했습니다.";
		}
		
		model.addAttribute("delete", str);
		
		return "branch/result";
	}
	
	//폐점된 점포리스트 뽑기
	@RequestMapping(value="/branchDelete", method={RequestMethod.POST, RequestMethod.GET})
	public String branchDelete(Model model){
		
		logger.info("branchDelete 호출 성공 in controller");
		
		List<BranchVO> branchDelete = branchService.branchDelete();
		model.addAttribute("branchDelete", branchDelete);
		return "branch/branchDelete";	
	}
	
	//재개업(BDELETEYN N -> Y)
	@RequestMapping(value="/reopen", method={RequestMethod.POST, RequestMethod.GET})
	public String reopen(@Param("bName") String bName, Model model){
		
		String str="";
		logger.info("reopen 호출 성공 in controller");
		logger.info("bName for delete>> " + bName);

		int i = branchService.reopen(bName);
		
		if(i>0){//수정이 일어났으면,
			str="수정 완료!";
		}else{//수정이 일어나지 않았으면,
			str="수정에 문제가 있어 완료하지 못했습니다.";
		}
		
		model.addAttribute("reopen", str);
		
		return "branch/result";
	}
	
	//전체지점 리스트(폐점/영업중 모두)
	@RequestMapping(value="/list", method={RequestMethod.POST, RequestMethod.GET})
	public String list(Model model){

		logger.info("list 호출 성공 in controller");
		
		List<BranchVO> list = branchService.list();
		model.addAttribute("list", list);
		return "branch/branchChoice";
		
	}
	
	//매출화면
	@RequestMapping(value="/sales", method={RequestMethod.POST, RequestMethod.GET})
	public String sales(HttpServletRequest request){

		logger.info("sales 호출 성공 in controller");
		ArrayList sales = branchService.sales();
		request.setAttribute("sales", sales);
		return "branch/sales";
	}
	
	//이전년도 매출화면
	@RequestMapping(value="/lastYear", method={RequestMethod.POST, RequestMethod.GET})
	public String lastYear(HttpServletRequest request){

		logger.info("lastYear 호출 성공 in controller");
		ArrayList lastYear = branchService.lastYear();
		request.setAttribute("lastYear", lastYear);
		return "branch/lastYear";
	}
}
