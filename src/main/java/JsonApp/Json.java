package JsonApp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Json {
    public static void main(String[] args) throws IOException {
        Person person1 = new Person("Samir", "Allahverdiyev", 22, Arrays.asList(9, 21, 2));
        Person person2 = new Person("Nazim", "Allahverdiyev", 12, Arrays.asList(1, 2, 3));

        ObjectMapper mapper = new XmlMapper();
// serialize
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File("test2.xml"), person1);

// deserialize
//        mapper.setDa
//        Person person = mapper.readValue(new File("test.JSON"), Person.class);

//        System.out.println(person);


    }
}
