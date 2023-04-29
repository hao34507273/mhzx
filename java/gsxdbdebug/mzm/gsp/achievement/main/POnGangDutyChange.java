/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.gang.event.DutyChangeProcedure;
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ 
/*    */ public class POnGangDutyChange extends DutyChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 12 */     for (Iterator i$ = ((GangArg)this.arg).extraMemberList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/*    */ 
/* 15 */       int duty = GangInterface.getGangDuty(roleId);
/*    */       
/* 17 */       AchievementManager.updateGoalTypeState(roleId, 903, Integer.valueOf(duty), "POnGangDutyChange.processImp@handle GANG_DUTY success");
/*    */     }
/*    */     
/*    */ 
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnGangDutyChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */