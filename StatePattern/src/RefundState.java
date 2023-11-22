public class RefundState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public RefundState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("Coin inserted: " + amount);
        vendingMachine.setState(vendingMachine.getWaitingForMoneyState());
    }

    @Override
    public void selectProduct(String product) {
        System.out.println("Refunding... Cannot select a product during refund.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Refunding... Cannot dispense a product during refund.");
    }

    @Override
    public void giveChange() {
        System.out.println("Refunding... Cannot give additional change during refund.");
    }

    @Override
    public void refund() {
        System.out.println("Refund completed.");
        vendingMachine.setState(vendingMachine.getWaitingForMoneyState()); // Transition back to waiting for money
    }
}
