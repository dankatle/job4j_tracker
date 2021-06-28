package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void whenComparatorSrcByName() {
        Comparator<Job> cmpName = new JobSrcByName();
        int rsl = cmpName.compare(
                new Job("To paint walls", 2),
                new Job("Prepare tools", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("To paint walls", 2),
                new Job("Prepare tools", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorSrcByPriority() {
        Comparator<Job> cmpName = new JobSrcByPriority();
        int rsl = cmpName.compare(
                new Job("To paint walls", 2),
                new Job("Prepare tools", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> cmpName = new JobDescByPriority();
        int rsl = cmpName.compare(
                new Job("To paint walls", 2),
                new Job("Prepare tools", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorSrcByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobSrcByPriority().thenComparing(new JobSrcByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("To paint walls", 2),
                new Job("Prepare tools", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorSrcByPriorityAndName() {
        Comparator<Job> cmpNamePriority = new JobSrcByPriority().thenComparing(new JobSrcByName());
        int rsl = cmpNamePriority.compare(
                new Job("To paint walls", 2),
                new Job("Prepare tools", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByPriorityAndName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("To paint walls", 2),
                new Job("Prepare tools", 0)
        );
        assertThat(rsl, lessThan(0));
    }
}

