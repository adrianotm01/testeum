package exemploAG;

import java.util.Arrays;
import java.util.Random;

public class Individuo implements Comparable<Individuo>{
	private Random random = new Random();
	private Double aptidao;
	
	//atributos do problema especifico
	private double qtdLigaBaixaResistencia;
	private double qtdLigaAltaResistencia;
	
	//cria um individuo aleatorio da primeira geracao
	public Individuo() {
		do {
			this.setQtdLigaBaixaResistencia();
			this.setQtdLigaAltaResistencia();
		} while (!validar());
		funcaoObjetivo();
	}

	// cria um individuo a partir de genes definidos
	public Individuo(double[] genes) {
		qtdLigaBaixaResistencia = genes[0];
		qtdLigaAltaResistencia = genes[1];

		//testa se deve fazer mutacao
		if (random.nextDouble() <= Genetico.getTaxaMutacao()) {
			
			int posAleatoria = random.nextInt(genes.length); //define gene que sera mutado
			mutacao(posAleatoria);
		}
		funcaoObjetivo();
	}

	public boolean validar() {
		double cobre = 0.5 * qtdLigaBaixaResistencia + 0.2 * qtdLigaAltaResistencia;
		double zinco = 0.25 * qtdLigaBaixaResistencia + 0.3 * qtdLigaAltaResistencia;
		double chumbo = 0.25 * qtdLigaBaixaResistencia + 0.5 * qtdLigaAltaResistencia; 
		if (cobre <= 16 && zinco <= 11 && chumbo <= 15)
			return true;
		return false;
	}

	public void mutacao(int posicao) {
		do {
			if (posicao == 0)
				this.setQtdLigaBaixaResistencia();
			else if (posicao == 1)
				this.setQtdLigaAltaResistencia();
		} while (!validar());

	}


	public double getAptidao() {
		return aptidao;
	}

	public double[] getGenes() {
		return new double[]{qtdLigaBaixaResistencia,qtdLigaAltaResistencia };
	}

	public void funcaoObjetivo() {
		aptidao = 3000*qtdLigaBaixaResistencia + 5000*qtdLigaAltaResistencia;
	}

	@Override
	public String toString() {
		return "Cromossomo " + Arrays.toString(getGenes()) + "\n";
	}

	@Override
	public int compareTo(Individuo i) {
		return this.aptidao.compareTo(i.aptidao);
	}

	public double getQtdLigaAltaResistencia() {
		return qtdLigaAltaResistencia;
	}

	public void setQtdLigaAltaResistencia(double qtdLigaAltaResistencia) {
		this.qtdLigaAltaResistencia = qtdLigaAltaResistencia;
	}

	public double getQtdLigaBaixaResistencia() {
		return qtdLigaBaixaResistencia;
	}

	public void setQtdLigaBaixaResistencia(double qtdLigaBaixaResistencia) {
		this.qtdLigaBaixaResistencia = qtdLigaBaixaResistencia;
	}
	
	public void setQtdLigaAltaResistencia(){
		this.qtdLigaAltaResistencia = random.nextDouble();
	}
	
	public void setQtdLigaBaixaResistencia(){
		this.qtdLigaBaixaResistencia = random.nextDouble();
	}
}
