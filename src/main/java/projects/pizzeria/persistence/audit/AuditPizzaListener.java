package projects.pizzeria.persistence.audit;


import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import projects.pizzeria.persistence.entity.Pizza;

public class AuditPizzaListener {
    @PostLoad
    public void postLoad(Pizza pizza){

    }
    @PostPersist
    @PostUpdate
    public void onPostPersist(Pizza pizza){
        System.out.println(pizza);
    }
    @PreRemove
    public void onPreRemove(Pizza pizza){
        System.out.println(pizza);
    }
}
