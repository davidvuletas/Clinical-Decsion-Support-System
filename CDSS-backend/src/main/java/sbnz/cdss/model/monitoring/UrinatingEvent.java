package sbnz.cdss.model.monitoring;

import org.kie.api.definition.type.Role;

import java.io.Serializable;

@Role(Role.Type.EVENT)
public class UrinatingEvent implements Serializable {

    private int amount;
    private Long id;

    public UrinatingEvent(int amount, Long id) {
        this.amount = amount;
        this.id = id;
    }

    public UrinatingEvent() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
