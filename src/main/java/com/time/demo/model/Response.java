package com.time.demo.model;

import java.util.Objects;

public class Response {
    private boolean isOpen;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return isOpen() == response.isOpen();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isOpen());
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Response(boolean isOpen) {
        this.isOpen = isOpen;
    }
}
