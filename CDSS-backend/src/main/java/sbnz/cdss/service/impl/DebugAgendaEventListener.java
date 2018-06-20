package sbnz.cdss.service.impl;

import org.drools.core.reteoo.RuleTerminalNodeLeftTuple;
import org.kie.api.definition.rule.Rule;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DebugAgendaEventListener extends DefaultAgendaEventListener {
    private final static Logger LOGGER = Logger.getLogger(DebugAgendaEventListener.class.getName());

    List<String> rulesFired = new ArrayList<>();

    @Override
    public void afterMatchFired(AfterMatchFiredEvent event) {
        Rule rule = event.getMatch().getRule();
        int salience = ((RuleTerminalNodeLeftTuple)event.getMatch()).getSalience();
        rulesFired.add(rule.getName() + ":" + salience);
        LOGGER.info("Rule fired: " + rule.getName() + ", " + event);
    }

    public List<String> getRulesFired() {
        return rulesFired;
    }

    public void reset() {
        rulesFired.clear();
    }
}
