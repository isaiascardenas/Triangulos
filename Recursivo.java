
public class Recursivo
{
	private int currentLine;
	private int high;
	private String[] lines;
	private int maxArea;

	public Recursivo()
	{
		this.currentLine = 0;
		this.high = 0;
		this.lines = null;
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
		int area = 0;
		for (int i=0; i<this.high ; i++) {
			for (int j=0; j<lines[i].length(); j++) {
				if (lines[i].charAt(j) == '-') {
					if (j%2 == 0) {
						area = this.getDownArea(j, this.getEndPivot(j, this.lines[i]), 0);
					} else {
						area = this.getUpArea(j, 0);
					}
					if (area > this.maxArea) {
						this.maxArea = area;
					}
				}
			}
			this.currentLine++;
		}
		return this.maxArea;
	}


	private int getEndPivot(int pivot, String line)
	{
		int i = pivot;
		while(i<line.length() && line.charAt(i) == '-') {
			i++;
		}
		if (i%2 == 0) {
			return i-2;
		}
		return i-1;
	}

	private int getUpArea(int pivot, int row)
	{
		if (row+this.currentLine >= this.high) {
			return 0;
		}
		if (pivot-2*row <= 0 || pivot < 3) {
			return 0;	
		}
		if (pivot >= this.lines[row+this.currentLine].length()) {
			return 0;	
		}
		for (int i=pivot; i>pivot-2*row; i--) {
			if (this.lines[row+this.currentLine].charAt(i) == '#') {
				return 0;
			}
		}
		return 1 + 2*row + this.getUpArea(pivot, row+1);
	}

	private int getDownArea(int pivot, int endPivot, int row)
	{
		if (row+this.currentLine >= this.high) {
			return 0;
		}
		if (endPivot <= pivot) {
			return 1;
		}
		if (endPivot >= this.lines[row+this.currentLine].length()) {
			return 0;	
		}

		for (int i=pivot; i<=endPivot; i++) {
			if (this.lines[row + this.currentLine].charAt(i) == '#') {
				return 0;	
				}	
		}
		return endPivot - pivot + 1 + this.getDownArea(pivot, endPivot-2, row+1);
	}
}