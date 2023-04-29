/*     */ package mzm.gsp.role.multirank;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.chart.confbean.ChartConsts;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.partner.main.PartnerInterface;
/*     */ import mzm.gsp.partneryuanshen.main.PartnerYuanshenInterface;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.role.RoleMFVRankData;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MultiRankManager
/*     */ {
/*     */   public static void initMFV()
/*     */   {
/*  31 */     MultiFightValueRankManager.init();
/*     */     
/*  33 */     NoneRealMFVRankManager.init();
/*     */     
/*  35 */     GuiWangMFVManager.init();
/*  36 */     GuiWangNRealMFVManager.init();
/*     */     
/*  38 */     QingYunMFVManager.init();
/*  39 */     QingYunNRealMFVManager.init();
/*     */     
/*  41 */     TianYinMFVManager.init();
/*  42 */     TianYinNRealMFVManager.init();
/*     */     
/*  44 */     FenXiangMFVManager.init();
/*  45 */     FenXiangNRealMFVManager.init();
/*     */     
/*  47 */     HeHuanMFVManager.init();
/*  48 */     HeHuanNRealMFVManager.init();
/*     */     
/*  50 */     ShengWuMFVManager.init();
/*  51 */     ShengWuNRealMFVManager.init();
/*     */     
/*  53 */     CangYuMFVManager.init();
/*  54 */     CangYuNRealMFVManager.init();
/*     */     
/*  56 */     LingYinMFVManager.init();
/*  57 */     LingYinNRealMFVManager.init();
/*     */     
/*  59 */     YiNengMFVManager.init();
/*  60 */     YiNengNRealMFVManager.init();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isOccMFVOpen()
/*     */   {
/*  70 */     if (!OpenInterface.getOpenStatus(144))
/*     */     {
/*  72 */       return false;
/*     */     }
/*  74 */     return true;
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
/*     */   public static int getRoleMFValue(long roleId)
/*     */   {
/*  88 */     int roleFValue = RoleInterface.getFightValue(roleId);
/*  89 */     int topNPetsFValue = getTopNPetsFValue(roleId);
/*  90 */     int topNPartnerFValue = getPartnerFightValue(roleId);
/*  91 */     int childrenFValue = ChildrenInterface.getTotalChildrenRating(roleId, false);
/*  92 */     return roleFValue + topNPetsFValue + topNPartnerFValue + childrenFValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getTopNPetsFValue(long roleId)
/*     */   {
/* 103 */     int mfvValueSum = getTopNSum(getAllPetsYaoli(getRolePetsYaoli(roleId)), getNeedTopPetNum());
/* 104 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/* 106 */       GameServer.logger().debug(String.format("[MFV]MultiRankManager.getTopNPetsFValue@ pet mfv: %d", new Object[] { Integer.valueOf(mfvValueSum) }));
/*     */     }
/* 108 */     return mfvValueSum;
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
/*     */   static int getPartnerFightValue(long roleId)
/*     */   {
/* 121 */     int topNFightValue = getTopNParntersFValue(roleId);
/* 122 */     int yuanFightValue = PartnerYuanshenInterface.getFightScoreFromPartnerYuanshen(roleId, false);
/* 123 */     return topNFightValue + yuanFightValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getTopNParntersFValue(long roleId)
/*     */   {
/* 134 */     int mfvValueSum = getTopNSum(getAllPartnersScores(getRoleParnterScores(roleId)), getNeedTopPartnerNum());
/* 135 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/* 137 */       GameServer.logger().debug(String.format("[MFV]MultiRankManager.getTopNParntersFValue@ partner mfv: %d", new Object[] { Integer.valueOf(mfvValueSum) }));
/*     */     }
/*     */     
/* 140 */     return mfvValueSum;
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
/*     */   public static void delOcpRankData(long roleId, int occId)
/*     */   {
/* 155 */     AbsNRealOMFVRankManager absNOMFVRankManager = AbsNRealOMFVRankManager.getNOMFVRankManagerByOccId(occId);
/* 156 */     if (absNOMFVRankManager == null)
/*     */     {
/* 158 */       GameServer.logger().error(String.format("[role]MultiRankManager.delOcpRank@ no AbsNRealOMFVRankManager!|roleId=%d|occId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(occId) }));
/*     */       
/*     */ 
/* 161 */       return;
/*     */     }
/* 163 */     AbsOMFVRankManager absOMFVRankManager = AbsOMFVRankManager.getAbsOMFVRankManagerByOccId(occId);
/* 164 */     if (absOMFVRankManager == null)
/*     */     {
/* 166 */       GameServer.logger().error(String.format("[role]MultiRankManager.delOcpRank@ no AbsOMFVRankManager!|roleId=%d|occId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(occId) }));
/*     */       
/* 168 */       return;
/*     */     }
/* 170 */     absNOMFVRankManager.delete(Long.valueOf(roleId));
/* 171 */     absOMFVRankManager.delete(Long.valueOf(roleId));
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
/*     */   static void fillProRankList(int fromNo, List<RoleMultiFightValueChart> roleMFVCharts, Map<Long, Integer> rankChangeMap, List<RoleMFVRankData> pRankList)
/*     */   {
/* 185 */     for (int i = 0; i < roleMFVCharts.size(); i++)
/*     */     {
/* 187 */       RoleMultiFightValueChart roleMFVChart = (RoleMultiFightValueChart)roleMFVCharts.get(i);
/* 188 */       Role role = RoleInterface.getRole(roleMFVChart.getKey().longValue(), false);
/* 189 */       if (role == null)
/*     */       {
/* 191 */         fromNo--;
/*     */       }
/*     */       else {
/* 194 */         RoleMFVRankData roleMFVRankData = new RoleMFVRankData();
/* 195 */         roleMFVRankData.fightvalue = roleMFVChart.getFightValue();
/* 196 */         roleMFVRankData.name = role.getName();
/* 197 */         roleMFVRankData.no = (fromNo + i);
/* 198 */         roleMFVRankData.occupationid = role.getOccupationId();
/* 199 */         roleMFVRankData.roleid = roleMFVChart.getKey().longValue();
/* 200 */         Integer change = (Integer)rankChangeMap.get(roleMFVChart.getKey());
/* 201 */         if (change != null)
/*     */         {
/* 203 */           roleMFVRankData.step = change.intValue();
/*     */         }
/* 205 */         pRankList.add(roleMFVRankData);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Map<Long, Integer> getRolePetsYaoli(long roleId)
/*     */   {
/* 217 */     Map<Long, Integer> pet2Yaoli = PetInterface.getPetYaoliMap(roleId);
/* 218 */     if (pet2Yaoli == null)
/*     */     {
/* 220 */       return new HashMap();
/*     */     }
/* 222 */     return pet2Yaoli;
/*     */   }
/*     */   
/*     */   private static Map<Integer, Integer> getRoleParnterScores(long roleId)
/*     */   {
/* 227 */     Map<Integer, Integer> partner2score = PartnerInterface.getAllPartnerScores(roleId, false);
/* 228 */     if ((partner2score == null) || (partner2score.size() == 0))
/*     */     {
/* 230 */       return new HashMap();
/*     */     }
/* 232 */     return partner2score;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getTopNSum(List<Integer> values, int max)
/*     */   {
/* 243 */     if ((values == null) || (values.size() == 0))
/*     */     {
/* 245 */       return 0;
/*     */     }
/* 247 */     if (max <= 0)
/*     */     {
/* 249 */       return 0;
/*     */     }
/* 251 */     int sumValue = 0;
/* 252 */     int count = 0;
/* 253 */     for (int i = values.size() - 1; (i >= 0) && (count < max); count++)
/*     */     {
/* 255 */       int value = ((Integer)values.get(i)).intValue();
/* 256 */       sumValue += value;i--;
/*     */     }
/*     */     
/* 258 */     return sumValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static List<Integer> getAllPetsYaoli(Map<Long, Integer> pet2yaoli)
/*     */   {
/* 269 */     List<Integer> yaoLiValues = new ArrayList();
/* 270 */     if ((pet2yaoli == null) || (pet2yaoli.size() == 0))
/*     */     {
/* 272 */       return yaoLiValues;
/*     */     }
/* 274 */     yaoLiValues.addAll(pet2yaoli.values());
/* 275 */     Collections.sort(yaoLiValues);
/* 276 */     return yaoLiValues;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static List<Integer> getAllPartnersScores(Map<Integer, Integer> partner2score)
/*     */   {
/* 287 */     List<Integer> scores = new ArrayList();
/* 288 */     if ((partner2score == null) || (partner2score.size() == 0))
/*     */     {
/* 290 */       return scores;
/*     */     }
/* 292 */     scores.addAll(partner2score.values());
/* 293 */     Collections.sort(scores);
/* 294 */     return scores;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getNeedTopPetNum()
/*     */   {
/* 304 */     return ChartConsts.getInstance().MFV_CHART_PET_MAX;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getNeedTopPartnerNum()
/*     */   {
/* 314 */     return ChartConsts.getInstance().MFV_CHART_PARTNER_MAX;
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
/*     */   static boolean canBeRanked(long roleId, int needOccId)
/*     */   {
/* 328 */     int roleOccId = RoleInterface.getOccupationId(roleId);
/* 329 */     if (roleOccId != needOccId)
/*     */     {
/* 331 */       GameServer.logger().info(String.format("[occmfv]MultiRankManager.canBeRanked@ have other occId!|roleId=%d|absOccId=%d|nowOccId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(needOccId), Integer.valueOf(roleOccId) }));
/*     */       
/*     */ 
/* 334 */       return false;
/*     */     }
/* 336 */     if (RoleInterface.isRoleRealDel(roleId))
/*     */     {
/* 338 */       GameServer.logger().info(String.format("[occmfv]MultiRankManager.canBeRanked@ role real deleted!|roleId=%d|absOccId=%d|nowOccId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(needOccId), Integer.valueOf(roleOccId) }));
/*     */       
/*     */ 
/* 341 */       return false;
/*     */     }
/* 343 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\MultiRankManager1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */