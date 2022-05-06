package com.example.become_better.controller;

import com.example.become_better.config.auth.PrincipalDetails;
import com.example.become_better.model.Board;
import com.example.become_better.model.Comment;
import com.example.become_better.model.User;
import com.example.become_better.service.BoardService;
import com.example.become_better.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;
    private final CommentService commentService;

    // 전체 게시글 보기
    @GetMapping("/board")
    public ResponseEntity<?> findAllBoard() {
        return new ResponseEntity<>(boardService.findAllBoard(), HttpStatus.OK);
    }

    // 개별 게시글 보기
    @GetMapping("/board/{boardId}")
    public ResponseEntity<?> findBoardByBoardId(@PathVariable("boardId") Integer boardId) {
        return new ResponseEntity<>(boardService.findBoardByBoardId(boardId), HttpStatus.OK);
    }

    // 유저가 작성한 게시글 보기
    @GetMapping("/board/history/{userId}")
    public ResponseEntity<?> findAllBoardByUserId(@PathVariable("userId") Integer userId) {
        return new ResponseEntity<>(boardService.findBoardsByUserId(userId), HttpStatus.OK);
    }

    // 게시글 작성하기
    @PostMapping("/board")
    public ResponseEntity<?> writeBoard(@RequestBody Board board, Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        board.setUser(principal.getUser());
        return new ResponseEntity<>(boardService.writeBoard(board), HttpStatus.CREATED);
    }

    // 게시글 삭제하기
    @DeleteMapping("/board/{boardId}")
    public ResponseEntity<?> deleteBoard(@PathVariable("boardId") Integer boardId, Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        Board board = boardService.findBoardByBoardId(boardId);
        if (board.getUser().getId() == principal.getUser().getId()) {
            return new ResponseEntity<>(boardService.deleteBoard(board), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("실패 본인 아이디가 아닙니다.", HttpStatus.BAD_GATEWAY);
        }
    }

    // 게시글 수정
    @PutMapping("/board/{boardId}")
    public ResponseEntity<?> updateBoard(@RequestBody Board updateBoard, @PathVariable("boardId") Integer boardId, Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        Board board = boardService.findBoardByBoardId(boardId);
        if (board.getUser().getId() == principal.getUser().getId()) {
            return new ResponseEntity<>(boardService.updateBoard(board.getId(), updateBoard), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("실패", HttpStatus.BAD_GATEWAY);
        }
    }


    //////////////// 댓글 ///////////////////////////

    // 댓글 작성
    @PostMapping("/board/{boardId}/comment")
    public ResponseEntity<?> writeComment(@PathVariable("boardId") Integer boardId, @RequestBody Comment comment, Authentication authentication) {
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        Board board = boardService.findBoardByBoardId(boardId);
        comment.setUser(principalDetails.getUser());
        comment.setBoard(board);
        return new ResponseEntity<>(commentService.writeComment(comment), HttpStatus.OK);
    }

    // 댓글 수정
    @PutMapping("/board/{boardId}/comment/{commentId}")
    public ResponseEntity<?> updateCommnet(@PathVariable("boardId") Integer boardId, @PathVariable("commentId") Integer commentId ,@RequestBody Comment updateComment, Authentication authentication) {
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        User user = principalDetails.getUser();
        Comment comment = commentService.findCommnetById(commentId);
        System.out.println(user);
        System.out.println(comment.getUser());
        if(user == comment.getUser()) {
            return new ResponseEntity<>(commentService.updateComment(commentId, updateComment), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("댓글 수정 실패", HttpStatus.BAD_GATEWAY);
        }
    }

    // 댓글 삭제
    @DeleteMapping("/board/{boardId}/comment/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable("boardId") Integer boardId, @PathVariable("commentId") Integer commentId, Authentication authentication) {
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        User user = principalDetails.getUser();
        if(user == commentService.findCommnetById(commentId).getUser()) {
            return new ResponseEntity<>(commentService.deleteComment(commentId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("댓글 삭제 실패!", HttpStatus.BAD_GATEWAY);
        }
    }
}
