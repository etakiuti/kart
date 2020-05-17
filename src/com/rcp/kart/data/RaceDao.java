package com.rcp.kart.data;

import java.nio.file.FileSystems;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rcp.kart.utils.Utils;

/**
 * It queries with database and allow get items according the necessity.
 */
public class RaceDao {

	private static final String DATABASE_PATH = FileSystems.getDefault().getPath("").toAbsolutePath()
			+ "\\res\\race.db";

	private static final String TABLE = "race";

	/**
	 * Connect to the race.db database.
	 * 
	 * @return the Connection object
	 */
	private Connection connect() {
		// SQLite connection string
		final String url = "jdbc:sqlite:" + DATABASE_PATH;
		Utils.Log(Utils.DATA_LOG, "RaceDao.connect() - url: " + url);
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (final SQLException e) {
			Utils.Log(Utils.DATA_LOG, "RaceDao.connect() - " + e.getMessage());
			System.out.println(e.getMessage());
		}
		return conn;
	}

	/**
	 * Get rows according parameters.
	 * 
	 * @param columns       the columns to be taken.
	 * @param selection     the columns to be selected.
	 * @param selectionArgs get only the rows with specific content.
	 * @param order         the order that the rows are taken.
	 */
	public List<Pilot> getRaceData(final String columns, final String selection, final String selectionArgs,
			final String order) {
		Utils.Log(Utils.DATA_LOG, "getRaceData() - columns: " + columns + " | selection: " + selection
				+ " | selectionArgs: " + selectionArgs + " | order: " + order);
		String sql = "SELECT " + columns + " FROM " + TABLE + " WHERE " + selection + " = " + selectionArgs
				+ " ORDER BY " + order;
		List<Pilot> pilotList = new ArrayList<Pilot>();

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				final Pilot pilot = new Pilot();
				pilot.setHour(rs.getString(Utils.HOUR_COLUMN));
				pilot.setIDPilot(rs.getInt(Utils.ID_PILOT_COLUMN));
				pilot.setNamePilot(rs.getString(Utils.NAME_PILOT_COLUMN));
				pilot.setLap(rs.getInt(Utils.LAP_COLUMN));
				pilot.setTimeLap(rs.getString(Utils.TIME_COLUMN));
				pilot.setSpeed(rs.getString(Utils.SPEED_COLUMN));
				pilotList.add(pilot);
			}
		} catch (SQLException e) {
			Utils.Log(Utils.DATA_LOG, "RaceDao.getRaceData - " + e.getMessage());
		}

		return pilotList;
	}
}
