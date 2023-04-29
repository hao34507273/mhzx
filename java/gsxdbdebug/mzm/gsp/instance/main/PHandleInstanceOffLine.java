/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*    */ import mzm.gsp.instance.confbean.SInstanceConsts;
/*    */ import xbean.InstanceCacheBean;
/*    */ import xtable.Instance;
/*    */ import xtable.Role2instance;
/*    */ import xtable.Role2instanceuuid;
/*    */ 
/*    */ class PHandleInstanceOffLine extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final boolean inFightDelay;
/*    */   
/*    */   public PHandleInstanceOffLine(long roleid, boolean inFightDelay)
/*    */   {
/* 20 */     this.roleid = roleid;
/* 21 */     this.inFightDelay = inFightDelay;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     Long instanceUuid = Role2instanceuuid.select(Long.valueOf(this.roleid));
/* 30 */     if (instanceUuid != null)
/*    */     {
/*    */ 
/*    */ 
/* 34 */       InstanceCacheBean xSelectinstanceCacheBean = Instance.select(instanceUuid);
/* 35 */       if (xSelectinstanceCacheBean == null)
/*    */       {
/* 37 */         return false;
/*    */       }
/* 39 */       if (FightInterface.isInFight(this.roleid))
/*    */       {
/* 41 */         if (this.inFightDelay)
/*    */         {
/* 43 */           new DelayLogoffSession(SInstanceConsts.getInstance().INSTANCE_FIGHT_LOGOFF_DELAY * 60, this.roleid);
/*    */           
/* 45 */           return false;
/*    */         }
/*    */       }
/*    */       
/* 49 */       SInstanceCfg instanceCfg = SInstanceCfg.get(xSelectinstanceCacheBean.getInstancecfgid());
/* 50 */       switch (instanceCfg.instanceType)
/*    */       {
/*    */ 
/*    */       case 1: 
/* 54 */         xbean.InstanceBean xInstanceBean = Role2instance.get(Long.valueOf(this.roleid));
/*    */         
/* 56 */         InstanceCacheBean xInstanceCacheBean = Instance.get(instanceUuid);
/* 57 */         if (xInstanceCacheBean == null)
/*    */         {
/* 59 */           return false;
/*    */         }
/* 61 */         return SingleInstance.onleaveInstance(this.roleid, instanceUuid.longValue(), xInstanceCacheBean, xInstanceBean);
/*    */       case 2: 
/* 63 */         List<Long> allRoles = new ArrayList();
/* 64 */         allRoles.addAll(xSelectinstanceCacheBean.getRoleids());
/*    */         
/* 66 */         lock(Role2instance.getTable(), allRoles);
/*    */         
/* 68 */         InstanceCacheBean xInstanceTeamCacheBean = Instance.get(instanceUuid);
/* 69 */         if (xInstanceTeamCacheBean == null)
/*    */         {
/* 71 */           return false;
/*    */         }
/* 73 */         return TeamInstance.onLogOff(allRoles, instanceUuid.longValue(), xInstanceTeamCacheBean);
/*    */       }
/*    */       
/*    */     }
/*    */     
/*    */ 
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\PHandleInstanceOffLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */