/*    */ package mzm.gsp.cookiecake.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ 
/*    */ 
/*    */ public class CookieCakeModule
/*    */   implements Module
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 13 */     ActivityInterface.registerActivityByLogicType(128, new CookieCakeActivityHandler(), false);
/*    */     
/* 15 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 21 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 27 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 33 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cookiecake\main\CookieCakeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */