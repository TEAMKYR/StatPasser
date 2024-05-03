package teamkyr.pokemon;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class StatPasserUnitTests {
    @Test
    public void testSvdexPath() {
        String expectedStr = "{\"input\":{\"start\":\"meowscarada\",\"pokedex\":\"svdex\",\"end\":\"bombirdier\"},\"path\":[[{\"gender\":\"-\",\"name\":\"Meowscarada\"}],[{\"gender\":\"male\",\"name\":\"Meowscarada\"},{\"gender\":\"female\",\"name\":\"Cacturne\"}],[{\"gender\":\"male\",\"name\":\"Cacturne\"},{\"gender\":\"female\",\"name\":\"Hawlucha\"}],[{\"gender\":\"male\",\"name\":\"Hawlucha\"},{\"gender\":\"female\",\"name\":\"Bombirdier\"}],[{\"gender\":\"-\",\"name\":\"Bombirdier\"}]]}";
        JSONParser parser = new JSONParser();
        JSONObject expected = null;
        try {
            expected = (JSONObject) parser.parse(expectedStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        StatPasser sp = new StatPasser();
        JSONObject result = sp.getStat("meowscarada", "bombirdier", "svdex");
        assertEquals(expected, result);
    }

    @Test
    public void testSvdlcdexPath() {
        String expectedStr = "{\"input\":{\"start\":\"meowscarada\",\"pokedex\":\"svdlcdex\",\"end\":\"bombirdier\"},\"path\":[[{\"gender\":\"-\",\"name\":\"Meowscarada\"}],[{\"gender\":\"male\",\"name\":\"Meowscarada\"},{\"gender\":\"female\",\"name\":\"Dipplin\"}],[{\"gender\":\"male\",\"name\":\"Dipplin\"},{\"gender\":\"female\",\"name\":\"Noivern\"}],[{\"gender\":\"male\",\"name\":\"Noivern\"},{\"gender\":\"female\",\"name\":\"Bombirdier\"}],[{\"gender\":\"-\",\"name\":\"Bombirdier\"}]]}";

        JSONParser parser = new JSONParser();
        JSONObject expected = null;
        try {
            expected = (JSONObject) parser.parse(expectedStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        StatPasser sp = new StatPasser();
        JSONObject result = sp.getStat("meowscarada", "bombirdier", "svdlcdex");
        assertEquals(expected, result);
    }
}