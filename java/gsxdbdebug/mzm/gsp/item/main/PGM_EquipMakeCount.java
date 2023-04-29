/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.Equipstate;
/*    */ 
/*    */ public class PGM_EquipMakeCount extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long gmRoleid;
/* 12 */   private int level = -1;
/* 13 */   private int eqpid = -1;
/*    */   
/*    */   public PGM_EquipMakeCount(long roleid, long gmRoleid, int level, int eqpid)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.gmRoleid = gmRoleid;
/* 19 */     this.level = level;
/* 20 */     this.eqpid = eqpid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     Equipstate xEquipstate = xtable.Role2equipstate.get(Long.valueOf(this.roleid));
/* 28 */     if (xEquipstate == null)
/*    */     {
/* 30 */       return false; }
/*    */     Iterator i$;
/* 32 */     if (this.level == -1)
/*    */     {
/* 34 */       for (i$ = xEquipstate.getLevel2makecount().keySet().iterator(); i$.hasNext();) { int level = ((Integer)i$.next()).intValue();
/*    */         
/* 36 */         GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d %d 级打造未掉落橙装次数为%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(level), xEquipstate.getLevel2makecount().get(Integer.valueOf(level)) }));
/*    */       }
/*    */       
/*    */     }
/*    */     else
/*    */     {
/* 42 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d %d 级打造未掉落橙装次数为%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.level), Integer.valueOf(xEquipstate.getLevel2makecount().get(Integer.valueOf(this.level)) == null ? 0 : ((Integer)xEquipstate.getLevel2makecount().get(Integer.valueOf(this.level))).intValue()) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */     Iterator i$;
/*    */     
/*    */ 
/*    */ 
/* 51 */     if (this.eqpid == -1)
/*    */     {
/* 53 */       for (i$ = xEquipstate.getEqpid2makecount().keySet().iterator(); i$.hasNext();) { int eqpid = ((Integer)i$.next()).intValue();
/*    */         
/* 55 */         mzm.gsp.item.confbean.SItemEquipCfg itemEquipCfg = mzm.gsp.item.confbean.SItemEquipCfg.get(eqpid);
/* 56 */         GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d %s 打造未掉落特技橙装次数为%d", new Object[] { Long.valueOf(this.roleid), itemEquipCfg.name, xEquipstate.getEqpid2makecount().get(Integer.valueOf(eqpid)) }));
/*    */       }
/*    */       
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 64 */       mzm.gsp.item.confbean.SItemEquipCfg itemEquipCfg = mzm.gsp.item.confbean.SItemEquipCfg.get(this.eqpid);
/* 65 */       if (itemEquipCfg == null)
/*    */       {
/* 67 */         GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("装备id不存在 %d", new Object[] { Integer.valueOf(this.eqpid) }));
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 72 */         GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d %s 打造未掉落特技橙装次数为%d", new Object[] { Long.valueOf(this.roleid), itemEquipCfg.name, Integer.valueOf(xEquipstate.getEqpid2makecount().get(Integer.valueOf(this.eqpid)) == null ? 0 : ((Integer)xEquipstate.getEqpid2makecount().get(Integer.valueOf(this.eqpid))).intValue()) }));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 83 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_EquipMakeCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */