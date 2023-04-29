/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.visiblemonsterfight.event.KillGangRobberProcedure;
/*    */ import mzm.gsp.visiblemonsterfight.event.KillRobberArg;
/*    */ import mzm.gsp.visiblemonsterfight.main.VisibleMonsterFightInterface;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ public class POnKillGangRobber
/*    */   extends KillGangRobberProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     int activityId = VisibleMonsterFightInterface.getGangRobberActivityId();
/* 18 */     for (Iterator i$ = ((KillRobberArg)this.arg).roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 20 */       Procedure.execute(new PFinishActivity(roleId, activityId, 0));
/*    */     }
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnKillGangRobber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */