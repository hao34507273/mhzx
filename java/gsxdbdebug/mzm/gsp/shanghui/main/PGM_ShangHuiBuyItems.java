/*    */ package mzm.gsp.shanghui.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class PGM_ShangHuiBuyItems extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long targetRoleId;
/*    */   private final long gmRoleId;
/*    */   private final int itemId;
/*    */   private final int number;
/*    */   
/*    */   public PGM_ShangHuiBuyItems(long targetRoleId, long gmRoleId, int itemId, int number)
/*    */   {
/* 15 */     this.targetRoleId = targetRoleId;
/* 16 */     this.gmRoleId = gmRoleId;
/* 17 */     this.itemId = itemId;
/* 18 */     this.number = number;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     for (int i = 0; i < this.number; i++)
/*    */     {
/* 26 */       new PBuyItemReq(this.targetRoleId, this.itemId, 1, RoleInterface.getGold(this.targetRoleId)).call();
/*    */     }
/*    */     
/* 29 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "购买成功");
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\PGM_ShangHuiBuyItems.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */