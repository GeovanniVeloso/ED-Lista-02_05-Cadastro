package model;

public class Cliente {

	private String cpf;
	private String name;
	private int age;
	private double credit_limit;
	
	public Cliente(String cpf, String name, int age, double credit_limit) {
		this.cpf = cpf;
		this.name = name;
		this.age = age;
		this.credit_limit = credit_limit;
	}

	public String getCpf() {
		return cpf;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getCredit_limit() {
		return credit_limit;
	}
	
	

}
