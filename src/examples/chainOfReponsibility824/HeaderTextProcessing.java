package examples.chainOfReponsibility824;

public class HeaderTextProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWork(String input) {
        return "From Raoul, Mario And alan: " + input;
    }
}
