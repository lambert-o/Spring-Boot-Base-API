package com.base.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
@Schema(name = "HelloDto")
public class HelloDto {

    @Schema(description = "The name received via the hello endpoint", example = "Owen Lambert")
    String name;
}
