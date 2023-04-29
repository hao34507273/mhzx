/*    */ package mzm.gsp.mounts.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_RemoveMounts
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long targetRoleId;
/*    */   private final long mountsId;
/*    */   private final int mountsCfgId;
/*    */   
/*    */   public PGM_RemoveMounts(long gmRoleId, long targetRoleId, long mountsId, int mountsCfgId)
/*    */   {
/* 19 */     this.gmRoleId = gmRoleId;
/* 20 */     this.targetRoleId = targetRoleId;
/* 21 */     this.mountsId = mountsId;
/* 22 */     this.mountsCfgId = mountsCfgId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     int ret = MountsManager.removeMounts(this.targetRoleId, this.mountsCfgId, this.mountsId);
/*    */     
/* 30 */     if (ret == 64034)
/*    */     {
/* 32 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "要删除的坐骑道具配置id不存在");
/* 33 */       return false;
/*    */     }
/* 35 */     if (ret == 64033)
/*    */     {
/* 37 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "要删除的坐骑实例id与配置id不匹配");
/* 38 */       return false;
/*    */     }
/* 40 */     if (ret == 64035)
/*    */     {
/* 42 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "要删除的坐骑实例id不存在");
/* 43 */       return false;
/*    */     }
/* 45 */     if (ret == 64036)
/*    */     {
/* 47 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "要删除的坐骑的角色不存在");
/* 48 */       return false;
/*    */     }
/* 50 */     if (ret == 64032)
/*    */     {
/* 52 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "要删除的坐骑的角色未拥有该坐骑");
/* 53 */       return false;
/*    */     }
/* 55 */     if (ret == 64031)
/*    */     {
/* 57 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "要删除的坐骑的角色未拥有坐骑包裹");
/* 58 */       return false;
/*    */     }
/* 60 */     if (ret == 0)
/*    */     {
/* 62 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "删除坐骑成功");
/* 63 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 67 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "未知错误");
/* 68 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PGM_RemoveMounts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */