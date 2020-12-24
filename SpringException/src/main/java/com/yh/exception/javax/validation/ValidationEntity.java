package com.yh.exception.javax.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 */
public class ValidationEntity {

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$")
    private String email;

    /**
     * 验证ip
     */
    @Pattern(regexp = "^((25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))$"
    )
    private String ip;

    public ValidationEntity() {
    }

    public ValidationEntity(String email, String ip) {
        this.email = email;
        this.ip = ip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
