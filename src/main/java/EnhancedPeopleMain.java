public class EnhancedPeopleMain {
    public static void main(String[] args){
        EnhancedPeopleModel model = new EnhancedPeopleModel();
        EnhancedPeopleView view = new EnhancedPeopleView();
        EnhancedPeopleController controller = new EnhancedPeopleController(model, view);

        controller.start();
    }
}
