package jeu;

public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model){
        this.view = view;
        this.model = model;
    }

    public void start(){
        ControllerMenu controllerMenu = new ControllerMenu(model,view);
        ControllerParty controllerParty = new ControllerParty(model,view.viewParty);

    }
}
