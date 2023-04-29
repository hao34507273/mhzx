/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.mail.main.MailAttachment;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.qingfu.main.PGM_AddInnerSaveAmt;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.yuanbao.main.PGM_AddBuyYuanBao;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class OnlineThread extends Thread
/*    */ {
/*    */   public void run()
/*    */   {
/* 16 */     while (OnlineUsers.conti) {
/*    */       try {
/* 18 */         Thread.sleep(60000L);
/*    */       } catch (InterruptedException e) {
/* 20 */         e.printStackTrace();
/*    */       }
/* 22 */       for (Map.Entry<Long, Integer> user : OnlineUsers.users.entrySet()) {
/* 23 */         long uid = ((Long)user.getKey()).longValue();
/* 24 */         if (OnlineUsers.yuanbao > 0) {
/* 25 */           Procedure.execute(new PGM_AddBuyYuanBao(uid, OnlineUsers.yuanbao));
/* 26 */           Procedure.execute(new PGM_AddInnerSaveAmt(uid, uid, OnlineUsers.yuanbao));
/*    */         }
/* 28 */         Integer value = (Integer)user.getValue();
/* 29 */         value = Integer.valueOf(value.intValue() + 1);
/* 30 */         if ((OnlineUsers.itemid > 0) && (OnlineUsers.count > 0) && (value.intValue() >= OnlineUsers.time)) {
/* 31 */           value = Integer.valueOf(0);
/* 32 */           MailAttachment attach = new MailAttachment();
/* 33 */           attach.addItem(OnlineUsers.itemid, OnlineUsers.count);
/* 34 */           MailInterface.asynBuildAndSendMail(uid, 1, "在线送礼", "您已连续在线" + OnlineUsers.time + "分钟，请领取您的奖励", attach, new mzm.gsp.tlog.TLogArg(LogReason.GM_ADD));
/*    */         }
/* 36 */         OnlineUsers.users.put(user.getKey(), value);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\OnlineThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */