package com.md.reactboard.domain;

import javax.persistence.*;

@Entity
public class Comment extends AbstractAuditingEntity {

    @ManyToOne
    @JoinColumn(name = "issue_id")
    Issue issue;

    @Column
    private String content;

    public Comment() {
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
            "issue=" + issue +
            ", content='" + content + '\'' +
            '}';
    }
}
