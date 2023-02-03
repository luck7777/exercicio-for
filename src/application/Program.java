package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Pessoas;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		double maiorAltura, menorAltura, mediaAltura;
		char genero;
				
		System.out.print("Quantas pessoas serão digitadas? ");
		
		int n = sc.nextInt();
		Pessoas[] vect = new Pessoas[n];
		
		for(int i=0; i<vect.length; i++) {
			sc.nextLine();
			System.out.printf("Altura da %d° pessoa: ", i+1);
			Double altura = sc.nextDouble();
			System.out.printf("Genero da %d° pessoa: ", i+1);
			genero = sc.next().charAt(0);
			while((genero != 'F') && (genero != 'f') && (genero != 'M') && (genero != 'm')) {
				System.out.print("Genero invalido, favor digite novamente (M ou F): ");
				genero = sc.next().charAt(0);				
			}
			vect[i] = new Pessoas(genero, altura);
		}
		
		menorAltura = vect[0].getAltura();
		int posicaoMenor = 0;
		for(int i=1; i<vect.length; i++) {
			if(vect[i].getAltura() < menorAltura) {
				menorAltura = vect[i].getAltura();
				posicaoMenor = i;
			}			
		}
		System.out.printf("Menor altura = %.2f%n", vect[posicaoMenor].getAltura());
		
		maiorAltura = vect[0].getAltura();
		int posicaoMaior = 0;
		for(int i=1; i<vect.length; i++) {
			if(vect[i].getAltura() > maiorAltura) {
				maiorAltura = vect[i].getAltura();
				posicaoMaior = i;
			}			
		}
		System.out.printf("Maior altura = %.2f%n", vect[posicaoMaior].getAltura());
		
		mediaAltura = 0.0;
		double somaAltura = 0.0;
		int contMulheres = 0;
		
		for(int i=0; i<vect.length; i++) {
			if(vect[i].getGenero() == 'F') {
				somaAltura += vect[i].getAltura();
				contMulheres += i - i + 1;
			}			
		}
		mediaAltura = somaAltura / contMulheres;
		System.out.printf("Media das alturas das Mulheres = %.2f%n", mediaAltura);
				
		int qtGenero = 0;
		for(int i=0; i<vect.length; i++) {
			if(vect[i].getGenero() == 'M') {
				qtGenero++;
			}			
		}
		System.out.println("Numero de Homens = " + qtGenero);
				
		sc.close();
	}
}
