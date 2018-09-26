package sushigame.view;

import java.util.Comparator;

import sushigame.model.Chef;

public class HighToLowFoodSoldComparator implements Comparator<Chef> {

	@Override
	public int compare(Chef a, Chef b) {
		return (int) (Math.round(b.getFoodConsumed() * 100.0) - Math.round(a.getFoodConsumed() * 100));
	}
}
