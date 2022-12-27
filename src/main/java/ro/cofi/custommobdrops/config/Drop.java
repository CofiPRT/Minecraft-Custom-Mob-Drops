package ro.cofi.custommobdrops.config;

import ro.cofi.custommobdrops.config.condition.Condition;

public abstract class Drop {

    protected boolean enabled = true;
    protected double weight = 100;
    protected Condition condition = Condition.TRUE;

    protected boolean isValid() {
        return true;
    }

}
