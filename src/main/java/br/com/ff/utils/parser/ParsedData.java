package br.com.ff.utils.parser;

import br.com.ff.models.Action;
import br.com.ff.models.Configuration;
import br.com.ff.models.Entity;
import br.com.ff.models.Queue;

import java.util.List;

public class ParsedData {

    Configuration configuration;
    List<Entity> entities;
    List<Queue> queues;
    List<Action> actions;

    public Configuration getConfiguration() {
        return configuration;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Queue> getQueues() {
        return queues;
    }

    public List<Action> getActions() {
        return actions;
    }
}
