package test;

import sys.SystemProperties;

public class TestSystemProperties {

	public static void main(String[] args) {
		System.out.println("isWindows" + SystemProperties.isWindows());		
		System.out.println("FileSeparator" + SystemProperties.getFileSeparator());
		System.out.println("JavaClassPath" + SystemProperties.getJavaClassPath());
		System.out.println("JavaHome" + SystemProperties.getJavaHome());		
		System.out.println("JavaVendor" + SystemProperties.getJavaVendor());
		System.out.println("JavaVendorURL" + SystemProperties.getJavaVendorURL());
		System.out.println("JavaVersion" + SystemProperties.getJavaVersion());		
		System.out.println("LineSeparator" + SystemProperties.getLineSeparator());
		System.out.println("OSArch" + SystemProperties.getOSArch());
		System.out.println("OSName" + SystemProperties.getOSName());
		System.out.println("OSVersion" + SystemProperties.getOSVersion());	
		System.out.println("PathSeparator" + SystemProperties.getPathSeparator());		
		System.out.println("UserDir" + SystemProperties.getUserDir());
		System.out.println("UserHome" + SystemProperties.getUserHome());
		System.out.println("UserName" + SystemProperties.getUserName());
		
	}
}
