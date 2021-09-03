package com.axios.manuscript.backupgm.controller;

import com.axios.manuscript.backupgm.controller.response.BackupInitResponse;
import com.axios.manuscript.backupgm.service.GmailBackupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GmailBackupController {

    private final GmailBackupService gmailBackupService;

    @Autowired
    public GmailBackupController(GmailBackupService gmailBackupService) {
        this.gmailBackupService = gmailBackupService;
    }

    @PostMapping("/backups")
    ResponseEntity<BackupInitResponse> initiateBackup() {
        BackupInitResponse backupInitResponse = new BackupInitResponse(gmailBackupService.initiateBackup());
        return new ResponseEntity<BackupInitResponse>(backupInitResponse, HttpStatus.OK);
    }

}
