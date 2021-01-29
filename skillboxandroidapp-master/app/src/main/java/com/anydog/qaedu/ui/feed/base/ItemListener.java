package com.anydog.qaedu.ui.feed.base;

public interface ItemListener<T> {
    void onItemClick(T item);
    void onAdd(T item);
    void onRemove(T item);
}
