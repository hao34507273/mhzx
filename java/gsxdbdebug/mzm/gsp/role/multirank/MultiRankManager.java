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
/*     */ public class MultiRankManager
/*     */ {
/*     */   public static void initMFV()
/*     */   {
/*  29 */     MultiFightValueRankManager.init();
/*  30 */     NoneRealMFVRankManager.init();
/*  31 */     GuiWangMFVManager.init();
/*  32 */     GuiWangNRealMFVManager.init();
/*  33 */     QingYunMFVManager.init();
/*  34 */     QingYunNRealMFVManager.init();
/*  35 */     TianYinMFVManager.init();
/*  36 */     TianYinNRealMFVManager.init();
/*  37 */     FenXiangMFVManager.init();
/*  38 */     FenXiangNRealMFVManager.init();
/*  39 */     HeHuanMFVManager.init();
/*  40 */     HeHuanNRealMFVManager.init();
/*  41 */     ShengWuMFVManager.init();
/*  42 */     ShengWuNRealMFVManager.init();
/*  43 */     CangYuMFVManager.init();
/*  44 */     CangYuNRealMFVManager.init();
/*  45 */     LingYinMFVManager.init();
/*  46 */     LingYinNRealMFVManager.init();
/*  47 */     YiNengMFVManager.init();
/*  48 */     YiNengNRealMFVManager.init();
/*  49 */     WanDuMFVManager.init();
/*  50 */     WanDuNRealMFVManager.init();
/*  51 */     DanQingMFVManager.init();
/*  52 */     DanQingNRealMFVManager.init();
/*  53 */     YinYangMFVManager.init();
/*  54 */     YinYangNRealMFVManager.init();
/*  55 */     HuangJinMFVManager.init();
/*  56 */     HuangJinNRealMFVManager.init();
/*  57 */     ShenMuMFVManager.init();
/*  58 */     ShenMuNRealMFVManager.init();
/*     */   }
/*     */   
/*     */   public static boolean isOccMFVOpen() {
/*  62 */     return OpenInterface.getOpenStatus(144);
/*     */   }
/*     */   
/*     */   public static int getRoleMFValue(long var0) {
/*  66 */     int var2 = RoleInterface.getFightValue(var0);
/*  67 */     int var3 = getTopNPetsFValue(var0);
/*  68 */     int var4 = getPartnerFightValue(var0);
/*  69 */     int var5 = ChildrenInterface.getTotalChildrenRating(var0, false);
/*  70 */     return var2 + var3 + var4 + var5;
/*     */   }
/*     */   
/*     */   static int getTopNPetsFValue(long var0) {
/*  74 */     int var2 = getTopNSum(getAllPetsYaoli(getRolePetsYaoli(var0)), getNeedTopPetNum());
/*  75 */     if (GameServer.logger().isDebugEnabled()) {
/*  76 */       GameServer.logger().debug(String.format("[MFV]MultiRankManager.getTopNPetsFValue@ pet mfv: %d", new Object[] { Integer.valueOf(var2) }));
/*     */     }
/*     */     
/*  79 */     return var2;
/*     */   }
/*     */   
/*     */   static int getPartnerFightValue(long var0) {
/*  83 */     int var2 = getTopNParntersFValue(var0);
/*  84 */     int var3 = PartnerYuanshenInterface.getFightScoreFromPartnerYuanshen(var0, false);
/*  85 */     return var2 + var3;
/*     */   }
/*     */   
/*     */   private static int getTopNParntersFValue(long var0) {
/*  89 */     int var2 = getTopNSum(getAllPartnersScores(getRoleParnterScores(var0)), getNeedTopPartnerNum());
/*  90 */     if (GameServer.logger().isDebugEnabled()) {
/*  91 */       GameServer.logger().debug(String.format("[MFV]MultiRankManager.getTopNParntersFValue@ partner mfv: %d", new Object[] { Integer.valueOf(var2) }));
/*     */     }
/*     */     
/*  94 */     return var2;
/*     */   }
/*     */   
/*     */   public static void delOcpRankData(long var0, int var2) {
/*  98 */     AbsNRealOMFVRankManager var3 = AbsNRealOMFVRankManager.getNOMFVRankManagerByOccId(var2);
/*  99 */     if (var3 == null) {
/* 100 */       GameServer.logger().error(String.format("[role]MultiRankManager.delOcpRank@ no AbsNRealOMFVRankManager!|roleId=%d|occId=%d", new Object[] { Long.valueOf(var0), Integer.valueOf(var2) }));
/*     */     } else {
/* 102 */       AbsOMFVRankManager var4 = AbsOMFVRankManager.getAbsOMFVRankManagerByOccId(var2);
/* 103 */       if (var4 == null) {
/* 104 */         GameServer.logger().error(String.format("[role]MultiRankManager.delOcpRank@ no AbsOMFVRankManager!|roleId=%d|occId=%d", new Object[] { Long.valueOf(var0), Integer.valueOf(var2) }));
/*     */       } else {
/* 106 */         var3.delete(Long.valueOf(var0));
/* 107 */         var4.delete(Long.valueOf(var0));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static void fillProRankList(int var0, List<RoleMultiFightValueChart> var1, Map<Long, Integer> var2, List<RoleMFVRankData> var3) {
/* 113 */     for (int var4 = 0; var4 < var1.size(); var4++) {
/* 114 */       RoleMultiFightValueChart var5 = (RoleMultiFightValueChart)var1.get(var4);
/* 115 */       Role var6 = RoleInterface.getRole(var5.getKey().longValue(), false);
/* 116 */       if (var6 == null) {
/* 117 */         var0--;
/*     */       } else {
/* 119 */         RoleMFVRankData var7 = new RoleMFVRankData();
/* 120 */         var7.fightvalue = var5.getFightValue();
/* 121 */         var7.name = var6.getName();
/* 122 */         var7.no = (var0 + var4);
/* 123 */         var7.occupationid = var6.getOccupationId();
/* 124 */         var7.roleid = var5.getKey().longValue();
/* 125 */         Integer var8 = (Integer)var2.get(var5.getKey());
/* 126 */         if (var8 != null) {
/* 127 */           var7.step = var8.intValue();
/*     */         }
/*     */         
/* 130 */         var3.add(var7);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static Map<Long, Integer> getRolePetsYaoli(long var0)
/*     */   {
/* 137 */     Map var2 = PetInterface.getPetYaoliMap(var0);
/* 138 */     return var2 == null ? new HashMap() : var2;
/*     */   }
/*     */   
/*     */   private static Map<Integer, Integer> getRoleParnterScores(long var0) {
/* 142 */     Map var2 = PartnerInterface.getAllPartnerScores(var0, false);
/* 143 */     return (var2 != null) && (var2.size() != 0) ? var2 : new HashMap();
/*     */   }
/*     */   
/*     */   private static int getTopNSum(List<Integer> var0, int var1) {
/* 147 */     if ((var0 != null) && (var0.size() != 0)) {
/* 148 */       if (var1 <= 0) {
/* 149 */         return 0;
/*     */       }
/* 151 */       int var2 = 0;
/* 152 */       int var3 = 0;
/*     */       
/* 154 */       for (int var4 = var0.size() - 1; (var4 >= 0) && (var3 < var1); var3++) {
/* 155 */         int var5 = ((Integer)var0.get(var4)).intValue();
/* 156 */         var2 += var5;
/* 157 */         var4--;
/*     */       }
/*     */       
/* 160 */       return var2;
/*     */     }
/*     */     
/* 163 */     return 0;
/*     */   }
/*     */   
/*     */   private static List<Integer> getAllPetsYaoli(Map<Long, Integer> var0)
/*     */   {
/* 168 */     ArrayList var1 = new ArrayList();
/* 169 */     if ((var0 != null) && (var0.size() != 0)) {
/* 170 */       var1.addAll(var0.values());
/* 171 */       Collections.sort(var1);
/* 172 */       return var1;
/*     */     }
/* 174 */     return var1;
/*     */   }
/*     */   
/*     */   private static List<Integer> getAllPartnersScores(Map<Integer, Integer> var0)
/*     */   {
/* 179 */     ArrayList var1 = new ArrayList();
/* 180 */     if ((var0 != null) && (var0.size() != 0)) {
/* 181 */       var1.addAll(var0.values());
/* 182 */       Collections.sort(var1);
/* 183 */       return var1;
/*     */     }
/* 185 */     return var1;
/*     */   }
/*     */   
/*     */   private static int getNeedTopPetNum()
/*     */   {
/* 190 */     return ChartConsts.getInstance().MFV_CHART_PET_MAX;
/*     */   }
/*     */   
/*     */   private static int getNeedTopPartnerNum() {
/* 194 */     return ChartConsts.getInstance().MFV_CHART_PARTNER_MAX;
/*     */   }
/*     */   
/*     */   static boolean canBeRanked(long var0, int var2) {
/* 198 */     int var3 = RoleInterface.getOccupationId(var0);
/* 199 */     if (var3 != var2) {
/* 200 */       GameServer.logger().info(String.format("[occmfv]MultiRankManager.canBeRanked@ have other occId!|roleId=%d|absOccId=%d|nowOccId=%d", new Object[] { Long.valueOf(var0), Integer.valueOf(var2), Integer.valueOf(var3) }));
/* 201 */       return false; }
/* 202 */     if (RoleInterface.isRoleRealDel(var0)) {
/* 203 */       GameServer.logger().info(String.format("[occmfv]MultiRankManager.canBeRanked@ role real deleted!|roleId=%d|absOccId=%d|nowOccId=%d", new Object[] { Long.valueOf(var0), Integer.valueOf(var2), Integer.valueOf(var3) }));
/* 204 */       return false;
/*     */     }
/* 206 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\MultiRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */