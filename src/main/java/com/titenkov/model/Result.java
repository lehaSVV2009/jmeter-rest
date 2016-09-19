package com.titenkov.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.jmeter.reporters.Summariser;

/**
 * Created by titenkov on 9/18/16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Result {

    @JsonProperty
    private String log;

    public Result(Summariser summariser) {
        log = summariser.toString();
    }
}
