package com.chatback.pojos.activity.promptActivity;

import com.chatback.pojos.activity.Activity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@ToString
@SuperBuilder
public class PromptActivity extends Activity
{
    @JsonProperty("prompt")
    protected String prompt;


}
