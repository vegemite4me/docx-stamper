package org.wickedsource.docxstamper.util;

import org.docx4j.wml.CommentRangeEnd;
import org.docx4j.wml.CommentRangeStart;
import org.docx4j.wml.Comments;
import org.wickedsource.docxstamper.proxy.ProxyBuilder;

public class CommentWrapper {

    private Comments.Comment comment;

    private CommentRangeStart commentRangeStart;

    private CommentRangeEnd commentRangeEnd;

    private ProxyBuilder<?> parentProxyBuilder;

    public CommentWrapper(Comments.Comment comment, CommentRangeStart commentRangeStart, CommentRangeEnd commentRangeEnd, ProxyBuilder<?> parentProxyBuilder) {
        this.comment = comment;
        this.commentRangeStart = commentRangeStart;
        this.commentRangeEnd = commentRangeEnd;
        this.parentProxyBuilder = parentProxyBuilder;
    }

    public CommentWrapper() {
    }

    public Comments.Comment getComment() {
        return comment;
    }

    public CommentRangeStart getCommentRangeStart() {
        return commentRangeStart;
    }

    public CommentRangeEnd getCommentRangeEnd() {
        return commentRangeEnd;
    }

    public ProxyBuilder<?> getParentProxyBuilder() {
        return parentProxyBuilder;
    }

    void setComment(Comments.Comment comment) {
        this.comment = comment;
    }

    void setCommentRangeStart(CommentRangeStart commentRangeStart) {
        this.commentRangeStart = commentRangeStart;
    }

    void setCommentRangeEnd(CommentRangeEnd commentRangeEnd) {
        this.commentRangeEnd = commentRangeEnd;
    }

    void setParentProxyBuilder(ProxyBuilder<?> parentProxyBuilder) {
        this.parentProxyBuilder = parentProxyBuilder;
    }
}
