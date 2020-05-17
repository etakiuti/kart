package com.rcp.kart.main;

import java.util.List;

import com.rcp.kart.data.Pilot;
import com.rcp.kart.utils.Utils;

public final class MainView implements IMainContract.View {

	/**
	 * Holds the reference to the {@link MainPresenter} that will be control by
	 * view.
	 */
	private final IMainContract.Presenter mPresenter;

	/**
	 * Main method.
	 * 
	 * @param args the arguments to be initialized.
	 */
	public static void main(final String[] args) {
		Utils.Log(Utils.VIEW, "main()");
		new MainView();
	}

	public MainView() {
		mPresenter = new MainPresenter(this);
		init();
	}

	private void init() {
		Utils.Log(Utils.VIEW, "init()");
		mPresenter.hadleStandings();
	}

	@Override
	public void showStandingsResult(final List<Pilot> pilotList) {
		Utils.Log(Utils.VIEW, "showStandingsResult() - pilotList: " + pilotList);
		int position;
		System.out.println("POS" + "\t" + "CODE" + "\t" + "NAME" + "\t" + "LAP" + "\t" + "TIME");
		for (int j = 0; j < pilotList.size(); j++) {
			position = (j + 1);
			System.out.println(position + "\t" + pilotList.get(j).getIDPilot() + "\t" + pilotList.get(j).getNamePilot()
					+ "\t" + pilotList.get(j).getLap() + "\t" + pilotList.get(j).getTotalTime());
		}
	}
}
