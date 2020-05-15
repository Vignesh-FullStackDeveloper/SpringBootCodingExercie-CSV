package com.telstra.codechallenge.oldestGitUser;

import javax.validation.constraints.Null;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OldestGitUserController {

  private OldestGitUserService oldestGitUserService;

  public OldestGitUserController( OldestGitUserService oldestGitUserService) {
    this.oldestGitUserService = oldestGitUserService;
  }

  @RequestMapping(path = "/oldestGitUser", method = RequestMethod.GET)
  public OldestGitUserModel OldestGitUserWithCount(@RequestParam(value = "number_of_accounts", defaultValue = "0") Integer num) {
    return oldestGitUserService.getOldestGitUser(num);
  }
}
