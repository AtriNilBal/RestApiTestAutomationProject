package org.atrinil.api.reqresservice.pojo;

import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain=true)
@Data
public class UserDetails {
    private String name;
    private String job;
}
