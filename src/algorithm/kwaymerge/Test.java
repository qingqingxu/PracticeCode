package algorithm.kwaymerge;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// 我们来演示K路合并，假设我们有4组已经排序了的数组，每组有8个数，则n=8,k=4
		int[] array1 = { 4, 5, 7, 8, 66, 69, 72, 79 };
		int[] array2 = { 3, 9, 42, 52, 53, 79, 82, 87 };
		int[] array3 = { 1, 17, 21, 31, 47, 55, 67, 95 };
		int[] array4 = { 6, 28, 49, 55, 68, 75, 83, 94 };

		System.out.println("这里演示K路合并，其中每个数组都事先被排序了，并且长度为8,我们分4路合并");
		System.out.println("数组1为：");
		for (int i = 0; i < array1.length; i++)
			System.out.print(array1[i] + " ");
		System.out.println();

		System.out.println("数组2为：");
		for (int i = 0; i < array2.length; i++)
			System.out.print(array2[i] + " ");
		System.out.println();

		System.out.println("数组3为：");
		for (int i = 0; i < array3.length; i++)
			System.out.print(array3[i] + " ");
		System.out.println();

		System.out.println("数组4为：");
		for (int i = 0; i < array4.length; i++)
			System.out.print(array4[i] + " ");
		System.out.println();
		List<int[]> arrayLists = new ArrayList<int[]>(4);
		arrayLists.add(0, array1);
		arrayLists.add(1, array2);
		arrayLists.add(2, array3);
		arrayLists.add(3, array4);

		System.out.println("排序后，结果为：");
		KWayMerge.mergeKWay(4, 8, arrayLists);
		System.out.println();
	}

}
