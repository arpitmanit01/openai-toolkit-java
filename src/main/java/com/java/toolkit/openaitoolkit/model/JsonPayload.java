package com.java.toolkit.openaitoolkit.model;

public class JsonPayload {
    private String model;
    private String prompt;
    private Double temperature;
    private Integer max_tokens;
    private Double top_p;
    private Double frequency_penalty;
    private Double presence_penalty;

    public JsonPayload() {

    }

    public JsonPayload(String model, String prompt, Double temperature, Integer max_tokens, Double top_p, Double frequency_penalty, Double presence_penalty) {
        this.model = model;
        this.prompt = prompt;
        this.temperature = temperature;
        this.max_tokens = max_tokens;
        this.top_p = top_p;
        this.frequency_penalty = frequency_penalty;
        this.presence_penalty = presence_penalty;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(Integer max_tokens) {
        this.max_tokens = max_tokens;
    }

    public Double getTop_p() {
        return top_p;
    }

    public void setTop_p(Double top_p) {
        this.top_p = top_p;
    }

    public Double getFrequency_penalty() {
        return frequency_penalty;
    }

    public void setFrequency_penalty(Double frequency_penalty) {
        this.frequency_penalty = frequency_penalty;
    }

    public Double getPresence_penalty() {
        return presence_penalty;
    }

    public void setPresence_penalty(Double presence_penalty) {
        this.presence_penalty = presence_penalty;
    }

    @Override
    public String toString() {
        return "JsonPayload{" +
                "model='" + model + '\'' +
                ", prompt='" + prompt + '\'' +
                ", temperature=" + temperature +
                ", max_tokens=" + max_tokens +
                ", top_p=" + top_p +
                ", frequency_penalty=" + frequency_penalty +
                ", presence_penalty=" + presence_penalty +
                '}';
    }
}
