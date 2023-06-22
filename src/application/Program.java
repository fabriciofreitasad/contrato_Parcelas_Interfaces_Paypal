package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contrato;
import entities.Prestacao;
import services.ContratoService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		DateTimeFormatter  fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato: ");
		System.out.print("Numero:");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(),fmt);
		System.out.print("Valor do contrato: ");
		double valorTotal = sc.nextDouble();
		
		Contrato contrato = new Contrato(number, date, valorTotal);
		
		System.out.print("Entre com o numero de parcelas: ");
		int n = sc.nextInt();
		
		ContratoService contratoService = new ContratoService(new PaypalService());
		
		contratoService.processContrato(contrato, n);
		
		System.out.println("Parcelas:");
		
		for(Prestacao prestacao : contrato.getPrestacao()) {
			System.out.println(prestacao);
		}
		
		
		sc.close();

	}

}
