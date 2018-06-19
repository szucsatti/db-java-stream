package com.szucsatti.streams.spliterator;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

import com.szucsatti.streams.AbstractRowSet;

public class ResultSetSpliterator<T> extends AbstractSpliterator<T> {

	private final AbstractRowSet<T> rowSet;

	public ResultSetSpliterator(final AbstractRowSet<T> rowSet) {
		super();
		this.rowSet = rowSet;
	}

	@Override
	public boolean tryAdvance(final Consumer<? super T> action) {
		if (action == null) {
			throw new NullPointerException();
		}

		if (rowSet.isLast()) {
			return false;
		} else {
			if (!rowSet.next()) {
				new NoSuchElementException();
			}
			action.accept(rowSet.getRow());
		}

		return true;
	}

}
