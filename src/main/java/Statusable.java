public interface Statusable {

    enum State {
        STABLE,
        ATTENTION,
        UNSTABLE
    }

    public String getStatus();
    public void setStatus();
}
