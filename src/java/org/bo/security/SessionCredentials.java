package org.bo.security;

import org.bo.entity.User;

public interface SessionCredentials {
    User getCurrentUser();

}
