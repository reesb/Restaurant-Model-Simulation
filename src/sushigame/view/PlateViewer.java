package sushigame.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401.sushi.IngredientPortion;
import comp401.sushi.Plate;

public class PlateViewer extends JPanel {

	private int _age;

	private JLabel _plateColor;
	private JLabel _sushiType;
	private JLabel _sushiTypeInfo;
	private JLabel _chefName;
	private JLabel _plateAge;

	public PlateViewer(int age) {
		_age = age;

		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

		_plateColor = new JLabel();
		_sushiType = new JLabel();
		_sushiTypeInfo = new JLabel();
		_chefName = new JLabel();
		_plateAge = new JLabel();

		add(_plateColor);
		add(_sushiType);
		add(_sushiTypeInfo);
		add(_chefName);
		add(_plateAge);
	}

	public void setColor(Plate p) {
		_plateColor.setText(p.getColor().toString() + " PLATE");
		_plateColor.setPreferredSize(new Dimension(100, 20));
		_plateColor.setMinimumSize(new Dimension(100, 20));
		_plateColor.setMaximumSize(new Dimension(100, 20));
	}

	public void setSushiType(Plate p) {
		_sushiType.setText("Sushi Type: " + p.getContents().getName());
		_sushiType.setPreferredSize(new Dimension(160, 20));
		_sushiType.setMinimumSize(new Dimension(160, 20));
		_sushiType.setMaximumSize(new Dimension(160, 20));
	}

	public void setSushiTypeInfo(Plate p) {
		if (p.getContents().getName().contains("Roll")) {
			IngredientPortion[] sushiIngredients = p.getContents().getIngredients();
			String ingredients = "";
			for (int i = 0; i < sushiIngredients.length; i++) {
				if (i == sushiIngredients.length - 1) {
					ingredients += sushiIngredients[i].getName() + "("
							+ (Math.round(sushiIngredients[i].getAmount() * 10.0) / 10.0) + "oz)";
				} else
					ingredients += sushiIngredients[i].getName() + "("
							+ (Math.round(sushiIngredients[i].getAmount() * 10.0) / 10.0) + "oz)" + ", ";
			}
			_sushiTypeInfo.setText("Ingredients: " + ingredients);
		} else {
			_sushiTypeInfo.setText("");
		}
		_sushiTypeInfo.setPreferredSize(new Dimension(700, 20));
		_sushiTypeInfo.setMinimumSize(new Dimension(700, 20));
		_sushiTypeInfo.setMaximumSize(new Dimension(700, 20));
	}

	public void setChef(Plate p) {
		_chefName.setText("Chef: " + p.getChef().getName());
		_chefName.setPreferredSize(new Dimension(150, 20));
		_chefName.setMinimumSize(new Dimension(150, 20));
		_chefName.setMaximumSize(new Dimension(150, 20));
	}

	public void setAge() {
		_plateAge.setText("Age: " + _age);
		_plateAge.setPreferredSize(new Dimension(75, 20));
		_plateAge.setMinimumSize(new Dimension(75, 20));
		_plateAge.setMaximumSize(new Dimension(75, 20));
	}

	public void reset() {
		_plateColor.setText("");
		_sushiType.setText("");
		_sushiTypeInfo.setText("");
		_chefName.setText("");
		_plateAge.setText("");

		setBackground(Color.GRAY);
		setMinimumSize(new Dimension(300, 20));
		setPreferredSize(new Dimension(300, 20));
		setOpaque(true);

	}
}
