/*     */ package mzm.gsp.shanghui.main;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.shanghui.SGetShangHuiItemCalParams;
/*     */ import mzm.gsp.shanghui.confbean.SRecommandPriceCfg;
/*     */ import mzm.gsp.shanghui.confbean.SShangHuiConsts;
/*     */ import mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.RoleShangHuiBean;
/*     */ import xbean.ShangHuiItem;
/*     */ import xtable.Role2shanghui;
/*     */ import xtable.Shanghui;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCGetShangHuiItemCalParams
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int itemId;
/*     */   
/*     */   public PCGetShangHuiItemCalParams(long roleId, int itemId)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.itemId = itemId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     SShangHuiItemToolsCfg itemCfg = ShanghuiManager.getShangHuiItemCfg(this.itemId);
/*  40 */     if (!canCheckItemCanBuyNum(itemCfg))
/*     */     {
/*     */ 
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     RoleShangHuiBean xRoleShangHuiBean = Role2shanghui.get(Long.valueOf(this.roleId));
/*  47 */     ShangHuiItem xShangHuiItem = Shanghui.get(Long.valueOf(GameServerInfoManager.toGlobalId(this.itemId)));
/*  48 */     if (xShangHuiItem == null)
/*     */     {
/*  50 */       ShanghuiManager.logDebug("PCGetShangHuiItemCalParams.processImp@shanghui xdb not have item|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId) });
/*     */       
/*  52 */       return false;
/*     */     }
/*  54 */     int recommandPrice = 0;
/*  55 */     if (itemCfg.isPriceFlow)
/*     */     {
/*  57 */       SRecommandPriceCfg recommandPriceCfg = ShanghuiManager.getRecommandCfg(this.itemId, ServerInterface.getCurrentServerLevel());
/*     */       
/*  59 */       if (recommandPriceCfg == null)
/*     */       {
/*  61 */         return false;
/*     */       }
/*  63 */       recommandPrice = recommandPriceCfg.recommandPrice;
/*     */     }
/*  65 */     OnlineManager.getInstance().send(this.roleId, new SGetShangHuiItemCalParams(this.itemId, itemCfg.dayBuyMaxNum - ShanghuiManager.getRoleAlreadyBuyItemNum(xRoleShangHuiBean, this.itemId), xShangHuiItem.getOrginalprice(), recommandPrice));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  70 */     return true;
/*     */   }
/*     */   
/*     */   private boolean canCheckItemCanBuyNum(SShangHuiItemToolsCfg itemCfg) throws UnsupportedEncodingException
/*     */   {
/*  75 */     if (itemCfg == null)
/*     */     {
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if (!ShanghuiManager.isShangHuiSwitchOpenForRole(this.roleId))
/*     */     {
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if (RoleInterface.getLevel(this.roleId) < SShangHuiConsts.getInstance().OPEN_LEVEL)
/*     */     {
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.SHANGHUI.value, this.itemId))
/*     */     {
/*  92 */       String itemName = ItemInterface.getItemName(this.itemId);
/*  93 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, itemName);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     if (!ShanghuiManager.isShangHuiOpenSubTypeItem(this.roleId, this.itemId))
/*     */     {
/*  99 */       ShanghuiManager.logDebug("PCGetShangHuiItemCanBuyNum.canCheckItemCanBuyNum@funtion not open!|roleid=%d|itemId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId) });
/*     */       
/* 101 */       return false;
/*     */     }
/* 103 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\PCGetShangHuiItemCalParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */