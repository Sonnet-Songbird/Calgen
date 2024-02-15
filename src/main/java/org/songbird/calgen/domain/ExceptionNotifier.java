package org.songbird.calgen.domain;

import java.util.Objects;

public class ExceptionNotifier {
    private final Exception exception;
    private final String message;

    private enum errMsg {
        IllegalStateException("프로그램 오류입니다. 개발자에게 문의 해 주세요."),
        ;
        private final String msg;

        errMsg(String msg) {
            this.msg = msg;
        }

        public String getMessag() {
            return msg;
        }

    }


    public ExceptionNotifier(Exception exception, String message) {

        this.exception = exception;
        this.message = Objects.requireNonNullElseGet(message, () -> messageOf(exception));
    }

    public ExceptionNotifier(Exception exception) {
        this.exception = exception;
        this.message = messageOf(exception);
    }

    private String messageOf(Exception exception) {
        if (exception instanceof IllegalStateException)
            return errMsg.IllegalStateException.getMessag();
        else
            return "오류가 발생했습니다.";


    }
}