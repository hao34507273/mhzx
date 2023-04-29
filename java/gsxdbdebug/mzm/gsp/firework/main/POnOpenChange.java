/*    */ package mzm.gsp.firework.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity3.confbean.SFireworkCfg;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnOpenChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     for (Iterator i$ = getSwitchActivityIds().iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*    */       
/* 23 */       handEachActivity(activityId);
/*    */     }
/* 25 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private Set<Integer> getSwitchActivityIds()
/*    */   {
/* 35 */     Set<Integer> activityIds = new HashSet();
/* 36 */     for (SFireworkCfg cfg : SFireworkCfg.getAll().values())
/*    */     {
/* 38 */       if (cfg.switchId == ((OpenChangeComplexArg)this.arg).getType())
/*    */       {
/* 40 */         activityIds.add(Integer.valueOf(cfg.activityId));
/*    */       }
/*    */     }
/* 43 */     return activityIds;
/*    */   }
/*    */   
/*    */   private void handEachActivity(int activityId)
/*    */   {
/* 48 */     if (!ActivityInterface.isActivityOpen(activityId))
/*    */     {
/* 50 */       return;
/*    */     }
/* 52 */     if (((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/* 54 */       FireworkManager.initActivity(activityId, OperFireorkReason.FUN_OPEN);
/*    */     }
/*    */     else
/*    */     {
/* 58 */       FireworkManager.stopActivity(activityId, OperFireorkReason.FUN_CLOSE);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */