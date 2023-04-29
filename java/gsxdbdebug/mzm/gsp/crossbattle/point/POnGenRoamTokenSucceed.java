/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.GenRoamTokenSucceedProcedure;
/*    */ import mzm.gsp.crossserver.event.PointRaceGenRoamTokenSucceedArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnGenRoamTokenSucceed extends GenRoamTokenSucceedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     if (!(this.arg instanceof PointRaceGenRoamTokenSucceedArg))
/*    */     {
/* 16 */       return false;
/*    */     }
/*    */     
/* 19 */     PointRaceGenRoamTokenSucceedArg argument = (PointRaceGenRoamTokenSucceedArg)this.arg;
/*    */     
/* 21 */     List<Long> roleids = new ArrayList();
/* 22 */     for (RolePointRaceMarkingInfo roleMatchMarkingInfo : argument.getRolePointRaceMarkingInfos())
/*    */     {
/* 24 */       long roleid = roleMatchMarkingInfo.getRoleid();
/* 25 */       roleids.add(Long.valueOf(roleid));
/*    */     }
/*    */     
/* 28 */     GameServer.logger().info(String.format("[crossbattlepoint]POnGenRoamTokenSucceed.processImp@succeed|roleids=%s", new Object[] { roleids }));
/*    */     
/*    */ 
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnGenRoamTokenSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */