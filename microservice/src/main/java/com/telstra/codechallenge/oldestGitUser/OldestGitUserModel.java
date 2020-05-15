package com.telstra.codechallenge.oldestGitUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OldestGitUserModel {

  // private Integer total_count;
  private Items[] items;

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Data
  public class Items {

    private Integer id;
    private String login;
    private String html_url;
  }
}
