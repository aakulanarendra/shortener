package com.narendra.shortener.repository;

import com.narendra.shortener.entity.Shortener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ShortenerRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    ShortenerRepository shortenerRepository;

    @Test
    public void findFirstByValueTest() {
        Shortener shortener = new Shortener("https://www.test.com/");
        testEntityManager.persist(shortener);
        testEntityManager.flush();

        Optional<Shortener> shortenerResult = shortenerRepository.findFirstByValue("https://www.test.com/");
        assertThat(shortenerResult.get().getValue())
                .isEqualTo(shortener.getValue());
    }

}
