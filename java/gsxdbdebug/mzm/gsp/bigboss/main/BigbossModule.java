/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import xbean.BigBoss;
/*    */ import xbean.OcpBigBossRoleList;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleBossBean;
/*    */ import xbean.RoleBossRank;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Ocpbossrank;
/*    */ import xtable.Role2bigboss;
/*    */ import xtable.Rolebossrank;
/*    */ 
/*    */ public class BigbossModule implements mzm.event.Module, mzm.event.PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 23 */     new BigbossOldRankDataUpgrade(null).call();
/* 24 */     BigbossChartManager.getInstance().initBigbossOcpRankManger();
/* 25 */     mzm.gsp.activity.main.ActivityInterface.registerActivityByLogicType(18, new BigbossActivityInit());
/* 26 */     return 0;
/*    */   }
/*    */   
/*    */   private static class BigbossOldRankDataUpgrade
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 35 */       RoleBossRank xBossRank = Rolebossrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 36 */       Iterator i$; if ((xBossRank != null) && (!xBossRank.getRankdatas().isEmpty()))
/*    */       {
/* 38 */         List<Long> ocpLocks = new ArrayList();
/* 39 */         for (Iterator i$ = mzm.gsp.bigboss.confbean.SOcp2ChartType.getAll().keySet().iterator(); i$.hasNext();) { int ocp = ((Integer)i$.next()).intValue();
/*    */           
/* 41 */           ocpLocks.add(Long.valueOf(GameServerInfoManager.toGlobalId(ocp)));
/*    */         }
/* 43 */         Lockeys.lock(Ocpbossrank.getTable(), ocpLocks);
/*    */         
/* 45 */         List<Long> roleids = new ArrayList();
/* 46 */         for (RoleBossBean xRoleBossBean : xBossRank.getRankdatas())
/*    */         {
/* 48 */           roleids.add(Long.valueOf(xRoleBossBean.getRoleid()));
/*    */         }
/* 50 */         Lockeys.lock(Role2bigboss.getTable(), roleids);
/* 51 */         for (i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */           
/* 53 */           int roleOcp = mzm.gsp.role.main.RoleInterface.getOccupationId(roleid);
/* 54 */           BigBoss xBigBoss = Role2bigboss.get(Long.valueOf(roleid));
/* 55 */           if (xBigBoss != null)
/*    */           {
/*    */ 
/*    */ 
/* 59 */             xBigBoss.getOcp2damagepoint().clear();
/* 60 */             xBigBoss.getOcp2damagepoint().put(Integer.valueOf(roleOcp), Integer.valueOf(xBigBoss.getDamagepoint()));
/* 61 */             xBigBoss.setDamagepoint(0);
/*    */             
/* 63 */             long key = GameServerInfoManager.toGlobalId(roleOcp);
/* 64 */             OcpBigBossRoleList xOcpBigBossRoleList = Ocpbossrank.get(Long.valueOf(key));
/* 65 */             if (xOcpBigBossRoleList == null)
/*    */             {
/* 67 */               xOcpBigBossRoleList = Pod.newOcpBigBossRoleList();
/* 68 */               Ocpbossrank.insert(Long.valueOf(key), xOcpBigBossRoleList);
/*    */             }
/* 70 */             RoleBossBean xRoleBossBean = Pod.newRoleBossBean();
/* 71 */             xRoleBossBean.setRoleid(roleid);
/* 72 */             xOcpBigBossRoleList.getRolelist().add(xRoleBossBean);
/*    */           }
/*    */         }
/*    */       }
/* 76 */       Rolebossrank.remove(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 77 */       return true;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 84 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 90 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 96 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\BigbossModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */