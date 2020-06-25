package controller;

import view.OutputView;

public class ChickenController {

    private static final ChickenController chickenController = new ChickenController();

    private ChickenController() {}

    public static ChickenController getInstance() {
        return chickenController;
    }

    public void execute() {
        OutputView.printMainScreen();

    }
}
