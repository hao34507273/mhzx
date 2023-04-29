/*     */ package mzm.gsp.wing.main2;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.wing.confbean.STWingSkillLib;
/*     */ import mzm.gsp.wing.confbean.SWingInfoCfg;
/*     */ import mzm.gsp.wing.confbean.WingCfgConsts;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.WingPlan;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCSetTargetSkillReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   public static final int SET_TARGET = 1;
/*     */   public static final int UNSET_TARGET = 2;
/*     */   private final long roleId;
/*     */   private final int wingId;
/*     */   private final int index;
/*     */   private final int skill_id;
/*     */   private final int action_type;
/*     */   
/*     */   public static final PCSetTargetSkillReq newPCSetTargetSkillReq(long roleId, int wingId, int index, int skill_id)
/*     */   {
/*  45 */     return new PCSetTargetSkillReq(roleId, wingId, index, skill_id, 1);
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
/*     */   public static final PCSetTargetSkillReq newPCUnsetTargetSkillReq(long roleId, int wingId, int index)
/*     */   {
/*  58 */     return new PCSetTargetSkillReq(roleId, wingId, index, -1, 2);
/*     */   }
/*     */   
/*     */   private PCSetTargetSkillReq(long roleId, int wingId, int index, int skill_id, int action_type)
/*     */   {
/*  63 */     this.roleId = roleId;
/*  64 */     this.wingId = wingId;
/*  65 */     this.index = index;
/*  66 */     this.skill_id = skill_id;
/*  67 */     this.action_type = action_type;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  73 */     if (!isValid())
/*     */     {
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  79 */     String userid = RoleInterface.getUserId(this.roleId);
/*  80 */     lock(Lockeys.get(User.getTable(), userid));
/*  81 */     RoleWingInfo roleWingInfo = new RoleWingInfo(this.roleId, true);
/*  82 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/*  83 */     if (xWingPlan == null)
/*     */     {
/*  85 */       GameServer.logger().error(String.format("[wing]PCSetTargetSkillReq.processImp@ wing plan not open!|roleId=%d|plan=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1) }));
/*     */       
/*     */ 
/*  88 */       return false;
/*     */     }
/*  90 */     RoleWingPlan xPlan = new RoleWingPlan(this.roleId, 1, xWingPlan);
/*     */     
/*  92 */     if (!xPlan.hasWing(this.wingId))
/*     */     {
/*  94 */       GameServer.logger().error(String.format("[wing]PCSetTargetSkillReq.processImp@ not own this wing!|roleId=%d|plan=%d|wingId=%d|index=%d|skill_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), Integer.valueOf(this.index), Integer.valueOf(this.skill_id) }));
/*     */       
/*     */ 
/*     */ 
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     SWingInfoCfg cfg = SWingInfoCfg.get(this.wingId);
/* 102 */     if (cfg == null)
/*     */     {
/* 104 */       GameServer.logger().error(String.format("[wing]PCSetTargetSkillReq.processImp@ no wing cfg data!|roleId=%d|plan=%d|wingId=%d|index=%d|skill_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), Integer.valueOf(this.index), Integer.valueOf(this.skill_id) }));
/*     */       
/*     */ 
/*     */ 
/* 108 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 112 */     if (!checkParam(xPlan, cfg))
/*     */     {
/* 114 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 118 */     if (!setTargetSkill(xPlan, roleWingInfo.getEffectWingOccId()))
/*     */     {
/* 120 */       GameServer.logger().error(String.format("[wing]PCSetTargetSkillReq.processImp@ reset wing error!|roleId=%d|plan=%d|wingId=%d|index=%d|skill_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), Integer.valueOf(this.index), Integer.valueOf(this.skill_id) }));
/*     */       
/*     */ 
/*     */ 
/* 124 */       return false;
/*     */     }
/* 126 */     return true;
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
/*     */ 
/*     */ 
/*     */   private boolean setTargetSkill(RoleWingPlan xPlan, int effectOccId)
/*     */   {
/* 141 */     if (!xPlan.setTargetSkill(this.wingId, this.index, this.skill_id))
/*     */     {
/* 143 */       GameServer.logger().error(String.format("[wing]PCSetTargetSkillReq.processImp@setTargetSkill set target skill error!|roleId=%d|plan=%d|wingId=%d|index=%d|skill_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), Integer.valueOf(this.index), Integer.valueOf(this.skill_id) }));
/*     */       
/*     */ 
/*     */ 
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     if (this.action_type == 1)
/*     */     {
/* 152 */       WingManager.noticeWingSetTargetSkill(this.roleId, this.wingId, this.index, this.skill_id, effectOccId);
/*     */     }
/*     */     else
/*     */     {
/* 156 */       WingManager.noticeWingUnsetTargetSkill(this.roleId, this.wingId, this.index);
/*     */     }
/* 158 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isValid()
/*     */   {
/* 169 */     if (!WingManager.isWingSetTargetSkillSwitchOpenForRole(this.roleId))
/*     */     {
/* 171 */       return false;
/*     */     }
/*     */     
/* 174 */     if (RoleInterface.getLevel(this.roleId) < WingInterface.getMinRoleLvForWing())
/*     */     {
/* 176 */       WingManager.sendWingNotice(this.roleId, 8, new String[0]);
/* 177 */       return false;
/*     */     }
/*     */     
/* 180 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 286, true))
/*     */     {
/* 182 */       GameServer.logger().error(String.format("[wing]PCSetTargetSkillReq.canActiveResetInStatus@ active reset is forbiddened!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/* 185 */       return false;
/*     */     }
/*     */     
/* 188 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkParam(RoleWingPlan xPlan, SWingInfoCfg cfg)
/*     */   {
/* 204 */     if ((this.index <= 0) || (this.index > WingCfgConsts.getInstance().TARGET_SKILL_NUM))
/*     */     {
/* 206 */       WingManager.sendWingNotice(this.roleId, 14, new String[0]);
/*     */       
/* 208 */       String logStr = String.format("[wing]PCSetTargetSkillReq.processImp@checkParam index is illegal|roleid=%d|plan=%d|wingId=%d|max_num=%d|index=%d|skill_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), Integer.valueOf(WingCfgConsts.getInstance().TARGET_SKILL_NUM), Integer.valueOf(this.index), Integer.valueOf(this.skill_id) });
/*     */       
/*     */ 
/*     */ 
/* 212 */       GameServer.logger().error(logStr);
/*     */       
/* 214 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 218 */     if (this.action_type == 1)
/*     */     {
/*     */ 
/* 221 */       if (xPlan.getAllSkills().contains(Integer.valueOf(this.skill_id)))
/*     */       {
/* 223 */         WingManager.sendWingNotice(this.roleId, 15, new String[0]);
/*     */         
/* 225 */         String logStr = String.format("[wing]PCSetTargetSkillReq.processImp@checkParam skill_id is own|roleid=%d|plan=%d|wingId=%d|index=%d|skill_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), Integer.valueOf(this.index), Integer.valueOf(this.skill_id) });
/*     */         
/*     */ 
/*     */ 
/* 229 */         GameServer.logger().error(logStr);
/*     */         
/* 231 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 235 */       if (xPlan.getTargetSkills(this.wingId).contains(Integer.valueOf(this.skill_id)))
/*     */       {
/* 237 */         WingManager.sendWingNotice(this.roleId, 17, new String[0]);
/*     */         
/* 239 */         String logStr = String.format("[wing]PCSetTargetSkillReq.processImp@checkParam skill_id is setted|roleid=%d|plan=%d|wingId=%d|index=%d|skill_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), Integer.valueOf(this.index), Integer.valueOf(this.skill_id) });
/*     */         
/*     */ 
/*     */ 
/* 243 */         GameServer.logger().error(logStr);
/*     */         
/* 245 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 249 */       STWingSkillLib sLib = STWingSkillLib.get(cfg.resetSkillLib);
/* 250 */       if ((sLib == null) || (!sLib.skillInfos.keySet().contains(Integer.valueOf(this.skill_id))))
/*     */       {
/* 252 */         WingManager.sendWingNotice(this.roleId, 16, new String[0]);
/*     */         
/* 254 */         String logStr = String.format("[wing]PCSetTargetSkillReq.processImp@checkParam skill_id is illegal|roleid=%d|plan=%d|wingId=%d|index=%d|skill_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), Integer.valueOf(this.index), Integer.valueOf(this.skill_id) });
/*     */         
/*     */ 
/*     */ 
/* 258 */         GameServer.logger().error(logStr);
/*     */         
/* 260 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 264 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PCSetTargetSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */