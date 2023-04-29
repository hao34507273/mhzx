/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*     */ import mzm.gsp.chart.main.NoneRealTimeNoneRoleKeyRankManagerNew;
/*     */ import mzm.gsp.chart.main.NoneRoleKeyRankManagerNew;
/*     */ import mzm.gsp.chart.main.RankInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.NoneRealTimePetYaoliBean;
/*     */ import xbean.NoneRealTimePetYaoliRank;
/*     */ import xbean.Pet;
/*     */ import xtable.Nonerealtimepetyaolirank;
/*     */ 
/*     */ public class NoneRealPetYaoLiRankManager extends NoneRealTimeNoneRoleKeyRankManagerNew<Long, PetYaoLiChart> implements mzm.gsp.chart.main.RankAwardHandler
/*     */ {
/*     */   private static NoneRealPetYaoLiRankManager instance;
/*     */   
/*     */   public static NoneRealPetYaoLiRankManager getInstance()
/*     */   {
/*  27 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   static void init()
/*     */   {
/*  33 */     if (instance != null) {
/*  34 */       return;
/*     */     }
/*  36 */     SChartSubTypeCfg chartSubTypeCfg = mzm.gsp.chart.main.ChartCfgManager.getChartSubTypeCfg(1);
/*  37 */     instance = new NoneRealPetYaoLiRankManager(chartSubTypeCfg.chartType, PetYaoLiChartRankManager.getInstance());
/*  38 */     RankInterface.registerRankAwardHandle(1, getInstance());
/*     */   }
/*     */   
/*     */   private NoneRealPetYaoLiRankManager(int chartType, NoneRoleKeyRankManagerNew<Long, PetYaoLiChart> rankManagerNew) {
/*  42 */     super(chartType, rankManagerNew);
/*     */   }
/*     */   
/*     */   public void saveToDB()
/*     */   {
/*  47 */     NoneRealTimePetYaoliRank noneRealTimePetYaoliRank = Nonerealtimepetyaolirank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  48 */     if (noneRealTimePetYaoliRank == null) {
/*  49 */       noneRealTimePetYaoliRank = xbean.Pod.newNoneRealTimePetYaoliRank();
/*  50 */       noneRealTimePetYaoliRank.setAwardtime(DateTimeUtils.getCurrTimeInMillis());
/*  51 */       Nonerealtimepetyaolirank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), noneRealTimePetYaoliRank);
/*     */     }
/*  53 */     noneRealTimePetYaoliRank.getRankdatas().clear();
/*  54 */     noneRealTimePetYaoliRank.getKeytorankchange().clear();
/*     */     
/*     */ 
/*     */ 
/*  58 */     noneRealTimePetYaoliRank.setSavetime(getSaveDbTime());
/*     */     
/*  60 */     for (PetYaoLiChart petYaoLiChart : getCacheRankDatas()) {
/*  61 */       NoneRealTimePetYaoliBean petYaoliBean = xbean.Pod.newNoneRealTimePetYaoliBean();
/*  62 */       petYaoliBean.setPetid(petYaoLiChart.getKey().longValue());
/*  63 */       petYaoliBean.setRoleid(petYaoLiChart.getRoleId());
/*  64 */       petYaoliBean.setPetyaoli(petYaoLiChart.getYaoLiValue());
/*  65 */       petYaoliBean.setChangeyaolitime(petYaoLiChart.getYaoLiTime());
/*  66 */       noneRealTimePetYaoliRank.getRankdatas().add(petYaoliBean);
/*     */     }
/*     */     
/*  69 */     noneRealTimePetYaoliRank.getKeytorankchange().putAll(getCacheRankChangeMap());
/*     */     
/*     */ 
/*  72 */     long awrdTime = noneRealTimePetYaoliRank.getAwardtime();
/*  73 */     if (awrdTime <= 0L)
/*     */     {
/*  75 */       noneRealTimePetYaoliRank.setAwardtime(DateTimeUtils.getCurrTimeInMillis());
/*     */     }
/*     */     else {
/*  78 */       checkAndAwarad(noneRealTimePetYaoliRank);
/*     */     }
/*     */   }
/*     */   
/*     */   private void checkAndAwarad(NoneRealTimePetYaoliRank noneRealTimePetYaoliRank) {
/*  83 */     long awardTime = noneRealTimePetYaoliRank.getAwardtime();
/*  84 */     boolean sameTime = RankInterface.isInSameAwardTime(awardTime, 1);
/*  85 */     if (!sameTime)
/*     */     {
/*     */ 
/*  88 */       if (mzm.gsp.open.main.OpenInterface.getOpenStatus(148))
/*     */       {
/*  90 */         int rank = RankInterface.getAwardRank(1);
/*  91 */         GameServer.logger().info(String.format("[Pet]NoneRealPetYaoLiRankManager.checkAndAwarad@do award rank|rank=%d", new Object[] { Integer.valueOf(rank) }));
/*  92 */         for (int i = 0; i <= rank; i++)
/*     */         {
/*  94 */           if (noneRealTimePetYaoliRank.getRankdatas().size() > i)
/*     */           {
/*  96 */             NoneRealTimePetYaoliBean xNoneRealTimePetYaoliBean = (NoneRealTimePetYaoliBean)noneRealTimePetYaoliRank.getRankdatas().get(i);
/*     */             
/*  98 */             long roleid = xNoneRealTimePetYaoliBean.getRoleid();
/*  99 */             NoneRealTimeTaskManager.getInstance().addTask(new AwardProcedure(roleid, i));
/*     */             
/* 101 */             GameServer.logger().info(String.format("[Pet]NoneRealTimeRoleLevelRankManager.checkAndAwarad@do award rank|rank=%d|roleid=%d", new Object[] { Integer.valueOf(rank), Long.valueOf(roleid) }));
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/* 106 */             GameServer.logger().info(String.format("[Pet]NoneRealTimeRoleLevelRankManager.checkAndAwarad@size less then award rank|rank=%d|size=%d", new Object[] { Integer.valueOf(rank), Integer.valueOf(noneRealTimePetYaoliRank.getRankdatas().size()) }));
/* 107 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 112 */       noneRealTimePetYaoliRank.setAwardtime(DateTimeUtils.getCurrTimeInMillis());
/*     */     }
/*     */     else
/*     */     {
/* 116 */       GameServer.logger().info(String.format("[Pet]NoneRealPetYaoLiRankManager.checkAndAwarad@do not open Award|awardTime=%d", new Object[] { Long.valueOf(awardTime) }));
/*     */     }
/*     */   }
/*     */   
/*     */   private static class AwardProcedure extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int rank;
/*     */     
/*     */     public AwardProcedure(long roleid, int rank)
/*     */     {
/* 127 */       this.roleid = roleid;
/* 128 */       this.rank = rank;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 134 */       String userid = RoleInterface.getUserId(this.roleid);
/* 135 */       lock(xtable.User.getTable(), Arrays.asList(new String[] { userid }));
/* 136 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 137 */       RankInterface.sendChartAward(userid, this.roleid, 1, this.rank);
/*     */       
/* 139 */       addTLog(this.roleid, "PetRankAward", new Object[] { Integer.valueOf(this.rank) });
/*     */       
/* 141 */       return true;
/*     */     }
/*     */     
/*     */     void addTLog(long roleid, String logName, Object... logColumns)
/*     */     {
/* 146 */       String vGameIp = GameServerInfoManager.getHostIP();
/* 147 */       int roleLevel = RoleInterface.getLevel(roleid);
/* 148 */       String userid = RoleInterface.getUserId(roleid);
/*     */       
/* 150 */       StringBuilder logStr = new StringBuilder();
/* 151 */       logStr.append(vGameIp);
/* 152 */       logStr.append("|").append(userid);
/* 153 */       logStr.append("|").append(roleid);
/* 154 */       logStr.append("|").append(roleLevel);
/*     */       
/* 156 */       for (Object colum : logColumns)
/*     */       {
/* 158 */         logStr.append("|").append(colum);
/*     */       }
/*     */       
/* 161 */       mzm.gsp.tlog.TLogManager.getInstance().addLog(roleid, logName, logStr.toString());
/*     */     }
/*     */   }
/*     */   
/*     */   public void initCachDataFromDb()
/*     */   {
/* 167 */     NoneRealTimePetYaoliRank noneRealTimePetYaoliRank = Nonerealtimepetyaolirank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 168 */     if (noneRealTimePetYaoliRank != null)
/*     */     {
/* 170 */       _initSaveDbTime(noneRealTimePetYaoliRank.getSavetime());
/* 171 */       List<PetYaoLiChart> petList = new java.util.ArrayList();
/* 172 */       for (NoneRealTimePetYaoliBean noneRealTimePetYaoliBean : noneRealTimePetYaoliRank.getRankdatas()) {
/* 173 */         PetYaoLiChart petYaoLiChart = new PetYaoLiChart(noneRealTimePetYaoliBean.getPetid(), noneRealTimePetYaoliBean.getRoleid(), noneRealTimePetYaoliBean.getPetyaoli(), noneRealTimePetYaoliBean.getChangeyaolitime());
/*     */         
/* 175 */         petList.add(petYaoLiChart);
/*     */       }
/*     */       
/* 178 */       _initCacheRankDatas(petList);
/*     */       
/* 180 */       _initCacheRankChangeMap(noneRealTimePetYaoliRank.getKeytorankchange());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void deletNoneRealTimeRank(long petID)
/*     */   {
/* 187 */     NoneRealTimePetYaoliRank noneRealTimePetYaoliRank = Nonerealtimepetyaolirank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 188 */     if (null != noneRealTimePetYaoliRank) {
/* 189 */       for (NoneRealTimePetYaoliBean noneRealTimePetYaoliBean : noneRealTimePetYaoliRank.getRankdatas()) {
/* 190 */         if (noneRealTimePetYaoliBean.getPetid() == petID) {
/* 191 */           noneRealTimePetYaoliRank.getRankdatas().remove(noneRealTimePetYaoliBean);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void addRankRoleForIDIP(long roleid) {
/* 198 */     PetBag petBag = PetInterface.getPetBag(roleid, false);
/* 199 */     if (petBag == null) {
/* 200 */       return;
/*     */     }
/* 202 */     for (Pet xPet : petBag.getAllPets().values()) {
/* 203 */       if (xPet != null) {
/* 204 */         PetYaoLiChart petYaoLiChart = new PetYaoLiChart(xPet.getId(), roleid, xPet.getYaoli(), xPet.getChangeyaolitime());
/* 205 */         rank(petYaoLiChart);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void clearRoleRankData(long roleid)
/*     */   {
/* 212 */     PetBag petBag = PetInterface.getPetBag(roleid, false);
/* 213 */     if (petBag == null) {
/* 214 */       return;
/*     */     }
/* 216 */     for (Pet xPet : petBag.getAllPets().values()) {
/* 217 */       if (xPet != null) {
/* 218 */         delete(Long.valueOf(xPet.getId()));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void doAward()
/*     */   {
/* 228 */     NoneRealTimePetYaoliRank xNoneRealTimePetYaoliRank = Nonerealtimepetyaolirank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 229 */     if (xNoneRealTimePetYaoliRank != null)
/*     */     {
/* 231 */       checkAndAwarad(xNoneRealTimePetYaoliRank);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\NoneRealPetYaoLiRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */