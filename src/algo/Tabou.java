package algo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import generic.AlgorithmeAbstract;
import generic.ProblemeAbstract;
import generic.SolutionAbstract;

/**
 * recherche taboue se fonde sur une liste taboue mise à jour a chaque nouvelle
 * acceptation
 * <p>
 * principe de la méthode pour chaque iteration
 * <ul>
 * <li>recuperer les voisins
 * <li>pour chaque solution, regarder si elle est valide grace à la liste taboue
 * <li>prendre la meilleure solution valide
 * <li>mettre à jour la liste taboue
 * </ul>
 * 
 * @author vthomas
 * 
 */
public class Tabou extends AlgorithmeAbstract {

	/**
	 * la liste taboue (definir une classe concrete)
	 */
	TabouFiltreAbstract tabou;

	/**
	 * constructeur
	 * 
	 * @param probleme
	 *            probleme à resoudre
	 * @param solutionInitiale
	 *            solution initiale
	 * @param taboue
	 *            liste taboue utilisee pour la recherche taboue
	 */
	public Tabou(ProblemeAbstract probleme, SolutionAbstract solutionInitiale, TabouFiltreAbstract taboue) {
		super(probleme, solutionInitiale);
		this.tabou = taboue;
	}

	@Override
	/**
	 * permet d'ameliorer la solution courante en utilisant une recherche taboue
	 */
	public boolean ameliorerSolution() {

		// a chaque iteration
		// on recupere les voisins 
		ArrayList<SolutionAbstract> voisinage = (ArrayList<SolutionAbstract>) this.solutionEnCours.retourneVoisinage();
		//et on filtre par le filtre tabou
		ArrayList<SolutionAbstract> autorisations = this.filtrer(voisinage);
		// on levera une Error en cas d'impossibilité (quand la liste taboue
		// bloque la recherche de la solution)
		if(autorisations.size() == 0) {
			throw new Error("Pas d'autorisation.");
		}else {
			this.solutionEnCours = this.chercherMeilleureSolution(autorisations);
			return true;
		}
		
		// penser à utiliser
		// 1) la méthode filtrer qui retourne la liste des solutions à conserver
		// 2) la methode chercherMeilleureSolution qui retourne la
		// meilleure solution à partir d'une liste de solution

	}

	/**
	 * trouve la meilleure solution dans une liste de solutions
	 * 
	 * @param solutionsVoisines
	 *            solutions dans laquelle chercher la meilleure
	 * 
	 * @return meilleure solution
	 */
	private SolutionAbstract chercherMeilleureSolution(List<SolutionAbstract> solutionsVoisines) {
		double min = this.problemeATraiter.evaluation(solutionEnCours);
		SolutionAbstract meilleure = this.solutionEnCours;
		for(SolutionAbstract s : solutionsVoisines) {
			double evalCourante = this.problemeATraiter.evaluation(s);
			if(evalCourante < min) {
				min = evalCourante;
				meilleure = s;
			}
		}
		return meilleure;
	}

	/**
	 * utilise le filtre taboue pour retirer les solutions non considérées dans
	 * la liste
	 * 
	 * @param solutionsVoisines
	 *            liste de solutions à filtrer, parametre modifié par la méthode
	 */

	private ArrayList<SolutionAbstract> filtrer(List<SolutionAbstract> solutionsVoisines) {
		ArrayList<SolutionAbstract> autorisations = new ArrayList<SolutionAbstract>();
		for(SolutionAbstract s : solutionsVoisines) {
			if(this.tabou.accepter(s)) {
				autorisations.add(s);
			}
		}
		return autorisations;
	}

}
