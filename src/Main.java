import java.util.Scanner;

public class Main {

    public static void Menu (){
        Scanner sc = new Scanner(System.in);
        String select;

        System.out.print("Selecione abaixo protocolo que deseja realizar:\n" +
                "1º) Adicionar novo contato;\n" +
                "2º) Visualizar lista completa;\n" +
                "3º) Buscar;\n" +
                "4º) Deletar contato;" +
                "5º) Finalizar;");
                select = sc.nextLine();

        if (select.equalsIgnoreCase("1")) {

        }
        else if (select.equalsIgnoreCase("2")) {

        }
        else if (select.equalsIgnoreCase("3")) {

        }
        else if (select.equalsIgnoreCase("4")) {

        }
        else if (select.equalsIgnoreCase("5")) {

        }
        else{
            System.out.print("Infelizmente o valor informado é inválido, repita o procedimento.");
            Menu();
        }
    }

    public static ??? Adicionar (){}
    public static ??? Listar (){}
    public static ??? Buscar () {}
    public static ??? Detelar () {}

    public static void main(String[] args) {
        System.out.println("Bem vindo a lista de contatos da aniecoi, por favor, insira o seu primeiro contato.");

    }
}