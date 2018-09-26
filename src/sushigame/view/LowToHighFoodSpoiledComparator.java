package sushigame.view;

import java.util.Comparator;

import sushigame.model.Chef;

public class LowToHighFoodSpoiledComparator implements Comparator<Chef> {

	@Override
	public int compare(Chef a, Chef b) {
		return (int) (Math.round(a.getFoodSpoiled() * 100) - Math.round(b.getFoodSpoiled() * 100.0));
	}

}
