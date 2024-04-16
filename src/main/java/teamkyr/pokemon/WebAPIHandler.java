package teamkyr.pokemon;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import java.io.*;
import java.util.Objects;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WebAPIHandler implements RequestStreamHandler {
    @Override
    public void handleRequest(
            InputStream inputStream, OutputStream outputStream, Context context)
            throws IOException {

        // implementation
    }

    public void handleGetByParam(
            InputStream inputStream, OutputStream outputStream, Context context)
            throws IOException {

        JSONParser parser = new JSONParser();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        JSONObject responseJson = new JSONObject();

        try {
            String start = "unknown";
            String end = "unknown";

            JSONObject event = (JSONObject) parser.parse(reader);
            JSONObject responseBody = new JSONObject();

            /*if (event.get("pathParameters") != null) {
                JSONObject pps = (JSONObject) event.get("pathParameters");
                if (pps.get("id") != null) {
                    int id = Integer.parseInt((String) pps.get("id"));

                }
            } else*/ if (event.get("queryStringParameters") != null) {
                JSONObject qps = (JSONObject) event.get("queryStringParameters");

                if (qps.get("start") != null) {
                    start = (String) qps.get("start");
                }
                if (qps.get("end") != null) {
                    end = (String) qps.get("end");
                }
            }

            responseBody.put("result", new JSONObject());
            if ((!start.equals("unknown") && (!end.equals("unknown")))) {
                StatPasser sp = new StatPasser();
                JSONObject resultObj = sp.getStat(start, end, Pokedexes.getDex(Pokedexes.SVDLC_DEX));
                responseBody.put("result", resultObj);
            }

            responseJson.put("statusCode", 200);

            JSONObject headerJson = new JSONObject();
            headerJson.put("x-custom-header", "my custom header value");

            responseJson.put("headers", headerJson);
            responseJson.put("body", responseBody.toString());

        } catch (ParseException pex) {
            responseJson.put("statusCode", 400);
            responseJson.put("exception", pex);
        }

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseJson.toString());
        writer.close();
    }
}

