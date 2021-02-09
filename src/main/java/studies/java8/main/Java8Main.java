package studies.java8.main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import studies.java8.model.Java8ClientModel;
import studies.java8.model.Jaba8EmployeeModel;

public class Java8Main {
	public static void main(String[] args) {
		
		/* Interface Funcional */
		/* Client está implementando uma interface funcional. Uma interface funcional é uma interface que só pode ter um método abstrato. */
		Java8ClientModel c = new Java8ClientModel();
		c.setName("Artur");
		c.setUsername("Username");
		c.setPassword("Password");
		c.passwordAuthentication("Password");
		
		/* Métodos Padrões */
		/* Funcionário implementa uma interface com método padrão. O método isValidEmployee rodando é o default, neste caso. */
		Jaba8EmployeeModel f = new Jaba8EmployeeModel();
		f.setName("Ana");
		f.setCode("AFSW19");
		f.isValidEmployee(f.getCode());

		/* Classes anônimas */
		/* A forma convencional seria criar uma classe implementando Consumer<Client> e fazer a implementação do accept nela. */
		Consumer<Java8ClientModel> consumer = new Consumer<Java8ClientModel>() {
			public void accept(Java8ClientModel t) {
				System.out.println("Nome do Cliente: " + c.getName());
			}
		};
		List<Java8ClientModel> clientes = Arrays.asList(c);
		clientes.forEach(consumer);
		
		/* Referência ao método */
		/* É possível referenciar um método de uma instância da seguinte forma */
		clientes.forEach(Java8ClientModel::printName);
		
		/* Expressões Lambda */
		/* Faz a mesma coisa que uma estrutura de repetição. */
		clientes.forEach((Java8ClientModel k) -> {
			System.out.println("Nome do Cliente: " + k.getName());
		});
		
		/* Expressões Lambda */
		/* Esse tipo de expressão lambda só funciona com interfaces funcionais. Thread sempre deverá receber como parâmetro uma 
		   interface Runnable. Runnable é uma interface funcional, portanto o java entende que a única coisa
		   que pode ser chamada é o método run. Então, o () representa os parâmetros do método run, e o restante, sua implementação. */           
		new Thread(() -> {
			System.out.println("Olá mundo");
		}).run();
		
		/* Stream (Fluxo de Dados) */
		/* Um exemplo (de muitos) é método filter, onde podemos filtrar com alguma condição uma stream de dados. */
		List<Integer> asList = Arrays.asList(1, 2, 3, 4);
		asList.stream().filter(e -> e % 2 == 0).forEach(e -> {
			System.out.println(e);
		});
		
		/* Collectors */
		/* Podemos também filtrar e retornar uma nova lista usando o collect. */
		List<Integer> newList = asList.stream().filter(h -> h > 2).collect(Collectors.toList());
		newList.forEach(h -> {
			System.out.println(h);
		});
	}
}

