/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import xbean.BigBoss;
/*    */ 
/*    */ public class Pgm_SetDamagePoint extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int value;
/*    */   
/*    */   public Pgm_SetDamagePoint(long roleid, int value)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.value = value;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     long starttime = BigbossManager.getActivityStarttime();
/* 23 */     if (starttime <= 0L)
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     BigBoss xBigBoss = BigbossManager.getBigboss(this.roleid, true);
/* 28 */     if (xBigBoss == null)
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     int ocp = mzm.gsp.role.main.RoleInterface.getOccupationId(this.roleid);
/* 33 */     Integer old = (Integer)xBigBoss.getOcp2damagepoint().get(Integer.valueOf(ocp));
/* 34 */     if (old == null)
/*    */     {
/* 36 */       old = Integer.valueOf(0);
/*    */     }
/* 38 */     xBigBoss.getOcp2damagepoint().clear();
/* 39 */     xBigBoss.getOcp2damagepoint().put(Integer.valueOf(ocp), Integer.valueOf(this.value));
/* 40 */     xBigBoss.setStarttime(starttime);
/* 41 */     BigbossChartManager.getInstance().rank(ocp, this.roleid, this.value);
/* 42 */     BigbossManager.reportRoleBigBossRankInfo(CommonUtils.getLong(ocp, (int)(starttime / 1000L)), this.roleid, mzm.gsp.role.main.RoleInterface.getName(this.roleid), ocp, this.value, 1);
/*    */     
/* 44 */     for (Iterator i$ = mzm.gsp.bigboss.confbean.SBigbossRemoteChartTypeCfg.getAll().keySet().iterator(); i$.hasNext();) { int tmpOcp = ((Integer)i$.next()).intValue();
/*    */       
/* 46 */       if (tmpOcp != ocp)
/*    */       {
/* 48 */         BigbossManager.removeRoleBigBossRankInfo(CommonUtils.getLong(tmpOcp, (int)(starttime / 1000L)), this.roleid, 1);
/*    */       }
/*    */     }
/*    */     
/* 52 */     int roleRank = BigbossChartManager.getInstance().getRank(ocp, this.roleid);
/* 53 */     BigbossManager.synBigbossActivityDataChanged(this.roleid, old.intValue() - this.value, ocp, xBigBoss, roleRank);
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\Pgm_SetDamagePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */