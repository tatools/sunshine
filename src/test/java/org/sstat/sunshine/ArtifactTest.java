package org.sstat.sunshine;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class ArtifactTest {

    @Test
    public void asStringForParentWithSlashInTheEnd() {
        MatcherAssert.assertThat(
                new Artifact("/a/b/", "/a/b/c").asString(),
                Matchers.equalTo("c")
        );
    }

    @Test
    public void asStringForParentWithoutSlashInTheEnd() {
        MatcherAssert.assertThat(
                new Artifact("/a/b", "/a/b/c").asString(),
                Matchers.equalTo("c")
        );
    }

    @Test
    public void asStringWithoutParent() {
        MatcherAssert.assertThat(
                new Artifact("c").asString(),
                Matchers.equalTo("c")
        );
    }

    @Test
    public void asStringWhenParentIsEqualsToFull() {
        MatcherAssert.assertThat(
                new Artifact("/a/b/c", "/a/b/c").asString(),
                Matchers.equalTo("/a/b/c")
        );
    }

    @Test
    public void asStringForRelativeParentWithSlashInTheEnd() {
        MatcherAssert.assertThat(
                new Artifact("a/b/", "a/b/c").asString(),
                Matchers.equalTo("c")
        );
    }

    @Test
    public void asStringForRelativeParentWithoutSlashInTheEnd() {
        MatcherAssert.assertThat(
                new Artifact("a/b", "a/b/c").asString(),
                Matchers.equalTo("c")
        );
    }
}