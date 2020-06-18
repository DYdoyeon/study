package com.doyeon.testBoard.pilates.domain.repository;


import com.doyeon.testBoard.pilates.domain.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface BoardRepository  {

  List<Object> findAll();
  Object findById(Long id);
  void save(Object obj);
  void update(Object obj);
  void delete(Long id);
}
