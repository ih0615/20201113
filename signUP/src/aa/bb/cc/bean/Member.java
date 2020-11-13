package aa.bb.cc.bean;

public class Member {
	String pidx;
	String pname;
	String pgender;
	String pid;
	String ppwd;
	String pcpwd;
	String paddr;
	String ptel;
	String pemail;
	String phobby;
	public Member() {}
	public Member(String pidx, String pname, String pgender, String pid, String ppwd, String pcpwd, String paddr,
			String ptel, String pemail, String phobby) {
		super();
		this.pidx = pidx;
		this.pname = pname;
		this.pgender = pgender;
		this.pid = pid;
		this.ppwd = ppwd;
		this.pcpwd = pcpwd;
		this.paddr = paddr;
		this.ptel = ptel;
		this.pemail = pemail;
		this.phobby = phobby;
	}
	@Override
	public String toString() {
		return "Member [pidx=" + pidx + ", pname=" + pname + ", pgender=" + pgender + ", pid=" + pid + ", ppwd=" + ppwd
				+ ", pcpwd=" + pcpwd + ", paddr=" + paddr + ", ptel=" + ptel + ", pemail=" + pemail + ", phobby="
				+ phobby + "]";
	}
	public String getPidx() {
		return pidx;
	}
	public void setPidx(String pidx) {
		this.pidx = pidx;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPgender() {
		return pgender;
	}
	public void setPgender(String pgender) {
		this.pgender = pgender;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPpwd() {
		return ppwd;
	}
	public void setPpwd(String ppwd) {
		this.ppwd = ppwd;
	}
	public String getPcpwd() {
		return pcpwd;
	}
	public void setPcpwd(String pcpwd) {
		this.pcpwd = pcpwd;
	}
	public String getPaddr() {
		return paddr;
	}
	public void setPaddr(String paddr) {
		this.paddr = paddr;
	}
	public String getPtel() {
		return ptel;
	}
	public void setPtel(String ptel) {
		this.ptel = ptel;
	}
	public String getPemail() {
		return pemail;
	}
	public void setPemail(String pemail) {
		this.pemail = pemail;
	}
	public String getPhobby() {
		return phobby;
	}
	public void setPhobby(String phobby) {
		this.phobby = phobby;
	}
	
}
