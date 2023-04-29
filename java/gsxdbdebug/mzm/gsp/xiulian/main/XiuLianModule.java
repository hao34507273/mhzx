/*    */ package mzm.gsp.xiulian.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XiuLianModule
/*    */   implements Module
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 14 */     XiuLianSkillManager.init();
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiulian\main\XiuLianModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */