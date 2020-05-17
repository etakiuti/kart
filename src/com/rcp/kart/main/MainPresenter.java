package com.rcp.kart.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.rcp.kart.data.Pilot;
import com.rcp.kart.data.RaceDao;
import com.rcp.kart.utils.Utils;

/**
 * 
 * This specifies the presenter for {@link MainView}.
 *
 */
public class MainPresenter implements IMainContract.Presenter {

	/**
	 * Holds the reference to the {@link MainView} that will be controlled by this
	 * presenter.
	 */
	private final IMainContract.View mView;

	private static final String COLUMNS = Utils.HOUR_COLUMN + ", " + Utils.ID_PILOT_COLUMN + ", "
			+ Utils.NAME_PILOT_COLUMN + ", " + Utils.LAP_COLUMN + ", " + Utils.TIME_COLUMN + ", " + Utils.SPEED_COLUMN;

	private final RaceDao mRaceDao;

	public MainPresenter(final IMainContract.View view) {
		Utils.Log(Utils.PRESENTER, "MainPresenter() - view: " + view);
		mView = view;
		mRaceDao = new RaceDao();
	}

	@Override
	public void hadleStandings() {
		Utils.Log(Utils.PRESENTER, "hadleStandings()");
		final List<Pilot> pilotStandingsList = mRaceDao.getRaceData(COLUMNS, Utils.LAP_COLUMN, "4", Utils.HOUR_COLUMN);
		mView.showStandingsResult(sumLapTimes(pilotStandingsList));
	}

	private List<Pilot> sumLapTimes(final List<Pilot> pilotStandingsList) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss.SSS");
		int totalTime = 0;

		for (int i = 0; i < pilotStandingsList.size(); i++) {
			final List<Pilot> pilot = mRaceDao.getRaceData(COLUMNS, Utils.ID_PILOT_COLUMN,
					String.valueOf(pilotStandingsList.get(i).getIDPilot()), Utils.TIME_COLUMN);
			for (int j = 0; j < pilot.size(); j++) {
				Date date;
				try {
					date = simpleDateFormat.parse(pilot.get(j).getTimeLap());
					totalTime += date.getTime();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			pilotStandingsList.get(i).setTotalTime(simpleDateFormat.format(totalTime));
			totalTime = 0;
		}

		return pilotStandingsList;
	}

}
