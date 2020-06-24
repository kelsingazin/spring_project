package kz.bitlab.TestSpring.repositories;

import kz.bitlab.TestSpring.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Assylkhan
 * on 26.03.2020
 * @project TestSpring
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
        }
