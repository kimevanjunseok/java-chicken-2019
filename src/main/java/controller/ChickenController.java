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
        Tables tables = Tables.from(TableRepository.tables());
        Menus menus = Menus.from(MenuRepository.menus());

        FunctionType functionType;
        do {
            OutputView.printMainScreen();
            functionType = FunctionType.find(InputView.inputFunctionNumber());
            function(functionType, tables, menus);
        } while(functionType.isNotThree());
    }

    private void function(FunctionType functionType, Tables tables, Menus menus) {
        if (functionType == FunctionType.ONE) {
            addOrder(tables, menus);
        }
        if (functionType == FunctionType.TWO) {
            countOrder(tables, menus);
        }
    }

    private void addOrder(Tables tables, Menus menus) {
        OutputView.printTables(tables.getTables());
        Table table = tables.findTableByNumber(InputView.inputTableNumber());
        OutputView.printMenus(menus.getMenus());
        Menu menu = menus.findMenuByNumber(InputView.inputMenuNumber());
        Order order = table.findOrderByMenu(menu);
    }

    private void countOrder(Tables tables, Menus menus) {

    }
}
