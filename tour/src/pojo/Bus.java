package pojo;

public class Bus {
	String bus_id;
	String start;
	String stop;
	String start_time;
	String stop_time;
	int seat;
	double price;
	String bus_station;
	public String getBus_station() {
		return bus_station;
	}
	public void setBus_station(String bus_station) {
		this.bus_station = bus_station;
	}
	public String getBus_id() {
		return bus_id;
	}
	public void setBus_id(String bus_id) {
		this.bus_id = bus_id;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getStop() {
		return stop;
	}
	public void setStop(String stop) {
		this.stop = stop;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String strat_time) {
		this.start_time = strat_time;
	}
	public String getStop_time() {
		return stop_time;
	}
	public void setStop_time(String stop_time) {
		this.stop_time = stop_time;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
