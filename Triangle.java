
public class Triangle 
{

	private int currentLine;
	private int high;
	private String[] lines;
	private int pivot;
	private int maxArea;

	public Triangle()
	{
		this.currentLine = 0;
		this.high = 0;
		this.lines = null;
		this.pivot = 0;
		this.maxArea = 0;

	}
	
	public void setHigh(int high)
	{
		this.high = high;
	}

	public void setLines()
	{
		this.lines = new String[this.high];
	}

	public void setLine(int pos, String line)
	{
		this.lines[pos] = line;
	}

	public void setCurrentLine(String line)
	{
		int n = 1;
		for (int i = 0; i<line.length(); i++) {
				if (i+1 < line.length() && line.charAt(i+1) == '#') {
				this.currentLine = n/2;	
				return ;		
			}
			n++;
		}
		this.currentLine = n/2;
		return ;
	}

	public void setMaxArea(int area)
	{
		if (area > this.maxArea) {
			this.maxArea = area;
		}
	}

	public void setPivot(int pivot)
	{
		this.pivot = pivot;
	}

	//

	public String[] getLines()
	{
		return this.lines;
	}

	public String getLine(int pos)
	{
		return this.lines[pos];
	}

	public int getHigh()
	{
		return this.high;
	}
	
	public int getPivot()
	{
		return this.pivot;
	}

	//

	public boolean checkUpTriangle()
	{
		if (this.pivot >= 3 && this.pivot-2*(this.currentLine) > 0 && this.pivot < lines[this.currentLine].length()) {
			for (int i=this.pivot; i>this.pivot-2*(this.currentLine); i--) {
				if (this.lines[this.currentLine].charAt(i) == '#') {
					this.currentLine = 0;

					return false;
				}
			}
			return true;
		}
		this.currentLine = 0;

		return false;	
	}

	public boolean checkDownTriangle()
	{
		if (this.pivot < this.lines[this.currentLine].length()-2) {
			for (int i=this.pivot; i>this.pivot+2*(this.currentLine); i++) {
				if (this.lines[this.currentLine].charAt(i) == '#') {
					this.currentLine = 0;
					return false;
				}
			}
			return true;
		}
		this.currentLine = 0;

		return false;	
	}

	public int getArea(boolean isOdd)
	{
		int area = 0;
		if (isOdd) {
			while(this.checkUpTriangle()) {
				area += 2*this.currentLine+1;
				this.currentLine++;
			}
		} else {
			while(this.checkDownTriangle()) {
				area += 2*this.currentLine+1;
				this.currentLine++;
			}
		}
		
		return area;
	}

	public int getMaxArea()
	{
		for (int i=0; i<this.high; i++) {
			for (int j=0; j<this.lines[i].length(); j++) {
				if (this.lines[i].charAt(j) == '-' && j%2 ==1) {
					this.pivot = j;
					if (this.getArea(true) > this.maxArea) {
						this.maxArea = this.getArea(true);
					}	
				}
				else if (this.lines[i].charAt(j) == '-' && j%2 ==0) {
					this.pivot = j;
					this.setCurrentLine(this.lines[i]);
					
					if (this.getArea(false) > this.maxArea) {
						this.maxArea = this.getArea(false);
					}	
				}
			}
		}
		return this.maxArea;
	}
}
