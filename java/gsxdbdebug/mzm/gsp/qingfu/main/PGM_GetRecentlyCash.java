/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGM_GetRecentlyCash extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int days;
/*    */   
/*    */   public PGM_GetRecentlyCash(long roleId, int day)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.days = day;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 24 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 26 */     long recentlyCashValue = SaveAmtRecordInterface.getRecentlySaveAmt(userId, this.days);
/*    */     
/* 28 */     notifyClient(this.roleId, String.format("您最近%d天的充值金额是%d元宝", new Object[] { Integer.valueOf(this.days), Long.valueOf(recentlyCashValue) }));
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(long roleId, String str)
/*    */   {
/* 34 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 35 */     messagetip.result = Integer.MAX_VALUE;
/* 36 */     messagetip.args.add(str);
/* 37 */     OnlineManager.getInstance().sendAtOnce(roleId, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PGM_GetRecentlyCash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */