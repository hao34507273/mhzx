/*    */ package mzm.gsp.homeland.mysteryvisitor;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MysteryVisitorModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int cleanupForMerge()
/*    */   {
/* 18 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 30 */     MysteryVisitorManager.init();
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 37 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\mysteryvisitor\MysteryVisitorModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */