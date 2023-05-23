package persistencia.ctrldata;

public class FinderBanco {
    private static FinderBanco instance;

    private FinderBanco() {

    }

    public static FinderBanco getInstance() {
        if (instance == null) instance = new FinderBanco();
        return instance;
    }
}
