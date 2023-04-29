/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SChildrenChangeOccupationErrorRes;
/*     */ import mzm.gsp.children.SChildrenChangeOccupationRes;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.confbean.SChildrenOccupationSkillCfg;
/*     */ import mzm.gsp.children.confbean.SChildrenOccupationSkillIndexCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.OccupationManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdulthoodInfo;
/*     */ import xbean.ChildInfo;
/*     */ 
/*     */ public class PCChildrenChangeOccupationReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childrenid;
/*     */   private final int occupation;
/*     */   
/*     */   public PCChildrenChangeOccupationReq(long roleid, long childrenid, int occupation)
/*     */   {
/*  32 */     this.roleid = roleid;
/*  33 */     this.childrenid = childrenid;
/*  34 */     this.occupation = occupation;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  39 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid)) {
/*  40 */       GameServer.logger().error(String.format("[Children]PCChildrenChangeOccupationReq.processImp@function level is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  44 */       return false;
/*     */     }
/*  46 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(this.roleid)) {
/*  47 */       GameServer.logger().error(String.format("[Children]PCChildrenChangeOccupationReq.processImp@function is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     if (!ChildrenManager.canOperChildInAdult(this.roleid, this.childrenid, true)) {
/*  54 */       GameServer.logger().error(String.format("[Children]PCChildrenChangeOccupationReq.processImp@can not operate child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     if (!ChildrenManager.checkOperChildInAdultStatus(this.roleid)) {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childrenid));
/*  67 */     if (xChildInfo == null) {
/*  68 */       GameServer.logger().error(String.format("[Children]PCChildrenChangeOccupationReq.processImp@do not exist child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  73 */       return false;
/*     */     }
/*  75 */     int period = xChildInfo.getChild_period();
/*  76 */     if (period != 2) {
/*  77 */       GameServer.logger().error(String.format("[Children]PCChildrenChangeOccupationReq.processImp@child period error|roleid=%d|childid=%d|period=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(period) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     boolean open = OccupationManager.isOccupationOpen(this.occupation, xChildInfo.getChild_gender());
/*  91 */     if (!open) {
/*  92 */       GameServer.logger().error(String.format("[Children]PCChildrenChangeOccupationReq.processImp@occupation error|roleid=%d|childid=%d|occupation=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.occupation) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  97 */       sendError(1);
/*  98 */       return false;
/*     */     }
/* 100 */     boolean occupationSwitchOpen = RoleInterface.isOccupationOpen(this.occupation);
/* 101 */     if (!occupationSwitchOpen) {
/* 102 */       GameServer.logger().error(String.format("[Children]PCChildrenSelectOccupationReq.processImp@occupation switch is not open|roleid=%d|childid=%d|occupation=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.occupation) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 107 */       return false;
/*     */     }
/* 109 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/* 110 */     int oldOccupation = xAdulthoodInfo.getOccupation();
/* 111 */     if (!OccupationManager.isExistOccupation(oldOccupation)) {
/* 112 */       GameServer.logger().error(String.format("[Children]PCChildrenChangeOccupationReq.processImp@do not select occupation|roleid=%d|childid=%d|occupation=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(oldOccupation) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 117 */       return false;
/*     */     }
/* 119 */     if (oldOccupation == this.occupation) {
/* 120 */       GameServer.logger().info(String.format("[Children]PCChildrenChangeOccupationReq.processImp@do not select the same occupation|roleid=%d|childid=%d|occupation=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.occupation) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 125 */       return false;
/*     */     }
/* 127 */     ChildrenOutFightObj childrenOutFightObj = ChildrenManager.getChildrenOutFightObj(this.roleid, this.childrenid, xChildInfo);
/*     */     
/* 129 */     if (childrenOutFightObj.isInFight()) {
/* 130 */       GameServer.logger().info(String.format("[Children]PCChildrenChangeOccupationReq.processImp@child is in fight|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 135 */       sendError(3);
/* 136 */       return false;
/*     */     }
/* 138 */     int cutValue = SChildrenConsts.getInstance().child_change_occcupation_cost;
/* 139 */     boolean ret = RoleInterface.cutGold(this.roleid, cutValue, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.CHILDREN_ADULT_CHANGE_OCCUPATION_COST, this.occupation));
/*     */     
/* 141 */     if (!ret) {
/* 142 */       sendError(2);
/* 143 */       return false;
/*     */     }
/* 145 */     xAdulthoodInfo.setOccupation(this.occupation);
/* 146 */     Set<Integer> afterFightSkills = new java.util.HashSet();
/* 147 */     for (Iterator i$ = xAdulthoodInfo.getFightskills().iterator(); i$.hasNext();) { int fightSkillid = ((Integer)i$.next()).intValue();
/* 148 */       int replaceSkillid = getReplaceSkillid(fightSkillid);
/* 149 */       if (replaceSkillid <= 0) {
/* 150 */         return false;
/*     */       }
/* 152 */       afterFightSkills.add(Integer.valueOf(replaceSkillid));
/*     */     }
/* 154 */     Map<Integer, Integer> afterSkill2LvMap = new HashMap();
/* 155 */     for (Map.Entry<Integer, Integer> entry : xAdulthoodInfo.getOccupationskill2value().entrySet()) {
/* 156 */       int replaceSkillid = getReplaceSkillid(((Integer)entry.getKey()).intValue());
/* 157 */       if (replaceSkillid <= 0) {
/* 158 */         return false;
/*     */       }
/* 160 */       afterSkill2LvMap.put(Integer.valueOf(replaceSkillid), entry.getValue());
/*     */     }
/* 162 */     String oldFightSkills = getComplexStr(xAdulthoodInfo.getFightskills());
/* 163 */     String newFightSkills = getComplexStr(afterFightSkills);
/* 164 */     String oldOccSkills = getComplexStr(xAdulthoodInfo.getOccupationskill2value().keySet());
/* 165 */     String oldOccSkillLvs = getComplexStr(xAdulthoodInfo.getOccupationskill2value().values());
/* 166 */     String newOccSkills = getComplexStr(afterSkill2LvMap.keySet());
/* 167 */     String newOccSkillLvs = getComplexStr(afterSkill2LvMap.values());
/* 168 */     ChildrenManager.tlogAdultChangeOccupation(this.roleid, this.childrenid, oldOccupation, this.occupation, oldFightSkills, newFightSkills, oldOccSkills, oldOccSkillLvs, newOccSkills, newOccSkillLvs);
/*     */     
/*     */ 
/*     */ 
/* 172 */     xAdulthoodInfo.getFightskills().clear();
/* 173 */     xAdulthoodInfo.getOccupationskill2value().clear();
/* 174 */     xAdulthoodInfo.getFightskills().addAll(afterFightSkills);
/* 175 */     xAdulthoodInfo.getOccupationskill2value().putAll(afterSkill2LvMap);
/* 176 */     SChildrenChangeOccupationRes changeOccupationRes = new SChildrenChangeOccupationRes();
/* 177 */     changeOccupationRes.childrenid = this.childrenid;
/* 178 */     changeOccupationRes.fightskills.addAll(xAdulthoodInfo.getFightskills());
/* 179 */     changeOccupationRes.occupation = this.occupation;
/* 180 */     changeOccupationRes.skill2lv.putAll(xAdulthoodInfo.getOccupationskill2value());
/* 181 */     OnlineManager.getInstance().send(this.roleid, changeOccupationRes);
/*     */     
/* 183 */     Map<Integer, Integer> intParameterMap = new HashMap();
/* 184 */     intParameterMap.put(Integer.valueOf(0), Integer.valueOf(oldOccupation));
/* 185 */     intParameterMap.put(Integer.valueOf(1), Integer.valueOf(this.occupation));
/* 186 */     ChildrenInterface.fillChildGrowthDiary(this.childrenid, intParameterMap, null, 22);
/*     */     
/* 188 */     return true;
/*     */   }
/*     */   
/*     */   private int getReplaceSkillid(int fightSkillid) {
/* 192 */     SChildrenOccupationSkillCfg occupationSkillCfg = SChildrenOccupationSkillCfg.get(fightSkillid);
/* 193 */     if (occupationSkillCfg == null) {
/* 194 */       GameServer.logger().error(String.format("[Children]PCChildrenChangeOccupationReq.processImp@skill cfg is not exist|roleid=%d|childid=%d|skillid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(fightSkillid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 199 */       return 0;
/*     */     }
/* 201 */     int index = occupationSkillCfg.skillIndex;
/* 202 */     SChildrenOccupationSkillIndexCfg skillIndexCfg = SChildrenOccupationSkillIndexCfg.get(this.occupation);
/* 203 */     if (skillIndexCfg == null) {
/* 204 */       GameServer.logger().error(String.format("[Children]PCChildrenChangeOccupationReq.processImp@skill index cfg is not exist|roleid=%d|childid=%d|occupation=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.occupation) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 209 */       return 0;
/*     */     }
/* 211 */     return ((Integer)skillIndexCfg.index2Skill.get(Integer.valueOf(index))).intValue();
/*     */   }
/*     */   
/*     */   private void sendError(int error) {
/* 215 */     SChildrenChangeOccupationErrorRes occupationErrorRes = new SChildrenChangeOccupationErrorRes();
/* 216 */     occupationErrorRes.ret = error;
/* 217 */     OnlineManager.getInstance().sendAtOnce(this.roleid, occupationErrorRes);
/*     */   }
/*     */   
/*     */   static <T> String getComplexStr(Collection<T> params) {
/* 221 */     if ((params == null) || (params.size() <= 0)) {
/* 222 */       return "";
/*     */     }
/* 224 */     StringBuilder stringBuilder = new StringBuilder();
/* 225 */     String splitString = ",";
/* 226 */     boolean first = true;
/* 227 */     for (T param : params) {
/* 228 */       if (!first) {
/* 229 */         stringBuilder.append(splitString);
/*     */       } else {
/* 231 */         first = false;
/*     */       }
/* 233 */       stringBuilder.append(param);
/*     */     }
/* 235 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCChildrenChangeOccupationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */