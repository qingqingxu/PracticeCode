package bigfile;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class LargeMappedFiles {

	static long length = 0x8000000;//128M
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileChannel fcr = null;
		FileChannel fcw = null;
		try {
			long start = System.currentTimeMillis();
			fcr = new RandomAccessFile("E:/ST/RData/HPID/data/SIMCZ201301/SIMCZ.DAT", "r").getChannel();
			fcw = new RandomAccessFile("E:/ST/RData/HPID/data/SIMCZ201301/SIMCZ.DAT_", "rw").getChannel();
			System.out.println(fcr.size());
			int blocks = (int) ((fcr.size() % length == 0) ? (fcr.size() / length) : (fcr.size() / length + 1));
			MappedByteBuffer[] in = new MappedByteBuffer[blocks];
			MappedByteBuffer[] out = new MappedByteBuffer[blocks];
			for (int i = 0; i < blocks - 1; i++) {
				System.out.println("start: " + i * length + "  end: " + (i * length + length));
				in[i] = fcw.map(MapMode.READ_WRITE, i * length, length);
				out[i] = fcr.map(MapMode.READ_ONLY, i * length, length);
				for (int j = 0; j < length; j++) {
					in[i].put(out[i].get(j));
				}
			}
			System.out.println("start: " + (blocks-2) * length + "  end: " + fcr.size());
			in[blocks-1] = fcw.map(MapMode.READ_WRITE, (blocks-2) * length, fcr.size()-(blocks-2) * length);
			out[blocks-1] = fcr.map(MapMode.READ_ONLY, (blocks-2) * length, fcr.size()-(blocks-2) * length);
			for (int j = 0; j < length; j++) {
				in[blocks-1].put(out[blocks-1].get(j));
			}
			//位置内存中的数据是否与存储设置上同步
			System.out.println("use time: " + (System.currentTimeMillis() - start));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fcr.close();
				fcw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
