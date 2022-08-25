package com.pre_38.pre_project.reply.dto;

import lombok.Getter;

import javax.validation.constraints.Positive;
import java.util.Date;

@Getter
public class ReplyDto {
    @Positive
    private int replyId;

    @Positive
    private String reply_content;

    @Positive
    private Date reply_date;
}
