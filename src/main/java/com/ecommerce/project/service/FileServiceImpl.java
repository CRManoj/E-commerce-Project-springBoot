package com.ecommerce.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService
{
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException
    {
        String originalFileName = file.getOriginalFilename();
        String randomId = UUID.randomUUID().toString();
        // This Make file name to this EX: mat.jpg --> Random ID = 1234 --> 1234.jpg
        String  fileName = randomId.concat(originalFileName.substring(originalFileName.lastIndexOf('.')));
        String  filePath = path + File.separator + fileName;
        File folder = new File(path);
        if (!folder.exists())
        {
            if (!folder.mkdir()) {
                throw new IOException("Failed to create directories");
            }
        }
        Files.copy(file.getInputStream(), Paths.get(filePath));
        return fileName;
    }
}
