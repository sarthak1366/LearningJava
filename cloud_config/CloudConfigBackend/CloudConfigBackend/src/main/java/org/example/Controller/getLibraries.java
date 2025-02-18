package org.example.Controller;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Project;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class getLibraries {

    public void getFileList() throws GitLabApiException {

        GitLabApi gitLabApi = new GitLabApi("https://gitlab.com/cloudconfig/", "glpat-r3q6ixvvqP2fKSL8dC6Z");
        List<Project> projects = gitLabApi.getProjectApi().getProjects();
        System.out.println(projects);
    }
}



