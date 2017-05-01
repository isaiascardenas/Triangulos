
public class Iterativo 
{
	private int currentLine;
	private int high;
	private String[] lines;
	private int pivot;
	private int maxArea;

	public void Iterativo()
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

	public int getMaxArea()
	{
		this.setUpArea();
		this.setDownArea();
		return this.maxArea;
	}

	private boolean checkUpTriangle()
	{
		if (this.pivot >= 3 && this.pivot-2*this.currentLine > 0 && this.pivot < lines[this.currentLine].length()) {
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

	private boolean checkDownTriangle(int row)
	{
		if (this.currentLine >= 0) {
			for (int i=this.pivot; i<=this.pivot+2*row; i++) {
				if (this.lines[this.currentLine].charAt(i) == '#') {
					return false;
				}
			}
			return true;
		}
		return false;	
	}

	private void setUpArea()
	{
		int area = 0;
		this.currentLine = 0;
		for (int i=0; i<this.high; i++) {
			for (int j=0; j<this.lines[i].length(); j++) {
				if (this.lines[i].charAt(j) == '-' && j%2 == 1) {
					this.pivot = j;
					while(this.checkUpTriangle()) {
						area += 2*this.currentLine+1;
						this.currentLine++;
					}
					if (area > this.maxArea) {
						this.maxArea = area;
					}	
					area = 0;
				}
			}
		}
	}

	private void setDownArea()
	{
		int area = 0;
		for (int i=this.high-1; i>=0; i--) {
			this.currentLine = i;
			for (int j=0; j<this.lines[i].length(); j++) {
				if (this.lines[i].charAt(j) == '-' && j%2 == 0) {
					this.pivot = j;
					int row = 0;
					while(this.checkDownTriangle(row)) {
						area += 2*row+1;
						row++;
						this.currentLine--;
					}
					if (area > this.maxArea) {
						this.maxArea = area;
					}	
					area = 0;
				}
			}
		}
	}
}
