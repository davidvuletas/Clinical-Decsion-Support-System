package sbnz.cdss.model.monitoring;

import org.kie.api.definition.type.Role;

import java.io.Serializable;

@Role(Role.Type.EVENT)
public class HeartBeatEvent implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HeartBeatEvent(Long id) {
        super();
        this.id = id;
    }

    public HeartBeatEvent() {
    }
}
