import java.time.Duration;

import reactor.core.publisher.Flux;

public class Task {

	public static Flux<String> backpressureByBatching(Flux<Long> upstream,
			Duration duration) {
		return upstream.window(duration)
				.flatMap(x -> x.reduce("", (s, e) -> s + e));
	}
}