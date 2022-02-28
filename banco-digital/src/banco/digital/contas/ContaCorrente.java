package banco.digital.contas;

import banco.digital.cliente.Cliente;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public ContaCorrente(double saldo, Cliente cliente) {
        super(saldo, cliente);
    }

    @Override
    public String informacaoConta() {
        return "--Conta Corrente--\n" + super.informacaoConta();
    }
}
