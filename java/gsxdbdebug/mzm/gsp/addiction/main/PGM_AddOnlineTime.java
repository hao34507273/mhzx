/*    */ package mzm.gsp.addiction.main;
/*    */ 
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.OnlineInfo;
/*    */ 
/*    */ public class PGM_AddOnlineTime extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int onlineTime;
/*    */   
/*    */   public PGM_AddOnlineTime(long gmRoleid, long roleid, int onlineTime)
/*    */   {
/* 15 */     this.gmRoleid = gmRoleid;
/* 16 */     this.roleid = roleid;
/* 17 */     this.onlineTime = onlineTime;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     OnlineInfo xOnlineInfo = xtable.Role2onlineinfo.get(Long.valueOf(this.roleid));
/* 24 */     if (xOnlineInfo == null)
/*    */     {
/* 26 */       notifyClient("操作失败");
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     xOnlineInfo.setSingle_online(xOnlineInfo.getSingle_online() + this.onlineTime);
/*    */     
/* 32 */     notifyClient(String.format("操作成功,当前在线时间为%d,总在线时间为%d", new Object[] { Integer.valueOf(xOnlineInfo.getSingle_online()), Integer.valueOf(xOnlineInfo.getAccumu_time()) }));
/*    */     
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 39 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 40 */     messagetip.result = Integer.MAX_VALUE;
/* 41 */     messagetip.args.add(str);
/* 42 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\main\PGM_AddOnlineTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */