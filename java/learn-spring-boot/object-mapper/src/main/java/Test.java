import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.HashSet;

public class Test {

    public static void main(String[] args) throws JsonProcessingException {
        User user = new User();
        user.age = 20;
        user.username = "test";
        user.hobbies = Arrays.asList("x", "y", "z").toArray(new String[]{});
        user.phones = new HashSet<String>(Arrays.asList("a", "b", "c"));
        user.valid = true;

        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        System.out.println(value);
    }

}
