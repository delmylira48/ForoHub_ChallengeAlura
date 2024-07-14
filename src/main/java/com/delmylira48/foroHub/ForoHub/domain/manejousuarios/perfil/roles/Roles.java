package com.delmylira48.foroHub.ForoHub.domain.manejousuarios.perfil.roles;

public enum Roles {
    ADMIN,
    USER,
    GUEST;

    public static Roles fromString(String roleStr) {
        if (roleStr != null) {
            for (Roles role : Roles.values()) {
                if (roleStr.equalsIgnoreCase(role.name())) {
                    return role;
                }
            }
        }
        throw new IllegalArgumentException("No se puede convertir el String a un valor de Roles: " + roleStr);
    }
}
