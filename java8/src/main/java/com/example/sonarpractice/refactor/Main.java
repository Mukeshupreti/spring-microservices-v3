package com.example.sonarpractice.refactor;

import java.util.*;

public class Main {
    public static void main(String[] args){
        // legacy
        LegacyComponent legacy = new LegacyComponent();
        legacy.save("data");
        // refactored
        Repository repo = new InMemoryRepository();
        Logger logger = new SimpleLogger();
        Validator validator = new SimpleValidator();
        Service svc = new Service(repo, logger, validator);
        svc.save("ok-data");
    }
}

// Legacy class violating SRP
class LegacyComponent {
    public void save(String data){
        // validate
        if(data==null || data.isEmpty()) throw new IllegalArgumentException("invalid");
        // persist - dummy
        System.out.println("Persisting: " + data);
        // log
        System.out.println("Logging: saved");
    }
}

// Refactored interfaces
interface Repository { void save(String data); }
interface Logger { void info(String msg); }
interface Validator { void validate(String data); }

class InMemoryRepository implements Repository {
    public void save(String data){ System.out.println("[Repo] " + data); }
}

class SimpleLogger implements Logger { public void info(String msg){ System.out.println("[Log] " + msg); } }

class SimpleValidator implements Validator {
    public void validate(String data){ if(data==null || data.isEmpty()) throw new IllegalArgumentException("invalid"); }
}

class Service {
    private final Repository repo; private final Logger logger; private final Validator validator;
    public Service(Repository repo, Logger logger, Validator validator){
        this.repo=repo; this.logger=logger; this.validator=validator;
    }
    public void save(String data){
        validator.validate(data);
        repo.save(data);
        logger.info("saved");
    }
}
