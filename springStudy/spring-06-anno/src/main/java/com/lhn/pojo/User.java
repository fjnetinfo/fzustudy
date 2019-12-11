package com.lhn.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class User {
    @Value("lhn")//也可以用于set方法
    public String name;
}
