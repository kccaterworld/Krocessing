package krocessing;
import krocessing.environment.*;
import krocessing.functions.*;
import krocessing.output.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Krocessing started.");
        UIWindow ui = new UIWindow();
        DisplayWindow display = new DisplayWindow("Krocessing");
        PDEInterpreter interpreter = new PDEInterpreter();
        interpreter.evaluate("System.out.println(\"Hello from PDE code!\");");
        ui.setup("Krocessing UI", 800, 600);
        display.hideDisplayWindow();
    }
}
