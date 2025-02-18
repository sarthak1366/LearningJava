import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@ContextConfiguration
public class MonoTest {

    @Test
    void MonoDemo(){
        //Created a mono
        Mono<String> m1 = Mono
                .just("Hello")
                .log(); //uses SLF4J for logging

        //Consuming mono by subscribing
        m1.subscribe(data->{
            System.out.println(data + " Data is being consumed");
        });
    }

    @Test
    void combiningMonoUsingZip(){
        Mono<String> firstMono = Mono.just("this is firstMono");
        Mono<String> secondMono = Mono.just("This is secondMono");

        //Zip is used to combine Mono
        //Zip is a static method
        Mono<Tuple2<String, String>> newMono = Mono.zip(firstMono, secondMono);

        newMono.subscribe(data->{
            System.out.println(data);
        });

        newMono.subscribe(data->{
            System.out.println(data.getT1());
            System.out.println(data.getT2());
        });
    }

    @Test
    void combiningMonoUsingWithZip() {
        Mono<String> mono1 = Mono.just("Mono1");
        Mono<String> mono2 = Mono.just("Mono2");

        // This is a non-static method
        Mono<Tuple2<String, String>> zippedMono = mono1.zipWith(mono2);

        mono1.subscribe(data->{
            System.out.println(data);
        });
    }

    @Test
    void usingMap(){
        Mono<String> mono1 = Mono.just("This is Mono1");
        Mono<String> mono2 = Mono.just("This is Mono2");
        Mono<String> mono3 = Mono.just("This is Mono3");

        // Map is synchronous
        Mono<String> newMono = mono1.map(item -> item.toUpperCase());
        newMono.subscribe(data->{
            System.out.println(data);
        });
    }

    @Test
}
