import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import manager.manager_thomas;
import model.User;

class connexionTest {

	@Test
	void test() throws Exception {
		User u = User.getInstance("Deo", "Thomas","testAssert@gmail.com", "test", "Professeur");
		manager_thomas a = new manager_thomas();
		a.inscription(u);
	}

}
