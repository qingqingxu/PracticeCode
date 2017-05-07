package javaibasic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPattern {

	public static void main(String[] args) {
		/*Pattern p = Pattern.compile("\\d+");
		System.out.println(p.pattern());
		String[] str=p.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
		for (String string : str) {
			System.out.println(string);
		}
		
		Pattern.matches("\\d+","2223");//返回true 
		Pattern.matches("\\d+","2223aa");//返回false,需要匹配到所有字符串才能返回true,这里aa不能匹配到 
		Pattern.matches("\\d+","22bb23");//返回false,需要匹配到所有字符串才能返回true,这里bb不能匹配到 
		
		Matcher m=p.matcher("22bb23"); 
		m.pattern();//返回p 也就是返回该Matcher对象是由哪个Pattern对象的创建的 
*/	
		/*Pattern p=Pattern.compile("([a-z]+)(\\d+)"); 
		Matcher m=p.matcher("aaa2223bb"); 
		m.find();   //匹配aaa2223 
		String strs = m.group();
		System.out.println(strs);
		m.groupCount();   //返回2,因为有2组 
		m.start(1);   //返回0 返回第一组匹配到的子字符串在字符串中的索引号 
		m.start(2);   //返回3 
		m.end(1);   //返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置. 
		m.end(2);   //返回7 
		m.group(1);   //返回aaa,返回第一组匹配到的子字符串 
		m.group(2);   //返回2223,返回第二组匹配到的子字符串 
*/	
		
		Pattern p=Pattern.compile("\\d+"); 
		Matcher m=p.matcher("我的QQ是:456456 我的电话是:0532214 我的邮箱是:aaa123@aaa.com"); 
		while(m.find()) { 
		     System.out.println(m.group()); 
		} 
	}

}
