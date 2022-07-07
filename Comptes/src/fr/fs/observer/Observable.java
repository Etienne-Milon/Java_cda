package fr.fs.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {
	private List<Observer> observers = new ArrayList<>();

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	public void notifie() {
		for (Observer observateur : observers)
			observateur.actualise(this);
	}
}
