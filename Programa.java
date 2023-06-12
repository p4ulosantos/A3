package Programa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Classe principal de execução do programa

public class Programa {
	
    public static void main(String[] args) {
    	
        // Criação da lista para armazenar os veiculos
    	
        List<Veiculo> listaVeiculos = new ArrayList<>();

        // Cadastro automático de veiculos
        
        listaVeiculos.add(new Veiculo("ABC123", "Volkswagen", "Delivery", "Branco", 2019));
        listaVeiculos.add(new Veiculo("ABC456", "Yamaha", "NMAX", "Vermelha", 2019));
        listaVeiculos.add(new Carro("DEF456", "Ford", "Fiesta", "Prata", 2019, 4, "Automático"));
        listaVeiculos.add(new Carro("GHI789", "Chevrolet", "Onix", "Branco", 2020, 4, "Manual"));
        listaVeiculos.add(new Carro("JKL012", "Fiat", "Palio", "Vermelho", 2017, 4, "Manual"));
        listaVeiculos.add(new Carro("MNO345", "Renault", "Sandero", "Azul", 2021, 4, "Manual"));
        listaVeiculos.add(new Carro("PQR678", "Toyota", "Corolla", "Cinza", 2019, 4, "Semi-Automático"));
        listaVeiculos.add(new Carro("PQR696", "Ferrari", "488", "Vermelho", 2020, 2, "Semi-Automático"));
        
        Scanner scanner = new Scanner(System.in);
        String opcao;
        
        do {
            exibirMenu();
          
            opcao = scanner.next();
            

            switch (opcao) {
                case "1":
                	
                    cadastrarVeiculo(scanner, listaVeiculos);
                    break;
                    
                case "2":
                    listarVeiculos(listaVeiculos);
                    break;
                case "3":
                    buscarEExibirVeiculo(scanner, listaVeiculos);
                    break;
                	
                case "4":
                	RemoverVeiculo(scanner, listaVeiculos);
                    break;
                case "5":
                	modificarVeiculo(scanner, listaVeiculos);
                    break;
                case "6":
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != "6");
    }

    // Exibe o menu de opções para o usuário
    
    private static void exibirMenu() {
		
        System.out.println("=========== MENU ===========");
        System.out.println("");
        System.out.println("1 - Cadastrar um veículo");
        System.out.println("2 - Listar os veículos");
        System.out.println("3 - Buscar um veículo");
        System.out.println("4 - Remover um veículo");
        System.out.println("5 - Modificar um veículo");     
        System.out.println("6 - Sair");
        System.out.println("");
        System.out.print("Digite a opção desejada: ");
      
    }

    // Método para cadastrar um veículo
    
    private static void cadastrarVeiculo(Scanner scanner, List<Veiculo> listaVeiculos) {
    	
    	String opcaoCadastro;
    	
    	System.out.println("O veículo que deseja cadastrar é um carro?: ");
    	System.out.println("1 - Sim");
    	System.out.println("2 - Não ");
    	System.out.println("3 - Cancelar");
    	System.out.print("Digite a opção: ");
    	
    	opcaoCadastro = scanner.next();
    	
    	
    	switch(opcaoCadastro) {
        
    	// cadastro de um novo carro
    	
        case "1":
        	
        	System.out.print("Digite a placa do veículo: ");
            String placa = scanner.next();
            scanner.nextLine();
            
            for (Veiculo veiculo : listaVeiculos) {
                if (veiculo.getPlaca().equals(placa)) {
                    System.out.println("Já existe um veículo com essa placa cadastrado.");
                    return;
                }
            }
            
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

            // Cria um objeto do tipo Carro e adiciona na lista de veículos
        
            listaVeiculos.add(new Carro(placa, marca, modelo, cor, ano, numeroPortas, cambio));
            System.out.println("Veículo cadastrado com sucesso.");
        	
            break;
        	
        // Cadastro de um novo veiculo
        
        case "2":
        	
        	// Cria um objeto e adiciona na lista de veículos
        	
        	System.out.print("Digite a placa do veículo: ");
            String placaVeiculo = scanner.next();
            scanner.nextLine(); 
            
            for (Veiculo veiculo : listaVeiculos) {
                if (veiculo.getPlaca().equals(placaVeiculo)) {
                    System.out.println("Já existe um veículo com essa placa cadastrado.");
                    return;
                }
            }
        	
            System.out.print("Digite a marca do veículo: ");
            String marcaVeiculo = scanner.nextLine();

            System.out.print("Digite o modelo do veículo: ");
            String modeloVeiculo = scanner.nextLine();

            System.out.print("Digite a cor do veículo: ");
            String corVeiculo = scanner.nextLine();

            System.out.print("Digite o ano do veículo: ");
            int anoVeiculo = scanner.nextInt();
        
        	listaVeiculos.add(new Veiculo(placaVeiculo, marcaVeiculo, modeloVeiculo, corVeiculo, anoVeiculo));
        	System.out.println("Veículo cadastrado com sucesso.");
        
        	break;
        
    	default:
    		
    		System.out.println("Voltando para o Menu...");
    		return;
    	}
         
    }
    
    // Método para listar os veículos cadastrados ordenados pelo ano
    
    private static void listarVeiculos(List<Veiculo> listaVeiculos) {
       
    	if (listaVeiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

    	// Ordena a lista de veículos pelo ano em ordem crescente
    	
        Collections.sort(listaVeiculos, (v1, v2) -> Integer.compare(v1.getAno(), v2.getAno()));

        System.out.println("==== LISTA DE VEÍCULOS ORDENADOS PELO ANO ====");
        System.out.printf("%-10s%-15s%-10s%-4s\n", "Placa", "Marca", "Modelo", "Ano");
        System.out.println("----------------------------------------------");
         
        for (Veiculo veiculo : listaVeiculos) {
            System.out.printf("%-10s%-15s%-10s%-4s\n", veiculo.getPlaca(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAno());
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
                System.out.println("==== VEÍCULO ENCONTRADO =====");
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
    
    //Busca e remove o veiculo a partir de sua placa
    
    private static void RemoverVeiculo(Scanner scanner, List<Veiculo> listaVeiculos) {
        
    	System.out.print("Digite a placa do veículo a ser removido: ");
        String placaRemocao = scanner.next();

        Veiculo veiculoEncontrado = null;

        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca().equals(placaRemocao)) {
                veiculoEncontrado = veiculo;
                break;
            }
        }

        if (veiculoEncontrado != null) {
            
    
            System.out.println("==== VEÍCULO ENCONTRADO ====");
        	
            System.out.print("Deseja realmente remover este veículo? (S/N): ");
            String confirmacao = scanner.next();
            
            if (confirmacao.equalsIgnoreCase("S")) {
                listaVeiculos.remove(veiculoEncontrado);
                System.out.println("Veículo removido com sucesso.");
            } else {
                System.out.println("Remoção cancelada.");
            }
        } 
        else {
            System.out.println("Veículo não encontrado.");
        }
    }
    
    // Metodo para modificar um dos atributos do Veiculo
    
    private static void modificarVeiculo(Scanner scanner, List<Veiculo> listaVeiculos) {
        
    	System.out.print("Digite a placa do veículo a ser modificado: ");
        String placaModificacao = scanner.next();

        Veiculo veiculoEncontrado = null;

        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca().equals(placaModificacao)) {
                veiculoEncontrado = veiculo;
                break;
            }
        }

        if (veiculoEncontrado != null) {
        	
            System.out.println("==== VEÍCULO ENCONTRADO ====");
            
            System.out.println("1 - Modifica a placa");
            System.out.println("2 - Modificar a marca");
            System.out.println("3 - Modificar o modelo");
            System.out.println("4  - Modificar a cor");
            System.out.println("5 - Modificar o ano");
            System.out.println("6 - Modificar a quantidade de portas");
            System.out.println("7 - Modificar o tipo de câmbio");
            System.out.println("8 - Não modificar atributos");
            System.out.print("Digite a opção desejada: ");
            String opcaoModificar = scanner.next();
            
            switch (opcaoModificar) {
            
            case "1":
            	System.out.print("Digite a nova placa do veículo: ");
                String placa = scanner.next();
                veiculoEncontrado.setPlaca(placa);
                
                break;
                
            case "2":
            	
            	System.out.print("Digite a nova marca do veículo: ");
                String marca = scanner.next();
                veiculoEncontrado.setMarca(marca);
                
                break;
                
            case "3":
            	
            	System.out.print("Digite o novo modelo do veículo: ");
                String modelo = scanner.next();
                veiculoEncontrado.setModelo(modelo);
                
                break;
                
            case "4":
            	
            	System.out.print("Digite a nova cor do veículo: ");
                String cor = scanner.next();
                veiculoEncontrado.setModelo(cor);
                
                break;
                
            case "5":
            	
            	System.out.print("Digite o novo ano do veículo: ");
                int ano = scanner.nextInt();
                veiculoEncontrado.setAno(ano);
                
                break;
                
            case "6":
            	
            	if (veiculoEncontrado instanceof Carro) {
            		
                    Carro carro = (Carro) veiculoEncontrado;
                    
                    System.out.print("Digite a nova Qtd. de portas do veículo: ");
                    int portas = scanner.nextInt();
                    carro.setNumeroPortas(portas);
                   
                }
            	
            	else {
            		
            		System.out.println("Este veiculo nao é um Carro!");
            		
            		break;
            		
            	}
            	               
                break;
            
            case "7":
            	
            	if (veiculoEncontrado instanceof Carro) {
            		
                    Carro carro = (Carro) veiculoEncontrado;
                    
                    System.out.print("Digite o novo tipo de cãmbio do veículo: ");
                    String cambio = scanner.next();
                    carro.setTipoCambio(cambio);
                   
                }
            	
            	else {
            		
            		System.out.println("Este veiculo nao é um Carro!");
            		
            		break;
            		
            	}
                
                break;
                
            case "8":
            	
                break; // Não faz nada, mantém os atributos atuais do carro
            default:
                System.out.println("Opção inválida.");
                break;
           
            }

            System.out.println("Veículo modificado com sucesso.");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }
      
}

    
    
    
    
        	
        





