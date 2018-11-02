package CommitModel;

import java.io.BufferedWriter;
import java.io.FileWriter;

/* CreteFile 최종적으로 경로에다가 String->.txt로 출력. */
public class CreateFile {
	private String outputstr = null;
	private String inputPath = null;

	/* 생성자 */
	public CreateFile(String getstr, String getfilePathName)
	{
		this.outputstr = getstr;
		inputPath = getfilePathName + ".txt";
		__doCreate(outputstr, inputPath);
	}
	
	
	/* 파일 생성 및 String 저장 */
	public void __doCreate(String txtstr, String path)
	{
		try
		{
			System.out.println(path);
			
			/* 객체 생성 */
			BufferedWriter fw = new BufferedWriter(new FileWriter(path, true));
			
			/* 내용 쓰기 */
			fw.write(txtstr);
			
			/* 비움  */
			fw.flush();
			fw.close();
			
		}
		catch(Exception e)
		{
			/* 에러 출력 */
			e.printStackTrace();
		}
		return;
	}
	
}
