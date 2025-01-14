package com.pre_38.pre_project.reply.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.time.LocalDateTime;
import java.util.ArrayList;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    @Column(nullable = false)
    private long votes;


    @ManyToOne // 일대 다(question-reply)
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    public void setQuestion(Question question){
        this.question = question;
    }

    // 추후 단방향/양방향 결정 시 수정 예정
    @OneToOne(mappedBy = "memberId") // 일대 일(member-reply)
//    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public void setMember(Member member){
        this.member = member;
    }


    public Reply(Long replyId, String content, long votes) {
        this.replyId = replyId;
        this.content = content;
        this.votes = votes;
    }
}

