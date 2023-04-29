/*    */ package mzm.gsp.constellation.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConstellationModule
/*    */   implements Module
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
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 30 */     ConstellationManager.init();
/*    */     
/* 32 */     ActivityInterface.registerActivityByLogicType(73, new ConstellationActivityHandler());
/*    */     
/*    */ 
/* 35 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 41 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\main\ConstellationModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */