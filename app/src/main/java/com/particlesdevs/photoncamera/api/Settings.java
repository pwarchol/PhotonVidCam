package com.particlesdevs.photoncamera.api;

import com.particlesdevs.photoncamera.app.PhotonCamera;
import com.particlesdevs.photoncamera.settings.PreferenceKeys;
import com.particlesdevs.photoncamera.util.Allocator;

import java.util.Objects;

import static android.hardware.camera2.CaptureRequest.NOISE_REDUCTION_MODE_OFF;

public class Settings {
    private final String TAG = "Settings";
    //Preferences

    public int frameCount;
    public int lumenCount;
    public int chromaCount;
    public boolean enhancedProcess;
    public boolean watermark;
    public boolean energySaving;
    public boolean aspect169 = false;
    public boolean earlyVendorKeysLoading = false;
    public boolean useThumbnail = false;
    public boolean binning;
    public boolean DebugData;
    public boolean roundEdge;
    public boolean align;
    public boolean hdrx;
    public boolean hdrxNR;
    public boolean videoLogicalWorkaround = false;
    public double exposureCompensation;
    public double saturation;
    public double sharpness;
    public double contrastMpy = 1.0;
    public double noiseRstr;
    public double mergeStrength;
    public double compressor;
    public double gain;
    public double shadows;
    public int rawSaver;
    public boolean QuadBayer;
    public int cfaPattern;
    public int theme;
    public boolean remosaic;//TODO
    public boolean eisPhoto;
    public boolean fpsPreview;
    public int alignAlgorithm;
    public int colorMethod;
    public int focusPeak;
    public int previewFormat;
    public int realPreviewFormat;
    public int rawFormat;
    public String functionOne;
    public String functionTwo;
    public String mCameraID;
    public float[] toneMap;
    public float[] gamma;
    public String mode = "Video"; //

    //Camera direct related
    public int noiseReduction = NOISE_REDUCTION_MODE_OFF;
    public CameraMode selectedMode;

    // QualityDoesMatter
    public boolean useBasicOsd = true;
    public boolean useOis = true;
    public boolean useDngCompression = false;
    public boolean useP3 = false;
    public int videoBitrate;
    public float apertureToUse;
    public String videoCodec;
    public int videoFramrate;
    public int videoHeight;
    public boolean videoEisInPreview;
    public boolean videoHDR = false;
    public boolean video10bit = false;
    public boolean videoNewRec = false;
    public boolean useExtendIso;
    public boolean useExtendExposure;
    public boolean zoom2X;
    public int noiseProcessing;
    public int edgeProcessing;
    public int audioProcessing;
    public int audioCodec;
    public String audioCodecStr;
    public String audioProcessingStr;
    public int audioSps;
    public int audioBitrate;
    public int audioChannels;
    public int singleFrameQuality;
    public int socQualcommSharpness;
    public int socQualcommSaturation;
    public int socQualcommContrast;
    public int socQualcommSaturationHdrVideo;
    public int socQualcommContrastHdrVideo;
    public int socQualcommEisMode;
    public int socQualcommAiMode;
    public boolean socQualcommUseIsz = false;
    public boolean socQualcommUseMfnr = false;
    public int socQualcommHdrMode = 0;
    public int socQualcommManualWb = 0;
    public boolean socQualcommAutoHdr = false;
    public boolean socQualcommLtmOff = false;
    public boolean useZsl = false;
    public boolean useSceneAndEffectMode = false;
    public boolean useNewSettingsGloabal = false;
    // QualityDoesMatter - Single Shot & Video Related
    public int hotPixelMode = 99;
    public int colorCorrectionAberrationMode = 99;
    public int distortionCorrectionMode = 99;
    public int shadingMode = 99;
    public boolean useAlternatePreviewTemplate = false;
    public boolean useStreamUseCases = false;
    public float digitalZoomFactor = 2;
    public boolean useExternalGallery = true;
    public boolean useAlternateLoupe = true;
    public boolean useVirtualHorizon = true;
    public boolean useVirtualHorizonText = false;
    public boolean allowNetworkSync = false;
    public boolean useLosslessSwEncoding = false;
    public boolean useExposureFusionMethod2 = true;
    public boolean gpsLocation = false;
    public String contrastCurve = "off";
    public int effectMode = 0;
    public int keyframeInterval = 10;
    public int hdrMode = 0;
    public int transferFunction = 7;
    public int photoTransferFunction = 7;
    public int photoColorSpace = 6;
    public int colorspace = 6;
    public String videoRange = "Full";
    public String videoEncoderName = "Device Default";
    public String lutName = "lut.png";
    public int exposureCompensation2 = 0;
    public int demosaicMethod = 2;
    public int sessionType = 0;
    public int sessionTypeVideo = 0;
    public int dngBlackLevel = -1;
    public int dngWhiteLevel = -1;
    public static final int SENSOR_MODE_OFF = -1;
    public static final int SENSOR_MODE_1 = 1;
    public static final int SENSOR_MODE_2 = 2;
    public int sensorModeOn = SENSOR_MODE_OFF;
    public int sensorModeDefault = SENSOR_MODE_OFF;
    public String sensorModeKey = "";
    public int sensorModeValue = -1;
    private int defaultCfaPattern = -1;
    private SensorModeConfiguration sensorMode1 = new SensorModeConfiguration();
    private SensorModeConfiguration sensorMode2 = new SensorModeConfiguration();
    private boolean sensorModeStateInitialized = false;
    private String sensorModeCameraId = null;
    public String photoRange = "Full";
    public String photoVideoCodec = "HEVC";
    public String swColorSpace = "DISPLAY_P3";
    public int audioDirection = 0;
    public float audioZoom = 0.0f;
    public boolean disableVendorKeys = false;
    public boolean disableNoGuiYet = false;
    public boolean isTonnemappingModeQuality = false;
    public int socQualcommMfnrFrames = 5;
    public boolean showZoomSlider = false;
    public boolean alternateImageReaderFlags = false;
    public boolean useHqSubsampling = false;
    public boolean useParallelAvif = false;
    public boolean use16Bit = false;
    public boolean useJpegUltraHdr = false;
    public boolean writeCaptureResult = false;
    public int colorTemperature = 999;
    public float colorTint = 0.0f;

