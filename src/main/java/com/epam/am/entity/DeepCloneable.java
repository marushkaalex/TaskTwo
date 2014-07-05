package com.epam.am.entity;

public interface DeepCloneable<T extends DeepCloneable> {
    T deepClone();
}
