package com.google.strategic.demo.controllers;

import com.sun.tools.sjavac.Log;
import org.slf4j.LoggerFactory;
import play.Logger;
import play.mvc.*;
import javax.inject.Inject;
import java.util.HashMap;
import play.libs.Json;
import com.google.strategic.demo.models.dialogflow.*;
import com.google.strategic.demo.models.cloudsql.Connector;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    private final Integrator integrator;
    private final Connector connection =null;
    private String userQueryInput="";
    private String clientSessionIdGenerated=null;
    private String projectId;
    private String queryDecoded=null;
    private String fullfilmentInput="";
    private String sqlOutput;
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(HomeController.class);
    @Inject

    public HomeController(Integrator integrator) {
        this.integrator = integrator;
    }

    public Result index() throws Exception {
        HashMap<String, String> inputArgsToDialogflow = new HashMap<>();
        HashMap<String, String> outputResponse = new HashMap<>();
        //Web client interacts with this microservice by calling:
        //http://hostip:portnumber/search?query=userquery&n=sessionid
        userQueryInput = request().getQueryString("query");
        //Get the session ID from the webclient to maintain search chat flow (like follow ups)
        clientSessionIdGenerated=request().getQueryString("n");
        projectId="yourprojectid";

        if (userQueryInput.matches("(.*)[h,H]i(.*)")) {
            outputResponse.put("content", String.format("Welcome to Search Bot"));
        }
        else {
            queryDecoded = java.net.URLDecoder.decode(userQueryInput, "UTF-8");
            //String[] inputArgsToDialogflow=new String[]{"--projectId",projectId,"--sessionId","ces session id"+clientSessionIdGenerated,"--languageCode","en-US",queryDecoded};
            inputArgsToDialogflow.put("--projecID",projectId);
            inputArgsToDialogflow.put("--sessionId","ces session id"+clientSessionIdGenerated);
            inputArgsToDialogflow.put("--languageCode","en-US");
            inputArgsToDialogflow.put("--userInput",queryDecoded);
            //Eg: --languageCode en-US "How many products are available in sample table"
            Log.info("input text: " + queryDecoded);
            String answer= integrator.getIntent(inputArgsToDialogflow);
           // Map<String, String> result=IntentManagement.getInput(query);
            //response.put("content", String.format("Hi, what are you looking for? "));
            outputResponse.put("content", answer);
            outputResponse.put("session", clientSessionIdGenerated);
        }
        return ok(Json.toJson(outputResponse));
    }

    //To generate results to Dialogflow Fullfilment component
    public Result db() throws Exception {
        String inputDecoded="";
        HashMap<String, String> sqlResponse = new HashMap<>();
        fullfilmentInput = request().getQueryString("inp");
        inputDecoded = java.net.URLDecoder.decode(fullfilmentInput, "UTF-8");
        sqlOutput= connection.readDatabase(inputDecoded);
        sqlResponse.put("content", sqlOutput);
        return ok(Json.toJson(sqlResponse));

    }
}
