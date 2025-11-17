package org.base.pojos.createUser;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.base.helpers.dataDeserializer.DataDeserializer;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {
    private int id;
    private String username;

    @JsonProperty("is_active")
    private boolean active;

    @JsonProperty("is_staff")
    private boolean staff;

    @JsonProperty("is_superuser")
    private boolean superuser;


    private String last_login;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
    @JsonDeserialize(using = DataDeserializer.class)
    private LocalDateTime created;
    private String updated;
}
