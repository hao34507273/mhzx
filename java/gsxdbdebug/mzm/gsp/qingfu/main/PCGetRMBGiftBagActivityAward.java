/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qingfu.SGetRMBGiftBagActivityAwardFailed;
/*    */ import mzm.gsp.qingfu.SGetRMBGiftBagActivityAwardSuccess;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCGetRMBGiftBagActivityAward extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   private final int tierid;
/*    */   private String userid;
/*    */   
/*    */   public PCGetRMBGiftBagActivityAward(long roleid, int activityCfgid, int tierid)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.activityCfgid = activityCfgid;
/* 24 */     this.tierid = tierid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!QingfuManager.canDoAction(this.roleid, 317))
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     this.userid = RoleInterface.getUserId(this.roleid);
/* 36 */     if (this.userid == null)
/*    */     {
/* 38 */       return false;
/*    */     }
/* 40 */     lock(Lockeys.get(User.getTable(), this.userid));
/*    */     
/* 42 */     int result = RMBGiftBagActivityManager.getAward(this.userid, this.roleid, this.activityCfgid, this.tierid);
/* 43 */     if (result != 0)
/*    */     {
/* 45 */       onFailed(result);
/*    */       
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     SGetRMBGiftBagActivityAwardSuccess resp = new SGetRMBGiftBagActivityAwardSuccess();
/* 51 */     resp.activity_cfgid = this.activityCfgid;
/* 52 */     resp.tier = this.tierid;
/* 53 */     OnlineManager.getInstance().send(this.roleid, resp);
/*    */     
/* 55 */     GameServer.logger().info(String.format("[qingfu]PCGetRMBGiftBagActivityAward.processImp@get rmb gift bag activity award success|roleid=%d|userid=%s|activity_cfgid=%d|tierid=%d|retcode=%d", new Object[] { Long.valueOf(this.roleid), this.userid, Integer.valueOf(this.activityCfgid), Integer.valueOf(this.tierid), Integer.valueOf(result) }));
/*    */     
/*    */ 
/*    */ 
/* 59 */     return true;
/*    */   }
/*    */   
/*    */   private void onFailed(int retcode)
/*    */   {
/* 64 */     if (retcode < 0)
/*    */     {
/* 66 */       SGetRMBGiftBagActivityAwardFailed resp = new SGetRMBGiftBagActivityAwardFailed();
/* 67 */       resp.retcode = retcode;
/* 68 */       resp.activity_cfgid = this.activityCfgid;
/* 69 */       resp.tier = this.tierid;
/* 70 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*    */     }
/*    */     
/* 73 */     GameServer.logger().info(String.format("[qingfu]PCGetRMBGiftBagActivityAward.onFailed@get rmb gift bag activity award failed|roleid=%d|userid=%s|activity_cfgid=%d|tierid=%d|retcode=%d", new Object[] { Long.valueOf(this.roleid), this.userid, Integer.valueOf(this.activityCfgid), Integer.valueOf(this.tierid), Integer.valueOf(retcode) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PCGetRMBGiftBagActivityAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */