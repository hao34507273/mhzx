/*    */ package mzm.gsp.resourcecheck.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import xbean.Reason2Resource;
/*    */ import xbean.ResourceId2Num;
/*    */ 
/*    */ public class PGM_ItemCheck extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long targetRoleid;
/*    */   private final int itemId;
/*    */   private final int logReason;
/*    */   
/*    */   public PGM_ItemCheck(long gmRoleid, long targetRoleid, int itemId, int logReason)
/*    */   {
/* 18 */     this.gmRoleid = gmRoleid;
/* 19 */     this.targetRoleid = targetRoleid;
/* 20 */     this.itemId = itemId;
/* 21 */     this.logReason = logReason;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if (!ResourceChecker.isItemCheckSwitchOpen())
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("物品资源监测开关关闭", new Object[0]));
/* 30 */       return true;
/*    */     }
/*    */     
/* 33 */     String rolename = mzm.gsp.role.main.RoleInterface.getName(this.targetRoleid);
/* 34 */     ResourceChecker.getItemId2NumXBean(this.targetRoleid, LogReason.GM_ADD.value, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*    */     
/* 36 */     Reason2Resource xReason2Resource = xtable.Role2resource.get(Long.valueOf(this.targetRoleid));
/*    */     
/* 38 */     ResourceId2Num xResourceId2Num = (ResourceId2Num)xReason2Resource.getReason2item().get(Integer.valueOf(this.logReason));
/* 39 */     if (xResourceId2Num != null)
/*    */     {
/* 41 */       Long num = (Long)xResourceId2Num.getId2num().get(Integer.valueOf(this.itemId));
/* 42 */       if (num == null)
/*    */       {
/* 44 */         num = Long.valueOf(0L);
/*    */       }
/* 46 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("角色名%s:物品%d 途径%d 获得个数%d", new Object[] { rolename, Integer.valueOf(this.itemId), Integer.valueOf(this.logReason), num }));
/*    */     }
/*    */     
/*    */ 
/* 50 */     int c = 0;
/* 51 */     for (ResourceId2Num x : xReason2Resource.getReason2item().values())
/*    */     {
/* 53 */       Long num = (Long)x.getId2num().get(Integer.valueOf(this.itemId));
/* 54 */       if (num == null)
/*    */       {
/* 56 */         num = Long.valueOf(0L);
/*    */       }
/* 58 */       c = (int)(c + num.longValue());
/*    */     }
/* 60 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("角色名%s:物品%d 获得总个数%d", new Object[] { rolename, Integer.valueOf(this.itemId), Integer.valueOf(c) }));
/*    */     
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\resourcecheck\main\PGM_ItemCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */