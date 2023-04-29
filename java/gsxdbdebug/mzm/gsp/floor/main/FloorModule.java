/*    */ package mzm.gsp.floor.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.confirm.main.TeamConfirmInterface;
/*    */ 
/*    */ 
/*    */ public class FloorModule
/*    */   implements Module
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 16 */     ActivityInterface.registerActivityByLogicType(101, new FloorActivityInit());
/*    */     
/*    */ 
/* 19 */     for (Iterator i$ = FloorManager.getAllConfirmType().iterator(); i$.hasNext();) { int confirmType = ((Integer)i$.next()).intValue();
/*    */       
/* 21 */       TeamConfirmInterface.registerConfirmHandler(confirmType, FloorConfirmHandler.getInstance());
/*    */     }
/* 23 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int exit()
/*    */   {
/* 30 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 37 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 44 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\FloorModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */