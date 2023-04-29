/*    */ package mzm.gsp.signaward.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.OnlineAward;
/*    */ 
/*    */ public class POpenOnlineAward extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public POpenOnlineAward(long roleid)
/*    */   {
/* 14 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     OnlineAward xOnlineAward = xtable.Role2onlineaward.get(Long.valueOf(this.roleid));
/* 23 */     if (xOnlineAward == null)
/*    */     {
/* 25 */       String logstr = String.format("[onlineaward]POpenOnlineAward.processImp@xOnlineAward null,should not run to here|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/*    */ 
/* 28 */       SignAwardManager.logger.error(logstr);
/* 29 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 34 */     long lastupdate = OnlineTimeObserver.getLastupdatetime();
/* 35 */     int delta = 0;
/* 36 */     if (lastupdate != 0L)
/*    */     {
/* 38 */       delta = (int)TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis() - lastupdate);
/* 39 */       if (delta < 0)
/*    */       {
/* 41 */         delta = 0;
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 46 */       delta = (int)TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis() - xOnlineAward.getLogintime());
/*    */     }
/*    */     
/* 49 */     int time = (int)(xOnlineAward.getOnlinetime() + delta);
/* 50 */     SignAwardManager.sendSSynOnlineTimeRes(this.roleid, time);
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\POpenOnlineAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */