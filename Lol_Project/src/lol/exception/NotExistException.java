package lol.exception;

// 유저, 프로젝트 id 등 존재하지 않을 경우에 발생 
public class NotExistException extends Exception{
	public NotExistException(){}
	public NotExistException(String message){
		super(message);
	}
}