    public void loadCache() {
        noiseReduction = PreferenceKeys.isSystemNrOn();
        frameCount = PreferenceKeys.getFrameCountValue();
        align = PreferenceKeys.isDisableAligningOn();
        lumenCount = PreferenceKeys.getLumaNrValue();
        chromaCount = PreferenceKeys.getChromaNrValue();
        enhancedProcess = PreferenceKeys.isEnhancedProcessionOn();
        watermark = PreferenceKeys.isShowWatermarkOn();
        energySaving = PreferenceKeys.getBool(PreferenceKeys.Key.KEY_ENERGY_SAVING);
        aspect169 = PreferenceKeys.getBool(PreferenceKeys.Key.KEY_WIDE169);
        earlyVendorKeysLoading = PreferenceKeys.getBool(PreferenceKeys.Key.KEY_EARLY_VENDOR_KEYS_LOADING);
        binning = PreferenceKeys.isBinningOn();
        Allocator.binning = binning;
        useThumbnail = PreferenceKeys.getBool(PreferenceKeys.Key.KEY_THUMBNAIL);
        useExposureFusionMethod2 = PreferenceKeys.isExposureFusionMethod2();
        isTonnemappingModeQuality = PreferenceKeys.isToneMappingQualityOn();
        //DebugData = PreferenceKeys.isAfDataOn();
        roundEdge = PreferenceKeys.isRoundEdgeOn();
        sharpness = PreferenceKeys.getSharpnessValue();
        contrastMpy = PreferenceKeys.getContrastValue();//TODO recheck
        saturation = PreferenceKeys.getSaturationValue();
        exposureCompensation = PreferenceKeys.getFloat(PreferenceKeys.Key.KEY_EXPOCOMPENSATE_SEEKBAR);
        compressor = PreferenceKeys.getCompressorValue();
        noiseRstr = PreferenceKeys.getFloat(PreferenceKeys.Key.KEY_NOISESTR_SEEKBAR);
        mergeStrength = PreferenceKeys.getFloat(PreferenceKeys.Key.KEY_MERGE_SEEKBAR);
        gain = PreferenceKeys.getGainValue();
        shadows = PreferenceKeys.getFloat(PreferenceKeys.Key.KEY_SHADOWS_SEEKBAR);
        hdrx = PreferenceKeys.isHdrxNrOn();
        defaultCfaPattern = PreferenceKeys.getCFAValue();
        rawSaver = PreferenceKeys.isSaveRaw();
        remosaic = PreferenceKeys.isRemosaicOn();
        eisPhoto = PreferenceKeys.isEisPhotoOn();
        QuadBayer = PreferenceKeys.isQuadBayerOn();
        fpsPreview = PreferenceKeys.isFpsPreviewOn();
        hdrxNR = PreferenceKeys.isHdrxNrOn();
        alignAlgorithm = PreferenceKeys.getAlignMethodValue();
        colorMethod = PreferenceKeys.getColorMethodValue();
        focusPeak = PreferenceKeys.getFocusPeakValue();
        previewFormat = PreferenceKeys.getPreviewFormatValue();
        realPreviewFormat = PreferenceKeys.getRealPreviewFormatValue();
        rawFormat = PreferenceKeys.getRawFormatValue();
        functionOne = PreferenceKeys.getFunctionOneValue();
        functionTwo = PreferenceKeys.getFunctionTwoValue();
        selectedMode = CameraMode.valueOf(PreferenceKeys.getCameraModeOrdinal());
        toneMap = parseToneMapArray();
        gamma = parseGammaArray();
        mCameraID = PreferenceKeys.getCameraID();
        theme = PreferenceKeys.getThemeValue();
        lutName = PreferenceKeys.getLutName();
        demosaicMethod = PreferenceKeys.getDemosaicMethod();
        disableVendorKeys = PreferenceKeys.disableVendorKeys();
        disableNoGuiYet = PreferenceKeys.disableNoGuiYet();
        useParallelAvif = PreferenceKeys.isParallelAvifOn();
        use16Bit = PreferenceKeys.is16BitOn();
        useJpegUltraHdr = PreferenceKeys.isUltraHdrOn();
        writeCaptureResult = PreferenceKeys.writeCaptureResultOn();
        // QualityDoesMatter - General
        useBasicOsd = PreferenceKeys.useBasicOsdOn();
        useOis = PreferenceKeys.useOisOn();
        useDngCompression = PreferenceKeys.useDngCompression();
        singleFrameQuality = PreferenceKeys.getSingleFrameQualityValue();
        apertureToUse = PreferenceKeys.getAperture();
        useExtendIso = PreferenceKeys.useExtendIsoOn();
        useExtendExposure = PreferenceKeys.useExtendExposureOn();
        useExternalGallery = PreferenceKeys.useExternalGallery();
        useAlternateLoupe = PreferenceKeys.useAlternateLupe();
        useVirtualHorizon = PreferenceKeys.useVirtualHorizon();
        useVirtualHorizonText = PreferenceKeys.useVirtualHorizonText();
        allowNetworkSync = PreferenceKeys.allowNetworkSync();
        gpsLocation = PreferenceKeys.gpsLocation();
        sessionType = PreferenceKeys.getSessionType();
        sessionTypeVideo = PreferenceKeys.getSessionTypeVideo();
        dngBlackLevel = PreferenceKeys.getDngBlackLevel();
        dngWhiteLevel = PreferenceKeys.getDngWhiteLevel();
        int newSensorModeDefault = PreferenceKeys.getSensorModeDefault();
        if (!sensorModeStateInitialized
                || (PreferenceKeys.isPerLensSettingsOn() && !Objects.equals(sensorModeCameraId, mCameraID))
                || sensorModeDefault != newSensorModeDefault) {
            sensorModeDefault = newSensorModeDefault;
            sensorModeOn = sensorModeDefault;
            sensorModeCameraId = mCameraID;
            sensorModeStateInitialized = true;
        }
        sensorMode1 = loadSensorModeConfiguration(SENSOR_MODE_1);
        sensorMode2 = loadSensorModeConfiguration(SENSOR_MODE_2);
        applySensorModeConfiguration();
        useP3 = PreferenceKeys.isP3On();
        // QualityDoesMatter - Video
        videoBitrate = PreferenceKeys.getVideoBitrate();
        videoCodec = PreferenceKeys.getVideoCodec();
        videoFramrate = PreferenceKeys.getVideoFramerate();
        videoHeight = PreferenceKeys.getVideoHeight();
        videoEisInPreview = PreferenceKeys.isEisInPreviewVideoOn();
        videoHDR = PreferenceKeys.isHdrVideoOn();
        video10bit = PreferenceKeys.is10bitVideoOn();
        videoNewRec = PreferenceKeys.isNeRecVideoOn();
        keyframeInterval = PreferenceKeys.getKeyframeInterval();
        hdrMode = PreferenceKeys.getHdrMode();
        transferFunction = PreferenceKeys.getTransferFunction();
        videoEncoderName = PreferenceKeys.getVideoEncoderName();
        exposureCompensation2 = PreferenceKeys.getExposureCompensation();
        videoRange = PreferenceKeys.getVideoRange();
        videoLogicalWorkaround = PreferenceKeys.isVideoLogicalWorkaroundOn();
        colorspace = PreferenceKeys.getColorspace();
        // QualityDoesMatter - Audio
        audioProcessing = PreferenceKeys.getAudioProcessing();
        audioCodec = PreferenceKeys.getAudioCodec();
        audioProcessingStr = PreferenceKeys.getAudioProcessingStr();
        audioCodecStr = PreferenceKeys.getAudioCodecStr();
        audioSps = PreferenceKeys.getAudioSps();
        audioBitrate = PreferenceKeys.getAudioBitrate();
        audioChannels = PreferenceKeys.getAudioChannels();
        audioDirection = PreferenceKeys.getAudioDirection();
        audioZoom = PreferenceKeys.getAudioZoom();
        // QualityDoesMatter - SoC - Qualcomm/Snapdragon
        socQualcommSharpness = PreferenceKeys.getSocQualcommSharpness();
        socQualcommSaturation = PreferenceKeys.getSocQualcommSaturation();
        socQualcommContrast = PreferenceKeys.getSocQualcommContrast();
        socQualcommSaturationHdrVideo = PreferenceKeys.getSocQualcommSaturationVideo();
        socQualcommContrastHdrVideo = PreferenceKeys.getSocQualcommContrastVideo();
        socQualcommEisMode = PreferenceKeys.getSocQualcommEisMode();
        socQualcommAiMode = PreferenceKeys.getSocQualcommAiMode();
        socQualcommUseIsz = PreferenceKeys.isSocQualcommIszOn();
        socQualcommUseMfnr = PreferenceKeys.isSocQualcommMfnrOn();
        socQualcommAutoHdr = PreferenceKeys.isSocQualcommAutoHdrOn();
        socQualcommLtmOff = PreferenceKeys.isSocQualcommLtmOff();
        socQualcommHdrMode = PreferenceKeys.getSocQualcommHdrMode();
        socQualcommManualWb = PreferenceKeys.getSocQualcommManualWb();
        socQualcommMfnrFrames = PreferenceKeys.getSocQualcommMfnrFrames();
        // QualityDoesMatter - Single Shot & Video Related
        useZsl = PreferenceKeys.isZslOn();
        useSceneAndEffectMode = PreferenceKeys.isSceneAndEffectModeOn();
        useNewSettingsGloabal = PreferenceKeys.isNewSettingsGlobalOn();
        noiseProcessing = PreferenceKeys.getNoiseProcessing();
        edgeProcessing = PreferenceKeys.getEdgeProcessing();
        zoom2X = PreferenceKeys.isZoomOn();
        digitalZoomFactor = PreferenceKeys.getDigitalZoomFactorValue();
        hotPixelMode = PreferenceKeys.getHotPixelMode();
        colorCorrectionAberrationMode = PreferenceKeys.getColorCorrectionAberrationMode();
        distortionCorrectionMode = PreferenceKeys.getDistortionCorrectionMode();
        shadingMode = PreferenceKeys.getShadingMode();
        useAlternatePreviewTemplate = PreferenceKeys.useAlternatePreviewTemplate();
        contrastCurve = PreferenceKeys.getContrastCurve();
        effectMode = PreferenceKeys.getEffectMode();
        useLosslessSwEncoding = PreferenceKeys.isLosslessSwEncodingOn();
        useStreamUseCases = PreferenceKeys.useStreamUsecase();
        photoTransferFunction = PreferenceKeys.getPhotoTransferFunction();
        photoColorSpace = PreferenceKeys.getPhotoColorSpace();
        photoRange = PreferenceKeys.getPhotoRange();
        photoVideoCodec = PreferenceKeys.getPhotoVideoCodec();
        showZoomSlider = PreferenceKeys.showZoomSlider();
        swColorSpace = PreferenceKeys.getSwColorSpace();
        alternateImageReaderFlags = PreferenceKeys.isAlternateImageReaderFlagsOn();
        useHqSubsampling = PreferenceKeys.isHqSubsamplingOn();
        colorTemperature = PreferenceKeys.getColorTemperature();
        colorTint = PreferenceKeys.getColorTint();
    }

    public int getSessionType() {
        SensorModeConfiguration configuration = getActiveSensorModeConfiguration();
        return configuration == null ? sessionType : configuration.sessionType;
    }

    public int getSessionTypeVideo() {
        SensorModeConfiguration configuration = getActiveSensorModeConfiguration();
        return configuration == null ? sessionTypeVideo : configuration.sessionTypeVideo;
    }

    public int getDngBlackLevel() {
        SensorModeConfiguration configuration = getActiveSensorModeConfiguration();
        return configuration == null ? dngBlackLevel : configuration.dngBlackLevel;
    }

    public int getDngWhiteLevel() {
        SensorModeConfiguration configuration = getActiveSensorModeConfiguration();
        return configuration == null ? dngWhiteLevel : configuration.dngWhiteLevel;
    }

    public boolean isDcg1610CropOn() {
        SensorModeConfiguration configuration = getActiveSensorModeConfiguration();
        return configuration != null && configuration.dcg1610Crop;
    }

    public boolean hasSensorModeConfiguration() {
        return hasSensorModeConfiguration(sensorModeOn);
    }

    public boolean hasSensorModeConfiguration(int sensorMode) {
        SensorModeConfiguration configuration = getSensorModeConfiguration(sensorMode);
        return configuration != null && configuration.key != null
                && !configuration.key.trim().isEmpty() && configuration.value >= 0;
    }

    public boolean isSensorModeActive() {
        return sensorModeOn != SENSOR_MODE_OFF && hasSensorModeConfiguration();
    }

    public String getSensorModeKey(int sensorMode) {
        SensorModeConfiguration configuration = getSensorModeConfiguration(sensorMode);
        return configuration == null ? "" : configuration.key;
    }

    public int getSensorModeValue(int sensorMode) {
        SensorModeConfiguration configuration = getSensorModeConfiguration(sensorMode);
        return configuration == null ? -1 : configuration.value;
    }

    public void setSensorMode(int sensorMode) {
        sensorModeOn = sensorMode == SENSOR_MODE_1 || sensorMode == SENSOR_MODE_2
                ? sensorMode : SENSOR_MODE_OFF;
        applySensorModeConfiguration();
    }

    private SensorModeConfiguration loadSensorModeConfiguration(int sensorMode) {
        SensorModeConfiguration configuration = new SensorModeConfiguration();
        configuration.key = PreferenceKeys.getSensorModeKey(sensorMode);
        configuration.value = PreferenceKeys.getSensorModeValue(sensorMode);
        configuration.sessionType = PreferenceKeys.getSensorModeSessionType(sensorMode);
        configuration.sessionTypeVideo = PreferenceKeys.getSensorModeSessionTypeVideo(sensorMode);
        configuration.dngBlackLevel = PreferenceKeys.getSensorModeDngBlackLevel(sensorMode);
        configuration.dngWhiteLevel = PreferenceKeys.getSensorModeDngWhiteLevel(sensorMode);
        configuration.cfaPattern = PreferenceKeys.getSensorModeCfa(sensorMode);
        configuration.dcg1610Crop = PreferenceKeys.isSensorModeDcg1610CropOn(sensorMode);
        return configuration;
    }

    private SensorModeConfiguration getSensorModeConfiguration(int sensorMode) {
        if (sensorMode == SENSOR_MODE_1) {
            return sensorMode1;
        }
        if (sensorMode == SENSOR_MODE_2) {
            return sensorMode2;
        }
        return null;
    }

    private SensorModeConfiguration getActiveSensorModeConfiguration() {
        return isSensorModeActive() ? getSensorModeConfiguration(sensorModeOn) : null;
    }

    private void applySensorModeConfiguration() {
        SensorModeConfiguration configuration = getSensorModeConfiguration(sensorModeOn);
        if (configuration == null) {
            sensorModeKey = "";
            sensorModeValue = -1;
            cfaPattern = defaultCfaPattern;
            return;
        }

        sensorModeKey = configuration.key;
        sensorModeValue = configuration.value;
        cfaPattern = configuration.cfaPattern;
    }

    private static class SensorModeConfiguration {
        String key = "";
        int value = -1;
        int sessionType = 0;
        int sessionTypeVideo = 0;
        int dngBlackLevel = -1;
        int dngWhiteLevel = -1;
        int cfaPattern = -1;
        boolean dcg1610Crop = false;
    }

    public void saveID() {
        PreferenceKeys.setCameraID(mCameraID);
    }

    float[] parseToneMapArray() {
        String savedArrayAsString = PreferenceKeys.getToneMap();
        if (savedArrayAsString == null)
            return new float[0];
        String[] array = savedArrayAsString.replace("[", "").replace("]", "").split(",");
        float[] finalArray = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            finalArray[i] = Float.parseFloat(array[i].trim());
        }
        return finalArray;
    }

    float[] parseGammaArray() {
        String savedArrayAsString = PreferenceKeys.getPref(PreferenceKeys.Key.GAMMA);
        if (savedArrayAsString == null)
            return new float[0];
        String[] array = savedArrayAsString.replace("[", "").replace("]", "").split(",");
        float[] finalArray = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            finalArray[i] = Float.parseFloat(array[i].trim());
        }
        return finalArray;
    }

}
