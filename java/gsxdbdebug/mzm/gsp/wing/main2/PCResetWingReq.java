/*     */ package mzm.gsp.wing.main2;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.wing.confbean.SWingInfoCfg;
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
/*     */ public class PCResetWingReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int wingId;
/*     */   private final byte resetType;
/*     */   private final long uuid;
/*     */   private final int num;
/*     */   private final long clientYuanBao;
/*     */   private final boolean isUseYuanbao;
/*     */   
/*     */   public PCResetWingReq(long roleId, int wingId, byte resetType, long uuid, int num, long yuanbao, byte isUseYuanbao)
/*     */   {
/*  42 */     this.roleId = roleId;
/*  43 */     this.wingId = wingId;
/*  44 */     this.resetType = resetType;
/*  45 */     this.uuid = uuid;
/*  46 */     this.num = num;
/*  47 */     this.clientYuanBao = yuanbao;
/*  48 */     this.isUseYuanbao = (isUseYuanbao == 1);
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  54 */     if (!isValid())
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  60 */     String userid = RoleInterface.getUserId(this.roleId);
/*  61 */     lock(Lockeys.get(User.getTable(), userid));
/*  62 */     RoleWingInfo roleWingInfo = new RoleWingInfo(this.roleId, true);
/*  63 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/*  64 */     if (xWingPlan == null)
/*     */     {
/*  66 */       GameServer.logger().error(String.format("[wing]PCAddWingRankReq.processImp@ wing plan not open!|roleId=%d|plan=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1) }));
/*     */       
/*     */ 
/*  69 */       return false;
/*     */     }
/*  71 */     RoleWingPlan xPlan = new RoleWingPlan(this.roleId, 1, xWingPlan);
/*     */     
/*  73 */     if (!xPlan.hasWing(this.wingId))
/*     */     {
/*  75 */       GameServer.logger().error(String.format("[wing]PCResetWingReq.processImp@ not own this wing!|roleId=%d|plan=%d|wingId=%d|type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), Byte.valueOf(this.resetType) }));
/*     */       
/*     */ 
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     SWingInfoCfg cfg = SWingInfoCfg.get(this.wingId);
/*  82 */     if (cfg == null)
/*     */     {
/*  84 */       GameServer.logger().error(String.format("[wing]PCResetWingReq.processImp@ no wing cfg data!|roleId=%d|plan=%d|wingId=%d|type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), Byte.valueOf(this.resetType) }));
/*     */       
/*     */ 
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     if (!payPrice(userid, cfg))
/*     */     {
/*  92 */       GameServer.logger().error(String.format("[wing]PCResetWingReq.processImp@ pay price error !|roleId=%d|plan=%d|wingId=%d|type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), Byte.valueOf(this.resetType) }));
/*     */       
/*     */ 
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     if (!reSetWing(xPlan, cfg, roleWingInfo.getEffectWingOccId()))
/*     */     {
/* 100 */       GameServer.logger().error(String.format("[wing]PCResetWingReq.processImp@ reset wing error!|roleId=%d|plan=%d|wingId=%d|type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), Byte.valueOf(this.resetType) }));
/*     */       
/*     */ 
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean payPrice(String userid, SWingInfoCfg cfg)
/*     */   {
/* 118 */     int itemId = -1;
/* 119 */     int num = -1;
/* 120 */     CostType costType = null;
/* 121 */     TLogArg tLogArg = null;
/* 122 */     if (this.resetType == 0)
/*     */     {
/* 124 */       itemId = cfg.resetProItemId;
/* 125 */       num = cfg.resetProItemNum;
/* 126 */       costType = CostType.COST_BIND_FIRST_WING_RESET_PROPERTY;
/* 127 */       tLogArg = new TLogArg(LogReason.WING_RESET_PROPERTY_REM);
/*     */     }
/*     */     else
/*     */     {
/* 131 */       itemId = cfg.resetSkillItemId;
/* 132 */       num = cfg.resetSkillItemNum;
/* 133 */       costType = CostType.COST_BIND_FIRST_WING_RESET_MAIN_SKILL;
/* 134 */       tLogArg = new TLogArg(LogReason.WING_RESET_SKILL_REM);
/*     */     }
/*     */     
/* 137 */     if (!WingManager.payPrice(userid, this.roleId, itemId, num, this.isUseYuanbao, this.clientYuanBao, costType, tLogArg))
/*     */     {
/* 139 */       GameServer.logger().error(String.format("[wing]PCAddWingRankReq.processImp@ pay error!|roleId=%d|plan=%d|type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Byte.valueOf(this.resetType) }));
/*     */       
/*     */ 
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean reSetWing(RoleWingPlan xPlan, SWingInfoCfg cfg, int effectOccId)
/*     */   {
/* 157 */     List<Integer> resetIds = new ArrayList();
/* 158 */     if (this.resetType == 0)
/*     */     {
/*     */ 
/* 161 */       if (!resetPros(xPlan, cfg, resetIds))
/*     */       {
/* 163 */         return false;
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 169 */     else if (!resetSkills(xPlan, cfg, resetIds))
/*     */     {
/* 171 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 175 */     WingManager.noticeResetWing(this.roleId, this.wingId, this.resetType, resetIds, effectOccId);
/* 176 */     return true;
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
/*     */   private boolean resetSkills(RoleWingPlan xPlan, SWingInfoCfg cfg, List<Integer> resetIds)
/*     */   {
/* 189 */     Set<Integer> allOwnSkills = new HashSet();
/* 190 */     Set<Integer> oldResetSkills = xPlan.getResetSkills(this.wingId);
/* 191 */     allOwnSkills.addAll(oldResetSkills);
/* 192 */     allOwnSkills.addAll(xPlan.getAllSkills());
/* 193 */     WingCfgManager.RanResult res = WingCfgManager.ranSkills(cfg.resetSkillLib, allOwnSkills, 2);
/* 194 */     if (!res.isSuc())
/*     */     {
/* 196 */       if (res.getRes() == WingCfgManager.RanRes.NOMORE_TO_RAN)
/*     */       {
/* 198 */         WingManager.sendWingNotice(this.roleId, 13, new String[0]);
/*     */       }
/* 200 */       return false;
/*     */     }
/* 202 */     resetIds.addAll(res.getRanSkills());
/* 203 */     if ((resetIds == null) || (resetIds.size() == 0))
/*     */     {
/* 205 */       GameServer.logger().error(String.format("[wing]PCResetWingReq.resetSkills@ ran skill error!|roleId=%d|plan=%d|wingId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId) }));
/*     */       
/*     */ 
/* 208 */       return false;
/*     */     }
/*     */     
/* 211 */     if (WingManager.isWingSkillGuaranteeSwitchOpenForRole(this.roleId))
/*     */     {
/* 213 */       if (xPlan.checkGuarantee(this.wingId, new HashSet(resetIds)))
/*     */       {
/* 215 */         res = WingCfgManager.ranTargetSkills(cfg.resetSkillLib, xPlan.getTargetSkills(this.wingId));
/* 216 */         if (res.isSuc())
/*     */         {
/* 218 */           resetIds.set(0, res.getRanSkills().get(0));
/*     */         }
/*     */       }
/*     */     }
/* 222 */     if (!xPlan.rpResetSkills(this.wingId, new HashSet(resetIds)))
/*     */     {
/* 224 */       GameServer.logger().error(String.format("[wing]PCResetWingReq.resetSkills@ rp reset skill error!|roleId=%d|plan=%d|wingId=%d|resetPros=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), resetIds.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 228 */       return false;
/*     */     }
/* 230 */     return true;
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
/*     */   private boolean resetPros(RoleWingPlan xPlan, SWingInfoCfg cfg, List<Integer> resetIds)
/*     */   {
/* 244 */     resetIds.addAll(WingCfgManager.ranProIds(cfg.resetProId, new HashSet()));
/* 245 */     if ((resetIds == null) || (resetIds.size() == 0))
/*     */     {
/* 247 */       GameServer.logger().error(String.format("[wing]PCResetWingReq.resetPros@ ran pro error!|roleId=%d|plan=%d|wingId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId) }));
/*     */       
/*     */ 
/* 250 */       return false;
/*     */     }
/* 252 */     if (!xPlan.rpResetPros(this.wingId, new HashSet(resetIds)))
/*     */     {
/* 254 */       GameServer.logger().error(String.format("[wing]PCResetWingReq.resetPros@ rp reset pros error!|roleId=%d|plan=%d|wingId=%d|resetPros=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), resetIds.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 258 */       return false;
/*     */     }
/* 260 */     return true;
/*     */   }
/*     */   
/*     */   boolean isValid()
/*     */   {
/* 265 */     if (!canActiveResetInStatus(this.roleId, this.resetType))
/*     */     {
/* 267 */       return false;
/*     */     }
/* 269 */     if (RoleInterface.getLevel(this.roleId) < WingInterface.getMinRoleLvForWing())
/*     */     {
/* 271 */       WingManager.sendWingNotice(this.roleId, 8, new String[0]);
/* 272 */       return false;
/*     */     }
/*     */     
/* 275 */     if (this.resetType == 0)
/*     */     {
/* 277 */       if (!WingManager.isWingPropertySwitchOpenForRole(this.roleId))
/*     */       {
/* 279 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 284 */     else if (!WingManager.isWingSkillSwitchOpenForRole(this.roleId))
/*     */     {
/* 286 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 290 */     return true;
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
/*     */   private boolean canActiveResetInStatus(long roleId, int resetType)
/*     */   {
/* 304 */     int state = 54;
/* 305 */     if (resetType == 0)
/*     */     {
/* 307 */       state = 55;
/*     */     }
/* 309 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, state, true))
/*     */     {
/* 311 */       GameServer.logger().error(String.format("[wing]PCResetWingReq.canActiveResetInStatus@ active reset is forbiddened!|roleId=%d|resetType=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(resetType) }));
/*     */       
/*     */ 
/*     */ 
/* 315 */       return false;
/*     */     }
/* 317 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PCResetWingReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */