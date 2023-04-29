/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.bigboss.confbean.SBigbossRemoteChartTypeCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import xbean.BigBoss;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     BigBoss bigBoss = xtable.Role2bigboss.get((Long)this.arg);
/* 17 */     if (bigBoss == null)
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     int ocp = RoleInterface.getOccupationId(((Long)this.arg).longValue());
/* 22 */     if ((bigBoss.getDamagepoint() != 0) && (!bigBoss.getOcp2damagepoint().containsKey(Integer.valueOf(ocp))))
/*    */     {
/* 24 */       bigBoss.getOcp2damagepoint().clear();
/* 25 */       bigBoss.getOcp2damagepoint().put(Integer.valueOf(ocp), Integer.valueOf(bigBoss.getDamagepoint()));
/* 26 */       bigBoss.setDamagepoint(0);
/*    */     }
/*    */     
/* 29 */     long starttime = BigbossManager.getActivityStarttime();
/* 30 */     if (starttime <= 0L)
/*    */     {
/* 32 */       return false; }
/*    */     int reserveOcp;
/* 34 */     Iterator i$; if (bigBoss.getStarttime() == starttime)
/*    */     {
/*    */       Iterator i$;
/*    */       
/*    */ 
/*    */ 
/* 40 */       if (bigBoss.getOcp2damagepoint().containsKey(Integer.valueOf(ocp)))
/*    */       {
/* 42 */         int damagePoint = ((Integer)bigBoss.getOcp2damagepoint().get(Integer.valueOf(ocp))).intValue();
/* 43 */         if (!BigbossManager.isBanRank(((Long)this.arg).longValue()))
/*    */         {
/* 45 */           BigbossChartManager.getInstance().removeRoleFromAllRank(((Long)this.arg).longValue());
/* 46 */           BigbossChartManager.getInstance().rank(ocp, ((Long)this.arg).longValue(), damagePoint);
/* 47 */           BigbossManager.reportRoleBigBossRankInfo(CommonUtils.getLong(ocp, (int)(starttime / 1000L)), ((Long)this.arg).longValue(), RoleInterface.getName(((Long)this.arg).longValue()), ocp, damagePoint, 1);
/*    */           
/* 49 */           for (i$ = SBigbossRemoteChartTypeCfg.getAll().keySet().iterator(); i$.hasNext();) { int tmpOcp = ((Integer)i$.next()).intValue();
/*    */             
/* 51 */             if (tmpOcp != ocp)
/*    */             {
/* 53 */               BigbossManager.removeRoleBigBossRankInfo(CommonUtils.getLong(tmpOcp, (int)(starttime / 1000L)), ((Long)this.arg).longValue(), 1);
/*    */             }
/*    */             
/*    */           }
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 61 */         reserveOcp = -1;
/* 62 */         Set<Integer> deleteOcps = new java.util.HashSet();
/* 63 */         for (Map.Entry<Integer, Integer> entry : bigBoss.getOcp2damagepoint().entrySet())
/*    */         {
/* 65 */           if (reserveOcp <= 0)
/*    */           {
/* 67 */             reserveOcp = ((Integer)entry.getKey()).intValue();
/*    */           }
/* 69 */           if (reserveOcp != ((Integer)entry.getKey()).intValue())
/*    */           {
/* 71 */             deleteOcps.add(entry.getKey());
/*    */           }
/*    */         }
/* 74 */         for (Iterator i$ = deleteOcps.iterator(); i$.hasNext();) { int deleteOcp = ((Integer)i$.next()).intValue();
/*    */           
/* 76 */           bigBoss.getOcp2damagepoint().remove(Integer.valueOf(deleteOcp));
/*    */         }
/* 78 */         if ((!BigbossManager.isBanRank(((Long)this.arg).longValue())) && (reserveOcp > 0) && (bigBoss.getOcp2damagepoint().containsKey(Integer.valueOf(reserveOcp))))
/*    */         {
/* 80 */           int damagePoint = ((Integer)bigBoss.getOcp2damagepoint().get(Integer.valueOf(reserveOcp))).intValue();
/* 81 */           BigbossChartManager.getInstance().removeRoleFromAllRank(((Long)this.arg).longValue());
/* 82 */           BigbossChartManager.getInstance().rank(reserveOcp, ((Long)this.arg).longValue(), damagePoint);
/* 83 */           BigbossManager.reportRoleBigBossRankInfo(CommonUtils.getLong(reserveOcp, (int)(starttime / 1000L)), ((Long)this.arg).longValue(), RoleInterface.getName(((Long)this.arg).longValue()), reserveOcp, damagePoint, 1);
/*    */           
/* 85 */           for (i$ = SBigbossRemoteChartTypeCfg.getAll().keySet().iterator(); i$.hasNext();) { int tmpOcp = ((Integer)i$.next()).intValue();
/*    */             
/* 87 */             if (tmpOcp != reserveOcp)
/*    */             {
/* 89 */               BigbossManager.removeRoleBigBossRankInfo(CommonUtils.getLong(tmpOcp, (int)(starttime / 1000L)), ((Long)this.arg).longValue(), 1);
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 96 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */