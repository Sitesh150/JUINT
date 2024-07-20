package manager;

import io.appium.java_client.screenrecording.CanRecordScreen;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class VideoManager {

    public void startRecording(){
        ((CanRecordScreen) DriverManager.getDriverInstance().getAppiumDriver()).startRecordingScreen();
    }

    public void stopRecording(String scenarioName) throws IOException {
        String media = ((CanRecordScreen) DriverManager.getDriverInstance().getAppiumDriver()).stopRecordingScreen();
        String directoryPath = "./target/Videos";
        File videoDirectory = new File(directoryPath);

        synchronized (videoDirectory){
            if(!videoDirectory.exists()){
                videoDirectory.mkdirs();
            }
        }
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(videoDirectory+File.separator+scenarioName+".mp4");
            fos.write(Base64.decodeBase64(media));
            fos.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            if(fos!=null){
                fos.close();
            }
        }
    }
}
