public class GivingChangeState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public GivingChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("Cannot insert coins during change dispensing.");
    }

    @Override
    public void selectProduct(String product) {
        System.out.println("Cannot select a product during change dispensing.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Cannot dispense a product during change dispensing.");
    }

    @Override
    public void giveChange() {
        System.out.println("Giving change...");
        vendingMachine.setState(vendingMachine.getWaitingForMoneyState());
    }

    @Override
    public void refund() {
        System.out.println("Cannot refund during change dispensing.");
    }
}
