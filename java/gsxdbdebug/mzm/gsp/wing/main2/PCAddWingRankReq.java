/*     */ package mzm.gsp.wing.main2;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.wing.confbean.STRank2Levels;
/*     */ import mzm.gsp.wing.confbean.SWingRankCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.WingContent;
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
/*     */ public class PCAddWingRankReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long uuid;
/*     */   private final int num;
/*     */   private final long yuanBao;
/*     */   private final boolean useYuanbao;
/*  36 */   SWingRankCfg nextRankcfg = null;
/*     */   
/*     */   public PCAddWingRankReq(long roleId, long uuid, int num, long yuanBao, byte useYuanbao)
/*     */   {
/*  40 */     this.roleId = roleId;
/*  41 */     this.uuid = uuid;
/*  42 */     this.num = num;
/*  43 */     this.yuanBao = yuanBao;
/*  44 */     this.useYuanbao = (useYuanbao == 1);
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  50 */     if (!isValid())
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     String userid = RoleInterface.getUserId(this.roleId);
/*  57 */     lock(Lockeys.get(User.getTable(), userid));
/*  58 */     RoleWingInfo roleWingInfo = new RoleWingInfo(this.roleId, true);
/*  59 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/*  60 */     if (xWingPlan == null)
/*     */     {
/*  62 */       GameServer.logger().error(String.format("[wing]PCAddWingRankReq.processImp@ wing plan not open!|roleId=%d|plan=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1) }));
/*     */       
/*     */ 
/*  65 */       WingManager.sendWingNotice(this.roleId, 11, new String[0]);
/*  66 */       return false;
/*     */     }
/*  68 */     RoleWingPlan xPlan = new RoleWingPlan(this.roleId, 1, xWingPlan);
/*     */     
/*  70 */     int curRank = xWingPlan.getCurrank();
/*  71 */     int curLv = xWingPlan.getCurlv();
/*     */     
/*  73 */     if (!initAndCheck(curRank, curLv))
/*     */     {
/*  75 */       GameServer.logger().error(String.format("[wing]PCAddWingRankReq.processImp@ init error!|roleId=%d|plan=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1) }));
/*     */       
/*     */ 
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     if (!WingManager.payPrice(userid, this.roleId, this.nextRankcfg.needItemId, this.nextRankcfg.itemNum, this.useYuanbao, this.yuanBao, CostType.COST_BIND_FIRST_WING_PHASE_UP, new TLogArg(LogReason.WING_PHASE_UP_REM)))
/*     */     {
/*     */ 
/*  84 */       GameServer.logger().error(String.format("[wing]PCAddWingRankReq.processImp@ pay error!|roleId=%d|plan=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1) }));
/*     */       
/*     */ 
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     if (!WingManager.getNewWing(xPlan, this.nextRankcfg.wingInfoId))
/*     */     {
/*  92 */       GameServer.logger().error(String.format("[wing]PCAddWingRankReq.processImp@ get new wing error!|roleId=%d|plan=%d|wingId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.nextRankcfg.wingInfoId) }));
/*     */       
/*     */ 
/*  95 */       return false;
/*     */     }
/*  97 */     int newRank = curRank + 1;
/*  98 */     xWingPlan.setCurrank(newRank);
/*     */     
/*     */ 
/* 101 */     WingManager.addTransferOccupationWingRank(this.roleId, newRank);
/*     */     
/*     */ 
/* 104 */     WingManager.noticeRankUp(this.roleId, xPlan, this.nextRankcfg.wingInfoId, roleWingInfo.getEffectWingOccId());
/*     */     
/* 106 */     if (WingManager.isWingSetTargetSkillSwitchOpenForRole(this.roleId))
/*     */     {
/* 108 */       xPlan.checkTargetSkills(xPlan.getWingData(this.nextRankcfg.wingInfoId).getSkills());
/*     */     }
/* 110 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean initAndCheck(int curRank, int curLv)
/*     */   {
/* 122 */     if (curRank >= WingManager.getMaxRank())
/*     */     {
/* 124 */       GameServer.logger().error(String.format("[wing]PCAddWingRankReq.initAndCheck@ rank 2 max!|roleId=%d|plan=%d|curRank", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(curRank) }));
/*     */       
/*     */ 
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     this.nextRankcfg = SWingRankCfg.get(curRank + 1);
/* 131 */     if (this.nextRankcfg == null)
/*     */     {
/* 133 */       GameServer.logger().error(String.format("[wing]PCAddWingRankReq.initAndCheck@ next rank cfg is null!|roleId=%d|plan=%d|curRank", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(curRank) }));
/*     */       
/*     */ 
/* 136 */       return false;
/*     */     }
/*     */     
/* 139 */     if (!checkRoleLv(curRank, this.nextRankcfg.upNeedRoleLv, RoleInterface.getLevel(this.roleId)))
/*     */     {
/* 141 */       return false;
/*     */     }
/* 143 */     if (!checkWingLv(curRank, curLv))
/*     */     {
/* 145 */       return false;
/*     */     }
/* 147 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkRoleLv(int curRank, int needRoleLv, int roleLv)
/*     */   {
/* 152 */     if (roleLv < needRoleLv)
/*     */     {
/* 154 */       GameServer.logger().error(String.format("[wing]PCAddWingRankReq.checkRoleLv@ role lv not enough!|roleId=%d|plan=%d|needLv=%d|roleLv|curRank=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(needRoleLv), Integer.valueOf(roleLv), Integer.valueOf(curRank) }));
/*     */       
/*     */ 
/*     */ 
/* 158 */       WingManager.sendWingNotice(this.roleId, 8, new String[0]);
/* 159 */       return false;
/*     */     }
/* 161 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkWingLv(int curRank, int curLv)
/*     */   {
/* 166 */     STRank2Levels rankCfg = STRank2Levels.get(curRank + 1);
/* 167 */     if (rankCfg == null)
/*     */     {
/* 169 */       GameServer.logger().error(String.format("[wing]PCAddWingRankReq.checkWingLv@ next rank data is null!|roleId=%d|plan=%d|curRank=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(curRank) }));
/*     */       
/*     */ 
/* 172 */       return false;
/*     */     }
/* 174 */     List<Integer> needLvs = rankCfg.levels;
/* 175 */     int needMinLv = ((Integer)Collections.min(needLvs)).intValue();
/* 176 */     if (curLv < needMinLv)
/*     */     {
/* 178 */       GameServer.logger().error(String.format("[wing]PCAddWingRankReq.checkWingLv@ wing lv not enough!|roleId=%d|plan=%d|wingLv=%d|curRank=%d|needMinLv=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(curLv), Integer.valueOf(curRank), Integer.valueOf(needMinLv) }));
/*     */       
/*     */ 
/*     */ 
/* 182 */       WingManager.sendWingNotice(this.roleId, 9, new String[0]);
/* 183 */       return false;
/*     */     }
/* 185 */     return true;
/*     */   }
/*     */   
/*     */   boolean isValid()
/*     */   {
/* 190 */     if (!canActiveRankupInStatus(this.roleId))
/*     */     {
/* 192 */       return false;
/*     */     }
/* 194 */     if (RoleInterface.getLevel(this.roleId) < WingInterface.getMinRoleLvForWing())
/*     */     {
/* 196 */       WingManager.sendWingNotice(this.roleId, 8, new String[0]);
/* 197 */       return false;
/*     */     }
/*     */     
/* 200 */     if (!WingManager.isWingPhaseUpSwitchOpenForRole(this.roleId))
/*     */     {
/* 202 */       return false;
/*     */     }
/*     */     
/* 205 */     return true;
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
/*     */   private boolean canActiveRankupInStatus(long roleId)
/*     */   {
/* 219 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 52, true))
/*     */     {
/* 221 */       GameServer.logger().error(String.format("[wing]PCAddWingRankReq.canActiveRankupInStatus@ active rank up is forbiddened!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*     */ 
/* 225 */       return false;
/*     */     }
/* 227 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PCAddWingRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */