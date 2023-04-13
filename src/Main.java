import java.util.Scanner;

public class Main {

    public static class Contato {
        String nome;
        String mail;
        int numero;
    }

    public static String Menu(){
        Scanner sc = new Scanner(System.in);
        String select;

        System.out.print("\n\nSelecione abaixo protocolo que deseja realizar:\n" +
                "1º) Adicionar: Incluir novo contato;\n" +
                "2º) Imprimir: Visualizar lista completa de contatos;\n" +
                "3º) Buscar: Procurar um contato;\n" +
                "4º) Sair: Finalizar programa;\n" +
                "RESPOSTA: ");
        select = sc.nextLine();

        if (select.equalsIgnoreCase("adicionar")){
            System.out.println("\nFunção ativada - Adicionar();\n");
            return "1";
        }
        else if (select.equalsIgnoreCase("imprimir")){
            System.out.println("\nFunção ativada - Imprimir();\n");
            return "2";
        }
        else if (select.equalsIgnoreCase("buscar")){
            System.out.println("\nFunção ativada - Buscar();\n");
            return "3";
        }
        else if (select.equalsIgnoreCase("sair")){
            System.out.println("\nAgenda finalizada.");
            return "0";
        }
        else {
            System.out.print("Valor inválido, tente novamente. \n");
            return Menu();
        }
    }

    public static Contato[] Adicionar (Contato[] list, int quant_contatos){
        Scanner sc = new Scanner(System.in);
        Contato c = new Contato ();

        System.out.print("Insira o nome do contato: ");
         c.nome = sc.nextLine();
        System.out.print("Insira o email do contato: ");
        c.mail = sc.nextLine();
        System.out.print("Insira o número do contato: ");
        c.numero = sc.nextInt();
        list[quant_contatos] = c;

        System.out.println("Contato adicionado com sucesso!\n");
        return list;
    }

    public static void Imprimir (Contato[] list, int quant_contatos){
        System.out.print("Funcionando\n\n");
    }

    public static int buscarContato(Contato list[], int quant_contatos){
        Scanner sc = new Scanner(System.in);
        boolean tester = false;

        if(quant_contatos==0){
            System.out.println("A lista ainda está vazia! ");
            return -1;
        }

        else{
            System.out.println("Digite o nome do contato cujo deseja buscar: ");
            String nomeBuscar = sc.next();

            for(int i=0; i<quant_contatos; i++){
                if(nomeBuscar.equalsIgnoreCase(list[i].nome)){
                    System.out.printf("O contato existe!\nNome: %s\nEmail: %s\nNumero: %d", list[i].nome, list[i].mail, list[i].numero);
                    tester = true;
                    return i;

                }

            }

            if(tester == false){
                System.out.println("O contato buscado não existe ou ainda não foi adcionado");
                return -1;
            }
        }

        return -1;

    }

    public static void main (String[] args) {
        int indice_contatos = 0;
        int TAM = 10;
        Contato lista_matriz[] = new Contato[TAM];
        
        System.out.print("AGENDA TELEFÔNICA\n\n");
        String select = Menu();

        while (select != "0") {
            if (select == "1") {

                lista_matriz = Adicionar(lista_matriz, indice_contatos);
                indice_contatos++;
                select = Menu();

            }
            else if (select == "2") {
                Imprimir(lista_matriz, indice_contatos);
                select = Menu();
            }
            else if(select == "3"){
                buscarContato(lista_matriz, indice_contatos);
                select = Menu();
            }
        }
    }
}