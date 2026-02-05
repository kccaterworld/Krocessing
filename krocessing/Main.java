package krocessing;
import krocessing.environment.*;
import krocessing.functions.*;
import krocessing.output.*;
import java.util.Collections;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) {
        UIWindow ui;
        HashSet<String> argsSet = new HashSet<>();
        Collections.addAll(argsSet, args);
        
        System.out.println("Krocessing started.");
        ui = new UIWindow("Krocessing UI", 800, 600, argsSet.contains("-i"));

        DisplayWindow display = new DisplayWindow("Krocessing");
        display.hideDisplayWindow();
    }
}
