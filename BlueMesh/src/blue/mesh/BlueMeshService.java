package blue.mesh;



public class BlueMeshService {
	
	public BlueMeshService(){
		
	}
	
	public int config(){
		
		return Constants.SUCCESS;
	}
	
	public int launch(){
		
		return Constants.SUCCESS;
	}
	
	public int write( byte [] buffer){
		
		return Constants.SUCCESS;
	}
	
	public byte [] pull(){
		
		return null;
	}
	
	public int disconnect(){
		
		return Constants.SUCCESS;
	}

}
