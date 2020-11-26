package com.yanghui.testone;

import lombok.Data;

@Data
public class Mib {
    private String filename;
    private String alias;
    private String directory;

    public Mib(String filename, String alias, String directory) {
        this.filename = filename;
        this.alias = alias;
        this.directory = directory;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
