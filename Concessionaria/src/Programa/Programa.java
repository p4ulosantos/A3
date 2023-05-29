package Programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe principal de execução do programa

public class Programa {
    public static void main(String[] args) {
    	
        // Criação da lista para armazenar os objetos
    	
        List<Veiculo> listaVeiculos = new ArrayList<>();

        // Cadastro automático de pelo menos 7 objetos
        
        listaVeiculos.add(new Veiculo("ABC123", "Volkswagen", "Delivery", "Branco", 2019));
        listaVeiculos.add(new Carro("DEF456", "Ford", "Fiesta", "Prata", 2019, 4, "Automático"));
        listaVeiculos.add(new Carro("GHI789", "Chevrolet", "Onix", "Branco", 2020, 4, "Manual"));
        listaVeiculos.add(new Carro("JKL012", "Fiat", "Palio", "Vermelho", 2017, 4, "Manual"));
        listaVeiculos.add(new Carro("MNO345", "Renault", "Sandero", "Azul", 2021, 4, "Manual"));
        listaVeiculos.add(new Carro("PQR678", "Toyota", "Corolla", "Cinza", 2019, 4, "Semi-Automático"));
        listaVeiculos.add(new Carro("PQR696", "Ferrari", "488", "Vermelho", 2020, 2, "Semi-Automático"));
        
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
          
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarVeiculo(scanner, listaVeiculos);
                    break;
                case 2:
                    listarVeiculos(listaVeiculos);
                    break;
                case 3:
                    buscarEExibirVeiculo(scanner, listaVeiculos);
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 4);
    }

    // Exibe o menu de opções para o usuário
    
    private static void exibirMenu() {
        System.out.println("=========== MENU ===========");
        System.out.println("");
        System.out.println("(1) Cadastrar um veículo");
        System.out.println("(2) Listar os veículos");
        System.out.println("(3) Buscar um veículo");
        System.out.println("(4) Sair");
        System.out.println("");
        System.out.print("Digite a opção desejada: ");
      
    }

    // Método para cadastrar um veículo
    
    private static void cadastrarVeiculo(Scanner scanner, List<Veiculo> listaVeiculos) {
    	
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.next();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("Digite a marca do veículo: ");
        String marca = scanner.nextLine();

        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();

        System.out.print("Digite a cor do veículo: ");
        String cor = scanner.nextLine();

        System.out.print("Digite o ano do veículo: ");
        int ano = scanner.nextInt();

        System.out.print("Digite o número de portas do carro: ");
        int numeroPortas = scanner.nextInt();
        
        System.out.print("Digite o tipo de câmbio do carro: ");
        String cambio = scanner.next();

        // Cria um objeto Carro e adiciona na lista de veículos
        
        listaVeiculos.add(new Carro(placa, marca, modelo, cor, ano, numeroPortas, cambio));
        System.out.println("Veículo cadastrado com sucesso.");
    }

    // Método para listar os veículos cadastrados
    
    private static void listarVeiculos(List<Veiculo> listaVeiculos) {
       
    	if (listaVeiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        System.out.println("==== LISTA DE VEÍCULOS ====");
        System.out.printf("%-10s%-15s%-10s\n", "Placa", "Marca", "Modelo");
        System.out.println("-----------------------------");
         
        for (Veiculo veiculo : listaVeiculos) {
            System.out.printf("%-10s%-15s%-10s\n", veiculo.getPlaca(), veiculo.getMarca(), veiculo.getModelo());
        }
    }

    // Método para buscar e exibir um veículo a partir da placa
    
    private static void buscarEExibirVeiculo(Scanner scanner, List<Veiculo> listaVeiculos) {
        if (listaVeiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        System.out.print("Digite a placa do veículo a ser buscado: ");
        String placaBusca = scanner.next();

        //Percorre cada item(veiculo) da classe (Veiculo) na lista (listaVeiculos)
        
        for (Veiculo veiculo : listaVeiculos) {
        	
            if (veiculo.getPlaca().equals(placaBusca)) {
                System.out.println("==== VEÍCULO ENCONTRADO ====");
                System.out.println("Placa: " + veiculo.getPlaca());
                System.out.println("Marca: " + veiculo.getMarca());
                System.out.println("Modelo: " + veiculo.getModelo());
                System.out.println("Cor: " + veiculo.getCor());
                System.out.println("Ano: " + veiculo.getAno());

                // Verifica se o veículo é do tipo Carro
                
                if (veiculo instanceof Carro) {
                	
                    Carro carro = (Carro) veiculo;
                    System.out.println("Número de Portas: " + carro.getNumeroPortas());
                    System.out.println("Tipo de Câmbio: " + carro.getTipoCambio());
                }    

                return;
            }
        }

        System.out.println("Veículo não encontrado.");
    }
}

// Classe Veiculo com 5 atributos

class Veiculo {
	
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private int ano;

    public Veiculo(String placa, String marca, String modelo, String cor, int ano) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
    }

    //gets e sets
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}

// Classe Carro que herda de Veiculo e adiciona 2 novos atributo

class Carro extends Veiculo {
    private int numeroPortas;
    private String cambio;

    public Carro(String placa, String marca, String modelo, String cor, int ano, int numeroPortas, String cambio) {
        super(placa, marca, modelo, cor, ano);
        this.numeroPortas = numeroPortas;
        this.cambio = cambio;
    }
    
    //gets e sets
   
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
