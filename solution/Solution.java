package solution;
public class Solution {

	private int nbPers;
	private int[] sol;
	private int[][] tab;
	
	public Solution(int[] s,int p,int[][] t){
		this.sol = s;
		this.nbPers = p;
		this.tab = t;
	}
	
	public Solution(int i,int p,int[][] t){
		this.sol = new int[i];
		this.nbPers = p;
		this.tab = t;
		for(int j = 0;j<i;j++){
			this.sol[j] = -1;
		}
	}
	
	public int evaluation(){
		int[] pers = new int[this.nbPers];
		for(int i = 0;i<this.sol.length && this.sol[i] != -1;i++){
			pers[this.sol[i]]+=this.tab[this.sol[i]][i];
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
		boolean complete = true;
		int i = 0;
		while(i<this.sol.length){
			if(this.sol[i]==-1){
				complete = false;
				break;
			}else{
				i++;
			}
		}
		
		if(complete){
			int indice = 0;
			res = new Solution[this.sol.length*(this.nbPers - 1)];
			for(int j = 0;j<this.sol.length;j++){
				for(int k = 0;k<this.nbPers;k++){
					if(k!=this.sol[j]){
						res[indice] = new Solution(this.sol.length,this.nbPers,this.tab);
						for(int l = 0;l<this.sol.length;l++){
							res[indice].sol[l] = this.sol[l];
						}
						res[indice].sol[j] = k;
						indice++;
					}
				}
			}
		}else{
			res = new Solution[this.nbPers];
			for(int j = 0;j<this.nbPers;j++){
				res[j] = new Solution(this.sol.length,this.nbPers,this.tab);
				for(int k = 0;k<i;k++){
					res[j].sol[k] = this.sol[k];
				}
				res[j].sol[i] = j;
			}
		}
		return res;
	}
	
	public ArrayList<Solution> retourneVoisinage(){
		ArrayList<Solution> res = new ArrayLsit<Solution>();
		for(Solution s:this.getVoisins()){
			res.add(s);
		}
		return res;
	}
	
	public String toString(){
		String res = "";
		for(int i = 0;i<this.sol.length;i++){
			res += this.sol[i]+",";
		}
		return res;
	}
	
}
