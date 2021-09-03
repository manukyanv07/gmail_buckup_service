package com.axios.manuscript.backupgm.controller;

import com.axios.manuscript.backupgm.service.GmailBackupService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class GmailBackupControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private GmailBackupService gmailBackupService;


    @Test
    void startGmailBackup() throws Exception {
        String backupId = UUID.randomUUID().toString();
        Mockito.when(gmailBackupService.initiateBackup()).thenReturn(backupId);
        mockMvc.perform(MockMvcRequestBuilders.post("/backups")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.backupId").value(backupId))
                .andDo(MockMvcResultHandlers.print());
    }
}
