package com.szucsatti.spliterator;

import static java.util.Spliterators.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public abstract class AbstractSpliterator<T> implements Spliterator<T> {
	private final int batchSize;
	private final int characteristics;

	public AbstractSpliterator(final int characteristics, final int batchSize, final long est) {
		this.characteristics = characteristics | SUBSIZED;
		this.batchSize = batchSize;
	}

	public AbstractSpliterator(final int characteristics, final int batchSize) {
		this(characteristics, batchSize, Long.MAX_VALUE);
	}

	public AbstractSpliterator(final int characteristics) {
		this(characteristics, 128, Long.MAX_VALUE);
	}

	public AbstractSpliterator() {
		this(IMMUTABLE | ORDERED | NONNULL);
	}

	@Override
	public Spliterator<T> trySplit() {
		final HoldingConsumer<T> holder = new HoldingConsumer<>();
		if (!tryAdvance(holder))
			return null;
		final Object[] a = new Object[batchSize];
		int j = 0;
		do
			a[j] = holder.value;
		while (++j < batchSize && tryAdvance(holder));
		return spliterator(a, 0, j, characteristics() | SIZED);
	}

	@Override
	public long estimateSize() {
		return Long.MAX_VALUE;
	}

	@Override
	public int characteristics() {
		return characteristics;
	}

	static final class HoldingConsumer<T> implements Consumer<T> {
		Object value;

		@Override
		public void accept(final T value) {
			this.value = value;
		}
	}
}
