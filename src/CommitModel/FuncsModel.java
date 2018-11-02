package CommitModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FuncsModel {
	public boolean checkpgNum(int getNum, int maxpgNum)
	{
		if(getNum < 1 || getNum > maxpgNum)
		{
			System.out.println("프로그램 번호를 확인하세요.");
			return false;
		}
		return true;
	}
	public boolean checkyear(int getYear, int maxYear)
	{
		String tempYear = String.valueOf(getYear);
		Pattern p = Pattern.compile("(^[0-9]*$)");
		Matcher m = p.matcher(tempYear);
		if(m.find() == false)
		{
			System.out.println("년도에 숫자 외에 것을 입력하였습니다.");
			return false;
		}
		if(getYear  == 0 || getYear > maxYear)
		{
			System.out.println("입력년도를 확인하세요.");
			return false;
		}
		return true;
	}

}
