package local.concept2_vc;

public class CalcApp {

    public static void main(String[] args) {
        System.out.println("Calculadora");
        CalcController controller = new CalcController();
        CalcView view = new CalcView(controller);
        System.out.println(controller);
        System.out.println(view);
        view.show();
    }

}
