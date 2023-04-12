import java.util.Scanner;

public class Main {

    public static class Contato {
        String nome;
        String gmail;
        int num;
    }

    public static String Menu(){
        Scanner sc = new Scanner(System.in);
        String select;

        System.out.print("Selecione abaixo protocolo que deseja realizar:\n" +
                "1º) Adicionar: Incluir novo contato;\n" +
                "2º) Imprimir: Visualizar lista completa de contatos;\n" +
                "3º) Sair: Finalizar programa;\n" +
                "RESPOSTA: ");
        select = sc.nextLine();

        if (select.equalsIgnoreCase("adicionar")){
            System.out.print("\nFunção ativada - Adicionar();\n");
            return "1";
        }
        else if (select.equalsIgnoreCase("imprimir")){
            System.out.print("\nFunção ativada - Imprimir();\n");
            return "2";
        }
        else if (select.equalsIgnoreCase("sair")){
            System.out.print("\nAgenda finalizada.");
            return "0";
        }
        else {
            System.out.print("Valor inválido, tente novamente. \n");
            return Menu();
        }
    }

    public static Contato[] Adicionar (Contato[] list, int i){
        Scanner sc = new Scanner(System.in);
        Contato c = new Contato ();

        System.out.print("Insira o nome do contato: ");
         c.nome = sc.nextLine();
        System.out.print("Insira o email do contato: ");
        c.gmail = sc.nextLine();
        System.out.print("Insira o número do contato: ");
        c.num = sc.nextInt();
        list[i] = c;

        System.out.println("Contato adicionado com sucesso!\n");
        return list;
    }

    public static void Imprimir (Contato[] list, int i){
        System.out.print("Funcionando\n\n");
    }

    public static void main (String[] args) {
        Contato lista_matriz[] = new Contato[10];
        int i = 0;

        System.out.print("AGENDA TELEFÔNICA\n\n");
        String select = Menu();

        while (select != "0") {
            if (select == "1") {

                lista_matriz = Adicionar(lista_matriz, i);
                i++;
                select = Menu();

            }
            else if (select == "2") {
                Imprimir(lista_matriz, i);
                select = Menu();
            }
        }
    }
}

