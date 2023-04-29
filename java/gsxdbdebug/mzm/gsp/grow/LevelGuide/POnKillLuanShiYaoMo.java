/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.visiblemonsterfight.event.KillLuanShiYaoMoArg;
/*    */ import mzm.gsp.visiblemonsterfight.event.KillLuanShiYaoMoProcedure;
/*    */ import mzm.gsp.visiblemonsterfight.main.VisibleMonsterFightInterface;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ public class POnKillLuanShiYaoMo
/*    */   extends KillLuanShiYaoMoProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     int activityId = VisibleMonsterFightInterface.getLuanShiYaoMoActivityId();
/* 18 */     for (Iterator i$ = ((KillLuanShiYaoMoArg)this.arg).roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 20 */       Procedure.execute(new PFinishActivity(roleId, activityId, 1));
/*    */     }
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnKillLuanShiYaoMo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */