package graphql.language;


import java.util.ArrayList;
import java.util.List;

public class DirectiveDefinition extends AbstractNode<DirectiveDefinition> implements Definition<DirectiveDefinition> {
    private final String name;
    private final List<InputValueDefinition> inputValueDefinitions;
    private final List<DirectiveLocation> directiveLocations;

    public DirectiveDefinition(String name) {
        this(name, new ArrayList<>(), new ArrayList<>());
    }

    public DirectiveDefinition(String name, List<InputValueDefinition> inputValueDefinitions, List<DirectiveLocation> directiveLocations) {
        this.name = name;
        this.inputValueDefinitions = inputValueDefinitions;
        this.directiveLocations = directiveLocations;
    }

    public String getName() {
        return name;
    }

    public List<InputValueDefinition> getInputValueDefinitions() {
        return inputValueDefinitions;
    }

    public List<DirectiveLocation> getDirectiveLocations() {
        return directiveLocations;
    }

    @Override
    public List<Node> getChildren() {
        List<Node> result = new ArrayList<>();
        result.addAll(inputValueDefinitions);
        result.addAll(directiveLocations);
        return result;
    }

    @Override
    public boolean isEqualTo(Node o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectiveDefinition that = (DirectiveDefinition) o;

        return isEqualTo(this.name, that.name);
    }

    @Override
    public DirectiveDefinition deepCopy() {
        return new DirectiveDefinition(name,
                deepCopy(inputValueDefinitions),
                deepCopy(directiveLocations));
    }

    @Override
    public String toString() {
        return "DirectiveDefinition{" +
                "name='" + name + "'" +
                ", inputValueDefinitions=" + inputValueDefinitions +
                ", directiveLocations=" + directiveLocations +
                "}";
    }
}
