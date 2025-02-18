package org.example;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.Pager;
import org.gitlab4j.api.models.Project;
import org.gitlab4j.api.models.Visibility;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws GitLabApiException {

        String gitlabUrl = "https://gitlab.com/CloudConfig";
        String accessToken = "glpat-r3q6ixvvqP2fKSL8dC6Z"; // Replace with a valid token

        GitLabApi gitLabApi = new GitLabApi(gitlabUrl, accessToken);

        // Set number of projects per page
        int itemsPerPage = 50;
        Pager<Project> pager = gitLabApi.getProjectApi().getOwnedProjects(itemsPerPage);

        // Fetch projects page by page
        while (pager.hasNext()) {
            List<Project> projects = pager.next();
            projects.forEach(project -> System.out.println("Project: " + project.getName()));
        }

        gitLabApi.close();

    }
}