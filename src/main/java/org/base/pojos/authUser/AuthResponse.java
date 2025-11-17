package org.base.pojos.authUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    @JsonProperty("refresh")
    private String refresh;

    @JsonProperty("access")
    private String access;
}
