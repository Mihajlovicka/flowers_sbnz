package com.ftn.sbnz.dto;

import com.ftn.sbnz.model.user.EnvironmentPreferences;
import com.ftn.sbnz.model.user.LookPreferences;
import com.ftn.sbnz.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecommendPreferences {
    private LookPreferences look;
    private EnvironmentPreferences env;
    private String user;
}
