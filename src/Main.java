import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner sc;
    public static class Contato {
        String nome;
        String mail;
        int num;

        public Contato(String nome, String email, int celular) {
            this.nome = nome;
            this.mail = email;
            this.num = celular;
        }
    }

    public static ArrayList<Contato> listaDeContatos = new ArrayList<>();

    public static void Menu () {
        String select;

        System.out.print("Selecione abaixo protocolo que deseja realizar:\n" +
                "1º) Adicionar novo contato;\n" +
                "2º) Visualizar lista completa;\n" +
                "3º) Buscar;\n" +
                "4º) Deletar contato;\n" + // Add a semicolon after "Deletar contato"
                "5º) Finalizar;\n"); // Add a semicolon after "Finalizar"
        select = sc.nextLine();

        if (select.equalsIgnoreCase("1")) {
            Adicionar();
        }
        else if (select.equalsIgnoreCase("2")) {
            Listar();
        }
        else if (select.equalsIgnoreCase("3")) {
            Buscar();
        }
        else if (select.equalsIgnoreCase("4")) {
            Deletar();
        }
        else if (select.equalsIgnoreCase("5")) {
            System.out.println("Programa finalizado.");
        }
        else{
            System.out.print("Infelizmente o valor informado é inválido, repita o procedimento.");
            Menu();
        }
    }

    public static void buscar(){
        System.out.println("Digite o nome do contato que está procurando: ");
        String aux = sc.next();

        if(listaDeContatos.size()>0){

                if(listaDeContatos.contains(aux)){
                    System.out.printf("O contato existe!\n NOME: \nCELULAR: \n EMAIL: ",);
                }


        }
        else{
            System.out.println("A lista está vazia! ");
        }
    }

    public static void Adicionar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Insira o nome do contato: ");
        String nome = sc.nextLine();

        System.out.print("Insira o email do contato: ");
        String email = sc.nextLine();

        System.out.print("Insira o número do contato: ");
        int num = sc.nextInt();
        sc.nextLine();

        Contato c = new Contato(nome, email, num);

        listaDeContatos.add(c);

        System.out.println("Contato adicionado com sucesso!");

    }

    
    public static void main(String[] args) {
        System.out.println("Bem vindo a lista de contatos da aniecoi, por favor, insira o seu primeiro contato.");
        Adicionar();
        Menu();
    }
}