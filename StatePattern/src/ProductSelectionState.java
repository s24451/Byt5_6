public class ProductSelectionState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public ProductSelectionState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("Already selected a product. Cannot insert more coins.");
    }

    @Override
    public void selectProduct(String product) {
        System.out.println("Already selected a product. Wait for confirmation or get a refund.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Dispensing product...");
        vendingMachine.setState(vendingMachine.getGivingProductState());
    }

    @Override
    public void giveChange() {
        System.out.println("Cannot give change without completing the product dispensing.");
    }

    @Override
    public void refund() {
        System.out.println("Refunding...");
        vendingMachine.setState(vendingMachine.getRefundState());
    }
}