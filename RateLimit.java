package leetcode;

import java.util.HashSet;
import java.util.Set;

public class RateLimit {

	public static void main(String[] args) throws InterruptedException {
		TokenBucketFilter.runTest();
	}

	private static class TokenBucketFilter {
		private int MAX_TOKENS;
		private long lastTokenRequestTime;
		private long availableTokens;

		public TokenBucketFilter(int maxTokens) {
			this.MAX_TOKENS = maxTokens;
			this.lastTokenRequestTime = System.currentTimeMillis();
			this.availableTokens = 0;
		}

		public synchronized void getToken() throws InterruptedException {

			availableTokens = (System.currentTimeMillis() - lastTokenRequestTime) / 1000;

			if (availableTokens > MAX_TOKENS) {
				availableTokens = MAX_TOKENS;
			}
			System.out.println("Available Tokens : " + availableTokens);

			if (availableTokens == 0) {
				Thread.sleep(1000);
			} else {
				availableTokens--;
			}
			lastTokenRequestTime = System.currentTimeMillis();
			System.out.println("Token is given To : "
					+ Thread.currentThread().getName() + ", at : "
					+ lastTokenRequestTime / 1000);
		}

		private static void runTest() throws InterruptedException {
			Set<Thread> threads = new HashSet<>();
			final TokenBucketFilter tokenBucketFilter = new TokenBucketFilter(10);

			for (int i = 0; i < 10; i++) {
				Thread thread = new Thread(new Runnable() {
					public void run() {
						try {
							tokenBucketFilter.getToken();
						} catch (InterruptedException ie) {
							System.out.println("ERROR " + ie);
						}
					}
				});
				thread.setName("Thread_" + i);
				threads.add(thread);
			}

			for (Thread thread : threads) {
				thread.start();
			}

			for (Thread thread : threads) {
				thread.join();
			}
		}
	}
}
