package examples.chainOfReponsibility824;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ProcessingService {

    public void oldJavaStart() {
        //템플릿 패턴을 이요해서 ProcessingObject를 구현한후 각각의 Processor를 만든다음에
        //작업의 연관 순서를 세팅하고
        //실행한다.

        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();

        p1.setSuccessor(p2);

        p1.handle(("Aren't labdas realy sexy?1"));
    }

    public void functionalJavaStart() {
        //이 패턴은 함수 체인과 비슷하다.
        //아래 예제는 아무런 클래스 구현 없이 chain of Reposibility 를 구현했다.

        UnaryOperator<String> headerProcessing = (text) -> "From Raoul, Mario And Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing = (text) -> text.replaceAll("labda", "lambda");

        Function<String, String> pipeline =
                headerProcessing.andThen(spellCheckerProcessing);

        String result = pipeline.apply("\"Aren't labdas realy sexy?1\"");

    }

}
