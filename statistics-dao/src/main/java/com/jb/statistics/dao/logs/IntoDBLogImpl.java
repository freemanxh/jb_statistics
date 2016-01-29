package com.jb.statistics.dao.logs;

import com.jb.statistics.rpc.thrift.LogsRequ;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class IntoDBLogImpl extends AbstIntoDB {

	protected abstract String getTableName();

	protected String getSql() {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into ");
		sb.append(getTableName());
		sb.append(" (userId_, type_, subType_, remark_, createTime_, version_,channel_,mobilePhone_,projectId_,sub2Type_,sub3Type_,moreInfo_,os_,os_version_,device_)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		return sb.toString();
	}

	@Override
	protected void setPstmt(PreparedStatement pstmt, Object obj) throws SQLException {
		// userId_, type_, subType_, remark_, createTime_,
		// version_,channel_,mobilePhone_,projectId_,sub2Type_,sub3Type_,moreInfo_,os_,os_version_,device_)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
		// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
		LogsRequ logsRequ = (LogsRequ) obj;
		if (null != logsRequ) {
			pstmt.setString(1, logsRequ.getId());
			pstmt.setInt(2, logsRequ.getType());
			pstmt.setInt(3, logsRequ.getSubType());
			pstmt.setString(4, logsRequ.getRemarks());
			pstmt.setLong(5, logsRequ.getCreateTime());
			pstmt.setString(6, logsRequ.getVersion());
			pstmt.setString(7, logsRequ.getChannel());
			pstmt.setString(8, logsRequ.getMobilePhone());
			pstmt.setString(9, logsRequ.getProjectId());
			pstmt.setInt(10, logsRequ.getSub2Type());
			pstmt.setInt(11, logsRequ.getSub3Type());
			pstmt.setString(12, logsRequ.getMoreInfo());
			pstmt.setInt(13, logsRequ.getOs());
			pstmt.setString(14, logsRequ.getOsVersion());
			pstmt.setString(15, logsRequ.getDevice());

			// pstmt.addBatch();
		}
	}

}
