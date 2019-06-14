package com.example.GroceryItems.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.GroceryItems.domain.FileModel;
import com.example.GroceryItems.domain.FileModelRepository;




@Controller
public class FileController {
	@Autowired
	private FileModelRepository frepository; 	

    @Value("${upload.path}")
    private String uploadFolder;
    
    @GetMapping("/uploadfile")
    public String index() {
        return "upload";
    }

    @PostMapping("/uploads")
    public String fileUpload(@RequestParam("file") MultipartFile file, Model model) {
        if (file.isEmpty()) {
        	model.addAttribute("msg", "Upload failed");
            return "uploadstatus";
        }

        try {
        	byte[] bytes= file.getBytes();
        	FileModel fileModel= new FileModel(file.getOriginalFilename(), file.getContentType(),bytes);
        	frepository.save(fileModel);
        	
        	
        	return "filelist";
        	} catch(IOException e) {
        	e.printStackTrace();
        	}

        return "uploadstatus";
    }
    
    @GetMapping("/files")
    public String fileList(Model model) {
    	model.addAttribute("files", frepository.findAll());  	
    	return "filelist";
    }
    
	@GetMapping("/file/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
		Optional<FileModel> fileOptional = frepository.findById(id);
		
		if(fileOptional.isPresent()) {
			FileModel file = fileOptional.get();
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
					.body(file.getFile());	
		}
		
		return ResponseEntity.status(404).body(null);
	}    
    
}