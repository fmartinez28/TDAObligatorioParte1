import java.util.Scanner;

public class Menu {
    private Lista<Integer> list = new Lista<>();
    private boolean on = true;
    public Menu(){
    }
    public boolean On(){
        return this.on;
    }
    public void Option1(){
        System.out.println("Ingrese el número que quiere añadir a la lista");
        Integer number = new Scanner(System.in).nextInt();
        list.Push(number);
    }
    public void Option2(){
        System.out.println("Ingrese la ruta del archivo que quiere leer:");
        String[] readValues = ManejadorArchivosGenerico.leerArchivo(new Scanner(System.in).nextLine());
        for(String num : readValues){
            list.Push(Integer.valueOf(num));
        }
    }
    public void Option3(){
        System.out.println("Qué elemento (basado en clave) quiere eliminar?");
        Integer number = new Scanner(System.in).nextInt();
        Node<Integer> nodo = list.find(number);
        if (nodo != null) list.Delete(nodo);
        else {
            System.out.println("El elemento que intentó eliminar no existe.");
        }
    }
    public void Option4(){
        String[] outFile = list.Print().split("->");
        System.out.println("Escriba el nombre del archivo que quiere guardar:");
        String outFileName = new Scanner(System.in).nextLine();
        ManejadorArchivosGenerico.escribirArchivo(outFileName, outFile);
    }
    public void Option5(){
        System.out.println("Escriba la clave del elemento que quiere buscar:");
        Integer val = new Scanner(System.in).nextInt();
        if(list.find(val) != null){
            System.out.println("El elemento existe");
            return;
        }
        System.out.println("El elemento no existe");
    }
    public void Option6(){
        list.DeleteDuplicates();
    }
    public void Option7(){
        System.out.println("---FIN---");
        this.on = false;
    }
    public void Display(){
        System.out.println("Elija una de las siguientes opciones:");
        System.out.println("1) Ingresar elemento a la lista");
        System.out.println("2) Ingresar elementos de un archivo");
        System.out.println("3) Eliminar elemento de la lista");
        System.out.println("4) Imprimir lista en un archivo");
        System.out.println("5) Buscar si un elemento existe en la lista");
        System.out.println("6) Eliminar duplicados");
        System.out.println("7) Finalizar programa");
    }
    public void Start(){
        Display();
        Integer currOption = new Scanner(System.in).nextInt();
        switch (currOption){
            case 1:
                Option1();
                break;
            case 2:
                Option2();
                break;
            case 3:
                Option3();
                break;
            case 4:
                Option4();
                break;
            case 5:
                Option5();
                break;
            case 6:
                Option6();
                break;
            case 7:
                Option7();
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
        System.out.println("Estado actual de la lista: " + list.Print());
    }
}
