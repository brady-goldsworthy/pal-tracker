package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String s1, s2, s3, s4;

    public EnvController(@Value("${port:8080}") String s1, @Value("${memory.limit:1024}") String s2, @Value("${cf.instance.index:NOT SET}") String s3, @Value("${cf.instance.addr:NOT SET}") String s4) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> envMap = new HashMap<>();
        envMap.put("PORT", s1);
        envMap.put("MEMORY_LIMIT", s2);
        envMap.put("CF_INSTANCE_INDEX", s3);
        envMap.put("CF_INSTANCE_ADDR", s4);
        return envMap;
    }
}
