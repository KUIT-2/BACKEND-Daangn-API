package com.kuit.backenddaangnapi.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity(name = "User")
@ToString
@NoArgsConstructor
public class User{
    @Id
    @Column(nullable = false, length = 50)
    private String userId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, length = 50)
    private String nickname;

    @Builder
    public User(String userId, String password, String nickname) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
    }
}
