import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class TimingRecord {
private LocalDateTime _start;
private LocalDateTime _finish;
private Duration _duration;
private STATUS _eventCode;
private enum STATUS {
	 START, DNF, FINISH, CANCEL
}

public TimingRecord()
{
_start=null;
_finish=null;
_duration=null;
}

public void start(){
	_start=LocalDateTime.now();
	_eventCode=STATUS.START;
}

public void finish(){
	_finish=LocalDateTime.now();
	_eventCode=STATUS.FINISH;
	_duration=Duration.between(_start, _finish);
}

public void DNF(){
	_eventCode=STATUS.DNF;
}

public void cancel(){
	_eventCode=STATUS.CANCEL;
}

public LocalDateTime get_start() {
	return _start;
}

public LocalDateTime get_finish() {
	return _finish;
}

public Duration get_duration() {
	return _duration;
}

public STATUS get_eventCode() {
	return _eventCode;
}

public String toString()
{
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLL yyyy HH:mm:ss.SS");
	if(_eventCode==STATUS.CANCEL) return "***CANCEL***";
	else if(_eventCode==STATUS.START) {
		return "***START***	 Start: " + _start.format(formatter);
	}
	else if(_eventCode==STATUS.DNF) {
		return "***DNF***		Start: " + _start.format(formatter);
	}
	else{
		return "***FINISH***	Start: " + _start.format(formatter) + "	Finish: " + _finish.format(formatter) + 
				"	Duration: " + _duration.getSeconds() + "." +_duration.getNano();
	}
	
}

}