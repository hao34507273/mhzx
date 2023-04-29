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
/*     */ public class FinishTaskProcedure extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int graphId;
/*     */   private int taskId;
/*     */   private List<GiveoutItemBean> giveItems;
/*     */   private List<Long> givePets;
/*     */   
/*     */   public FinishTaskProcedure(long roleId, int graphId, int taskId, List<GiveoutItemBean> giveItems, List<Long> givePets)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.graphId = graphId;
/*  33 */     this.taskId = taskId;
/*  34 */     this.giveItems = giveItems;
/*  35 */     this.givePets = givePets;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     Graph graph = GraphManager.getGraphById(this.graphId);
/*  43 */     Task task = TaskManager.getTaskById(this.taskId);
/*  44 */     if ((graph == null) || (task == null))
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     int taskfinishNpcId = task.getTaskFinishNpcId();
/*  50 */     if (!isNearFinishNpc(task, this.roleId))
/*     */     {
/*  52 */       GameServer.logger().info(String.format("[task]FinishTaskProcedure.processImp@not near finish npc while finishing task!|roleId=%d|graphId=%d|taskId=%d|taskfinishNpcId=%d|", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.graphId), Integer.valueOf(this.taskId), Integer.valueOf(taskfinishNpcId) }));
/*     */       
/*     */ 
/*  55 */       return false;
/*     */     }
/*  57 */     Map<Integer, Object> operMap = new HashMap();
/*  58 */     TakeGoodsParamObj takeGoodsParamObj; if (this.giveItems.size() > 0)
/*     */     {
/*  60 */       takeGoodsParamObj = new TakeGoodsParamObj();
/*  61 */       takeGoodsParamObj.setGiveItemUuids(this.giveItems);
/*  62 */       List<AbsOperation> list = task.getOperation(2, Oper_TakeGoods.class);
/*  63 */       for (AbsOperation operation : list)
/*     */       {
/*  65 */         operMap.put(Integer.valueOf(operation.getOperId()), takeGoodsParamObj);
/*     */       }
/*     */     }
/*     */     TakePetsParamObj takePetsParamObj;
/*  69 */     if (this.givePets.size() > 0)
/*     */     {
/*  71 */       takePetsParamObj = new TakePetsParamObj();
/*  72 */       takePetsParamObj.setGivePetIds(this.givePets);
/*  73 */       List<AbsOperation> list = task.getOperation(2, Oper_TakePets.class);
/*  74 */       for (AbsOperation operation : list)
/*     */       {
/*  76 */         operMap.put(Integer.valueOf(operation.getOperId()), takePetsParamObj);
/*     */       }
/*     */     }
/*  79 */     if (task.getStask().teamType == 3)
/*     */     {
/*  81 */       return RoleTaskManager.finishTeamTask(this.roleId, task, graph, operMap);
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
/*  94 */     String userId = RoleInterface.getUserId(this.roleId);
/*  95 */     Lockeys.lock(Lockeys.get(User.getTable(), userId));
/*  96 */     return RoleTaskManager.finishTask(this.roleId, task, graph, operMap, true);
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
/* 107 */     if (task.outoFinishTask())
/*     */     {
/* 109 */       return true;
/*     */     }
/* 111 */     int taskfinishNpcId = task.getTaskFinishNpcId();
/* 112 */     if (taskfinishNpcId <= 0)
/*     */     {
/* 114 */       return true;
/*     */     }
/* 116 */     if (taskfinishNpcId == 100)
/*     */     {
/* 118 */       taskfinishNpcId = getMasterNpcId(roleId);
/*     */     }
/*     */     
/* 121 */     return RoleTaskManager.isNearByNpc(roleId, taskfinishNpcId);
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
/* 132 */     int occupation = RoleInterface.getOccupationId(roleId);
/* 133 */     ShimenActivityCfgConsts consts = ShimenActivityCfgConsts.getInstance();
/*     */     
/* 135 */     switch (occupation)
/*     */     {
/*     */     case 1: 
/* 138 */       return consts.GUIWANG_NPC_ID;
/*     */     
/*     */     case 2: 
/* 141 */       return consts.QINGYUN_NPC_ID;
/*     */     
/*     */     case 4: 
/* 144 */       return consts.FENXIANG_NPC_ID;
/*     */     
/*     */     case 3: 
/* 147 */       return consts.TIANYIN_NPC_ID;
/*     */     
/*     */     case 6: 
/* 150 */       return consts.SHENGWU_NPC_ID;
/*     */     
/*     */     case 5: 
/* 153 */       return consts.HEHUAN_NPC_ID;
/*     */     
/*     */     case 7: 
/* 156 */       return consts.CANGYU_NPC_ID;
/*     */     
/*     */     case 8: 
/* 159 */       return consts.LINGYINDIAN_NPC_ID;
/*     */     case 9: 
/* 161 */       return consts.YINENGZHE_NPC_ID;
/*     */     }
/*     */     
/* 164 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\FinishTaskProcedure1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */