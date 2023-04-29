/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SStudyCommonSkillSkillErrorRes;
/*     */ import mzm.gsp.children.SStudyCommonSkillSkillRes;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.item.confbean.SPetSkillBookCfg;
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
/*     */ public class PCStudyCommonSkillReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childrenid;
/*     */   private final int itemKey;
/*     */   private final int pos;
/*     */   
/*     */   public PCStudyCommonSkillReq(long roleid, long childrenid, int itemKey, int pos)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.childrenid = childrenid;
/*  32 */     this.itemKey = itemKey;
/*  33 */     this.pos = pos;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  38 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid)) {
/*  39 */       GameServer.logger().error(String.format("[Children]PCStudyCommonSkillReq.processImp@function level is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  42 */       return false;
/*     */     }
/*  44 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(this.roleid)) {
/*  45 */       GameServer.logger().error(String.format("[Children]PCStudyCommonSkillReq.processImp@function is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!ChildrenManager.canOperChildInAdult(this.roleid, this.childrenid, true)) {
/*  51 */       GameServer.logger().error(String.format("[Children]PCStudyCommonSkillReq.processImp@can not operate child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (!ChildrenManager.checkOperChildInAdultStatus(this.roleid)) {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childrenid));
/*  63 */     if (xChildInfo == null) {
/*  64 */       GameServer.logger().error(String.format("[Children]PCStudyCommonSkillReq.processImp@do not exist child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*  67 */       return false;
/*     */     }
/*  69 */     int period = xChildInfo.getChild_period();
/*  70 */     if (period != 2) {
/*  71 */       GameServer.logger().error(String.format("[Children]PCStudyCommonSkillReq.processImp@child period error|roleid=%d|childid=%d|period=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(period) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     BasicItem basicItem = ItemInterface.getItem(this.roleid, this.itemKey);
/*  86 */     if (basicItem == null) {
/*  87 */       sendError(1);
/*  88 */       return false;
/*     */     }
/*  90 */     SPetSkillBookCfg skillBookCfg = SPetSkillBookCfg.get(basicItem.getCfgId());
/*  91 */     if (skillBookCfg == null) {
/*  92 */       sendError(1);
/*  93 */       return false;
/*     */     }
/*  95 */     if (skillBookCfg.skillId == 0) {
/*  96 */       sendError(1);
/*  97 */       return false;
/*     */     }
/*  99 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/* 100 */     if (xAdulthoodInfo.getSkillbookskills().contains(Integer.valueOf(skillBookCfg.skillId))) {
/* 101 */       sendError(3);
/* 102 */       return false;
/*     */     }
/* 104 */     int occupation = xAdulthoodInfo.getOccupation();
/* 105 */     if (occupation <= 0) {
/* 106 */       sendError(4);
/* 107 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 111 */     if (!ItemInterface.removeItemByUuid(this.roleid, basicItem.getFirstUuid().longValue(), 1, new TLogArg(LogReason.CHILDREN_ADULT_STUDY_COMMON_SKILL)))
/*     */     {
/* 113 */       sendError(1);
/* 114 */       return false;
/*     */     }
/* 116 */     int unLockPos = xAdulthoodInfo.getUnlockskillposnum();
/* 117 */     int totalPosSize = SChildrenConsts.getInstance().child_init_skill_pos_max + unLockPos;
/* 118 */     int nowSkillSize = xAdulthoodInfo.getSkillbookskills().size();
/* 119 */     if (this.pos < 0) {
/* 120 */       GameServer.logger().error(String.format("[Children]PCStudyCommonSkillReq.processImp@pos param error|roleid=%d|childid=%d|pos=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.pos) }));
/*     */       
/*     */ 
/*     */ 
/* 124 */       return false;
/*     */     }
/* 126 */     if (this.pos >= totalPosSize) {
/* 127 */       GameServer.logger().error(String.format("[Children]PCStudyCommonSkillReq.processImp@pos param error|roleid=%d|childid=%d|pos=%d|totalPos=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.pos), Integer.valueOf(totalPosSize) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 132 */       return false;
/*     */     }
/* 134 */     int replaceSkillid = 0;
/* 135 */     int retPos = 0;
/* 136 */     if (this.pos < nowSkillSize) {
/* 137 */       xAdulthoodInfo.getSkillbookskills().add(this.pos, Integer.valueOf(skillBookCfg.skillId));
/* 138 */       replaceSkillid = ((Integer)xAdulthoodInfo.getSkillbookskills().remove(this.pos + 1)).intValue();
/* 139 */       retPos = this.pos;
/*     */     }
/*     */     else {
/* 142 */       retPos = xAdulthoodInfo.getSkillbookskills().size();
/* 143 */       xAdulthoodInfo.getSkillbookskills().add(Integer.valueOf(skillBookCfg.skillId));
/*     */     }
/* 145 */     ChildrenOutFightObj outFightObj = ChildrenManager.getChildrenOutFightObj(this.roleid, this.childrenid, xChildInfo);
/* 146 */     outFightObj.updatePassiveSkill();
/* 147 */     outFightObj.synPropertyChange(this.roleid);
/* 148 */     SStudyCommonSkillSkillRes studyCommonSkillSkillRes = new SStudyCommonSkillSkillRes();
/* 149 */     studyCommonSkillSkillRes.childrenid = this.childrenid;
/* 150 */     studyCommonSkillSkillRes.itemkey = this.itemKey;
/* 151 */     studyCommonSkillSkillRes.skilid = skillBookCfg.skillId;
/* 152 */     studyCommonSkillSkillRes.replaceskillid = replaceSkillid;
/* 153 */     studyCommonSkillSkillRes.pos = retPos;
/* 154 */     OnlineManager.getInstance().send(this.roleid, studyCommonSkillSkillRes);
/*     */     
/* 156 */     ChildrenManager.tlogAdultStudySkill(this.roleid, this.childrenid, 1, skillBookCfg.skillId, replaceSkillid);
/*     */     
/*     */ 
/* 159 */     Map<Integer, Integer> intParameterMap = new HashMap();
/* 160 */     intParameterMap.put(Integer.valueOf(0), Integer.valueOf(replaceSkillid));
/* 161 */     intParameterMap.put(Integer.valueOf(1), Integer.valueOf(skillBookCfg.skillId));
/* 162 */     ChildrenInterface.fillChildGrowthDiary(this.childrenid, intParameterMap, null, 21);
/*     */     
/*     */ 
/* 165 */     ChildrenManager.triggerChildRatingChange(this.roleid, this.childrenid, false);
/* 166 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error) {
/* 170 */     SStudyCommonSkillSkillErrorRes errorRes = new SStudyCommonSkillSkillErrorRes();
/* 171 */     errorRes.ret = error;
/* 172 */     OnlineManager.getInstance().sendAtOnce(this.roleid, errorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCStudyCommonSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */