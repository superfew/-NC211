package th.ac.Utcc.NC231;

public class BubbleSortArray {
	private int[] element;
	private int eSize;
	
	public BubbleSortArray(int size) {
		if(size >0)
			this.element = new int[size];
		else
			this.element=new int[10];
		eSize=0;
	}
	
	public void insert(int e) {
		this.element[eSize]= e;
		eSize++;
	}
	
	public void show() {
		for(int i = 0; i< eSize; i++) {
			 System.out.print(this.element[i] + " ");
		}
		System.out.println("");
	}
	public void bubbleSort() {
		int out, in;
		
		for(out=eSize - 1; out >0; out--) {
			for(in=0; in < out; in++) {
				if(element[in] < element[in+1]) {
					int temp = element[in];
					element[in]=element[in+1];
					element[in+1]=temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int num = 20;
		BubbleSortArray bubbleSort = new BubbleSortArray(num);
		for(int i=0; i<num; i++) {
			bubbleSort.insert((int)(Math.random()*100.));
		}
		
		System.out.print("Before sorting: ");
		bubbleSort.show();
		
		bubbleSort.bubbleSort();
		System.out.print("After sorting: ");
		bubbleSort.show();
	}
}
