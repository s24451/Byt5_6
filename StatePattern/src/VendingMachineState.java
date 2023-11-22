interface VendingMachineState {
    void insertCoin(int amount);
    void selectProduct(String product);
    void dispenseProduct();
    void giveChange();
    void refund();
}
