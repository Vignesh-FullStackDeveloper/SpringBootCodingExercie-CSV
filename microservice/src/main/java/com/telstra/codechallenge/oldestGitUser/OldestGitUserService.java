package com.telstra.codechallenge.oldestGitUser;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OldestGitUserService {

    @Value("${github.search.user.url}")
    private String githubsearchuserurl;

    private RestTemplate restTemplate;

    public OldestGitUserService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    }

      public OldestGitUserModel getOldestGitUser(Integer num) {
        String URL = "https://api.github.com/search/users?q=followers:0&sort=joined&order=asc";
        if(num != 0){
          URL = URL + "&per_page="+num;
        }
        String html = restTemplate.getForObject(URL, String.class);
        Gson g = new Gson(); 
        return g.fromJson(html, OldestGitUserModel.class);
        }

}