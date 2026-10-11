import java.util.*;

class EntitySchema {
    String entityName;
    List<String[]> fields;

    EntitySchema(String name) {
        this.entityName = name;
        this.fields = new ArrayList<>();
    }

    EntitySchema addField(String name, String type) {
        fields.add(new String[]{name, type});
        return this;
    }
}

class ClassGenerator {

    String generateClass(EntitySchema schema) {
        StringBuilder sb = new StringBuilder();
        sb.append("public class ").append(schema.entityName).append(" {\n\n");

        for (String[] field : schema.fields)
            sb.append("    private ").append(field[1]).append(" ").append(field[0]).append(";\n");

        sb.append("\n    public ").append(schema.entityName).append("(");
        for (int i = 0; i < schema.fields.size(); i++) {
            sb.append(schema.fields.get(i)[1]).append(" ").append(schema.fields.get(i)[0]);
            if (i < schema.fields.size() - 1) sb.append(", ");
        }
        sb.append(") {\n");
        for (String[] field : schema.fields)
            sb.append("        this.").append(field[0]).append(" = ").append(field[0]).append(";\n");
        sb.append("    }\n\n");

        for (String[] field : schema.fields) {
            String cap = Character.toUpperCase(field[0].charAt(0)) + field[0].substring(1);
            sb.append("    public ").append(field[1]).append(" get").append(cap).append("() { return ").append(field[0]).append("; }\n");
            sb.append("    public void set").append(cap).append("(").append(field[1]).append(" ").append(field[0]).append(") { this.").append(field[0]).append(" = ").append(field[0]).append("; }\n\n");
        }

        sb.append("    @Override\n    public String toString() {\n        return \"")
          .append(schema.entityName).append("{\"");
        for (int i = 0; i < schema.fields.size(); i++) {
            String f = schema.fields.get(i)[0];
            sb.append(" + \"").append(f).append("=\" + ").append(f);
            if (i < schema.fields.size() - 1) sb.append(" + \", \"");
        }
        sb.append(" + \"}\";\n    }\n}\n");

        return sb.toString();
    }

    Map<String, String> generateAll(List<EntitySchema> schemas) {
        Map<String, String> generated = new LinkedHashMap<>();
        for (EntitySchema s : schemas)
            generated.put(s.entityName, generateClass(s));
        return generated;
    }
}

class DynamicObject {
    String typeName;
    Map<String, Object> fields = new LinkedHashMap<>();

    DynamicObject(String typeName) { this.typeName = typeName; }

    DynamicObject set(String key, Object value) { fields.put(key, value); return this; }
    Object get(String key) { return fields.get(key); }

    @Override
    public String toString() {
        return typeName + fields.toString();
    }
}

class DynamicObjectFactory {
    DynamicObject create(EntitySchema schema, Object... values) {
        DynamicObject obj = new DynamicObject(schema.entityName);
        for (int i = 0; i < schema.fields.size() && i < values.length; i++)
            obj.set(schema.fields.get(i)[0], values[i]);
        return obj;
    }
}

public class GenerationDemo {
    public static void main(String[] args) {
        System.out.println("=== Variability Mechanism: GENERATION ===\n");

        EntitySchema studentSchema = new EntitySchema("Student")
            .addField("name",   "String")
            .addField("rollNo", "int")
            .addField("cgpa",   "double");

        EntitySchema productSchema = new EntitySchema("Product")
            .addField("productId", "String")
            .addField("price",     "double")
            .addField("stock",     "int");

        EntitySchema employeeSchema = new EntitySchema("Employee")
            .addField("empId",      "int")
            .addField("department", "String")
            .addField("salary",     "double");

        ClassGenerator generator = new ClassGenerator();
        List<EntitySchema> schemas = List.of(studentSchema, productSchema, employeeSchema);
        Map<String, String> generated = generator.generateAll(schemas);

        for (Map.Entry<String, String> entry : generated.entrySet()) {
            System.out.println("════════════════════════════════════════");
            System.out.println("Generated Class: " + entry.getKey());
            System.out.println("════════════════════════════════════════");
            System.out.println(entry.getValue());
        }

        System.out.println("════════════════════════════════════════");
        System.out.println("Dynamic Object Creation from Schemas");
        System.out.println("════════════════════════════════════════");
        DynamicObjectFactory factory = new DynamicObjectFactory();

        DynamicObject s1 = factory.create(studentSchema, "Rohit", 101, 8.9);
        DynamicObject s2 = factory.create(studentSchema, "Priya", 102, 9.2);
        DynamicObject p1 = factory.create(productSchema,  "P001", 499.99, 50);
        DynamicObject e1 = factory.create(employeeSchema, 1001, "CSE", 75000.0);

        System.out.println("Student 1  : " + s1);
        System.out.println("Student 2  : " + s2);
        System.out.println("Product 1  : " + p1);
        System.out.println("Employee 1 : " + e1);
    }
}
