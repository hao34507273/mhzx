/*     */ package mzm.gsp.online.main;
/*     */ 
/*     */ import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.confConverter.ConfManager;
/*     */ 
/*     */ public class OnlineInfoArgs
/*     */ {
/*  11 */   private static OnlineInfoArgs instance = new OnlineInfoArgs();
/*     */   
/*     */   public static OnlineInfoArgs getInstance()
/*     */   {
/*  15 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  21 */   String mode = "tencent";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  31 */   String guestMode = "exclude";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   String onlineInfoTableName = "tb_mhzx_onlinecnt";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   String accountNumTableName = "tb_mhzx_account_num";
/*     */   
/*     */ 
/*     */ 
/*     */   @XStreamAsAttribute
/*  46 */   Map<String, AppInfo> appInfos = new java.util.HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  52 */   String wechatAppId = "wx5450e72520b1f41e";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  57 */   String wechatGuestAppId = "G_wx5450e72520b1f41e";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  62 */   String qqAppId = "1105218881";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  67 */   String qqGuestAppId = "G_1105218881";
/*     */   
/*  69 */   String sqlURL = null;
/*  70 */   String sqlUser = null;
/*  71 */   String sqlPassword = null;
/*     */   
/*     */   void initkAppIds()
/*     */   {
/*  75 */     for (AppInfo appInfo : this.appInfos.values())
/*     */     {
/*  77 */       if ("wechat".equals(appInfo.channel))
/*     */       {
/*  79 */         if (appInfo.appid.startsWith("G_"))
/*     */         {
/*  81 */           this.wechatGuestAppId = appInfo.appid;
/*     */         }
/*     */         else
/*     */         {
/*  85 */           this.wechatAppId = appInfo.appid;
/*     */         }
/*     */       }
/*  88 */       else if ("qq".equals(appInfo.channel))
/*     */       {
/*  90 */         if (appInfo.appid.startsWith("G_"))
/*     */         {
/*  92 */           this.qqGuestAppId = appInfo.appid;
/*     */         }
/*     */         else
/*     */         {
/*  96 */           this.qqAppId = appInfo.appid;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void initArgsFromSysProperty()
/*     */   {
/* 105 */     String modeValue = System.getProperty("com.zulong.mhzx.onlineinfomode");
/* 106 */     if ((modeValue != null) && (!modeValue.isEmpty()))
/*     */     {
/* 108 */       this.mode = modeValue;
/*     */     }
/*     */     
/*     */ 
/* 112 */     String guestModeValue = System.getProperty("com.zulong.mhzx.onlineinfo.guestmode");
/* 113 */     if ((guestModeValue != null) && (!guestModeValue.isEmpty()))
/*     */     {
/* 115 */       this.guestMode = guestModeValue;
/*     */     }
/*     */     
/* 118 */     String sqlURLValue = System.getProperty("com.zulong.mhzx.onlineinfo.sqlurl");
/* 119 */     if ((sqlURLValue != null) && (!sqlURLValue.isEmpty()))
/*     */     {
/* 121 */       this.sqlURL = sqlURLValue;
/*     */     }
/*     */     
/* 124 */     String sqlUserValue = System.getProperty("com.zulong.mhzx.onlineinfo.sqluser");
/* 125 */     if ((sqlUserValue != null) && (!sqlUserValue.isEmpty()))
/*     */     {
/* 127 */       this.sqlUser = sqlUserValue;
/*     */     }
/*     */     
/* 130 */     String sqlPasswordValue = System.getProperty("com.zulong.mhzx.onlineinfo.sqlpassword");
/* 131 */     if ((sqlPasswordValue != null) && (!sqlPasswordValue.isEmpty()))
/*     */     {
/* 133 */       this.sqlPassword = sqlPasswordValue;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void init()
/*     */   {
/* 142 */     instance = (OnlineInfoArgs)ConfManager.getInstance().getconf("mzm.gsp.online.main.OnlineInfoArgs");
/*     */     
/* 144 */     if (instance == null)
/*     */     {
/* 146 */       throw new RuntimeException("找不到登陆程序配置：mzm.gsp.online.main.OnlineInfoArgs");
/*     */     }
/*     */     
/* 149 */     instance.initArgsFromSysProperty();
/*     */     
/* 151 */     instance.initkAppIds();
/*     */   }
/*     */   
/*     */   public AppInfo getAppInfo(String appid)
/*     */   {
/* 156 */     return (AppInfo)this.appInfos.get(appid);
/*     */   }
/*     */   
/*     */   public String getQQAppid()
/*     */   {
/* 161 */     return this.qqAppId;
/*     */   }
/*     */   
/*     */   public String getQQGuestAppid()
/*     */   {
/* 166 */     return this.qqGuestAppId;
/*     */   }
/*     */   
/*     */   public String getWechatAppid()
/*     */   {
/* 171 */     return this.wechatAppId;
/*     */   }
/*     */   
/*     */   public String getWechatGuestAppid()
/*     */   {
/* 176 */     return this.wechatGuestAppId;
/*     */   }
/*     */   
/*     */   public java.sql.Connection getConnection() throws SQLException
/*     */   {
/* 181 */     if ((this.sqlURL == null) || (this.sqlUser == null) || (this.sqlPassword == null))
/*     */     {
/* 183 */       return null;
/*     */     }
/*     */     
/* 186 */     return DriverManager.getConnection(this.sqlURL, this.sqlUser, this.sqlPassword);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\OnlineInfoArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */