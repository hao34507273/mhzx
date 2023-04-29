/*     */ package mzm.gsp.cake.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity4.confbean.SCakeActivityCfg;
/*     */ import mzm.gsp.activity4.confbean.STActivityCakeInfos;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CakeData;
/*     */ import xbean.CakeDetailData;
/*     */ import xbean.FactionCakeData;
/*     */ import xbean.GlobalCakeData;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAddCakeReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityId;
/*     */   private final int clientTurn;
/*     */   
/*     */   public PCAddCakeReq(long roleId, int activityId, int clientTurn)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.activityId = activityId;
/*  35 */     this.clientTurn = clientTurn;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     SCakeActivityCfg activityCfg = SCakeActivityCfg.get(this.activityId);
/*  42 */     if (activityCfg == null)
/*     */     {
/*  44 */       CakeManager.loggerError("PCAddCakeReq.processImp@ SCakeActivityCfg is null!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) });
/*     */       
/*  46 */       return false;
/*     */     }
/*  48 */     if (!OpenInterface.getOpenStatus(activityCfg.switchId))
/*     */     {
/*     */ 
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     String userId = RoleInterface.getUserId(this.roleId);
/*  55 */     lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*     */     
/*  57 */     CakeData xCakeData = CakeManager.getXCakeDataIfAbsent(this.roleId, this.activityId);
/*     */     
/*  59 */     long factionId = GangInterface.getGangId(this.roleId);
/*  60 */     if (factionId <= 0L)
/*     */     {
/*     */ 
/*  63 */       CakeManager.loggerError("PCAddCakeReq.processImp@ SCakeActivityCfg is null!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) });
/*     */       
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     FactionCakeData xFactionCakeData = CakeManager.getXFactionCakeData(factionId, this.activityId);
/*  69 */     if (!GangInterface.isGangMember(this.roleId, factionId))
/*     */     {
/*     */ 
/*  72 */       CakeManager.loggerError("PCAddCakeReq.processImp@ faction changed!|roleId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Long.valueOf(factionId) });
/*     */       
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     GlobalCakeData xGlobalCakeData = CakeManager.getXGlobalCakeData(this.activityId);
/*  78 */     if ((xGlobalCakeData == null) || (!xGlobalCakeData.getIsgoing()))
/*     */     {
/*     */ 
/*  81 */       CakeManager.loggerError("PCAddCakeReq.processImp@ not in activity time!|roleId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Long.valueOf(factionId) });
/*     */       
/*  83 */       return false;
/*     */     }
/*  85 */     if (xFactionCakeData.getCurturn() != this.clientTurn)
/*     */     {
/*     */ 
/*  88 */       CakeManager.sendCakeNotice(Arrays.asList(new Long[] { Long.valueOf(this.roleId) }), false, 1, new String[0]);
/*  89 */       return false;
/*     */     }
/*  91 */     if (xGlobalCakeData.getCurstage() != 3)
/*     */     {
/*     */ 
/*  94 */       CakeManager.loggerError("PCAddCakeReq.processImp@ not in cake time!|roleId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Long.valueOf(factionId) });
/*     */       
/*  96 */       return false;
/*     */     }
/*  98 */     if (GangInterface.getGangWorldId(factionId) != MapInterface.getRoleWorldInstanceId(this.roleId))
/*     */     {
/*     */ 
/* 101 */       CakeManager.loggerError("PCAddCakeReq.processImp@ not in own faction world!|roleId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Long.valueOf(factionId) });
/*     */       
/* 103 */       return false;
/*     */     }
/* 105 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId);
/* 106 */     if (!res.isCanJoin())
/*     */     {
/* 108 */       CakeManager.loggerError("PCAddCakeReq.processImp@ forbid join activity!|roleId=%d|activityId=%d|factionId=%d|res=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Long.valueOf(factionId), Integer.valueOf(res.getReasonValue()) });
/*     */       
/*     */ 
/* 111 */       return false;
/*     */     }
/* 113 */     if (xFactionCakeData.getRolecakes().get(Long.valueOf(this.roleId)) != null)
/*     */     {
/*     */ 
/* 116 */       CakeManager.loggerError("PCAddCakeReq.processImp@ already add!|roleId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Long.valueOf(factionId) });
/*     */       
/* 118 */       return false;
/*     */     }
/* 120 */     if (xGlobalCakeData.getCurturn() != xCakeData.getCurturn())
/*     */     {
/* 122 */       xCakeData.setCollectnum(0);
/*     */     }
/* 124 */     xCakeData.setCurturn(xGlobalCakeData.getCurturn());
/* 125 */     xCakeData.setCookothercount(0);
/* 126 */     xCakeData.setCookselfcount(0);
/* 127 */     xCakeData.setEffectfactionid(factionId);
/*     */     
/* 129 */     int orgCakeId = randomCakeId(activityCfg);
/* 130 */     if (orgCakeId <= 0)
/*     */     {
/*     */ 
/* 133 */       CakeManager.loggerError("PCAddCakeReq.processImp@ random cake rank error!|roleId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Long.valueOf(factionId) });
/*     */       
/* 135 */       return false;
/*     */     }
/* 137 */     CakeDetailData xCakeDetailData = xbean.Pod.newCakeDetailData();
/* 138 */     xCakeDetailData.setCakeid(orgCakeId);
/* 139 */     xCakeDetailData.setState(2);
/* 140 */     xFactionCakeData.getRolecakes().put(Long.valueOf(this.roleId), xCakeDetailData);
/*     */     
/* 142 */     if (!awardGift(userId, this.roleId, activityCfg))
/*     */     {
/* 144 */       return false;
/*     */     }
/*     */     
/* 147 */     CakeManager.synCakeStageChange(this.roleId, this.roleId, RoleInterface.getName(this.roleId), this.activityId, xCakeDetailData, 1, xFactionCakeData.getRolecakes().keySet(), factionId, 0, xGlobalCakeData.getCurturn());
/*     */     
/*     */ 
/*     */ 
/* 151 */     CakeManager.tlogAddCake(userId, this.roleId, this.activityId, factionId, orgCakeId);
/* 152 */     return true;
/*     */   }
/*     */   
/*     */   private boolean awardGift(String userId, long roleId, SCakeActivityCfg activityCfg)
/*     */   {
/* 157 */     AwardReason awardReason = new AwardReason(LogReason.AWARD_EAT_CAKE, this.activityId);
/* 158 */     if (AwardInterface.awardFixAward(getGiftFixAwardId(activityCfg), userId, roleId, false, true, awardReason) != null)
/*     */     {
/* 160 */       return true;
/*     */     }
/* 162 */     CakeManager.loggerError("PCAddCakeReq.awardGift@ award gift error!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(this.activityId) });
/* 163 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getGiftFixAwardId(SCakeActivityCfg activityCfg)
/*     */   {
/* 173 */     return activityCfg.giftFixAwardId;
/*     */   }
/*     */   
/*     */   int randomCakeId(SCakeActivityCfg activityCfg)
/*     */   {
/* 178 */     STActivityCakeInfos stInfos = STActivityCakeInfos.get(this.activityId);
/* 179 */     if (stInfos == null)
/*     */     {
/* 181 */       return -1;
/*     */     }
/* 183 */     int rank = CommonUtils.random(activityCfg.randomRangeFloorLimit, activityCfg.randomRangeTopLimit + 1);
/* 184 */     Integer cakeId = (Integer)stInfos.cakeInfos.get(Integer.valueOf(rank));
/* 185 */     return cakeId == null ? -1 : cakeId.intValue();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\PCAddCakeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */