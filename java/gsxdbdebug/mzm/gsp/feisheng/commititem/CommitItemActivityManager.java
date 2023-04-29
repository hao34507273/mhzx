/*    */ package mzm.gsp.feisheng.commititem;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.feisheng.confbean.SFeiShengCommitItemActivityCfg;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommitItemActivityManager
/*    */ {
/*    */   public static void init()
/*    */   {
/* 21 */     ActivityInterface.registerActivityByLogicType(82, new FeiShengCommitItemActivityHandler());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isFeiShengCommitItemActivitySwitchOpenForRole(long roleid, int activityCfgid)
/*    */   {
/* 33 */     SFeiShengCommitItemActivityCfg cfg = SFeiShengCommitItemActivityCfg.get(activityCfgid);
/* 34 */     if (cfg == null)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*    */     {
/* 44 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/* 45 */       return false;
/*    */     }
/* 47 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean cutAllNeedItem(long roleid, int activityCfgid)
/*    */   {
/* 60 */     SFeiShengCommitItemActivityCfg cfg = SFeiShengCommitItemActivityCfg.get(activityCfgid);
/* 61 */     if (cfg == null)
/*    */     {
/*    */ 
/* 64 */       return false;
/*    */     }
/* 66 */     for (Map.Entry<Integer, Integer> entry : cfg.need_items.entrySet())
/*    */     {
/* 68 */       if (!ItemInterface.removeItemById(roleid, ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue(), new TLogArg(LogReason.FEI_SHENG_COMMIT_ITEM_COST_ITEM, activityCfgid)))
/*    */       {
/*    */ 
/* 71 */         return false;
/*    */       }
/*    */     }
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\commititem\CommitItemActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */