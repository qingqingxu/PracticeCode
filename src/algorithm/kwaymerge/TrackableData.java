package algorithm.kwaymerge;

/**
 *
 * 这个对象表明是一个可以跟踪来自于哪个数组的数据对象
 * 
 * @author charles.wang
 *
 */
public class TrackableData {

	// data表明具体的值
	private int data;
	// comeFromArray表明这个值来自于哪一个数组
	private int comeFromArray;

	public TrackableData(int data, int comeFromArray) {
		this.data = data;
		this.comeFromArray = comeFromArray;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getComeFromArray() {
		return comeFromArray;
	}

	public void setComeFromArray(int comeFromArray) {
		this.comeFromArray = comeFromArray;
	}

}