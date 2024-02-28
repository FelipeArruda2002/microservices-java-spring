package com.ms.user.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserPojo (@NotBlank String name,
                        @NotBlank @Email String email){

}
