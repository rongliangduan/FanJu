package com.china.yuncheng.fanju.util;

import android.media.MediaRecorder;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * Created by agonyice on 14-8-28.
 * 开始，停止录音的类
 */
public class SoundRecorder {
    private static final MediaRecorder mRecorder = new MediaRecorder();
    private  final String path;
    private static int SAMPLE_RATE_IN_HZ = 800;//采样率

    public SoundRecorder(String path) {
        this.path = SanItIzePath(path);
    }

    private String SanItIzePath(String path) {
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        if (!path.contains(".")) {
            path += ".amr";
        }
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/fanju" + path;
    }

    /**
     * 开始录音
     */
    public void start() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return;
        }
        File directory=new File(path).getParentFile();
        if(!directory.exists()&&!directory.mkdirs()){
            return;
        }
        try {
            //设置声音的来源
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            //设置声音的输出格式
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            //设置声音的编码格式
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            //设置音频采样率
            mRecorder.setAudioSamplingRate(SAMPLE_RATE_IN_HZ);
            //设置输出文件
            mRecorder.setOutputFile(path);
            //准备录音
            mRecorder.prepare();
            //开始录音
            mRecorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 停止录音
     */
    public  void stop(){
        try {
            //停止录音
            mRecorder.stop();
            //释放资源
            mRecorder.release();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
    public  double getAmplitude(){
        if(mRecorder!=null){
            return (mRecorder.getMaxAmplitude());
        }else{
            return 0;
        }
    }
}
