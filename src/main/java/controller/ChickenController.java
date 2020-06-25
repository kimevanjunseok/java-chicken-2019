package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class ChickenController {

    private static final ChickenController chickenController = new ChickenController();

    private ChickenController() {}

    public static ChickenController getInstance() {
        return chickenController;
    }

    public void execute() {
        try {
            work();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    private void work() {
        TableOrder tableOrder = TableOrder.from(TableMenuFactory.createTableOrder(
            TableRepository.tables(),
            MenuRepository.menus()
        ));
        FunctionType functionType;
        do {
            OutputView.printMainScreen();
            functionType = FunctionType.find(InputView.inputFunctionNumber());
            function(functionType, tableOrder);
        } while(functionType.isNotThree());
    }

    private void function(FunctionType functionType, TableOrder tableOrder) {
        if (functionType == FunctionType.ONE) {
            add(tableOrder);
        }
        if (functionType == FunctionType.TWO) {
            count(tableOrder);
        }
    }

    private void add(TableOrder tableOrder) {
        OutputView.printTables(tableOrder.getTables());
        Table table = tableOrder.findTableByNumber(InputView.inputTableNumber());
    }

    private void count(TableOrder tableOrder) {

    }
}
