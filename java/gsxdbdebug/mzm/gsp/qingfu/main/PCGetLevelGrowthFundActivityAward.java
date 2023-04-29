/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qingfu.SGetLevelGrowthFundActivityAwardFailed;
/*    */ import mzm.gsp.qingfu.SGetLevelGrowthFundActivityAwardSuccess;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCGetLevelGrowthFundActivityAward extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   private final int sortid;
/*    */   private String userid;
/*    */   
/*    */   public PCGetLevelGrowthFundActivityAward(long roleid, int activityCfgid, int sortid)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.activityCfgid = activityCfgid;
/* 24 */     this.sortid = sortid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!QingfuManager.canDoAction(this.roleid, 315))
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
/* 42 */     int result = LevelGrowthFundActivityManager.getAward(this.userid, this.roleid, this.activityCfgid, this.sortid);
/* 43 */     if (result != 0)
/*    */     {
/* 45 */       onFailed(result);
/*    */       
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     SGetLevelGrowthFundActivityAwardSuccess resp = new SGetLevelGrowthFundActivityAwardSuccess();
/* 51 */     resp.activity_id = this.activityCfgid;
/* 52 */     resp.sortid = this.sortid;
/* 53 */     OnlineManager.getInstance().send(this.roleid, resp);
/*    */     
/* 55 */     GameServer.logger().info(String.format("[qingfu]PCGetLevelGrowthFundActivityAward.processImp@get level growth fund activity award success|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d|retcode=%d", new Object[] { Long.valueOf(this.roleid), this.userid, Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(result) }));
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
/* 66 */       SGetLevelGrowthFundActivityAwardFailed resp = new SGetLevelGrowthFundActivityAwardFailed();
/* 67 */       resp.retcode = retcode;
/* 68 */       resp.activity_id = this.activityCfgid;
/* 69 */       resp.sortid = this.sortid;
/* 70 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*    */     }
/*    */     
/* 73 */     GameServer.logger().info(String.format("[qingfu]PCGetLevelGrowthFundActivityAward.onFailed@get level growth fund activity award failed|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d|retcode=%d", new Object[] { Long.valueOf(this.roleid), this.userid, Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(retcode) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PCGetLevelGrowthFundActivityAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */