package org.example;

import com.google.cloud.NoCredentials;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class Main {
    public static void main(String[] args) {
        Storage emulatorStorage = StorageOptions.newBuilder()
                .setProjectId("demo-project")
                .setHost("http://localhost:9199")
                .setCredentials(NoCredentials.getInstance())
                .build()
                .getService();

        emulatorStorage.create(
                BlobInfo.newBuilder("demo-project.appspot.com", "test")
                        .setContentType("text/plain")
                        .build()
                ,"test".getBytes(),
                Storage.BlobTargetOption.doesNotExist());
    }
}