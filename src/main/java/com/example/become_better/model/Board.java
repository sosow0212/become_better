package com.example.become_better.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String content;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate; // 날짜

    @PrePersist // DB에 INSERT 되기 직전에 실행. 즉 DB에 값을 넣으면 자동으로 실행됨
    public void createDate() {
        this.createDate = LocalDate.now();
    }

//    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER) // EAGER은 호출할 때 바로 로드하는 것임
    @JoinColumn(name="user_Id")
    @JsonIgnoreProperties({"boards", "comments", "password"})
    private User user;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) // 연관관계의 주인이 아니다 == FK가 아니라는 뜻, DB에 컬럼을 만들지 말라는 뜻
    @JsonIgnoreProperties({"board"}) // 댓글 무한참조 방지가 됨 == getter 호출을 막음
    @OrderBy("id desc") // Board를 부를 때, replys_id 기준으로 내림차순으로 정렬을함 - 즉 최근 댓글이 맨 위
    private List<Comment> comments;

}
