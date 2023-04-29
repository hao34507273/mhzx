/*    */ package mzm.gsp.shanghui.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ShangHuiItem;
/*    */ import xtable.Shanghui;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_ChangeItemFlowRate
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int itemId;
/*    */   private final int rise;
/*    */   
/*    */   public PGM_ChangeItemFlowRate(long roleId, int itemId, int rise)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.itemId = itemId;
/* 24 */     this.rise = rise;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     SShangHuiItemToolsCfg itemCfg = ShanghuiManager.getShangHuiItemCfg(this.itemId);
/* 32 */     if (itemCfg == null)
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("非商会物品！|物品id=%d", new Object[] { Integer.valueOf(this.itemId) }));
/* 35 */       return false;
/*    */     }
/* 37 */     ShangHuiItem xShangHuiItem = Shanghui.get(Long.valueOf(GameServerInfoManager.toGlobalId(this.itemId)));
/* 38 */     if (xShangHuiItem == null)
/*    */     {
/* 40 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("数据库里没有该物品数据！|物品id=%d", new Object[] { Integer.valueOf(this.itemId) }));
/* 41 */       return false;
/*    */     }
/* 43 */     xShangHuiItem.setRiserate(this.rise);
/* 44 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("设置成功！当前物品涨幅万分比率=%d", new Object[] { Integer.valueOf(this.rise) }));
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\PGM_ChangeItemFlowRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */