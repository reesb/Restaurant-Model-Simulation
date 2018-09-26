package sushigame.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import comp401.sushi.AvocadoPortion;
import comp401.sushi.CrabPortion;
import comp401.sushi.EelPortion;
import comp401.sushi.IngredientPortion;
import comp401.sushi.Nigiri;
import comp401.sushi.RicePortion;
import comp401.sushi.Roll;
import comp401.sushi.SalmonPortion;
import comp401.sushi.Sashimi;
import comp401.sushi.SeaweedPortion;
import comp401.sushi.ShrimpPortion;
import comp401.sushi.Sushi;
import comp401.sushi.TunaPortion;

public class PlayerChefView extends JPanel implements ActionListener {

	private List<ChefViewListener> listeners;
	private int belt_size;
	private String _sashimiType = "Choose sashimi type...";
	private String _nigiriType = "Choose nigiri type...";
	private String _plateColor = "Choose plate color...";
	private int _position;

	private JSlider _goldPlatePriceSlider;
	private JSlider _avocadoSlider;
	private JSlider _crabSlider;
	private JSlider _eelSlider;
	private JSlider _riceSlider;
	private JSlider _salmonSlider;
	private JSlider _seaweedSlider;
	private JSlider _shrimpSlider;
	private JSlider _tunaSlider;

