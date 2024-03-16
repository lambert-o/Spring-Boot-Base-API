package com.base.domain.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a request for a "Hello" object.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelloRequest {

  @NotBlank(message = "Name is required")
  public String name;
}
