/*    */ package mzm.gsp.guide.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ public class GivePetSession extends Session
/*    */ {
/*    */   private final int guideid;
/*    */   private final int petcfgid;
/*    */   
/*    */   public GivePetSession(long interval, long roleId, int guideid, int petcfgid) {
/* 11 */     super(interval, roleId);
/* 12 */     this.guideid = guideid;
/* 13 */     this.petcfgid = petcfgid;
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 18 */     new PSetGuidedState(getOwerId(), this.guideid, this.petcfgid).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\main\GivePetSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */