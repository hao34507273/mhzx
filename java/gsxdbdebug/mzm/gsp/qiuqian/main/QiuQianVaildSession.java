/*    */ package mzm.gsp.qiuqian.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QiuQianVaildSession
/*    */   extends Session
/*    */ {
/*    */   private final int qiuqianid;
/*    */   
/*    */   public QiuQianVaildSession(long interval, long roleid, int qiuqianid)
/*    */   {
/* 15 */     super(interval, roleid);
/* 16 */     this.qiuqianid = qiuqianid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 22 */     StringBuilder sb = new StringBuilder();
/* 23 */     sb.append(String.format("[qiuqian]QiuQianVaildSession.onTimeOut@qiu qian session timeout|roleid=%d|qiuqianid=%d", new Object[] { Long.valueOf(getOwerId()), Integer.valueOf(this.qiuqianid) }));
/*    */     
/* 25 */     QiuQianManager.logger.info(sb.toString());
/*    */   }
/*    */   
/*    */   public int getQiuQianid()
/*    */   {
/* 30 */     return this.qiuqianid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qiuqian\main\QiuQianVaildSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */