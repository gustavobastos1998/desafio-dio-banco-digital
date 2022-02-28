package banco.digital.cliente;

public class Cliente {
    private String name;
    private final int ID;
    public Cliente(String name, int ID){
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    
}
