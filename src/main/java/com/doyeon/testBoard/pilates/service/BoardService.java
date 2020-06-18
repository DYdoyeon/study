package com.doyeon.testBoard.pilates.service;

import com.doyeon.testBoard.pilates.domain.entity.Post;
import com.doyeon.testBoard.pilates.domain.repository.BoardRepository;
import com.doyeon.testBoard.pilates.domain.result.ListResult;
import com.doyeon.testBoard.pilates.domain.result.ObjectResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BoardService {
    BoardRepository boardRepository;
    @Autowired
    BoardService (BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public ListResult getAllPost(int status){
        ListResult listResult = new ListResult();
        listResult.setMsg("success");
        listResult.setCode(status);
        listResult.setObj(boardRepository.findAll());
        return listResult;
    }

    public ObjectResult getPost(int status, Long id){

        ObjectResult objectResult = new ObjectResult();
        objectResult.setMsg("success");
        objectResult.setCode(status);
        objectResult.setObj(boardRepository.findById(id));
        return objectResult;
    }


    public ObjectResult writePost (int status,Post post){

        boardRepository.save(post);
        ObjectResult objectResult = new ObjectResult();

        objectResult.setMsg("success");
        objectResult.setCode(status);
        return objectResult;

    }

    // Update Post
    // Update Post
    public  ObjectResult updatePost (int status ,Post post) {

        boardRepository.update(post);

        ObjectResult objectResult = new ObjectResult();

        objectResult.setMsg("success");
        objectResult.setCode(status);
        return objectResult;

    }


    // Delete Post
    @DeleteMapping("/list/{id}")
    public ListResult deletePost( int status ,Long id) throws Exception {
        boardRepository.delete(id);

        ListResult listResult = new ListResult();
        listResult.setMsg("success");
        listResult.setCode(status);
        listResult.setObj(boardRepository.findAll());
        return listResult;

    }
}
