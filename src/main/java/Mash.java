import events.HelloEvent;
import events.MyListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Mash {

    public static void main(String[] args) throws Exception {

        JSONParser jsonParser = new JSONParser();

        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:\\Users\\Mash\\Documents\\mashfig.json"));

        String token = (String) jsonObject.get("token");

        JDA jda = JDABuilder.createDefault(token).build();

        jda.addEventListener(new HelloEvent());
        jda.addEventListener(new MyListener());

    }

}
