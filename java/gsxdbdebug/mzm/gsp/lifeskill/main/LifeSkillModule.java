/*    */ package mzm.gsp.lifeskill.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LifeSkillModule
/*    */   implements Module
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 14 */     LifeSkillManager.init();
/* 15 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 20 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 25 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 30 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\main\LifeSkillModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */