package Design_ptr.builder_dp;

public class User {

    // Marked fields in User as final for immutability.
    private final String name;
    private final String phoneNo;
    private final String city;
    private final String mail;


    /* the User constructor should be private
     to ensure that users of the class cannot instantiate the User object directly without the builder.
     */

    private User(UserBuilder builder) {
        this.name = builder.name;
        this.phoneNo = builder.phoneNo;
        this.city = builder.city;
        this.mail = builder.mail;
    }

    // Getter methods for User class
    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getCity() {
        return city;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", city='" + city + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public static UserBuilder builder(String name, String phoneNo) {
        return new UserBuilder(name, phoneNo);
    }

    public static class UserBuilder {
        private final String name;
        private final String phoneNo;
        private String city;
        private String mail;

        public UserBuilder(String name, String phoneNo) {
            if (name == null || phoneNo == null) {
                throw new IllegalArgumentException("Name and Phone Number cannot be null");
            }
            this.name = name;
            this.phoneNo = phoneNo;
        }

        public UserBuilder city(String city) {
            this.city = city;
            return this;
        }

        public UserBuilder mail(String mail) {
            this.mail = mail;
            return this;
        }

        public User build() {
            return new User(this);
        }

        // Optional: Getter methods for the builder (if necessary)

        /*
        public String getName() {
            return name;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public String getCity() {
            return city;
        }

        public String getMail() {
            return mail;
        }

         */
    }
}
