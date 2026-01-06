package ch.schmucki.core.project;

import ch.schmucki.core.board.KanbanBoard;
import ch.schmucki.core.user.User;
import ch.schmucki.core.user.UserId;

import java.util.List;

public class Project {
    private ProjectId projectId;
    private String name;
    private KanbanBoard kanbanBoard;
    private List<ProjectMembership> memberships;

    public Project(String name) {
        this.name = name;
    }

    public void createProject(UserId userId, ProjectId projectId, String name) {
        var membership = new ProjectMembership(userId, projectId, Role.ADMIN);
        this.memberships.add(membership);
    }
}