	public PlayerChefView(int belt_size) {
		this.belt_size = belt_size;
		listeners = new ArrayList<ChefViewListener>();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel box = new JPanel();

		String[] sashimiTypes = { "Choose sashimi type...", "Crab Sashimi", "Eel Sashimi", "Salmon Sashimi",
				"Shrimp Sashimi", "Tuna Sashimi" };
		String[] nigiriTypes = { "Choose nigiri type...", "Crab Nigiri", "Eel Nigiri", "Salmon Nigiri", "Shrimp Nigiri",
				"Tuna Nigiri" };
		String[] plateColors = { "Choose plate color...", "RED", "BLUE", "GREEN", "GOLD" };
		String[] positions = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20" };

		JComboBox sashimiMenu = new JComboBox(sashimiTypes);
		sashimiMenu.setPreferredSize(new Dimension(300, 20));
		sashimiMenu.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED)
					_sashimiType = sashimiTypes[sashimiMenu.getSelectedIndex()];
			}
		});

		JComboBox nigiriMenu = new JComboBox(nigiriTypes);
		nigiriMenu.setPreferredSize(new Dimension(300, 20));
		nigiriMenu.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED)
					_nigiriType = nigiriTypes[nigiriMenu.getSelectedIndex()];
			}
		});

		JComboBox colorMenu = new JComboBox(plateColors);
		colorMenu.setPreferredSize(new Dimension(300, 20));
		colorMenu.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED)
					_plateColor = plateColors[colorMenu.getSelectedIndex()];
			}
		});

		JComboBox position = new JComboBox(positions);
		position.setPreferredSize(new Dimension(300, 20));
		position.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED)
					_position = Integer.parseInt(positions[position.getSelectedIndex()]);
			}
		});

		box.add(sashimiMenu);
		box.add(nigiriMenu);
		box.add(colorMenu);
		box.add(position);

		box.setPreferredSize(new Dimension(400, 100));

		_goldPlatePriceSlider = new JSlider(5, 10, 5);
		_avocadoSlider = new JSlider(0, 15, 0);
		_crabSlider = new JSlider(0, 15, 0);
		_eelSlider = new JSlider(0, 15, 0);
		_riceSlider = new JSlider(0, 15, 0);
		_salmonSlider = new JSlider(0, 15, 0);
		_seaweedSlider = new JSlider(0, 15, 0);
		_shrimpSlider = new JSlider(0, 15, 0);
		_tunaSlider = new JSlider(0, 15, 0);

		JLabel goldPlatePriceLabel = new JLabel("Gold plate price (from $5-$10):");
		JLabel avocadoAMT = new JLabel("Current avocado amount:");
		JLabel crabAMT = new JLabel("Current crab amount:");
		JLabel eelAMT = new JLabel("Current eel amount:");
		JLabel riceAMT = new JLabel("Current rice amount:");
		JLabel salmonAMT = new JLabel("Current salmon amount:");
		JLabel seaweedAMT = new JLabel("Current seaweed amount:");
		JLabel shrimpAMT = new JLabel("Current shrimp amount:");
		JLabel tunaAMT = new JLabel("Current tuna amount:");

		Dimension slider_dim = new Dimension(300, 60);
		_goldPlatePriceSlider.setPreferredSize(slider_dim);
		_avocadoSlider.setPreferredSize(slider_dim);
		_crabSlider.setPreferredSize(slider_dim);
		_eelSlider.setPreferredSize(slider_dim);
		_riceSlider.setPreferredSize(slider_dim);
		_salmonSlider.setPreferredSize(slider_dim);
		_seaweedSlider.setPreferredSize(slider_dim);
		_shrimpSlider.setPreferredSize(slider_dim);
		_tunaSlider.setPreferredSize(slider_dim);

		_goldPlatePriceSlider.setMajorTickSpacing(1);
		_goldPlatePriceSlider.setPaintTicks(true);
		_avocadoSlider.setMajorTickSpacing(1);
		_avocadoSlider.setPaintTicks(true);
		_crabSlider.setMajorTickSpacing(1);
		_crabSlider.setPaintTicks(true);
		_eelSlider.setMajorTickSpacing(1);
		_eelSlider.setPaintTicks(true);
		_riceSlider.setMajorTickSpacing(1);
		_riceSlider.setPaintTicks(true);
		_salmonSlider.setMajorTickSpacing(1);
		_salmonSlider.setPaintTicks(true);
		_seaweedSlider.setMajorTickSpacing(1);
		_seaweedSlider.setPaintTicks(true);
		_shrimpSlider.setMajorTickSpacing(1);
		_shrimpSlider.setPaintTicks(true);
		_tunaSlider.setMajorTickSpacing(1);
		_tunaSlider.setPaintTicks(true);

		box.add(goldPlatePriceLabel);
		box.add(_goldPlatePriceSlider);
		box.add(avocadoAMT);
		box.add(_avocadoSlider);
		box.add(crabAMT);
		box.add(_crabSlider);
		box.add(eelAMT);
		box.add(_eelSlider);
		box.add(riceAMT);
		box.add(_riceSlider);
		box.add(salmonAMT);
		box.add(_salmonSlider);
		box.add(seaweedAMT);
		box.add(_seaweedSlider);
		box.add(shrimpAMT);
		box.add(_shrimpSlider);
		box.add(tunaAMT);
		box.add(_tunaSlider);

		JButton addSashimiButton = new JButton();
		addSashimiButton.setActionCommand("add sashimi");
		addSashimiButton.addActionListener(this);
		addSashimiButton.setText("Add Sashimi");

		JButton addNigiriButton = new JButton();
		addNigiriButton.setActionCommand("add nigiri");
		addNigiriButton.addActionListener(this);
		addNigiriButton.setText("Add Nigiri");

		JButton addRollButton = new JButton();
		addRollButton.setActionCommand("add roll");
		addRollButton.addActionListener(this);
		addRollButton.setText("Add Roll");

		box.add(addSashimiButton);
		box.add(addNigiriButton);
		box.add(addRollButton);

		add(box);
	}

	public void registerChefListener(ChefViewListener cl) {
		listeners.add(cl);
	}

	private void makeRedPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleRedPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGreenPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleGreenPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeBluePlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleBluePlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGoldPlateRequest(Sushi plate_sushi, int plate_position, double price) {
		for (ChefViewListener l : listeners) {
			l.handleGoldPlateRequest(plate_sushi, plate_position, price);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "add sashimi":
			if (!_sashimiType.equals("Choose sashimi type...")) {
				if (_sashimiType.equals("Eel Sashimi")) {
					if (_plateColor.equals("RED")) {
						makeRedPlateRequest(new Sashimi(Sashimi.SashimiType.EEL), _position);
					} else if (_plateColor.equals("BLUE")) {
						makeBluePlateRequest(new Sashimi(Sashimi.SashimiType.EEL), _position);
					} else if (_plateColor.equals("GREEN")) {
						makeGreenPlateRequest(new Sashimi(Sashimi.SashimiType.EEL), _position);
					} else if (_plateColor.equals("GOLD")) {
						makeGoldPlateRequest(new Sashimi(Sashimi.SashimiType.EEL), _position,
								_goldPlatePriceSlider.getValue());
					}

				} else if (_sashimiType.equals("Crab Sashimi")) {
					if (_plateColor.equals("RED")) {
						makeRedPlateRequest(new Sashimi(Sashimi.SashimiType.CRAB), _position);
					} else if (_plateColor.equals("BLUE")) {
						makeBluePlateRequest(new Sashimi(Sashimi.SashimiType.CRAB), _position);
					} else if (_plateColor.equals("GREEN")) {
						makeGreenPlateRequest(new Sashimi(Sashimi.SashimiType.CRAB), _position);
					} else if (_plateColor.equals("GOLD")) {
						makeGoldPlateRequest(new Sashimi(Sashimi.SashimiType.CRAB), _position,
								_goldPlatePriceSlider.getValue());
					}
				} else if (_sashimiType.equals("Salmon Sashimi")) {
					if (_plateColor.equals("RED")) {
						makeRedPlateRequest(new Sashimi(Sashimi.SashimiType.SALMON), _position);
					} else if (_plateColor.equals("BLUE")) {
						makeBluePlateRequest(new Sashimi(Sashimi.SashimiType.SALMON), _position);
					} else if (_plateColor.equals("GREEN")) {
						makeGreenPlateRequest(new Sashimi(Sashimi.SashimiType.SALMON), _position);
					} else if (_plateColor.equals("GOLD")) {
						makeGoldPlateRequest(new Sashimi(Sashimi.SashimiType.SALMON), _position,
								_goldPlatePriceSlider.getValue());
					}
				} else if (_sashimiType.equals("Shrimp Sashimi")) {
					if (_plateColor.equals("RED")) {
						makeRedPlateRequest(new Sashimi(Sashimi.SashimiType.SHRIMP), _position);
					} else if (_plateColor.equals("BLUE")) {
						makeBluePlateRequest(new Sashimi(Sashimi.SashimiType.SHRIMP), _position);
					} else if (_plateColor.equals("GREEN")) {
						makeGreenPlateRequest(new Sashimi(Sashimi.SashimiType.SHRIMP), _position);
					} else if (_plateColor.equals("GOLD")) {
						makeGoldPlateRequest(new Sashimi(Sashimi.SashimiType.SHRIMP), _position,
								_goldPlatePriceSlider.getValue());
					}
				} else if (_sashimiType.equals("Tuna Sashimi")) {
					if (_plateColor.equals("RED")) {
						makeRedPlateRequest(new Sashimi(Sashimi.SashimiType.TUNA), _position);
					} else if (_plateColor.equals("BLUE")) {
						makeBluePlateRequest(new Sashimi(Sashimi.SashimiType.TUNA), _position);
					} else if (_plateColor.equals("GREEN")) {
						makeGreenPlateRequest(new Sashimi(Sashimi.SashimiType.TUNA), _position);
					} else if (_plateColor.equals("GOLD")) {
						makeGoldPlateRequest(new Sashimi(Sashimi.SashimiType.TUNA), _position,
								_goldPlatePriceSlider.getValue());
					}
				}
			}
			break;
		case "add nigiri":
			if (_nigiriType.equals("Choose sashimi type...")) {
				if (_nigiriType.equals("Eel Nigiri")) {
					if (_plateColor.equals("RED")) {
						makeRedPlateRequest(new Nigiri(Nigiri.NigiriType.EEL), _position);
					} else if (_plateColor.equals("BLUE")) {
						makeBluePlateRequest(new Nigiri(Nigiri.NigiriType.EEL), _position);
					} else if (_plateColor.equals("GREEN")) {
						makeGreenPlateRequest(new Nigiri(Nigiri.NigiriType.EEL), _position);
					} else if (_plateColor.equals("GOLD")) {
						makeGoldPlateRequest(new Nigiri(Nigiri.NigiriType.EEL), _position,
								_goldPlatePriceSlider.getValue());
					}

				} else if (_nigiriType.equals("Crab Nigiri")) {
					if (_plateColor.equals("RED")) {
						makeRedPlateRequest(new Nigiri(Nigiri.NigiriType.CRAB), _position);
					} else if (_plateColor.equals("BLUE")) {
						makeBluePlateRequest(new Nigiri(Nigiri.NigiriType.CRAB), _position);
					} else if (_plateColor.equals("GREEN")) {
						makeGreenPlateRequest(new Nigiri(Nigiri.NigiriType.CRAB), _position);
					} else if (_plateColor.equals("GOLD")) {
						makeGoldPlateRequest(new Nigiri(Nigiri.NigiriType.CRAB), _position,
								_goldPlatePriceSlider.getValue());
					}
				} else if (_nigiriType.equals("Salmon Nigiri")) {
					if (_plateColor.equals("RED")) {
						makeRedPlateRequest(new Nigiri(Nigiri.NigiriType.SALMON), _position);
					} else if (_plateColor.equals("BLUE")) {
						makeBluePlateRequest(new Nigiri(Nigiri.NigiriType.SALMON), _position);
					} else if (_plateColor.equals("GREEN")) {
						makeGreenPlateRequest(new Nigiri(Nigiri.NigiriType.SALMON), _position);
					} else if (_plateColor.equals("GOLD")) {
						makeGoldPlateRequest(new Nigiri(Nigiri.NigiriType.SALMON), _position,
								_goldPlatePriceSlider.getValue());
					}
				} else if (_nigiriType.equals("Shrimp Nigiri")) {
					if (_plateColor.equals("RED")) {
						makeRedPlateRequest(new Nigiri(Nigiri.NigiriType.SHRIMP), _position);
					} else if (_plateColor.equals("BLUE")) {
						makeBluePlateRequest(new Nigiri(Nigiri.NigiriType.SHRIMP), _position);
					} else if (_plateColor.equals("GREEN")) {
						makeGreenPlateRequest(new Nigiri(Nigiri.NigiriType.SHRIMP), _position);
					} else if (_plateColor.equals("GOLD")) {
						makeGoldPlateRequest(new Nigiri(Nigiri.NigiriType.SHRIMP), _position,
								_goldPlatePriceSlider.getValue());
					}
				} else if (_nigiriType.equals("Tuna Nigiri")) {
					if (_plateColor.equals("RED")) {
						makeRedPlateRequest(new Nigiri(Nigiri.NigiriType.TUNA), _position);
					} else if (_plateColor.equals("BLUE")) {
						makeBluePlateRequest(new Nigiri(Nigiri.NigiriType.TUNA), _position);
					} else if (_plateColor.equals("GREEN")) {
						makeGreenPlateRequest(new Nigiri(Nigiri.NigiriType.TUNA), _position);
					} else if (_plateColor.equals("GOLD")) {
						makeGoldPlateRequest(new Nigiri(Nigiri.NigiriType.TUNA), _position,
								_goldPlatePriceSlider.getValue());
					}
				}
			}
			break;
		case "add roll":
			int i = 0;
			if (_avocadoSlider.getValue() > 0) {
				i++;
			}
			if (_crabSlider.getValue() > 0) {
				i++;
			}
			if (_eelSlider.getValue() > 0) {
				i++;
			}
			if (_riceSlider.getValue() > 0) {
				i++;
			}
			if (_salmonSlider.getValue() > 0) {
				i++;
			}
			if (_seaweedSlider.getValue() > 0) {
				i++;
			}
			if (_shrimpSlider.getValue() > 0) {
				i++;
			}
			if (_tunaSlider.getValue() > 0) {
				i++;
			}

			IngredientPortion[] roll = new IngredientPortion[i];
			i = 0;

			if (_avocadoSlider.getValue() > 0) {
				roll[i] = new AvocadoPortion(_avocadoSlider.getValue() / 10.0);
				i++;
			}
			if (_crabSlider.getValue() > 0) {
				roll[i] = new CrabPortion(_crabSlider.getValue() / 10.0);
				i++;
			}
			if (_eelSlider.getValue() > 0) {
				roll[i] = new EelPortion(_eelSlider.getValue() / 10.0);
				i++;
			}
			if (_riceSlider.getValue() > 0) {
				roll[i] = new RicePortion(_riceSlider.getValue() / 10.0);
				i++;
			}
			if (_salmonSlider.getValue() > 0) {
				roll[i] = new SalmonPortion(_salmonSlider.getValue() / 10.0);
				i++;
			}
			if (_seaweedSlider.getValue() > 0) {
				roll[i] = new SeaweedPortion(_seaweedSlider.getValue() / 10.0);
				i++;
			}
			if (_shrimpSlider.getValue() > 0) {
				roll[i] = new ShrimpPortion(_shrimpSlider.getValue() / 10.0);
				i++;
			}
			if (_tunaSlider.getValue() > 0) {
				roll[i] = new TunaPortion(_tunaSlider.getValue() / 10.0);
				i++;
			}

			if (!_plateColor.equals("Choose plate color...")) {

				if (_plateColor.equals("RED")) {
					makeRedPlateRequest(new Roll("Dank Roll", roll), _position);
				} else if (_plateColor.equals("BLUE")) {
					makeBluePlateRequest(new Roll("Dank Roll", roll), _position);
				} else if (_plateColor.equals("GREEN")) {
					makeGreenPlateRequest(new Roll("Dank Roll", roll), _position);
				} else if (_plateColor.equals("GOLD")) {
					makeGoldPlateRequest(new Roll("Dank Roll", roll), _position, _goldPlatePriceSlider.getValue());
				}
				break;
			}
		}
	}
}