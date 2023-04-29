/*     */ package mzm.gsp.apollo.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.Module;
/*     */ 
/*     */ 
/*     */ public class ApolloModule
/*     */   implements Module
/*     */ {
/*     */   public int init(Map<String, String> envs)
/*     */   {
/*  12 */     String intervalValue = (String)envs.get("interval");
/*  13 */     if (intervalValue == null)
/*     */     {
/*  15 */       throw new RuntimeException("interval is null");
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  20 */       long interval = Long.parseLong(intervalValue);
/*  21 */       ChatToSpeakerIntervalChecker.getInstance().setInterval(interval);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  25 */       throw new RuntimeException("interval format error");
/*     */     }
/*     */     
/*  28 */     String exitVoipRoomTryimesValue = (String)envs.get("exit_voip_room_try_times");
/*  29 */     if (exitVoipRoomTryimesValue != null)
/*     */     {
/*     */       try
/*     */       {
/*  33 */         int param = Integer.parseInt(exitVoipRoomTryimesValue);
/*  34 */         VoipRoomManager.EXIT_VOIP_ROOM_TRY_TIMES = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  38 */         throw new RuntimeException("exit_voip_room_try_times format error");
/*     */       }
/*     */     }
/*     */     
/*  42 */     String exitVoipRoomTimeoutValue = (String)envs.get("exit_voip_room_timeout");
/*  43 */     if (exitVoipRoomTryimesValue != null)
/*     */     {
/*     */       try
/*     */       {
/*  47 */         int param = Integer.parseInt(exitVoipRoomTimeoutValue);
/*  48 */         VoipRoomManager.EXIT_VOIP_ROOM_TIMEOUT = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  52 */         throw new RuntimeException("exit_voip_room_timeout format error");
/*     */       }
/*     */     }
/*     */     
/*  56 */     String closeVoipRoomTryimesValue = (String)envs.get("close_voip_room_try_times");
/*  57 */     if (closeVoipRoomTryimesValue != null)
/*     */     {
/*     */       try
/*     */       {
/*  61 */         int param = Integer.parseInt(closeVoipRoomTryimesValue);
/*  62 */         VoipRoomManager.CLOSE_VOIP_ROOM_TRY_TIMES = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  66 */         throw new RuntimeException("close_voip_room_try_times format error");
/*     */       }
/*     */     }
/*     */     
/*  70 */     String closeVoipRoomTimeoutValue = (String)envs.get("close_voip_room_timeout");
/*  71 */     if (exitVoipRoomTryimesValue != null)
/*     */     {
/*     */       try
/*     */       {
/*  75 */         int param = Integer.parseInt(closeVoipRoomTimeoutValue);
/*  76 */         VoipRoomManager.CLOSE_VOIP_ROOM_TIMEOUT = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  80 */         throw new RuntimeException("close_voip_room_timeout format error");
/*     */       }
/*     */     }
/*     */     
/*  84 */     String voipRoomProtectTimeInSecondValue = (String)envs.get("voip_room_protect_time_in_second");
/*  85 */     if (voipRoomProtectTimeInSecondValue != null)
/*     */     {
/*     */       try
/*     */       {
/*  89 */         int param = Integer.parseInt(voipRoomProtectTimeInSecondValue);
/*  90 */         VoipRoomManager.VOIP_ROOM_PROTECT_TIME_IN_SECOND = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  94 */         throw new RuntimeException("voip_room_protect_time_in_second format error");
/*     */       }
/*     */     }
/*     */     
/*  98 */     VoipRoomManager.init();
/*  99 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int exit()
/*     */   {
/* 105 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int cleanupForMerge()
/*     */   {
/* 111 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int loadconf(Map<String, String> envs, int reloadcount)
/*     */   {
/* 117 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\ApolloModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */