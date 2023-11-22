public class HasCashState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public HasCashState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("Already have cash. Select a product or get a refund.");
    }

    @Override
    public void selectProduct(String product) {
        if (vendingMachine.isProductAvailable()) {
            System.out.println("Product selected: " + product);
            vendingMachine.setState(vendingMachine.getProductSelectionState());
        } else {
            System.out.println("Out of stock. Please select another product or get a refund.");
            vendingMachine.setState(vendingMachine.getOutOfStockState());
        }
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Cannot dispense product without product selection.");
    }

    @Override
    public void giveChange() {
        System.out.println("Cannot give change without product selection.");
    }

    @Override
    public void refund() {
        System.out.println("Refunding...");
        vendingMachine.setState(vendingMachine.getRefundState());
    }
}