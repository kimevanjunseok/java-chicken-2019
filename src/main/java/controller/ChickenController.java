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
        Menus menus = Menus.from(MenuRepository.menus());
        TableOrder tableOrder = TableOrder.from(TableMenuFactory.createTableOrder(
            TableRepository.tables(),
            menus.getMenus()
        ));
        FunctionType functionType;
        do {
            OutputView.printMainScreen();
            functionType = FunctionType.find(InputView.inputFunctionNumber());
            function(functionType, tableOrder, menus);
        } while(functionType.isNotThree());
    }

    private void function(FunctionType functionType, TableOrder tableOrder, Menus menus) {
        if (functionType == FunctionType.ONE) {
            addOrder(tableOrder, menus);
        }
        if (functionType == FunctionType.TWO) {
            countOrder(tableOrder, menus);
        }
    }

    private void addOrder(TableOrder tableOrder, Menus menus) {
        OutputView.printTables(tableOrder.getTables());
        Table table = tableOrder.findTableByNumber(InputView.inputTableNumber());
        OutputView.printMenus(menus.getMenus());
        Menu menu = menus.findMenuByNumber(InputView.inputMenuNumber());
    }

    private void countOrder(TableOrder tableOrder, Menus menus) {

    }
}
