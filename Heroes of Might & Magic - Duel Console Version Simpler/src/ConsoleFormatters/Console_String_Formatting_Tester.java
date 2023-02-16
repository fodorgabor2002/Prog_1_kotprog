package ConsoleFormatters;

public class Console_String_Formatting_Tester {
    public static void main(String[] args){
        System.out.print("Everything on the console will cleared");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
