/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qingfu.SGetSaveAmtActivityAwardFailed;
/*    */ import mzm.gsp.qingfu.SGetSaveAmtActivityAwardSuccess;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCGetSaveAmtActivityAward extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   private final int sortid;
/*    */   private String userid;
/*    */   
/*    */   public PCGetSaveAmtActivityAward(long roleid, int activityCfgid, int sortid)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.activityCfgid = activityCfgid;
/* 24 */     this.sortid = sortid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!QingfuManager.canDoAction(this.roleid, 318))
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
/* 42 */     int result = SaveAmtActivityManager.getAward(this.userid, this.roleid, this.activityCfgid, this.sortid);
/* 43 */     if (result != 0)
/*    */     {
/* 45 */       onFailed(result);
/*    */       
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     SGetSaveAmtActivityAwardSuccess resp = new SGetSaveAmtActivityAwardSuccess();
/* 51 */     resp.activity_id = this.activityCfgid;
/* 52 */     resp.sort_id = this.sortid;
/* 53 */     OnlineManager.getInstance().send(this.roleid, resp);
/*    */     
/* 55 */     GameServer.logger().info(String.format("[qingfu]PCGetSaveAmtActivityAward.processImp@get save amt activity award success|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d|retcode=%d", new Object[] { Long.valueOf(this.roleid), this.userid, Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(result) }));
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
/* 66 */       SGetSaveAmtActivityAwardFailed resp = new SGetSaveAmtActivityAwardFailed();
/* 67 */       resp.retcode = retcode;
/* 68 */       resp.activity_id = this.activityCfgid;
/* 69 */       resp.sortid = this.sortid;
/* 70 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*    */     }
/*    */     
/* 73 */     GameServer.logger().info(String.format("[qingfu]PCGetSaveAmtActivityAward.onFailed@get save amt activity award failed|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d|retcode=%d", new Object[] { Long.valueOf(this.roleid), this.userid, Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(retcode) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PCGetSaveAmtActivityAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */