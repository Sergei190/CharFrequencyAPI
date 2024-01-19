package ru.consulting.sergei.charfrequencyapi.controllers;

import ru.consulting.sergei.charfrequencyapi.dto.CharactersDto;
import ru.consulting.sergei.charfrequencyapi.services.CountCharactersService;
import io.swagger.annotations.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "CountSymbols", description = "Операции связанные с подсчетом символов")
@Controller
@RestController
@RequestMapping("/api")
public class CountCharacters {
    final CountCharactersService countCharactersService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public CountCharacters(CountCharactersService countCharactersService) {
        this.countCharactersService = countCharactersService;
    }

    /**
     * Endpoint for counting characters in a string.
     *
     * @param symbols The object containing the characters to count.
     * @return The response entity with a hash map of characters and their counts.
     */
    @ApiOperation(value = "Подсчет символов в строке")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Успешный запрос. Возвращает хеш-таблицу символов и их количества.",
                    examples = @Example({
                            @ExampleProperty(mediaType = "application/json", value = "{\"a\": 5, \"с\": 4, \"b\": 1}")
                    })),
            @ApiResponse(code = 400, message = "Неверный запрос. Возвращается в случае ошибки в запросе."),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервера. Возвращается в случае ошибки на сервере.")
    })
    @PostMapping(path = "/count", produces = "application/json")
    @Cacheable(value = "count")
    public ResponseEntity<Map<Character, Integer>> count(
            @ApiParam(value = "Объект, содержащий строку символов")
            @RequestBody
            @NotNull CharactersDto symbols
    ) {
        return ResponseEntity.ok().body(countCharactersService.count(symbols.symbols().toCharArray()));
    }
}