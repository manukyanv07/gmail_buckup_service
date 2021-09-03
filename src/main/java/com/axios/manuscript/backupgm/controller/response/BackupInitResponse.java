package com.axios.manuscript.backupgm.controller.response;

public class BackupInitResponse {
    private String backupId;

    public String getBackupId() {
        return backupId;
    }

    public void setBackupId(String backupId) {
        this.backupId = backupId;
    }

    public BackupInitResponse(String backupId) {
        this.backupId = backupId;
    }
}
