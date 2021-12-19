package ru.job4j.it;

import org.junit.Test;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Artem Polshchak on 19.12.2021.
 * @project job4j_design 1. Что такое итератор. [#4951]
 */

public class BackwardArrayItTest {

    @Test
    public void whenMultiCallHasNextThenTrue() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[] {1, 2, 3}
        );
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenReadSequence() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[] {1, 2, 3, 4, 5, 6, 7, 8}
        );
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[] {}
        );
        it.next();
    }

}