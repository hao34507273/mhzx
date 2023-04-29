/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*    */ import xbean.InstanceCacheBean;
/*    */ 
/*    */ public class LeaveSingleInstanceLogicProcedure extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public LeaveSingleInstanceLogicProcedure(long roleid)
/*    */   {
/* 12 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     xbean.InstanceBean xInstanceBean = xtable.Role2instance.get(Long.valueOf(this.roleid));
/* 20 */     if (xInstanceBean == null) {
/* 21 */       return false;
/*    */     }
/* 23 */     Long instanceUuid = xtable.Role2instanceuuid.get(Long.valueOf(this.roleid));
/* 24 */     if (instanceUuid != null)
/*    */     {
/* 26 */       InstanceCacheBean xInstanceCacheBean = xtable.Instance.get(instanceUuid);
/*    */       
/* 28 */       SInstanceCfg instanceCfg = SInstanceCfg.get(xInstanceCacheBean.getInstancecfgid());
/* 29 */       if (instanceCfg.instanceType == 1)
/* 30 */         SingleInstance.onleaveInstance(this.roleid, instanceUuid.longValue(), xInstanceCacheBean, xInstanceBean);
/*    */     }
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\LeaveSingleInstanceLogicProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */