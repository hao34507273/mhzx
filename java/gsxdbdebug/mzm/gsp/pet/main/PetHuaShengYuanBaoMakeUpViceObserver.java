/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.timer.main.DateObserver.MyDate;
/*    */ 
/*    */ public class PetHuaShengYuanBaoMakeUpViceObserver extends DateObserver
/*    */ {
/*    */   public PetHuaShengYuanBaoMakeUpViceObserver(DateObserver.MyDate myDate)
/*    */   {
/* 10 */     super(myDate);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 16 */     new PPetHuaShengYuanBaoMakeUpViceGetSkillsAndPrice().execute();
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetHuaShengYuanBaoMakeUpViceObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */