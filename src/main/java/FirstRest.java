import com.example.Parent;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/api")
public class FirstRest {

        private ParentDAO parentDAO;

    public ParentDAO getParentDAO() {
        return parentDAO;
    }

    public void setParentDAO(ParentDAO parentDAO) {
        this.parentDAO = parentDAO;
    }

    @POST
        @Path("/newUser")
        @Produces(MediaType.APPLICATION_JSON)
        public Boolean addUser(Parent parent) {
//        Parent parent = new Parent();
//        parent.setFio("Ivan Ivanov");
        parentDAO.save(parent);
            return true;
        }

        @GET
        @Path("/allUser")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public List<Parent> getAllUser() {

            List<Parent> parents = parentDAO.findAll();

            return parents;
        }

    }
