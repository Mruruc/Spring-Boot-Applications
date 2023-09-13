package com.mruruc.responseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Lecture_Service {
    private Lecture_Repository repo;
    @Autowired
    public Lecture_Service(Lecture_Repository repo){
        this.repo=repo;
    }

    public List<Lecture> getAllLecture(){
        return repo.findAll();
    }
    public Optional<Lecture> getLectureById(Integer id){
        return repo.findById(id);
    }

    public Lecture addLecture(Lecture lecture){
      return repo.save(lecture);
    }
    public Optional<Lecture> updateLectureById(Integer id, Lecture updatedLecture){
        Optional<Lecture> existLecture = repo.findById(id);

        if (existLecture.isPresent()) {
            Lecture lecture = existLecture.get();
            lecture.setName(updatedLecture.getName());

            repo.save(lecture);
        }
        return existLecture;
    }

    public void deleteLecture(Integer id){
        repo.deleteById(id);
    }
    public Boolean isEmpty(Integer id){
        return repo.existsById(id);
    }
}
