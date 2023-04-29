/*     */ package mzm.gsp.jingji.main;
/*     */ 
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.JingjiPvp;
/*     */ import xtable.Role2jingjipvp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JingjiInterface
/*     */ {
/*     */   static int getPhaseByWingPoint(int winPoint)
/*     */   {
/*  16 */     return JingjiManager.getPhaseByWingPoint(winPoint);
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
/*     */   public static int getWinpoint(long roleid, boolean islock)
/*     */   {
/*  30 */     return JingjiManager.getWinpoint(roleid, islock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getRoleLastseasonendtime(long roleid)
/*     */   {
/*  41 */     return JingjiManager.getRoleLastseasonendtime(roleid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getSeasonStarttime()
/*     */   {
/*  52 */     return JingjiManager.getSeasonStarttime();
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
/*     */   public static void insertIntoRankForIdip(long roleid, int winPoint)
/*     */   {
/*  65 */     new InsertIntoRankPro(roleid, winPoint).execute();
/*     */   }
/*     */   
/*     */ 
/*     */   private static class InsertIntoRankPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int winPoint;
/*     */     
/*     */     public InsertIntoRankPro(long roleid, int winPoint)
/*     */     {
/*  77 */       this.roleid = roleid;
/*  78 */       this.winPoint = winPoint;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  84 */       long seasonstarttime = JingjiManager.getSeasonStarttime();
/*  85 */       JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(this.roleid));
/*  86 */       if (jingjiData == null)
/*     */       {
/*  88 */         return false;
/*     */       }
/*  90 */       jingjiData.setWinpoint(this.winPoint);
/*  91 */       jingjiData.setLastseasonendtime(seasonstarttime);
/*  92 */       RoleJingjiChartInterface.rank(this.roleid, this.winPoint);
/*  93 */       return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getCanGetStorageExp(long roleid, int finishCount)
/*     */   {
/* 109 */     return (int)(JingjiManager.getJingjiRestExp(roleid, finishCount) * JingjiManager.getRate());
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
/*     */   public static int getExpByRing(long roleid, boolean isWing)
/*     */   {
/* 122 */     return (int)(JingjiManager.getExpByRing(roleid, isWing) * JingjiManager.getRate());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\JingjiInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */