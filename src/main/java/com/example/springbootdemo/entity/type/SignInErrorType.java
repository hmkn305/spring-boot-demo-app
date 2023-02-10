package com.example.springbootdemo.entity.type;

import com.example.springbootdemo.entity.*;
import lombok.*;


@Getter
@AllArgsConstructor
public enum SignInErrorType implements CodeEnum {

    NotRegisteredEmail(1, "メールアドレスが登録されていません"),
    NotMatchedPassword(2, "パスワードが間違っています"),
    AlreadyRegisteredEmail(3, "既にメールアドレスが登録されています");

    private final int code;
    private final String label;

}
