package com.store.inventory.domain;

public enum CartStatus {
	EMPTY(0),
	NOT_EMPTY(1),
	FULL(2);

	private final int value;

	CartStatus(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
