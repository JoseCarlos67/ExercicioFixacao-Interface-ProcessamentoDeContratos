package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner scanner = new Scanner(System.in);

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    System.out.println("Entre com os dados do contrato");
    System.out.print("Numero: ");
    int numberOfContract = scanner.nextInt();
    System.out.print("Data (dd/MM/yyyy): ");
    LocalDate dateOfContract = LocalDate.parse(scanner.next(), fmt);
    System.out.print("Valor do contrato: ");
    double valueOfContract = scanner.nextDouble();

    Contract contract = new Contract(numberOfContract, dateOfContract, valueOfContract);

    System.out.print("Entre com o número de parcelas: ");
    int numberOfInstalment = scanner.nextInt();

    ContractService contractService = new ContractService(new PaypalService());

    contractService.processContract(contract, numberOfInstalment);

    System.out.println("Parcelas:");
    for (Installment installment : contract.getInstallmentList()) {
      System.out.println(installment);
    }

    scanner.close();
  }
}
