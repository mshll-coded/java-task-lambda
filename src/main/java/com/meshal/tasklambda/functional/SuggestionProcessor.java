package com.meshal.tasklambda.functional;

@FunctionalInterface
public interface SuggestionProcessor {
    public void process(String text, int rate);
}
