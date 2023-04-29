/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qingfu.SGetMonthCardActivityAwardFailed;
/*    */ import mzm.gsp.qingfu.SGetMonthCardActivityAwardSuccess;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCGetMonthCardActivityAward extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   private String userid;
/*    */   
/*    */   public PCGetMonthCardActivityAward(long roleid, int activityCfgid)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (!QingfuManager.canDoAction(this.roleid, 316))
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     this.userid = RoleInterface.getUserId(this.roleid);
/* 34 */     if (this.userid == null)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     lock(Lockeys.get(User.getTable(), this.userid));
/*    */     
/* 40 */     int result = MonthCardActivityManager.getAward(this.userid, this.roleid, this.activityCfgid);
/* 41 */     if (result != 0)
/*    */     {
/* 43 */       onFailed(result);
/*    */       
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     SGetMonthCardActivityAwardSuccess resp = new SGetMonthCardActivityAwardSuccess();
/* 49 */     resp.activity_id = this.activityCfgid;
/* 50 */     OnlineManager.getInstance().send(this.roleid, resp);
/*    */     
/* 52 */     GameServer.logger().info(String.format("[qingfu]PCGetMonthCardActivityAward.processImp@get month card activity award success|roleid=%d|userid=%s|activity_cfgid=%d|retcode=%d", new Object[] { Long.valueOf(this.roleid), this.userid, Integer.valueOf(this.activityCfgid), Integer.valueOf(result) }));
/*    */     
/*    */ 
/*    */ 
/* 56 */     return true;
/*    */   }
/*    */   
/*    */   private void onFailed(int retcode)
/*    */   {
/* 61 */     if (retcode < 0)
/*    */     {
/* 63 */       SGetMonthCardActivityAwardFailed resp = new SGetMonthCardActivityAwardFailed();
/* 64 */       resp.retcode = retcode;
/* 65 */       resp.activity_id = this.activityCfgid;
/* 66 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*    */     }
/*    */     
/* 69 */     GameServer.logger().info(String.format("[qingfu]PCGetMonthCardActivityAward.onFailed@get month card activity award failed|roleid=%d|userid=%s|activity_cfgid=%d|retcode=%d", new Object[] { Long.valueOf(this.roleid), this.userid, Integer.valueOf(this.activityCfgid), Integer.valueOf(retcode) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PCGetMonthCardActivityAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */