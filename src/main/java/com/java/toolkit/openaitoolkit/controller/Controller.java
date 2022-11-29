package com.java.toolkit.openaitoolkit.controller;

import com.java.toolkit.openaitoolkit.model.JsonPayload;
import com.java.toolkit.openaitoolkit.model.JsonPayloadWS;
import com.java.toolkit.openaitoolkit.service.HelperService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


@RestController
@RequestMapping("/v1")
public class Controller {

    @GetMapping("/q-and-a")
    @Operation(
            summary = "Answer questions based on existing knowledge.",
            description = "Sample Prompt 1 - Q: What is the Area of Earth ? \n\n Sample Prompt 2 - Q: What would be the angular velocity of a particle rotating at a distance of 5 m from center and having velocity 35 m/s ? "
    )
    public Map<String, Object> questionAndAnswer(@RequestParam(name = "prompt", required = true) String prompt,
                                                 @RequestParam(name = "ml_model", defaultValue = "text-davinci-002") String ml_model,
                                                 @RequestParam(name = "temperature", defaultValue = "0") Double temperature,
                                                 @RequestParam(name = "max_tokens", defaultValue = "100") Integer max_tokens,
                                                 @RequestParam(name = "top_p", defaultValue = "1") Double top_p,
                                                 @RequestParam(name = "frequency_penalty", defaultValue = "0.0") Double frequency_penalty,
                                                 @RequestParam(name = "presence_penalty", defaultValue = "0.0") Double presence_penalty,
                                                 @RequestParam(name = "stop", defaultValue = "\\n") String stop) throws IOException {

        ArrayList<String> stops = new ArrayList<>();
        stops.add(stop);

        String[] all_stops = new String[stops.size()];
        all_stops = stops.toArray(all_stops);

        JsonPayloadWS jsonPayloadWS = new JsonPayloadWS(ml_model, prompt, temperature, max_tokens, top_p, frequency_penalty, presence_penalty, all_stops);

        HelperService helperService = new HelperService();

        Map<String, Object> response = helperService.sendRequestToOpenAI(jsonPayloadWS);

        return response;

    }

    @Operation(
            summary = "Translates difficult text into simpler concepts.",
            description = "Sample Prompt : \n\n Summarize this for a second-grade student:\n\n" +
                    "Jupiter is the fifth planet from the Sun and the largest in the Solar System. It is a gas giant with a mass one-thousandth that of the Sun, but two-and-a-half times that of all the other planets in the Solar System combined. Jupiter is one of the brightest objects visible to the naked eye in the night sky, and has been known to ancient civilizations since before recorded history. It is named after the Roman god Jupiter. When viewed from Earth, Jupiter can be bright enough for its reflected light to cast visible shadows, and is on average the third-brightest natural object in the night sky after the Moon and Venus.\n\n"
    )
    @GetMapping("/summarize-for-a-2nd-grader")
    public Map<String, Object> summarizeForASecondGrader(@RequestParam(name = "prompt", required = true) String prompt,
                                                         @RequestParam(name = "ml_model", defaultValue = "text-davinci-002") String ml_model,
                                                         @RequestParam(name = "temperature", defaultValue = "0.7") Double temperature,
                                                         @RequestParam(name = "max_tokens", defaultValue = "64") Integer max_tokens,
                                                         @RequestParam(name = "top_p", defaultValue = "1.0") Double top_p,
                                                         @RequestParam(name = "frequency_penalty", defaultValue = "0.0") Double frequency_penalty,
                                                         @RequestParam(name = "presence_penalty", defaultValue = "0.0") Double presence_penalty) throws IOException {

        JsonPayload jsonPayload = new JsonPayload(ml_model, prompt, temperature, max_tokens, top_p, frequency_penalty, presence_penalty);

        HelperService helperService = new HelperService();

        Map<String, Object> response = helperService.sendRequestToOpenAI(jsonPayload);

        return response;

    }
    @Operation(
            summary = "Corrects sentences into standard English.",
            description = "Sample Prompt : \n\nCorrect this to standard English:\n\n" +
                    "She no went to the market."
    )
    @GetMapping("/grammar-correction")
    public Map<String, Object> grammarCorrection(@RequestParam(name = "prompt", required = true) String prompt,
                                                 @RequestParam(name = "ml_model", defaultValue = "text-davinci-002") String ml_model,
                                                 @RequestParam(name = "temperature", defaultValue = "0") Double temperature,
                                                 @RequestParam(name = "max_tokens", defaultValue = "60") Integer max_tokens,
                                                 @RequestParam(name = "top_p", defaultValue = "1.0") Double top_p,
                                                 @RequestParam(name = "frequency_penalty", defaultValue = "0.0") Double frequency_penalty,
                                                 @RequestParam(name = "presence_penalty", defaultValue = "0.0") Double presence_penalty) throws IOException {

        JsonPayload jsonPayload = new JsonPayload(ml_model, prompt, temperature, max_tokens, top_p, frequency_penalty, presence_penalty);

        HelperService helperService = new HelperService();

        Map<String, Object> response = helperService.sendRequestToOpenAI(jsonPayload);

        return response;

    }

