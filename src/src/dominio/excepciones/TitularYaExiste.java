package dominio.excepciones;

public class TitularYaExiste extends Exception {
    public TitularYaExiste() {
        super("El titular ya existe");
    }
}
