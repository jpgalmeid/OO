import java.util.Scanner;

public class Index {

	static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Data years[] = new Data[10];
		
		for(int i = 0; i < 10; i++) {
			years[i] = new Data();
		}
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 12; j++) {
				if(j == 1) {
					if(i == 1 || i == 5 || i == 9)
						years[i].diasMes[j] = 29;
					else
						years[i].diasMes[j] = 28;
				}
				else if((j <= 6 && j % 2 == 0) || (j >= 7 && j % 2 != 0))
					years[i].diasMes[j] = 31;
				else
					years[i].diasMes[j] = 30;
			}
		}
		
		jan2020(years);
		int op = 0;
		do {
			op = menu();
			switch(op) {
				case 1:
					inserirTemperaturas(years);
					System.out.println("Temperaturas Inseridas!\n");
					break;
					
				case 2:
					calculoMedia(years);
					break;
					
				case 3:
					minima(years);
					break;
					
				case 4:
					maxima(years);
					break;
					
				case 5:
					relatorio(years);
					break;
					
				case 9:
					System.out.println("Saindo...\n");
					break;
					
				default:
					System.out.println("Operação Inválida!");
					
			}
		} while (op != 9);
	}
	
	public static int menu() {
		System.out.println("Bem vindo ao Instituto Nacional de Meteorologia");
		System.out.println("O que deseja fazer:");
		System.out.println("1. Inserir temperaturas");
		System.out.println("2. Cálcular a temperatura média");
		System.out.println("3. Cálcular a temperatura mínima");
		System.out.println("4. Cálcular a temperatura máxima");
		System.out.println("5. Receber o relatório meteorológico");
		System.out.println("9. Sair");
		int op = ler.nextInt();
		return op;
	}
	
	public static void inserirTemperaturas(Data years[]) {
		System.out.println("Escolha um ano entre 2011 e 2020: ");
		int ano = ler.nextInt();
		while (ano < 2011 || ano > 2020) {
			System.out.println("Ano Inválido!");
			System.out.println("Por favor escolha um válido (2011 a 2020): ");
			ano = ler.nextInt();
		}
		ano -= 2011;
		
		System.out.println("Escolha um mes entre 1 e 12: ");
		int mes = ler.nextInt();
		while (mes < 1 || mes > 12) {
			System.out.println("Mes Inválido!");
			System.out.println("Por favor escolha um mes válido (1 a 12): ");
			mes = ler.nextInt();
		}
		mes -= 1;
		
		double sum = 0;
		int n = years[ano].diasMes[mes];
		
		for(int i = 0; i < n; i++) {
			System.out.println("Temperatura do dia " + (i+1) + ":\n");
			years[ano].temperaturas[mes][i] = ler.nextDouble();
			sum += years[ano].temperaturas[mes][i];
		}
		
		double min = years[ano].temperaturas[mes][0];
		double max = years[ano].temperaturas[mes][0];
		
		for(int i = 1; i < n; i++) {
			if (years[ano].temperaturas[mes][i] < min)
				min = years[ano].temperaturas[mes][i];
			if (years[ano].temperaturas[mes][i] > max)
				max = years[ano].temperaturas[mes][i];
		}
		
		years[ano].media[mes] = sum/n;
		years[ano].min[mes] = min;
		years[ano].max[mes] = max;
		years[ano].full[mes] = true;
	}
	
	public static void calculoMedia(Data years[]) {
		System.out.println("Escolha um ano entre 2011 e 2020: ");
		int ano = ler.nextInt();
		while (ano < 2011 || ano > 2020) {
			System.out.println("Ano Inválido!");
			System.out.println("Por favor escolha um válido (2011 a 2020): ");
			ano = ler.nextInt();
		}
		ano -= 2011;
		
		System.out.println("Escolha um mes entre 1 e 12: ");
		int mes = ler.nextInt();
		while (mes < 1 || mes > 12) {
			System.out.println("Mes Inválido!");
			System.out.println("Por favor escolha um mes válido (1 a 12): ");
			mes = ler.nextInt();
		}
		mes -= 1;
		
		if (years[ano].full[mes] == false)
			System.out.println("Não há dados registrados!\n");
		
		else	
			System.out.println("A media de temperatura foi de: " + years[ano].media[mes] + "\n");
	}
	
	public static void minima(Data years[]) {
		System.out.println("Escolha um ano entre 2011 e 2020: ");
		int ano = ler.nextInt();
		while (ano < 2011 || ano > 2020) {
			System.out.println("Ano Inválido!");
			System.out.println("Por favor escolha um válido (2011 a 2020): ");
			ano = ler.nextInt();
		}
		ano -= 2011;
		
		System.out.println("Escolha um mes entre 1 e 12: ");
		int mes = ler.nextInt();
		while (mes < 1 || mes > 12) {
			System.out.println("Mes Inválido!");
			System.out.println("Por favor escolha um mes válido (1 a 12): ");
			mes = ler.nextInt();
		}
		mes -= 1;
		
		if (years[ano].full[mes] == false)
			System.out.println("Não há dados registrados!\n");
		
		else 
			System.out.println("A temperatura minima foi de: " + years[ano].min[mes] + "\n");
	}
	
	public static void maxima(Data years[]) {
		System.out.println("Escolha um ano entre 2011 e 2020: ");
		int ano = ler.nextInt();
		while (ano < 2011 || ano > 2020) {
			System.out.println("Ano Inválido!");
			System.out.println("Por favor escolha um válido (2011 a 2020): ");
			ano = ler.nextInt();
		}
		ano -= 2011;
		
		System.out.println("Escolha um mes entre 1 e 12: ");
		int mes = ler.nextInt();
		while (mes < 1 || mes > 12) {
			System.out.println("Mes Inválido!");
			System.out.println("Por favor escolha um mes válido (1 a 12): ");
			mes = ler.nextInt();
		}
		mes -= 1;
		
		if (years[ano].full[mes] == false)
			System.out.println("Não há dados registrados!\n");
		else	
			System.out.println("A temperatura maxima foi de: " + years[ano].max[mes] + "\n");
	}
	
	public static void relatorio(Data years[]) {
		System.out.println("Escolha um ano entre 2011 e 2020: ");
		int ano = ler.nextInt();
		while (ano < 2011 || ano > 2020) {
			System.out.println("Ano Inválido!");
			System.out.println("Por favor escolha um válido (2011 a 2020): ");
			ano = ler.nextInt();
		}
		ano -= 2011;
		
		System.out.println("Escolha um mes entre 1 e 12: ");
		int mes = ler.nextInt();
		while (mes < 1 || mes > 12) {
			System.out.println("Mes Inválido!");
			System.out.println("Por favor escolha um mes válido (1 a 12): ");
			mes = ler.nextInt();
		}
		mes -= 1;
		
		if (years[ano].full[mes] == false)
			System.out.println("Não há dados registrados!\n");
		else {
			int n = years[ano].diasMes[mes];
			for(int i = 0; i < n; i++)
				System.out.println("A media de temperatura do dia " + (i+1) + " foi de: " + years[ano].temperaturas[mes][i] + "\n");
			
			System.out.println("A media de temperatura foi de: " + years[ano].media[mes] + "\n");
			System.out.println("A temperatura minima foi de: " + years[ano].min[mes] + "\n");
			System.out.println("A temperatura maxima foi de: " + years[ano].max[mes] + "\n");
		}
	}
	
	public static void jan2020(Data years[]) {
		double upper = 100;
		double lower = -100;
		int ano = 9;
		int mes = 0;
		
		int n = years[ano].diasMes[mes];
		double sum = 0;
		
		for (int i = 0; i < n; i++) {
			double r = (double) (Math.random() * (upper - lower)) + lower;
			years[ano].temperaturas[mes][i] = r;
			sum += r;
		}
		
		double min = years[ano].temperaturas[mes][0];
		double max = years[ano].temperaturas[mes][0];
		
		for(int i = 1; i < n; i++) {
			if (years[ano].temperaturas[mes][i] < min)
				min = years[ano].temperaturas[mes][i];
			if (years[ano].temperaturas[mes][i] > max)
				max = years[ano].temperaturas[mes][i];
		}
		
		years[ano].media[mes] = sum/n;
		years[ano].min[mes] = min;
		years[ano].max[mes] = max;
		years[ano].full[mes] = true;
	}
	
}
