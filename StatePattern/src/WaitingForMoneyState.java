class WaitingForMoneyState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public WaitingForMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("Coin inserted: " + amount);
        vendingMachine.setState(vendingMachine.getHasCashState());
    }

    @Override
    public void selectProduct(String product) {
        System.out.println("Insert coins first before selecting a product.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Insert coins first before dispensing a product.");
    }

    @Override
    public void giveChange() {
        System.out.println("No change to give. Insert coins first.");
    }

    @Override
    public void refund() {
        System.out.println("No refund available. Insert coins first.");
    }
}
