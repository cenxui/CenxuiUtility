package sys;

/**
 * 
 * @author xenxui
 * 2016 8/15
 */

public final class SystemProperties {
	// Character that separates components of a file path. This is "/" on UNIX and 
	// "\" on Windows.
	static final String FILE_SEPARATOR = "file.separator";
	// Path used to find directories and JAR archives containing class files. 
	// Elements of the class path are separated by a platform-specific character
	// specified in the path.separator property.
	static final String JAVA_CLASS_PATH = "java.class.path";
	// Installation directory for Java Runtime Environment (JRE)
	static final String JAVA_HOME = "java.home";
	// JRE vendor name
	static final String JAVA_VENDOR = "java.vendor";
	// JRE vendor URL
	static final String JAVA_VENDOR_URL = "java.vendor.url";
	// JRE version number
	static final String JAVA_VERSION = "java.version";
	// Sequence used by operating system to separate lines in text files
	static final String LINE_SEPARATOR = "line.separator";
	// Operating system architecture
	static final String OS_ARCH = "os.arch";
	// Operating system name
	static final String OS_NAME = "os.name";
	// Operating system version
	static final String OS_VERSION = "os.version";
	// Path separator character used in java.class.path
	static final String PATH_SEPARATOR = "path.separator";
	// User working directory
	static final String USER_DIR = "user.dir";
	// User home directory
	static final String USER_HOME = "user.home";
	// User account name
	static final String USER_NAME = "user.name";
	
	/**
	 * get the file separator
	 * @return file separator
	 */
	public static String getFileSeparator() {
		return System.getProperty(FILE_SEPARATOR);
	}
	
	/**
	 * get the java class path of this class
	 * @return java class path
	 */
	public static String getJavaClassPath() {
		return System.getProperty(JAVA_CLASS_PATH);
	}
	
	/**
	 * get the java home, that means the path of java runtime environment
	 * @return the absolutely path of java runtime environment 
	 */
	public static String getJavaHome() {
		return System.getProperty(JAVA_HOME);
	}
	
	/**
	 * get the vendor of the java virtue machine
	 * @return the vendor of java virtue machine
	 */
	public static String getJavaVendor() {
		return System.getProperty(JAVA_VENDOR);
	}
	
	/**
	 * get the java vendor url 
	 * @return the java vendor url 
	 */
	public static String getJavaVendorURL() {
		return System.getProperty(JAVA_VENDOR_URL);
	}
	
	/**
	 * get the java virtue machine version
	 * @return the java virtue machine version
	 */
	public static String getJavaVersion() {
		return System.getProperty(JAVA_VERSION);
	}
	/**
	 * get the line separator
	 * @return the line separator
	 */
	public static String getLineSeparator() {
		return System.getProperty(LINE_SEPARATOR);
	}
	
	/**
	 * get the operation system architecture e.g amd64
	 * @return the operation system architecture
	 */
	
	public static String getOSArch() {
		return System.getProperty(OS_ARCH);
	}
	
	/**
	 * get the operation system name e.g Windows 8.1
	 * @return the operation system name
	 */
	public static String getOSName() {
		return System.getProperty(OS_NAME);
	}
	
	/**
	 * get the operation system version e.g 6.3 for Windows 8.1
	 * @return the operation system version
	 */
	
	public static String getOSVersion() {
		return System.getProperty(OS_VERSION);
	}
	
	/**
	 * get the path separator e.g ";"
	 * @return the path separator
	 */
	
	public static String getPathSeparator() {
		return System.getProperty(PATH_SEPARATOR);
	}
	
	/**
	 * get the user directory e.g D:\eclipseJavaProject\CenxuiUtil
	 * @return the user directory 
	 */
	public static String getUserDir() {
		return System.clearProperty(USER_DIR);
	}
	
	/**
	 * get the user home absolutely path e.g C:\Users\xenxui
	 * @return
	 */
	
	public static String getUserHome() {
		return System.clearProperty(USER_HOME);
	}
	/**
	 * get the user name e.g xenxui
	 * @return
	 */
	public static String getUserName () {
		return System.clearProperty(USER_NAME);
	}
	
	public static boolean isWindows() {
		return getOSName().startsWith("Windows");
	}
	
	public static void main(String[] args) {
		System.out.println("isWindows" + isWindows());		
		System.out.println("FileSeparator" + getFileSeparator());
		System.out.println("JavaClassPath" + getJavaClassPath());
		System.out.println("JavaHome" + getJavaHome());		
		System.out.println("JavaVendor" + getJavaVendor());
		System.out.println("JavaVendorURL" + getJavaVendorURL());
		System.out.println("JavaVersion" + getJavaVersion());		
		System.out.println("LineSeparator" + getLineSeparator());
		System.out.println("OSArch" + getOSArch());
		System.out.println("OSName" + getOSName());
		System.out.println("OSVersion" + getOSVersion());	
		System.out.println("PathSeparator" + getPathSeparator());		
		System.out.println("UserDir" + getUserDir());
		System.out.println("UserHome" + getUserHome());
		System.out.println("UserName" + getUserName());
		
	}
}
