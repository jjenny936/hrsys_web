package coffee.chain.emp.vo;

import org.springframework.web.multipart.MultipartFile;

public class EmpVO {
	
	private String eNo; //사원번호
	private String eId; //아이디
	private String ePw; //비밀번호
	private String eName; //사원명
	private String eDept; //소속부서
	private String ePos; //직책
	private String eAddr; //주소
	private String ePhone; //전화번호
	private String eEmail; //이메일주소

	private String ePhoto; //사진이름
	private String eSignature; //사인이름
	private MultipartFile file; //첨부된 사진 파일
	private MultipartFile file_1; //첨부된 사인 파일
	
	private String eDeleteyn; //근속여부
	private String eInsertDate; //입사일
	private String eUpdateDate; //최종수정일
	
	public EmpVO(){
		
	}

	public EmpVO(String eNo, String eId, String ePw, String eName,
			String eDept, String ePos, String eAddr, String ePhone,
			String eEmail, String ePhoto, String eSignature,
			MultipartFile file, MultipartFile file_1, String eDeleteyn,
			String eInsertDate, String eUpdateDate) {
		super();
		this.eNo = eNo;
		this.eId = eId;
		this.ePw = ePw;
		this.eName = eName;
		this.eDept = eDept;
		this.ePos = ePos;
		this.eAddr = eAddr;
		this.ePhone = ePhone;
		this.eEmail = eEmail;
		this.ePhoto = ePhoto;
		this.eSignature = eSignature;
		this.file = file;
		this.file_1 = file_1;
		this.eDeleteyn = eDeleteyn;
		this.eInsertDate = eInsertDate;
		this.eUpdateDate = eUpdateDate;
	}

	public String geteNo() {
		return eNo;
	}

	public void seteNo(String eNo) {
		this.eNo = eNo;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String getePw() {
		return ePw;
	}

	public void setePw(String ePw) {
		this.ePw = ePw;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteDept() {
		return eDept;
	}

	public void seteDept(String eDept) {
		this.eDept = eDept;
	}

	public String getePos() {
		return ePos;
	}

	public void setePos(String ePos) {
		this.ePos = ePos;
	}

	public String geteAddr() {
		return eAddr;
	}

	public void seteAddr(String eAddr) {
		this.eAddr = eAddr;
	}

	public String getePhone() {
		return ePhone;
	}

	public void setePhone(String ePhone) {
		this.ePhone = ePhone;
	}

	public String geteEmail() {
		return eEmail;
	}

	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}

	public String getePhoto() {
		return ePhoto;
	}

	public void setePhoto(String ePhoto) {
		this.ePhoto = ePhoto;
	}

	public String geteSignature() {
		return eSignature;
	}

	public void seteSignature(String eSignature) {
		this.eSignature = eSignature;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public MultipartFile getFile_1() {
		return file_1;
	}

	public void setFile_1(MultipartFile file_1) {
		this.file_1 = file_1;
	}

	public String geteDeleteyn() {
		return eDeleteyn;
	}

	public void seteDeleteyn(String eDeleteyn) {
		this.eDeleteyn = eDeleteyn;
	}

	public String geteInsertDate() {
		return eInsertDate;
	}

	public void seteInsertDate(String eInsertDate) {
		this.eInsertDate = eInsertDate;
	}

	public String geteUpdateDate() {
		return eUpdateDate;
	}

	public void seteUpdateDate(String eUpdateDate) {
		this.eUpdateDate = eUpdateDate;
	}
}

