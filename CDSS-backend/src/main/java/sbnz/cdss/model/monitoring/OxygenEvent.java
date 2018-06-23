package sbnz.cdss.model.monitoring;

import org.kie.api.definition.type.Role;

import java.io.Serializable;

@Role(Role.Type.EVENT)
public class OxygenEvent implements Serializable {
    private int oxygenLevel;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OxygenEvent() {
    }

    public OxygenEvent(int oxygenLevel, Long id){
         super();
         this.id = id;
         this.oxygenLevel = oxygenLevel;
    }
    public int getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(int oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }
}
