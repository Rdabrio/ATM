package dominio;

public class CuentaBancaria {
    private int id;
    private Banco bancoAdmin;

    public CuentaBancaria(int id, Banco bancoAdmin) {
        this.id = id;
        this.bancoAdmin = bancoAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBancoAdmin(Banco bancoAdmin) {
        this.bancoAdmin = bancoAdmin;
    }

    public Banco getBancoAdmin() {
        return bancoAdmin;
    }
}
