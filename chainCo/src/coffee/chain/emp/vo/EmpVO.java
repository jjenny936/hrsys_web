package coffee.chain.emp.vo;

import org.springframework.web.multipart.MultipartFile;

public class EmpVO {
	
	private String eNo; //�����ȣ
	private String eId; //���̵�
	private String ePw; //��й�ȣ
	private String eName; //�����
	private String eDept; //�ҼӺμ�
	private String ePos; //��å
	private String eAddr; //�ּ�
	private String ePhone; //��ȭ��ȣ
	private String eEmail; //�̸����ּ�

	private String ePhoto; //�����̸�
	private String eSignature; //�����̸�
	private MultipartFile file; //÷�ε� ���� ����
	private MultipartFile file_1; //÷�ε� ���� ����
	
	private String eDeleteyn; //�ټӿ���
	private String eInsertDate; //�Ի���
	private String eUpdateDate; //����������
	
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

