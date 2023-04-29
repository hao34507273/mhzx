/*     */ package mzm.gsp.task.condition;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.task.conParamObj.ShareParamObj;
/*     */ import mzm.gsp.task.confbean.STask;
/*     */ import mzm.gsp.task.confbean.STaskConSharePengYouQuan;
/*     */ import mzm.gsp.task.main.RoleTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ConBean;
/*     */ import xbean.Pod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Con_Share_20
/*     */   extends AbsCondition
/*     */ {
/*     */   public Con_Share_20(int conId, int conType, int sTaskId)
/*     */   {
/*  24 */     super(conId, conType, sTaskId);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isComplete(long roleId, Map<Integer, ConBean> xConMap, Map<Integer, Object> params, int graphId)
/*     */   {
/*  30 */     STaskConSharePengYouQuan cfg = STaskConSharePengYouQuan.get(getConId());
/*  31 */     if (cfg == null)
/*     */     {
/*  33 */       GameServer.logger().error(String.format("[task]Con_Share_20.isComplete@STaskConSharePengYouQuan is null!|roleId=%d|graphId=%d|taskId=%d|conId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(getTaskId()), Integer.valueOf(getConId()) }));
/*     */       
/*     */ 
/*     */ 
/*  37 */       return false;
/*     */     }
/*  39 */     ConBean conBean = getConBeanIfAbsent(xConMap);
/*  40 */     if (isDBDataFinished(cfg, conBean))
/*     */     {
/*  42 */       return true;
/*     */     }
/*  44 */     Long alreadyShareCount = (Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_SHARE_PENGYOUQUAN.getParamType()));
/*  45 */     if (alreadyShareCount == null)
/*     */     {
/*  47 */       alreadyShareCount = new Long(0L);
/*     */     }
/*  49 */     Object obj = params.get(Integer.valueOf(getType()));
/*  50 */     if (obj == null)
/*     */     {
/*  52 */       conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_SHARE_PENGYOUQUAN.getParamType()), alreadyShareCount);
/*  53 */       if (cfg.contype == 2)
/*     */       {
/*  55 */         RoleTaskManager.sendConChangeMsg(roleId, graphId, getSTask().id, getConId(), alreadyShareCount.longValue());
/*     */       }
/*  57 */       return false;
/*     */     }
/*  59 */     if (!(obj instanceof ShareParamObj))
/*     */     {
/*  61 */       GameServer.logger().error(String.format("[task]Con_Share_20.isComplete@ obj is not ShareParamObj!|roleId=%d|graphId=%d|taskId=%d|conId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(getTaskId()), Integer.valueOf(getConId()) }));
/*     */       
/*     */ 
/*     */ 
/*  65 */       return false;
/*     */     }
/*  67 */     ShareParamObj shareObj = (ShareParamObj)obj;
/*  68 */     if (shareObj.getShareId() != cfg.shareId)
/*     */     {
/*  70 */       GameServer.logger().info(String.format("[task]Con_Share_20.isComplete@ not need shareId!|roleId=%d|graphId=%d|taskId=%d|conId=%d|needShareId=%d|thisShareId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(getTaskId()), Integer.valueOf(getConId()), Integer.valueOf(cfg.shareId), Integer.valueOf(shareObj.getShareId()) }));
/*     */       
/*     */ 
/*     */ 
/*  74 */       return false;
/*     */     }
/*  76 */     int addShareCount = shareObj.getShareCount();
/*  77 */     if (addShareCount <= 0)
/*     */     {
/*  79 */       return false;
/*     */     }
/*  81 */     alreadyShareCount = Long.valueOf(alreadyShareCount.longValue() + addShareCount);
/*  82 */     long dbNum = alreadyShareCount.longValue() > cfg.needShareCount ? cfg.needShareCount : alreadyShareCount.longValue();
/*  83 */     conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_SHARE_PENGYOUQUAN.getParamType()), Long.valueOf(dbNum));
/*  84 */     if (dbNum < cfg.needShareCount)
/*     */     {
/*  86 */       RoleTaskManager.sendConChangeMsg(roleId, graphId, getSTask().id, getConId(), dbNum);
/*  87 */       return false;
/*     */     }
/*  89 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private ConBean getConBeanIfAbsent(Map<Integer, ConBean> xConMap)
/*     */   {
/* 100 */     ConBean xConBean = (ConBean)xConMap.get(Integer.valueOf(getConId()));
/* 101 */     if (xConBean == null)
/*     */     {
/* 103 */       xConBean = Pod.newConBean();
/* 104 */       xConBean.setType(getType());
/* 105 */       xConMap.put(Integer.valueOf(getConId()), xConBean);
/*     */     }
/* 107 */     return xConBean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isDBDataFinished(STaskConSharePengYouQuan cfg, ConBean conBean)
/*     */   {
/* 119 */     Long shareCount = (Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_SHARE_PENGYOUQUAN.getParamType()));
/* 120 */     if (shareCount == null)
/*     */     {
/* 122 */       return false;
/*     */     }
/* 124 */     return shareCount.longValue() >= cfg.needShareCount;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getType()
/*     */   {
/* 130 */     return 20;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void checkCfg() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ConParam getSendParam(ConBean xConBean)
/*     */   {
/* 148 */     ConParam p = new ConParam();
/* 149 */     if (xConBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_SHARE_PENGYOUQUAN.getParamType())))
/*     */     {
/* 151 */       p.setParam(((Long)xConBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_SHARE_PENGYOUQUAN.getParamType()))).longValue());
/*     */     }
/* 153 */     return p;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_Share_20.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */