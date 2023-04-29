/*     */ package mzm.gsp.gm.main;
/*     */ 
/*     */ import mzm.gsp.gm.SGMMessageTipRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ 
/*     */ public class GmManager
/*     */ {
/*   8 */   private static GmManager instance = new GmManager();
/*     */   
/*     */   public static GmManager getInstance()
/*     */   {
/*  12 */     return instance;
/*     */   }
/*     */   
/*  15 */   static xdb.util.Counter counterInvoke = new xdb.util.Counter(xdb.Xdb.mbeans(), "gm", "cmdCounterInvoke");
/*  16 */   static xdb.util.Counter counterSuccess = new xdb.util.Counter(xdb.Xdb.mbeans(), "gm", "cmdCounterSuccess");
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  23 */   private volatile boolean debug = false;
/*     */   
/*     */   public void sendResultToAll(String result)
/*     */   {
/*  27 */     if (result == null)
/*     */     {
/*  29 */       return;
/*     */     }
/*     */     
/*  32 */     SGMMessageTipRes msg = new SGMMessageTipRes();
/*  33 */     msg.result = Integer.MAX_VALUE;
/*  34 */     msg.args.add(result);
/*  35 */     OnlineManager.getInstance().sendAllAtOnce(msg);
/*     */   }
/*     */   
/*     */   public void sendResultToAll(int strId, Object... args)
/*     */   {
/*  40 */     SGMMessageTipRes msg = new SGMMessageTipRes();
/*  41 */     msg.result = strId;
/*  42 */     for (Object obj : args)
/*     */     {
/*  44 */       msg.args.add(obj.toString());
/*     */     }
/*  46 */     OnlineManager.getInstance().sendAllAtOnce(msg);
/*     */   }
/*     */   
/*     */   public void sendResultToGM(long gmRoleId, String result)
/*     */   {
/*  51 */     if (result == null)
/*     */     {
/*  53 */       return;
/*     */     }
/*     */     
/*  56 */     SGMMessageTipRes msg = new SGMMessageTipRes();
/*  57 */     msg.result = Integer.MAX_VALUE;
/*  58 */     msg.args.add(result);
/*  59 */     OnlineManager.getInstance().sendAtOnce(gmRoleId, msg);
/*     */   }
/*     */   
/*     */   public void sendResultToGM(long gmRoleId, int strId, Object... args)
/*     */   {
/*  64 */     SGMMessageTipRes msg = new SGMMessageTipRes();
/*  65 */     msg.result = strId;
/*  66 */     for (Object obj : args)
/*     */     {
/*  68 */       msg.args.add(obj.toString());
/*     */     }
/*  70 */     OnlineManager.getInstance().sendAtOnce(gmRoleId, msg);
/*     */   }
/*     */   
/*     */   public SGMMessageTipRes makeGMResult(String result)
/*     */   {
/*  75 */     SGMMessageTipRes msg = new SGMMessageTipRes();
/*  76 */     msg.result = Integer.MAX_VALUE;
/*  77 */     msg.args.add(result);
/*  78 */     return msg;
/*     */   }
/*     */   
/*     */   public SGMMessageTipRes makeGMResult(int strId, Object... args)
/*     */   {
/*  83 */     SGMMessageTipRes msg = new SGMMessageTipRes();
/*  84 */     msg.result = strId;
/*  85 */     for (Object obj : args)
/*     */     {
/*  87 */       msg.args.add(obj.toString());
/*     */     }
/*     */     
/*  90 */     return msg;
/*     */   }
/*     */   
/*     */   public synchronized boolean closeDebugEnvForIDIP()
/*     */   {
/*  95 */     if (this.debug)
/*     */     {
/*  97 */       this.debug = false;
/*     */       
/*  99 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 103 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   final synchronized void openDebugEnv()
/*     */   {
/* 109 */     this.debug = true;
/*     */   }
/*     */   
/*     */   final boolean isDebugEnv()
/*     */   {
/* 114 */     return this.debug;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\GmManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */