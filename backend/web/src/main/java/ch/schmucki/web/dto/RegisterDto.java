package ch.schmucki.web.dto;

public record RegisterDto(String username,
                          String password,
                          String passwordConfirmation) {
    public boolean isValid() {
        return username != null && password != null && password.equals(passwordConfirmation);
    }
}
