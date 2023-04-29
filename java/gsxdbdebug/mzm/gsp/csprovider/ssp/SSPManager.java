/*     */ package mzm.gsp.csprovider.ssp;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenGameAndSocialSpaceArg;
/*     */ import csprovider.DataBetweenGameAndSocialSpaceRes;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.util.CommonHandlerManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ class SSPManager
/*     */ {
/*     */   private static final String ENCODING = "UTF-8";
/*  15 */   static final CommonHandlerManager<Integer, SSPHandler> sspHandlerMgr = new CommonHandlerManager();
/*     */   
/*     */   static
/*     */   {
/*  19 */     sspHandlerMgr.addHandler(Integer.valueOf(5), new SSP_GiveGift());
/*     */     
/*  21 */     sspHandlerMgr.addHandler(Integer.valueOf(4), new SSP_PlaceTreasure());
/*     */     
/*  23 */     sspHandlerMgr.addHandler(Integer.valueOf(1), new SSP_ReportRoleBaseInfo());
/*     */     
/*  25 */     sspHandlerMgr.addHandler(Integer.valueOf(3), new SSP_TreadSpace());
/*     */     
/*  27 */     sspHandlerMgr.addHandler(Integer.valueOf(7), new SSP_UpdateFriends());
/*     */     
/*  29 */     sspHandlerMgr.addHandler(Integer.valueOf(2), new SSP_UpdateSpaceStyle());
/*     */     
/*  31 */     sspHandlerMgr.addHandler(Integer.valueOf(9), new SSP_UpdateBlacklist());
/*     */     
/*  33 */     sspHandlerMgr.addHandler(Integer.valueOf(12), new SSP_UpdateRoleImportantValue());
/*     */   }
/*     */   
/*     */ 
/*     */   static final void onServer(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res)
/*     */   {
/*  39 */     SSPHandler hanlder = (SSPHandler)sspHandlerMgr.getHandler(Integer.valueOf(arg.qtype));
/*  40 */     if (hanlder == null)
/*     */     {
/*  42 */       GameServer.logger().warn(String.format("[ssp]SSPManager.onServer@handler is null|qtype=%d|data=%s", new Object[] { Integer.valueOf(arg.qtype), convertOctetsToStr(arg.data) }));
/*     */       
/*     */ 
/*  45 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  50 */       hanlder.onServer(arg, res);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  54 */       res.retcode = 40010;
/*     */       
/*  56 */       GameServer.logger().error(String.format("[ssp]SSPManager.onServer@ssp handle error|qtype=%d|data=%s", new Object[] { Integer.valueOf(arg.qtype), convertOctetsToStr(arg.data) }), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static final void onClient(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*     */   {
/*  65 */     SSPHandler hanlder = (SSPHandler)sspHandlerMgr.getHandler(Integer.valueOf(arg.qtype));
/*  66 */     if (hanlder == null)
/*     */     {
/*  68 */       GameServer.logger().warn(String.format("[ssp]SSPManager.onClient@handler is null|qtype=%d|data=%s", new Object[] { Integer.valueOf(arg.qtype), convertOctetsToStr(arg.data) }));
/*     */       
/*     */ 
/*  71 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  76 */       hanlder.onClient(arg, res, context);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  80 */       GameServer.logger().error(String.format("[ssp]SSPManager.onClient@ssp handle error|qtype=%d|data=%s", new Object[] { Integer.valueOf(arg.qtype), convertOctetsToStr(arg.data) }), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static final void onTimeout(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*     */   {
/*  89 */     SSPHandler hanlder = (SSPHandler)sspHandlerMgr.getHandler(Integer.valueOf(arg.qtype));
/*  90 */     if (hanlder == null)
/*     */     {
/*  92 */       GameServer.logger().warn(String.format("[ssp]SSPManager.onTimeout@handler is null|qtype=%d|data=%s", new Object[] { Integer.valueOf(arg.qtype), convertOctetsToStr(arg.data) }));
/*     */       
/*     */ 
/*  95 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 100 */       hanlder.onTimeout(arg, res, context);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 104 */       GameServer.logger().error(String.format("[ssp]SSPManager.onTimeout@ssp handle error|qtype=%d|data=%s", new Object[] { Integer.valueOf(arg.qtype), convertOctetsToStr(arg.data) }), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static String convertOctetsToStr(Octets octets)
/*     */   {
/*     */     try
/*     */     {
/* 114 */       return new String(octets.getBytes(), "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/* 118 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\ssp\SSPManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */