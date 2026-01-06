package ch.schmucki.core.project;

import ch.schmucki.core.user.UserId;

public class ProjectMembership {
    private UserId user;
    private ProjectId project;
    private Role role;

    public ProjectMembership(UserId user, ProjectId project, Role role) {
        this.user = user;
        this.project = project;
        this.role = role;
    }
}
