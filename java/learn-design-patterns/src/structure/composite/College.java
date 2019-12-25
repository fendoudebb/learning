package structure.composite;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent {

    private List<OrganizationComponent> organizationComponents = new ArrayList<>();

    public College(String name, String desc) {
        super(name, desc);
    }

    @Override
    public void add(OrganizationComponent organizationComponent) {
        this.organizationComponents.add(organizationComponent);
    }

    @Override
    public void remove(OrganizationComponent organizationComponent) {
        this.organizationComponents.remove(organizationComponent);
    }

    @Override
    public void print() {
        System.out.println("----------" + getName() + "----------");
        organizationComponents.forEach(OrganizationComponent::print);
    }
}
