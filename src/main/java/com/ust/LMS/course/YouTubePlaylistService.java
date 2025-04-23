package com.ust.LMS.course;

import com.ust.LMS.course_material.CourseMaterial;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class YouTubePlaylistService {

    @Value("${youtube.api.key}")
    private String apiKey;

    private final String BASE_URL = "https://www.googleapis.com/youtube/v3/playlistItems";

    public List<CourseMaterial> extractMaterialsFromPlaylist(String playlistUrl, Course course) {
        String playlistId = extractPlaylistId(playlistUrl);
        List<CourseMaterial> materials = new ArrayList<>();

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(BASE_URL);
        String url = factory.builder()
                .queryParam("part", "snippet")
                .queryParam("maxResults", "50")
                .queryParam("playlistId", playlistId)
                .queryParam("key", apiKey)
                .build().toString();

        RestTemplate restTemplate = new RestTemplate();
        YouTubeResponse response = restTemplate.getForObject(url, YouTubeResponse.class);

        if (response != null && response.items != null) {
            int i = 1;
            for (YouTubeItem item : response.items) {
                CourseMaterial material = new CourseMaterial();
                material.setTitle(item.snippet.title);
                material.setYoutubeVideoId(item.snippet.resourceId.videoId);
                material.setSequenceNumber(i++);
                material.setCourse(course);
                materials.add(material);
            }
        }

        return materials;
    }

    private String extractPlaylistId(String url) {
        int index = url.indexOf("list=");
        return index != -1 ? url.substring(index + 5) : "";
    }

    // Inner classes to map YouTube API response
    static class YouTubeResponse {
        public List<YouTubeItem> items;
    }

    static class YouTubeItem {
        public Snippet snippet;
    }

    static class Snippet {
        public String title;
        public ResourceId resourceId;
    }

    static class ResourceId {
        public String videoId;
    }
}


