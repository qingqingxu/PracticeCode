package algorithm.kwaymerge;

/**
 * @author charles.wang
 *
 */
public class MinHeap {
    // 最小堆的存储是一个数组,并且为了计算，我们第一个位置不放内容
    private TrackableData[] data;
    // 堆的大小
    private int heapSize;
    // 当前元素的数量
    private int currentSize;
    public MinHeap(int maxSize) {
        heapSize = maxSize;
        // 创建一个比最大容纳数量多1的数组的作用是启用掉数组的头元素，为了方便运算，因为从1开始的运算更加好算
        data = new TrackableData[heapSize + 1];
        currentSize = 0;
    }
                                                                                                                  
                                                                                                                  
    /**
     * 返回当前的堆是否为空
     * @return
     */
    public boolean isEmpty(){ 
        if(currentSize==0)
            return true;
        return false;
    }
    /**
     * 这里考察堆的插入，因为最小堆内部结构中数组前面元素总是按照最小堆已经构建好的，所以我们总从尾部插入 解决方法是： Step
     * 1:先把当前的元素插入到数组的尾部 Step 2:递归的比较当前元素和父亲节点元素， Step
     * 3:如果当前的元素小于父亲节点的元素，那么就把当前的元素上移，直到移不动为止
     *
     * @param value
     * @return
     */
    public MinHeap insert(TrackableData value) {
        // 首先判断堆是否满了，如果满了就无法插入
        if (currentSize == heapSize)
            return this;
        // 如果堆还没有满，那么说明堆中还有位置可以插入，我们先找到最后一个可以插入的位置
        // currentPos表示当前要插入的位置的数组下标
        int currentPos = currentSize + 1;
        // 先插入到当前的位置，因为是从1开始的，所以数组下标运算也要+1
        data[currentPos] = value;
        // 然后比较当前元素和他的父亲元素
        // 当前元素是data[currentPos] ，父亲元素是 data[(currentPos/2],一直遍历到根
        TrackableData temp;
        // 如果currentPos为1，表明是插入的堆中第一个元素，则不用比较
        // 否则， 如果插了不止一个元素，则用插入位置的元素和其父元素比较
        while (currentPos > 1) {
            // 如果当前元素小于父亲元素，那么交换他们位置
            if (data[currentPos].getData() < data[currentPos / 2].getData()) {
                temp = data[currentPos / 2];
                data[currentPos / 2] = data[currentPos];
                data[currentPos] = temp;
                // 更新当前位置
                currentPos = currentPos / 2;
            }
            // 否则， 在假定已有的堆是最小堆的情况下，说明现在插入的位置是正确的，不用变换
            else {
                break;
            }
        }
        // 插入完毕之后，吧当前的堆中元素的个数加1
        currentSize++;
        return this;
    }
    /**
     * 这里考察堆的删除 因为是最小堆，所以肯定删除最小值就是删除堆的根元素，此外，还必须要调整剩余的堆使其仍然保持一个最小堆
     * 因为有删除最小元素之后最小元素位置就有了个空位，所以解决方法是： Step 1:吧堆中最后一个元素复制给这个空位 Step
     * 2:依次比较这个最后元素值，当前位置的左右子元素的值，从而下调到一个合适的位置 Step 3:从堆数组中移除最后那个元素
     */
    public TrackableData deleteMin() {
        // 如果最小堆已经为空，那么无法删除最小元素
        if (currentSize == 0)
            return null;
        // 否则堆不为空，那么最小元素总是堆中的第一个元素
        TrackableData minValue = data[1];
        // 既然删除了最小元素，那么堆中currentSize的尺寸就要-1，为此，我们必须为数组中最后一个元素找到合适的新位置
        // 堆中最后一个元素
        TrackableData lastValue = data[currentSize];
        // 先将堆中最后一个元素移动到最小堆的堆首
        data[1] = lastValue;
        // 把堆内部存储数组的最后一个元素清0
        data[currentSize] = null;
        // 并且当前的堆的尺寸要-1
        currentSize--;
        // 现在开始调整堆结构使其仍然为一个最小堆
        int currentPos = 1; // 当前位置设置为根，从根开始比较左右
        int leftPos = currentPos * 2;
        TrackableData leftValue;
        TrackableData rightValue;
        TrackableData temp;
        // 如果左位置和当前堆的总容量相同，说明只有2个元素了，一个是根元素，一个是根的左元素
        if (leftPos == currentSize) {
            // 这时候如果根左元素data[2]比根元素data[1]小，那么就交换二者位置
            if (data[2].getData() < data[1].getData()) {
                temp = data[2];
                data[2] = data[1];
                data[1] = temp;
            }
        }
        else {
            // 保持循环的条件是该节点的左位置小于当前堆中元素个数，那么该节点必定还有右子元素并且位置是左子元素位置+1
            while (leftPos < currentSize) {
                // 获取当前位置的左子节点的值
                leftValue = data[leftPos];
                // 获取当期那位置的右子节点的值
                rightValue = data[leftPos + 1];
                // 如果当前值既小于左子节点又小于右子节点，那么则说明当前值位置是正确的
                if (data[currentPos].getData() < leftValue.getData()
                        && data[currentPos].getData() < rightValue.getData()) {
                    break;
                }
                // 否则，比较左子节点和右子节点
                // 如果左子节点小于右子节点（当然了，同时小于当前节点），那么左子节点和当前节点互换位置
                else if (leftValue.getData() < rightValue.getData()) {
                    temp = data[currentPos];
                    data[currentPos] = leftValue;
                    data[leftPos] = temp;
                    // 同时更新当前位置是左子节点的位置,并且新的左子节点的位置为左子节点的左子节点
                    currentPos = leftPos;
                    leftPos = currentPos * 2;
                }
                // 如果右子节点小于左子节点(当然了，同时小于当前节点），那么右边子节点和当前节点互换位置
                else {
                    temp = data[currentPos];
                    data[currentPos] = rightValue;
                    data[leftPos + 1] = temp;
                    // 同时更新当前位置是右子节点的位置,并且新的左子节点的位置为右子节点的左子节点
                    currentPos = leftPos + 1;
                    leftPos = currentPos * 2;
                }
            }
        }
        return minValue;
    }
}