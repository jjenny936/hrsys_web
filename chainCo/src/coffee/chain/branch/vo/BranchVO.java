package coffee.chain.branch.vo;

public class BranchVO {
	
	/*점포테이블*/
	private String bNo; //지점번호
	private String bName; //지점명
	private String eNo; //점장의 사원번호
	private String bLocation; //지역구분
	private String bDeleteyn; //영업여부
	private String bInsertDate; //개점일
	private String bUpdateDate; //최종수정일
	
	/*매출테이블 FK: bNo*/
	private int sFirstQ; //1분기매출
	private int sSecondQ; //2분기매출
	private int sThirdQ; //3분기매출
	private int sFourthQ; //4분기매출
	private int sYear; //연도
	private String sDeleteyn; 
	private String sInsertDate; //등록일
	private String sUpdateDate; //최종수정일
	
	/*점장이름*/
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