package aa.bb.cc.mm;

/**
 * @PackageName		: aa.bb.cc.mm
 * @FileName		: Member.java
 * @Since			: 2020. 11. 5
 * @Author			: KB
 * @Description		: 
 * =====================================================================================
 * 								   Modification History
 * =====================================================================================
 * Date				Author				Note
 * -------------------------------------------------------------------------------------
 * 2020. 11. 5		KB				최초 작성
 *
 */
public class Member {
	String pname;
	String pgender;
	String pid;
	String ppw;
	String ppwr;
	String padr;
	String ptel;
	String pemail;
	String phobby;
	/**
	 * @param pname
	 * @param pgender
	 * @param pid
	 * @param ppw
	 * @param ppwr
	 * @param padr
	 * @param ptel
	 * @param pemail
	 * @param phobby
	 */
	public Member(String pname, String pgender, String pid, String ppw, String ppwr, String padr, String ptel,
			String pemail, String phobby) {
		super();
		this.pname = pname;
		this.pgender = pgender;
		this.pid = pid;
		this.ppw = ppw;
		this.ppwr = ppwr;
		this.padr = padr;
		this.ptel = ptel;
		this.pemail = pemail;
		this.phobby = phobby;
	}
	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	/**
	 * @return the pgender
	 */
	public String getPgender() {
		return pgender;
	}
	/**
	 * @param pgender the pgender to set
	 */
	public void setPgender(String pgender) {
		this.pgender = pgender;
	}
	/**
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * @return the ppw
	 */
	public String getPpw() {
		return ppw;
	}
	/**
	 * @param ppw the ppw to set
	 */
	public void setPpw(String ppw) {
		this.ppw = ppw;
	}
	/**
	 * @return the ppwr
	 */
	public String getPpwr() {
		return ppwr;
	}
	/**
	 * @param ppwr the ppwr to set
	 */
	public void setPpwr(String ppwr) {
		this.ppwr = ppwr;
	}
	/**
	 * @return the padr
	 */
	public String getPadr() {
		return padr;
	}
	/**
	 * @param padr the padr to set
	 */
	public void setPadr(String padr) {
		this.padr = padr;
	}
	/**
	 * @return the ptel
	 */
	public String getPtel() {
		return ptel;
	}
	/**
	 * @param ptel the ptel to set
	 */
	public void setPtel(String ptel) {
		this.ptel = ptel;
	}
	/**
	 * @return the pemail
	 */
	public String getPemail() {
		return pemail;
	}
	/**
	 * @param pemail the pemail to set
	 */
	public void setPemail(String pemail) {
		this.pemail = pemail;
	}
	/**
	 * @return the phobby
	 */
	public String getPhobby() {
		return phobby;
	}
	/**
	 * @param phobby the phobby to set
	 */
	public void setPhobby(String phobby) {
		this.phobby = phobby;
	}
	
	
}
