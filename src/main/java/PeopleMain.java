public class PeopleMain {
    public static void main(String[] args){
        PeopleModel model = new PeopleModel();
        PeopleView view = new PeopleView();
        PeopleController controller = new PeopleController(model, view);

        controller.start();
    }
}
