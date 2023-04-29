/*    */ package mzm.gsp.massexp.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.massexp.SMassExpInfo;
/*    */ import mzm.gsp.massexp.confbean.SMassExpCfgConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.MassExpInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGM_ResetMassExp extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_ResetMassExp(long gmRoleid, long roleid)
/*    */   {
/* 21 */     this.gmRoleid = gmRoleid;
/* 22 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (!MassExpManager.isFunOpen(this.roleid, false))
/*    */     {
/* 30 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "功能为开启");
/* 31 */       return false;
/*    */     }
/* 33 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 35 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "中心服不支持此操作");
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     String userid = RoleInterface.getUserId(this.roleid);
/* 40 */     if (userid == null)
/*    */     {
/* 42 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "角色不存在");
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     int activityCfgid = SMassExpCfgConsts.getInstance().ACTIVITY_CFG_ID;
/*    */     
/*    */ 
/* 49 */     lock(Lockeys.get(User.getTable(), userid));
/* 50 */     MassExpInfo xMassExpInfo = MassExpManager.getMassExpInfo(this.roleid, activityCfgid);
/* 51 */     if (xMassExpInfo == null)
/*    */     {
/* 53 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "未参与活动");
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     if (xMassExpInfo.getStatus() == 0)
/*    */     {
/* 59 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "未参与活动");
/* 60 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 64 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 65 */     xMassExpInfo.setEnd_time(now);
/*    */     
/* 67 */     if (xMassExpInfo.getStatus() == 2)
/*    */     {
/* 69 */       SMassExpInfo msg = new SMassExpInfo();
/* 70 */       msg.mass_exp_info = MassExpManager.buildMassExpInfo(xMassExpInfo);
/* 71 */       OnlineManager.getInstance().send(this.roleid, msg);
/*    */       
/* 73 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "重置成功");
/* 74 */       return true;
/*    */     }
/*    */     
/* 77 */     if (xMassExpInfo.getStatus() == 1)
/*    */     {
/* 79 */       MassExpManager.startObserver(this.roleid, activityCfgid, 0L);
/*    */       
/* 81 */       SMassExpInfo msg = new SMassExpInfo();
/* 82 */       msg.mass_exp_info = MassExpManager.buildMassExpInfo(xMassExpInfo);
/* 83 */       OnlineManager.getInstance().send(this.roleid, msg);
/*    */       
/* 85 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "重置成功，并返还奖励");
/* 86 */       return true;
/*    */     }
/*    */     
/* 89 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, "系统错误");
/* 90 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\massexp\main\PGM_ResetMassExp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */