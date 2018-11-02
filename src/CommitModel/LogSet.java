package CommitModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class LogSet {
	/* LogSet - Hashmap에 URL 세팅, 프로그램명 + 현재시간으로 파일명 생성 */
	
	/* URL 저장 맵 */
	static HashMap<Integer,String> urlSet = null;
	
	/* Log출력프로세스 시작 */
	public void Loginit(int getpgNum, int getYear) {
		
		urlSet = new HashMap<>();
		
		/* URL 세팅 */
		__urlSetting();
		
		String getinfo[] = __getFilename(getpgNum, getYear);
		
		/* 배열 값가지고 LogProc 시작 */
		new Logproc(getinfo[0], getinfo[1], getinfo[2]);
	}
	
	
	/* 파일명 생성 */
	private static String[] __getFilename(int getUrlnum, int getYear)
	{
		String inputUrl = null;
		String inputfilePath = "C:\\Users\\jsmo\\Desktop"; // UX에서 입력받을 것
		String inputfileName = null;
		String inputfilePathName = null;
		
		/* 저장소 명 +현재 시각으로 파일 명 세팅 */ 
		Date dt = new Date();
		SimpleDateFormat time = new SimpleDateFormat("hhmmss");
		inputUrl = urlSet.get(getUrlnum);
		String getPgname[] = inputUrl.split("/");
		inputfileName = "\\" + getPgname[4] + "_"+ String.valueOf(getYear)+ "_" + time.format(dt);
		
		inputfilePathName = inputfilePath + inputfileName;		
		
		String returnarr[] = {inputUrl, inputfilePathName, String.valueOf(getYear)};
		
		/* URL, 경로, 파일명, 년도 리턴 */
		return returnarr;
	}
	
	/* 저장소 URL 세팅 */
	private static void __urlSetting()
	{
		/**************** URL SETTING ****************/
		//Midas
		urlSet.put(1,"http://git.sw.co.kr/finance/Midas/commits/master?feed_token=Srs_ufwpwSY5e2LZcPVX&format=atom");
		
		//Global
		urlSet.put(2,"http://git.sw.co.kr/finance/Brioni/commits/master?feed_token=Srs_ufwpwSY5e2LZcPVX&format=atom");
		
		//GLS
		urlSet.put(3,"http://git.sw.co.kr/finance/SwGLS/commits/master?feed_token=Srs_ufwpwSY5e2LZcPVX&format=atom");
		
		//Logis
		urlSet.put(4,"http://git.sw.co.kr/domestic/SwLogis/commits/master?feed_token=Srs_ufwpwSY5e2LZcPVX&format=atom");
		
		//Logistics
		urlSet.put(5,"http://git.sw.co.kr/domestic/SwLogistics/commits/master?feed_token=Srs_ufwpwSY5e2LZcPVX&format=atom");
		
		//Vt
		urlSet.put(6,"http://git.sw.co.kr/finance/SwVT/commits/master?feed_token=Srs_ufwpwSY5e2LZcPVX&format=atom");
		
		//Hcm
		urlSet.put(7,"http://git.sw.co.kr/finance/SwHcm/commits/master?feed_token=Srs_ufwpwSY5e2LZcPVX&format=atom");
		
		//Hanoi
		urlSet.put(8,"http://git.sw.co.kr/finance/SwHanoi/commits/master?feed_token=Srs_ufwpwSY5e2LZcPVX&format=atom");
		
		//Saigon
		urlSet.put(9,"http://git.sw.co.kr/finance/SwSaigon/commits/master?feed_token=Srs_ufwpwSY5e2LZcPVX&format=atom");
		
		//Shacc
		urlSet.put(10,"http://git.sw.co.kr/finance/Shacc/commits/master?feed_token=Srs_ufwpwSY5e2LZcPVX&format=atom");
		
		//ininkt
		urlSet.put(11,"http://git.sw.co.kr/finance/Swinikt/commits/master?feed_token=Srs_ufwpwSY5e2LZcPVX&format=atom");
	}
}
