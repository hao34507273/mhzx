/*     */ package mzm.gsp.map.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.map.SMapCommonResult;
/*     */ import mzm.gsp.map.confbean.SMapItemCfg;
/*     */ import mzm.gsp.map.main.message.MMH_AddMapItemGatherTask;
/*     */ import mzm.gsp.map.main.message.MMH_GetMapItemCfgid;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.GatherMapItemInfo;
/*     */ import xbean.Properties;
/*     */ 
/*     */ public class PCMapItemGather extends LogicProcedure implements MapCallback<Integer>
/*     */ {
/*  16 */   private static final MapItemGatherContext DUMMY = new MapItemGatherContext() {};
/*     */   
/*     */   private final long roleid;
/*     */   
/*     */   private final int instanceid;
/*     */   
/*     */   private final MapItemGatherContext context;
/*     */   
/*     */   public PCMapItemGather(long roleid, int instanceid)
/*     */   {
/*  26 */     this(roleid, instanceid, DUMMY);
/*     */   }
/*     */   
/*     */   public PCMapItemGather(long roleid, int instanceid, MapItemGatherContext context)
/*     */   {
/*  31 */     this.roleid = roleid;
/*  32 */     this.instanceid = instanceid;
/*  33 */     this.context = context;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (this.roleid < 0L)
/*     */     {
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!MapManager.canDoAction(this.roleid, 162))
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     new MMH_GetMapItemCfgid(this.instanceid, this).execute();
/*     */     
/*  51 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCallInProcedure()
/*     */   {
/*  57 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onResult(Integer mapItemCfgid)
/*     */   {
/*  63 */     if (mapItemCfgid == null)
/*     */     {
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     SMapItemCfg mapItemCfg = SMapItemCfg.get(mapItemCfgid.intValue());
/*  69 */     if (mapItemCfg == null)
/*     */     {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     if (!MapManager.canDoAction(this.roleid, 162))
/*     */     {
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     if ((mapItemCfg.gatherInterval > 0) || (mapItemCfg.dailyMaxGatherLimit > 0))
/*     */     {
/*  81 */       Properties xProperties = xtable.Role2properties.get(Long.valueOf(this.roleid));
/*  82 */       if (xProperties == null)
/*     */       {
/*  84 */         return false;
/*     */       }
/*     */       
/*  87 */       long currTime = DateTimeUtils.getCurrTimeInMillis();
/*  88 */       Map<Integer, GatherMapItemInfo> xGatherMapItemInfos = xProperties.getGather_map_item_infos();
/*  89 */       GatherMapItemInfo xGatherMapItemInfo = (GatherMapItemInfo)xGatherMapItemInfos.get(mapItemCfgid);
/*  90 */       if (xGatherMapItemInfo == null)
/*     */       {
/*  92 */         xGatherMapItemInfo = xbean.Pod.newGatherMapItemInfo();
/*  93 */         xGatherMapItemInfos.put(mapItemCfgid, xGatherMapItemInfo);
/*     */       }
/*     */       else
/*     */       {
/*  97 */         if (mapItemCfg.gatherInterval > 0)
/*     */         {
/*  99 */           long oldTime = xGatherMapItemInfo.getRequest_gather_timestamp();
/* 100 */           if ((currTime - oldTime) / 1000L <= mapItemCfg.gatherInterval)
/*     */           {
/* 102 */             SMapCommonResult mapCommonResult = new SMapCommonResult();
/* 103 */             mapCommonResult.result = 105;
/* 104 */             OnlineManager.getInstance().sendAtOnce(this.roleid, mapCommonResult);
/*     */             
/* 106 */             return false;
/*     */           }
/*     */         }
/*     */         
/* 110 */         if ((mapItemCfg.dailyMaxGatherLimit > 0) && (!DateTimeUtils.needDailyReset(xGatherMapItemInfo.getGather_success_timestamp(), currTime, 0)) && (xGatherMapItemInfo.getGather_success_times() >= mapItemCfg.dailyMaxGatherLimit))
/*     */         {
/*     */ 
/*     */ 
/* 114 */           SMapCommonResult mapCommonResult = new SMapCommonResult();
/* 115 */           mapCommonResult.result = 104;
/* 116 */           OnlineManager.getInstance().sendAtOnce(this.roleid, mapCommonResult);
/*     */           
/* 118 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 122 */       if (mapItemCfg.gatherInterval > 0)
/*     */       {
/* 124 */         xGatherMapItemInfo.setRequest_gather_timestamp(currTime);
/*     */       }
/*     */     }
/*     */     
/* 128 */     new MMH_AddMapItemGatherTask(this.roleid, this.instanceid, this.context).execute();
/*     */     
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PCMapItemGather.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */