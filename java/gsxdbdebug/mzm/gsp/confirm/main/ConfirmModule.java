/*    */ package mzm.gsp.confirm.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConfirmModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 14 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int exit()
/*    */   {
/* 21 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 28 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 34 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\confirm\main\ConfirmModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */