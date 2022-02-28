package banco.digital.contas;

import banco.digital.cliente.Cliente;

public class Conta implements InterfaceConta{
    
    protected double saldo;
    protected Cliente cliente;
    protected int agencia;
    private final int AGENCIA_DEFAULT = 1;
    
    public Conta(double saldo, Cliente cliente){
        this.saldo = saldo;
        this.cliente = cliente;
        agencia = AGENCIA_DEFAULT;
    }
    
    public Conta(Cliente cliente){
        this.cliente = cliente;
        agencia = AGENCIA_DEFAULT;
    }
    
    @Override
    public void depositar(double valorDeposito){
        saldo += valorDeposito;
    }
    
    @Override
    public void sacar(double valorSaque){
        saldo -= valorSaque;
    }
    
    @Override
    public void transferir(double valor, InterfaceConta contaDestino){
        this.sacar(valor);
        contaDestino.depositar(valor);
    }
    
    public double getSaldo(){
        return this.saldo;
    }
    
    @Override
    public Cliente getCliente(){
        return this.cliente;
    }
    
    public int getAgencia(){
        return this.agencia;
    }
    
    @Override
    public String informacaoConta(){
        return "Saldo da conta = "+saldo
              +"\nNome do cliente : "+cliente.getName()
              +"\nID do cliente : "+cliente.getID()
              +"\nAgência bancária : "+agencia+'\n';
    }
}
