/*    */ package mzm.gsp.countdown.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.countdown.confbean.MailInfo;
/*    */ import mzm.gsp.countdown.confbean.SCountDownCfg;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PInitOnGameServerStart
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int cfgid;
/*    */   
/*    */   public PInitOnGameServerStart(int cfgid)
/*    */   {
/* 19 */     this.cfgid = cfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     SCountDownCfg cfg = SCountDownCfg.get(this.cfgid);
/* 26 */     long nowInSecond = DateTimeUtils.getCurrTimeInMillis() / 1000L;
/*    */     
/* 28 */     for (Map.Entry<Integer, MailInfo> entry : cfg.remind_mail_infos.entrySet())
/*    */     {
/* 30 */       long interval = ((MailInfo)entry.getValue()).send_mail_timestamp - nowInSecond;
/* 31 */       if (interval >= 0L)
/*    */       {
/* 33 */         new SendRemindMailSession(interval, 0L, this.cfgid, ((Integer)entry.getKey()).intValue());
/*    */       }
/*    */     }
/*    */     
/* 37 */     for (Map.Entry<Integer, MailInfo> entry : cfg.thank_mail_infos.entrySet())
/*    */     {
/* 39 */       long interval = ((MailInfo)entry.getValue()).send_mail_timestamp - nowInSecond;
/* 40 */       if (interval >= 0L)
/*    */       {
/* 42 */         new SendThankMailSession(interval, 0L, this.cfgid, ((Integer)entry.getKey()).intValue());
/*    */       }
/*    */     }
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\countdown\main\PInitOnGameServerStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */