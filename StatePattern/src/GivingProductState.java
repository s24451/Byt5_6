public class GivingProductState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public GivingProductState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("Already giving a product. Wait for the product to be dispensed.");
    }

    @Override
    public void selectProduct(String product) {
        System.out.println("Already giving a product. Wait for the product to be dispensed.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Dispensing product...");
        vendingMachine.setState(vendingMachine.getGivingChangeState()); // Transition to giving change state
    }

    @Override
    public void giveChange() {
        System.out.println("Cannot give change without completing the product dispensing.");
    }

    @Override
    public void refund() {
        System.out.println("Cannot refund during product dispensing.");
    }
}
