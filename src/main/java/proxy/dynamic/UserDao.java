package proxy.dynamic;

public interface UserDao {
    void save();

    void find();

    default void look() {
        System.out.println("look");
    }

}
