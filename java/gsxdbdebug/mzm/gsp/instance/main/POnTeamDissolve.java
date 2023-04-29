/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*    */ import mzm.gsp.team.event.TeamDissolveArg;
/*    */ 
/*    */ public class POnTeamDissolve extends mzm.gsp.team.event.TeamDissolveProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     if (((TeamDissolveArg)this.arg).members.size() <= 0) {
/* 11 */       return false;
/*    */     }
/* 13 */     long roleid = ((Long)((TeamDissolveArg)this.arg).members.get(0)).longValue();
/*    */     
/* 15 */     Long instanceUuid = xtable.Role2instanceuuid.select(Long.valueOf(roleid));
/* 16 */     if (instanceUuid == null) {
/* 17 */       return false;
/*    */     }
/*    */     
/* 20 */     lock(xtable.Role2instance.getTable(), ((TeamDissolveArg)this.arg).members);
/*    */     
/* 22 */     xbean.InstanceCacheBean xInstanceCacheBean = xtable.Instance.get(instanceUuid);
/* 23 */     if (xInstanceCacheBean == null) {
/* 24 */       return false;
/*    */     }
/* 26 */     SInstanceCfg instanceCfg = SInstanceCfg.get(xInstanceCacheBean.getInstancecfgid());
/* 27 */     switch (instanceCfg.instanceType) {
/*    */     case 2: 
/* 29 */       return TeamInstance.onTeamDissolve(((TeamDissolveArg)this.arg).members, instanceUuid.longValue(), xInstanceCacheBean);
/*    */     }
/*    */     
/*    */     
/*    */ 
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */