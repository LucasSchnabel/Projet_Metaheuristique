package solution;
public class test {

	public static void main(String[] args) {
		int nbPers = 4;
		int nbTaches = 4;
		Tableau t = new Tableau();
		int[][] tab = t.getTab(nbPers, nbTaches);
		Solution s = new Solution(4,4,tab);
		System.out.println(s);
		
		Solution tmp = s.getVoisins()[0];
		System.out.println(tmp);
		tmp = tmp.getVoisins()[0];
		System.out.println(tmp);
		tmp = tmp.getVoisins()[0];
		System.out.println(tmp);
		tmp = tmp.getVoisins()[0];
		System.out.println(tmp);
		for(Solution sol :tmp.getVoisins()){
			System.out.println(sol);
		}

	}

}
