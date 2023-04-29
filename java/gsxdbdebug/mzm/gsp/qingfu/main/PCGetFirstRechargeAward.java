/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qingfu.SGetFirstRechargeAwardResp;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCGetFirstRechargeAward extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private String userid;
/*    */   
/*    */   public PCGetFirstRechargeAward(long roleId)
/*    */   {
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (!QingfuManager.canDoAction(this.roleId, 314))
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     this.userid = RoleInterface.getUserId(this.roleId);
/* 31 */     if (this.userid == null)
/*    */     {
/* 33 */       return false;
/*    */     }
/* 35 */     lock(Lockeys.get(User.getTable(), this.userid));
/*    */     
/* 37 */     int result = FirstRechargeManager.getAward(this.userid, this.roleId);
/* 38 */     if (result != 0)
/*    */     {
/* 40 */       onFailed(result);
/*    */       
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     SGetFirstRechargeAwardResp resp = new SGetFirstRechargeAwardResp();
/* 46 */     resp.retcode = 0;
/* 47 */     OnlineManager.getInstance().send(this.roleId, resp);
/*    */     
/* 49 */     GameServer.logger().info(String.format("[qingfu]PCGetFirstRechargeAward.processImp@get first recharge award success|roleid=%d|userid=%s|retcode=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(0) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 55 */     new POnGetFirstRechargeAward(this.userid, this.roleId).execute();
/*    */     
/* 57 */     return true;
/*    */   }
/*    */   
/*    */   private void onFailed(int retcode)
/*    */   {
/* 62 */     if (retcode < 0)
/*    */     {
/* 64 */       SGetFirstRechargeAwardResp resp = new SGetFirstRechargeAwardResp();
/* 65 */       resp.retcode = retcode;
/* 66 */       OnlineManager.getInstance().sendAtOnce(this.roleId, resp);
/*    */     }
/*    */     
/* 69 */     GameServer.logger().info(String.format("[qingfu]PCGetFirstRechargeAward.onFailed@get first recharge award failed|roleid=%d|userid=%s|retcode=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(retcode) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PCGetFirstRechargeAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */