package algo;

import generic.AlgorithmeAbstract;
import generic.ProblemeAbstract;
import generic.SolutionAbstract;
import solution.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * classe recuit simulé
 * <p>
 * herite de Algrotihme, à redefinir
 * <p>
 * attribut temperature
 * <p>
 * iteration doit - recuperer le voisinage - choisir au hasard un point - tirer
 * un nombre aleatoire - faire évoluer la temperature
 * 
 * 
 * @author vthomas
 * 
 */
public class RecuitSimule extends AlgorithmeAbstract {

	/**
	 * variation de temperature par iteration
	 */
	public double DELTA_TEMPERATURE = 0.99;

	/**
	 * la temperature qui décroit au cours du temps;
	 */
	double temperature;

	/**
	 * valeur de la solution en cours
	 */
	double valeurActuelleSolution = 0;

	/**
	 * constructeur
	 * 
	 * @param probleme
	 *            probleme à resoudre
	 * @param solutionInitiale
	 *            solution initiale fournie
	 * @param temperatuer
	 *            temperature initiale
	 */
	public RecuitSimule(ProblemeAbstract probleme,
			Solution solutionInitiale, double temperature) {
		super(probleme, solutionInitiale);
		this.temperature = temperature;
	}

	@Override
	/**
	 * lance une iteration.
	 * <p>
	 * A completer en utilisant les méthodes
	 * <ul>
	 * <li>choisirHasard
	 * <li>estAccepte
	 * </ul>
	 */
	public boolean ameliorerSolution() {
		// a completer en utilisant les méthodes
		int compteurAcceptation = 0;
		boolean fin = false;
		Solution solHasard = this.solutionEnCours;
		// on limite le nombre de tirages non accepte a un nombre maximal (1000)
		while (compteurAcceptation < 1000 && !fin) {
			// * choisirHasard
			solHasard = this.choisirHasard();
			// * estAccepte
			fin = this.estAcceptee(solHasard);
			compteurAcceptation++;
		}
		this.solutionEnCours = solHasard;
		if (this.problemeATraiter.evaluation(solutionEnCours) == this.problemeATraiter
				.evaluation(solHasard)) {
			return true;
		} else
			return false;
	}

	private Solution choisirHasard() {
		ArrayList<Solution> listVoisin = (ArrayList<Solution>) this.solutionEnCours
				.retourneVoisinage();
		int indexHasard = new Random().nextInt(listVoisin.size());
		// maj temp
		this.miseAJourTemperature();

		return listVoisin.get(indexHasard);
	}

	private void miseAJourTemperature() {
		this.temperature = this.temperature * DELTA_TEMPERATURE;
	}

	/**
	 * méthode stochastique pour savoir si une solution est validée
	 * 
	 * @param solutionAbstract
	 *            solution à comparer à la solution actuelle
	 * @return booleen qui valide ou non
	 */
	private boolean estAcceptee(Solution solution) {
		// a completer en utilisant probaMetropolis
		boolean accept = false;
		double evaluation = this.problemeATraiter.evaluation(solution);
		double evaluationEnCours = this.problemeATraiter
				.evaluation(solutionEnCours);
		if (evaluation < evaluationEnCours) {
			accept = true;
		} else {

			double delta = evaluation - evaluationEnCours;
			double p = this.probaMetropolis(delta);
			double random = new Random().nextDouble();
			if (p > random) {
				accept = true;
			}
		}
		return accept;
	}

	/**
	 * retourne la proba d'acceptation en fonction de la difference de valeur et
	 * de la temperature
	 * 
	 * @param deltaValeur
	 *            difference de valeur entre solution courante et la nouvelle
	 *            solution
	 * 
	 * @return probabilite d'accepter la nouvelle solution
	 */
	private double probaMetropolis(double deltaValeur) {
		return Math.exp(-deltaValeur / temperature);
	}

	/**
	 * par defaut on affiche aussi la temperature
	 */
	public String log() {
		return super.log() + "; T;" + temperature;
	}

}
