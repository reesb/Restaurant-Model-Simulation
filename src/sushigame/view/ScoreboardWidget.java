package sushigame.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;
import sushigame.model.Chef;
import sushigame.model.SushiGameModel;

public class ScoreboardWidget extends JPanel implements BeltObserver, ActionListener {

	private SushiGameModel game_model;
	private JLabel display;
	private JComboBox _scoreboardTypes;

	private int _menuType;

	public ScoreboardWidget(SushiGameModel gm) {
		game_model = gm;
		game_model.getBelt().registerBeltObserver(this);

		String[] _scoreboardDisplayOptions = { "Sort by chef account balance", "Sort by chef total food consumed",
				"Sort by chef total food spoiled" };

		setLayout(new GridLayout(2, 1));
		_scoreboardTypes = new JComboBox(_scoreboardDisplayOptions);
		_scoreboardTypes.addActionListener(this);

		display = new JLabel();
		display.setVerticalAlignment(SwingConstants.TOP);

		display.setText(makeScoreboardHTML());

		JPanel box = new JPanel();
		box.setLayout(new GridLayout(3, 1));

		box.add(_scoreboardTypes);
		box.add(display);
		add(box);

	}

	private String makeScoreboardHTML() {
		String sb_html = "<html>";
		sb_html += "<h1>Scoreboard</h1>";

		Chef[] opponent_chefs = game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length + 1];
		chefs[0] = game_model.getPlayerChef();
		for (int i = 1; i < chefs.length; i++) {
			chefs[i] = opponent_chefs[i - 1];
		}

		if (_menuType == 0) {
			Arrays.sort(chefs, new HighToLowBalanceComparator());

			for (Chef c : chefs) {
				sb_html += c.getName() + " ($" + Math.round(c.getBalance() * 100.0) / 100.0 + ") <br>";
			}
		} else if (_menuType == 1) {
			Arrays.sort(chefs, new HighToLowFoodSoldComparator());

			for (Chef c : chefs) {
				sb_html += c.getName() + " ($" + Math.round(c.getFoodConsumed() * 100.0) / 100.0 + ") <br>";
			}
		} else if (_menuType == 2) {
			Arrays.sort(chefs, new LowToHighFoodSpoiledComparator());

			for (Chef c : chefs) {
				sb_html += c.getName() + " ($" + Math.round(c.getFoodSpoiled() * 100.0) / 100.0 + ") <br>";
			}
		}
		return sb_html;
	}

	public void refresh() {
		display.setText(makeScoreboardHTML());
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {
		if (e.getType() == BeltEvent.EventType.ROTATE) {
			refresh();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (_scoreboardTypes.getSelectedItem().toString().equals("Sort by chef account balance")) {
			_menuType = 0;
			refresh();
		} else if (_scoreboardTypes.getSelectedItem().toString().equals("Sort by chef total food consumed")) {
			_menuType = 1;
			refresh();
		} else if (_scoreboardTypes.getSelectedItem().toString().equals("Sort by chef total food spoiled")) {
			_menuType = 2;
			refresh();
		}
	}
}
