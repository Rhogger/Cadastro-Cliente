
public class Pessoa {

	// Restante dos Dados
	public int validationStatus;
	private String name, phoneNumber, email, adress;
	private boolean status;

	// CPF e CNPJ
	private String numDocument;
	private int weight, total = 0, rest, digit1, digit2;
	private boolean validation;

	public Pessoa() {

	}

	public Pessoa(int validationStatus, String name, String phoneNumber, String email, String adress, boolean status,
			String numDocument) {
		this.validationStatus = validationStatus;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.adress = adress;
		this.status = status;
		this.numDocument = numDocument;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

			if (hasAt == true && text.charAt(i) == 46 && hasDot == false) {
				hasDot = true;
			}
		}

		validation = hasAt && hasDot;

		return validation;

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

	// CPF

	public String getNumDocument() {
		return numDocument;
	}

	public void setNumDocument(String numDocument) {
		this.numDocument = numDocument;
	}

	public void validation_1st_digit_cpf() {
		for (int i = 0; i < 9; i++) {
			total += weight * Integer.parseInt(this.numDocument.substring(i, i + 1));
			weight--;
		}

		if (total % 11 < 2) {
			this.digit1 = 0;
		} else {
			rest = total % 11;
			this.digit1 = 11 - rest;
		}

		validation_2nd_digit_cpf();

	}

	public void validation_2nd_digit_cpf() {
		weight = 11;
		total = 0;

		for (int i = 0; i < 10; i++) {
			total += weight * Integer.parseInt(this.numDocument.substring(i, i + 1));
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
		validation_1st_digit_cpf();
		int p1 = Integer.parseInt(numDocument.substring(9, 10));
		int p2 = Integer.parseInt(numDocument.substring(10));

		if (numDocument == "11111111111" || numDocument == "22222222222" || numDocument == "33333333333"
				|| numDocument == "44444444444" || numDocument == "55555555555" || numDocument == "66666666666"
				|| numDocument == "77777777777" || numDocument == "88888888888" || numDocument == "99999999999") {
			validation = true;
		} else if (p1 == this.digit1 && p2 == this.digit2) {
			validation = true;
		} else {
			validation = false;
		}

		total = 0;
		return validation;
	}

	public int CNPJ_1st_digit(String text) {

		int weight = 2, total = 0, rest, digit1 = 0;

		for (int i = 11; i >= 0; i--, weight++) {
			
			if (weight == 10) {
				weight = 2;
			}
			
			String item = text.substring(i, i + 1);
			total += weight * Integer.parseInt(item);
			

		}

		if (total % 11 < 2) {
			this.digit1 = 0;
		} else {
			rest = total % 11;
			this.digit1 = 11 - rest;
		}

		return digit1;

	}

	public int CNPJ_2nd_digit(String text) {

		int weight = 2, total = 0, rest, digit2 = 0;

		for (int i = 12; i >= 0; i--, weight++) {

			if (weight == 10) {
				weight = 2;
			}
			
			total += weight * Integer.parseInt(text.substring(i, i + 1));


		}

		if (total % 11 < 2) {
			this.digit2 = 0;
		} else {
			rest = total % 11;
			this.digit2 = 11 - rest;
		}

		return digit2;

	}

	public boolean CNPJisValid(String text) {
		int digit1 = Integer.parseInt(text.substring(12, 13));
		int digit2 = Integer.parseInt(text.substring(13));
		
		boolean result = (digit1 == CNPJ_1st_digit(text)) && (digit2 == CNPJ_2nd_digit(text));

		return result;
	}

}
