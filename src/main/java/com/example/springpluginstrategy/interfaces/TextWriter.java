package com.example.springpluginstrategy.interfaces;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TextWriter implements WriterPlugin {
    String format = "TXT";

    @Override
    public void write(String message) {
        log.info("Writing from Text Writer: {} for the format: {}", message, format);
    }

    @Override
    public boolean supports(String s) {
        return s.equalsIgnoreCase(format);
    }
}
