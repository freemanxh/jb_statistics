/**
 * The first thing to know about are types. The available types in Thrift are:
 *
 *  bool        Boolean, one byte
 *  byte        Signed byte
 *  i16         Signed 16-bit integer
 *  i32         Signed 32-bit integer
 *  i64         Signed 64-bit integer
 *  double      64-bit floating point value
 *  string      String
 *  binary      Blob (byte array)
 *  map<t1,t2>  Map from one type to another
 *  list<t1>    Ordered list of one type
 *  set<t1>     Set of unique elements of one type
 *
 * Did you also notice that Thrift supports C style comments?
 */

// Just in case you were wondering... yes. We support simple C comments too.

//include "shared.thrift"

 namespace java com.jb.statistics.rpc.thrift
 
 struct LogsRequ{
	1:string id,
	2:i32 type,
	3:i32 subType,
	4:i64 createTime,
	5:string version,
	6:string channel,
	7:string remarks,
	8:i32 sub2Type,
	9:i32 sub3Type,
	10:string mobilePhone,
	11:string projectId,
	12:string moreInfo,
	13:i32 os,
	14:string osVersion,
	15:string device
}

struct LogsResp{
	1:i32 code,
	2:string msg
}


service LogsService{
	LogsResp logByThrift(1:LogsRequ logsRequ)
}

/*
    public OperateResult logByThrift(ClockLog clockLog) throws org.apache.thrift.TException;

    public OperateResult clockCallFlowByThrift(ClockCallFlow clockCallFlow) throws org.apache.thrift.TException;

    public OperateResult clockUserModifyFlowByThrift(ClockUserModifyFlow clockUserModifyFlow) throws org.apache.thrift.TException;

    public OperateResult clockMsgConfirmByThrift(ClockMsgConfirm clockMsgConfirm) throws org.apache.thrift.TException;

*/

 
 
 