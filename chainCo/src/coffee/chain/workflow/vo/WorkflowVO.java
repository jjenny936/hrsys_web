package coffee.chain.workflow.vo;

public class WorkflowVO {

	// ���ڰ��� : workflow
	private int wNo; // ���� ������ȣ
	private String eNo;
	private String wOkdocNo; // �������ε� ������ȣ
	private String wFormat;
	private String wTitle;
	private String wDeleteyn; 
	private String wInsertDate;
	private String wUpdateDate;
	private String wCode; // ���, ������, ����, �ӽ������ 
	private String wFirstState; //1�ܰ� ���� ���� : ����, �̰���
	private String wFirstOKState;//����, �ݷ�
	private String wFinalState; //2�ܰ� ���� ���� : ����, �̰���
	private String wFinalOKState;//����, �ݷ�
	private String wFirstokEno; //���� ����ֱ�
	private String wSecondokEno;
	private String wFirstokDate;
	private String wSecondokDate;
	private String wDenyReason;
	
	
	// ����ܰ�� 1�ܰ�, 2�ܰ� 2����
	// ������ ��쿡�� 1�ܰ�
	// ���� ������ ����� �μ� ���޿� ���� ������� �ٸ��� ���ǹ����� �б��Ŵ
	// �����Ŀ� �������� �ް���ȹ���� �λ�� ��ü�� ����(����ó����)
	// �����Ǵ� ������ �ܼ��� ���� INSERT �� ������ view
	
	// ���� ������ ������ �ӽ������ ������ ����
	// �ѹ� �����ϸ� ���� �Ұ���
	// ����ȸ���� ������Ҹ� �ؾ߸� ���� -> �ϸ� �ӽ������ ������ ��ȯ
	
	// ������ ������ ��(view�� ��) ���� ���̰�
	// ������ view�� �� SELECT�ϰ��� �׸��� ȭ�鿡 ����
	
	
	// �������� : work -> workflow work
	private String wWtodayDone1;
	private String wWtodayDone2;	
	private String wWnextdayDo;
	private String wWinstruction;

	// ���� : resignation -> workflow resignation
	private String wRresigndate;
	private String wRreason;
	private String wRpostaddr;
	private String wRposttel;
	private String wRpostemail;
	private String wRsecondcheck;
	
	// �ް���û : vacation -> workflow vacation
	private String wVkind;
	private String wVreason;
	private String wVtermfrom;
	private String wVtermto;
	private String wVtakedept;
	private String wVtakepos;
	private String wVtakename;
	private String wVtakesign;
	private String wVsecondtel;
	
	// �ް���û���� ��� �븮�������� ������ �ʿ�
	// ��������� ��� �����ȣ�� ã��ó��
	// �˾�â�� ����� �μ� ���� �̸����� �˻��� ���� ���� ���ֱܳ�
	// �ϴ� �븮�������� ������úκ��� ���߿�
	
	
	// view�� ���� ����,
	// jstl���� c:foreach���� 1���� ��ü�� �����ϹǷ�
	// FK�� �ƴ�
	// �ƴϸ� ����� ������ ��
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












