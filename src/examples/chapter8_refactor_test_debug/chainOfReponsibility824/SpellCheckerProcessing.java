package examples.chapter8_refactor_test_debug.chainOfReponsibility824;

public class SpellCheckerProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWork(String input) {
        return input.replaceAll("labda", "lambda");
    }
}
