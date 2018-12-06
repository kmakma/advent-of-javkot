#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
public class ${NAME} extends Day {
    
    public static void main(String[] args) {
        new ${NAME}().executeParts();
    }

    @Override
    void partOne() {

        System.out.println("=== DAY __ - STAR 1 ===");
    }

    @Override
    void partTwo() {

        System.out.println("=== DAY __ - STAR 2 ===");
    }
}
