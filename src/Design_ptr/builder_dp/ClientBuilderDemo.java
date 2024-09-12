package Design_ptr.builder_dp;

public class ClientBuilderDemo {
    public static void main(String[] args) {
        User user = User.builder("Rishi","24444948").city("patna").build();
        System.out.println(user);
    }
}
