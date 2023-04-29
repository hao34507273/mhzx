/*    */ package mzm.gsp.shanghui.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.pet.main.PetHuaShengYuanBaoMakeUpViceManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShanghuiModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 16 */     ShanghuiManager.init();
/* 17 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 22 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 27 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 32 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit()
/*    */   {
/* 37 */     ShanghuiManager.postInit();
/* 38 */     PetHuaShengYuanBaoMakeUpViceManager.postInit();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\ShanghuiModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */