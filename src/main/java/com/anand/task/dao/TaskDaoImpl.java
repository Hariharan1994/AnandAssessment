package com.anand.task.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.anand.task.constants.TableCons;
import com.anand.task.entity.EmployeeInfo;
import com.anand.task.entity.TaskCustomException;
import com.anand.task.log.ConsoleLog;

/**
 * TaskDaoImpl is a DAO implementation class for handling DB
 * 
 * @author ANAND MUTHUKUMAR
 * @since 23-01-2021
 */
@Repository
public class TaskDaoImpl implements TaskDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<EmployeeInfo> getAllEmployee() {
		try {
			String selectQuery = TableCons.SELECT_QUERY;
			return jdbcTemplate.query(selectQuery, new EmployeeInfoMapper());
		} catch (Exception e) {
			ConsoleLog.printErrorMessage("getAllEmployee Error : " + e.getMessage());
			throw new TaskCustomException("DB Connection Error");
		}
	}

	public EmployeeInfo getEmployee(final int empId) {
		String selectQuery = TableCons.EMP_SEL_QUERY;
		PreparedStatementSetter pss = new PreparedStatementSetter() {
//			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, empId);
			}
		};

		List<EmployeeInfo> employeeInfoList = jdbcTemplate.query(selectQuery, pss, new EmployeeInfoMapper());
		if (employeeInfoList.size() > 0) {
			return employeeInfoList.get(0);
		} else {
			ConsoleLog.printErrorMessage("There is no data found for the employee (" + empId + ")");
			throw new TaskCustomException("Data not found for " + empId);
		}
	}

	public String createEmployee(EmployeeInfo employeeInfo) {
		String insertQuery = TableCons.INSERT_QUERY;
		try {
			executeUpdateQuery(true, insertQuery, employeeInfo);
			return "Employee details created successfully.";
		} catch (Exception e) {
			ConsoleLog.printErrorMessage("createEmployee Error : " + e.getMessage());
			throw new TaskCustomException("UNABLE TO INSERT NEW EMPLOYEE");
		}
	}

	public String updateEmployee(EmployeeInfo employeeInfo) {
		String updateQuery = TableCons.UPDATE_QUERY;
		try {
			executeUpdateQuery(false, updateQuery, employeeInfo);
			return "Employee details updated successfully.";
		} catch (Exception e) {
			ConsoleLog.printErrorMessage("updateEmployee Error : " + e.getMessage());
			throw new TaskCustomException("UNABLE TO EXECUTE UPDATE EMPLOYEE");
		}
	}

	private void executeUpdateQuery(final boolean isCreate, String updateQuery, final EmployeeInfo employeeInfo) {

		try {
			PreparedStatementSetter pss = new PreparedStatementSetter() {
//				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					int i = 0;
					if (isCreate) {
						ps.setInt(i++, employeeInfo.getId());
					}
					ps.setString(i++, employeeInfo.getFirstName());
					ps.setString(i++, employeeInfo.getLastName());
					ps.setString(i++, employeeInfo.getEmailId());
					ps.setInt(i++, employeeInfo.getAge());
					ps.setString(i++, employeeInfo.getGender());
					ps.setString(i++, employeeInfo.getAddress());
					if (!isCreate) {
						ps.setInt(i++, employeeInfo.getId());
					}
				}
			};

			int i = jdbcTemplate.update(updateQuery, pss);
			if (i != 1) { // WHEN PRIMARY KEY NOT FOUND WHILE UPDATING
				throw new Exception("");
			}
		} catch (Exception e) {
			throw new TaskCustomException("UNABLE TO EXECUTE QUERY");
		}
	}

	public String deleteEmployee(final int empId) {
		String deleteQuery = TableCons.DELETE_QUERY;
		try {
			PreparedStatementSetter pss = new PreparedStatementSetter() {
//				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, empId);
				}
			};

			int i = jdbcTemplate.update(deleteQuery, pss);
			if (i != 1) { // WHEN PRIMARY KEY NOT FOUND WHILE UPDATING
				throw new Exception("");
			}
			return "Employee details deleted successfully.";
		} catch (Exception e) {
			ConsoleLog.printErrorMessage("deleteEmployee Error : " + e.getMessage());
			throw new TaskCustomException("UNABLE TO EXECUTE UPDATE EMPLOYEE");
		}
	}

}

class EmployeeInfoMapper implements RowMapper<EmployeeInfo> {
	public EmployeeInfo mapRow(ResultSet rs, int arg1) {
		EmployeeInfo employeeInfo = new EmployeeInfo();
		try {
			employeeInfo.setId(Integer.parseInt(Objects.toString(rs.getString(TableCons.COL_1_ID), "")));
			employeeInfo.setFirstName(Objects.toString(rs.getString(TableCons.COL_2_FIRST_NAME), ""));
			employeeInfo.setLastName(Objects.toString(rs.getString(TableCons.COL_3_LAST_NAME), ""));
			employeeInfo.setEmailId(Objects.toString(rs.getString(TableCons.COL_4_EMAIL_ID), ""));
			employeeInfo.setAge(Integer.parseInt(Objects.toString(rs.getString(TableCons.COL_5_AGE), "")));
			employeeInfo.setGender(Objects.toString(rs.getString(TableCons.COL_6_GENDER), ""));
			employeeInfo.setAddress(Objects.toString(rs.getString(TableCons.COL_7_ADDRESS), ""));
		} catch (Exception e) {
			ConsoleLog.printErrorMessage("Table Data Read Error..." + e.getMessage());
		}
		return employeeInfo;
	}
}