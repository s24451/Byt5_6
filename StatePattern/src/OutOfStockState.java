public class OutOfStockState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public OutOfStockState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("Cannot accept coins. Out of stock.");
    }

    @Override
    public void selectProduct(String product) {
        System.out.println("Out of stock. Please get a refund or select another product.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Cannot dispense product. Out of stock.");
    }

    @Override
    public void giveChange() {
        System.out.println("Cannot give change. Out of stock.");
    }

    @Override
    public void refund() {
        System.out.println("Refunding...");
        vendingMachine.setState(vendingMachine.getRefundState());
    }
}
