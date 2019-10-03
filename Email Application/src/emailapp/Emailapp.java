package emailapp;

public class Emailapp {

	public static void main(String[] args) {
		Email em1 = new Email("Carlitos", "Salazar");
		
		/* em1.setAlternateEmail("\nbennn@gmail.com");
		 * System.out.println(em1.getAlternateEmail());
		 */
		
		System.out.print(em1.showInfo());
	}

}
