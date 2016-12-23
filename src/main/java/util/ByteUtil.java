package util;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/20
 */
public class ByteUtil {

    /**
     * 将int数值转换为占四个字节的byte数组，本方法适用于(低位在前，高位在后)的顺序。 和bytesToInt（）配套使用
     *
     * @param value 要转换的int值
     * @return byte数组
     */
    public static byte[] intToBytes(int value) {
        byte[] src = new byte[4];
        src[3] = (byte) ((value >> 24) & 0xFF);
        src[2] = (byte) ((value >> 16) & 0xFF);
        src[1] = (byte) ((value >> 8) & 0xFF);
        src[0] = (byte) (value & 0xFF);
        return src;
    }

    /**
     * byte数组中取int数值，本方法适用于(低位在前，高位在后)的顺序，和和intToBytes（）配套使用
     *
     * @param src    byte数组
     * @param offset 从数组的第offset位开始
     * @return int数值
     */
    public static int bytesToInt(byte[] src, int offset) {
        int value;
        value = (int) ((src[offset] & 0xFF)
                | ((src[offset + 1] & 0xFF) << 8)
                | ((src[offset + 2] & 0xFF) << 16)
                | ((src[offset + 3] & 0xFF) << 24));
        return value;
    }

    /**
     * byte数组转double
     *
     * @param Array
     * @param Pos
     * @return
     */
    public static double byteArrayToDouble(byte[] Array, int Pos) {
        long accum = 0;
        accum = Array[Pos + 0] & 0xFF;
        accum |= (long) (Array[Pos + 1] & 0xFF) << 8;
        accum |= (long) (Array[Pos + 2] & 0xFF) << 16;
        accum |= (long) (Array[Pos + 3] & 0xFF) << 24;
        accum |= (long) (Array[Pos + 4] & 0xFF) << 32;
        accum |= (long) (Array[Pos + 5] & 0xFF) << 40;
        accum |= (long) (Array[Pos + 6] & 0xFF) << 48;
        accum |= (long) (Array[Pos + 7] & 0xFF) << 56;
        return Double.longBitsToDouble(accum);
    }

    /**
     * double 转byte数组
     *
     * @param Value
     * @return
     */
    public static byte[] doubleToByteArray(double Value) {
        long accum = Double.doubleToRawLongBits(Value);
        byte[] byteRet = new byte[8];
        byteRet[0] = (byte) (accum & 0xFF);
        byteRet[1] = (byte) ((accum >> 8) & 0xFF);
        byteRet[2] = (byte) ((accum >> 16) & 0xFF);
        byteRet[3] = (byte) ((accum >> 24) & 0xFF);
        byteRet[4] = (byte) ((accum >> 32) & 0xFF);
        byteRet[5] = (byte) ((accum >> 40) & 0xFF);
        byteRet[6] = (byte) ((accum >> 48) & 0xFF);
        byteRet[7] = (byte) ((accum >> 56) & 0xFF);
        return byteRet;
    }
}
