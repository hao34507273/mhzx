/*     */ package mzm.gsp.server.main;
/*     */ 
/*     */ import mzm.gsp.serverconf.confbean.SServerLevelConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ServerInterface
/*     */ {
/*     */   public static int getCurrentServerLevel()
/*     */   {
/*  16 */     return ServerLevelObject.getInstance().getLevel();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getCurrentServerLevelStartTime()
/*     */   {
/*  26 */     return ServerLevelObject.getInstance().getStartTime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isCharUsable(char c)
/*     */   {
/*  38 */     return AvailableStringArgs.getInstance().isCharUsable(c);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isStringUsable(String str)
/*     */   {
/*  49 */     return AvailableStringArgs.getInstance().isStringUsable(str);
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
/*     */   @Deprecated
/*     */   public static int getOpenServerDay(long curtime, boolean islock)
/*     */   {
/*  65 */     return ServerManager.getOpenServerDay(curtime);
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
/*     */ 
/*     */   public static int getOpenServerDay(long curtime)
/*     */   {
/*  81 */     return ServerManager.getOpenServerDay(curtime);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getOpenServertime()
/*     */   {
/*  91 */     return ServerManager.getOpenServertime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public static long getOpenServertime(boolean islock)
/*     */   {
/* 104 */     return ServerManager.getOpenServertime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SServerLevelConfig getNextServerLevelBean(int level)
/*     */   {
/* 115 */     return ServerManager.getNextServerLevelBean(level);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\server\main\ServerInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */