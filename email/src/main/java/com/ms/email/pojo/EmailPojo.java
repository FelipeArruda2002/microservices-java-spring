package com.ms.email.pojo;

import java.util.UUID;

public record EmailPojo(UUID userId,
                        String emailTo,
                        String subject,
                        String  text) {
}
