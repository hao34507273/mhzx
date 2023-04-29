/*     */ package mzm.gsp.genius.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.genius.SSavePlanFailed;
/*     */ import mzm.gsp.genius.SSavePlanSuccess;
/*     */ import mzm.gsp.genius.confbean.PreviousGeniusCfg;
/*     */ import mzm.gsp.genius.confbean.SGeniusCfg;
/*     */ import mzm.gsp.genius.confbean.SGeniusConst;
/*     */ import mzm.gsp.genius.confbean.SGeniusSeriesCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GeniusInfo;
/*     */ import xbean.GeniusSeries;
/*     */ import xbean.GeniusSeriesInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCSavePlan extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int geniusSeriesCfgid;
/*     */   private final HashMap<Integer, Integer> skills;
/*     */   
/*     */   public PCSavePlan(long roleid, int geniusSeriesCfgid, HashMap<Integer, Integer> skills)
/*     */   {
/*  32 */     this.roleid = roleid;
/*  33 */     this.geniusSeriesCfgid = geniusSeriesCfgid;
/*  34 */     this.skills = skills;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (this.geniusSeriesCfgid <= 0)
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (this.skills.isEmpty())
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!GeniusManager.canDoAction(this.roleid, 1072, false))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!GeniusManager.isFunOpen(this.roleid))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     int level = RoleInterface.getLevel(this.roleid);
/*  62 */     if (level < SGeniusConst.getInstance().OPEN_LEVEL)
/*     */     {
/*  64 */       onFailed(4);
/*  65 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  69 */     int ocpid = RoleInterface.getOccupationId(this.roleid);
/*  70 */     SGeniusSeriesCfg geniusSeriesCfg = SGeniusSeriesCfg.get(ocpid);
/*  71 */     if (geniusSeriesCfg == null)
/*     */     {
/*  73 */       Map<String, Object> extras = new HashMap();
/*  74 */       extras.put("occupationid", Integer.valueOf(ocpid));
/*  75 */       onFailed(3, extras);
/*  76 */       return false;
/*     */     }
/*  78 */     if (geniusSeriesCfg.series.get(Integer.valueOf(this.geniusSeriesCfgid)) == null)
/*     */     {
/*  80 */       Map<String, Object> extras = new HashMap();
/*  81 */       extras.put("occupationid", Integer.valueOf(ocpid));
/*  82 */       onFailed(3, extras);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     String userid = RoleInterface.getUserId(this.roleid);
/*  87 */     if (userid == null)
/*     */     {
/*  89 */       onFailed(2);
/*  90 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  94 */     lock(Lockeys.get(User.getTable(), userid));
/*  95 */     GeniusInfo xGeniusInfo = GeniusManager.getAndInitGeniusInfo(this.roleid);
/*  96 */     int extraPoint = xGeniusInfo.getExtra_point();
/*     */     
/*  98 */     GeniusSeries xGeniusSeries = GeniusManager.getGeniusSeries(this.roleid, ocpid);
/*  99 */     if (xGeniusSeries == null)
/*     */     {
/* 101 */       Map<String, Object> extras = new HashMap();
/* 102 */       extras.put("occupationid", Integer.valueOf(ocpid));
/* 103 */       onFailed(1, extras);
/* 104 */       return false;
/*     */     }
/* 106 */     GeniusSeriesInfo xGeniusSeriesInfo = (GeniusSeriesInfo)xGeniusSeries.getSeries().get(Integer.valueOf(this.geniusSeriesCfgid));
/* 107 */     if (xGeniusSeriesInfo == null)
/*     */     {
/* 109 */       xGeniusSeriesInfo = xbean.Pod.newGeniusSeriesInfo();
/* 110 */       xGeniusSeries.getSeries().put(Integer.valueOf(this.geniusSeriesCfgid), xGeniusSeriesInfo);
/*     */     }
/*     */     
/* 113 */     int canUsePoint = GeniusManager.getCurGeniousPoint(this.roleid) + extraPoint;
/* 114 */     int maxPoint = SGeniusConst.getInstance().MAX_POINT;
/* 115 */     if (canUsePoint > maxPoint)
/*     */     {
/* 117 */       canUsePoint = maxPoint;
/*     */     }
/*     */     
/* 120 */     Map<Integer, Integer> xOldGeniusSkills = xGeniusSeriesInfo.getGenius_skills();
/*     */     
/*     */ 
/* 123 */     List<GeniusSkillInfo> geniusSkillInfos = new ArrayList();
/* 124 */     for (Map.Entry<Integer, Integer> entry : this.skills.entrySet())
/*     */     {
/* 126 */       geniusSkillInfos.add(new GeniusSkillInfo(((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue()));
/*     */     }
/* 128 */     java.util.Collections.sort(geniusSkillInfos);
/*     */     
/*     */ 
/* 131 */     Map<Integer, Integer> layers = new HashMap();
/* 132 */     for (GeniusSkillInfo geniusSkillInfo : geniusSkillInfos)
/*     */     {
/* 134 */       int geniusCfgid = geniusSkillInfo.geniusCfgid;
/* 135 */       SGeniusCfg geniusCfg = SGeniusCfg.get(geniusCfgid);
/* 136 */       if (geniusCfg == null)
/*     */       {
/* 138 */         Map<String, Object> extras = new HashMap();
/* 139 */         extras.put("genius_cfgid", Integer.valueOf(geniusCfgid));
/* 140 */         onFailed(3, extras);
/* 141 */         return false;
/*     */       }
/*     */       
/* 144 */       int addPoint = geniusSkillInfo.addPoint;
/* 145 */       if (addPoint <= 0)
/*     */       {
/* 147 */         Map<String, Object> extras = new HashMap();
/* 148 */         extras.put("genius_cfgid", Integer.valueOf(geniusCfgid));
/* 149 */         extras.put("add_point", Integer.valueOf(addPoint));
/* 150 */         onFailed(7, extras);
/* 151 */         return false;
/*     */       }
/*     */       
/* 154 */       if (addPoint > geniusCfg.skills.size())
/*     */       {
/* 156 */         Map<String, Object> extras = new HashMap();
/* 157 */         extras.put("genius_cfgid", Integer.valueOf(geniusCfgid));
/* 158 */         extras.put("add_point", Integer.valueOf(addPoint));
/* 159 */         onFailed(7, extras);
/* 160 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 164 */       canUsePoint -= addPoint;
/* 165 */       if (canUsePoint < 0)
/*     */       {
/* 167 */         onFailed(8);
/* 168 */         return false;
/*     */       }
/*     */       
/* 171 */       int layer = geniusCfg.layer;
/* 172 */       Integer oldAddPoint = (Integer)xOldGeniusSkills.remove(Integer.valueOf(geniusCfgid));
/* 173 */       if (oldAddPoint != null)
/*     */       {
/* 175 */         if (addPoint < oldAddPoint.intValue())
/*     */         {
/* 177 */           Map<String, Object> extras = new HashMap();
/* 178 */           extras.put("genius_cfgid", Integer.valueOf(geniusCfgid));
/* 179 */           extras.put("add_point", Integer.valueOf(addPoint));
/* 180 */           extras.put("old_add_point", oldAddPoint);
/* 181 */           onFailed(7, extras);
/* 182 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 186 */       Integer points = (Integer)layers.get(Integer.valueOf(layer));
/* 187 */       if (points == null)
/*     */       {
/* 189 */         layers.put(Integer.valueOf(layer), Integer.valueOf(addPoint));
/*     */       }
/*     */       else
/*     */       {
/* 193 */         layers.put(Integer.valueOf(layer), Integer.valueOf(addPoint + points.intValue()));
/*     */       }
/*     */       
/*     */ 
/* 197 */       for (PreviousGeniusCfg previousGenius : geniusCfg.previousGenius)
/*     */       {
/* 199 */         int previousGeniusCfgid = previousGenius.previousGeniusCfgid;
/* 200 */         SGeniusCfg previousGeniusCfg = SGeniusCfg.get(previousGeniusCfgid);
/* 201 */         if (previousGeniusCfg == null)
/*     */         {
/* 203 */           Map<String, Object> extras = new HashMap();
/* 204 */           extras.put("genius_cfgid", Integer.valueOf(geniusCfgid));
/* 205 */           extras.put("previous_genius_cfgid", Integer.valueOf(previousGeniusCfgid));
/* 206 */           onFailed(3, extras);
/* 207 */           return false;
/*     */         }
/*     */         
/* 210 */         Integer previousAddPoint = (Integer)this.skills.get(Integer.valueOf(previousGeniusCfgid));
/* 211 */         if (previousAddPoint == null)
/*     */         {
/* 213 */           Map<String, Object> extras = new HashMap();
/* 214 */           extras.put("genius_cfgid", Integer.valueOf(geniusCfgid));
/* 215 */           extras.put("previous_genius_cfgid", Integer.valueOf(previousGeniusCfgid));
/* 216 */           onFailed(7, extras);
/* 217 */           return false;
/*     */         }
/*     */         
/* 220 */         if (previousAddPoint.intValue() < previousGenius.previousGeniusAddPoint)
/*     */         {
/* 222 */           Map<String, Object> extras = new HashMap();
/* 223 */           extras.put("genius_cfgid", Integer.valueOf(geniusCfgid));
/* 224 */           extras.put("previous_genius_cfgid", Integer.valueOf(previousGeniusCfgid));
/* 225 */           extras.put("previous_add_point", previousAddPoint);
/* 226 */           onFailed(9, extras);
/* 227 */           return false;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 232 */       int previousPoint = geniusCfg.previousPoint;
/* 233 */       if (previousPoint > 0)
/*     */       {
/* 235 */         int sum = 0;
/* 236 */         for (int i = 1; i < layer; i++)
/*     */         {
/* 238 */           Integer layerPoints = (Integer)layers.get(Integer.valueOf(i));
/* 239 */           if (layerPoints != null)
/*     */           {
/*     */ 
/*     */ 
/* 243 */             sum += layerPoints.intValue();
/*     */           }
/*     */         }
/* 246 */         if (previousPoint > sum)
/*     */         {
/* 248 */           Map<String, Object> extras = new HashMap();
/* 249 */           extras.put("genius_cfgid", Integer.valueOf(geniusCfgid));
/* 250 */           onFailed(10, extras);
/* 251 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 256 */     if (!xOldGeniusSkills.isEmpty())
/*     */     {
/* 258 */       onFailed(11);
/* 259 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 263 */     xGeniusSeriesInfo.getGenius_skills().putAll(this.skills);
/*     */     
/*     */ 
/* 266 */     GeniusManager.triggerGeniusSkillChangeEvent(this.roleid, GeniusSkillChangeReason.SAVE_GENIUS);
/*     */     
/*     */ 
/* 269 */     GeniusManager.addTLog(this.roleid, "GeniusSavePlanForServer", new Object[] { Integer.valueOf(ocpid), Integer.valueOf(this.geniusSeriesCfgid), this.skills.toString() });
/*     */     
/* 271 */     SSavePlanSuccess rsp = new SSavePlanSuccess();
/* 272 */     rsp.genius_series_id = this.geniusSeriesCfgid;
/* 273 */     rsp.genius_skills = this.skills;
/* 274 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/* 276 */     GameServer.logger().info(String.format("[genius]PCSavePlan.processImp@save plan success|roleid=%d|genius_series_cfgid=%d|skills=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.geniusSeriesCfgid), this.skills.toString() }));
/*     */     
/*     */ 
/* 279 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 284 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 289 */     SSavePlanFailed rsp = new SSavePlanFailed();
/* 290 */     rsp.genius_series_id = this.geniusSeriesCfgid;
/* 291 */     rsp.retcode = retcode;
/* 292 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 294 */     StringBuffer logBuilder = new StringBuffer();
/* 295 */     logBuilder.append("[genius]PCSavePlan.onFailed@save plan failed");
/* 296 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 297 */     logBuilder.append('|').append("genius_series_cfgid=").append(this.geniusSeriesCfgid);
/* 298 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 300 */     if (extraParams != null)
/*     */     {
/* 302 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 304 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 308 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\main\PCSavePlan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */