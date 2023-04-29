/*     */ package mzm.gsp.personal.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.occupation.confbean.RoleCommonConstants;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.personal.AdvertInfo;
/*     */ import mzm.gsp.personal.ConditionInfo;
/*     */ import mzm.gsp.personal.SSearchAdvertsFailed;
/*     */ import mzm.gsp.personal.SSearchAdvertsSuccess;
/*     */ import mzm.gsp.personal.confbean.PersonalOptionCfg;
/*     */ import mzm.gsp.personal.confbean.SNSConsts;
/*     */ import mzm.gsp.personal.confbean.SNSSubTypeCfg;
/*     */ import mzm.gsp.personal.confbean.SPersonalCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PersonalInfo;
/*     */ import xtable.Role2personal;
/*     */ 
/*     */ public class PCSearchAdverts extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int advertType;
/*     */   private final int page;
/*     */   private final boolean refresh;
/*     */   private final ConditionInfo queryConditionInfo;
/*     */   
/*     */   public PCSearchAdverts(long roleId, int advertType, int page, int refresh, ConditionInfo queryConditionInfo)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.advertType = advertType;
/*  38 */     this.page = page;
/*  39 */     this.refresh = (refresh == 1);
/*  40 */     this.queryConditionInfo = queryConditionInfo;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     GameServer.logger().info(String.format("[personal]PCSearchAdverts.processImp@search adverts begin|roleid=%d|advert_type=%d|page=%d|refresh=%b|gender=%d|min_level=%d|max_level=%d|location=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.advertType), Integer.valueOf(this.page), Boolean.valueOf(this.refresh), Integer.valueOf(this.queryConditionInfo.gender), Integer.valueOf(this.queryConditionInfo.minlevel), Integer.valueOf(this.queryConditionInfo.maxlevel), Integer.valueOf(this.queryConditionInfo.location) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  52 */     if (!SNSManager.isFunOpen(this.roleId))
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     if (!SNSManager.checkRoleStatus(this.roleId))
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     if (!SNSSubTypeCfg.getAll().containsKey(Integer.valueOf(this.advertType)))
/*     */     {
/*     */ 
/*  66 */       onFailed(0);
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     if (this.page <= 0)
/*     */     {
/*  72 */       onFailed(8);
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     if (!checkGender(this.queryConditionInfo.gender))
/*     */     {
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     if (!checkLevel(this.queryConditionInfo.minlevel, this.queryConditionInfo.maxlevel))
/*     */     {
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if (!checkLocation(this.queryConditionInfo.location))
/*     */     {
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     if (RoleInterface.getLevel(this.roleId) < SNSConsts.getInstance().OPEN_LEVEL)
/*     */     {
/*     */ 
/*  94 */       onFailed(13);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     if (this.refresh)
/*     */     {
/* 100 */       long now = DateTimeUtils.getCurrTimeInMillis();
/* 101 */       PersonalInfo xPersonalInfo = Role2personal.get(Long.valueOf(this.roleId));
/* 102 */       if (xPersonalInfo != null)
/*     */       {
/* 104 */         Long refreshTimestamp = (Long)xPersonalInfo.getRefreshadvert().get(Integer.valueOf(this.advertType));
/* 105 */         if ((refreshTimestamp != null) && (refreshTimestamp.longValue() + TimeUnit.SECONDS.toMillis(SNSConsts.getInstance().REFRESH_INTERVAL) > now))
/*     */         {
/*     */ 
/* 108 */           onFailed(12);
/* 109 */           return false;
/*     */         }
/*     */         
/*     */       }
/*     */       else
/*     */       {
/* 115 */         xPersonalInfo = xbean.Pod.newPersonalInfo();
/* 116 */         PersonalManager.initXPersonalInfo(this.roleId, xPersonalInfo);
/* 117 */         Role2personal.insert(Long.valueOf(this.roleId), xPersonalInfo);
/*     */       }
/* 119 */       xPersonalInfo.getRefreshadvert().put(Integer.valueOf(this.advertType), Long.valueOf(now));
/*     */     }
/*     */     
/* 122 */     SearchInfo searchInfo = new SearchInfo(this.advertType, this.queryConditionInfo);
/* 123 */     List<AdvertChart> advertCharts = SNSRankManager.getInstance().search(searchInfo, this.page, false);
/* 124 */     if (advertCharts == null)
/*     */     {
/*     */ 
/* 127 */       boolean isAdd = SearchTaskOneByOne.getInstance().addTask(new PSearchTask(this.roleId, this.advertType, this.queryConditionInfo, this.page, this.refresh));
/*     */       
/* 129 */       if (isAdd)
/*     */       {
/* 131 */         GameServer.logger().info(String.format("[personal]PCSearchAdverts.processImp@add search queue|roleid=%d|advert_type=%d|page=%d|refresh=%b|gender=%d|min_level=%d|max_level=%d|location=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.advertType), Integer.valueOf(this.page), Boolean.valueOf(this.refresh), Integer.valueOf(this.queryConditionInfo.gender), Integer.valueOf(this.queryConditionInfo.minlevel), Integer.valueOf(this.queryConditionInfo.maxlevel), Integer.valueOf(this.queryConditionInfo.location) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 137 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 141 */       onFailed(14);
/* 142 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 147 */     int size = SNSRankManager.getInstance().getSize(searchInfo);
/* 148 */     ArrayList<AdvertInfo> advertInfos = AdvertDataCache.getInstance().buildResp(advertCharts);
/*     */     
/* 150 */     SSearchAdvertsSuccess resp = new SSearchAdvertsSuccess();
/* 151 */     resp.adverttype = this.advertType;
/* 152 */     resp.page = this.page;
/* 153 */     resp.size = size;
/* 154 */     resp.adverts = advertInfos;
/* 155 */     OnlineManager.getInstance().send(this.roleId, resp);
/*     */     
/* 157 */     GameServer.logger().info(String.format("[personal]PCSearchAdverts.processImp@search adverts success|roleid=%d|advert_type=%d|page=%d|refresh=%b|gender=%d|min_level=%d|max_level=%d|location=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.advertType), Integer.valueOf(this.page), Boolean.valueOf(this.refresh), Integer.valueOf(this.queryConditionInfo.gender), Integer.valueOf(this.queryConditionInfo.minlevel), Integer.valueOf(this.queryConditionInfo.maxlevel), Integer.valueOf(this.queryConditionInfo.location) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 163 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onFailed(int retCode)
/*     */   {
/* 170 */     SSearchAdvertsFailed resp = new SSearchAdvertsFailed();
/* 171 */     resp.adverttype = this.advertType;
/* 172 */     resp.page = this.page;
/* 173 */     resp.retcode = retCode;
/* 174 */     OnlineManager.getInstance().sendAtOnce(this.roleId, resp);
/*     */     
/* 176 */     GameServer.logger().error(String.format("[personal]PCSearchAdverts.onFailed@search adverts failed|roleId=%d|advertType=%d|page=%d|refresh=%b|gender=%d|minLevel=%d|maxLevel=%d|location=%d|ret=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.advertType), Integer.valueOf(this.page), Boolean.valueOf(this.refresh), Integer.valueOf(this.queryConditionInfo.gender), Integer.valueOf(this.queryConditionInfo.minlevel), Integer.valueOf(this.queryConditionInfo.maxlevel), Integer.valueOf(this.queryConditionInfo.location), Integer.valueOf(retCode) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkGender(int gender)
/*     */   {
/* 186 */     if (gender == -1)
/*     */     {
/* 188 */       return true;
/*     */     }
/*     */     
/* 191 */     int optionId = SPersonalCfg.get(4).optionId;
/* 192 */     PersonalOptionCfg optionCfg = PersonalOptionCfg.get(optionId);
/* 193 */     if (optionCfg == null)
/*     */     {
/* 195 */       onFailed(6);
/* 196 */       return false;
/*     */     }
/* 198 */     if (!optionCfg.optionCfgIds.contains(Integer.valueOf(gender)))
/*     */     {
/* 200 */       onFailed(11);
/* 201 */       return false;
/*     */     }
/*     */     
/* 204 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkLevel(int minLevel, int maxLevel)
/*     */   {
/* 209 */     if ((minLevel <= 0) || (maxLevel <= 0) || (minLevel > maxLevel))
/*     */     {
/* 211 */       onFailed(9);
/* 212 */       return false;
/*     */     }
/*     */     
/* 215 */     int levelInterval = SNSConsts.getInstance().ROLE_LEVEL_INTERVAL;
/* 216 */     int openLevel = SNSConsts.getInstance().OPEN_LEVEL;
/* 217 */     int limitLevel = ServerInterface.getCurrentServerLevel() + RoleCommonConstants.getInstance().ROLE_LEVEL_MORE_THAN_SERVER_LEVEL;
/*     */     
/*     */ 
/* 220 */     if (minLevel == openLevel)
/*     */     {
/*     */ 
/* 223 */       if (maxLevel == limitLevel)
/*     */       {
/* 225 */         return true;
/*     */       }
/*     */       
/* 228 */       if ((maxLevel - openLevel) % levelInterval != 0)
/*     */       {
/* 230 */         onFailed(9);
/* 231 */         return false;
/*     */       }
/* 233 */       return true;
/*     */     }
/* 235 */     if (maxLevel == limitLevel)
/*     */     {
/*     */ 
/*     */ 
/* 239 */       if (minLevel == limitLevel)
/*     */       {
/* 241 */         return true;
/*     */       }
/*     */       
/* 244 */       if ((minLevel - openLevel) % levelInterval != 0)
/*     */       {
/* 246 */         onFailed(9);
/* 247 */         return false;
/*     */       }
/* 249 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 253 */     onFailed(9);
/* 254 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean checkLocation(int location)
/*     */   {
/* 260 */     if (location == -1)
/*     */     {
/* 262 */       return true;
/*     */     }
/*     */     
/* 265 */     int optionId = SPersonalCfg.get(14).optionId;
/* 266 */     PersonalOptionCfg optionCfg = PersonalOptionCfg.get(optionId);
/* 267 */     if (optionCfg == null)
/*     */     {
/* 269 */       onFailed(6);
/* 270 */       return false;
/*     */     }
/* 272 */     if (!optionCfg.optionCfgIds.contains(Integer.valueOf(location)))
/*     */     {
/* 274 */       onFailed(10);
/* 275 */       return false;
/*     */     }
/*     */     
/* 278 */     return true;
/*     */   }
/*     */   
/*     */   private class PSearchTask
/*     */     extends SearchBaseProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int advertType;
/*     */     private final ConditionInfo queryConditionInfo;
/*     */     private final int page;
/*     */     private final boolean refresh;
/*     */     
/*     */     public PSearchTask(long roleId, int advertType, ConditionInfo queryConditionInfo, int page, boolean refresh)
/*     */     {
/* 292 */       this.roleId = roleId;
/* 293 */       this.advertType = advertType;
/* 294 */       this.queryConditionInfo = queryConditionInfo;
/* 295 */       this.page = page;
/* 296 */       this.refresh = refresh;
/*     */     }
/*     */     
/*     */     protected boolean search()
/*     */       throws Exception
/*     */     {
/* 302 */       if (!SNSManager.isFunOpen(this.roleId))
/*     */       {
/* 304 */         return false;
/*     */       }
/*     */       
/* 307 */       if (!SNSSubTypeCfg.getAll().containsKey(Integer.valueOf(this.advertType)))
/*     */       {
/*     */ 
/* 310 */         PCSearchAdverts.this.onFailed(0);
/* 311 */         return false;
/*     */       }
/*     */       
/* 314 */       if (!PCSearchAdverts.this.checkGender(this.queryConditionInfo.gender))
/*     */       {
/* 316 */         return false;
/*     */       }
/*     */       
/* 319 */       if (!PCSearchAdverts.this.checkLevel(this.queryConditionInfo.minlevel, this.queryConditionInfo.maxlevel))
/*     */       {
/* 321 */         return false;
/*     */       }
/*     */       
/* 324 */       if (!PCSearchAdverts.this.checkLocation(this.queryConditionInfo.location))
/*     */       {
/* 326 */         return false;
/*     */       }
/*     */       
/* 329 */       if (RoleInterface.getLevel(this.roleId) < SNSConsts.getInstance().OPEN_LEVEL)
/*     */       {
/*     */ 
/* 332 */         PCSearchAdverts.this.onFailed(13);
/* 333 */         return false;
/*     */       }
/*     */       
/* 336 */       SearchInfo searchInfo = new SearchInfo(this.advertType, this.queryConditionInfo);
/* 337 */       List<AdvertChart> advertCharts = SNSRankManager.getInstance().search(searchInfo, this.page, true);
/* 338 */       int size = SNSRankManager.getInstance().getSize(searchInfo);
/* 339 */       ArrayList<AdvertInfo> advertInfos = AdvertDataCache.getInstance().buildResp(advertCharts);
/*     */       
/* 341 */       SSearchAdvertsSuccess resp = new SSearchAdvertsSuccess();
/* 342 */       resp.adverttype = this.advertType;
/* 343 */       resp.page = this.page;
/* 344 */       resp.size = size;
/* 345 */       resp.adverts = advertInfos;
/* 346 */       OnlineManager.getInstance().send(this.roleId, resp);
/*     */       
/* 348 */       GameServer.logger().info(String.format("[personal]PCSearchAdverts.processImp@search adverts success|roleid=%d|advert_type=%d|page=%d|refresh=%b|gender=%d|min_level=%d|max_level=%d|location=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.advertType), Integer.valueOf(this.page), Boolean.valueOf(this.refresh), Integer.valueOf(this.queryConditionInfo.gender), Integer.valueOf(this.queryConditionInfo.minlevel), Integer.valueOf(this.queryConditionInfo.maxlevel), Integer.valueOf(this.queryConditionInfo.location) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 354 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\PCSearchAdverts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */