/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SUseChildrenCharaterItemErrorRes;
/*     */ import mzm.gsp.children.SUseChildrenCharaterItemRes;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.item.confbean.SChildrenCharacterItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdulthoodInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xtable.Children;
/*     */ 
/*     */ public class PCUseChildrenCharaterItemReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childrenid;
/*     */   private final int itemKey;
/*     */   
/*     */   public PCUseChildrenCharaterItemReq(long roleid, long childrenid, int itemkey)
/*     */   {
/*  25 */     this.roleid = roleid;
/*  26 */     this.childrenid = childrenid;
/*  27 */     this.itemKey = itemkey;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  32 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid)) {
/*  33 */       GameServer.logger().error(String.format("[Children]PCUseChildrenCharaterItemReq.processImp@function level is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  37 */       return false;
/*     */     }
/*  39 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(this.roleid)) {
/*  40 */       GameServer.logger().error(String.format("[Children]PCUseChildrenCharaterItemReq.processImp@function is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     if (!ChildrenManager.canOperChildInAdult(this.roleid, this.childrenid, true)) {
/*  47 */       GameServer.logger().error(String.format("[Children]PCUseChildrenCharaterItemReq.processImp@can not operate child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!ChildrenManager.checkOperChildInAdultStatus(this.roleid)) {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childrenid));
/*  60 */     if (xChildInfo == null) {
/*  61 */       GameServer.logger().error(String.format("[Children]PCUseChildrenCharaterItemReq.processImp@do not exist child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  66 */       return false;
/*     */     }
/*  68 */     int period = xChildInfo.getChild_period();
/*  69 */     if (period != 2) {
/*  70 */       GameServer.logger().error(String.format("[Children]PCUseChildrenCharaterItemReq.processImp@child period error|roleid=%d|childid=%d|period=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(period) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/*  84 */     if (xAdulthoodInfo.getOccupation() <= 0) {
/*  85 */       sendError(3);
/*  86 */       return false;
/*     */     }
/*  88 */     int oldCharacter = xAdulthoodInfo.getCharacter();
/*  89 */     if (SChildrenConsts.getInstance().child_grow_character_max <= oldCharacter) {
/*  90 */       sendError(1);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     BasicItem xBasicItem = ItemInterface.getItem(this.roleid, this.itemKey);
/*  95 */     if (xBasicItem == null) {
/*  96 */       sendError(3);
/*  97 */       return false;
/*     */     }
/*  99 */     int itemCfgid = xBasicItem.getCfgId();
/* 100 */     SChildrenCharacterItemCfg childrenCharacterItemCfg = SChildrenCharacterItemCfg.get(itemCfgid);
/* 101 */     if (childrenCharacterItemCfg == null) {
/* 102 */       sendError(3);
/* 103 */       return false;
/*     */     }
/* 105 */     boolean ret = ItemInterface.removeItemByGrid(this.roleid, 340600000, this.itemKey, 1, new mzm.gsp.tlog.TLogArg(LogReason.CHILDREN_ADULT_ADD_CHARACTER_COST));
/*     */     
/* 107 */     if (!ret) {
/* 108 */       sendError(3);
/* 109 */       return false;
/*     */     }
/* 111 */     ChildrenOutFightObj childrenOutFightObj = ChildrenManager.getChildrenOutFightObj(this.roleid, this.childrenid, xChildInfo);
/*     */     
/* 113 */     int character = childrenOutFightObj.addCharater(childrenCharacterItemCfg.addCharacter);
/* 114 */     childrenOutFightObj.updatePassiveSkill();
/* 115 */     childrenOutFightObj.synPropertyChange(this.roleid);
/*     */     
/* 117 */     SUseChildrenCharaterItemRes useCharaterItemRes = new SUseChildrenCharaterItemRes();
/* 118 */     useCharaterItemRes.character = character;
/* 119 */     useCharaterItemRes.childrenid = this.childrenid;
/* 120 */     useCharaterItemRes.itemkey = this.itemKey;
/* 121 */     OnlineManager.getInstance().send(this.roleid, useCharaterItemRes);
/*     */     
/* 123 */     ChildrenManager.tlogAdultGrow(this.roleid, this.childrenid, 3, 0, oldCharacter, character, childrenCharacterItemCfg.addCharacter);
/*     */     
/* 125 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error) {
/* 129 */     SUseChildrenCharaterItemErrorRes useChildrenCharaterItemErrorRes = new SUseChildrenCharaterItemErrorRes();
/* 130 */     useChildrenCharaterItemErrorRes.ret = error;
/* 131 */     OnlineManager.getInstance().sendAtOnce(this.roleid, useChildrenCharaterItemErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCUseChildrenCharaterItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */