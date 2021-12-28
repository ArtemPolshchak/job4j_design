package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Artem Polshchak on 28.12.2021.
 * @project job4j_design
 * Job4j
 * Уроки
 * 2.1.2. Generic
 * 5.2.2. Реализовать Store<T extends Base>
 */

public class RoleStoreTest {

    @Test
    public void whenAddAndFindThenUsernameIsBrad() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Brad Pit"));
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("Brad Pit"));
    }

    @Test
    public void whenAddAndFindThenUserIsNull() {
        RoleStore store = new  RoleStore();
        store.add(new  Role("1", "Batmen"));
        Role result = store.findById("10");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindUsernameIsSuperMan() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "SuperMen"));
        store.add(new Role("1", "Batmen"));
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("SuperMen"));
    }

    @Test
    public void whenReplaceThenUsernameIsBatmen() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Supermen"));
        store.replace("1", new Role("1", "Batmen"));
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("Batmen"));
    }

    @Test
    public void whenNoReplaceUserThenNoChangeUsername() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Batmen"));
        store.replace("10", new Role("10", "Supermen"));
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("Batmen"));
    }

    @Test
    public void whenDeleteUserThenUserIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Batmen"));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteUserThenUsernameIsPetr() {
        UserStore store = new UserStore();
        store.add(new User("1", "Batmen"));
        store.delete("10");
        User result = store.findById("1");
        assertThat(result.getUserName(), is("Batmen"));
    }

}