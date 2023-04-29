/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SChildrenWearPetEquipErrorRes;
/*     */ import mzm.gsp.children.SChildrenWearPetEquipRes;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.petequip.confbean.SPetEquipItem;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdulthoodInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.Item;
/*     */ 
/*     */ public class PCChildrenWearPetEquipReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childrenid;
/*     */   private final int itemKey;
/*     */   
/*     */   public PCChildrenWearPetEquipReq(long roleid, long childrenid, int itemkey)
/*     */   {
/*  24 */     this.roleid = roleid;
/*  25 */     this.childrenid = childrenid;
/*  26 */     this.itemKey = itemkey;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  31 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid)) {
/*  32 */       GameServer.logger().error(String.format("[Children]PCChildrenWearPetEquipReq.processImp@function level is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  36 */       return false;
/*     */     }
/*  38 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(this.roleid)) {
/*  39 */       GameServer.logger().error(String.format("[Children]PCChildrenWearPetEquipReq.processImp@function is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!ChildrenManager.canOperChildInAdult(this.roleid, this.childrenid, true)) {
/*  46 */       GameServer.logger().error(String.format("[Children]PCChildrenWearPetEquipReq.processImp@can not operate child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (!ChildrenManager.checkOperChildInAdultStatus(this.roleid)) {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childrenid));
/*  59 */     if (xChildInfo == null) {
/*  60 */       GameServer.logger().error(String.format("[Children]PCChildrenWearPetEquipReq.processImp@do not exist child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     int period = xChildInfo.getChild_period();
/*  73 */     if (period != 2) {
/*  74 */       GameServer.logger().error(String.format("[Children]PCChildrenWearPetEquipReq.processImp@child period error|roleid=%d|childid=%d|period=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(period) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  79 */       return false;
/*     */     }
/*  81 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/*     */     
/*  83 */     BasicItem basicItem = ItemInterface.getItem(this.roleid, this.itemKey);
/*  84 */     if (basicItem == null) {
/*  85 */       sendError(1);
/*  86 */       return false;
/*     */     }
/*  88 */     int itemCfgid = basicItem.getCfgId();
/*  89 */     SPetEquipItem petEquipItemCfg = SPetEquipItem.get(itemCfgid);
/*  90 */     if (petEquipItemCfg == null) {
/*  91 */       sendError(2);
/*  92 */       return false;
/*     */     }
/*  94 */     if (petEquipItemCfg.equipType != 2) {
/*  95 */       sendError(2);
/*  96 */       return false;
/*     */     }
/*  98 */     Item xItemBean = basicItem.getItem().toBean();
/*  99 */     long firstUUid = basicItem.getTlogUuid();
/* 100 */     if (!ItemInterface.removeItemByGrid(this.roleid, 340600000, this.itemKey, 1, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.CHILDREN_ADULT_EQUIP_COST)))
/*     */     {
/* 102 */       sendError(1);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     xAdulthoodInfo.getEquippetitem().put(Integer.valueOf(petEquipItemCfg.equipType), xItemBean);
/*     */     
/* 108 */     ChildrenOutFightObj childrenOutFightObj = ChildrenManager.getChildrenOutFightObj(this.roleid, this.childrenid, xChildInfo);
/*     */     
/* 110 */     childrenOutFightObj.updateOutFightProperty();
/* 111 */     childrenOutFightObj.synPropertyChange(this.roleid);
/*     */     
/* 113 */     SChildrenWearPetEquipRes childrenWearPetEquipRes = new SChildrenWearPetEquipRes();
/* 114 */     childrenWearPetEquipRes.childrenid = this.childrenid;
/* 115 */     ItemInterface.fillInItemInfoBean(childrenWearPetEquipRes.iteminfo, xItemBean);
/* 116 */     OnlineManager.getInstance().send(this.roleid, childrenWearPetEquipRes);
/*     */     
/* 118 */     ChildrenManager.triggerChildRatingChange(this.roleid, this.childrenid, false);
/*     */     
/*     */ 
/* 121 */     ChildrenManager.tlogAdultWearPetEquip(this.roleid, this.childrenid, petEquipItemCfg.equipType, firstUUid, itemCfgid);
/* 122 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error) {
/* 126 */     SChildrenWearPetEquipErrorRes errorRes = new SChildrenWearPetEquipErrorRes();
/* 127 */     errorRes.ret = error;
/* 128 */     OnlineManager.getInstance().sendAtOnce(this.roleid, errorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCChildrenWearPetEquipReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */