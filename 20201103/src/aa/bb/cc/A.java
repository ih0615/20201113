package aa.bb.cc;

/**
 * @PackageName : aa.bb.cc
 * @FileName : A.java
 * @Since : 2020. 11. 3
 * @Author : KB
 * @Description :
 *              =====================================================================================
 *              Modification History
 *              =====================================================================================
 *              Date Author Note
 *              -------------------------------------------------------------------------------------
 *              2020. 11. 3 KB 최초 작성
 *
 */
abstract class B{
	public abstract void doPrint();
}

public class A {
	public int a=20;
	public void doPrint() {
		System.out.println("A 클래스 입니다.");
	}
}