    @Operation(
            summary = "Create code to call to the OpenAI API using a natural language instruction.",
            description = "Sample Prompt : \n\n"+
                    "\"\"\"\n\n" +
                    "Util exposes the following:\n\n" +
                    "util.openai() -> authenticates & returns the openai module, which has the following functions:\n\n" +
                    "openai.Completion.create(\n\n" +
                    "    prompt=\"<my prompt>\", # The prompt to start completing from\n\n" +
                    "    max_tokens=123, # The max number of tokens to generate\n\n" +
                    "    temperature=1.0 # A measure of randomness\n\n" +
                    "    echo=True, # Whether to return the prompt in addition to the generated completion\n\n" +
                    ")\n\n" +
                    "\"\"\"\n\n" +
                    "import util\n\n" +
                    "\"\"\"\n\n" +
                    "Create an OpenAI completion starting from the prompt \"Once upon an AI\", no more than 5 tokens. Does not include the prompt.\n\n" +
                    "\"\"\""
    )
    @GetMapping("/natural-language-to-openai-api")
    public Map<String, Object> naturalLanguageToOpenAIAPI(@RequestParam(name = "prompt", required = true) String prompt,
                                                 @RequestParam(name = "ml_model", defaultValue = "text-davinci-002") String ml_model,
                                                 @RequestParam(name = "temperature", defaultValue = "0") Double temperature,
                                                 @RequestParam(name = "max_tokens", defaultValue = "64") Integer max_tokens,
                                                 @RequestParam(name = "top_p", defaultValue = "1.0") Double top_p,
                                                 @RequestParam(name = "frequency_penalty", defaultValue = "0.0") Double frequency_penalty,
                                                 @RequestParam(name = "presence_penalty", defaultValue = "0.0") Double presence_penalty,
                                                 @RequestParam(name = "stop", defaultValue = "\"\"\"") String stop) throws IOException {

        ArrayList<String> stops = new ArrayList<>();
        stops.add(stop);

        String[] all_stops = new String[stops.size()];
        all_stops = stops.toArray(all_stops);

        JsonPayloadWS jsonPayloadWS = new JsonPayloadWS(ml_model, prompt, temperature, max_tokens, top_p, frequency_penalty, presence_penalty, all_stops);

        HelperService helperService = new HelperService();

        Map<String, Object> response = helperService.sendRequestToOpenAI(jsonPayloadWS);

        return response;

    }

    @Operation(
            summary = "Translate text into programmatic commands.",
            description = "Sample Prompt : \n\n"+
            "Convert this text to a programmatic command:\n\n" +
            "\n\n" +
            "Example: Ask Alan if we need some bread\n\n" +
            "Output: send-msg `find Alan` Do we need some bread?\n\n" +
            "\n\n" +
            "Contact the ski store and figure out if I can get my skis fixed before I leave on Thursday"
    )
    @GetMapping("/text-to-command")
    public Map<String, Object> textToCommand(@RequestParam(name = "prompt", required = true) String prompt,
                                             @RequestParam(name = "ml_model", defaultValue = "text-davinci-002") String ml_model,
                                             @RequestParam(name = "temperature", defaultValue = "0.0") Double temperature,
                                             @RequestParam(name = "max_tokens", defaultValue = "100") Integer max_tokens,
                                             @RequestParam(name = "top_p", defaultValue = "1.0") Double top_p,
                                             @RequestParam(name = "frequency_penalty", defaultValue = "0.2") Double frequency_penalty,
                                             @RequestParam(name = "presence_penalty", defaultValue = "0.0") Double presence_penalty,
                                             @RequestParam(name = "stop", defaultValue = "\\n") String stop) throws IOException {

        ArrayList<String> stops = new ArrayList<>();
        stops.add(stop);

        String[] all_stops = new String[stops.size()];
        all_stops = stops.toArray(all_stops);

        JsonPayloadWS jsonPayloadWS = new JsonPayloadWS(ml_model, prompt, temperature, max_tokens, top_p, frequency_penalty, presence_penalty, all_stops);

        HelperService helperService = new HelperService();

        Map<String, Object> response = helperService.sendRequestToOpenAI(jsonPayloadWS);

        return response;

    }
}
