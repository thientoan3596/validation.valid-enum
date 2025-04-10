package com.github.thientoan3596.validator;

import com.github.thientoan3596.constraint.ValidEnum;

public class MultiFieldDTO {
    @ValidEnum(enumClass = Status.class, message = "Status must be one of: ACTIVE, INACTIVE, PENDING")
    private String status;
    private String name;

    public MultiFieldDTO(String status, String name) {
        this.status = status;
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
