/*     */ package mzm.gsp.partner.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.partner.confbean.LibInfo;
/*     */ import mzm.gsp.partner.confbean.PartnerConstants;
/*     */ import mzm.gsp.partner.confbean.STLove2Rate;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
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
/*     */ public class LoveCfgManager
/*     */ {
/*     */   static Set<Integer> getNewLoveContentIds(int loveCfgId, Set<Integer> ownContentIds)
/*     */   {
/*  35 */     Set<Integer> ownLibIds = new HashSet();
/*  36 */     if (ownContentIds.size() > 0)
/*     */     {
/*  38 */       Map<Integer, Integer> content2libId = getLoveLibIds(loveCfgId, ownContentIds);
/*  39 */       if (content2libId.size() == 0)
/*     */       {
/*  41 */         return new HashSet();
/*     */       }
/*  43 */       ownLibIds.addAll(content2libId.values());
/*     */     }
/*     */     
/*  46 */     return ranLoveContentIds(loveCfgId, ownLibIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Map<Integer, Integer> getLoveLibIds(int loveCfgId, Set<Integer> contentIds)
/*     */   {
/*  58 */     Map<Integer, Integer> libIds = new HashMap();
/*  59 */     STLove2Rate cfg = STLove2Rate.get(loveCfgId);
/*  60 */     if (cfg == null)
/*     */     {
/*  62 */       GameServer.logger().error(String.format("[partner]LoveCfgManager.getLoveIds@ no STLove2Rate data!|loveCfgId=%d", new Object[] { Integer.valueOf(loveCfgId) }));
/*     */       
/*  64 */       return libIds;
/*     */     }
/*  66 */     for (Iterator i$ = contentIds.iterator(); i$.hasNext();) { int contentId = ((Integer)i$.next()).intValue();
/*     */       
/*  68 */       Integer loveLibId = (Integer)cfg.contentId2loveId.get(Integer.valueOf(contentId));
/*  69 */       if (loveLibId == null)
/*     */       {
/*  71 */         GameServer.logger().error(String.format("[partner]LoveCfgManager.getLoveIds@ no loveLibId!|loveCfgId=%d|contentId=%d", new Object[] { Integer.valueOf(loveCfgId), Integer.valueOf(contentId) }));
/*     */         
/*     */ 
/*  74 */         return new HashMap();
/*     */       }
/*  76 */       libIds.put(Integer.valueOf(contentId), Integer.valueOf(loveLibId.intValue()));
/*     */     }
/*  78 */     return libIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Set<Integer> ranLoveContentIds(int loveCfgId, Set<Integer> ownLoveLibIds)
/*     */   {
/*  90 */     STLove2Rate cfg = STLove2Rate.get(loveCfgId);
/*     */     
/*  92 */     if (!checkRanValid(loveCfgId, ownLoveLibIds, cfg))
/*     */     {
/*  94 */       GameServer.logger().error(String.format("[partner]LoveCfgManager.ranLoveContentIds@ check valid error!|ownLoveIds=%s", new Object[] { ownLoveLibIds.toString() }));
/*     */       
/*     */ 
/*  97 */       return new HashSet();
/*     */     }
/*     */     
/* 100 */     Map<Integer, LibInfo> libId2info = cfg.libId2info;
/*     */     
/* 102 */     Set<Integer> allLoveIds = new HashSet(libId2info.keySet());
/* 103 */     int weightSum = getLastWeight(ownLoveLibIds, cfg, libId2info, allLoveIds);
/*     */     
/* 105 */     Set<Integer> ranLoveIds = ranLoves(libId2info, weightSum, allLoveIds);
/* 106 */     if (ranLoveIds.size() != needLoveContentIdNum())
/*     */     {
/* 108 */       GameServer.logger().error(String.format("[partner]LoveCfgManager.ranLoveContentIds@ ran loves error!|allLoveIds=%s|weightSum=%d|ranIdSize=%d", new Object[] { allLoveIds, Integer.valueOf(weightSum), Integer.valueOf(ranLoveIds.size()) }));
/*     */       
/*     */ 
/*     */ 
/* 112 */       return new HashSet();
/*     */     }
/*     */     
/* 115 */     return ranLastContentIds(ranLoveIds, libId2info);
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
/*     */   static Set<Integer> ranLastContentIds(Set<Integer> loveIds, Map<Integer, LibInfo> libId2info)
/*     */   {
/* 129 */     Set<Integer> lastLoveIds = new HashSet();
/* 130 */     for (Iterator i$ = loveIds.iterator(); i$.hasNext();) { int loveId = ((Integer)i$.next()).intValue();
/*     */       
/* 132 */       int contentId = ranOneLoveContentId(libId2info, loveId);
/* 133 */       if (contentId <= 0)
/*     */       {
/* 135 */         GameServer.logger().error(String.format("[partner]LoveCfgManager.ranLastContentIds@ get libInfo error!|loveId=%d", new Object[] { Integer.valueOf(loveId) }));
/*     */         
/* 137 */         return new HashSet();
/*     */       }
/* 139 */       lastLoveIds.add(Integer.valueOf(contentId));
/*     */     }
/* 141 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/* 143 */       GameServer.logger().debug(String.format("[partner]LoveCfgManager.ranLastContentIds@ ran new love!|loveLibIds=%s|loveContentIds=%s", new Object[] { loveIds.toString(), lastLoveIds.toString() }));
/*     */     }
/*     */     
/*     */ 
/* 147 */     return lastLoveIds;
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
/*     */   private static int ranOneLoveContentId(Map<Integer, LibInfo> libId2info, int loveId)
/*     */   {
/* 160 */     LibInfo info = (LibInfo)libId2info.get(Integer.valueOf(loveId));
/* 161 */     if (info == null)
/*     */     {
/* 163 */       GameServer.logger().error(String.format("[partner]LoveCfgManager.ranOneLoveContentId@ get libInfo error!|loveId=%d", new Object[] { Integer.valueOf(loveId) }));
/*     */       
/* 165 */       return -1;
/*     */     }
/* 167 */     return ranOneLoveContentId(info);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int ranOneLoveContentId(LibInfo info)
/*     */   {
/* 178 */     int weightSum = info.weightSum;
/* 179 */     Map<Integer, Integer> contentId2weight = info.contentId2weight;
/*     */     
/* 181 */     Random random = Xdb.random();
/* 182 */     int ran = random.nextInt(weightSum);
/*     */     
/* 184 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/* 186 */       GameServer.logger().debug(String.format("[partner]LoveCfgManager.ranOneLoveContentId@ cur data|ran=%d|weightSum=%d|contentId2weight=%s", new Object[] { Integer.valueOf(ran), Integer.valueOf(weightSum), contentId2weight.toString() }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 192 */     int sum = 0;
/* 193 */     int contentTmpId = -1;
/* 194 */     Iterator<Map.Entry<Integer, Integer>> it = contentId2weight.entrySet().iterator();
/* 195 */     while (it.hasNext())
/*     */     {
/* 197 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 198 */       sum += ((Integer)entry.getValue()).intValue();
/* 199 */       if (sum > ran)
/*     */       {
/*     */ 
/*     */ 
/* 203 */         contentTmpId = ((Integer)entry.getKey()).intValue();
/*     */       }
/*     */     }
/* 206 */     return contentTmpId;
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
/*     */   private static int getLastWeight(Set<Integer> ownLoveIds, STLove2Rate cfg, Map<Integer, LibInfo> libId2info, Set<Integer> allLoveIds)
/*     */   {
/* 221 */     int weightSum = cfg.weightSum;
/*     */     
/* 223 */     for (Iterator i$ = ownLoveIds.iterator(); i$.hasNext();) { int ownloveId = ((Integer)i$.next()).intValue();
/*     */       
/* 225 */       LibInfo libInfo = (LibInfo)libId2info.get(Integer.valueOf(ownloveId));
/* 226 */       if (libInfo == null)
/*     */       {
/* 228 */         GameServer.logger().error(String.format("[partner]LoveCfgManager.getLastWeight@ get libInfo error!|ownloveId=%d|", new Object[] { Integer.valueOf(ownloveId) }));
/*     */         
/* 230 */         return -1;
/*     */       }
/* 232 */       weightSum -= libInfo.enterWeight;
/* 233 */       allLoveIds.remove(Integer.valueOf(ownloveId));
/*     */     }
/* 235 */     return weightSum;
/*     */   }
/*     */   
/*     */   private static Set<Integer> ranLoves(Map<Integer, LibInfo> libId2info, int weightSum, Set<Integer> allLoveIds)
/*     */   {
/* 240 */     Set<Integer> ranLoveIds = new HashSet();
/* 241 */     for (int i = 0; i < needLoveContentIdNum(); i++)
/*     */     {
/* 243 */       int oneLoveId = getOneLoveId(weightSum, allLoveIds, libId2info);
/* 244 */       if (oneLoveId <= 0)
/*     */       {
/* 246 */         GameServer.logger().error(String.format("[partner]LoveCfgManager.ranLoves@ get one love error!|allLoveIds=%s|weightSum=%d", new Object[] { allLoveIds, Integer.valueOf(weightSum) }));
/*     */         
/*     */ 
/* 249 */         return new HashSet();
/*     */       }
/* 251 */       ranLoveIds.add(Integer.valueOf(oneLoveId));
/* 252 */       allLoveIds.remove(Integer.valueOf(oneLoveId));
/* 253 */       weightSum -= ((LibInfo)libId2info.get(Integer.valueOf(oneLoveId))).enterWeight;
/*     */     }
/* 255 */     return ranLoveIds;
/*     */   }
/*     */   
/*     */   static int getOneLoveId(int weightSum, Set<Integer> allLoveIds, Map<Integer, LibInfo> libId2info)
/*     */   {
/* 260 */     if (weightSum <= 0)
/*     */     {
/* 262 */       return -1;
/*     */     }
/*     */     
/* 265 */     Random random = Xdb.random();
/* 266 */     int ran = random.nextInt(weightSum);
/*     */     
/* 268 */     int sum = 0;
/* 269 */     Iterator<Integer> it = allLoveIds.iterator();
/* 270 */     int ranId = -1;
/* 271 */     while (it.hasNext())
/*     */     {
/* 273 */       int eachLoveId = ((Integer)it.next()).intValue();
/* 274 */       LibInfo libInfo = (LibInfo)libId2info.get(Integer.valueOf(eachLoveId));
/* 275 */       int weight = libInfo.enterWeight;
/* 276 */       sum += weight;
/* 277 */       if (sum > ran)
/*     */       {
/*     */ 
/*     */ 
/* 281 */         ranId = eachLoveId;
/*     */       }
/*     */     }
/* 284 */     if (ranId < 0)
/*     */     {
/* 286 */       return -1;
/*     */     }
/* 288 */     return ranId;
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
/*     */   private static boolean checkRanValid(int loveCfgId, Set<Integer> ownLoveId, STLove2Rate cfg)
/*     */   {
/* 302 */     if ((ownLoveId.size() > 0) && (ownLoveId.size() != needLoveContentIdNum()))
/*     */     {
/* 304 */       GameServer.logger().error(String.format("[partner]LoveCfgManager.checkRanValid@ ownLoveId num error!|ownLoveId=%s|needNum=%d", new Object[] { ownLoveId.toString(), Integer.valueOf(needLoveContentIdNum()) }));
/*     */       
/*     */ 
/* 307 */       return false;
/*     */     }
/* 309 */     if (cfg == null)
/*     */     {
/* 311 */       GameServer.logger().error(String.format("[partner]LoveCfgManager.checkRanValid@ no STLove2Rate data!|loveCfgId=%d", new Object[] { Integer.valueOf(loveCfgId) }));
/*     */       
/* 313 */       return false;
/*     */     }
/* 315 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int needLoveContentIdNum()
/*     */   {
/* 325 */     return PartnerConstants.getInstance().LOVE_NUM;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\LoveCfgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */