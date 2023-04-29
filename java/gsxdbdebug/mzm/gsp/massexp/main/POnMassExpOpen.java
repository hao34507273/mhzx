/*    */ package mzm.gsp.massexp.main;
/*    */ 
/*    */ import mzm.gsp.massexp.SMassExpInfo;
/*    */ import mzm.gsp.massexp.confbean.SMassExpCfgConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import xbean.MassExpInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnMassExpOpen extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public POnMassExpOpen(long roleid)
/*    */   {
/* 19 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (!MassExpManager.isFunOpen(this.roleid, false))
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/* 32 */     lock(Lockeys.get(User.getTable(), userid));
/* 33 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/*    */ 
/* 36 */     int activityCfgid = SMassExpCfgConsts.getInstance().ACTIVITY_CFG_ID;
/* 37 */     MassExpInfo xMassExpInfo = MassExpManager.getMassExpInfo(this.roleid, activityCfgid);
/* 38 */     if (xMassExpInfo == null)
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 44 */     MassExpManager.dataStruceChange(xMassExpInfo);
/*    */     
/*    */ 
/* 47 */     int curStatus = xMassExpInfo.getStatus();
/* 48 */     if (xMassExpInfo.getStatus() == 0)
/*    */     {
/* 50 */       return true;
/*    */     }
/*    */     
/* 53 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 54 */     if (MassExpManager.expire(xMassExpInfo.getEnd_time(), now))
/*    */     {
/* 56 */       MassExpManager.taskEnd(userid, curStatus, activityCfgid, xMassExpInfo, MassExpInitReason.CLIENT_GET_TASK);
/* 57 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 61 */     if (xMassExpInfo.getStatus() == 1)
/*    */     {
/*    */ 
/* 64 */       TaskInterface.activeGraph(Long.valueOf(this.roleid), SMassExpCfgConsts.getInstance().TASK_ICON_ID);
/*    */     }
/*    */     
/* 67 */     SMassExpInfo msg = new SMassExpInfo();
/* 68 */     msg.mass_exp_info = MassExpManager.buildMassExpInfo(xMassExpInfo);
/* 69 */     OnlineManager.getInstance().send(this.roleid, msg);
/* 70 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\massexp\main\POnMassExpOpen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */