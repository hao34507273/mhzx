/*    */ package mzm.gsp.shanghui.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.RoleShangHuiBean;
/*    */ import xbean.RoleShangHuiItem;
/*    */ 
/*    */ public class PGM_SetRoleBuyNum extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int itemId;
/*    */   private final int buyNum;
/*    */   
/*    */   public PGM_SetRoleBuyNum(long roleId, int itemId, int buyNum)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.itemId = itemId;
/* 19 */     this.buyNum = buyNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (this.buyNum < 0)
/*    */     {
/* 27 */       GmManager.getInstance().sendResultToGM(this.roleId, "设置的[已购买数量]不能为负数！");
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg itemCfg = ShanghuiManager.getShangHuiItemCfg(this.itemId);
/* 32 */     if (itemCfg == null)
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     RoleShangHuiBean xRoleShangHuiBean = xtable.Role2shanghui.get(Long.valueOf(this.roleId));
/* 38 */     if (xRoleShangHuiBean == null)
/*    */     {
/* 40 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有玩家商会操作记录，尝试任意购买或卖出一款物品！");
/* 41 */       return false;
/*    */     }
/* 43 */     xbean.ShangHuiItem xShangHuiItem = xtable.Shanghui.get(Long.valueOf(mzm.gsp.GameServerInfoManager.toGlobalId(this.itemId)));
/* 44 */     if (xShangHuiItem == null)
/*    */     {
/* 46 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("数据库里没有该物品数据！|物品id=%d", new Object[] { Integer.valueOf(this.itemId) }));
/* 47 */       return false;
/*    */     }
/* 49 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 50 */     if (DateTimeUtils.needDailyReset(xRoleShangHuiBean.getTimestamp(), now, 0))
/*    */     {
/* 52 */       xRoleShangHuiBean.setTimestamp(now);
/* 53 */       xRoleShangHuiBean.getItemmap().clear();
/*    */     }
/* 55 */     RoleShangHuiItem xRoleItem = (RoleShangHuiItem)xRoleShangHuiBean.getItemmap().get(Integer.valueOf(this.itemId));
/* 56 */     if (xRoleItem == null)
/*    */     {
/* 58 */       xRoleShangHuiBean.getItemmap().put(Integer.valueOf(this.itemId), xRoleItem = xbean.Pod.newRoleShangHuiItem());
/*    */     }
/* 60 */     xRoleItem.setBuynum(this.buyNum);
/*    */     
/* 62 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("设置成功！|物品id=%d|已购买数量=%d", new Object[] { Integer.valueOf(this.itemId), Integer.valueOf(this.buyNum) }));
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\PGM_SetRoleBuyNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */