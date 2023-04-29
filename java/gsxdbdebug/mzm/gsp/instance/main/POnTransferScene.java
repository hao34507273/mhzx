/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.map.event.MapTransferArg;
/*    */ import xbean.InstanceCacheBean;
/*    */ import xtable.Role2instance;
/*    */ 
/*    */ public class POnTransferScene extends mzm.gsp.map.event.PlayerTransferSceneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     Long instanceUuid = xtable.Role2instanceuuid.select((Long)((MapTransferArg)this.arg).roleList.get(0));
/* 12 */     if (instanceUuid == null) {
/* 13 */       return false;
/*    */     }
/*    */     
/* 16 */     InstanceCacheBean xSelectInstanceCacheBean = xtable.Instance.select(instanceUuid);
/* 17 */     if (xSelectInstanceCacheBean == null) {
/* 18 */       return false;
/*    */     }
/*    */     
/* 21 */     if (((MapTransferArg)this.arg).oldWorldId == ((MapTransferArg)this.arg).newWorldId) {
/* 22 */       return true;
/*    */     }
/* 24 */     int instancecfgid = xSelectInstanceCacheBean.getInstancecfgid();
/* 25 */     mzm.gsp.instance.confbean.SInstanceCfg sInstanceCfg = mzm.gsp.instance.confbean.SInstanceCfg.get(instancecfgid);
/* 26 */     switch (sInstanceCfg.instanceType) {
/*    */     case 1: 
/* 28 */       lock(Role2instance.getTable(), ((MapTransferArg)this.arg).roleList);
/* 29 */       for (java.util.Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 31 */         xbean.InstanceBean xInstanceBean = Role2instance.get(Long.valueOf(roleid));
/*    */         
/* 33 */         InstanceCacheBean xInstanceCacheBean = xtable.Instance.get(instanceUuid);
/* 34 */         if (xInstanceCacheBean != null)
/*    */         {
/*    */ 
/* 37 */           SingleInstance.onRoleTransferScene(roleid, ((MapTransferArg)this.arg).newWorldId, ((MapTransferArg)this.arg).newMapCfgId, ((MapTransferArg)this.arg).oldWorldId, ((MapTransferArg)this.arg).oldMapCfgId, instanceUuid.longValue(), xInstanceCacheBean, xInstanceBean);
/*    */         }
/*    */       }
/* 40 */       return true;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     case 2: 
/* 57 */       lock(Role2instance.getTable(), ((MapTransferArg)this.arg).roleList);
/*    */       
/* 59 */       InstanceCacheBean xInstanceTeamCacheBean = xtable.Instance.get(instanceUuid);
/* 60 */       if (xInstanceTeamCacheBean == null) {
/* 61 */         return false;
/*    */       }
/* 63 */       return TeamInstance.onRoleTransferScene(((MapTransferArg)this.arg).roleList, ((MapTransferArg)this.arg).newWorldId, ((MapTransferArg)this.arg).newMapCfgId, ((MapTransferArg)this.arg).oldWorldId, ((MapTransferArg)this.arg).oldMapCfgId, instanceUuid.longValue(), xInstanceTeamCacheBean);
/*    */     }
/*    */     
/*    */     
/*    */ 
/*    */ 
/* 69 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */