package com.example.become_better.service;

import com.example.become_better.model.Board;
import com.example.become_better.model.User;
import com.example.become_better.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<Board> findAllBoard() {
        return boardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Board findBoardByBoardId(int id) {
        return boardRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("Board ID가 없습니다.");
        });
    }

    @Transactional(readOnly = true)
    public Object findBoardsByUserId(int id) {
        if(boardRepository.findAllByUserId(id) == null) {
            return new IllegalArgumentException("user id를 찾을 수 없습니다.");
        } else {
            return boardRepository.findAllByUserId(id);
        }
    }

    @Transactional
    public Board writeBoard(Board board) {
        return boardRepository.save(board);
    }

    @Transactional
    public String deleteBoard(Board board) {
        boardRepository.delete(board);
        return "성공";
    }

    @Transactional
    public Board updateBoard(int id, Board updateBoard) {
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("Board ID가 없습니다.");
        });

        board.setTitle(updateBoard.getTitle());
        board.setContent(updateBoard.getContent());
        return board;
    }
}
