package ru.consulting.sergei.charfrequencyapi.services;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The CountCharactersService class provides a method to count the frequency of characters in a given array.
 */
public class CountCharactersService {

    /**
     * Sorts the given map by value in descending order and returns the sorted map.
     *
     * @param map The map to be sorted.
     * @return The sorted map.
     */
    private @NotNull Map<Character, Integer> sortedMap(@NotNull Map<Character, Integer> map) {
        Map<Character, Integer> sortedCharacterCount = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> sortedCharacterCount.put(entry.getKey(), entry.getValue()));
        return sortedCharacterCount;
    }

    /**
     * Counts the frequency of characters in the given char array and returns a map containing the character count.
     *
     * @param characters The char array to count the characters in.
     * @return A map containing the character count.
     */
    public Map<Character, Integer> count(char @NotNull [] characters) {
        Map<Character, Integer> characterCount = new HashMap<>();
        for (char character : characters) {
            characterCount.put(character, characterCount.getOrDefault(character, 0) + 1);
        }

        return sortedMap(characterCount);
    }
}