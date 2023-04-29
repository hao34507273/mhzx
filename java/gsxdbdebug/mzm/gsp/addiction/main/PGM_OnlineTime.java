/*    */ package mzm.gsp.addiction.main;
/*    */ 
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.OnlineInfo;
/*    */ 
/*    */ public class PGM_OnlineTime extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_OnlineTime(long gmRoleid, long roleid)
/*    */   {
/* 14 */     this.gmRoleid = gmRoleid;
/* 15 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     AddictionCfgInfo cfgInfo = AddictionManager.getConfig();
/* 22 */     if (cfgInfo != null)
/*    */     {
/* 24 */       notifyClient(cfgInfo.toString());
/*    */     }
/*    */     
/* 27 */     OnlineInfo xOnlineInfo = xtable.Role2onlineinfo.get(Long.valueOf(this.roleid));
/* 28 */     if (xOnlineInfo == null)
/*    */     {
/* 30 */       notifyClient("查询失败");
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     notifyClient(String.format("当前在线时间为%d,总在线时间为%d", new Object[] { Integer.valueOf(xOnlineInfo.getSingle_online()), Integer.valueOf(xOnlineInfo.getAccumu_time()) }));
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 40 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 41 */     messagetip.result = Integer.MAX_VALUE;
/* 42 */     messagetip.args.add(str);
/* 43 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\main\PGM_OnlineTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */