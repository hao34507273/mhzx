/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shimen.confbean.ShimenActivityCfgConsts;
/*     */ import mzm.gsp.task.GiveoutItemBean;
/*     */ import mzm.gsp.task.confbean.STask;
/*     */ import mzm.gsp.task.operParamObj.TakeGoodsParamObj;
/*     */ import mzm.gsp.task.operParamObj.TakePetsParamObj;
/*     */ import mzm.gsp.task.operation.AbsOperation;
/*     */ import mzm.gsp.task.operation.Oper_TakeGoods;
/*     */ import mzm.gsp.task.operation.Oper_TakePets;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class FinishTaskProcedure
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int graphId;
/*     */   private int taskId;
/*     */   private List<GiveoutItemBean> giveItems;
/*     */   private List<Long> givePets;
/*     */   
/*     */   public FinishTaskProcedure(long roleId, int graphId, int taskId, List<GiveoutItemBean> giveItems, List<Long> givePets)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.graphId = graphId;
/*  34 */     this.taskId = taskId;
/*  35 */     this.giveItems = giveItems;
/*  36 */     this.givePets = givePets;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     Graph graph = GraphManager.getGraphById(this.graphId);
/*  44 */     Task task = TaskManager.getTaskById(this.taskId);
/*  45 */     if ((graph == null) || (task == null))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     int taskfinishNpcId = task.getTaskFinishNpcId();
/*  51 */     if (!isNearFinishNpc(task, this.roleId))
/*     */     {
/*  53 */       GameServer.logger().info(String.format("[task]FinishTaskProcedure.processImp@not near finish npc while finishing task!|roleId=%d|graphId=%d|taskId=%d|taskfinishNpcId=%d|", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.graphId), Integer.valueOf(this.taskId), Integer.valueOf(taskfinishNpcId) }));
/*     */       
/*     */ 
/*  56 */       return false;
/*     */     }
/*  58 */     Map<Integer, Object> operMap = new HashMap();
/*  59 */     if (this.giveItems.size() > 0)
/*     */     {
/*  61 */       TakeGoodsParamObj takeGoodsParamObj = new TakeGoodsParamObj();
/*  62 */       takeGoodsParamObj.setGiveItemUuids(this.giveItems);
/*  63 */       List<AbsOperation> list = task.getOperation(2, Oper_TakeGoods.class);
/*  64 */       for (AbsOperation operation : list)
/*     */       {
/*  66 */         operMap.put(Integer.valueOf(operation.getOperId()), takeGoodsParamObj);
/*     */       }
/*     */     }
/*     */     
/*  70 */     if (this.givePets.size() > 0)
/*     */     {
/*  72 */       TakePetsParamObj takePetsParamObj = new TakePetsParamObj();
/*  73 */       takePetsParamObj.setGivePetIds(this.givePets);
/*  74 */       List<AbsOperation> list = task.getOperation(2, Oper_TakePets.class);
/*  75 */       for (AbsOperation operation : list)
/*     */       {
/*  77 */         operMap.put(Integer.valueOf(operation.getOperId()), takePetsParamObj);
/*     */       }
/*     */     }
/*  80 */     if (task.getStask().teamType == 3)
/*     */     {
/*  82 */       return RoleTaskManager.finishTeamTask(this.roleId, task, graph, operMap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  95 */     String userId = RoleInterface.getUserId(this.roleId);
/*  96 */     Lockeys.lock(Lockeys.get(User.getTable(), userId));
/*  97 */     return RoleTaskManager.finishTask(this.roleId, task, graph, operMap, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isNearFinishNpc(Task task, long roleId)
/*     */   {
/* 108 */     if (task.outoFinishTask())
/*     */     {
/* 110 */       return true;
/*     */     }
/* 112 */     int taskfinishNpcId = task.getTaskFinishNpcId();
/* 113 */     if (taskfinishNpcId <= 0)
/*     */     {
/* 115 */       return true;
/*     */     }
/* 117 */     if (taskfinishNpcId == 100)
/*     */     {
/* 119 */       taskfinishNpcId = getMasterNpcId(roleId);
/*     */     }
/*     */     
/* 122 */     return RoleTaskManager.isNearByNpc(roleId, taskfinishNpcId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getMasterNpcId(long roleId)
/*     */   {
/* 133 */     int occupation = RoleInterface.getOccupationId(roleId);
/* 134 */     ShimenActivityCfgConsts consts = ShimenActivityCfgConsts.getInstance();
/*     */     
/* 136 */     switch (occupation)
/*     */     {
/*     */     case 1: 
/* 139 */       return consts.GUIWANG_NPC_ID;
/*     */     
/*     */     case 2: 
/* 142 */       return consts.QINGYUN_NPC_ID;
/*     */     
/*     */     case 4: 
/* 145 */       return consts.FENXIANG_NPC_ID;
/*     */     
/*     */     case 3: 
/* 148 */       return consts.TIANYIN_NPC_ID;
/*     */     
/*     */     case 6: 
/* 151 */       return consts.SHENGWU_NPC_ID;
/*     */     
/*     */     case 5: 
/* 154 */       return consts.HEHUAN_NPC_ID;
/*     */     
/*     */     case 7: 
/* 157 */       return consts.CANGYU_NPC_ID;
/*     */     
/*     */     case 8: 
/* 160 */       return consts.LINGYINDIAN_NPC_ID;
/*     */     case 9: 
/* 162 */       return consts.YINENGZHE_NPC_ID;
/*     */     case 10: 
/* 164 */       return consts.WANDUMEN_NPC_ID;
/*     */     }
/*     */     
/* 167 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\FinishTaskProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */