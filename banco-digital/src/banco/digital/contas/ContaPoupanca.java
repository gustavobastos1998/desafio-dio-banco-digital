package banco.digital.contas;

import banco.digital.cliente.Cliente;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public ContaPoupanca(double saldo, Cliente cliente) {
        super(saldo, cliente);
    }

    @Override
    public String informacaoConta() {
        return "--Conta Poupança--\n" + super.informacaoConta();
    }
}
