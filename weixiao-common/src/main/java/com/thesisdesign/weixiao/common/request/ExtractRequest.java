package com.thesisdesign.weixiao.common.request;

public class ExtractRequest {
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "ExtractRequest{" +
                "filename='" + filename + '\'' +
                '}';
    }
}
