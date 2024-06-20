package ru.job4j.question;

import java.util.Objects;

/**
 * @author Artem Polshchak on 24.01.2022.
 * @project job4j_design 2. Статистика по коллекции. [#45889]
 * Уровень : 2. ДжуниорКатегория : 2.1. Структуры данных и алгоритмы.Топик : 2.1.7. Контрольные вопросы
 */
public class Info {
    private int added;
    private int changed;
    private int deleted;

    public Info(int added, int changed, int deleted) {
        this.added = added;
        this.changed = changed;
        this.deleted = deleted;
    }

    public int getAdded() {
        return added;
    }

    public void setAdded(int added) {
        this.added = added;
    }

    public int getChanged() {
        return changed;
    }

    public void setChanged(int changed) {
        this.changed = changed;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Info)) {
            return false;
        }
        Info info = (Info) o;
        return getAdded() == info.getAdded() && getChanged() == info.getChanged() && getDeleted() == info.getDeleted();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdded(), getChanged(), getDeleted());
    }

    @Override
    public String toString() {
        return "Info{" + "added="
                + added + ", changed="
                + changed + ", deleted="
                + deleted + '}';
    }
}
