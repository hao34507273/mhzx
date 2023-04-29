/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import xdb.Table;
/*    */ import xtable.Role2achievement;
/*    */ 
/*    */ public class AchievementModule
/*    */   implements Module, MergeModule
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 17 */     CarnivalActivityHandler handler = new CarnivalActivityHandler();
/* 18 */     ActivityInterface.registerActivityByLogicType(49, handler);
/* 19 */     ActivityInterface.registerActivityByLogicType(116, new DouDouSongLiActivityHandler());
/* 20 */     ActivityInterface.registerActivityByLogicType(117, new AchievementHandler());
/* 21 */     ActivityInterface.registerActivityByLogicType(120, new SurpriseActivityHandler());
/* 22 */     ActivityInterface.registerActivityByLogicType(123, new ActivityAchievementHandler());
/*    */     
/* 24 */     AchievementManager.init();
/* 25 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 37 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 43 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 49 */     return Arrays.asList(new Table[] { Role2achievement.getTable() });
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\AchievementModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */