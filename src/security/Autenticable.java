package security;

public interface Autenticable {
    boolean Authenticated(String email, String password);
}
