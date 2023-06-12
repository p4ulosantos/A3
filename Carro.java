package Programa;

//Classe Carro que herda de Veiculo e adiciona 2 novos atributo

class Carro extends Veiculo {
		
	 private int numeroPortas;
	 private String cambio;
	
	 public Carro(String placa, String marca, String modelo, String cor, int ano, int numeroPortas, String cambio) {
	     super(placa, marca, modelo, cor, ano);
	     this.numeroPortas = numeroPortas;
	     this.cambio = cambio;
	 }
	 
	
	
	 public int getNumeroPortas() {
	     return numeroPortas;
	 }
	
	 public void setNumeroPortas(int numeroPortas) {
	     this.numeroPortas = numeroPortas;
	 }
	 
	 public String getTipoCambio() {
	     return cambio;
	 }
	
	 public void setTipoCambio(String cambio) {
	     this.cambio = cambio;
	 }
 
}
