package com.example.javaarchitecture.qualifier;

import javax.inject.Qualifier;

@Qualifier
public @interface DatabaseMigration {
    public String value();
}
