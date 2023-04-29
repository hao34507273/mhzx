/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.timer.main.DateObserver.MyDate;
/*    */ 
/*    */ public class FriendModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 13 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 18 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 23 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 28 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 34 */     DateObserver.MyDate myDate = new DateObserver.MyDate(-1, -1, -1, 0);
/* 35 */     new FriendDayObserver(myDate);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\FriendModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */