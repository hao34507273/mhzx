/*     */ package mzm.gsp.task.condition;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.task.conParamObj.ToPlaceParamObj;
/*     */ import mzm.gsp.task.confbean.STask;
/*     */ import mzm.gsp.task.confbean.STaskContoPlace;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ConBean;
/*     */ import xbean.Pod;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Con_ToPlace_4
/*     */   extends AbsCondition
/*     */ {
/*  17 */   private static final Logger logger = Logger.getLogger(Con_ToPlace_4.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Con_ToPlace_4(int conId, int conType, int sTaskId)
/*     */   {
/*  29 */     super(conId, conType, sTaskId);
/*     */   }
/*     */   
/*     */   public STaskContoPlace getContoPlace()
/*     */   {
/*  34 */     return STaskContoPlace.get(getConId());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isComplete(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*     */   {
/*  44 */     STaskContoPlace contoPlace = getContoPlace();
/*  45 */     if (conMap != null)
/*     */     {
/*  47 */       ConBean conBean = (ConBean)conMap.get(Integer.valueOf(getConId()));
/*  48 */       if (conBean == null)
/*     */       {
/*  50 */         conBean = Pod.newConBean();
/*  51 */         conBean.setType(getType());
/*  52 */         conMap.put(Integer.valueOf(getConId()), conBean);
/*     */       }
/*  54 */       long mapid = -1L;
/*  55 */       long x = -1L;
/*  56 */       long y = -1L;
/*  57 */       long z = 0L;
/*  58 */       if (conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_TO_PLACE_MAP_ID.getParamType())))
/*     */       {
/*  60 */         mapid = ((Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_TO_PLACE_MAP_ID.getParamType()))).longValue();
/*     */       }
/*  62 */       if (conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_TO_PLACE_X.getParamType())))
/*     */       {
/*  64 */         x = ((Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_TO_PLACE_X.getParamType()))).longValue();
/*     */       }
/*  66 */       if (conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_TO_PLACE_Y.getParamType())))
/*     */       {
/*  68 */         y = ((Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_TO_PLACE_Y.getParamType()))).longValue();
/*     */       }
/*  70 */       if (conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_TO_PLACE_Z.getParamType())))
/*     */       {
/*  72 */         z = ((Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_TO_PLACE_Z.getParamType()))).longValue();
/*     */       }
/*  74 */       if ((mapid == contoPlace.mapId) && (x == contoPlace.x) && (y == contoPlace.y) && (z == contoPlace.z))
/*     */       {
/*  76 */         return true;
/*     */       }
/*  78 */       Object obj = params.get(Integer.valueOf(getType()));
/*  79 */       if (obj == null)
/*     */       {
/*  81 */         return false;
/*     */       }
/*  83 */       if ((obj instanceof ToPlaceParamObj))
/*     */       {
/*  85 */         ToPlaceParamObj paramObj = (ToPlaceParamObj)obj;
/*  86 */         mapid = paramObj.getMapId();
/*  87 */         x = paramObj.getX();
/*  88 */         y = paramObj.getY();
/*  89 */         z = paramObj.getZ();
/*     */       }
/*     */       else
/*     */       {
/*  93 */         logger.error("传递的对象不是" + ToPlaceParamObj.class.getName());
/*  94 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  99 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getType()
/*     */   {
/* 105 */     return 4;
/*     */   }
/*     */   
/*     */ 
/*     */   public void checkCfg()
/*     */   {
/* 111 */     STaskContoPlace contoPlace = getContoPlace();
/* 112 */     if (!MapInterface.isHasMap(contoPlace.mapId))
/*     */     {
/* 114 */       throw new RuntimeException("任务配置的地图Id不存在,mapId" + contoPlace.mapId + ",taskId" + getSTask().id + " 到达地点条件");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isVisiable(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params)
/*     */   {
/* 121 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_ToPlace_4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */