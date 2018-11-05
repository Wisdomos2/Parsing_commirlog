package CommitModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VariableModel {
	static private int maxYear = 0;
	static private int pgCount = 11;
	static private int minYear = 2015;
	
	public int getMinYear() {
		return minYear;
	}

	public void setMinYear(int minYear) {
		VariableModel.minYear = minYear;
	}

	public int getMaxYear() {
		return maxYear;
	}

	public void setMaxYear(int maxYear) {
		VariableModel.maxYear = maxYear;
	}

	public int getPgCount() {
		return pgCount;
	}

	public void setPgCount(int pgCount) {
		VariableModel.pgCount = pgCount;
	}


	
	public void pgDatainit()
	{
		Date dt = new Date();
		SimpleDateFormat day = new SimpleDateFormat("yyyy");
		maxYear = Integer.parseInt(day.format(dt));
	}
}
