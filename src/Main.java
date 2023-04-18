import java.util.Scanner;
public class Main {

    public static class Contato {
        String nome;
        String mail;
        int numero;
    }

    public static String Menu() {
        Scanner sc = new Scanner(System.in);
        String select;

        System.out.print("\nSelecione abaixo protocolo que deseja realizar:\n" +
                "\n1º) Adicionar: Incluir novo contato;\n" +
                "2º) Imprimir: Visualizar lista completa de contatos;\n" +
                "3º) Buscar: Procurar um contato;\n" +
                "4º) Apagar: Excluir um contato;\n" +
                "5º) Sair: Finalizar programa;\n\n" +
                "RESPOSTA: ");
        select = sc.nextLine();

        if (select.equalsIgnoreCase("adicionar")) {
            System.out.println("\nFunção ativada - Adicionar();");
            return "1";
        } else if (select.equalsIgnoreCase("imprimir")) {
            System.out.println("\nFunção ativada - Imprimir();");
            return "2";
        } else if (select.equalsIgnoreCase("buscar")) {
            System.out.println("\nFunção ativada - Buscar();");
            return "3";
        } else if (select.equalsIgnoreCase("apagar")) {
            System.out.println("\nFunção ativada - Apagar();");
            return "4";
        } else if (select.equalsIgnoreCase("sair")) {
            System.out.println("\nAgenda finalizada.");
            return "0";
        } else {
            System.out.print("Valor inválido, tente novamente.");
            return Menu();
        }
    }

    public static Contato[] Adicionar(Contato[] list, int quant_contatos) {
        Scanner sc = new Scanner(System.in);
        Contato c = new Contato();

        System.out.print("Insira o primeiro nome do contato: ");
        c.nome = sc.nextLine();
        for (int i = 0; i < quant_contatos; i++) {
            if (c.nome.equalsIgnoreCase(list[i].nome)) {
                System.out.println("Nome já utilizado, tente novamente.\n");
                System.out.print("Insira o primeiro nome do contato: ");
                c.nome = sc.nextLine();
                i = -1;
            }
        }
        System.out.print("Insira o email do contato: ");
        c.mail = sc.nextLine();
        System.out.print("Insira o número do contato: ");
        c.numero = sc.nextInt();
        list[quant_contatos] = c;
        System.out.printf("Contato '%s' foi adicionado com sucesso!\n", c.nome);
        return list;
    }

    public static void Imprimir(Contato[] list, int quant_contatos) {
        System.out.println(".º°~°~°~°~°~°º(・人・)º°~°~°~°~°~°º." +
                "\nLISTA DE CONTATOS: ROBÔ DO NUBANCOS\n" +
                ".º°~°~°~°~°~°º('ノωヽ)º°~°~°~°~°~°º.");

        if (quant_contatos == 0) {
            System.out.print("\t\n╮(︶︿︶)╭ A agenda ainda está vazia!");
        } else {
            for (int i = 0; i < quant_contatos; i++) {
                System.out.printf("\nNome: %s\nEmail: %s\nNúmero: %d", list[i].nome, list[i].mail, list[i].numero);
                System.out.print("\n.---------(｡•̀ᴗ-)✧---------.");
            }
        }
    }

    public static void BuscarContato(Contato[] list, int quant_contatos) {
        Scanner sc = new Scanner(System.in);
        boolean buscar = false;

        if (quant_contatos == 0) {
            System.out.print("\t\n╮(︶︿︶)╭ A agenda ainda está vazia!");
        } else {
            System.out.print("Digite o nome do contato cujo deseja buscar: ");
            String nomeBuscar = sc.next();

            for (int i = 0; i < quant_contatos; i++) {
                if (nomeBuscar.equalsIgnoreCase(list[i].nome)) {
                    System.out.printf("\nNome: %s\nEmail: %s\nNumero: %d", list[i].nome, list[i].mail, list[i].numero);
                    buscar = true;
                    return;
                }
            }
            if (buscar == false) {
                System.out.println("O contato buscado não está armazenado em nosso sistema.");
            }
        }
    }

    public static Contato[] RemoverContato(Contato[] list, int quant_contatos, int tama) {
        Contato[] new_list = new Contato[tama - 1];
        int j = 0;
        String name;
        Scanner sc = new Scanner(System.in);

        if (quant_contatos == 0) {
            System.out.print("\t\n╮(︶︿︶)╭ A agenda ainda está vazia!");
        }
        else {
            System.out.print("Digite o nome que será removido: ");
            name = sc.nextLine();

            for (int i = 0; i < quant_contatos; i++) {
                if (!name.equalsIgnoreCase(list[i].nome)) {
                    new_list[j] = list[i];
                    j++;
                }
            }
            System.out.print("\nO contato foi removido da lista com sucesso.");
        }
        return new_list;
    }

    public static void main(String[] args) {
        int indice_contatos = 0;
        final int TAM = 3;
        Contato lista_matriz[] = new Contato[TAM];

        System.out.println(".º°~°~°~°~°~°º(￣▽￣)º°~°~°~°~°~°º." +
                "\nAGENDA TELEFÔNICA: ROBÔ DO NUBANCOS\n" +
                ".º°~°~°~°~°~°º(─‿‿─)º°~°~°~°~°~°º.");
        String select = Menu();

        while (!select.equals("0")) {

            if (select.equals("1")) {
                lista_matriz = Adicionar(lista_matriz, indice_contatos);
                indice_contatos++;
                select = Menu();
            }

            else if (select.equals("2")) {
                Imprimir(lista_matriz, indice_contatos);
                select = Menu();
            }

            else if (select.equals("3")) {
                BuscarContato(lista_matriz, indice_contatos);
                select = Menu();
            }

            else if (select.equals("4")) {
                lista_matriz = RemoverContato(lista_matriz, indice_contatos, TAM);
                indice_contatos--;
                select = Menu();
            }
        }
    }
}