/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.visiblemonsterfight.event.KillLuanShiYaoMoArg;
/*    */ import mzm.gsp.visiblemonsterfight.main.VisibleMonsterFightInterface;
/*    */ 
/*    */ public class POnKillLuanShiYaoMo extends mzm.gsp.visiblemonsterfight.event.KillLuanShiYaoMoProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     int activityId = VisibleMonsterFightInterface.getLuanShiYaoMoActivityId();
/* 12 */     String logStr = "POnKillLuanShiYaoMo.processImp@handle ACTIVITY_JOIN finish";
/*    */     
/* 14 */     for (Iterator i$ = ((KillLuanShiYaoMoArg)this.arg).roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 16 */       xdb.Procedure.execute(new PUpdateGoalTypeState(roleId, 2400, Integer.valueOf(activityId), "POnKillLuanShiYaoMo.processImp@handle ACTIVITY_JOIN finish"));
/*    */     }
/*    */     
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnKillLuanShiYaoMo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */