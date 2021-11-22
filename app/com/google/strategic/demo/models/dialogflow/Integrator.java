package com.google.strategic.demo.models.dialogflow;


import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

@Singleton
public class Integrator
{
    private static Integrator single_instance = null;
    public static String displayName = "";
    public static String intentId = "";
    public static List<String> messageTexts = new ArrayList<>();
    public static List<String> trainingPhrasesParts = new ArrayList<>();
    private static String projectId = "";
    private static ArrayList<String> queryDecodedUserInput = new ArrayList<>();
    private static String sessionId = "";
    private static String languageCode = "";
    private static String intentOutput=null;


    public String config;

    // private constructor restricted to this class itself
    @Inject
    private Integrator()
    {
        config = "to be updated later";
        //to insert project id and other private info
    }

    // static method to create instance of Singleton class
    public static Integrator getInstance(String[] args) throws Exception {
        String method = "";
        InteractionLayer interactCall=new InteractionLayer();
        try {
            method = args[0];
            String command = args[1];
            if (method.equals("list")) {
                if (command.equals("--projectId")) {
                    projectId = args[2];
                }
            } else if (method.equals("create")) {
                displayName = args[1];
                command = args[2];
                if (command.equals("--projectId")) {
                    projectId = args[3];
                }
                System.out.println(args.length);
                for (int i = 4; i < args.length; i += 1) {
                    if (args[i].equals("--messageTexts")) {
                        while ((i + 1) < args.length && !args[(i + 1)].contains("--")) {
                            messageTexts.add(args[++i]);
                            System.out.println(args[i]);
                        }
                        // input.put("messageTexts",messageTexts.);
                    } else if (args[i].equals("--trainingPhrasesParts")) {
                        while ((i + 1) < args.length && !args[(i + 1)].contains("--")) {
                            trainingPhrasesParts.add(args[++i]);
                            System.out.println(args[i]);
                        }
                    }
                }
            } else if (method.equals("delete")) {
                intentId = args[1];
                command = args[2];
                if (command.equals("--projectId")) {
                    projectId = args[3];
                }
            }
        } catch (Exception e) {
            System.out.println("Usage:");
            System.out.println("mvn exec:java -DIntentManagement "
                    + "-Dexec.args='list --projectId PROJECT_ID'\n");

            System.out.println("mvn exec:java -DIntentManagement "
                    + "-Dexec.args='create \"room.cancellation - yes\" --projectId PROJECT_ID "
                    + "--trainingPhrasesParts \"cancel\" \"cancellation\""
                    + "--messageTexts \"Are you sure you want to cancel?\" \"Cancelled.\"'\n");

            System.out.println("mvn exec:java -DIntentManagement "
                    + "-Dexec.args='delete INTENT_ID --projectId PROJECT_ID'\n");

            System.out.println("Commands: list");
            System.out.println("\t--projectId <projectId> - Project/Agent Id");

            System.out.println("Commands: create");
            System.out.println("\t--projectId <projectId> - Project/Agent Id");
            System.out.println("\t<displayName> - [For create] The display name of the intent.");
            System.out.println("\nOptional Commands [For create]:");
            System.out.println("\t--trainingPhrasesParts <trainingPhrasesParts> - Training phrases.");
            System.out.println("\t--messageTexts <messageTexts> - Message texts for the agent's "
                    + "response when the intent is detected.");

            System.out.println("Commands: delete");
            System.out.println("\t--projectId <projectId> - Project/Agent Id");
            System.out.println("\t<intentId> - [For delete] The id of the intent.");
        }
        System.out.println("method"+method);
        if (method.equals("list")) {
            System.out.println(interactCall.listIntents(projectId));
            //intl.doQuery("list_intents",inpr);
        } else if (method.equals("create")) {
            System.out.println("create");
            interactCall.createIntent(displayName, projectId, trainingPhrasesParts, messageTexts);
        } else if (method.equals("delete")) {
            System.out.println("delete");
            interactCall.deleteIntent(intentId, projectId);
        }
        if (single_instance == null)
            single_instance = new Integrator();
        return single_instance;
    }
    public static String getIntent(HashMap<String,String> inputArgsToDialogflow) throws Exception {
        InteractionLayer interactionDetectIntent=new InteractionLayer();
        projectId = inputArgsToDialogflow.get("--projecID");
        sessionId = inputArgsToDialogflow.get("--sessionId");
        languageCode = inputArgsToDialogflow.get("--languageCode");
        queryDecodedUserInput.add(inputArgsToDialogflow.get("--userInput"));
        intentOutput=interactionDetectIntent.detectIntentTexts(projectId, queryDecodedUserInput, sessionId, languageCode);
        return intentOutput;
    }
}