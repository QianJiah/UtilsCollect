package raysharp.com.utilsdemo.utils;


import java.util.ArrayList;
import java.util.List;

import raysharp.com.utilsdemo.constants.Constants;

/**
 * copy from 张风捷特烈 by hao on 2019/02/23
 * about 随机数，随机字符串，随机中英名字
 */
public class RandomUtils {

    /**
     * 返回随机整数[min,max]
     * @param min 最小值
     * @param max 最大值
     * @return 随机整数
     */
    public static int randomInt(int min, int max) {
        int maxs = Math.max(min, max);
        int mins = Math.min(min, max) - 1;
        return (int) (mins + Math.ceil(Math.random()*(maxs - mins)));
    }

    /**
     * 返回随机字符
     * @param len  字符长度
     * @param chars  字符串数组
     * @return 随机长度字符
     */
    public static String randomChar(int len, String[] chars) {
        if (len >= chars.length) {
            return "越界字符";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(chars[randomInt(i,chars.length - 1)]);
        }

        return stringBuilder.toString();
    }

    /**
     * 返回随机英文名字
     * @return 随机英文名字（firstName+“ ”+lastName）
     */
    public static String getRandomEnName() {
        String firstName = upperFirst(randomChar(4, Constants.abc));
        String lastName = upperFirst(randomChar(6, Constants.abc));
        return firstName+ " " + lastName;
    }

    /**
     *
     * @return 随机中文名字（名为1个字，或2个字）
     */
    public static String getRandomChName() {
        StringBuilder sb = new StringBuilder();
        if (randomInt(1, 2) == 1) { //名字为1个字的
            String xing = randomChar(1, Constants.XING);
            String ming = randomChar(1, Constants.MING);
            sb.append(xing);
            sb.append(ming);
        } else {    //名字为2个字的
            String xing = randomChar(1, Constants.XING);
            String ming = randomChar(2, Constants.MING);
            sb.append(xing);
            sb.append(ming);
        }
        return sb.toString();
    }

    /**
     * 返回首字母大写的字符串
     * @param str 待处理字符串
     * @return 首字母大写的字符串
     */
    public static String upperFirst(String str) {
        StringBuilder builder = new StringBuilder();
        String lastChar = str.substring(1);   //截取后半部分
        String firstChar = str.substring(0,1).toUpperCase();  //截取首字符并将其大写
        builder.append(firstChar);
        builder.append(lastChar);
        return builder.toString();
    }

    /**
     * 获取随机名字集合
     * @param count 获取个数
     * @param isCN  是否是中文名字
     * @return   名字集合
     */
    public static List<String> getRandomName(int count, boolean isCN) {
        ArrayList<String> names = new ArrayList<>();
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                names.add(isCN ? getRandomChName() : getRandomEnName());
            }
        }
        return names;
    }

}
