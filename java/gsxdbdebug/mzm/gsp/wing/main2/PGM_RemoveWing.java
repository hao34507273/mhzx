/*    */ package mzm.gsp.wing.main2;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_RemoveWing
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long targetRoleId;
/*    */   private final int wingCfgId;
/*    */   
/*    */   public PGM_RemoveWing(long gmRoleId, long targetRoleId, int wingCfgId)
/*    */   {
/* 17 */     this.gmRoleId = gmRoleId;
/* 18 */     this.targetRoleId = targetRoleId;
/* 19 */     this.wingCfgId = wingCfgId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     xbean.Basic xBasic = xtable.Basic.get(Long.valueOf(this.targetRoleId));
/*    */     
/* 27 */     if (xBasic == null)
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "目标角色不存在");
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     int ret = WingInterface.deleteWing(this.targetRoleId, this.wingCfgId);
/* 34 */     if (ret != 0)
/*    */     {
/* 36 */       if (ret == 64106)
/*    */       {
/* 38 */         GmManager.getInstance().sendResultToGM(this.gmRoleId, "角色没有羽翼数据");
/* 39 */         return false;
/*    */       }
/* 41 */       if (ret == 64105)
/*    */       {
/* 43 */         GmManager.getInstance().sendResultToGM(this.gmRoleId, "羽翼配置不存在");
/* 44 */         return false;
/*    */       }
/* 46 */       if (ret == 64104)
/*    */       {
/* 48 */         GmManager.getInstance().sendResultToGM(this.gmRoleId, "角色未拥有该羽翼");
/* 49 */         return false;
/*    */       }
/*    */       
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "羽翼删除成功");
/*    */     
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PGM_RemoveWing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */