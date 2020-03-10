
public class X {

	static void ss(int ire,int ity){
		int x=0;
		int y=0;
		while(ire>0){
			if(ity==0)
				break;
			else 
				if(ity==1)
					x=x+10;
				else
					y=y+20;
		}
		System.out.println(x);
		System.out.println(y);
	}
	public static void main(String[] args) {
		ss(2,2);

	}

}
