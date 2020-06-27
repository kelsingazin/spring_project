package kz.bitlab.TestSpring.repositories;

import kz.bitlab.TestSpring.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
        }
