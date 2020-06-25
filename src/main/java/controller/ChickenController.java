package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class ChickenController {

    private static final ChickenController chickenController = new ChickenController();

    private ChickenController() {}

    public static ChickenController getInstance() {
        return chickenController;
    }

    public void execute() {
        Tables tables = Tables.from(TableRepository.tables());
        Menus menus = Menus.from(MenuRepository.menus());
        FunctionType functionType;
        do {
            OutputView.printMainScreen();
            functionType = FunctionType.find(InputView.inputFunctionNumber());
        } while(functionType.isNotThree());
    }
}
