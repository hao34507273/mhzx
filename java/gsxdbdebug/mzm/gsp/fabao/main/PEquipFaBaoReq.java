/*     */ package mzm.gsp.fabao.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.fabao.FaBaoChangeInfo;
/*     */ import mzm.gsp.fabao.SEquipFabaoErrorRes;
/*     */ import mzm.gsp.fabao.SSynFaBaoChangeInfo;
/*     */ import mzm.gsp.fabao.confbean.SFabaoConstants;
/*     */ import mzm.gsp.fabao.event.FabaoSysChangeArg;
/*     */ import mzm.gsp.item.ItemInfo;
/*     */ import mzm.gsp.item.confbean.SFabaoItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.FabaoItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import xbean.Item;
/*     */ import xbean.RoleFabaoSysInfo;
/*     */ 
/*     */ public class PEquipFaBaoReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int key;
/*     */   
/*     */   public PEquipFaBaoReq(long roleid, int key)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.key = key;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  36 */     if ((!OpenInterface.getOpenStatus(97)) || (OpenInterface.isBanPlay(this.roleid, 97)))
/*     */     {
/*  38 */       OpenInterface.sendBanPlayMsg(this.roleid, 97);
/*  39 */       return false;
/*     */     }
/*  41 */     if (FabaoManager.checkInCross(this.roleid)) {
/*  42 */       sendErrorRet(3);
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     BasicItem basicItem = ItemInterface.moveItemFromBag(this.roleid, 340600006, this.key);
/*  47 */     if (basicItem == null) {
/*  48 */       sendErrorRet(0);
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     SFabaoItem sFabaoItem = SFabaoItem.get(basicItem.getCfgId());
/*  53 */     if (sFabaoItem == null) {
/*  54 */       sendErrorRet(0);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (!(basicItem instanceof FabaoItem)) {
/*  59 */       sendErrorRet(2);
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     int level = mzm.gsp.role.main.RoleInterface.getLevel(this.roleid);
/*  64 */     if (level < SFabaoConstants.getInstance().FABAO_OPEN_LEVEL) {
/*  65 */       sendErrorRet(1);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.createIfNotExist(this.roleid);
/*  70 */     Item xItem = (Item)xRoleFabaoSysInfo.getFabaomap().remove(Integer.valueOf(sFabaoItem.faobaoType));
/*  71 */     if (xItem != null) {
/*  72 */       FabaoItem fabaoItem = new FabaoItem(xItem);
/*  73 */       long fabaoUUid = fabaoItem.getFirstUuid().longValue();
/*     */       
/*  75 */       ItemInterface.moveItemInBag(this.roleid, 340600006, fabaoItem);
/*  76 */       FabaoManager.tlogEquipFabao(this.roleid, 2, fabaoItem.getCfgId(), fabaoUUid, sFabaoItem.faobaoType);
/*     */     }
/*     */     
/*  79 */     xRoleFabaoSysInfo.getFabaomap().put(Integer.valueOf(sFabaoItem.faobaoType), basicItem.getItem());
/*     */     
/*     */ 
/*  82 */     ItemInfo itemInfo = new ItemInfo();
/*  83 */     ItemInterface.fillInItemInfoBean(itemInfo, basicItem.getItem());
/*  84 */     SSynFaBaoChangeInfo synFaBaoChangeInfo = new SSynFaBaoChangeInfo();
/*  85 */     synFaBaoChangeInfo.fabaochangeinfo.changed.put(Integer.valueOf(sFabaoItem.faobaoType), itemInfo);
/*  86 */     OnlineManager.getInstance().send(this.roleid, synFaBaoChangeInfo);
/*     */     
/*  88 */     Set<Integer> fabaotypes = new java.util.HashSet();
/*  89 */     fabaotypes.add(Integer.valueOf(sFabaoItem.faobaoType));
/*  90 */     FabaoSysChangeArg fabaoSysChangeArg = new FabaoSysChangeArg(this.roleid, fabaotypes);
/*  91 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.fabao.event.FabaoSysChange(), fabaoSysChangeArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/*     */ 
/*  95 */     int disFabaoType = xRoleFabaoSysInfo.getDisfabaotype();
/*  96 */     if ((disFabaoType <= 0) || (disFabaoType == sFabaoItem.faobaoType)) {
/*  97 */       FabaoManager.onFaBaoDisplayChange(this.roleid, xRoleFabaoSysInfo, sFabaoItem.id, sFabaoItem.faobaoType);
/*     */     }
/*  99 */     FabaoManager.tlogEquipFabao(this.roleid, 1, sFabaoItem.id, basicItem.getFirstUuid().longValue(), sFabaoItem.faobaoType);
/*     */     
/* 101 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrorRet(int errorCode) {
/* 105 */     SEquipFabaoErrorRes sEquipFabaoErrorRes = new SEquipFabaoErrorRes();
/* 106 */     sEquipFabaoErrorRes.errorcode = errorCode;
/* 107 */     OnlineManager.getInstance().sendAtOnce(this.roleid, sEquipFabaoErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PEquipFaBaoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */