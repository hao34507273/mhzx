/*    */ package mzm.gsp.magicmark.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MagicMarkOutOfDateSession
/*    */   extends Session
/*    */ {
/*    */   private final long expireTime;
/*    */   private final int magicMarkType;
/*    */   
/*    */   public MagicMarkOutOfDateSession(long interval, long roleId, int magicMarkType, long expireTime)
/*    */   {
/* 20 */     super(interval, roleId);
/* 21 */     this.expireTime = expireTime;
/* 22 */     this.magicMarkType = magicMarkType;
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 27 */     new PMagicMarkOutOfDate(getOwerId(), this.magicMarkType, this.expireTime).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\main\MagicMarkOutOfDateSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */