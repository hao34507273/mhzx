/*     */ package mzm.gsp.task.condition;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.task.conParamObj.NpcDlgParamObj;
/*     */ import mzm.gsp.task.confbean.STask;
/*     */ import mzm.gsp.task.confbean.STaskConnpcDialog;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ConBean;
/*     */ import xbean.Pod;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Con_Npc_Dlg_3
/*     */   extends AbsCondition
/*     */ {
/*  17 */   private static final Logger logger = Logger.getLogger(Con_Npc_Dlg_3.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Con_Npc_Dlg_3(int conId, int conType, int sTaskId)
/*     */   {
/*  29 */     super(conId, conType, sTaskId);
/*     */   }
/*     */   
/*     */   STaskConnpcDialog getConnpcDialog()
/*     */   {
/*  34 */     return STaskConnpcDialog.get(getConId());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isComplete(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*     */   {
/*  43 */     STaskConnpcDialog connpcDialog = getConnpcDialog();
/*  44 */     if (conMap != null)
/*     */     {
/*  46 */       ConBean conBean = (ConBean)conMap.get(Integer.valueOf(getConId()));
/*  47 */       if (conBean == null)
/*     */       {
/*  49 */         conBean = Pod.newConBean();
/*  50 */         conBean.setType(getType());
/*  51 */         conMap.put(Integer.valueOf(getConId()), conBean);
/*     */       }
/*  53 */       if (conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_NPC_DLG_NPC_ID.getParamType())))
/*     */       {
/*  55 */         long storeNpcId = ((Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_NPC_DLG_NPC_ID.getParamType()))).longValue();
/*  56 */         if (storeNpcId == connpcDialog.npcId)
/*     */         {
/*  58 */           return true;
/*     */         }
/*     */       }
/*  61 */       Object obj = params.get(Integer.valueOf(getType()));
/*  62 */       if (obj == null)
/*     */       {
/*  64 */         return false;
/*     */       }
/*  66 */       if ((obj instanceof NpcDlgParamObj))
/*     */       {
/*  68 */         NpcDlgParamObj npcDlgParamObj = (NpcDlgParamObj)obj;
/*  69 */         if (npcDlgParamObj.getNpcId() == connpcDialog.npcId)
/*     */         {
/*  71 */           conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_NPC_DLG_NPC_ID.getParamType()), Long.valueOf(npcDlgParamObj.getNpcId()));
/*  72 */           return true;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/*  77 */         logger.error("npc对话中传递的不是" + NpcDlgParamObj.class.getName()); }
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getType()
/*     */   {
/*  87 */     return 3;
/*     */   }
/*     */   
/*     */ 
/*     */   public void checkCfg()
/*     */   {
/*  93 */     STaskConnpcDialog connpcDialog = getConnpcDialog();
/*  94 */     if (NpcInterface.getNpc(connpcDialog.npcId) == null)
/*     */     {
/*  96 */       throw new RuntimeException("任务配置的npc不存在:taskId:" + getSTask().id + " npcId:" + connpcDialog.npcId + " 与npc对话");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isVisiable(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params)
/*     */   {
/* 103 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_Npc_Dlg_3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */