package org.base.pojos.createUser;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String username;
    private String password;
}
