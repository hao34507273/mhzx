/*    */ package mzm.gsp.shanggong.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShangGongVaildSession
/*    */   extends Session
/*    */ {
/*    */   private final int shanggongid;
/*    */   
/*    */   public ShangGongVaildSession(long interval, long roleid, int shanggongid)
/*    */   {
/* 15 */     super(interval, roleid);
/* 16 */     this.shanggongid = shanggongid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 22 */     StringBuilder sb = new StringBuilder();
/* 23 */     sb.append(String.format("[shanggong]ShangGongVaildSession.onTimeOut@shang gong session timeout|roleid=%d|shanggongid=%d", new Object[] { Long.valueOf(getOwerId()), Integer.valueOf(this.shanggongid) }));
/*    */     
/*    */ 
/* 26 */     ShangGongManager.logger.info(sb.toString());
/*    */   }
/*    */   
/*    */   public int getShangGongid()
/*    */   {
/* 31 */     return this.shanggongid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanggong\main\ShangGongVaildSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */