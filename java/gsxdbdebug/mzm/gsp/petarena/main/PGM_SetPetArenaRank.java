/*     */ package mzm.gsp.petarena.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gm.SGMMessageTipRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.petarena.confbean.SPetArenaConst;
/*     */ import mzm.gsp.petarena.event.PetArenaRankChanged;
/*     */ import mzm.gsp.petarena.event.PetArenaRankChangedArg;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import xbean.PetArenaRank;
/*     */ import xbean.PetArenaRankInfo;
/*     */ import xtable.Petarenarank;
/*     */ 
/*     */ public class PGM_SetPetArenaRank extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long gmRoleid;
/*     */   private final long roleid;
/*     */   private final int rank;
/*     */   
/*     */   public PGM_SetPetArenaRank(long gmRoleid, long roleid, int rank)
/*     */   {
/*  27 */     this.gmRoleid = gmRoleid;
/*  28 */     this.roleid = roleid;
/*  29 */     this.rank = rank;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (!PetArenaManager.isFunOpen())
/*     */     {
/*  37 */       notifyClient("开关未开启");
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     if (this.rank < 0)
/*     */     {
/*  43 */       notifyClient("rank不能小于0");
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (this.rank > SPetArenaConst.getInstance().ROBOT_NUM)
/*     */     {
/*  49 */       notifyClient("rank大于最大排名，如果想设置榜外，参数请输入0");
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     if (mzm.gsp.pet.main.PetFightInterface.getPetFightDefenseTeam(this.roleid, true) == null)
/*     */     {
/*  55 */       notifyClient("未设置防守小队");
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     long key = GameServerInfoManager.getLocalId();
/*  60 */     PetArenaRank xPetArenaRank = Petarenarank.get(Long.valueOf(key));
/*  61 */     if (xPetArenaRank == null)
/*     */     {
/*  63 */       notifyClient("服务器逻辑错误1");
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     List<PetArenaFightInfo> actives = new ArrayList();
/*  68 */     List<PetArenaFightInfo> passives = new ArrayList();
/*  69 */     Map<Long, Integer> damages = new HashMap();
/*     */     
/*  71 */     if (this.rank == 0)
/*     */     {
/*  73 */       Integer oldRank = (Integer)xPetArenaRank.getRoles().remove(Long.valueOf(this.roleid));
/*  74 */       if (oldRank == null)
/*     */       {
/*  76 */         notifyClient("角色未上榜");
/*  77 */         return false;
/*     */       }
/*     */       
/*  80 */       PetArenaRankInfo xPetArenaRankInfo = (PetArenaRankInfo)xPetArenaRank.getRanks().get(oldRank.intValue() - 1);
/*  81 */       if (xPetArenaRankInfo == null)
/*     */       {
/*  83 */         notifyClient("服务器逻辑错误2");
/*  84 */         return false;
/*     */       }
/*     */       
/*  87 */       xPetArenaRankInfo.setRoleid(0L);
/*  88 */       PetArenaRankManager.getInstance().removeRank(this.roleid);
/*  89 */       PetArenaRankManager.getInstance().setRank(oldRank.intValue(), new RankInfo(oldRank.intValue(), 0L));
/*  90 */       PetArenaChartManager.rank(new PetArenaChartObj(oldRank.intValue()));
/*     */       
/*     */ 
/*  93 */       PetArenaFightResultContext resultContext = new PetArenaFightResultContext(0L, damages, 0);
/*  94 */       PetArenaRankChangedArg arg = new PetArenaRankChangedArg(this.roleid, 0L, false, 0, oldRank.intValue(), -1, true, true, actives, passives, resultContext);
/*     */       
/*     */ 
/*  97 */       TriggerEventsManger.getInstance().triggerEvent(new PetArenaRankChanged(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */       
/*     */ 
/* 100 */       notifyClient("修改成功");
/* 101 */       return true;
/*     */     }
/*     */     
/* 104 */     PetArenaRankInfo xPetArenaRankInfo = (PetArenaRankInfo)xPetArenaRank.getRanks().get(this.rank - 1);
/* 105 */     if (xPetArenaRankInfo == null)
/*     */     {
/* 107 */       notifyClient("服务器逻辑错误3");
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     long oldRoleid = xPetArenaRankInfo.getRoleid();
/* 112 */     if (oldRoleid > 0L)
/*     */     {
/* 114 */       xPetArenaRank.getRoles().remove(Long.valueOf(oldRoleid));
/*     */       
/* 116 */       PetArenaFightResultContext resultContext = new PetArenaFightResultContext(0L, damages, 0);
/* 117 */       PetArenaRankChangedArg loseArg = new PetArenaRankChangedArg(oldRoleid, this.roleid, false, 1, this.rank, -1, true, false, actives, passives, resultContext);
/*     */       
/*     */ 
/* 120 */       TriggerEventsManger.getInstance().triggerEvent(new PetArenaRankChanged(), loseArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(oldRoleid)));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 125 */     xPetArenaRankInfo.setRoleid(this.roleid);
/* 126 */     Integer oldRank = (Integer)xPetArenaRank.getRoles().put(Long.valueOf(this.roleid), Integer.valueOf(this.rank));
/* 127 */     if (oldRank != null)
/*     */     {
/* 129 */       PetArenaRankInfo xOldPetArenaRankInfo = (PetArenaRankInfo)xPetArenaRank.getRanks().get(oldRank.intValue() - 1);
/* 130 */       xOldPetArenaRankInfo.setRoleid(0L);
/* 131 */       PetArenaRankManager.getInstance().setRank(oldRank.intValue(), new RankInfo(oldRank.intValue(), 0L));
/* 132 */       PetArenaChartManager.rank(new PetArenaChartObj(oldRank.intValue()));
/*     */     }
/* 134 */     PetArenaRankManager.getInstance().setRank(this.rank, new RankInfo(this.rank, this.roleid));
/*     */     
/* 136 */     PetArenaFightResultContext resultContext = new PetArenaFightResultContext(0L, damages, 0);
/* 137 */     PetArenaRankChangedArg arg = new PetArenaRankChangedArg(this.roleid, oldRoleid, true, 0, oldRank == null ? -1 : oldRank.intValue(), this.rank, true, true, actives, passives, resultContext);
/*     */     
/*     */ 
/*     */ 
/* 141 */     TriggerEventsManger.getInstance().triggerEvent(new PetArenaRankChanged(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/* 144 */     notifyClient("修改成功");
/* 145 */     return true;
/*     */   }
/*     */   
/*     */   private void notifyClient(String str)
/*     */   {
/* 150 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 151 */     messagetip.result = Integer.MAX_VALUE;
/* 152 */     messagetip.args.add(str);
/* 153 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PGM_SetPetArenaRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */