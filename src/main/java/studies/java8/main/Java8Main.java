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
		/* Client est� implementando uma interface funcional. Uma interface funcional � uma interface que s� pode ter um m�todo abstrato. */
		Java8ClientModel c = new Java8ClientModel();
		c.setName("Artur");
		c.setUsername("Username");
		c.setPassword("Password");
		c.passwordAuthentication("Password");
		
		/* M�todos Padr�es */
		/* Funcion�rio implementa uma interface com m�todo padr�o. O m�todo isValidEmployee rodando � o default, neste caso. */
		Jaba8EmployeeModel f = new Jaba8EmployeeModel();
		f.setName("Ana");
		f.setCode("AFSW19");
		f.isValidEmployee(f.getCode());

		/* Classes an�nimas */
		/* A forma convencional seria criar uma classe implementando Consumer<Client> e fazer a implementa��o do accept nela. */
		Consumer<Java8ClientModel> consumer = new Consumer<Java8ClientModel>() {
			public void accept(Java8ClientModel t) {
				System.out.println("Nome do Cliente: " + c.getName());
			}
		};
		List<Java8ClientModel> clientes = Arrays.asList(c);
		clientes.forEach(consumer);
		
		/* Refer�ncia ao m�todo */
		/* � poss�vel referenciar um m�todo de uma inst�ncia da seguinte forma */
		clientes.forEach(Java8ClientModel::printName);
		
		/* Express�es Lambda */
		/* Faz a mesma coisa que uma estrutura de repeti��o. */
		clientes.forEach((Java8ClientModel k) -> {
			System.out.println("Nome do Cliente: " + k.getName());
		});
		
		/* Express�es Lambda */
		/* Esse tipo de express�o lambda s� funciona com interfaces funcionais. Thread sempre dever� receber como par�metro uma 
		   interface Runnable. Runnable � uma interface funcional, portanto o java entende que a �nica coisa
		   que pode ser chamada � o m�todo run. Ent�o, o () representa os par�metros do m�todo run, e o restante, sua implementa��o. */           
		new Thread(() -> {
			System.out.println("Ol� mundo");
		}).run();
		
		/* Stream (Fluxo de Dados) */
		/* Um exemplo (de muitos) � m�todo filter, onde podemos filtrar com alguma condi��o uma stream de dados. */
		List<Integer> asList = Arrays.asList(1, 2, 3, 4);
		asList.stream().filter(e -> e % 2 == 0).forEach(e -> {
			System.out.println(e);
		});
		
		/* Collectors */
		/* Podemos tamb�m filtrar e retornar uma nova lista usando o collect. */
		List<Integer> newList = asList.stream().filter(h -> h > 2).collect(Collectors.toList());
		newList.forEach(h -> {
			System.out.println(h);
		});
	}
}

