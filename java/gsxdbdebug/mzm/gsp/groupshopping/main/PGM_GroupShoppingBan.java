/*    */ package mzm.gsp.groupshopping.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_GroupShoppingBan
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   private final int groupShoppingItemCfgId;
/*    */   private final boolean isBanned;
/*    */   
/*    */   public PGM_GroupShoppingBan(long roleId, int activityId, int groupShoppingItemCfgId, int isBanned)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.activityId = activityId;
/* 18 */     this.groupShoppingItemCfgId = groupShoppingItemCfgId;
/* 19 */     this.isBanned = (isBanned != 0);
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*    */     boolean result;
/*    */     boolean result;
/* 26 */     if (this.isBanned) {
/* 27 */       result = GroupShoppingBanInterface.ban(this.activityId, this.groupShoppingItemCfgId);
/*    */     } else
/* 29 */       result = GroupShoppingBanInterface.unban(this.activityId, this.groupShoppingItemCfgId);
/* 30 */     if (result)
/*    */     {
/* 32 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("已对活动%d的团购商品配置ID%d完成操作", new Object[] { Integer.valueOf(this.activityId), Integer.valueOf(this.groupShoppingItemCfgId) }));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 37 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("活动%d中没有团购商品配置ID%d, 操作失败", new Object[] { Integer.valueOf(this.activityId), Integer.valueOf(this.groupShoppingItemCfgId) }));
/*    */       
/* 39 */       return false;
/*    */     }
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\PGM_GroupShoppingBan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */