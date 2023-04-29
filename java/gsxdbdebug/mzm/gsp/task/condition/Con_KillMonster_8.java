/*     */ package mzm.gsp.task.condition;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.monster.main.MonsterInterface;
/*     */ import mzm.gsp.task.conParamObj.KillMonsterParamObj;
/*     */ import mzm.gsp.task.confbean.STask;
/*     */ import mzm.gsp.task.confbean.STaskConkillMonsterCount;
/*     */ import mzm.gsp.task.main.RoleTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ConBean;
/*     */ import xbean.Pod;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Con_KillMonster_8
/*     */   extends AbsCondition
/*     */ {
/*  20 */   private static final Logger logger = Logger.getLogger(Con_KillMonster_8.class);
/*     */   
/*     */   public Con_KillMonster_8(int conId, int conType, int sTaskId)
/*     */   {
/*  24 */     super(conId, conType, sTaskId);
/*     */   }
/*     */   
/*     */   STaskConkillMonsterCount getSConkillMonsterCount()
/*     */   {
/*  29 */     return STaskConkillMonsterCount.get(getConId());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isComplete(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*     */   {
/*  39 */     STaskConkillMonsterCount skilConkillMonsterCount = getSConkillMonsterCount();
/*  40 */     if (conMap != null)
/*     */     {
/*  42 */       ConBean conBean = (ConBean)conMap.get(Integer.valueOf(getConId()));
/*  43 */       if (conBean == null)
/*     */       {
/*  45 */         conBean = Pod.newConBean();
/*  46 */         conBean.setType(getType());
/*  47 */         conMap.put(Integer.valueOf(getConId()), conBean);
/*     */       }
/*     */       
/*  50 */       if (conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_KILL_MONSTER_COUNT.getParamType())))
/*     */       {
/*  52 */         long monsterCount = ((Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_KILL_MONSTER_COUNT.getParamType()))).longValue();
/*  53 */         if (monsterCount >= skilConkillMonsterCount.killMonsterCount)
/*     */         {
/*  55 */           return true;
/*     */         }
/*     */       }
/*     */       
/*  59 */       long count = 0L;
/*  60 */       Object obj = params.get(Integer.valueOf(getType()));
/*  61 */       if (obj == null)
/*     */       {
/*  63 */         conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_KILL_MONSTER_COUNT.getParamType()), Long.valueOf(count));
/*  64 */         if (skilConkillMonsterCount.contype == 2)
/*     */         {
/*  66 */           RoleTaskManager.sendConChangeMsg(roleId, graphId, getSTask().id, getConId(), count);
/*     */         }
/*  68 */         return false;
/*     */       }
/*  70 */       if ((obj instanceof KillMonsterParamObj))
/*     */       {
/*  72 */         KillMonsterParamObj killMonsterParamObj = (KillMonsterParamObj)obj;
/*  73 */         if ((killMonsterParamObj.getMapId() != skilConkillMonsterCount.killMonsterMapId) && (skilConkillMonsterCount.killMonsterMapId > 0))
/*     */         {
/*     */ 
/*  76 */           return false;
/*     */         }
/*  78 */         for (Map.Entry<Integer, Integer> idAndCountEntry : killMonsterParamObj.getMonsterIdToCountMap().entrySet())
/*     */         {
/*  80 */           if (((Integer)idAndCountEntry.getKey()).intValue() == skilConkillMonsterCount.killMonsterId)
/*     */           {
/*  82 */             count = ((Integer)idAndCountEntry.getValue()).intValue();
/*  83 */             if (conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_KILL_MONSTER_COUNT.getParamType())))
/*     */             {
/*  85 */               count = ((Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_KILL_MONSTER_COUNT.getParamType()))).longValue() + count;
/*  86 */               count = Math.min(count, skilConkillMonsterCount.killMonsterCount);
/*  87 */               conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_KILL_MONSTER_COUNT.getParamType()), Long.valueOf(count));
/*     */             }
/*     */             else
/*     */             {
/*  91 */               conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_KILL_MONSTER_COUNT.getParamType()), Long.valueOf(count));
/*     */             }
/*     */             
/*  94 */             if (skilConkillMonsterCount.contype == 2)
/*     */             {
/*  96 */               RoleTaskManager.sendConChangeMsg(roleId, graphId, getSTask().id, getConId(), count);
/*     */             }
/*  98 */             if (count >= skilConkillMonsterCount.killMonsterCount)
/*     */             {
/* 100 */               return true;
/*     */             }
/*     */             
/*     */           }
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 108 */         logger.error("杀怪传递的对象不是" + KillMonsterParamObj.class.getName());
/* 109 */         return false;
/*     */       }
/*     */     }
/* 112 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getType()
/*     */   {
/* 118 */     return 8;
/*     */   }
/*     */   
/*     */ 
/*     */   public void checkCfg()
/*     */   {
/* 124 */     STaskConkillMonsterCount skilConkillMonsterCount = getSConkillMonsterCount();
/* 125 */     if (!MapInterface.isHasMap(skilConkillMonsterCount.killMonsterMapId))
/*     */     {
/* 127 */       throw new RuntimeException("任务配置的地图不存在:mapId:" + skilConkillMonsterCount.killMonsterMapId + " taskId:" + getSTask().id + " 杀怪条件");
/*     */     }
/*     */     
/* 130 */     if (!MonsterInterface.isMonsterCfgExist(skilConkillMonsterCount.killMonsterId))
/*     */     {
/* 132 */       throw new RuntimeException("任务配置的怪物不存在:monsterId:" + skilConkillMonsterCount.killMonsterId + " taskId:" + getSTask().id + " 杀怪条件");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isVisiable(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params)
/*     */   {
/* 140 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public ConParam getSendParam(ConBean xConBean)
/*     */   {
/* 146 */     ConParam p = new ConParam();
/* 147 */     if (xConBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_KILL_MONSTER_COUNT.getParamType())))
/*     */     {
/* 149 */       p.setParam(((Long)xConBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_KILL_MONSTER_COUNT.getParamType()))).longValue());
/*     */     }
/* 151 */     return p;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_KillMonster_8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */