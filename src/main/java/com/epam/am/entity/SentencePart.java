package com.epam.am.entity;

public interface SentencePart extends DeepCloneable<SentencePart>, TextPart {
    public String toOriginal();
}
