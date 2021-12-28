package ru.job4j.generic;

/**
 * @author Artem Polshchak on 28.12.2021.
 * @project job4j_design
 * Job4j
 * Уроки
 * 2.1.2. Generic
 * 5.2.2. Реализовать Store<T extends Base>
 */
public class RoleStore implements Store<Role> {
    private final Store<Role> roleStore = new MemStore<>();

    @Override
    public void add(Role role) {
        if (role != null) {
            roleStore.add(new Role(role.getId(), role.getRoleName()));
        }
    }

    @Override
    public boolean replace(String id, Role role) {
        return roleStore.replace(id, role);
    }

    @Override
    public boolean delete(String id) {
        return roleStore.delete(id);
    }

    @Override
    public Role findById(String id) {
        return roleStore.findById(id);
    }
}
