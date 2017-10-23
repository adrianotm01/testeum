package exemploAG;

import java.util.Random;

public class Genetico {
	private Random rand = new Random();
	private double taxaCruzamento;
	private double taxaMutacao;
	private boolean elitismo = true;
	private int maxGeracoes;
	private int tamPopulacao = 100;
	private Populacao populacao = new Populacao(100);
	
	public void gerarPopulacao(Populacao population, boolean elitismo){
		Populacao newPopulacao = new Populacao(population.getTamPopulation());
		if(elitismo){
			populacao.setIndividuo(population.getIndividuo(0));
		}
		while(newPopulacao.getNumIndividuos() < newPopulacao.getTamPopulation()){
			Individuo[] pais = selecao(population);
			Individuo filhos[] = new Individuo[2];	
			
			if(rand.nextDouble() <= taxaCruzamento){
				filhos = cruzamento(pais[1],pais[0]);
			}
			else{
				filhos[0] = new Individuo(pais[0].getGenes());
				filhos[1] = new Individuo(pais[1].getGenes());
			}
 		}
	}
	
	public Individuo[] selecao(Populacao pop){
		Populacao populacaoMedia = new Populacao(3);
		populacaoMedia.setIndividuo(pop.getIndividuo(rand.nextInt(pop.getTamPopulation())));
		populacaoMedia.setIndividuo(pop.getIndividuo(rand.nextInt(pop.getTamPopulation())));
		populacaoMedia.setIndividuo(pop.getIndividuo(rand.nextInt(pop.getTamPopulation())));
		
		populacaoMedia.ordenarPopulacao();
		
		Individuo[] pais = new Individuo[2];
		pais[0] = populacaoMedia.getIndividuo(0);
		pais[1] = populacaoMedia.getIndividuo(1);
		
		return pais;
	}
	
	public Individuo[] cruzamento(Individuo pais, Individuo pais2){
		
	}
	
	public static double getTaxaMutacao(){
		
		return 100;
	}
	public static void main(String[] args){

		
		
	}
	
}
