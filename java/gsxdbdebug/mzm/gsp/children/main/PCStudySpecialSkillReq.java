/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SStudySpecialSkillErrorRes;
/*     */ import mzm.gsp.children.SStudySpecialSkillRes;
/*     */ import mzm.gsp.item.confbean.SChildrenSpecialSkillItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdulthoodInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xtable.Children;
/*     */ 
/*     */ public class PCStudySpecialSkillReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childrenid;
/*     */   private final int itemKey;
/*     */   
/*     */   public PCStudySpecialSkillReq(long roleid, long childrenid, int itemKey)
/*     */   {
/*  27 */     this.roleid = roleid;
/*  28 */     this.childrenid = childrenid;
/*  29 */     this.itemKey = itemKey;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  34 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid)) {
/*  35 */       GameServer.logger().error(String.format("[Children]PCStudySpecialSkillReq.processImp@function level is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  38 */       return false;
/*     */     }
/*  40 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(this.roleid)) {
/*  41 */       GameServer.logger().error(String.format("[Children]PCStudySpecialSkillReq.processImp@function is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!ChildrenManager.canOperChildInAdult(this.roleid, this.childrenid, true)) {
/*  48 */       GameServer.logger().error(String.format("[Children]PCStudySpecialSkillReq.processImp@can not operate child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
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
/*  61 */       GameServer.logger().error(String.format("[Children]PCStudySpecialSkillReq.processImp@do not exist child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*  65 */       return false;
/*     */     }
/*  67 */     int period = xChildInfo.getChild_period();
/*  68 */     if (period != 2) {
/*  69 */       GameServer.logger().error(String.format("[Children]PCStudySpecialSkillReq.processImp@child period error|roleid=%d|childid=%d|period=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(period) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     BasicItem basicItem = ItemInterface.getItem(this.roleid, this.itemKey);
/*  84 */     if (basicItem == null) {
/*  85 */       sendError(1);
/*  86 */       return false;
/*     */     }
/*  88 */     SChildrenSpecialSkillItemCfg specialSkillItemCfg = SChildrenSpecialSkillItemCfg.get(basicItem.getCfgId());
/*  89 */     if (specialSkillItemCfg == null) {
/*  90 */       sendError(1);
/*  91 */       return false;
/*     */     }
/*  93 */     if (specialSkillItemCfg.skillid == 0) {
/*  94 */       sendError(1);
/*  95 */       return false;
/*     */     }
/*  97 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/*  98 */     if (xAdulthoodInfo.getSpecialskillid() == specialSkillItemCfg.skillid) {
/*  99 */       sendError(2);
/* 100 */       return false;
/*     */     }
/* 102 */     int occupation = xAdulthoodInfo.getOccupation();
/* 103 */     if (occupation <= 0) {
/* 104 */       sendError(3);
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     if (!ItemInterface.removeItemByUuid(this.roleid, basicItem.getFirstUuid().longValue(), 1, new TLogArg(LogReason.CHILDREN_ADULT_STUDY_SPECIAL_SKILL)))
/*     */     {
/* 110 */       return false;
/*     */     }
/* 112 */     int replaceSkillid = xAdulthoodInfo.getSpecialskillid();
/* 113 */     xAdulthoodInfo.setSpecialskillid(specialSkillItemCfg.skillid);
/* 114 */     ChildrenOutFightObj outFightObj = ChildrenManager.getChildrenOutFightObj(this.roleid, this.childrenid, xChildInfo);
/* 115 */     outFightObj.updatePassiveSkill();
/* 116 */     outFightObj.synPropertyChange(this.roleid);
/* 117 */     SStudySpecialSkillRes specialSkillRes = new SStudySpecialSkillRes();
/* 118 */     specialSkillRes.childrenid = this.childrenid;
/* 119 */     specialSkillRes.itemkey = this.itemKey;
/* 120 */     specialSkillRes.skilid = specialSkillItemCfg.skillid;
/* 121 */     OnlineManager.getInstance().send(this.roleid, specialSkillRes);
/*     */     
/* 123 */     ChildrenManager.tlogAdultStudySkill(this.roleid, this.childrenid, 2, specialSkillItemCfg.skillid, replaceSkillid);
/*     */     
/*     */ 
/* 126 */     Map<Integer, Integer> intParameterMap = new HashMap();
/* 127 */     intParameterMap.put(Integer.valueOf(0), Integer.valueOf(replaceSkillid));
/* 128 */     intParameterMap.put(Integer.valueOf(1), Integer.valueOf(specialSkillItemCfg.skillid));
/* 129 */     ChildrenInterface.fillChildGrowthDiary(this.childrenid, intParameterMap, null, 21);
/*     */     
/*     */ 
/* 132 */     ChildrenManager.triggerChildRatingChange(this.roleid, this.childrenid, false);
/* 133 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error) {
/* 137 */     SStudySpecialSkillErrorRes errorRes = new SStudySpecialSkillErrorRes();
/* 138 */     errorRes.ret = error;
/* 139 */     OnlineManager.getInstance().sendAtOnce(this.roleid, errorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCStudySpecialSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */