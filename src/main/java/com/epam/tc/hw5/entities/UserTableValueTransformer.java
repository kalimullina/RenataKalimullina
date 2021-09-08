package com.epam.tc.hw5.entities;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import java.util.Locale;
import java.util.Map;

public class UserTableValueTransformer implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(UserTableValue.class,
                (Map<String, String> row) -> {
                    Integer number = Integer.parseInt(row.get("Number"));
                    String user = row.get("User");
                    String description = row.get("Description");

                    return new UserTableValue(number, user, description);
                }
            )
        );
    }
}
