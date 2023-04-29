/*     */ package mzm.gsp.role.log;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.main.RankManagerNew;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleFightValueChart;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.multirank.RoleMultiFightValueChart;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LogRankData;
/*     */ import xbean.RecordData;
/*     */ import xbean.RoleRankData;
/*     */ import xtable.Logrolerank;
/*     */ 
/*     */ 
/*     */ public class PTLogXTypeRankData
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final int logRankType;
/*     */   private boolean needReset;
/*  33 */   private Map<Long, RoleLogInfo> rolesLogInfo = new HashMap();
/*     */   
/*     */   public PTLogXTypeRankData(int logRankType)
/*     */   {
/*  37 */     this.logRankType = logRankType;
/*  38 */     this.needReset = true;
/*     */   }
/*     */   
/*     */   public PTLogXTypeRankData(int logRankType, boolean needReset)
/*     */   {
/*  43 */     this.logRankType = logRankType;
/*  44 */     this.needReset = needReset;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  50 */     GameServer.logger().info(String.format("[logrank]PTLogXTypeRankData.processImp@ start log rank data!|logRankType=%d", new Object[] { Integer.valueOf(this.logRankType) }));
/*     */     
/*     */ 
/*  53 */     LogRankData xLogRankData = Logrolerank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  54 */     if (xLogRankData == null)
/*     */     {
/*  56 */       return false;
/*     */     }
/*  58 */     RecordData xRecordData = (RecordData)xLogRankData.getType2rankdata().get(Integer.valueOf(this.logRankType));
/*  59 */     if (xRecordData == null)
/*     */     {
/*  61 */       return false;
/*     */     }
/*  63 */     Map<Long, RoleRankData> xRankDatas = xRecordData.getRankdatas();
/*  64 */     if ((xRankDatas == null) || (xRankDatas.size() == 0))
/*     */     {
/*  66 */       return false;
/*     */     }
/*  68 */     List<Long> topNRoleIds = getTopN(xRankDatas, LogRankManager.getCfgTopNum());
/*  69 */     if ((topNRoleIds == null) || (topNRoleIds.size() == 0))
/*     */     {
/*  71 */       return false;
/*     */     }
/*  73 */     for (int index = 0; index < topNRoleIds.size(); index++)
/*     */     {
/*  75 */       long roleId = ((Long)topNRoleIds.get(index)).longValue();
/*  76 */       tlogRoleRankInfo(xRankDatas, roleId, index);
/*     */     }
/*  78 */     analyseTopNRolesData(topNRoleIds);
/*  79 */     if (!this.needReset)
/*     */     {
/*  81 */       return true;
/*     */     }
/*     */     
/*  84 */     xRankDatas.clear();
/*  85 */     xRecordData.setLastlogtime(DateTimeUtils.getCurrTimeInMillis());
/*  86 */     GameServer.logger().info(String.format("[logrank]PTLogXTypeRankData.processImp@ log rank data end!|logRankType=%d", new Object[] { Integer.valueOf(this.logRankType) }));
/*     */     
/*  88 */     return true;
/*     */   }
/*     */   
/*     */   void analyseTopNRolesData(List<Long> roleIds)
/*     */   {
/*  93 */     if ((roleIds == null) || (roleIds.size() == 0))
/*     */     {
/*  95 */       return;
/*     */     }
/*  97 */     for (int index = 0; index < roleIds.size(); index++)
/*     */     {
/*  99 */       checkSingleRole(getRoleLogInfo(roleIds, index - 1), getRoleLogInfo(roleIds, index + 1), getRoleLogInfo(roleIds, index));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void checkSingleRole(RoleLogInfo roleLogInfoBf, RoleLogInfo roleLogInfoAf, RoleLogInfo roleLogInfo)
/*     */   {
/* 106 */     if (roleLogInfo == null)
/*     */     {
/* 108 */       return;
/*     */     }
/* 110 */     if ((compareWithOther(roleLogInfo, roleLogInfoBf)) || (compareWithOther(roleLogInfo, roleLogInfoAf)))
/*     */     {
/* 112 */       String fatalStr = String.format("RoleRankAbnormal|role_info=%s|role_before_info=%s|role_after_info=%s", new Object[] { roleLogInfo.getRoleLogInfo(), roleLogInfoBf == null ? "NULL" : roleLogInfoBf.getRoleLogInfo(), roleLogInfoAf == null ? "NULL" : roleLogInfoAf.getRoleLogInfo() });
/*     */       
/*     */ 
/* 115 */       GameServer.surveillanceLogger().fatal(fatalStr);
/*     */       
/* 117 */       GameServer.logger().info(fatalStr);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean compareWithOther(RoleLogInfo roleLogInfo, RoleLogInfo roleLogInfo_other)
/*     */   {
/* 130 */     if (roleLogInfo == null)
/*     */     {
/* 132 */       return false;
/*     */     }
/* 134 */     if (roleLogInfo_other == null)
/*     */     {
/* 136 */       return false;
/*     */     }
/* 138 */     long balance = roleLogInfo.getBalance();
/* 139 */     long balance_other = roleLogInfo_other.getBalance();
/* 140 */     if (balance >= Math.round(balance_other * 0.1D))
/*     */     {
/* 142 */       return false;
/*     */     }
/* 144 */     return true;
/*     */   }
/*     */   
/*     */   private RoleLogInfo getRoleLogInfo(List<Long> roleIds, int index)
/*     */   {
/* 149 */     long roleId = getRoleId(roleIds, index);
/* 150 */     if (roleId <= 0L)
/*     */     {
/* 152 */       return null;
/*     */     }
/* 154 */     return (RoleLogInfo)this.rolesLogInfo.get(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */   private long getRoleId(List<Long> roleIds, int index)
/*     */   {
/* 159 */     long roleId = -1L;
/* 160 */     if ((index >= 0) && (index < roleIds.size()))
/*     */     {
/* 162 */       Long roleId_tmp = (Long)roleIds.get(index);
/* 163 */       roleId = roleId_tmp == null ? -1L : roleId_tmp.longValue();
/*     */     }
/* 165 */     return roleId;
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
/*     */   private void tlogRoleRankInfo(Map<Long, RoleRankData> xRankDatas, long roleId, int index)
/*     */   {
/* 178 */     RoleRankData xRoleRankData = (RoleRankData)xRankDatas.get(Long.valueOf(roleId));
/* 179 */     if (xRoleRankData == null)
/*     */     {
/* 181 */       return;
/*     */     }
/* 183 */     int maxValue = xRoleRankData.getMaxvalue();
/* 184 */     long logTime = xRoleRankData.getLogtime();
/*     */     
/* 186 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/* 188 */     Role role = RoleInterface.getRole(roleId, false);
/* 189 */     String userid = role.getUserId();
/* 190 */     int rolelevel = role.getLevel();
/* 191 */     int curFV = role.getFightValue();
/* 192 */     int curMFV = RoleInterface.getRoleMFValue(roleId);
/*     */     
/* 194 */     long balance = QingfuInterface.getBalance(userid, false);
/*     */     
/* 196 */     Object[] colums = { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(curFV), Integer.valueOf(curMFV), Long.valueOf(balance), Integer.valueOf(this.logRankType), Integer.valueOf(maxValue), Long.valueOf(logTime) };
/*     */     
/*     */ 
/* 199 */     TLogManager.getInstance().addLog(roleId, "RoleRankInfo", colums);
/*     */     
/* 201 */     this.rolesLogInfo.put(Long.valueOf(roleId), new RoleLogInfo(roleId, vGameIP, userid, maxValue, logTime, rolelevel, curFV, curMFV, balance, this.logRankType, index + 1));
/*     */   }
/*     */   
/*     */ 
/*     */   List<Long> getTopN(Map<Long, RoleRankData> xRankDatas, int max)
/*     */   {
/* 207 */     switch (this.logRankType)
/*     */     {
/*     */     case 2: 
/* 210 */       return getMFVTopN(xRankDatas, max);
/*     */     case 1: 
/* 212 */       return getFVTopN(xRankDatas, max);
/*     */     }
/*     */     
/*     */     
/* 216 */     return new ArrayList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Long> getMFVTopN(Map<Long, RoleRankData> xRankDatas, int max)
/*     */   {
/* 226 */     if (max <= 0)
/*     */     {
/* 228 */       return new ArrayList();
/*     */     }
/* 230 */     List<Long> roleIds = new ArrayList();
/* 231 */     RoleMFVRankManagerForLog logRank = new RoleMFVRankManagerForLog(Integer.MAX_VALUE, 0);
/* 232 */     Iterator<Map.Entry<Long, RoleRankData>> it = xRankDatas.entrySet().iterator();
/* 233 */     while (it.hasNext())
/*     */     {
/* 235 */       Map.Entry<Long, RoleRankData> entry = (Map.Entry)it.next();
/* 236 */       RoleMultiFightValueChart rankObj = new RoleMultiFightValueChart(((Long)entry.getKey()).longValue(), ((RoleRankData)entry.getValue()).getMaxvalue());
/* 237 */       logRank.rank(rankObj);
/*     */     }
/* 239 */     List<RoleMultiFightValueChart> tmpRoleIds = logRank.getAllChartObjs();
/* 240 */     int size = tmpRoleIds.size();
/* 241 */     int endNum = size - 1;
/* 242 */     if (max < size)
/*     */     {
/* 244 */       endNum = max - 1;
/*     */     }
/* 246 */     for (int i = 0; i <= endNum; i++)
/*     */     {
/* 248 */       roleIds.add(Long.valueOf(((RoleMultiFightValueChart)tmpRoleIds.get(i)).getRoleid()));
/*     */     }
/* 250 */     return roleIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private class RoleMFVRankManagerForLog
/*     */     extends RankManagerNew<Long, RoleMultiFightValueChart>
/*     */   {
/*     */     public RoleMFVRankManagerForLog(int capacity, int extraSize)
/*     */     {
/* 264 */       super(extraSize);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public void saveToDB() {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public void rankDataFromDB() {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Long> getFVTopN(Map<Long, RoleRankData> xRankDatas, int max)
/*     */   {
/* 286 */     List<Long> roleIds = new ArrayList();
/* 287 */     RoleFightRankManagerForLog logRank = new RoleFightRankManagerForLog(Integer.MAX_VALUE, 0);
/* 288 */     Iterator<Map.Entry<Long, RoleRankData>> it = xRankDatas.entrySet().iterator();
/* 289 */     while (it.hasNext())
/*     */     {
/* 291 */       Map.Entry<Long, RoleRankData> entry = (Map.Entry)it.next();
/* 292 */       RoleFightValueChart rankObj = new RoleFightValueChart(((Long)entry.getKey()).longValue(), ((RoleRankData)entry.getValue()).getMaxvalue());
/* 293 */       logRank.rank(rankObj);
/*     */     }
/* 295 */     List<RoleFightValueChart> tmpRoleIds = logRank.getAllChartObjs();
/* 296 */     int size = tmpRoleIds.size();
/* 297 */     int endNum = size - 1;
/* 298 */     if (max < size)
/*     */     {
/* 300 */       endNum = max - 1;
/*     */     }
/* 302 */     for (int i = 0; i <= endNum; i++)
/*     */     {
/* 304 */       roleIds.add(Long.valueOf(((RoleFightValueChart)tmpRoleIds.get(i)).getRoleid()));
/*     */     }
/* 306 */     return roleIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private class RoleFightRankManagerForLog
/*     */     extends RankManagerNew<Long, RoleFightValueChart>
/*     */   {
/*     */     public RoleFightRankManagerForLog(int capacity, int extraSize)
/*     */     {
/* 320 */       super(extraSize);
/*     */     }
/*     */     
/*     */     public void saveToDB() {}
/*     */     
/*     */     public void rankDataFromDB() {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\log\PTLogXTypeRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */