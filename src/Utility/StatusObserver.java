package Utility;

public class StatusObserver {
    
	private static final StatusObserver STATUS = new StatusObserver();;
    
	private StatusObserver(){}

    public static StatusObserver getStatus(){
        return STATUS;
    }
	
	private Status currentStatus;
	private boolean showCutVerticesIsOn = false;
	
	public boolean isShowCutVerticesIsOn() {
		return showCutVerticesIsOn;
	}

	public void setShowCutVerticesIsOn(boolean showCutVerticesIsOn) {
		this.showCutVerticesIsOn = showCutVerticesIsOn;
	}

	public Status getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(Status status) {
		currentStatus = status;
	}
	
}
