package jianzhi;

/*
 * 数组中重复的数字
 *
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * numbers是输入数组,duplication[0]保存第一个重复数字
 * */
public class Q50_Duplicate {
    // 使用插入排序，进行判断
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if(length <= 1) return false;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (numbers[j] <= numbers[j-1]){
                    if(numbers[j] == numbers[j-1]) {
                        duplication[0] = numbers[j];
                        return true;
                    }else {
                        int temp = numbers[j];
                        numbers[j] = numbers[j-1];
                        numbers[j-1] = temp;
                    }
                }
            }
        }
        return false;
    }

    // Solu2: Arrays.sort()排序后遍历。如果要获取第一个重复的元素，不可以使用Arrays.sort()进行排序后比较

    // Solu3: HashSet()存储

    // 利用特性所有的数在0到n-1内，将当前位置数和应该在的位置交换，如果应该在的位置数值等于交换的数，则重复
    public boolean duplicate1(int numbers[], int length, int[] duplication) {
        if(length <= 1) return false;
        for (int i = 0; i < length; i++) {
            int currentValue = numbers[i];                      //当前位置元素的值
            int supposePosition = currentValue;                 //这个值应该在的位置
            if(supposePosition == i) continue;
            if(numbers[supposePosition] == currentValue){       //当这个值与它应该在位置值相等时，说明重复
                duplication[0] = currentValue;
                return true;
            }else{                                              //当这个值与它应该在位置值不相等时，交换两值
                int tempValue = numbers[supposePosition];
                numbers[supposePosition] = currentValue;
                numbers[i] = tempValue;
            }
        }
        return false;
    }
}
