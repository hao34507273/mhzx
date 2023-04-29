/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.singlebattle.antiafk.AntiAFKInterface;
/*    */ import mzm.gsp.singlebattle.buff.SingleBattleBuffInterface;
/*    */ import mzm.gsp.singlebattle.gather.GatherPlayTypeHandler;
/*    */ import mzm.gsp.singlebattle.grab.GrabPlayTypeHandler;
/*    */ import mzm.gsp.singlebattle.resourcepoint.ResourcePointInterface;
/*    */ import mzm.gsp.singlebattle.task.BattleTaskPlayHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SingleBattleModule
/*    */   implements Module
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 26 */     SingleBattleInterface.registerPlayHandler(1, new GrabPlayTypeHandler());
/* 27 */     ResourcePointInterface.init();
/* 28 */     SingleBattleInterface.registerPlayHandler(4, new GatherPlayTypeHandler());
/* 29 */     SingleBattleBuffInterface.init();
/* 30 */     SingleBattleInterface.registerPlayHandler(2, new BattleTaskPlayHandler());
/* 31 */     AntiAFKInterface.init();
/* 32 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 38 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 44 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 50 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\SingleBattleModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */