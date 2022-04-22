
public class Pessoa {

	public int validationStatus;
	private String name, phoneNumber, email, adress;
	private boolean status;

	private String num_cpf;
	private int weight = 10, total = 0, rest, digit1, digit2;
	private boolean validation;

	public Pessoa() {

	}

	public Pessoa(int validationStatus, String name, String phoneNumber, String email, String adress, boolean status,
			String num_cpf) {
		this.validationStatus = validationStatus;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.adress = adress;
		this.status = status;
		this.num_cpf = num_cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStatus() {
		if (this.status == true) {
			return "Ativo";
		} else {
			return "Inativo";
		}

	}

	public void setStatus() {
		if (validationStatus == 1) {
			this.status = true;
		} else if (validationStatus == 2) {
			this.status = false;
		}
	}

	@Override
	public String toString() {
		return "Nome: " + name + "\nTelefone: " + phoneNumber + "\nE-mail: " + email + "\nEndereço: " + adress
				+ "Status: " + getStatus() + "\n\n";
	}

	public String getNum_cpf() {
		return num_cpf;
	}

	public void setNum_cpf(String num_cpf) {
		this.num_cpf = num_cpf;
	}

	public void validation_1st_digit() {
		for (int i = 0; i < 9; i++) {
			total += weight * Integer.parseInt(this.num_cpf.substring(i, i + 1));
			weight--;
		}

		if (total % 11 < 2) {
			this.digit1 = 0;
		} else {
			rest = total % 11;
			this.digit1 = 11 - rest;
		}

		validation_2nd_digit();

	}

	public void validation_2nd_digit() {
		weight = 11;
		total = 0;

		for (int i = 0; i < 10; i++) {
			total += weight * Integer.parseInt(this.num_cpf.substring(i, i + 1));
			weight--;
		}

		if (total % 11 < 2) {
			this.digit2 = 0;
		} else {
			rest = total % 11;
			this.digit2 = 11 - rest;
		}

	}

	public boolean validationCPF() {
		validation_1st_digit();
		int p1 = Integer.parseInt(num_cpf.substring(9, 10));
		int p2 = Integer.parseInt(num_cpf.substring(10));

		if (num_cpf == "11111111111" || num_cpf == "22222222222" || num_cpf == "33333333333" || num_cpf == "44444444444"
				|| num_cpf == "55555555555" || num_cpf == "66666666666" || num_cpf == "77777777777"
				|| num_cpf == "88888888888" || num_cpf == "99999999999") {
			validation = true;
		} else if (p1 == this.digit1 && p2 == this.digit2) {
			validation = true;
		} else {
			validation = false;
		}

		total = 0;
		return validation;
	}

	public int getTotal() {
		return total;
	}

	public boolean validationName(String text) {
		
		validation = true;

		for (int i = 0; i < text.length(); i++) {

			if ((text.charAt(i) < 65 || text.charAt(i) > 90) && (text.charAt(i) < 97 || text.charAt(i) > 122)) {
				this.validation = false;
				break;
			}
		}

		return validation;
	}

	public boolean validationEmail(String text) {
		
		// @
		boolean hasAt = false;
		// .
		boolean hasDot = false;
		
		validation = true;
		
		for (int i = 0; i < text.length(); i++) {

			if (text.charAt(i) == 64 && hasAt == false) {
				hasAt = true;
			}
			
			if(hasAt == true && text.charAt(i) == 46 && hasDot == false) {
				hasDot = true;
			}
		}
		

		validation = hasAt && hasDot;
		
		return validation ;
		
	}

}
