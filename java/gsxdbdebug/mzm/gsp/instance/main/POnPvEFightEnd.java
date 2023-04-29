/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.fight.event.PVEFightEndArg;
/*    */ import mzm.gsp.instance.confbean.SInstanceConsts;
/*    */ import mzm.gsp.instance.confbean.SingleInstanceData;
/*    */ import xbean.InstanceBean;
/*    */ 
/*    */ public class POnPvEFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     if ((((PVEFightEndArg)this.arg).context instanceof SingleInstanceFightContext)) {
/* 15 */       SingleInstanceFightContext context = (SingleInstanceFightContext)((PVEFightEndArg)this.arg).context;
/*    */       
/* 17 */       long roleid = ((Long)((PVEFightEndArg)this.arg).roleList.get(0)).longValue();
/*    */       
/*    */ 
/* 20 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 21 */       lock(xdb.Lockeys.get(xtable.User.getTable(), userid));
/*    */       
/*    */ 
/* 24 */       InstanceBean xInstanceBean = xtable.Role2instance.get(Long.valueOf(roleid));
/* 25 */       Long instanceUuid = xtable.Role2instanceuuid.get(Long.valueOf(roleid));
/* 26 */       if (instanceUuid == null) {
/* 27 */         if (!((PVEFightEndArg)this.arg).isPlayerWin) {
/* 28 */           return false;
/*    */         }
/* 30 */         boolean isDataValidate = ActivityInterface.isActivityDataValidate(userid, roleid, SInstanceConsts.getInstance().SINGLE_INSTANCE_ACTIVITY_TYPE_ID);
/*    */         
/* 32 */         if (!isDataValidate)
/*    */         {
/* 34 */           xbean.SingleInstance xSingleInstance = (xbean.SingleInstance)xInstanceBean.getSingleinstancemap().get(Integer.valueOf(context.instanceCfgid));
/*    */           
/* 36 */           if (xSingleInstance == null) {
/* 37 */             return false;
/*    */           }
/* 39 */           if (!SingleInstance.isCanRewardRole(roleid, xSingleInstance, context.instanceCfgid)) {
/* 40 */             return false;
/*    */           }
/* 42 */           SingleInstanceData origialInstanceDataCfg = InstanceCfgManager.getSingleInstanceCfg(context.instanceCfgid, context.instanceProcessid);
/*    */           
/* 44 */           if (origialInstanceDataCfg == null) {
/* 45 */             return false;
/*    */           }
/* 47 */           ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, SInstanceConsts.getInstance().SINGLE_INSTANCE_ACTIVITY_TYPE_ID);
/*    */           
/* 49 */           if (activityJoinResult.isCanJoin())
/*    */           {
/* 51 */             SingleInstance.sendInstanceAward(userid, roleid, context.instanceCfgid, origialInstanceDataCfg);
/* 52 */             return true;
/*    */           }
/*    */         }
/* 55 */         return false;
/*    */       }
/*    */       
/* 58 */       xbean.InstanceCacheBean xInstanceCacheBean = xtable.Instance.get(instanceUuid);
/* 59 */       return SingleInstance.fightResult(userid, roleid, ((PVEFightEndArg)this.arg).isPlayerWin, (int)(((PVEFightEndArg)this.arg).timeMills / 1000L), context, xInstanceBean, instanceUuid.longValue(), xInstanceCacheBean);
/*    */     }
/*    */     
/* 62 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\POnPvEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */