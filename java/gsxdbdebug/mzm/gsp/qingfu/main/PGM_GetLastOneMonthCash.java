/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGM_GetLastOneMonthCash extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_GetLastOneMonthCash(long roleId)
/*    */   {
/* 15 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 22 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 24 */     long recentlyCashValue = SaveAmtRecordInterface.getLastOneMonthSaveAmt(userId);
/*    */     
/* 26 */     notifyClient(this.roleId, String.format("您最近一个月的充值金额是%d元宝", new Object[] { Long.valueOf(recentlyCashValue) }));
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(long roleId, String str)
/*    */   {
/* 32 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 33 */     messagetip.result = Integer.MAX_VALUE;
/* 34 */     messagetip.args.add(str);
/* 35 */     OnlineManager.getInstance().sendAtOnce(roleId, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PGM_GetLastOneMonthCash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */