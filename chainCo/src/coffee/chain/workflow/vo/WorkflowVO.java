package coffee.chain.workflow.vo;

public class WorkflowVO {

	// 전자결재 : workflow
	private int wNo; // 문서 생성번호
	private String eNo;
	private String wOkdocNo; // 최종승인된 문서번호
	private String wFormat;
	private String wTitle;
	private String wDeleteyn; 
	private String wInsertDate;
	private String wUpdateDate;
	private String wCode; // 대기, 열람중, 보류, 임시저장됨 
	private String wFirstState; //1단계 결재 여부 : 결재, 미결재
	private String wFirstOKState;//승인, 반려
	private String wFinalState; //2단계 결재 여부 : 결재, 미결재
	private String wFinalOKState;//승인, 반려
	private String wFirstokEno; //서명 집어넣기
	private String wSecondokEno;
	private String wFirstokDate;
	private String wSecondokDate;
	private String wDenyReason;
	
	
	// 결재단계는 1단계, 2단계 2가지
	// 사장의 경우에는 1단계
	// 문서 종류와 사원의 부서 직급에 따라 결재라인 다르게 조건문으로 분기시킴
	// 결재후에 사직서나 휴가계획서는 인사부 전체에 배포(업무처리용)
	// 배포되는 문서는 단순히 기존 INSERT 된 문서를 view
	
	// 삭제 가능한 문서는 임시저장된 문서만 가능
	// 한번 결재하면 수정 불가능
	// 결재회수나 결재취소를 해야만 가능 -> 하면 임시저장된 문서로 변환
	
	// 문서를 열람할 때(view할 때) 서명 보이게
	// 서명은 view할 때 SELECT하게함 그리고 화면에 보임
	
	
	// 업무보고 : work -> workflow work
	private String wWtodayDone1;
	private String wWtodayDone2;	
	private String wWnextdayDo;
	private String wWinstruction;

	// 사직 : resignation -> workflow resignation
	private String wRresigndate;
	private String wRreason;
	private String wRpostaddr;
	private String wRposttel;
	private String wRpostemail;
	private String wRsecondcheck;
	
	// 휴가신청 : vacation -> workflow vacation
	private String wVkind;
	private String wVreason;
	private String wVtermfrom;
	private String wVtermto;
	private String wVtakedept;
	private String wVtakepos;
	private String wVtakename;
	private String wVtakesign;
	private String wVsecondtel;
	
	// 휴가신청서의 경우 대리업무자의 서명이 필요
	// 구현방법의 경우 우편번호로 찾기처럼
	// 팝업창을 띄워서 부서 직급 이름으로 검색한 다음 서명 새겨넣기
	// 일단 대리업무자의 서명관련부분은 나중에
	
	
	// view를 위해 생성,
	// jstl에서 c:foreach에서 1개의 객체만 가능하므로
	// FK는 아님
	// 아니면 상속을 받으면 됨
	private String ePos;
	private String eDept;
	private String eName;
	
	
	public WorkflowVO(){}


	public int getwNo() {
		return wNo;
	}


	public String geteNo() {
		return eNo;
	}


	public String getwOkdocNo() {
		return wOkdocNo;
	}


	public String getwFormat() {
		return wFormat;
	}


	public String getwTitle() {
		return wTitle;
	}


	public String getwDeleteyn() {
		return wDeleteyn;
	}


	public String getwInsertDate() {
		return wInsertDate;
	}


	public String getwUpdateDate() {
		return wUpdateDate;
	}


	public String getwCode() {
		return wCode;
	}


	public String getwFirstState() {
		return wFirstState;
	}


	public String getwFirstOKState() {
		return wFirstOKState;
	}


	public String getwFinalState() {
		return wFinalState;
	}


	public String getwFinalOKState() {
		return wFinalOKState;
	}


	public String getwFirstokEno() {
		return wFirstokEno;
	}


	public String getwSecondokEno() {
		return wSecondokEno;
	}


	public String getwFirstokDate() {
		return wFirstokDate;
	}


	public String getwSecondokDate() {
		return wSecondokDate;
	}


	public String getwDenyReason() {
		return wDenyReason;
	}


	public String getwWtodayDone1() {
		return wWtodayDone1;
	}


	public String getwWtodayDone2() {
		return wWtodayDone2;
	}


	public String getwWnextdayDo() {
		return wWnextdayDo;
	}


	public String getwWinstruction() {
		return wWinstruction;
	}


	public String getwRresigndate() {
		return wRresigndate;
	}


	public String getwRreason() {
		return wRreason;
	}


	public String getwRpostaddr() {
		return wRpostaddr;
	}


	public String getwRposttel() {
		return wRposttel;
	}


	public String getwRpostemail() {
		return wRpostemail;
	}


	public String getwRsecondcheck() {
		return wRsecondcheck;
	}


