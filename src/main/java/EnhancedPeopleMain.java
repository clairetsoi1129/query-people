public class EnhancedPeopleMain {
    public static void main(String[] args){
        PeopleModel model = new EnhancedPeopleModel();
        PeopleView view = new EnhancedPeopleView();
        PeopleController controller = new EnhancedPeopleController(model, view);

        controller.start();
    }
}
