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
 
 struct FlagRequ{
 	1:i32 type,
 	2:i32 subType,
 	3:i32 opType,
 	4:string id,
 	5:string msg,
 	6:i32 workType
 }


struct FlagResp{
	1:i32 flag,
	2:string msg
}

service FlagService {
 	FlagResp  sendFlag(1: FlagRequ  flagRequ)
}
 
 
 
 