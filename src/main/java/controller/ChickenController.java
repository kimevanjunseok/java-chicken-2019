package controller;

import domain.Table;
import domain.TableRepository;
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
        OutputView.printMainScreen();
        int number = InputView.inputFunctionNumber();

        List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
    }
}
