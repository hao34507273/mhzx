/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.bigboss.confbean.SBigbossRemoteChartTypeCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.BigBoss;
/*    */ import xtable.Role2bigboss;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BigbossInterface
/*    */ {
/*    */   public static int getDamagePoint(long roleid)
/*    */   {
/* 19 */     return BigbossManager.getDamagePoint(roleid, RoleInterface.getOccupationId(roleid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void insertIntoRankForIdip(long roleid, int damagePoint)
/*    */   {
/* 31 */     new InsertIntoRankPro(roleid, damagePoint).execute();
/*    */   }
/*    */   
/*    */ 
/*    */   private static class InsertIntoRankPro
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     private final int damagePoint;
/*    */     
/*    */     public InsertIntoRankPro(long roleid, int damagePoint)
/*    */     {
/* 43 */       this.roleid = roleid;
/* 44 */       this.damagePoint = damagePoint;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 50 */       long starttime = BigbossManager.getActivityStarttime();
/* 51 */       if (starttime <= 0L)
/*    */       {
/* 53 */         return false;
/*    */       }
/* 55 */       BigBoss xBigBoss = Role2bigboss.get(Long.valueOf(this.roleid));
/* 56 */       if (xBigBoss == null)
/*    */       {
/* 58 */         return false;
/*    */       }
/* 60 */       int ocp = RoleInterface.getOccupationId(this.roleid);
/* 61 */       xBigBoss.setDamagepoint(0);
/* 62 */       xBigBoss.getOcp2damagepoint().clear();
/* 63 */       xBigBoss.getOcp2damagepoint().put(Integer.valueOf(ocp), Integer.valueOf(this.damagePoint));
/* 64 */       xBigBoss.setStarttime(starttime);
/* 65 */       BigbossChartManager.getInstance().rank(ocp, this.roleid, this.damagePoint);
/* 66 */       BigbossManager.reportRoleBigBossRankInfo(CommonUtils.getLong(ocp, (int)(starttime / 1000L)), this.roleid, RoleInterface.getName(this.roleid), ocp, this.damagePoint, 1);
/*    */       
/* 68 */       for (Iterator i$ = SBigbossRemoteChartTypeCfg.getAll().keySet().iterator(); i$.hasNext();) { int tmpOcp = ((Integer)i$.next()).intValue();
/*    */         
/* 70 */         if (tmpOcp != ocp)
/*    */         {
/* 72 */           BigbossManager.removeRoleBigBossRankInfo(CommonUtils.getLong(tmpOcp, (int)(starttime / 1000L)), this.roleid, 1);
/*    */         }
/*    */       }
/* 75 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\BigbossInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */