package com.example.currency_service.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserBean {
    private String avatarUrl;
    private String banner_image;
    private String banner_url;
    private String profile_url;
    private String username;
    private String display_name;
    private String description;
    private String instagram_url;
    private String website_url;
    private Boolean is_verified;
}
