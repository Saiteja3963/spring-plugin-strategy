package com.example.springpluginstrategy;

import com.example.springpluginstrategy.interfaces.WriterPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.plugin.core.config.EnablePluginRegistries;

@SpringBootApplication
@EnablePluginRegistries(WriterPlugin.class)
public class SpringPluginStrategyApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringPluginStrategyApplication.class, args);
    }

    @Autowired
    PluginRegistry<WriterPlugin, String> plugins;

    @Override
    public void run(ApplicationArguments args) {
        for (String format : "csv,txt,xlsx".split(",")) {
            plugins.getPluginFor(format).get().write("Hello World!");
        }
    }
}
