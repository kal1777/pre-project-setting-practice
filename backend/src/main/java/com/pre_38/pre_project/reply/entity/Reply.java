package com.pre_38.pre_project.reply.entity;

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
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long replyId;

    @ManyToOne // 일대 다(question-reply)
    @JoinColumn(name = "QUESTION_ID")
    @Column(nullable = false, updatable = false, unique = true)
    private int question_id;

    @OneToOne // 일대 일(member-reply)
    @JoinColumn(name = "MEMBER_ID")
    @Column(nullable = false, updatable = false, unique = true)
    private int member_id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    public Reply(int replyId, String reply_content, Date reply_date) {
        this.replyId = replyId;
        this.content = content;
        this.date = date;
    }

    //  setOrder 할 지 결정. 여기부터 시작


}

