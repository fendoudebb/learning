/**
 * zbj: created on 2021/7/4 10:55.
 *
 * -Xms60m -Xmx60m -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 *
 * Java8
 *
 * Heap
 *  PSYoungGen      total 18432K, used 2322K [0x00000000fec00000, 0x0000000100000000, 0x0000000100000000)
 *   eden space 16384K, 14% used [0x00000000fec00000,0x00000000fee448c8,0x00000000ffc00000)
 *   from space 2048K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x0000000100000000)
 *   to   space 2048K, 0% used [0x00000000ffc00000,0x00000000ffc00000,0x00000000ffe00000)
 *  ParOldGen       total 40960K, used 20480K [0x00000000fc400000, 0x00000000fec00000, 0x00000000fec00000)
 *   object space 40960K, 50% used [0x00000000fc400000,0x00000000fd800010,0x00000000fec00000)
 *  Metaspace       used 3333K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 359K, capacity 388K, committed 512K, reserved 1048576K
 */
public class YoungOldAreaDemo {

    public static void main(String[] args) {
        byte[] bytes = new byte[1024 * 1024 * 20];
    }

}
