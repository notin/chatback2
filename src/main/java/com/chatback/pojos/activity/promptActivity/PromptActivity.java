package com.chatback.pojos.activity.promptActivity;

import com.chatback.pojos.activity.Activity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;

@Data
@Builder
@Entity
@ToString
public class PromptActivity extends Activity
{
    @JsonProperty("prompt")
    private String prompt;
}
