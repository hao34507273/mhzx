/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.instance.STeamInstanceProcess;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import xbean.InstanceBean;
/*    */ 
/*    */ class TeamInstanceInitProcedure extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int activityid;
/*    */   
/*    */   public TeamInstanceInitProcedure(long roleid, int activityid)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.activityid = activityid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     if ((!OpenInterface.getOpenStatus(7)) || (OpenInterface.isBanPlay(this.roleid, 7)))
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     InstanceBean xInstanceBean = xtable.Role2instance.get(Long.valueOf(this.roleid));
/* 26 */     if (xInstanceBean == null) {
/* 27 */       return false;
/*    */     }
/* 29 */     int teamInstanceCfgid = InstanceCfgManager.getOperaInstanceCfgIdByActivityid(this.activityid);
/* 30 */     xbean.TeamInstance xTeamInstance = (xbean.TeamInstance)xInstanceBean.getTeaminstancemap().get(Integer.valueOf(teamInstanceCfgid));
/* 31 */     if (xTeamInstance == null) {
/* 32 */       return true;
/*    */     }
/* 34 */     boolean ret = TeamInstance.onTeamInstanceUpdate(this.roleid, xTeamInstance, teamInstanceCfgid);
/* 35 */     if (ret)
/*    */     {
/* 37 */       xdb.Procedure.execute(new LeaveTeamInstanceLogicProcedure(this.roleid, this.activityid));
/* 38 */       STeamInstanceProcess teamInstanceProcess = new STeamInstanceProcess();
/* 39 */       int processid = xTeamInstance.getToprocess();
/* 40 */       TeamInstance.fillInTeamInfo(teamInstanceProcess.teaminstanceinfo, processid, teamInstanceCfgid, xTeamInstance.getSign());
/*    */       
/* 42 */       mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleid, teamInstanceProcess);
/*    */     }
/* 44 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\TeamInstanceInitProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */