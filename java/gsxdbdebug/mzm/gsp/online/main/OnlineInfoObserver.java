/*     */ package mzm.gsp.online.main;
/*     */ 
/*     */ import gnet.link.Onlines;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Procedure;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class OnlineInfoObserver
/*     */   extends Observer
/*     */ {
/*  23 */   static final Set<String> appids = new HashSet();
/*     */   
/*     */   OnlineInfoObserver()
/*     */   {
/*  27 */     super(60L);
/*     */     
/*  29 */     String mode = OnlineInfoArgs.getInstance().mode;
/*  30 */     String guestMode = OnlineInfoArgs.getInstance().guestMode;
/*  31 */     if ("tencent".equals(mode))
/*     */     {
/*  33 */       if ("include".equals(guestMode))
/*     */       {
/*  35 */         appids.add(OnlineInfoArgs.getInstance().wechatAppId);
/*  36 */         appids.add(OnlineInfoArgs.getInstance().wechatGuestAppId);
/*  37 */         appids.add(OnlineInfoArgs.getInstance().qqAppId);
/*  38 */         appids.add(OnlineInfoArgs.getInstance().qqGuestAppId);
/*     */       }
/*  40 */       else if ("exclude".equals(guestMode))
/*     */       {
/*  42 */         appids.add(OnlineInfoArgs.getInstance().wechatAppId);
/*  43 */         appids.add(OnlineInfoArgs.getInstance().qqAppId);
/*     */       }
/*     */       else
/*     */       {
/*  47 */         appids.add(OnlineInfoArgs.getInstance().wechatGuestAppId);
/*  48 */         appids.add(OnlineInfoArgs.getInstance().qqGuestAppId);
/*     */       }
/*     */     }
/*  51 */     else if ("qq".equals(mode))
/*     */     {
/*  53 */       if ("include".equals(guestMode))
/*     */       {
/*  55 */         appids.add(OnlineInfoArgs.getInstance().qqAppId);
/*  56 */         appids.add(OnlineInfoArgs.getInstance().qqGuestAppId);
/*     */       }
/*  58 */       else if ("exclude".equals(guestMode))
/*     */       {
/*  60 */         appids.add(OnlineInfoArgs.getInstance().qqAppId);
/*     */       }
/*     */       else
/*     */       {
/*  64 */         appids.add(OnlineInfoArgs.getInstance().qqGuestAppId);
/*     */       }
/*     */     }
/*  67 */     else if ("wechat".equals(mode))
/*     */     {
/*  69 */       if ("include".equals(guestMode))
/*     */       {
/*  71 */         appids.add(OnlineInfoArgs.getInstance().wechatAppId);
/*  72 */         appids.add(OnlineInfoArgs.getInstance().wechatGuestAppId);
/*     */       }
/*  74 */       else if ("exclude".equals(guestMode))
/*     */       {
/*  76 */         appids.add(OnlineInfoArgs.getInstance().wechatAppId);
/*     */       }
/*     */       else
/*     */       {
/*  80 */         appids.add(OnlineInfoArgs.getInstance().wechatGuestAppId);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  88 */     Procedure.execute(new POnOnlineInfoObserverUpdate());
/*     */     
/*  90 */     return true;
/*     */   }
/*     */   
/*     */   static class POnOnlineInfoObserverUpdate
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  99 */       OnlineInfoFlusher.statisAccountNum(LoginManager.getInstance().getUserNum());
/*     */       
/*     */ 
/* 102 */       Map<String, OnlineInfoFlusher.OnlineInfo> onlineInfos = new HashMap();
/* 103 */       List<Long> roles = OnlineManager.getInstance().getAllRolesInWorld();
/* 104 */       for (Iterator i$ = roles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 106 */         if (Onlines.getInstance().find(Long.valueOf(roleid)) != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 111 */           String userid = RoleInterface.getUserId(roleid);
/* 112 */           String gameAppId = Onlines.getInstance().findGameAppid(userid);
/* 113 */           if ((gameAppId != null) && (!gameAppId.isEmpty()))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 118 */             OnlineInfoFlusher.OnlineInfo onlineInfo = (OnlineInfoFlusher.OnlineInfo)onlineInfos.get(gameAppId);
/* 119 */             if (onlineInfo == null)
/*     */             {
/* 121 */               onlineInfo = new OnlineInfoFlusher.OnlineInfo(gameAppId);
/* 122 */               onlineInfos.put(gameAppId, onlineInfo);
/*     */             }
/*     */             
/* 125 */             int platID = Onlines.getInstance().findPlatid(userid);
/* 126 */             if (platID == 0)
/*     */             {
/* 128 */               onlineInfo.onlinecntIOS += 1;
/*     */             }
/*     */             else
/*     */             {
/* 132 */               onlineInfo.onlinecntAndroid += 1; }
/*     */           }
/*     */         }
/*     */       }
/* 136 */       if (GameServerInfoManager.isRoamServer())
/*     */       {
/* 138 */         int totalOnlineNum = 0;
/* 139 */         for (OnlineInfoFlusher.OnlineInfo onlineInfo : onlineInfos.values())
/*     */         {
/* 141 */           totalOnlineNum += onlineInfo.onlinecntAndroid;
/* 142 */           totalOnlineNum += onlineInfo.onlinecntIOS;
/*     */         }
/* 144 */         CrossServerInterface.reportGameServerBalanceInfo(totalOnlineNum);
/*     */       }
/*     */       else
/*     */       {
/* 148 */         for (OnlineInfoFlusher.OnlineInfo onlineInfo : onlineInfos.values())
/*     */         {
/* 150 */           OnlineInfoFlusher.statisOnlineInfo(onlineInfo);
/*     */         }
/*     */         
/* 153 */         for (String gameAppId : OnlineInfoObserver.appids)
/*     */         {
/* 155 */           if (!onlineInfos.containsKey(gameAppId))
/*     */           {
/* 157 */             OnlineInfoFlusher.OnlineInfo onlineInfo = new OnlineInfoFlusher.OnlineInfo(gameAppId);
/* 158 */             OnlineInfoFlusher.statisOnlineInfo(onlineInfo);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 163 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\OnlineInfoObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */