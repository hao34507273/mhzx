/*    */ package mzm.gsp.treasurehunt.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import xdb.Table;
/*    */ import xtable.Role2treasurehunt;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TreasureHuntModule
/*    */   implements Module, PostModuleInitListner, MergeModule
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 20 */     TreasureHuntActivityHandler treasureHuntActivityHandler = new TreasureHuntActivityHandler();
/*    */     
/* 22 */     ActivityInterface.registerActivityByLogicType(144, treasureHuntActivityHandler);
/* 23 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 29 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 35 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 41 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void postInit() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 53 */     return Arrays.asList(new Table[] { Role2treasurehunt.getTable() });
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\main\TreasureHuntModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */