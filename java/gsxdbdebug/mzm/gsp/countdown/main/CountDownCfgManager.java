/*    */ package mzm.gsp.countdown.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.countdown.confbean.MailInfo;
/*    */ import mzm.gsp.countdown.confbean.SCountDownCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CountDownCfgManager
/*    */ {
/*    */   public static Set<Integer> getCanReceiveRemindMailIndices(int cfgid, long nowInSecond)
/*    */   {
/* 27 */     Set<Integer> indices = new HashSet();
/* 28 */     SCountDownCfg cfg = SCountDownCfg.get(cfgid);
/* 29 */     if (cfg != null)
/*    */     {
/* 31 */       for (Map.Entry<Integer, MailInfo> entry : cfg.remind_mail_infos.entrySet())
/*    */       {
/* 33 */         if ((nowInSecond >= ((MailInfo)entry.getValue()).send_mail_timestamp) && (nowInSecond <= cfg.festival_timestamp))
/*    */         {
/* 35 */           indices.add(entry.getKey());
/*    */         }
/*    */       }
/*    */     }
/* 39 */     return indices;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static Set<Integer> getCanReceiveThankMailIndices(int cfgid, long nowInSecond)
/*    */   {
/* 51 */     Set<Integer> indices = new HashSet();
/* 52 */     SCountDownCfg cfg = SCountDownCfg.get(cfgid);
/* 53 */     if (cfg != null)
/*    */     {
/* 55 */       for (Map.Entry<Integer, MailInfo> entry : cfg.thank_mail_infos.entrySet())
/*    */       {
/* 57 */         if ((nowInSecond >= ((MailInfo)entry.getValue()).send_mail_timestamp) && (nowInSecond <= cfg.festival_timestamp + cfg.thank_mail_valid_time))
/*    */         {
/*    */ 
/* 60 */           indices.add(entry.getKey());
/*    */         }
/*    */       }
/*    */     }
/* 64 */     return indices;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\countdown\main\CountDownCfgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */