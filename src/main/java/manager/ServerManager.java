package manager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import utils.AndroidMobileUtils;

public class ServerManager {

	/**
	 * @keyword Using volatile keyword to get the proper read for all threads.
	 */
	private volatile static ServerManager serverManager;
	private ServerManager() {}


	/**
	 * @return serverManager
	 * @implNote Double check code for driver is initiated or not.
	 */
	public static ServerManager getServerInstance(){

		if(serverManager==null){
			synchronized (ServerManager.class){
				if(serverManager==null){
					serverManager = new ServerManager();
				}
			}
		}
		return serverManager;
	}

	/**
	 * @class ThreadLocal to only allows to read not write
	 */
	private static final ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();

	/**
	 * @return server
	 * @method Getting server to provide the same URL as argument in the AndroidDriver
	 */
	public AppiumDriverLocalService getServer() {
		return server.get();
	}


	/**
	 * @set setting-up the server
	 * @method Starting the server
	 * @Exception Server not started
	 */
	public void startServer() throws IOException {
		AppiumDriverLocalService server = windowsGetAppiumService();
		try {
			if (!server.isRunning()) {
				server.start();
			}
		} catch (Exception e) {
			AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().error("Server is not started", new Exception("Server not started!"));
		}
		ServerManager.server.set(server);
	}


	/**
	 * @Exception server is not stopped
	 * @method Stopping the server
	 */
	public void stopServer() throws IOException {
		AppiumDriverLocalService server = windowsGetAppiumService();
		try {
			if (server.isRunning()) {
				server.stop();
			}
		} catch (Exception e) {
			AndroidMobileUtils.getAndroidMobileUtilsInstance().getLog().error("Server is not stopped", new Exception("Server not stopped!"));
			throw new AppiumServerHasNotBeenStartedLocallyException("Appium Server Not Started ABORT!!");
		}
	}

	/**
	 * @implNote windowsGetAppiumService
	 * @method Getting free port to run the server for Android
	 */
	public static AppiumDriverLocalService windowsGetAppiumService() {
		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort()
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE).withLogFile(new File("server.log")));
	}

	/**
	 * @implNote macGetAppiumService
	 * @method Getting free port to run the server for iOS
	 */
	public AppiumDriverLocalService macGetAppiumService() {
		HashMap<String, String> environment = new HashMap<String, String>();
		environment.put("PATH", "JDK_PATH/1.8.0_231");
		environment.put("JAVA_HOME", "JDK_PATH/1.8.0_231");
		environment.put("ANDROID_HOME", "PATH/PLATFORM-TOOLS");
		return AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("/user/local/bin/node"))
						.withAppiumJS(new File("/user/local/lib/node_modules....")).usingAnyFreePort()
						.withArgument(GeneralServerFlag.SESSION_OVERRIDE).withEnvironment(environment)
						.withLogFile(new File(File.separator + "server.log")));
	}
}
