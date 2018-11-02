package CommitModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/* Logproc - 실제 파싱작업 및 출력 String 생성 */
public class Logproc {
	public Logproc(String getUrl, String getfilePathName, String getYear)
	{
		try
		{
			/* 입력된 URL, 경로, 파일명, 년도로 getLog 시작 */
			getLog(getUrl, getfilePathName, getYear);
		}
		catch(Exception e)
		{
			/* 에러 출력 */
			System.out.println("Error : " + e);
		}
	}
	
	
	/* XML 파싱하여 출력할 String 생성 : inputStr */
	private void getLog(String geturl, String gatefilePathName, String getYear) throws Exception
	{
		/* 입력된 URl에서 파싱 */
		Document doc = Jsoup.connect(geturl).get();
		
		/* XML에서 해당 태그의 Attribute값 추출 */
		Elements ids = doc.select("id");
		Elements titles = doc.select("title");
		Elements updateds= doc.select("updated");
		Elements names = doc.select("name");
		Elements emails = doc.select("email");
		String inputStr = "";
		
		/* 추출된 Elements 갯수 만큼 반복 */
		for(int i=0;i<titles.size();i++)
		{
			/* History Entry 전에 저장소 정보 */
			if(i==0)
			{
				System.out.println("- # 저장소 정 보 # -");
				inputStr += "- # 저장소 정 보 # -\r\n";
				System.out.println("- > Base Year : " + getYear);
				inputStr += "- > Base Year : " + getYear + "\r\n";
				System.out.println("- > Commit Branch name : " + ids.get(i).text());
				inputStr += "- > Commit Branch name : " + ids.get(i).text() + "\r\n";
				System.out.println("- > Info Source : " + titles.get(i).text());
				inputStr += "- > Info Source : " + titles.get(i).text() + "\r\n";
				System.out.println("- > Last Updated : " + updateds.get(i).text());
				inputStr += "- > Last Updated : " + updateds.get(i).text() + "\r\n";
				System.out.println("- > Additional Info : Maximum length of Commit Context is 77.");
				inputStr += "- > Additional Info : Maximum length of Commit Context is 77.\r\n";
			}
			/* History Entry 정보 저장 */
			else
			{
				/* 입력 년도에 해당되는 것만 출력, Updated에서 년도를 추출하여 입력 값과 비교 */
				if(getYear.equals(updateds.get(i).text().substring(0, 4)))
				{
					/* 각 태그 Attribute를 출력 String에 저장 */
					System.out.println("--------------------------------------------------------------------------------------------------");
					inputStr += "--------------------------------------------------------------------------------------------------\r\n";
					System.out.println("Commit Id : " + ids.get(i).text());
					inputStr += "Commit Id : " + ids.get(i).text() + "\r\n";
					System.out.println("Updated Date : " + updateds.get(i).text());
					inputStr += "Updated Date : " + updateds.get(i).text() + "\r\n";
					System.out.println("Commit Context : " + titles.get(i).text());
					inputStr += "Commit Context : " + titles.get(i).text() + "\r\n";
					System.out.println("Author Name : " + names.get(i-1).text());
					inputStr +="Author Name : " + names.get(i-1).text() + "\r\n";
					System.out.println("Author Email : " + emails.get(i-1).text());
					inputStr += "Author Email : " + emails.get(i-1).text() + "\r\n";
				}
			}
		}
		
		/* 저장된 String과 경로, 경로명을 가지고 파일 생성 */
		new CreateFile(inputStr, gatefilePathName);
	}
}
