import java.util.Scanner; //import do scanner
public class Main {

    public static class Contato { //criação do registro
        String nome;
        String mail;
        int numero;
    }

    public static String Menu() { //função que mostra o menu e suas ferramentas para o usuário
        Scanner sc = new Scanner(System.in); //declaração do Scanner
        String select;

        System.out.print("\nSelecione abaixo protocolo que deseja realizar:\n" +
                "\n1º) Adicionar: Incluir novo contato;\n" +
                "2º) Imprimir: Visualizar lista completa de contatos;\n" +
                "3º) Buscar: Procurar um contato;\n" +
                "4º) Apagar: Excluir um contato;\n" +
                "5º) Sair: Finalizar programa;\n\n" +
                "RESPOSTA: ");
        select = sc.nextLine(); //variável que guarda a resposta do usuário

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
            return Menu(); //seleção de opções ou chamada da função menu novamente (caso o valor seja inválido)
        }
    }

    public static Contato[] Adicionar(Contato[] list, int quant_contatos) { //função para adicionar contatos na lista
        Scanner sc = new Scanner(System.in);
        Contato c = new Contato();

        System.out.print("Insira o primeiro nome do contato: "); //Primeiro, insere-se o nome do contato que deseja adicionar.
        c.nome = sc.nextLine();
        for (int i = 0; i < quant_contatos; i++) { //Laço de repetição que analisa os contatos anteriormente inseridos.
            if (c.nome.equalsIgnoreCase(list[i].nome)) { //Se em um local do índice, o nome for igual, solicita para se inserir outro nome e retorna uma casa da busca.
                System.out.println("Nome já utilizado, tente novamente.\n");
                System.out.print("Insira o primeiro nome do contato: ");
                c.nome = sc.nextLine(); // jp é lindo
                i = -1;
            }
        }
        System.out.print("Insira o email do contato: "); //Ao finalizar a busca, prossegue de maneira convencional, adicionando o seu email e número de telefone.
        c.mail = sc.nextLine();
        System.out.print("Insira o número do contato: ");
        c.numero = sc.nextInt();
        list[quant_contatos] = c;
        System.out.printf("Contato '%s' foi adicionado com sucesso!\n", c.nome);
        return list; //retorno da lista atualizada
    }

    public static void Imprimir(Contato[] list, int quant_contatos) {
        System.out.println(".º°~°~°~°~°~°º(・人・)º°~°~°~°~°~°º." +
                "\nLISTA DE CONTATOS: ROBÔ DO NUBANCOS\n" +
                ".º°~°~°~°~°~°º('ノωヽ)º°~°~°~°~°~°º.");

        if (quant_contatos == 0) {
            System.out.print("\t\n╮(︶︿︶)╭ A agenda ainda está vazia!");
        } else {
            for (int i = 0; i < quant_contatos; i++) { //estrutura de repetição que percorre o vetor por inteiro imprimindo cada elemento do mesmo
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
        int mat[][] = new int[3][3]; //uma matriz (porque a senhora pediu para ter)
        int indice_contatos = 0;
        final int TAM = 10;
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