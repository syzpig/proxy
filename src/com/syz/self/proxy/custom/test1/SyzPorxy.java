package com.syz.self.proxy.custom.test1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.gupaoedu.vip.custom.GPClassLoader;
import com.gupaoedu.vip.custom.GPInvocationHandler;
import com.sun.media.sound.StandardMidiFileWriter;

//生成代理对象的代码
public class SyzPorxy {
	private static String ln = "\r\n";
	//
	public static Object newProxyInstance(SyzClassLoader classLoader,Class<?>[] interfaces,SyzInvocationHandler h){
		try {
			//1、生成源代码  （重组后代理对象java源码）
			String proxySrc = generateSrc(interfaces[0]);
			//2、将生成的源代码输出到磁盘，保存为.java文件
			String fulePath=SyzPorxy.class.getResource("").getPath();//获取类所在的根路径
			File f=new File("D:\\GuPaoPorxy\\$syz0.java");
			FileWriter fw;
			fw = new FileWriter(proxySrc);
			fw.flush();
			fw.close();
			
			//3.编译源代码 并且生成.class文件
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager manager=compiler.getStandardFileManager(null, null, null);
			Iterable iterable = manager.getJavaFileObjects(f);
			CompilationTask task=compiler.getTask(null, manager, null, null, null, iterable);
			task.call();
			manager.close();
			//4.将class文件中的内容，动态加载到JVM中来；并返回被代理后的代理对象
			Class proxyClass =classLoader.findClass("$syz0");
			//创建类代理对象的构造方法 --》getConstructor(Class[] params) 获取类的特定构造方法,params参数指定构造方法的参数类型
			Constructor c =proxyClass.getConstructor(SyzInvocationHandler.class);
			f.delete();
			//通过带参数的构造函数创建代理对象类的实例
			c.newInstance(h);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}
	private static String generateSrc(Class<?> interfaces) {
		StringBuffer src = new StringBuffer();
		src.append("package com.gupaoedu.vip.custom;" + ln);
		src.append("import java.lang.reflect.Method;" + ln);
		src.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);
		
		src.append("GPInvocationHandler h;" + ln);
		
		src.append("public $Proxy0(GPInvocationHandler h) {" + ln);
		src.append("this.h = h;" + ln);
		src.append("}" + ln);
		
		for (Method m : interfaces.getMethods()) {
			src.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + ln);
			
			src.append("try{" + ln);
			src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" +m.getName()+"\",new Class[]{});" + ln);
			src.append("this.h.invoke(this,m,null);" + ln);
			src.append("}catch(Throwable e){e.printStackTrace();}" + ln);
			src.append("}" + ln);
		}
		
		src.append("}");
		
		return src.toString();
	}
}
