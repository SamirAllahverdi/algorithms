package workWithGrizzly.server.resources;

import workWithGrizzly.entity.Book;

import javax.validation.constraints.Positive;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Path("/book")
public class RsBooks {
    private final Map<Integer, Book> books = new HashMap<Integer, Book>() {{
        put(1, new Book(1, "Java", "Jim", Arrays.asList("a", "b", "c")));
        put(2, new Book(2, "Scala", "John", Arrays.asList("d")));
        put(3, new Book(2, "Haskell", "Jeremy", Arrays.asList("e", "f")));
    }};

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response book_all() {
        return Response.status(200).entity(books.values()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response bookById(@PathParam("id") int id) {
        return Response.status(200).entity(books.get(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response book_post(Book book) {
        System.out.println(book);
        return Response.status(201).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("form")
    public Response book_post(@QueryParam("a") String a, @QueryParam("b") String b) {
        System.out.println("Handler int, string");
        System.out.printf("a=%s\n", a);
        System.out.printf("b=%s\n", b);

        return Response.status(200).build();
    }

}
