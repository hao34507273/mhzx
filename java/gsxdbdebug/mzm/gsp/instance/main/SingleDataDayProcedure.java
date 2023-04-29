/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.instance.SUpdateSingleInfo;
/*    */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.InstanceBean;
/*    */ import xbean.InstanceCacheBean;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2instance;
/*    */ import xtable.Role2instanceuuid;
/*    */ import xtable.User;
/*    */ 
/*    */ class SingleDataDayProcedure extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public SingleDataDayProcedure(long roleid)
/*    */   {
/* 22 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     String userid = RoleInterface.getUserId(this.roleid);
/* 29 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 31 */     InstanceBean xInstanceBean = Role2instance.get(Long.valueOf(this.roleid));
/* 32 */     boolean ret = SingleInstance.onDataUpdate(this.roleid, xInstanceBean);
/* 33 */     if (ret)
/*    */     {
/* 35 */       Long instanceUuid = Role2instanceuuid.get(Long.valueOf(this.roleid));
/* 36 */       if (instanceUuid != null)
/*    */       {
/* 38 */         InstanceCacheBean xInstanceCacheBean = xtable.Instance.get(instanceUuid);
/*    */         
/* 40 */         SInstanceCfg instanceCfg = SInstanceCfg.get(xInstanceCacheBean.getInstancecfgid());
/* 41 */         if (instanceCfg.instanceType == 1) {
/* 42 */           SingleInstance.onleaveInstance(this.roleid, instanceUuid.longValue(), xInstanceCacheBean, xInstanceBean);
/*    */         }
/*    */       }
/* 45 */       for (Map.Entry<Integer, xbean.SingleInstance> entry : xInstanceBean.getSingleinstancemap().entrySet()) {
/* 46 */         SUpdateSingleInfo updateSingleInfo = new SUpdateSingleInfo();
/* 47 */         updateSingleInfo.failtime = xInstanceBean.getSinglefailtime();
/* 48 */         xbean.SingleInstance xSingleInstance = (xbean.SingleInstance)entry.getValue();
/* 49 */         SingleInstance.fillInSingleInfo(updateSingleInfo.singleinfo, xSingleInstance.getHighprocess(), xSingleInstance.getCurprocess(), xSingleInstance.getFinishtimes(), ((Integer)entry.getKey()).intValue(), xSingleInstance.getSign());
/*    */         
/*    */ 
/* 52 */         OnlineManager.getInstance().send(this.roleid, updateSingleInfo);
/*    */       }
/*    */     }
/* 55 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\SingleDataDayProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */