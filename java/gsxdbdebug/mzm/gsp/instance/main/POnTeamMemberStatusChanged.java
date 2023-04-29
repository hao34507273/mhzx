/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedArg;
/*    */ 
/*    */ public class POnTeamMemberStatusChanged extends mzm.gsp.team.event.TeamMemberStatusChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     if (((TeamMemberStatusChangedArg)this.arg).isNormal())
/*    */     {
/* 12 */       Long instanceUuid = xtable.Role2instanceuuid.get(Long.valueOf(((TeamMemberStatusChangedArg)this.arg).roleid));
/* 13 */       if (instanceUuid == null) {
/* 14 */         return false;
/*    */       }
/*    */       
/* 17 */       xbean.InstanceBean xInstanceBean = xtable.Role2instance.get(Long.valueOf(((TeamMemberStatusChangedArg)this.arg).roleid));
/*    */       
/* 19 */       xbean.InstanceCacheBean xInstanceCacheBean = xtable.Instance.get(instanceUuid);
/* 20 */       SInstanceCfg instanceCfg = SInstanceCfg.get(xInstanceCacheBean.getInstancecfgid());
/* 21 */       switch (instanceCfg.instanceType) {
/*    */       case 2: 
/* 23 */         return TeamInstance.onTeamRoleToNormal(((TeamMemberStatusChangedArg)this.arg).roleid, instanceUuid.longValue(), xInstanceCacheBean, xInstanceBean);
/*    */       }
/*    */       
/*    */     }
/*    */     
/*    */ 
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\POnTeamMemberStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */