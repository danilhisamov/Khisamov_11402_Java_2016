package sample.server;

import sample.entity.enums.Role;

import java.util.Base64;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class ServerAuth {
    private static String loginPass;
    public static Role role;

    private Connection server = new Connection();

    static String getLoginPass() {
        return loginPass;
    }

    public boolean tryAuth(String login, String pass) {
        save(login, pass);

        try {
            Role role = server.getUserRole();
            ServerAuth.role = role;
            return true;
        } catch (MyCustomException e) {
            System.out.println(e.getStatusCode());
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return false;
    }

    private void save(String login, String pass) {
        byte[] bytes = (login + ":" + pass).getBytes();
        loginPass = "Basic " + Base64.getEncoder().encodeToString(bytes);;
    }
}
