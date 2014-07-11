package com.epam.am.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCompoundText<T extends TextPart> implements CompoundText<T> {
    protected final List<T> components;

    protected AbstractCompoundText(List<T> components) {
        this.components = components;
    }

    protected AbstractCompoundText() {
        components = new ArrayList<>();
    }

    protected boolean add(T element) {
        return components.add(element);
    }
}
