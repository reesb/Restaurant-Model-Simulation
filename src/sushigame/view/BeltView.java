package sushigame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import comp401.sushi.Plate;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;

public class BeltView extends JPanel implements BeltObserver {

	private Belt belt;
	private PlateViewer[] _beltPanels;

	public BeltView(Belt b) {
		this.belt = b;
		belt.registerBeltObserver(this);
		setLayout(new GridLayout(belt.getSize(), 1));
		_beltPanels = new PlateViewer[belt.getSize()];

		for (int i = 0; i < belt.getSize(); i++) {
			PlateViewer plateViewer = new PlateViewer(0);
			add(plateViewer);
			_beltPanels[i] = plateViewer;
		}
		refresh();

	}

	@Override
	public void handleBeltEvent(BeltEvent e) {
		refresh();
	}

	private void refresh() {
		for (int i = 0; i < belt.getSize(); i++) {
			Plate p = belt.getPlateAtPosition(i);
			PlateViewer pview = _beltPanels[i];

			if (p == null) {
				pview.reset();
				pview.setMinimumSize(new Dimension(300, 20));
				pview.setPreferredSize(new Dimension(300, 20));
				pview.setOpaque(true);
			} else {
				pview.setColor(belt.getPlateAtPosition(i));
				pview.setSushiType(p);
				pview.setSushiTypeInfo(p);
				pview.setChef(p);
				pview.setAge();

				switch (p.getColor()) {
				case RED:
					pview.setBackground(Color.RED);
					break;
				case GREEN:
					pview.setBackground(Color.GREEN);
					break;
				case BLUE:
					pview.setBackground(Color.BLUE);
					break;
				case GOLD:
					pview.setBackground(Color.YELLOW);
					break;
				}
			}
		}
	}
}
