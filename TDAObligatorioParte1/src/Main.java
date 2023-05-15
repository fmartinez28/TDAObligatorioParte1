public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        while(menu.On()){
            menu.Start();
        }
    }
}