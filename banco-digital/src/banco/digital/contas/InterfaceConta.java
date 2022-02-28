package banco.digital.contas;

import banco.digital.cliente.Cliente;

public interface InterfaceConta {
    
    public void depositar(double valorDeposito);
    public void sacar(double valorSaque);
    public void transferir(double valor, InterfaceConta contaDestino);
    public Cliente getCliente();
    public String informacaoConta();
    
}
