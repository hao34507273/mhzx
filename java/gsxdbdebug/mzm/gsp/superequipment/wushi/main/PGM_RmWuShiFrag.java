/*    */ package mzm.gsp.superequipment.wushi.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_RmWuShiFrag
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   final int wuShiTypeId;
/*    */   final int fragCountToRemove;
/*    */   
/*    */   public PGM_RmWuShiFrag(long targetRoleId, long gmRoleId, int wuShiTypeId, int fragCountToRemove)
/*    */   {
/* 16 */     this.targetRoleId = targetRoleId;
/* 17 */     this.gmRoleId = gmRoleId;
/* 18 */     this.wuShiTypeId = wuShiTypeId;
/* 19 */     this.fragCountToRemove = fragCountToRemove;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     int ret = WuShiInterface.removeWuShiByFragmentForIDIP(this.targetRoleId, this.wuShiTypeId, this.fragCountToRemove, true);
/*    */     
/* 27 */     if (ret == 0)
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "删除成功");
/* 30 */       return true;
/*    */     }
/* 32 */     if (ret == 63975)
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "碎片不足，无法删除");
/* 35 */       return false;
/*    */     }
/* 37 */     if (ret == 63976)
/*    */     {
/* 39 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "武饰不存在");
/* 40 */       return false;
/*    */     }
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\main\PGM_RmWuShiFrag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */