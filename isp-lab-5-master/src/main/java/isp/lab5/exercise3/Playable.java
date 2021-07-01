package isp.lab5.exercise3;

interface Playable {
    void play();
}

class ColorVideo implements Playable {

    private String fileName;

    public ColorVideo(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void play() {
        System.out.println("Play " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading video..." + fileName);
    }
}

class ProxyVideo implements Playable {

    private Playable video;
    private String fileName;
    private String colorType;

    public ProxyVideo(String fileName, String colorType){
        this.fileName = fileName;
        this.colorType=colorType;
    }

    @Override
    public void play() {
        if(video == null){
            if (colorType.equals("Color")) video = new ColorVideo(fileName);
            else
                if (colorType.equals("BlackAndWhite")) video = new BlackAndWhiteVideo(fileName);
        }
        video.play();
    }
}

class BlackAndWhiteVideo implements Playable{
  
    private String fileName;

    public BlackAndWhiteVideo(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }    
    
    @Override
    public void play() {
        System.out.println("Play black and white video" + fileName);
    }
    
    private void loadFromDisk(String fileName){
        System.out.println("Loading video..." + fileName);
    }
}