package CommitController;

import java.util.Scanner;

import CommitModel.FuncsModel;
import CommitModel.LogSet;
import CommitModel.VariableModel;
import CommitView.LogView;

public class LogController {
	/* Controller */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/* 객체 선언 */
		Scanner sc = new Scanner(System.in);
		LogSet ls = new LogSet();
		LogView lv = new LogView();
		FuncsModel fm = new FuncsModel();
		VariableModel vm = new VariableModel();
		
		/* 프로그램 정보 객체 초기화 */
		vm.pgDatainit();
		
		/* 메뉴 뷰 */
		lv.LogmenuView();
		
		/* 프로그램 넘버 입력 */
		int usrpgNum = sc.nextInt() ;
		
		/* 프로그램 넘버 검사 */
		int maxpgNum = vm.getPgCount();
		if(fm.checkpgNum(usrpgNum, maxpgNum) == false)
		{
			return;
		}
		
		/* 년도 뷰 */		
		lv.LoggetYearView();
		
		/* 년도 입력 */
		int usrgetYear = sc.nextInt();
		
		/* 년도 검사, 2015년 - 이번년도, 숫자 */
		int maxpgYear = vm.getMaxYear();
		int minpgYear = vm.getMinYear();
		if(fm.checkyear(usrgetYear, minpgYear ,maxpgYear) == false)
		{
			return;
		}
		
		/* 클래스 플로우 : Logset -> Logproc -> Cretafile  */
		
		/* 입력된 프로그램 넘버, 년도로 시작 */
		ls.Loginit(usrpgNum,usrgetYear);
		sc.close();
		return;
	}
}
