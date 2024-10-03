import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Carro.Carro;

public class Main {
    private static List<Carro> carros = new ArrayList<Carro>();
    private static String[] args = {"Cadastrar Carro", "Listar Carros", "Sair"};
    public static int opcao;
    public static void main(String[] args) {
        try {
            carregarCarros();

            while(true){
                opcao = menu(Main.args);
                System.out.println("");
                switch(opcao) {
                    case 1:
                        cadastrarCarro();
                        break;
                    case 2:
                        printCarros();
                        break;
                    case 3:
                        salvarCarros();
                        return;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int menu(String[] args) {
        for(int i = 0; i < args.length; i++){
            System.out.println((i + 1) + " - " + args[i]);
        }
        System.out.print("Opção: ");
        return Integer.parseInt(System.console().readLine());
    }

    public static void printCarros(){
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("Carros Cadastrados: ");
        for(Carro carro : Main.carros){
            System.out.println(carro.toString());
        }
        System.out.println("-----------------------------");
        System.out.println("");        
    }

    public static void cadastrarCarro() {
        try {
            Carro carro = new Carro();
            carro.setId(Main.carros.size() + 1);
            System.out.print("Modelo: ");
            carro.setModelo(System.console().readLine());
            System.out.print("Marca: ");
            carro.setMarca(System.console().readLine());
            System.out.print("Ano (yyyy): ");
            carro.setAno(System.console().readLine());
            System.out.print("Cor: ");
            carro.setCor(System.console().readLine());
            System.out.print("Preço: ");
            carro.setPreco(Double.parseDouble(System.console().readLine()));
            System.out.print("Custo: ");
            carro.setCusto(Double.parseDouble(System.console().readLine()));
            System.out.println("Lucro: " + carro.getLucro());
    
            Main.carros.add(carro);
            System.out.println("");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar carro: " + e.getMessage(), e);
        }
    }

    public static void carregarCarros()  throws Exception {        
        File file = new File("carros.dat");
        if (!file.exists()) {
            System.out.println("Arquivo de carros não encontrado, iniciando com lista vazia.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("carros.dat"))) {
            Main.carros = (List<Carro>) ois.readObject();
        } catch (IOException e) {
            throw new Exception("Erro ao carregar carros: " + e.getMessage());
        }

        System.out.println("Carros carregados com sucesso!");
    }

    public static void salvarCarros() throws Exception {
        System.out.println("Salvando carros...");
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("carros.dat")))) {
            oos.writeObject(Main.carros);
        } catch (IOException e) {
            throw new Exception("Erro ao salvar carros: " + e.getMessage()); 
        }

        System.out.println("Carros salvos com sucesso!");
        System.out.println("Saindo...");
    }
}
