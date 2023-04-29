/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*    */ import xbean.InstanceCacheBean;
/*    */ import xtable.Instance;
/*    */ import xtable.Role2instance;
/*    */ 
/*    */ public class POnRoleEnterProtect extends mzm.gsp.online.event.PlayerEnterProtectProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     Long instanceUuid = xtable.Role2instanceuuid.select((Long)this.arg);
/* 15 */     if (instanceUuid != null)
/*    */     {
/* 17 */       InstanceCacheBean xSelectinstanceCacheBean = Instance.select(instanceUuid);
/* 18 */       if (xSelectinstanceCacheBean != null) {
/* 19 */         SInstanceCfg instanceCfg = SInstanceCfg.get(xSelectinstanceCacheBean.getInstancecfgid());
/* 20 */         switch (instanceCfg.instanceType) {
/*    */         case 2: 
/* 22 */           List<Long> allRoles = new ArrayList();
/* 23 */           allRoles.addAll(xSelectinstanceCacheBean.getRoleids());
/*    */           
/* 25 */           lock(Role2instance.getTable(), allRoles);
/*    */           
/* 27 */           InstanceCacheBean xInstanceCacheBean = Instance.get(instanceUuid);
/* 28 */           if (xInstanceCacheBean == null) {
/* 29 */             return false;
/*    */           }
/* 31 */           return TeamInstance.playerEnterProtect(allRoles, instanceUuid.longValue(), xInstanceCacheBean);
/*    */         }
/*    */         
/*    */       }
/*    */     }
/*    */     
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\POnRoleEnterProtect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */