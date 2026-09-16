package memory;


/**
 * 스프링 부트 자동구성 직접 만들기를 위한 패키지 및 파일
 */
public class Memory {

    private long used;
    private long max;

    public Memory(long used, long max) {
        this.used = used;
        this.max = max;
    }

    public long getUsed() {
        return used;
    }

    public long getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "used=" + used +
                ", max=" + max +
                '}';
    }
}
