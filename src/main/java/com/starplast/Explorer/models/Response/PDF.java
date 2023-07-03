package com.starplast.Explorer.models.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.ALWAYS)
public class PDF {
    byte[] pdf;
}
