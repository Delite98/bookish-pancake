package parser;

import api.UserModel;
import com.google.gson.Gson;

import java.io.FileReader;

public class GsonParser {

    public UserModel parserUserModel(String nameOfTheFile) {

        try (FileReader reader = new FileReader(nameOfTheFile)) {
            UserModel createUser = new Gson().fromJson(reader, UserModel.class);

            return createUser;
        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }

        return null;
    }
}
