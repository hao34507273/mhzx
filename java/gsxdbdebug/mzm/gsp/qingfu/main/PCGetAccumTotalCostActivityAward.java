/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qingfu.SGetAccumTotalCostActivityAwardFailed;
/*    */ import mzm.gsp.qingfu.SGetAccumTotalCostActivityAwardSuccess;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCGetAccumTotalCostActivityAward extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   private final int sortid;
/*    */   private String userid;
/*    */   
/*    */   public PCGetAccumTotalCostActivityAward(long roleid, int activityCfgid, int sortid)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.activityCfgid = activityCfgid;
/* 24 */     this.sortid = sortid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!QingfuManager.canDoAction(this.roleid, 313))
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     this.userid = RoleInterface.getUserId(this.roleid);
/* 36 */     if (this.userid == null)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     lock(Lockeys.get(User.getTable(), this.userid));
/*    */     
/* 43 */     int result = AccumTotalCostActivityManager.getAward(this.userid, this.roleid, this.activityCfgid, this.sortid);
/* 44 */     if (result != 0)
/*    */     {
/* 46 */       onFailed(result);
/*    */       
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     SGetAccumTotalCostActivityAwardSuccess resp = new SGetAccumTotalCostActivityAwardSuccess();
/* 52 */     resp.activity_cfgid = this.activityCfgid;
/* 53 */     resp.sort_id = this.sortid;
/* 54 */     OnlineManager.getInstance().send(this.roleid, resp);
/*    */     
/* 56 */     GameServer.logger().info(String.format("[qingfu]PCGetAccumTotalCostActivityAward.processImp@get accum total cost activity award success|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d|retcode=%d", new Object[] { Long.valueOf(this.roleid), this.userid, Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(result) }));
/*    */     
/*    */ 
/*    */ 
/* 60 */     return true;
/*    */   }
/*    */   
/*    */   private void onFailed(int retcode)
/*    */   {
/* 65 */     if (retcode < 0)
/*    */     {
/* 67 */       SGetAccumTotalCostActivityAwardFailed resp = new SGetAccumTotalCostActivityAwardFailed();
/* 68 */       resp.retcode = retcode;
/* 69 */       resp.activity_cfgid = this.activityCfgid;
/* 70 */       resp.sortid = this.sortid;
/* 71 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*    */     }
/*    */     
/* 74 */     GameServer.logger().info(String.format("[qingfu]PCGetAccumTotalCostActivityAward.onFailed@get accum total cost award failed|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d|retcode=%d", new Object[] { Long.valueOf(this.roleid), this.userid, Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(retcode) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PCGetAccumTotalCostActivityAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */