/*     */ package mzm.gsp.role.multirank;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.main.RoleKeyRankManagerNew;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MultiFightValueRank;
/*     */ import xbean.OccMFVRankData;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleMultiFightValueBean;
/*     */ import xtable.Occmfvrank;
/*     */ 
/*     */ public abstract class AbsOMFVRankManager
/*     */   extends RoleKeyRankManagerNew<RoleMultiFightValueChart>
/*     */ {
/*     */   public AbsOMFVRankManager(int var1)
/*     */   {
/*  22 */     super(var1);
/*     */   }
/*     */   
/*     */   public void saveToDB() {
/*  26 */     List var1 = getAllChartObjs();
/*  27 */     OccMFVRankData var2 = Occmfvrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  28 */     if (var2 == null) {
/*  29 */       var2 = Pod.newOccMFVRankData();
/*  30 */       Occmfvrank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), var2);
/*     */     }
/*     */     
/*  33 */     var2.getOcc2rankdata().remove(Integer.valueOf(getOccId()));
/*     */     
/*     */     RoleMultiFightValueBean var5;
/*     */     MultiFightValueRank var6;
/*  37 */     for (Iterator var3 = var1.iterator(); var3.hasNext(); var6.getRolerankdatas().add(var5)) {
/*  38 */       RoleMultiFightValueChart var4 = (RoleMultiFightValueChart)var3.next();
/*  39 */       var5 = Pod.newRoleMultiFightValueBean();
/*  40 */       var5.setRoleid(var4.getKey().longValue());
/*  41 */       var6 = (MultiFightValueRank)var2.getOcc2rankdata().get(Integer.valueOf(getOccId()));
/*  42 */       if (var6 == null) {
/*  43 */         var6 = Pod.newMultiFightValueRank();
/*  44 */         var2.getOcc2rankdata().put(Integer.valueOf(getOccId()), var6);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void rankDataFromDB()
/*     */   {
/*  51 */     OccMFVRankData var1 = Occmfvrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  52 */     if (var1 != null) {
/*  53 */       MultiFightValueRank var2 = (MultiFightValueRank)var1.getOcc2rankdata().get(Integer.valueOf(getOccId()));
/*  54 */       if (var2 != null) {
/*  55 */         Iterator var3 = var2.getRolerankdatas().iterator();
/*     */         
/*  57 */         while (var3.hasNext()) {
/*  58 */           RoleMultiFightValueBean var4 = (RoleMultiFightValueBean)var3.next();
/*  59 */           long var5 = var4.getRoleid();
/*  60 */           if (!MultiRankManager.canBeRanked(var5, getOccId())) {
/*  61 */             GameServer.logger().info(String.format("[occmfv]AbsOMFVRankManager.rankDataFromDB@ can not ranked!|roleId=%d", new Object[] { Long.valueOf(var5) }));
/*     */           } else {
/*  63 */             int var7 = MultiRankManager.getRoleMFValue(var5);
/*  64 */             RoleMultiFightValueChart var8 = new RoleMultiFightValueChart(var5, var7, getOccId());
/*  65 */             rank(var8);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void addRankRoleForIDIP(long var1)
/*     */   {
/*  74 */     int var3 = MultiRankManager.getRoleMFValue(var1);
/*  75 */     int var4 = RoleInterface.getOccupationId(var1);
/*  76 */     rank(new RoleMultiFightValueChart(var1, var3, var4));
/*     */   }
/*     */   
/*     */   public void clearRoleRankData(long var1) {}
/*     */   
/*     */   abstract int getOccChartType();
/*     */   
/*     */   abstract int getOccId();
/*     */   
/*     */   public static AbsOMFVRankManager getAbsOMFVRankManagerByOccId(int var0)
/*     */   {
/*  87 */     switch (var0) {
/*     */     case 1: 
/*  89 */       return GuiWangMFVManager.getInstance();
/*     */     case 2: 
/*  91 */       return QingYunMFVManager.getInstance();
/*     */     case 3: 
/*  93 */       return TianYinMFVManager.getInstance();
/*     */     case 4: 
/*  95 */       return FenXiangMFVManager.getInstance();
/*     */     case 5: 
/*  97 */       return HeHuanMFVManager.getInstance();
/*     */     case 6: 
/*  99 */       return ShengWuMFVManager.getInstance();
/*     */     case 7: 
/* 101 */       return CangYuMFVManager.getInstance();
/*     */     case 8: 
/* 103 */       return LingYinMFVManager.getInstance();
/*     */     case 9: 
/* 105 */       return YiNengMFVManager.getInstance();
/*     */     case 10: 
/* 107 */       return WanDuMFVManager.getInstance();
/*     */     case 11: 
/* 109 */       return DanQingMFVManager.getInstance();
/*     */     case 12: 
/* 111 */       return YinYangMFVManager.getInstance();
/*     */     case 13: 
/* 113 */       return HuangJinMFVManager.getInstance();
/*     */     case 14: 
/* 115 */       return ShenMuMFVManager.getInstance();
/*     */     }
/* 117 */     return null;
/*     */   }
/*     */   
/*     */   static AbsOMFVRankManager getAbsOMFVRankManagerByChartType(int var0)
/*     */   {
/* 122 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\AbsOMFVRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */