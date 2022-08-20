package ru.vsu.kudinov_i_m.draw;

public interface IFilter<T> {

    boolean accept(T value);
}
