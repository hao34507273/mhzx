/*    */ package mzm.gsp.baitan.main;
/*    */ 
/*    */ import mzm.gsp.baitan.confbean.BaiTanConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import xbean.RoleGrid;
/*    */ import xtable.Role2grid;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (BaiTanManager.isOpenForLevel(((RoleLevelUpArg)this.arg).newLevel))
/*    */     {
/* 15 */       RoleGrid roleGrid = Role2grid.get(Long.valueOf(((RoleLevelUpArg)this.arg).roleId));
/* 16 */       if (roleGrid == null)
/*    */       {
/* 18 */         roleGrid = xbean.Pod.newRoleGrid();
/* 19 */         roleGrid.setMaxgridnum(BaiTanConsts.getInstance().DEFAULT_POS_NUM);
/* 20 */         Role2grid.insert(Long.valueOf(((RoleLevelUpArg)this.arg).roleId), roleGrid);
/*    */         
/* 22 */         mzm.gsp.baitan.SSyncMyShopingItem my = new mzm.gsp.baitan.SSyncMyShopingItem();
/* 23 */         my.shopgridsize = roleGrid.getMaxgridnum();
/* 24 */         OnlineManager.getInstance().send(((RoleLevelUpArg)this.arg).roleId, my);
/*    */         
/* 26 */         new PQueryShoppingListReq(((RoleLevelUpArg)this.arg).roleId, BaiTanManager.getBaitanSubtype(), 0).execute();
/*    */       }
/*    */     }
/*    */     
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */