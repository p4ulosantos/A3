package Programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {
		
        // CRIAÇÃO DA LISTA PARA ARMAZENAR OS OBJETOS:
		
        List<Carro> carros = new ArrayList<>();

        // CADASTRO AUTOMÁTICO DE 7 OBJETOS:
        
        carros.add(new Carro("ABC123", "Volkswagen", "Gol", "Preto", 2018));
        carros.add(new Carro("DEF456", "Ford", "Fiesta", "Prata", 2019));
        carros.add(new Carro("GHI789", "Chevrolet", "Onix", "Branco", 2020));
        carros.add(new Carro("JKL012", "Fiat", "Palio", "Vermelho", 2017));
        carros.add(new Carro("MNO345", "Renault", "Sandero", "Azul", 2021));
        carros.add(new Carro("PQR678", "Toyota", "Corolla", "Cinza", 2019));
        carros.add(new Carro("STU901", "Honda", "Civic", "Prata", 2022));
        
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        // ESTRUTURA DE EXIBIÇÃO DO MENU:
        
        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarCarro(scanner, carros);
                    break;
                case 2:
                    listarCarros(carros);
                    break;
                case 3:
                    buscarEExibirCarro(scanner, carros);
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

	// METODO PARA EXIBIR O MENU:
	
    private static void exibirMenu() {
        System.out.println("==== MENU ====");
        System.out.println("1. Cadastrar carro");
        System.out.println("2. Listar carros");
        System.out.println("3. Buscar carro");
        System.out.println("4. Sair");
        System.out.print("Digite a opção desejada: ");
    }

    // MÉTODO PARA CADASTRAR UM CARRO:
    
    private static void cadastrarCarro(Scanner scanner, List<Carro> carros) {
        System.out.print("Digite a placa do carro: ");
        String placa = scanner.next();
        scanner.nextLine(); // LIMPA O BUFFER DO SCANNER

        System.out.print("Digite a marca do carro: ");
        String marca = scanner.nextLine();

        System.out.print("Digite o modelo do carro: ");
        String modelo = scanner.nextLine();

        System.out.print("Digite a cor do carro: ");
        String cor = scanner.nextLine();

        System.out.print("Digite o ano do carro: ");
        int ano = scanner.nextInt();

        carros.add(new Carro(placa, marca, modelo, cor, ano));
        System.out.println("Carro cadastrado com sucesso.");
    }

    // MÉTODO PARA LISTAR OS CARROS CADASTRADOS:
    
    private static void listarCarros(List<Carro> carros) {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
            return;
        }

        System.out.println("==== LISTA DE CARROS ====");
        System.out.printf("%-10s%-15s%-10s\n", "Placa", "Marca", "Modelo");
        System.out.println("-----------------------------");

        for (Carro carro : carros) {
            System.out.printf("%-10s%-15s%-10s\n", carro.getPlaca(), carro.getMarca(), carro.getModelo());
        }
    }

    // MÉTODO PARA BUSCAR E EXIBIR UM CARRO A PARTIR DA PLACA:
    
    private static void buscarEExibirCarro(Scanner scanner, List<Carro> carros) {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
            return;
        }

        System.out.print("Digite a placa do carro a ser buscado: ");
        String placaBusca = scanner.next();

        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placaBusca)) {
                System.out.println("==== CARRO ENCONTRADO ====");
                System.out.println("Placa: " + carro.getPlaca());
                System.out.println("Marca: " + carro.getMarca());
                System.out.println("Modelo: " + carro.getModelo());
                System.out.println("Cor: " + carro.getCor());
                System.out.println("Ano: " + carro.getAno());
                return;
            }
        }

        System.out.println("Carro não encontrado.");
    }
}

//CLASSE CARRO COM 5 ATRIBUTOS:

class Carro {
	
	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	private int ano;

	public Carro(String placa, String marca, String modelo, String cor, int ano) {
		
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.ano = ano;
	}
	
	//GET E SET

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
