package com.rcp.kart.main;

import java.util.List;

import com.rcp.kart.data.Pilot;

/**
 * 
 * This specifies the contract between the view and the presenter for
 * {@link MainView}
 *
 */
public interface IMainContract {
	/**
	 * Interface that should be implemented by the view.
	 */
	interface View {
		
		/**
		 * Shows the standings result.
		 */
		void showStandingsResult(final List<Pilot> pilotList);
	}

	/**
	 * Interface that should be implemented by the presenter.
	 */
	interface Presenter {

		/**
		 * Method used to handle the standings.
		 */
		void hadleStandings();
	}
}
