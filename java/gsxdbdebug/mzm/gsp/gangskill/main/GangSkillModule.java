/*    */ package mzm.gsp.gangskill.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ 
/*    */ public class GangSkillModule
/*    */   implements Module
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 11 */     GangSkillManager.init();
/* 12 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 18 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 30 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangskill\main\GangSkillModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */