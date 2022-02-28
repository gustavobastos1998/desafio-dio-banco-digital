package banco.digital;

import java.util.Scanner;
import banco.digital.cliente.Cliente;
import banco.digital.contas.ContaCorrente;
import banco.digital.contas.ContaPoupanca;
import banco.digital.contas.InterfaceConta;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int op, idClienteAutoIncrement = 0;
        Banco banco = new Banco();
        do {
            menu();
            op = in.nextInt();
            while (op < 0 || op > 4) {//enquanto op for diferente de qualquer opção válida
                System.out.println("Informe uma opção válida\n");
                menu();
                op = in.nextInt();
            }
            in.nextLine();
            switch (op) {
                case 1:
                    String nomeNovoCliente;
                    double saldoNovoCliente;
                    int opConta;

                    System.out.println("Informe o nome do cliente:");
                    nomeNovoCliente = in.nextLine();
                    Cliente novoCliente;
                    novoCliente = new Cliente(nomeNovoCliente, idClienteAutoIncrement++);
                    System.out.println("Informe seu saldo bancário:");
                    saldoNovoCliente = in.nextDouble();
                    while (saldoNovoCliente < 0) {
                        System.out.println("Informe um saldo positivo:");
                        saldoNovoCliente = in.nextDouble();
                    }
                    System.out.println("Digite 1 para conta corrente ou 2 para conta pouponça:");
                    opConta = in.nextInt();
                    while (opConta != 1 && opConta != 2) {
                        System.out.println("Informe 1 para conta corrente ou 2 para conta poupança:");
                        opConta = in.nextInt();
                    }
                    in.nextLine();
                    if (opConta == 1) {
                        InterfaceConta novoClienteParaInserir = new ContaCorrente(saldoNovoCliente, novoCliente);
                        banco.contas.add(novoClienteParaInserir);
                    } else {
                        InterfaceConta novoClienteParaInserir = new ContaPoupanca(saldoNovoCliente, novoCliente);
                        banco.contas.add(novoClienteParaInserir);
                    }

                    break;
                case 2:
                    if (banco.isEmpty() == true) {
                        System.out.println("Banco está vazio");
                    } else {
                        int idBusca;

                        System.out.println("Informe o ID do cliente:");
                        idBusca = in.nextInt();
                        while (idBusca < 0) {
                            System.out.println("ID deve se positivo:");
                            idBusca = in.nextInt();
                        }
                        in.nextLine();
                        banco.informacaoClienteEspecifico(idBusca);
                    }

                    break;
                case 3:
                    if (banco.isEmpty() == true) {
                        System.out.println("Banco está vazio");
                    } else {
                        banco.listasInfoTodosClientes();
                    }
                    break;
                case 4:
                    if (banco.isEmpty() == true) {
                        System.out.println("Banco está vazio");
                    } else {
                        int idRemove;
                        System.out.println("Informe o ID do cliente a ser removido:");
                        idRemove = in.nextInt();
                        while (idRemove < 0) {
                            System.out.println("ID deve se positivo:");
                            idRemove = in.nextInt();
                        }
                        in.nextLine();
                        banco.removerContaClienteEspecifico(idRemove);
                    }
                    break;
                case 0:
                    System.out.println("Programa finalizado!");
                    break;
            }
        } while (op != 0);
    }

    private static void menu() {
        System.out.println("-- Informe sua opção --");
        System.out.println("1- Criar e inserir conta do cliente no banco");
        System.out.println("2- Exibir informações de um cliente específico");
        System.out.println("3- Exibir informações de todos os clientes");
        System.out.println("4- Remover cliente apartir de seu ID");
        System.out.println("0- Encerrar o programa");

    }

}
