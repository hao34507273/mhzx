/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import mzm.gsp.item.SFixEquipmentRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PFixEquipment
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int desEquipBagId;
/*     */   private final int desEquipKey;
/*     */   
/*     */   public PFixEquipment(long roleId, int desEquipBagId, int desEquipKey)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.desEquipBagId = desEquipBagId;
/*  28 */     this.desEquipKey = desEquipKey;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!ItemModuleSwitchInterface.isEquipFixSwitchOpenForRole(this.roleId))
/*     */     {
/*  36 */       return false;
/*     */     }
/*  38 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleId))
/*     */     {
/*  40 */       String logStr = String.format("[item]PFixEquipment.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  41 */       ItemManager.logger.info(logStr);
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if ((this.desEquipBagId != 340600001) && (this.desEquipBagId != 340600000))
/*     */     {
/*  47 */       ItemManager.sendWrongInfo(this.roleId, 640, new String[0]);
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     return doFixEquipItem();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean doFixEquipItem()
/*     */   {
/*  62 */     RoleItemBag bag = ItemManager.getBag(this.roleId, this.desEquipBagId);
/*  63 */     if (bag == null)
/*     */     {
/*  65 */       ItemManager.sendWrongInfo(this.roleId, 640, new String[0]);
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  70 */     BasicItem desBasicItem = bag.get(this.desEquipKey);
/*  71 */     if ((desBasicItem == null) || (!(desBasicItem instanceof EquipmentItem)))
/*     */     {
/*  73 */       ItemManager.sendWrongInfo(this.roleId, 641, new String[0]);
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     EquipmentItem desEquipmentItem = (EquipmentItem)desBasicItem;
/*     */     
/*  79 */     int needSilver = desEquipmentItem.computeNeedSilver();
/*     */     
/*  81 */     if (needSilver <= 0)
/*     */     {
/*  83 */       ItemManager.sendWrongInfo(this.roleId, 643, new String[0]);
/*  84 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  88 */     TLogArg logArg = new TLogArg(LogReason.EQUIP_FIX_REM, desEquipmentItem.getCfgId());
/*     */     
/*  90 */     if (!RoleInterface.cutSilver(this.roleId, needSilver, logArg))
/*     */     {
/*  92 */       ItemManager.sendWrongInfo(this.roleId, 642, new String[0]);
/*  93 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  97 */     desEquipmentItem.fix();
/*     */     
/*  99 */     SFixEquipmentRes res = new SFixEquipmentRes();
/* 100 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 102 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PFixEquipment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */