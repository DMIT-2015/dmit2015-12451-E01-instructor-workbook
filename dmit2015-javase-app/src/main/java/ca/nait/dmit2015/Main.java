package ca.nait.dmit2015;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void PrintInfo(Circle circle) {
        String message = String.format(
                "Radius: %s, Area: %.2f, Diameter: %s, Perimeter: %.3f",
                circle.getRadius(),
                circle.area(),
                circle.diameter(),
                circle.perimeter()
        );
        System.out.println(message);
    }

    public static void main(String[] args) {
        // Create a circle with a default radius
        //Circle circle1 = new Circle();
        var circle1 = new Circle();
        // Print the radius, area, diameter, perimeter of circle1
        System.out.println(circle1);
        // Change the radius to 10
        circle1.setRadius(10);
        System.out.println(circle1);
        // Create a circle with a radius of 200
        var circle2 = new Circle(200);
        System.out.println(circle2);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}