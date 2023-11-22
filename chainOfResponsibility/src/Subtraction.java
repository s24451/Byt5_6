import java.util.function.IntBinaryOperator;

public class Subtraction implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain=nextChain;

    }

    @Override
    public void calculate(Numbers request) {
        IntBinaryOperator subtraction = (a, b) -> a - b;

        if (request.getCalculationWanted().equals("-")) {
            int result = subtraction.applyAsInt(request.getNumber1(), request.getNumber2());
            System.out.println(request.getNumber1() + " - " + request.getNumber2() + " = " + result);
        } else if (nextInChain != null) {
            nextInChain.calculate(request);
        } else {
            System.out.println("Unsupported operation: " + request.getCalculationWanted());
        }
    }
}
