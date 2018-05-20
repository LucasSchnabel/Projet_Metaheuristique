
public class Solution {

	private int nbPers;
	private int[] sol;
	
	public Solution(int[] s,int p){
		this.sol = s;
		this.nbPers = p;
	}
	
	public Solution(int i,int p){
		this.sol = new int[i];
		this.nbPers = p;
		for(int j = 0;j<i;j++){
			this.sol[j] = -1;
		}
	}
	
	public int evaluation(){
		int[] pers = new int[this.nbPers];
		for(int i = 0;i<this.sol.length && this.sol[i] != -1;i++){
			pers[this.sol[i]]++;
			i++;
		}
		int max = 0;
		for(int i = 0;i<this.nbPers;i++){
			if(pers[i]>max){
				max = pers[i];
			}
		}
		
		return max;
	}
	
	public Solution[] getVoisins(){
		Solution[] res;
		
		
		
		return res;
	}
	
	
}
