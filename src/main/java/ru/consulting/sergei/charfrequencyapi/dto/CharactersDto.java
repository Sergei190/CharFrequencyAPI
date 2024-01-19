package ru.consulting.sergei.charfrequencyapi.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * DTO (Data Transfer Object) for the characters to count.
 */
public record CharactersDto(
        @ApiModelProperty(example = "aaaaabcccc")
        String symbols
) {

    /**
     * Constructs a new CharactersDto object.
     *
     * @param symbols The string of characters to count.
     */
    public CharactersDto {
    }
}