/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SFightSkillOperErrorRes;
/*     */ import mzm.gsp.children.SFightSkillOperRes;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.confbean.SChildrenOccupationSkillCfg;
/*     */ import mzm.gsp.children.event.ChildFightSkillChange;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdulthoodInfo;
/*     */ import xbean.ChildInfo;
/*     */ 
/*     */ public class PCFightSkillOperReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childrenid;
/*     */   private final int skillid;
/*     */   private boolean use;
/*     */   
/*     */   public PCFightSkillOperReq(long roleid, long childrenid, int skillid, int use)
/*     */   {
/*  24 */     this.roleid = roleid;
/*  25 */     this.childrenid = childrenid;
/*  26 */     this.skillid = skillid;
/*  27 */     this.use = (use == 1);
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  32 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid)) {
/*  33 */       GameServer.logger().error(String.format("[Children]PCFightSkillOperReq.processImp@function level is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  36 */       return false;
/*     */     }
/*  38 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(this.roleid)) {
/*  39 */       GameServer.logger().error(String.format("[Children]PCFightSkillOperReq.processImp@function is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!ChildrenManager.canOperChildInAdult(this.roleid, this.childrenid, true)) {
/*  45 */       GameServer.logger().error(String.format("[Children]PCFightSkillOperReq.processImp@can not operate child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*     */ 
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!ChildrenManager.checkOperChildInAdultStatus(this.roleid)) {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childrenid));
/*  57 */     if (xChildInfo == null) {
/*  58 */       GameServer.logger().error(String.format("[Children]PCFightSkillOperReq.processImp@do not exist child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid) }));
/*     */       
/*     */ 
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     int period = xChildInfo.getChild_period();
/*  70 */     if (period != 2) {
/*  71 */       GameServer.logger().error(String.format("[Children]PCFightSkillOperReq.processImp@child period error|roleid=%d|childid=%d|period=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(period) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  76 */       return false;
/*     */     }
/*  78 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/*  79 */     int occupation = xAdulthoodInfo.getOccupation();
/*  80 */     if (occupation <= 0) {
/*  81 */       sendError(3);
/*  82 */       return false;
/*     */     }
/*  84 */     SChildrenOccupationSkillCfg childrenOccupationSkillCfg = SChildrenOccupationSkillCfg.get(this.skillid);
/*  85 */     if (childrenOccupationSkillCfg == null) {
/*  86 */       GameServer.logger().error(String.format("[Children]PCFightSkillOperReq.processImp@skill error|roleid=%d|childid=%d|skillid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.skillid) }));
/*     */       
/*     */ 
/*     */ 
/*  90 */       sendError(1);
/*  91 */       return false;
/*     */     }
/*  93 */     if (childrenOccupationSkillCfg.occupation != occupation) {
/*  94 */       GameServer.logger().error(String.format("[Children]PCFightSkillOperReq.processImp@skill occupation error|roleid=%d|childid=%d|skillid=%d|occupation=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.skillid), Integer.valueOf(occupation) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  99 */       return false;
/*     */     }
/* 101 */     if (this.use) {
/* 102 */       if (xAdulthoodInfo.getFightskills().contains(Integer.valueOf(this.skillid))) {
/* 103 */         GameServer.logger().error(String.format("[Children]PCFightSkillOperReq.processImp@fight skill in use|roleid=%d|childid=%d|skillid=%d|occupation=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.skillid), Integer.valueOf(occupation) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 108 */         return false;
/*     */       }
/* 110 */       int useSkillSize = xAdulthoodInfo.getFightskills().size();
/* 111 */       if (useSkillSize >= SChildrenConsts.getInstance().child_fight_skill_max) {
/* 112 */         sendError(2);
/* 113 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 117 */       int minChildrenEquipsLevel = ChildrenManager.getChildrenEquipMinLevel(xAdulthoodInfo);
/* 118 */       int skillNeedEquipLevel = childrenOccupationSkillCfg.needEquipmentLevel;
/* 119 */       if (skillNeedEquipLevel > minChildrenEquipsLevel) {
/* 120 */         sendError(4);
/* 121 */         GameServer.logger().error(String.format("[Children]PCFightSkillOperReq.processImp@skill need unlock by equipment min level error|roleid=%d|childid=%d|skillid=%d|occupation=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.skillid), Integer.valueOf(occupation) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 126 */         return false;
/*     */       }
/*     */       
/* 129 */       if (useSkillSize + 1 >= 2) {
/* 130 */         int takeTwoSkillsNeedEquipLevel = SChildrenConsts.getInstance().child_take_twoskills_equipment_level;
/* 131 */         if (takeTwoSkillsNeedEquipLevel > minChildrenEquipsLevel) {
/* 132 */           sendError(5);
/* 133 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 137 */       xAdulthoodInfo.getFightskills().add(Integer.valueOf(this.skillid));
/*     */     } else {
/* 139 */       if (!xAdulthoodInfo.getFightskills().contains(Integer.valueOf(this.skillid))) {
/* 140 */         GameServer.logger().error(String.format("[Children]PCFightSkillOperReq.processImp@fight skill is not in use|roleid=%d|childid=%d|skillid=%d|occupation=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childrenid), Integer.valueOf(this.skillid), Integer.valueOf(occupation) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 145 */         return false;
/*     */       }
/* 147 */       xAdulthoodInfo.getFightskills().remove(Integer.valueOf(this.skillid));
/*     */     }
/* 149 */     SFightSkillOperRes fightSkillOperRes = new SFightSkillOperRes();
/* 150 */     fightSkillOperRes.childrenid = this.childrenid;
/* 151 */     fightSkillOperRes.skillid = this.skillid;
/* 152 */     if (this.use) {
/* 153 */       fightSkillOperRes.use = 1;
/*     */     } else {
/* 155 */       fightSkillOperRes.use = 2;
/*     */     }
/* 157 */     OnlineManager.getInstance().send(this.roleid, fightSkillOperRes);
/*     */     
/* 159 */     mzm.gsp.children.event.ChildFightSkillChangeArg childFightSkillChangeArg = new mzm.gsp.children.event.ChildFightSkillChangeArg(this.roleid, this.childrenid);
/* 160 */     ChildFightSkillChange childFightSkillChange = new ChildFightSkillChange();
/* 161 */     ChildrenManager.trigChildrenEvent(childFightSkillChange, childFightSkillChangeArg);
/*     */     
/* 163 */     GameServer.logger().info(String.format("[Children]PCFightSkillOperReq.processImp@fight skills|roleid=%d|fightSkills=%s|skillid=%d|use=%b", new Object[] { Long.valueOf(this.roleid), xAdulthoodInfo.getFightskills(), Integer.valueOf(this.skillid), Boolean.valueOf(this.use) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 168 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error) {
/* 172 */     SFightSkillOperErrorRes fightSkillOperErrorRes = new SFightSkillOperErrorRes();
/* 173 */     fightSkillOperErrorRes.ret = error;
/* 174 */     OnlineManager.getInstance().sendAtOnce(this.roleid, fightSkillOperErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCFightSkillOperReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */