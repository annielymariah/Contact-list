import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static class Contato {
        String nome;
        String gmail;
        int num;

        public Contato(String nome, String gmail, int num) {
            this.nome = nome;
            this.gmail = gmail;
            this.num = num;
        }
    }

    static ArrayList<Contato> contatos = new ArrayList<>();

    public static void Menu () {
        Scanner sc = new Scanner(System.in);
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
        contatos.add(c);
        System.out.println("Contato adicionado com sucesso!");
    }

    public static void main(String[] args) {
        System.out.println("Bem vindo a lista de contatos da aniecoi, por favor, insira o seu primeiro contato.");
        Adicionar();
        Menu();
    }
}