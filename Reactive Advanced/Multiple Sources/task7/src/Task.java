import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class Task {

	public static Publisher<String> combineSeveralSources(Publisher<String> prefixPublisher,
			Publisher<String> wordPublisher,
			Publisher<String> suffixPublisher) {

		return Flux.combineLatest((x) -> "" + x[0] + x[1] + x[2],
				prefixPublisher, wordPublisher, suffixPublisher);
	}
}