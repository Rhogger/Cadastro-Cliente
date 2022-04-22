import java.util.Scanner;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		ArrayList<Pessoa> customList = new ArrayList<Pessoa>();

		int condition = 1;

		System.out.println("=-=-=-=-= Cadastro de Clientes =-=-=-=-=");

		while (condition == 1) {

			Pessoa customer = new Pessoa();

			System.out.println();

			String name;
			do {
				
				System.out.print("*Nome: ");
				name= input.nextLine();
				
			}while(customer.validationName(name) != true);
			
			customer.setName(name);
			System.out.println();

			System.out.print("*Telefone: ");
			customer.setPhoneNumber(input.nextLine());
			System.out.println();

			System.out.print("*E-mail: ");
			customer.setEmail(input.nextLine());
			System.out.println();

			System.out.print("*Endereço: ");
			customer.setAdress(input.nextLine());
			System.out.println();

			int qtd_cpf = 11, qtd_cnpj = 14;
			String entrance;
			do {
				do {
					System.out.println("*Insira CPF / CNPJ:  ");
					entrance = input.nextLine();
				} while (entrance.length() != qtd_cpf && entrance.length() != qtd_cnpj);

				if (entrance.length() == qtd_cpf) {
					customer.setNumDocument(entrance);
					
				} else {
					customer.setNumDocument(entrance);
				}
			} while (customer.validationCPF() == false && customer.CNPJisValid(entrance) == false);

			System.out.println("*Deseja manter o cadastro ativo? ");
			do {
				System.out.println("1- Sim");
				System.out.println("2- Não");
				System.out.println();
				System.out.print("Escolha: ");
				customer.validationStatus = input.nextInt();
				customer.setStatus();
			} while (customer.validationStatus != 1 && customer.validationStatus != 2);

			System.out.println();
			System.out.println();

			System.out.println("Deseja continuar cadastrando?");
			do {
				System.out.println("1- Sim");
				System.out.println("2- Não");
				System.out.println();
				System.out.print("Escolha: ");
				condition = input.nextInt();
			} while (condition != 1 && condition != 2);

			input.nextLine().substring(0, 0);

			customList.add(customer);

		}

		System.out.println("=-=-=-=-= Dados dos Clientes =-=-=-=-=");
		System.out.println();

		for (Pessoa p : customList) {

			System.out.printf("Nome: %s \n", p.getName());
			System.out.printf("Telefone: %s \n", p.getPhoneNumber());
			System.out.printf("E-mail: %s \n", p.getEmail());
			System.out.printf("Endereço: %s \n", p.getAdress());
			System.out.printf("CPF / CNPJ: %s \n", p.getNumDocument());
			System.out.printf("Status: %s ", p.getStatus());

			System.out.println();
			System.out.println();
		}

		System.out.println("=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=");

		input.close();
	}

}
