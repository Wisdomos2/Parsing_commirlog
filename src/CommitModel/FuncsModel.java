package CommitModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/* Model - 함수 */
public class FuncsModel {
	
	/* 프로그램 번호 확인 함수 */
	public boolean checkpgNum(int getNum, int maxpgNum)
	{
		/* 프로그램 번호는 1부터 저장소 개수 */		
		if(getNum < 1 || getNum > maxpgNum)
		{
			System.out.println("프로그램 번호를 확인하세요.");
			return false;
		}
		return true;
	}
	
	/* 년도 확인 함수 */
	public boolean checkyear(int getYear, int minYear, int maxYear)
	{
		String tempYear = String.valueOf(getYear);
		
		/* 숫자인지 확인 */
		Pattern p = Pattern.compile("(^[0-9]*$)");
		Matcher m = p.matcher(tempYear);
		if(m.find() == false)
		{
			System.out.println("년도에 숫자 외에 것을 입력하였습니다.");
			return false;
		}
		
		/* 입력년도는 최소년도 <-> 최대년도(올해)까지  */
		if(getYear < minYear || getYear > maxYear)
		{
			System.out.println("입력년도를 확인하세요.");
			return false;
		}
		return true;
	}

}
