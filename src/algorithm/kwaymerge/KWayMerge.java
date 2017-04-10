package algorithm.kwaymerge;

import java.util.List;

/**
*
* 这个类用于演示K路合并
*
* @author charles.wang
*
*/
public class KWayMerge {
   private KWayMerge() {
   }
   /**
    * k路合并，这里的指导思想如下：
    *
    * (1)首先构造一个最小堆，其中堆中的元素初始值为每个数组中的最小元素
    * (2)每次从最小堆中打印并且删除最小元素，然后把这个最小元素所在的数组中的下一个元素插入到最小堆中 (3)每次（2）结束后调整堆来维持这个最小堆
    */
   public static void mergeKWay(int k, int n, List<int[]> arrays) {
       // 这里存储了所有每个数组的当前的下标,在没有开始插入之前，每个数组的当前下标都设为0
       int[] indexInArrays = new int[k];
       for (int i = 0; i < k; i++) {
           indexInArrays[i] = 0;
       }
       // 首先构造一个最小堆,其大小为k
       MinHeap minHeap = new MinHeap(k);
       // 第一步，依次吧每个数组中的第一个元素都插入到最小堆
       // 然后把所有数组的下标都指向1
       for (int i = 0; i < k; i++) {
           // 这里每个都构造TrackableData对象：
           // 其中：arrays.get(i)[0]表示它值为第i个数组的下标为0的元素（也就是第i个数组的第一个元素）
           // i表示这个对象来自于第i个数组
           minHeap.insert(new TrackableData(arrays.get(i)[0], i));
           indexInArrays[i] = 1;
       }
       // 第二步，对最小堆进行反复的插入删除动作
       TrackableData currentDeletedData;
       TrackableData currentInsertedData;
       int arrayIdForDeletedData;
       int nextValueIndexInArray;
       // 循环的条件是k个数组中至少有一个还有值没有被插入到minHeap中
       while (true) {
           // 这个变量维护了有多少个数组当前下标已经越界，也就是数组所有元素已经被完全处理过
           int noOfArraysThatCompletelyHandled = 0;
           // 就是去查询维护所有数组当前下标的数组，如果都越界了，那么就说明都比较过了
           for (int i = 0; i < k; i++) {
               if (indexInArrays[i] == n)
                   noOfArraysThatCompletelyHandled++;
           }
           // 如果所有的数组中的所有的值都比较过了，那么查看堆中内容是否为空。
           if (noOfArraysThatCompletelyHandled == k) {
               while (!minHeap.isEmpty()) {
                   currentDeletedData = minHeap.deleteMin();
                   // 打印出当前的数
                   System.out.print(currentDeletedData.getData() + " ");
               }
               break;
           }
           currentDeletedData = minHeap.deleteMin();
           // 打印出当前的数
           System.out.print(currentDeletedData.getData() + " ");
           // 获取当前的被删的数来自于第几个数组
           arrayIdForDeletedData = currentDeletedData.getComeFromArray();
           // 获取那个数组的当前下标
           nextValueIndexInArray = indexInArrays[arrayIdForDeletedData];
           // 如果当前下标没有越界，说明当前数组中还有元素，则找到该数组中的下个元素
           if (nextValueIndexInArray < n) {
               // 构造新的TrackableData，并且插入到最小堆
               currentInsertedData = new TrackableData(
                       arrays.get(arrayIdForDeletedData)[nextValueIndexInArray],
                       arrayIdForDeletedData);
               minHeap.insert(currentInsertedData);
               // 同时更新维护数组当前下标的数组，让对应数组的当前下标+1
               indexInArrays[arrayIdForDeletedData]++;
           }
           // 如果当前下标已经越界，说明这个数组已经没有任何元素了，则找下一个有值的数组的最小元素
           else {
               while (true) {
                   arrayIdForDeletedData = (arrayIdForDeletedData + 1) % k;
                   // 获取那个数组的当前下标
                   nextValueIndexInArray = indexInArrays[arrayIdForDeletedData];
                   if (nextValueIndexInArray == n)
                       continue;
                   else {
                       // 构造新的TrackableData，并且插入到最小堆
                       currentInsertedData = new TrackableData(
                               arrays.get(arrayIdForDeletedData)[nextValueIndexInArray],
                               arrayIdForDeletedData);
                       minHeap.insert(currentInsertedData);
                       // 同时更新维护数组当前下标的数组，让对应数组的当前下标+1
                       indexInArrays[arrayIdForDeletedData]++;
                       break;
                   }
               }
           }
       }
   }
                          
}
