import persistencia.rowdata.FinderBanco;
import persistencia.rowdata.GatewayBanco;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String codigo = scanner.nextLine();

        while (!codigo.equals("0")) {

            if (codigo.equals("find all banco")) {

                ArrayList<GatewayBanco> lgb = FinderBanco.getInstance().findAll();
                if (lgb.size() == 0) System.out.println("No hay ningun banco en la tabla");
                else for (GatewayBanco gb:lgb) System.out.println(gb.getNombre());
                codigo = scanner.nextLine();
                if (codigo.equals("inserta")) {
                    System.out.println("Escribe el nombre del banco a insertar:");
                    String nombre = scanner.nextLine();
                    GatewayBanco gb = new GatewayBanco(nombre);
                    gb.insert();
                }

                else if (codigo.equals("update")) {
                    System.out.println("Escribe el nombre del banco a eliminar:");
                    String nombre = scanner.nextLine();
                    for (GatewayBanco gb:lgb) {
                        if (gb.getNombre().equals(nombre)) gb.remove();
                    }
                }
            }

            else if (codigo.equals("find banco")) {
                System.out.println("Escribe el nombre del banco a buscar:");
                String nombre = scanner.nextLine();
                GatewayBanco gb = FinderBanco.getInstance().find(nombre);
                System.out.println("El banco con nombre "+gb.getNombre()+" existe");
            }
            codigo = scanner.nextLine();

        }
    }

}
