/*     */ package mzm.gsp.partner.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.partner.confbean.PartnerConstants;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCImproveYuanShenReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int partnerId;
/*     */   private final int subIndex;
/*     */   private final int toLevel;
/*     */   private int oldYuanLv;
/*     */   
/*     */   public PCImproveYuanShenReq(long roleId, int partnerId, int subIndex, int toLevel)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.partnerId = partnerId;
/*  31 */     this.subIndex = subIndex;
/*  32 */     this.toLevel = toLevel;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (this.toLevel > PartnerConstants.getInstance().YUAN_LV_MAX)
/*     */     {
/*  40 */       GameServer.logger().error(String.format("[partner]PCImproveYuanShenReq.processImp@ to max lv!|roleId=%d|partnerId=%d|toLevel=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.partnerId), Integer.valueOf(this.toLevel) }));
/*     */       
/*     */ 
/*  43 */       return false;
/*     */     }
/*  45 */     lock(Lockeys.get(User.getTable(), RoleInterface.getUserId(this.roleId)));
/*  46 */     RolePartner rolePartner = PartnerManager.getRolePartner(this.roleId, true);
/*  47 */     Partner xPartner = rolePartner.getXPartner(this.partnerId);
/*  48 */     if (xPartner == null)
/*     */     {
/*  50 */       GameServer.logger().error(String.format("[partner]PCImproveYuanShenReq.processImp@ not own this partner!|roleId=%d|partnerId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.partnerId) }));
/*     */       
/*     */ 
/*  53 */       return false;
/*     */     }
/*  55 */     this.oldYuanLv = xPartner.getYuanLevel();
/*     */     
/*  57 */     if (!payLvUpPrice(xPartner))
/*     */     {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     int res = xPartner.setSubYuanLevel(this.subIndex, this.toLevel);
/*  63 */     switch (res)
/*     */     {
/*     */ 
/*     */     case -1: 
/*  67 */       return false;
/*     */     
/*     */     case -2: 
/*  70 */       return false;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*     */ 
/*  76 */     handMainYuanLvUp(xPartner);
/*     */     
/*  78 */     PartnerManager.onSinglePartnerProChange(this.roleId, xPartner);
/*  79 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean payLvUpPrice(Partner xPartner)
/*     */   {
/*  92 */     YuanCostInfo costInfo = xPartner.getPartnerCfg().getCostInfo(this.toLevel);
/*  93 */     if (costInfo == null)
/*     */     {
/*  95 */       GameServer.logger().error(String.format("[partner]PCImproveYuanShenReq.payLvUpPrice@ partner cost data null!|roleId=%d|partnerId=%d|toLv=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.partnerId), Integer.valueOf(this.toLevel) }));
/*     */       
/*     */ 
/*     */ 
/*  99 */       return false;
/*     */     }
/* 101 */     if (!ItemInterface.removeItemById(this.roleId, costInfo.getNeedItemId(), costInfo.getNum(), new TLogArg(LogReason.PARTNER_SUB_YUANSHEN_LV_UP_REM)))
/*     */     {
/*     */ 
/* 104 */       GameServer.logger().error(String.format("[partner]PCImproveYuanShenReq.payLvUpPrice@ not enough item!|roleId=%d|needItemId=%d|needItemNum=%d|ownItemNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(costInfo.getNeedItemId()), Integer.valueOf(costInfo.getNum()), Integer.valueOf(ItemInterface.getItemNumberById(this.roleId, costInfo.getNeedItemId())) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 109 */       return false;
/*     */     }
/* 111 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void handMainYuanLvUp(Partner xPartner)
/*     */   {
/* 121 */     if (this.oldYuanLv < xPartner.getYuanLevel())
/*     */     {
/* 123 */       xPartner.onYuanLevelChange(false);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PCImproveYuanShenReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */