package ru.job4j.stream;

public class Production {

    private byte workshopCode;
    private int materialCode;
    private String employeeLogin;
    private byte program;
    private String detail;
    private String machine;
    private String condition;

    static class Builder {
        private byte workshopCode;
        private int materialCode;
        private String employeeLogin;
        private byte program;
        private String detail;
        private String machine;
        private String condition;

        Builder buildWorkshopCode(byte  workshopCode) {
            this.workshopCode = workshopCode;
            return this;
        }

        Builder buildMaterialCode(int materialCode) {
            this.materialCode = materialCode;
            return this;
        }

        Builder buildEmployeeLogin(String employeeLogin) {
            this.employeeLogin = employeeLogin;
            return this;
        }

        Builder buildProgram(byte program) {
            this.program = program;
            return this;
        }

        Builder buildDetail(String detail) {
            this.detail = detail;
            return this;
        }

        Builder buildMachine(String machine) {
            this.machine = machine;
            return this;
        }

        Builder buildCondition(String condition) {
            this.condition = condition;
            return this;
        }

        Production build() {
            Production production = new Production();
            production.workshopCode = workshopCode;
            production.materialCode = materialCode;
            production.employeeLogin = employeeLogin;
            production.program = program;
            production.detail = detail;
            production.machine = machine;
            production.condition = condition;
            return production;
        }

        public static void main(String[] args) {
            Production production = new Builder()
                    .buildWorkshopCode((byte) 112)
                    .buildMaterialCode(1021)
                    .buildEmployeeLogin("login")
                    .buildProgram((byte) 321)
                    .buildDetail("Detail")
                    .buildMachine("Machine")
                    .buildCondition("At work")
                    .build();
            System.out.println(production);
        }
    }
}
