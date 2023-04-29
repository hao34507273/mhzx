/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.GenRoamTokenFailProcedure;
/*    */ import mzm.gsp.crossserver.event.LadderGenRoamTokenFailArg;
/*    */ import mzm.gsp.crossserver.main.RoleMatchMarkingInfo;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.User;
/*    */ 
/*    */ public class GenRoamTokenFail extends GenRoamTokenFailProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     if (!(this.arg instanceof LadderGenRoamTokenFailArg)) {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     LadderGenRoamTokenFailArg argument = (LadderGenRoamTokenFailArg)this.arg;
/*    */     
/* 25 */     List<Long> roleids = new ArrayList();
/* 26 */     Map<Long, String> roleid2Useid = new HashMap();
/* 27 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : argument.getRoleMatchMarkingInfos()) {
/* 28 */       long roleid = roleMatchMarkingInfo.getRoleid();
/* 29 */       String userid = RoleInterface.getUserId(roleid);
/* 30 */       roleid2Useid.put(Long.valueOf(roleid), userid);
/* 31 */       roleids.add(Long.valueOf(roleid));
/*    */     }
/* 33 */     GameServer.logger().info(String.format("[Ladder]GenRoamTokenFail.processImp@gen token failed|roleids=%s", new Object[] { roleid2Useid.values() }));
/*    */     
/*    */ 
/* 36 */     lock(User.getTable(), roleid2Useid.values());
/* 37 */     lock(xtable.Role2properties.getTable(), roleid2Useid.keySet());
/* 38 */     LadderManager.goToCenterServerFail(roleid2Useid, 1);
/* 39 */     LadderManager.logMatch(roleids, roleid2Useid, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() - argument.getMatchStartTime(), 1, argument.getContextid(), 3);
/*    */     
/*    */ 
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\GenRoamTokenFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */