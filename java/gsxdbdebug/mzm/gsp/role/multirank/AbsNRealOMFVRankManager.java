/*     */ package mzm.gsp.role.multirank;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.main.NoneRealTimeRoleKeyRankManagerNew;
/*     */ import mzm.gsp.chart.main.RankAwardHandler;
/*     */ import mzm.gsp.chart.main.RankInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.NoneRealRoleMultiFightValueBean;
/*     */ import xbean.NoneRealTimeMultiFightValueRank;
/*     */ import xbean.NoneRealTimeOccMFVRankData;
/*     */ import xbean.NoneRealTimeOccMFVRankDataBackUp;
/*     */ import xbean.NoneRealTimeOccMFVRoleRankBackUp;
/*     */ import xbean.Pod;
/*     */ import xtable.Nonerealtimeoccmfvrank;
/*     */ import xtable.Nonerealtimeoccmfvrankbackup;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ public abstract class AbsNRealOMFVRankManager
/*     */   extends NoneRealTimeRoleKeyRankManagerNew<RoleMultiFightValueChart> implements RankAwardHandler
/*     */ {
/*     */   public AbsNRealOMFVRankManager(int var1, AbsOMFVRankManager var2)
/*     */   {
/*  36 */     super(var1, var2);
/*  37 */     RankInterface.registerRankAwardHandle(var1, this);
/*     */   }
/*     */   
/*     */   public void saveToDB() {
/*  41 */     setNewRankXData(getXRankDataIfAbsence());
/*     */   }
/*     */   
/*     */   private NoneRealTimeMultiFightValueRank getXRankDataIfAbsence() {
/*  45 */     NoneRealTimeOccMFVRankData var1 = Nonerealtimeoccmfvrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  46 */     if (var1 == null) {
/*  47 */       var1 = Pod.newNoneRealTimeOccMFVRankData();
/*  48 */       Nonerealtimeoccmfvrank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), var1);
/*     */     }
/*     */     
/*  51 */     NoneRealTimeMultiFightValueRank var2 = (NoneRealTimeMultiFightValueRank)var1.getOcc2rankdata().get(Integer.valueOf(getOccId()));
/*  52 */     if (var2 == null) {
/*  53 */       var2 = Pod.newNoneRealTimeMultiFightValueRank();
/*  54 */       var2.setAwardtime(DateTimeUtils.getCurrTimeInMillis());
/*  55 */       var1.getOcc2rankdata().put(Integer.valueOf(getOccId()), var2);
/*     */     }
/*     */     
/*  58 */     return var2;
/*     */   }
/*     */   
/*     */   private void setNewRankXData(NoneRealTimeMultiFightValueRank var1) {
/*  62 */     if (var1 == null) {
/*  63 */       GameServer.logger().error(String.format("[MFV]AbsNRealOMFVRankManager.setNewRankXData@ xNMFVRank is null!|occId=%d", new Object[] { Integer.valueOf(getOccId()) }));
/*     */     } else {
/*  65 */       var1.getRankdatas().clear();
/*  66 */       var1.getKeytorankchange().clear();
/*  67 */       var1.setSavetime(getSaveDbTime());
/*  68 */       Iterator var2 = getCacheRankDatas().iterator();
/*     */       
/*  70 */       while (var2.hasNext()) {
/*  71 */         RoleMultiFightValueChart var3 = (RoleMultiFightValueChart)var2.next();
/*  72 */         NoneRealRoleMultiFightValueBean var4 = Pod.newNoneRealRoleMultiFightValueBean();
/*  73 */         var4.setMultifightvalue(var3.getFightValue());
/*  74 */         var4.setRoleid(var3.getKey().longValue());
/*  75 */         var1.getRankdatas().add(var4);
/*     */       }
/*     */       
/*  78 */       var1.getKeytorankchange().putAll(getCacheRankChangeMap());
/*     */     }
/*     */   }
/*     */   
/*     */   public void initCachDataFromDb() {
/*  83 */     initCacheRankData(getXRankData());
/*     */   }
/*     */   
/*     */   private NoneRealTimeMultiFightValueRank getXRankData() {
/*  87 */     NoneRealTimeOccMFVRankData var1 = Nonerealtimeoccmfvrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  88 */     if (var1 == null) {
/*  89 */       GameServer.logger().warn(String.format("[MFV]AbsNRealOMFVRankManager.getXRankData@ xNOMFVData is null!", new Object[0]));
/*  90 */       return null;
/*     */     }
/*  92 */     NoneRealTimeMultiFightValueRank var2 = (NoneRealTimeMultiFightValueRank)var1.getOcc2rankdata().get(Integer.valueOf(getOccId()));
/*  93 */     if (var2 == null) {
/*  94 */       GameServer.logger().warn(String.format("[MFV]AbsNRealOMFVRankManager.getXRankData@ xNMFVRank is null!|occId=%d", new Object[] { Integer.valueOf(getOccId()) }));
/*  95 */       return null;
/*     */     }
/*  97 */     return var2;
/*     */   }
/*     */   
/*     */ 
/*     */   private void initCacheRankData(NoneRealTimeMultiFightValueRank var1)
/*     */   {
/* 103 */     if (var1 != null) {
/* 104 */       _initSaveDbTime(var1.getSavetime());
/* 105 */       ArrayList var2 = new ArrayList();
/* 106 */       Iterator var3 = var1.getRankdatas().iterator();
/*     */       
/* 108 */       while (var3.hasNext()) {
/* 109 */         NoneRealRoleMultiFightValueBean var4 = (NoneRealRoleMultiFightValueBean)var3.next();
/* 110 */         long var5 = var4.getRoleid();
/* 111 */         if (!MultiRankManager.canBeRanked(var5, getOccId())) {
/* 112 */           GameServer.logger().info(String.format("[occmfv]AbsNRealOMFVRankManager.initCacheRankData@ can not be ranked!|roleId=%d", new Object[] { Long.valueOf(var5) }));
/*     */         } else {
/* 114 */           int var7 = var4.getMultifightvalue();
/* 115 */           RoleMultiFightValueChart var8 = new RoleMultiFightValueChart(var5, var7, getOccId());
/* 116 */           var2.add(var8);
/*     */         }
/*     */       }
/*     */       
/* 120 */       _initCacheRankDatas(var2);
/* 121 */       _initCacheRankChangeMap(var1.getKeytorankchange());
/* 122 */       checkAward(var1);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addRankRoleForIDIP(long var1) {
/* 127 */     int var3 = MultiRankManager.getRoleMFValue(var1);
/* 128 */     int var4 = RoleInterface.getOccupationId(var1);
/* 129 */     rank(new RoleMultiFightValueChart(var1, var3, var4));
/*     */   }
/*     */   
/*     */   public void clearRoleRankData(long var1) {}
/*     */   
/*     */   public void doAward()
/*     */   {
/* 136 */     NoneRealTimeOccMFVRankData var1 = Nonerealtimeoccmfvrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 137 */     if (var1 != null) {
/* 138 */       int var2 = getOccId();
/* 139 */       NoneRealTimeMultiFightValueRank var3 = (NoneRealTimeMultiFightValueRank)var1.getOcc2rankdata().get(Integer.valueOf(var2));
/* 140 */       if (var3 != null) {
/* 141 */         checkAward(var3);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void checkAward(NoneRealTimeMultiFightValueRank var1) {
/* 147 */     long var2 = var1.getAwardtime();
/* 148 */     long var4 = DateTimeUtils.getCurrTimeInMillis();
/* 149 */     if (var2 <= 0L) {
/* 150 */       var1.setAwardtime(var4);
/*     */     } else {
/* 152 */       int var6 = getOccChartType();
/* 153 */       if (!isSendAward()) {
/* 154 */         GameServer.logger().error(String.format("[Role]AbsNRealOMFVRankManager.checkAward@can not award|chart_type=%d", new Object[] { Integer.valueOf(var6) }));
/* 155 */       } else if (!RankInterface.isInSameAwardTime(var2, var6)) {
/* 156 */         int var7 = RankInterface.getAwardRank(var6) + 1;
/* 157 */         int var8 = Math.min(var7, var1.getRankdatas().size());
/* 158 */         NoneRealTimeOccMFVRoleRankBackUp var9 = initAndClear(var6);
/*     */         
/* 160 */         for (int var10 = 0; var10 < var8; var10++) {
/* 161 */           NoneRealRoleMultiFightValueBean var11 = (NoneRealRoleMultiFightValueBean)var1.getRankdatas().get(var10);
/* 162 */           long var12 = var11.getRoleid();
/* 163 */           NoneRealTimeTaskManager.getInstance().addTask(new PAwardProcedure(var12, var10, var6));
/* 164 */           backup(var9, var11);
/* 165 */           GameServer.logger().info(String.format("[Role]AbsNRealOMFVRankManager.checkAward@do award rank|chart_type=%d|rank=%d|roleid=%d", new Object[] { Integer.valueOf(var6), Integer.valueOf(var7), Long.valueOf(var12) }));
/*     */         }
/*     */         
/* 168 */         var1.setAwardtime(var4);
/* 169 */         GameServer.logger().info(String.format("[Role]AbsNRealOMFVRankManager.checkAward@do award rank|rank=%d|chart_type=%d", new Object[] { Integer.valueOf(var7), Integer.valueOf(var6) }));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private NoneRealTimeOccMFVRoleRankBackUp initAndClear(int var1) {
/* 175 */     long var2 = GameServerInfoManager.getLocalId();
/* 176 */     NoneRealTimeOccMFVRankDataBackUp var4 = Nonerealtimeoccmfvrankbackup.get(Long.valueOf(var2));
/* 177 */     if (var4 == null) {
/* 178 */       var4 = Pod.newNoneRealTimeOccMFVRankDataBackUp();
/* 179 */       Nonerealtimeoccmfvrankbackup.insert(Long.valueOf(var2), var4);
/*     */     }
/*     */     
/* 182 */     NoneRealTimeOccMFVRoleRankBackUp var5 = (NoneRealTimeOccMFVRoleRankBackUp)var4.getRank_datas().get(Integer.valueOf(var1));
/* 183 */     if (var5 == null) {
/* 184 */       var5 = Pod.newNoneRealTimeOccMFVRoleRankBackUp();
/* 185 */       var4.getRank_datas().put(Integer.valueOf(var1), var5);
/*     */     }
/*     */     
/* 188 */     var5.getRole_datas().clear();
/* 189 */     return var5;
/*     */   }
/*     */   
/*     */   private void backup(NoneRealTimeOccMFVRoleRankBackUp var1, NoneRealRoleMultiFightValueBean var2) {
/* 193 */     if (var2 != null) {
/* 194 */       NoneRealRoleMultiFightValueBean var3 = Pod.newNoneRealRoleMultiFightValueBean();
/* 195 */       var3.setRoleid(var2.getRoleid());
/* 196 */       var3.setMultifightvalue(var2.getMultifightvalue());
/* 197 */       var1.getRole_datas().add(var3);
/*     */     }
/*     */   }
/*     */   
/*     */   abstract int getOccChartType();
/*     */   
/*     */   abstract int getOccId();
/*     */   
/*     */   abstract boolean isSendAward();
/*     */   
/*     */   static AbsNRealOMFVRankManager getNOMFVRankManagerByOccId(int var0) {
/* 208 */     switch (var0) {
/*     */     case 1: 
/* 210 */       return GuiWangNRealMFVManager.getInstance();
/*     */     case 2: 
/* 212 */       return QingYunNRealMFVManager.getInstance();
/*     */     case 3: 
/* 214 */       return TianYinNRealMFVManager.getInstance();
/*     */     case 4: 
/* 216 */       return FenXiangNRealMFVManager.getInstance();
/*     */     case 5: 
/* 218 */       return HeHuanNRealMFVManager.getInstance();
/*     */     case 6: 
/* 220 */       return ShengWuNRealMFVManager.getInstance();
/*     */     case 7: 
/* 222 */       return CangYuNRealMFVManager.getInstance();
/*     */     case 8: 
/* 224 */       return LingYinNRealMFVManager.getInstance();
/*     */     case 9: 
/* 226 */       return YiNengNRealMFVManager.getInstance();
/*     */     case 10: 
/* 228 */       return WanDuNRealMFVManager.getInstance();
/*     */     case 11: 
/* 230 */       return DanQingNRealMFVManager.getInstance();
/*     */     case 12: 
/* 232 */       return YinYangNRealMFVManager.getInstance();
/*     */     case 13: 
/* 234 */       return HuangJinNRealMFVManager.getInstance();
/*     */     case 14: 
/* 236 */       return ShenMuNRealMFVManager.getInstance();
/*     */     }
/* 238 */     return null;
/*     */   }
/*     */   
/*     */   public static int getOccRank(long var0)
/*     */   {
/* 243 */     int var2 = RoleInterface.getOccupationId(var0);
/* 244 */     AbsNRealOMFVRankManager var3 = getNOMFVRankManagerByOccId(var2);
/* 245 */     if (var3 == null) {
/* 246 */       GameServer.logger().error(String.format("[MFV]AbsNRealOMFVRankManager.getOccRank@ no role rankManager!|occupationId=%d", new Object[] { Integer.valueOf(var2) }));
/* 247 */       return 0;
/*     */     }
/* 249 */     return var3.getRank(Long.valueOf(var0)) + 1;
/*     */   }
/*     */   
/*     */   public static List<Long> getTopNRoleIds(int var0, int var1, int var2)
/*     */   {
/* 254 */     if (var1 <= 0) {
/* 255 */       return Collections.emptyList();
/*     */     }
/* 257 */     AbsNRealOMFVRankManager var3 = getNOMFVRankManagerByOccId(var0);
/* 258 */     if (var3 == null) {
/* 259 */       return Collections.emptyList();
/*     */     }
/* 261 */     ArrayList var4 = new ArrayList();
/* 262 */     Iterator var5 = var3.getCacheRankDatas().iterator();
/*     */     
/* 264 */     while (var5.hasNext()) {
/* 265 */       RoleMultiFightValueChart var6 = (RoleMultiFightValueChart)var5.next();
/* 266 */       long var7 = var6.getRoleid();
/* 267 */       if ((var2 == 0) || (RoleInterface.getGender(var7) == var2)) {
/* 268 */         var4.add(Long.valueOf(var7));
/* 269 */         if (var4.size() >= var1) {
/*     */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 275 */     return var4;
/*     */   }
/*     */   
/*     */ 
/*     */   static AbsNRealOMFVRankManager getNOMFVRankManagerByChartType(int var0)
/*     */   {
/* 281 */     return null;
/*     */   }
/*     */   
/*     */   private static class PAwardProcedure extends LogicProcedure {
/*     */     private final long roleid;
/*     */     private final int rank;
/*     */     private final int chartType;
/*     */     
/*     */     public PAwardProcedure(long roleid, int rank, int chartType) {
/* 290 */       this.roleid = roleid;
/* 291 */       this.rank = rank;
/* 292 */       this.chartType = chartType;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception {
/* 296 */       String userid = RoleInterface.getUserId(this.roleid);
/* 297 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 298 */       lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 299 */       RankInterface.sendChartAward(userid, this.roleid, this.chartType, this.rank);
/* 300 */       tlogRankAward(userid);
/* 301 */       return true;
/*     */     }
/*     */     
/*     */     private void tlogRankAward(String userid) {
/* 305 */       String vGameIP = GameServerInfoManager.getHostIP();
/* 306 */       int level = RoleInterface.getLevel(this.roleid);
/* 307 */       Object[] colums = { vGameIP, userid, Long.valueOf(this.roleid), Integer.valueOf(level), Integer.valueOf(this.chartType), Integer.valueOf(this.rank) };
/* 308 */       TLogManager.getInstance().addLog(this.roleid, "RoleOccMultiFightRankAwardInfo", colums);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\AbsNRealOMFVRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */