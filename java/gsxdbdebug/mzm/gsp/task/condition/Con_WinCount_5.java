/*     */ package mzm.gsp.task.condition;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.task.conParamObj.WinCountParamObj;
/*     */ import mzm.gsp.task.confbean.STask;
/*     */ import mzm.gsp.task.confbean.STaskConwinCount;
/*     */ import mzm.gsp.task.main.RoleTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ConBean;
/*     */ import xbean.Pod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Con_WinCount_5
/*     */   extends AbsCondition
/*     */ {
/*  20 */   private static final Logger logger = Logger.getLogger(Con_WinCount_5.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Con_WinCount_5(int conId, int conType, int sTaskId)
/*     */   {
/*  32 */     super(conId, conType, sTaskId);
/*     */   }
/*     */   
/*     */   STaskConwinCount getConwinCount()
/*     */   {
/*  37 */     return STaskConwinCount.get(getConId());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isComplete(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*     */   {
/*  46 */     STaskConwinCount conwinCount = getConwinCount();
/*  47 */     if (conMap != null)
/*     */     {
/*  49 */       ConBean conBean = (ConBean)conMap.get(Integer.valueOf(getConId()));
/*  50 */       if (conBean == null)
/*     */       {
/*  52 */         conBean = Pod.newConBean();
/*  53 */         conBean.setType(getType());
/*  54 */         conMap.put(Integer.valueOf(getConId()), conBean);
/*     */       }
/*  56 */       long count = 0L;
/*  57 */       if (conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_WIN_COUNT_COUNT.getParamType())))
/*     */       {
/*  59 */         count = ((Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_WIN_COUNT_COUNT.getParamType()))).longValue();
/*     */       }
/*  61 */       if (count >= conwinCount.winCount)
/*     */       {
/*  63 */         return true;
/*     */       }
/*     */       
/*  66 */       Object obj = params.get(Integer.valueOf(getType()));
/*  67 */       if (obj == null)
/*     */       {
/*  69 */         conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_WIN_COUNT_COUNT.getParamType()), Long.valueOf(count));
/*     */         
/*  71 */         if (getConType() == 2)
/*     */         {
/*  73 */           RoleTaskManager.sendConChangeMsg(roleId, graphId, getSTask().id, getConId(), count);
/*     */         }
/*  75 */         return false;
/*     */       }
/*  77 */       if ((obj instanceof WinCountParamObj))
/*     */       {
/*  79 */         WinCountParamObj winCountParamObj = (WinCountParamObj)obj;
/*  80 */         if ((conwinCount.mapId > 0) && (conwinCount.mapId == winCountParamObj.getMapId()))
/*     */         {
/*  82 */           if ((conwinCount.battleId > 0) && (conwinCount.battleId != (int)winCountParamObj.getBattleId()))
/*     */           {
/*  84 */             return false;
/*     */           }
/*  86 */           count += winCountParamObj.getCount();
/*  87 */           count = Math.min(count, conwinCount.winCount);
/*  88 */           conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_WIN_COUNT_COUNT.getParamType()), Long.valueOf(count));
/*     */           
/*  90 */           if (getConType() == 2)
/*     */           {
/*  92 */             RoleTaskManager.sendConChangeMsg(roleId, graphId, getSTask().id, getConId(), count);
/*     */           }
/*  94 */           if (count >= conwinCount.winCount)
/*     */           {
/*  96 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 102 */         logger.error("胜利次数传递的对象不是" + WinCountParamObj.class.getName());
/* 103 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 108 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getType()
/*     */   {
/* 114 */     return 5;
/*     */   }
/*     */   
/*     */ 
/*     */   public void checkCfg()
/*     */   {
/* 120 */     STaskConwinCount conwinCount = getConwinCount();
/* 121 */     int mapId = conwinCount.mapId;
/* 122 */     if ((mapId > 0) && (!MapInterface.isHasMap(mapId)))
/*     */     {
/* 124 */       throw new RuntimeException("[战斗胜利次数条件]任务配置的地图Id不存在,mapId" + conwinCount.mapId + ",taskId" + getSTask().id);
/*     */     }
/* 126 */     int fightCfgId = conwinCount.battleId;
/* 127 */     if ((fightCfgId > 0) && (FightInterface.getFightCfg(fightCfgId) == null))
/*     */     {
/* 129 */       throw new RuntimeException("[战斗胜利次数条件]任务配置的战斗id不存在,fightId=" + conwinCount.battleId + ",taskId=" + getSTask().id);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isVisiable(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params)
/*     */   {
/* 136 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ConParam getSendParam(ConBean xConBean)
/*     */   {
/* 148 */     ConParam p = new ConParam();
/* 149 */     if (xConBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_WIN_COUNT_COUNT.getParamType())))
/*     */     {
/* 151 */       p.setParam(((Long)xConBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_WIN_COUNT_COUNT.getParamType()))).longValue());
/*     */     }
/* 153 */     return p;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_WinCount_5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */