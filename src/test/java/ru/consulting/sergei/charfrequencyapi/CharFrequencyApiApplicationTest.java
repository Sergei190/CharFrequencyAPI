package ru.consulting.sergei.charfrequencyapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CharFrequencyApiApplicationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetCharacterFrequency() {
        String input = "aaaaabcccc";
        Map<Character, Long> result = this.restTemplate.getForObject("http://localhost:" + port + "/frequency?input={input}", Map.class, input);
        assertThat(result.get('a')).isEqualTo(5);
        assertThat(result.get('c')).isEqualTo(4);
        assertThat(result.get('b')).isEqualTo(1);
    }
}
