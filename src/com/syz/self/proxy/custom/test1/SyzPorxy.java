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

//���ɴ������Ĵ���
public class SyzPorxy {
	private static String ln = "\r\n";
	//
	public static Object newProxyInstance(SyzClassLoader classLoader,Class<?>[] interfaces,SyzInvocationHandler h){
		try {
			//1������Դ����  �������������javaԴ�룩
			String proxySrc = generateSrc(interfaces[0]);
			//2�������ɵ�Դ������������̣�����Ϊ.java�ļ�
			String fulePath=SyzPorxy.class.getResource("").getPath();//��ȡ�����ڵĸ�·��
			File f=new File("D:\\GuPaoPorxy\\$syz0.java");
			FileWriter fw;
			fw = new FileWriter(proxySrc);
			fw.flush();
			fw.close();
			
			//3.����Դ���� ��������.class�ļ�
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager manager=compiler.getStandardFileManager(null, null, null);
			Iterable iterable = manager.getJavaFileObjects(f);
			CompilationTask task=compiler.getTask(null, manager, null, null, null, iterable);
			task.call();
			manager.close();
			//4.��class�ļ��е����ݣ���̬���ص�JVM�����������ر������Ĵ������
			Class proxyClass =classLoader.findClass("$syz0");
			//������������Ĺ��췽�� --��getConstructor(Class[] params) ��ȡ����ض����췽��,params����ָ�����췽���Ĳ�������
			Constructor c =proxyClass.getConstructor(SyzInvocationHandler.class);
			f.delete();
			//ͨ���������Ĺ��캯����������������ʵ��
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
