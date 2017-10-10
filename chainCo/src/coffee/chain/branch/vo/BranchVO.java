package coffee.chain.branch.vo;

public class BranchVO {
	
	/*�������̺�*/
	private String bNo; //������ȣ
	private String bName; //������
	private String eNo; //������ �����ȣ
	private String bLocation; //��������
	private String bDeleteyn; //��������
	private String bInsertDate; //������
	private String bUpdateDate; //����������
	
	/*�������̺� FK: bNo*/
	private int sFirstQ; //1�б����
	private int sSecondQ; //2�б����
	private int sThirdQ; //3�б����
	private int sFourthQ; //4�б����
	private int sYear; //����
	private String sDeleteyn; 
	private String sInsertDate; //�����
	private String sUpdateDate; //����������
	
	/*�����̸�*/
	private String eName;
	
	public BranchVO(){
		
	}
	
	public BranchVO(String bNo, String bName, String eNo, String bLocation,
			String bDeleteyn, String bInsertDate, String bUpdateDate,
			int sFirstQ, String eName, int sSecondQ, int sThirdQ, int sFourthQ, int sYear,
			String sDeleteyn, String sInsertDate, String sUpdateDate) {
		super();
		this.bNo = bNo;
		this.bName = bName;
		this.eName = eName;
		this.eNo = eNo;
		this.bLocation = bLocation;
		this.bDeleteyn = bDeleteyn;
		this.bInsertDate = bInsertDate;
		this.bUpdateDate = bUpdateDate;
		this.sFirstQ = sFirstQ;
		this.sSecondQ = sSecondQ;
		this.sThirdQ = sThirdQ;
		this.sFourthQ = sFourthQ;
		this.sYear = sYear;
		this.sDeleteyn = sDeleteyn;
		this.sInsertDate = sInsertDate;
		this.sUpdateDate = sUpdateDate;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getbNo() {
		return bNo;
	}
	public void setbNo(String bNo) {
		this.bNo = bNo;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String geteNo() {
		return eNo;
	}
	public void seteNo(String eNo) {
		this.eNo = eNo;
	}
	public String getbLocation() {
		return bLocation;
	}
	public void setbLocation(String bLocation) {
		this.bLocation = bLocation;
	}
	public String getbDeleteyn() {
		return bDeleteyn;
	}
	public void setbDeleteyn(String bDeleteyn) {
		this.bDeleteyn = bDeleteyn;
	}
	public String getbInsertDate() {
		return bInsertDate;
	}
	public void setbInsertDate(String bInsertDate) {
		this.bInsertDate = bInsertDate;
	}
	public String getbUpdateDate() {
		return bUpdateDate;
	}
	public void setbUpdateDate(String bUpdateDate) {
		this.bUpdateDate = bUpdateDate;
	}
	public int getsFirstQ() {
		return sFirstQ;
	}
	public void setsFirstQ(int sFirstQ) {
		this.sFirstQ = sFirstQ;
	}
	public int getsSecondQ() {
		return sSecondQ;
	}
	public void setsSecondQ(int sSecondQ) {
		this.sSecondQ = sSecondQ;
	}
	public int getsThirdQ() {
		return sThirdQ;
	}
	public void setsThirdQ(int sThirdQ) {
		this.sThirdQ = sThirdQ;
	}
	public int getsFourthQ() {
		return sFourthQ;
	}
	public void setsFourthQ(int sFourthQ) {
		this.sFourthQ = sFourthQ;
	}
	public int getsYear() {
		return sYear;
	}
	public void setsYear(int sYear) {
		this.sYear = sYear;
	}
	public String getsDeleteyn() {
		return sDeleteyn;
	}
	public void setsDeleteyn(String sDeleteyn) {
		this.sDeleteyn = sDeleteyn;
	}
	public String getsInsertDate() {
		return sInsertDate;
	}
	public void setsInsertDate(String sInsertDate) {
		this.sInsertDate = sInsertDate;
	}
	public String getsUpdateDate() {
		return sUpdateDate;
	}
	public void setsUpdateDate(String sUpdateDate) {
		this.sUpdateDate = sUpdateDate;
	}

}