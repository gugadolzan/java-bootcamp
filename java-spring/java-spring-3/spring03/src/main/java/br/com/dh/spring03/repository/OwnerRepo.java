package br.com.dh.spring03.repository;

import br.com.dh.spring03.model.Owner;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class OwnerRepo {

    private final String fileLink = "src/main/resources/owners.json";

    public List<Owner> getAll() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return Arrays.asList(
                mapper.readValue(new File(fileLink), Owner[].class)
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