	public String getwVkind() {
		return wVkind;
	}


	public String getwVreason() {
		return wVreason;
	}


	public String getwVtermfrom() {
		return wVtermfrom;
	}


	public String getwVtermto() {
		return wVtermto;
	}


	public String getwVtakedept() {
		return wVtakedept;
	}


	public String getwVtakepos() {
		return wVtakepos;
	}


	public String getwVtakename() {
		return wVtakename;
	}


	public String getwVtakesign() {
		return wVtakesign;
	}


	public String getwVsecondtel() {
		return wVsecondtel;
	}


	public String getePos() {
		return ePos;
	}


	public String geteDept() {
		return eDept;
	}


	public String geteName() {
		return eName;
	}


	public void setwNo(int wNo) {
		this.wNo = wNo;
	}


	public void seteNo(String eNo) {
		this.eNo = eNo;
	}


	public void setwOkdocNo(String wOkdocNo) {
		this.wOkdocNo = wOkdocNo;
	}


	public void setwFormat(String wFormat) {
		this.wFormat = wFormat;
	}


	public void setwTitle(String wTitle) {
		this.wTitle = wTitle;
	}


	public void setwDeleteyn(String wDeleteyn) {
		this.wDeleteyn = wDeleteyn;
	}


	public void setwInsertDate(String wInsertDate) {
		this.wInsertDate = wInsertDate;
	}


	public void setwUpdateDate(String wUpdateDate) {
		this.wUpdateDate = wUpdateDate;
	}


	public void setwCode(String wCode) {
		this.wCode = wCode;
	}


	public void setwFirstState(String wFirstState) {
		this.wFirstState = wFirstState;
	}


	public void setwFirstOKState(String wFirstOKState) {
		this.wFirstOKState = wFirstOKState;
	}


	public void setwFinalState(String wFinalState) {
		this.wFinalState = wFinalState;
	}


	public void setwFinalOKState(String wFinalOKState) {
		this.wFinalOKState = wFinalOKState;
	}


	public void setwFirstokEno(String wFirstokEno) {
		this.wFirstokEno = wFirstokEno;
	}


	public void setwSecondokEno(String wSecondokEno) {
		this.wSecondokEno = wSecondokEno;
	}


	public void setwFirstokDate(String wFirstokDate) {
		this.wFirstokDate = wFirstokDate;
	}


	public void setwSecondokDate(String wSecondokDate) {
		this.wSecondokDate = wSecondokDate;
	}


	public void setwDenyReason(String wDenyReason) {
		this.wDenyReason = wDenyReason;
	}


	public void setwWtodayDone1(String wWtodayDone1) {
		this.wWtodayDone1 = wWtodayDone1;
	}


	public void setwWtodayDone2(String wWtodayDone2) {
		this.wWtodayDone2 = wWtodayDone2;
	}


	public void setwWnextdayDo(String wWnextdayDo) {
		this.wWnextdayDo = wWnextdayDo;
	}


	public void setwWinstruction(String wWinstruction) {
		this.wWinstruction = wWinstruction;
	}


	public void setwRresigndate(String wRresigndate) {
		this.wRresigndate = wRresigndate;
	}


	public void setwRreason(String wRreason) {
		this.wRreason = wRreason;
	}


	public void setwRpostaddr(String wRpostaddr) {
		this.wRpostaddr = wRpostaddr;
	}


	public void setwRposttel(String wRposttel) {
		this.wRposttel = wRposttel;
	}


	public void setwRpostemail(String wRpostemail) {
		this.wRpostemail = wRpostemail;
	}


	public void setwRsecondcheck(String wRsecondcheck) {
		this.wRsecondcheck = wRsecondcheck;
	}


	public void setwVkind(String wVkind) {
		this.wVkind = wVkind;
	}


	public void setwVreason(String wVreason) {
		this.wVreason = wVreason;
	}


	public void setwVtermfrom(String wVtermfrom) {
		this.wVtermfrom = wVtermfrom;
	}


	public void setwVtermto(String wVtermto) {
		this.wVtermto = wVtermto;
	}


	public void setwVtakedept(String wVtakedept) {
		this.wVtakedept = wVtakedept;
	}


	public void setwVtakepos(String wVtakepos) {
		this.wVtakepos = wVtakepos;
	}


	public void setwVtakename(String wVtakename) {
		this.wVtakename = wVtakename;
	}


	public void setwVtakesign(String wVtakesign) {
		this.wVtakesign = wVtakesign;
	}


	public void setwVsecondtel(String wVsecondtel) {
		this.wVsecondtel = wVsecondtel;
	}


	public void setePos(String ePos) {
		this.ePos = ePos;
	}


	public void seteDept(String eDept) {
		this.eDept = eDept;
	}


	public void seteName(String eName) {
		this.eName = eName;
	}



	
	
}












