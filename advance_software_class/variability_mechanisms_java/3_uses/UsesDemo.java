abstract class AuthenticationUseCase {

    abstract boolean validateCredentials(String user, String pass);

    final boolean login(String user, String pass) {
        System.out.println("[Auth] Attempting login for: " + user);
        if (validateCredentials(user, pass)) {
            System.out.println("[Auth] SUCCESS");
            onLoginSuccess(user);
            return true;
        } else {
            System.out.println("[Auth] FAILED");
            onLoginFailure(user);
            return false;
        }
    }

    void onLoginSuccess(String user) { System.out.println("  Welcome, " + user + "!"); }
    void onLoginFailure(String user) { System.out.println("  Access denied for " + user + "."); }
}

class AdminLoginUseCase extends AuthenticationUseCase {
    @Override
    boolean validateCredentials(String user, String pass) {
        return user.equals("admin") && pass.equals("admin123");
    }
    @Override
    void onLoginSuccess(String user) {
        System.out.println("  [Admin] Admin portal access granted to " + user + ".");
    }
}

class GuestLoginUseCase extends AuthenticationUseCase {
    @Override
    boolean validateCredentials(String user, String pass) {
        return pass.equals("guest");
    }
    @Override
    void onLoginSuccess(String user) {
        System.out.println("  [Guest] Limited access granted to " + user + ".");
    }
}

class TokenLoginUseCase extends AuthenticationUseCase {
    private String validToken;
    TokenLoginUseCase(String token) { this.validToken = token; }

    @Override
    boolean validateCredentials(String user, String token) {
        return token.equals(validToken);
    }
    @Override
    void onLoginSuccess(String user) {
        System.out.println("  [Token] Token session started for " + user + ".");
    }
}

public class UsesDemo {
    public static void main(String[] args) {
        System.out.println("=== Variability Mechanism: USES ===\n");

        System.out.println("--- Specialized Use Case 1: Admin Login ---");
        AdminLoginUseCase admin = new AdminLoginUseCase();
        admin.login("admin", "wrongpass");
        admin.login("admin", "admin123");

        System.out.println("\n--- Specialized Use Case 2: Guest Login ---");
        GuestLoginUseCase guest = new GuestLoginUseCase();
        guest.login("john", "guest");
        guest.login("jane", "secret");

        System.out.println("\n--- Specialized Use Case 3: Token Login ---");
        TokenLoginUseCase token = new TokenLoginUseCase("TOKEN-XYZ-2024");
        token.login("rohit", "TOKEN-XYZ-2024");
        token.login("rohit", "WRONG-TOKEN");
    }
}
