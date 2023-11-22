import java.util.Scanner;

public class VendingMachine {

    private final VendingMachineState hasCash;
    private final VendingMachineState outOfStock;
    private final VendingMachineState givingProduct;
    private final VendingMachineState givingChange;
    private final VendingMachineState refund;
    private final VendingMachineState productSelection;
    private final WaitingForMoneyState waitingForMoney;

    VendingMachineState vendingMachineState;
    private boolean productExists = true;

    public VendingMachine() {
        waitingForMoney = new WaitingForMoneyState(this);
        hasCash = new HasCashState(this);
        outOfStock = new OutOfStockState(this);
        givingProduct = new GivingProductState(this);
        givingChange = new GivingChangeState(this);
        refund = new RefundState(this);
        productSelection = new ProductSelectionState(this);
        // Initial state
        vendingMachineState = waitingForMoney;
    }

    public void insertCoin(int amount) {
        vendingMachineState.insertCoin(amount);
    }

    public void selectProduct(String product) {
        vendingMachineState.selectProduct(product);
    }

    public void dispenseProduct() {
        vendingMachineState.dispenseProduct();
    }

    public void giveChange() {
        vendingMachineState.giveChange();
    }

    public void refund() {
        vendingMachineState.refund();
    }

    public void setState(VendingMachineState state) {
        this.vendingMachineState = state;
    }

    public VendingMachineState getHasCashState() {
        return hasCash;
    }

    public VendingMachineState getOutOfStockState() {
        return outOfStock;
    }

    public VendingMachineState getWaitingForMoneyState() {
        return waitingForMoney;
    }

    public VendingMachineState getGivingProductState() {
        return givingProduct;
    }

    public VendingMachineState getGivingChangeState() {
        return givingChange;
    }

    public VendingMachineState getRefundState() {
        return refund;
    }

    public VendingMachineState getProductSelectionState() {
        return productSelection;
    }

    public boolean isProductAvailable() {
        return productExists;
    }

    public void setProductAvailability(boolean available) {
        productExists = available;
    }

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vending Machine!");

        while (true) {
            System.out.println("1. Insert Coin");
            System.out.println("2. Select Product");
            System.out.println("3. Dispense Product");
            System.out.println("4. Give Change");
            System.out.println("5. Refund");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter coin amount: ");
                    int coinAmount = scanner.nextInt();
                    vendingMachine.insertCoin(coinAmount);
                }
                case 2 -> {
                    System.out.print("Enter product name: ");
                    String productName = scanner.next();
                    vendingMachine.selectProduct(productName);
                }
                case 3 -> vendingMachine.dispenseProduct();
                case 4 -> vendingMachine.giveChange();
                case 5 -> vendingMachine.refund();
                case 0 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
