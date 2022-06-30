package com.calmdev.board.repository;

import com.calmdev.board.entity.Board;
import com.calmdev.board.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertBoard() {

        IntStream.rangeClosed(1, 100)
                 .forEach(i -> {

                     Member member = Member.builder()
                                           .email("user" + i + "@aaa.com")
                                           .build();

                     Board board = Board.builder()
                                        .title("Title..." + i)
                                        .content("Content..." + i)
                                        .writer(member)
                                        .build();

                     boardRepository.save(board);
                 });
    }
}