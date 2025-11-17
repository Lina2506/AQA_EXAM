package org.base.pojos.authMe;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.*;
import org.base.helpers.dataDeserializer.DataDeserializer;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthMeResponse {
    private int id;
    private String username;

    @JsonProperty("is_active")
    private boolean isActive;

    @JsonProperty("is_staff")
    private boolean isStaff;

    @JsonProperty("is_superuser")
    private boolean isSuperuser;


    private String last_login;
    private String created;
    private String updated;
}
