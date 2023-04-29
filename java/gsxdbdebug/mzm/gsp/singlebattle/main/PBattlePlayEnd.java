/*     */ package mzm.gsp.singlebattle.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.singlebattle.CampFinalInfo;
/*     */ import mzm.gsp.singlebattle.FightRecord;
/*     */ import mzm.gsp.singlebattle.RoleFinalInfo;
/*     */ import mzm.gsp.singlebattle.SSynBattleFinalInfo;
/*     */ import mzm.gsp.singlebattle.SSynBattleStage;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CampInfo;
/*     */ import xbean.GlobalSingleBattleData;
/*     */ import xbean.roleBattleData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PBattlePlayEnd
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long _battleId;
/*     */   private int winMvpAddPoint;
/*     */   private int loseMvpAddPoint;
/*     */   private int drowMvpAddPoint;
/*     */   private int winnerAddPoint;
/*     */   private int loserAddPoint;
/*     */   private int drawAddPoint;
/*     */   private int winCampId;
/*  35 */   private Map<Integer, Long> camp2mvp = new HashMap();
/*     */   
/*     */   public PBattlePlayEnd(long battleId)
/*     */   {
/*  39 */     this._battleId = battleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     GameServer.logger().info(String.format("[singlebattle]PBattlePlayEnd.processImp@ try enter clean up stage!|battleId=%d", new Object[] { Long.valueOf(this._battleId) }));
/*     */     
/*     */ 
/*  48 */     SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(this._battleId, true);
/*  49 */     if (globalInfo == null)
/*     */     {
/*  51 */       GameServer.logger().error(String.format("[singlebattle]PBattlePlayEnd.processImp@ no xGlobalInfo! |battleId=%d", new Object[] { Long.valueOf(this._battleId) }));
/*     */       
/*  53 */       return false;
/*     */     }
/*  55 */     this.winCampId = globalInfo.getWinnerCampId();
/*     */     
/*  57 */     if (globalInfo.getStage() == 4)
/*     */     {
/*     */ 
/*  60 */       GameServer.logger().error(String.format("[singlebattle]PBattlePlayEnd.processImp@ already cleaned!|battleId=%d", new Object[] { Long.valueOf(this._battleId) }));
/*     */       
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     GameServer.logger().info(String.format("[singlebattle]PBattlePlayEnd.processImp@ begin clean up!|battleId=%d", new Object[] { Long.valueOf(this._battleId) }));
/*     */     
/*     */ 
/*     */ 
/*  69 */     globalInfo.setStage(4);
/*     */     
/*  71 */     globalInfo.battleBro(new SSynBattleStage(4), true);
/*     */     
/*  73 */     this.winMvpAddPoint = globalInfo.getWinMvpAddPoint();
/*  74 */     this.loseMvpAddPoint = globalInfo.getLoseMvpAddPoint();
/*  75 */     this.winnerAddPoint = globalInfo.getWinnerAddPoint();
/*  76 */     this.loserAddPoint = globalInfo.getLoserAddPoint();
/*  77 */     this.drawAddPoint = globalInfo.getDrawAddPoint();
/*  78 */     this.drowMvpAddPoint = globalInfo.getDrawMvpAddPoint();
/*     */     
/*  80 */     SSynBattleFinalInfo res = new SSynBattleFinalInfo();
/*     */     
/*  82 */     res.battlecfgid = globalInfo.getBattleCfgId();
/*  83 */     res.wincampid = this.winCampId;
/*     */     
/*  85 */     GlobalSingleBattleData xBattleData = globalInfo.getxBattleData();
/*     */     
/*  87 */     for (Map.Entry<Integer, CampInfo> xEntry : xBattleData.getCampinfos().entrySet())
/*     */     {
/*  89 */       int campId = ((Integer)xEntry.getKey()).intValue();
/*  90 */       CampInfo xCampInfo = (CampInfo)xEntry.getValue();
/*     */       
/*  92 */       CampFinalInfo campFinalInfo = new CampFinalInfo();
/*  93 */       campFinalInfo.totalsource = xCampInfo.getSource();
/*     */       
/*  95 */       long mvpRoleId = -1L;
/*  96 */       int maxPoint = 0;
/*  97 */       for (Map.Entry<Long, roleBattleData> entry : xCampInfo.getRolebattledatas().entrySet())
/*     */       {
/*  99 */         long roleId = ((Long)entry.getKey()).longValue();
/* 100 */         if (((roleBattleData)entry.getValue()).getState() != 3)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 105 */           FightRecord fightRecord = globalInfo.getFightRecord(roleId);
/* 106 */           int point = getPoint(campId, ((roleBattleData)entry.getValue()).getPoint());
/* 107 */           campFinalInfo.rolefinalinfos.put(Long.valueOf(roleId), new RoleFinalInfo(point, fightRecord.killcount, fightRecord.diecount));
/*     */           
/* 109 */           if ((mvpRoleId <= 0L) || (maxPoint <= point))
/*     */           {
/* 111 */             mvpRoleId = roleId;
/* 112 */             maxPoint = point;
/*     */           }
/*     */         }
/*     */       }
/* 116 */       addMvpPoint(campId, campFinalInfo, mvpRoleId);
/*     */       
/* 118 */       res.campfinalinfos.put(Integer.valueOf(campId), campFinalInfo);
/*     */     }
/*     */     
/* 121 */     globalInfo.battleBro(res, false);
/*     */     
/* 123 */     globalInfo.setResult(this.winCampId, this.camp2mvp);
/*     */     
/* 125 */     SingleBattleManager.onStageChange(this._battleId, globalInfo.getBattleCfg(), 4);
/*     */     
/* 127 */     GameServer.logger().info(String.format("[singlebattle]PBattlePlayEnd.processImp@ over clean up!|battleId=%d", new Object[] { Long.valueOf(this._battleId) }));
/*     */     
/* 129 */     return true;
/*     */   }
/*     */   
/*     */   private int getPoint(int campId, int point)
/*     */   {
/* 134 */     if (this.winCampId == 0)
/*     */     {
/* 136 */       point += this.drawAddPoint;
/*     */ 
/*     */ 
/*     */     }
/* 140 */     else if (campId == this.winCampId)
/*     */     {
/* 142 */       point += this.winnerAddPoint;
/*     */     }
/*     */     else
/*     */     {
/* 146 */       point += this.loserAddPoint;
/*     */     }
/*     */     
/* 149 */     return point;
/*     */   }
/*     */   
/*     */   private void addMvpPoint(int campId, CampFinalInfo campFinalInfo, long mvpRoleId)
/*     */   {
/* 154 */     if (mvpRoleId <= 0L)
/*     */     {
/* 156 */       return;
/*     */     }
/* 158 */     this.camp2mvp.put(Integer.valueOf(campId), Long.valueOf(mvpRoleId));
/* 159 */     RoleFinalInfo roleFinalInfo = (RoleFinalInfo)campFinalInfo.rolefinalinfos.get(Long.valueOf(mvpRoleId));
/* 160 */     if (roleFinalInfo == null)
/*     */     {
/* 162 */       return;
/*     */     }
/* 164 */     roleFinalInfo.point += getMvpAddPoint(campId, mvpRoleId);
/*     */   }
/*     */   
/*     */   private int getMvpAddPoint(int campId, long mvpRoleId)
/*     */   {
/* 169 */     if (this.winCampId == 0)
/*     */     {
/* 171 */       return this.drowMvpAddPoint;
/*     */     }
/* 173 */     if (campId == this.winCampId)
/*     */     {
/* 175 */       return this.winMvpAddPoint;
/*     */     }
/* 177 */     return this.loseMvpAddPoint;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\PBattlePlayEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */