package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmpPriority = new JobDescByName();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 0),
                new Job("Fixed bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 2)
        );
        assertThat(rsl, lessThan(2));
    }

    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> cmpNameAsc = new JobAscByName();
        int rsl = cmpNameAsc.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(4));
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> cmpPriority = new JobAscByName();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 4),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(4));
    }

    @Test
    public void whenComparatorDescByNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(2));
    }

    @Test
    public void whenComparatorAscByNameAndAscPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName()
                .thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fixed bug", 1)
        );
        assertThat(rsl, lessThan(4));
    }

    @Test
    public void whenComparatorAscByNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fixed bug", 1)
        );
        assertThat(rsl, lessThan(4));
    }
}
