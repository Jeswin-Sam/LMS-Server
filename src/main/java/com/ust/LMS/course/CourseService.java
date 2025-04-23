package com.ust.LMS.course;

import com.ust.LMS.course_material.CourseMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired private CourseRepository repo;
    @Autowired private CourseMapper mapper;
    @Autowired private YouTubePlaylistService playlistService; // new

    public List<CourseDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public CourseDTO getById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    public CourseDTO save(CourseDTO dto) {
        Course entity = mapper.toEntity(dto);
        if (entity.getPlaylistUrl() != null && !entity.getPlaylistUrl().isEmpty()) {
            List<CourseMaterial> materials = playlistService.extractMaterialsFromPlaylist(entity.getPlaylistUrl(), entity);
            entity.setMaterials(materials);
        }
        return mapper.toDTO(repo.save(entity));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

