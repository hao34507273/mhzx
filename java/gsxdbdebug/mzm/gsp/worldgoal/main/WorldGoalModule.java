/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGoalModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int cleanupForMerge()
/*    */   {
/* 19 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 25 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 31 */     WorldGoalManager.init();
/* 32 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 38 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 44 */     for (Iterator i$ = SWorldGoalCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*    */       
/* 46 */       if (WorldGoalManager.isWorldGoalSwitchOpen(activityCfgid))
/*    */       {
/*    */ 
/*    */ 
/* 50 */         new PInitActivityOnGameServerStart(activityCfgid).call(); }
/*    */     }
/* 52 */     WorldGoalManager.postInit();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\WorldGoalModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */