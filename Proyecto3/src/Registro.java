public class Registro {
    private int celular;
    private String curp;
    private String estudios;

    public Registro(int celular, String curp, String estudios) {
        this.celular = celular;
        this.curp = curp;
        this.estudios = estudios;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    @Override
    public String toString() {
        return "Celular=" + celular + ", CURP=" + curp + ", Estudios=" + estudios;
    }
}
