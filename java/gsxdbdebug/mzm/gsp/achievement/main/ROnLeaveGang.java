/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.gang.event.LeaveGangArg;
/*    */ import mzm.gsp.gang.event.LeaveGangRunnable;
/*    */ 
/*    */ public class ROnLeaveGang extends LeaveGangRunnable
/*    */ {
/*    */   public void process()
/*    */   {
/* 11 */     for (Iterator i$ = ((LeaveGangArg)this.arg).extraMemberList.iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 13 */       new mzm.gsp.util.LogicProcedure()
/*    */       {
/*    */         protected boolean processImp()
/*    */           throws Exception
/*    */         {
/* 18 */           if (((LeaveGangArg)ROnLeaveGang.this.arg).activeLeave())
/*    */           {
/*    */ 
/* 21 */             AchievementManager.updateGoalTypeState(roleId, 904, Integer.valueOf(1), "ROnLeaveGang.process@handle GANG_LEAVE success");
/*    */ 
/*    */           }
/* 24 */           else if (((LeaveGangArg)ROnLeaveGang.this.arg).isPassiveKickedOut())
/*    */           {
/*    */ 
/* 27 */             AchievementManager.updateGoalTypeState(roleId, 905, Integer.valueOf(1), "ROnLeaveGang.process@handle GANG_KICKED success");
/*    */           }
/*    */           
/* 30 */           return true;
/*    */         }
/*    */       }.call();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\ROnLeaveGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */