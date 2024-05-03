package relience;

import org.springframework.data.jpa.repository.JpaRepository;
import relience.entity.Message;

public interface MessageRepo extends JpaRepository<Message,Integer> {
}
