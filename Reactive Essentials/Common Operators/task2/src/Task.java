import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.lang.reflect.Array;

public class Task {

	public static Flux<String> transformSequence(Flux<String> flux) {
		return flux.filter(s -> s.length() > 3);
	}
}