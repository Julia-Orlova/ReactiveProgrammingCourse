import java.util.concurrent.CountDownLatch;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

public class Task {

	public static void dynamicDemand(Flux<String> source, CountDownLatch countDownOnComplete) {

		source.subscribe(new BaseSubscriber<String>() {
			long req = 1;
			long count = 0;

			@Override
			protected void hookOnSubscribe(Subscription subscription) {
				request(req);
			}

			@Override
			protected void hookOnNext(String value) {
				count++;

				if (count == req) {
					count = 0;
					req *= 2;
					request(req);
				}
			}

			@Override
			protected void hookFinally(SignalType type) {
				countDownOnComplete.countDown();
			}
		});
	}
}