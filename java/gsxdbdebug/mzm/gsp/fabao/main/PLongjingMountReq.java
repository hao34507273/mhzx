/*     */ package mzm.gsp.fabao.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.fabao.LongJingChangeInfo;
/*     */ import mzm.gsp.fabao.SLongjingMountErrorRes;
/*     */ import mzm.gsp.fabao.SLongjingMountSucRes;
/*     */ import mzm.gsp.fabao.SSynLongJingChangeInfo;
/*     */ import mzm.gsp.fabao.confbean.SFabaoConstants;
/*     */ import mzm.gsp.fabao.event.FabaoSysChangeArg;
/*     */ import mzm.gsp.item.ItemInfo;
/*     */ import mzm.gsp.item.confbean.SLongJingItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import xbean.Item;
/*     */ import xbean.LongJing;
/*     */ import xbean.RoleFabaoSysInfo;
/*     */ 
/*     */ public class PLongjingMountReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int itemKey;
/*     */   private final int pos;
/*     */   
/*     */   public PLongjingMountReq(long roleid, int itemkey, int pos)
/*     */   {
/*  32 */     this.roleId = roleid;
/*  33 */     this.itemKey = itemkey;
/*  34 */     this.pos = pos;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  39 */     if ((!OpenInterface.getOpenStatus(97)) || (OpenInterface.isBanPlay(this.roleId, 97)))
/*     */     {
/*  41 */       OpenInterface.sendBanPlayMsg(this.roleId, 97);
/*  42 */       return false;
/*     */     }
/*  44 */     if (FabaoManager.checkInCross(this.roleId)) {
/*  45 */       sendError(3);
/*  46 */       return false;
/*     */     }
/*  48 */     if ((this.pos > SFabaoConstants.getInstance().FABAO_MAX_HOLE) || (this.pos <= 0)) {
/*  49 */       sendError(2);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     BasicItem basicItem = ItemInterface.getAndRemoveFromBag(this.roleId, this.itemKey, 1);
/*  54 */     if (basicItem == null) {
/*  55 */       sendError(1);
/*  56 */       return false;
/*     */     }
/*  58 */     SLongJingItem sLongJingItem = SLongJingItem.get(basicItem.getCfgId());
/*  59 */     if (sLongJingItem == null) {
/*  60 */       sendError(1);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.createIfNotExist(this.roleId);
/*  65 */     LongJing xLongJing = (LongJing)xRoleFabaoSysInfo.getLongjingmap().get(Integer.valueOf(sLongJingItem.longjingtype));
/*  66 */     if (xLongJing != null) {
/*  67 */       Item xItem = (Item)xLongJing.getLongjingitems().remove(Integer.valueOf(this.pos));
/*  68 */       if (xItem != null) {
/*  69 */         BasicItem longjingItem = new BasicItem(xItem);
/*  70 */         long longjingUUId = longjingItem.getFirstUuid().longValue();
/*     */         
/*  72 */         ItemInterface.moveItemInBag(this.roleId, longjingItem, true);
/*  73 */         SLongJingItem equipedLongJingItem = SLongJingItem.get(longjingItem.getCfgId());
/*  74 */         FabaoManager.tlogEquipLongJing(this.roleId, 2, longjingItem.getCfgId(), longjingUUId, this.pos, equipedLongJingItem.longjingtype, equipedLongJingItem.lv);
/*     */       }
/*     */     }
/*     */     else {
/*  78 */       xLongJing = xbean.Pod.newLongJing();
/*  79 */       xRoleFabaoSysInfo.getLongjingmap().put(Integer.valueOf(sLongJingItem.longjingtype), xLongJing);
/*     */     }
/*     */     
/*  82 */     xLongJing.getLongjingitems().put(Integer.valueOf(this.pos), basicItem.getItem());
/*     */     
/*  84 */     SLongjingMountSucRes sLongjingMountSucRes = new SLongjingMountSucRes();
/*  85 */     sLongjingMountSucRes.itemid = sLongJingItem.id;
/*  86 */     sLongjingMountSucRes.pos = this.pos;
/*  87 */     OnlineManager.getInstance().send(this.roleId, sLongjingMountSucRes);
/*     */     
/*  89 */     SSynLongJingChangeInfo synLongJingChangeInfo = new SSynLongJingChangeInfo();
/*     */     
/*  91 */     LongJingChangeInfo longJingChangeInfo = new LongJingChangeInfo();
/*  92 */     ItemInfo iteminfo = new ItemInfo();
/*  93 */     ItemInterface.fillInItemInfoBean(iteminfo, basicItem.getItem());
/*  94 */     longJingChangeInfo.changed.put(Integer.valueOf(this.pos), iteminfo);
/*     */     
/*  96 */     synLongJingChangeInfo.longjingchangeinfo.changed.put(Integer.valueOf(sLongJingItem.longjingtype), longJingChangeInfo);
/*     */     
/*  98 */     OnlineManager.getInstance().send(this.roleId, synLongJingChangeInfo);
/*     */     
/*     */ 
/* 101 */     Map<Integer, List<Integer>> fabaoTypeToPos = new HashMap();
/* 102 */     List<Integer> posList = new java.util.ArrayList();
/* 103 */     posList.add(Integer.valueOf(this.pos));
/* 104 */     fabaoTypeToPos.put(Integer.valueOf(sLongJingItem.longjingtype), posList);
/* 105 */     FabaoSysChangeArg fabaoSysChangeArg = new FabaoSysChangeArg(this.roleId, fabaoTypeToPos);
/* 106 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.fabao.event.FabaoSysChange(), fabaoSysChangeArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/* 108 */     FabaoManager.tlogEquipLongJing(this.roleId, 1, sLongJingItem.id, basicItem.getFirstUuid().longValue(), this.pos, sLongJingItem.longjingtype, sLongJingItem.lv);
/*     */     
/* 110 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error) {
/* 114 */     SLongjingMountErrorRes longjingMountErrorRes = new SLongjingMountErrorRes();
/* 115 */     longjingMountErrorRes.resultcode = error;
/* 116 */     OnlineManager.getInstance().sendAtOnce(this.roleId, longjingMountErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PLongjingMountReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */