package com.example.springpluginstrategy.interfaces;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultWriter implements WriterPlugin {

    String format = "";

    @Override
    public void write(String message) {
        log.info("Writing from Default Writer: {} for the format: {}", message, format);
    }

    @Override
    public boolean supports(String s) {
        format = s;
        return !"csv,txt".contains(s);
    }
}
