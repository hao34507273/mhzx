/*    */ package mzm.gsp.addiction.main;
/*    */ 
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.OnlineInfo;
/*    */ 
/*    */ public class PGM_Identity extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_Identity(long gmRoleid, long roleid)
/*    */   {
/* 14 */     this.gmRoleid = gmRoleid;
/* 15 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     OnlineInfo xOnlineInfo = xtable.Role2onlineinfo.get(Long.valueOf(this.roleid));
/* 22 */     if (xOnlineInfo == null)
/*    */     {
/* 24 */       notifyClient("查询失败");
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     String result = "错误";
/* 29 */     int identity = xOnlineInfo.getIs_adult();
/* 30 */     switch (identity)
/*    */     {
/*    */     case 0: 
/* 33 */       result = "未成年人";
/* 34 */       break;
/*    */     
/*    */     case 1: 
/* 37 */       result = "成年人";
/* 38 */       break;
/*    */     
/*    */     case 2: 
/* 41 */       result = "未知身份";
/* 42 */       break;
/*    */     }
/*    */     
/*    */     
/*    */ 
/*    */ 
/* 48 */     notifyClient(result + ", 年龄:" + xOnlineInfo.getAge());
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 54 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 55 */     messagetip.result = Integer.MAX_VALUE;
/* 56 */     messagetip.args.add(str);
/* 57 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\main\PGM_Identity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */