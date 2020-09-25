package jianzhi;

/*
 * 替换空格
 *
 *  请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * */
public class Q2_ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        StringBuffer stringBuffer = new StringBuffer();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals(" ")) count++;
        }
        while (count > 0) {
            int index = str.indexOf(" ");
            stringBuffer.append(str.substring(0, index));
            stringBuffer.append("%20");
            str = new StringBuffer(str.substring(index+1));
            count--;
        }
        stringBuffer.append(str.substring(0));
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        Q2_ReplaceSpace q2_replaceSpace = new Q2_ReplaceSpace();
        StringBuffer stringBuffer = new StringBuffer("hello world");
        System.out.println(q2_replaceSpace.replaceSpace(stringBuffer));
    }

}
