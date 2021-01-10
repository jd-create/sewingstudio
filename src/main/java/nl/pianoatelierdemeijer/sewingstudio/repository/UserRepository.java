package nl.pianoatelierdemeijer.sewingstudio.repository;

import nl.pianoatelierdemeijer.sewingstudio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{

    User findByLastNameIgnoreCase(String lastName);
}
