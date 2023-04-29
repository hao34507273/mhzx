/*    */ package mzm.gsp.yzdd.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.yzdd.confbean.YzddConsts;
/*    */ 
/*    */ public class YzddModule implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> map)
/*    */   {
/* 13 */     ActivityInterface.registerActivityByLogicType(YzddConsts.getInstance().LogicType, new YzddActivityHandler());
/* 14 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 19 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> map, int i)
/*    */   {
/* 29 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\yzdd\main\YzddModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */