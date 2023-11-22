public class TestCalcChain {
    public static void main(String[] args) {


        Chain chainCalc1 = new Addition();
        Chain chainCalc2 = new Subtraction();
        Chain chainCalc3 = new Multiplication();
        Chain chainCalc4 = new Division();
        chainCalc1.setNextChain(chainCalc2);
        chainCalc2.setNextChain(chainCalc3);
        chainCalc3.setNextChain(chainCalc4);


        Numbers request= new Numbers(4, 2, "-");
        chainCalc1.calculate(request);


    }
}