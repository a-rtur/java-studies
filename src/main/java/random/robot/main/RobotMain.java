package random.robot.main;

import java.awt.Robot;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RobotMain {

	public static void main(String[] args) throws Exception {
		while (true) {
			try {
				System.out.println("Por quantos minutos devo rodar?");
			    Scanner scanner = new Scanner(System.in);
				BigDecimal milliseconds = scanner.nextBigDecimal().multiply(new BigDecimal(60000));
				scanner.close();
				Robot r = new Robot();
				int loopCount = 1;
				while (loopCount <= milliseconds.divide(new BigDecimal(20000)).intValue()) {
					int x = (int) (Math.random() * 800 + 100);
					int y = (int) (Math.random() * 800 + 100);
					r.mouseMove(x, y);
					r.delay(20000);
					loopCount++;
				}
			    break;
			} catch (InputMismatchException ime) {
				System.out.println("Por favor, digite um número.");
			} catch (Exception e) {
				throw e;
			}
		}
		System.out.println("Programa acabou.");
	}
}