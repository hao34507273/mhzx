/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_RecallRecharge extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int num;
/*    */   
/*    */   public PGM_RecallRecharge(long gmRoleid, long roleid, int num)
/*    */   {
/* 16 */     this.gmRoleid = gmRoleid;
/* 17 */     this.roleid = roleid;
/* 18 */     this.num = num;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     if (this.num <= 0)
/*    */     {
/* 26 */       notifyClient("数量应该大于0");
/*    */     }
/*    */     
/* 29 */     String userid = RoleInterface.getUserId(this.roleid);
/* 30 */     new PTryAddRecallFriendRebate(userid, this.num).call();
/* 31 */     notifyClient("操作成功");
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 37 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 38 */     messagetip.result = Integer.MAX_VALUE;
/* 39 */     messagetip.args.add(str);
/* 40 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PGM_RecallRecharge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */