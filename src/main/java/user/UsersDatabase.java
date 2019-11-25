package user;

import encoder.Encoder;
import exception.EncoderException;
import exception.NoSuchUserException;
import exception.UsersDatabaseException;
import helper.JSONHelper;
import org.json.simple.JSONObject;

public class UsersDatabase {

    private static final String usersJSONFile = "src/main/resources/users.json";

    /* Singleton instance */
    private static UsersDatabase usersDatabase;

    private JSONObject usersJson;

    public static UsersDatabase getInstance() throws UsersDatabaseException {
        if(usersDatabase == null) {
            usersDatabase = new UsersDatabase();
        }
        return usersDatabase;
    }

    private UsersDatabase() throws UsersDatabaseException {
        try {
            usersJson = JSONHelper.fileToJSONObject(usersJSONFile);
        } catch (Exception e) {
            throw new UsersDatabaseException(e);
        }
    }

    public User getUser(String user) throws NoSuchUserException, EncoderException {
        JSONObject userObject = (JSONObject) usersJson.get(user);
        if(userObject == null) {
            throw new NoSuchUserException();
        }
        String email = Encoder.getInstance().decrypt((String) userObject.get("email"));
        String password = Encoder.getInstance().decrypt((String) userObject.get("password"));
        return new User(email, password);
    }

}
