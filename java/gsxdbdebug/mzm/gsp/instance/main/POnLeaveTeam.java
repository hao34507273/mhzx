/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ import xbean.InstanceCacheBean;
/*    */ 
/*    */ public class POnLeaveTeam extends mzm.gsp.team.event.LeaveTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     Long instanceUuid = xtable.Role2instanceuuid.get(Long.valueOf(((LeaveTeamArg)this.arg).roleid));
/* 12 */     if (instanceUuid == null) {
/* 13 */       return false;
/*    */     }
/*    */     
/* 16 */     InstanceCacheBean xInstanceCacheBean = xtable.Instance.get(instanceUuid);
/* 17 */     if (xInstanceCacheBean != null) {
/* 18 */       SInstanceCfg instanceCfg = SInstanceCfg.get(xInstanceCacheBean.getInstancecfgid());
/* 19 */       switch (instanceCfg.instanceType) {
/*    */       case 2: 
/* 21 */         TeamInstance.onLeaveTeam(((LeaveTeamArg)this.arg).roleid, instanceUuid.longValue(), xInstanceCacheBean);
/* 22 */         break;
/*    */       }
/*    */       
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */