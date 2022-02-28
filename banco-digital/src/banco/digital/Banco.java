package banco.digital;

import java.util.ArrayList;
import banco.digital.contas.InterfaceConta;

public class Banco {

    ArrayList<InterfaceConta> contas;
    
    public Banco(){
        contas = new ArrayList<>();
    }

    public void inserirContaAoBanco(InterfaceConta conta) {
        contas.add(conta);
    }

    public void removerContaClienteEspecifico(int ID) {
        int i;
        InterfaceConta removeConta;
        for (i = 0; i < contas.size(); i++) {
            removeConta = contas.get(i);
            if (removeConta.getCliente().getID() == ID) {
                contas.remove(removeConta);
                System.out.println(removeConta);
                System.out.println("Esta conta foi removida!");
                return;
            }
        }
        System.out.println("ID de cliente não cadastrado");
    }
    
    public void listasInfoTodosClientes(){
        int i;
        for(i=0;i<contas.size();i++){
            System.out.println(contas.get(i).informacaoConta());
        }
    }
    
    public void informacaoClienteEspecifico(int ID){
        int i;
        InterfaceConta contaClienteEspecifico;
        for(i=0;i<contas.size();i++){
            contaClienteEspecifico = contas.get(i);
            if(contaClienteEspecifico.getCliente().getID() == ID){
                System.out.println(contaClienteEspecifico.informacaoConta());
            }
        }
    }
    
    public boolean isEmpty(){
        return contas.isEmpty();
    }
}
