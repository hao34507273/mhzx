/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.condition.AbsCondition;
/*     */ import mzm.gsp.task.confbean.STask;
/*     */ import mzm.gsp.task.operation.AbsOperation;
/*     */ import mzm.gsp.task.operation.Oper_TakeGoods;
/*     */ import mzm.gsp.task.operation.Oper_TakePets;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ConBean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Task
/*     */ {
/*  30 */   private Map<Integer, AbsCondition> acceptConMap = new HashMap();
/*     */   
/*  32 */   private Map<Integer, AbsCondition> finishConMap = new HashMap();
/*     */   
/*  34 */   private Map<Integer, AbsOperation> acceptOperMap = new HashMap();
/*     */   
/*  36 */   private Map<Integer, AbsOperation> finishOperMap = new HashMap();
/*     */   
/*  38 */   private Map<Integer, AbsOperation> giveUpOperMap = new HashMap();
/*     */   
/*  40 */   private Map<Integer, AbsOperation> failOperMap = new HashMap();
/*     */   
/*  42 */   private Map<Integer, AbsOperation> delOperMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */   private int taskId;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getTaskId()
/*     */   {
/*  53 */     return this.taskId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTaskId(int taskId)
/*     */   {
/*  63 */     this.taskId = taskId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public STask getStask()
/*     */   {
/*  73 */     return STask.get(this.taskId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   String getTaskName()
/*     */   {
/*  83 */     return getStask().taskName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getTaskFinishNpcId()
/*     */   {
/*  93 */     return getStask().finishTaskNPC;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean outoFinishTask()
/*     */   {
/* 103 */     return getStask().autoFinish;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Integer> taskNeedMemberLevel()
/*     */   {
/* 113 */     List<Integer> levelArg = new ArrayList();
/*     */     
/* 115 */     return levelArg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean canEnterFight(List<Long> members)
/*     */   {
/* 126 */     if ((members == null) || (members.size() == 0))
/*     */     {
/* 128 */       return false;
/*     */     }
/* 130 */     if (!isPeopleNumOk(members.size(), ((Long)members.get(0)).longValue()))
/*     */     {
/* 132 */       return false;
/*     */     }
/* 134 */     if (!isMembersLevelOk(members))
/*     */     {
/* 136 */       return false;
/*     */     }
/* 138 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isPeopleNumOk(int peopleNum, long leaderId)
/*     */   {
/* 149 */     STask sTask = getStask();
/* 150 */     if (peopleNum <= 0)
/*     */     {
/* 152 */       return false;
/*     */     }
/* 154 */     if ((sTask.battlePeopleNumLower > 0) && (peopleNum < sTask.battlePeopleNumLower))
/*     */     {
/* 156 */       RoleTaskManager.sendTaskNotice(Arrays.asList(new Long[] { Long.valueOf(leaderId) }), false, 2, new String[] { String.valueOf(getStask().battlePeopleNumLower) });
/*     */       
/* 158 */       return false;
/*     */     }
/* 160 */     if ((sTask.battlePeopleNumUpper > 0) && (peopleNum > sTask.battlePeopleNumUpper))
/*     */     {
/*     */ 
/* 163 */       return false;
/*     */     }
/* 165 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isMembersLevelOk(List<Long> members)
/*     */   {
/* 178 */     STask sTask = getStask();
/* 179 */     int levelLow = sTask.battleLevelLow;
/* 180 */     int levelHigh = sTask.battleLevelHigh;
/* 181 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 183 */       int roleLevel = RoleInterface.getLevel(roleId);
/* 184 */       if ((levelLow > 0) && (roleLevel < levelLow))
/*     */       {
/*     */ 
/* 187 */         RoleTaskManager.sendTaskNotice(members, false, 5, new String[] { String.valueOf(levelLow) });
/*     */         
/* 189 */         return false;
/*     */       }
/* 191 */       if ((levelHigh > 0) && (roleLevel > levelHigh))
/*     */       {
/*     */ 
/* 194 */         return false;
/*     */       }
/*     */     }
/* 197 */     return true;
/*     */   }
/*     */   
/*     */   public boolean addCondition(AbsCondition condition)
/*     */   {
/* 202 */     switch (condition.getConType())
/*     */     {
/*     */     case 1: 
/* 205 */       if (this.acceptConMap.containsKey(Integer.valueOf(condition.getConId())))
/*     */       {
/* 207 */         return false;
/*     */       }
/* 209 */       this.acceptConMap.put(Integer.valueOf(condition.getConId()), condition);
/* 210 */       break;
/*     */     case 2: 
/* 212 */       if (this.finishConMap.containsKey(Integer.valueOf(condition.getConId())))
/*     */       {
/* 214 */         return false;
/*     */       }
/* 216 */       this.finishConMap.put(Integer.valueOf(condition.getConId()), condition);
/* 217 */       break;
/*     */     default: 
/* 219 */       return false;
/*     */     }
/* 221 */     return true;
/*     */   }
/*     */   
/*     */   public boolean addOperation(AbsOperation operation)
/*     */   {
/* 226 */     switch (operation.getOperType())
/*     */     {
/*     */     case 1: 
/* 229 */       if (this.acceptOperMap.containsKey(Integer.valueOf(operation.getOperId())))
/*     */       {
/* 231 */         return false;
/*     */       }
/* 233 */       this.acceptOperMap.put(Integer.valueOf(operation.getOperId()), operation);
/* 234 */       break;
/*     */     case 2: 
/* 236 */       if (this.finishOperMap.containsKey(Integer.valueOf(operation.getOperId())))
/*     */       {
/* 238 */         return false;
/*     */       }
/* 240 */       this.finishOperMap.put(Integer.valueOf(operation.getOperId()), operation);
/* 241 */       break;
/*     */     case 3: 
/* 243 */       if (this.failOperMap.containsKey(Integer.valueOf(operation.getOperId())))
/*     */       {
/* 245 */         return false;
/*     */       }
/* 247 */       this.failOperMap.put(Integer.valueOf(operation.getOperId()), operation);
/* 248 */       break;
/*     */     case 4: 
/* 250 */       if (this.giveUpOperMap.containsKey(Integer.valueOf(operation.getOperId())))
/*     */       {
/* 252 */         return false;
/*     */       }
/* 254 */       this.giveUpOperMap.put(Integer.valueOf(operation.getOperId()), operation);
/* 255 */       break;
/*     */     case 5: 
/* 257 */       if (this.delOperMap.containsKey(Integer.valueOf(operation.getOperId())))
/*     */       {
/* 259 */         return false;
/*     */       }
/* 261 */       this.delOperMap.put(Integer.valueOf(operation.getOperId()), operation);
/* 262 */       break;
/*     */     default: 
/* 264 */       return false;
/*     */     }
/* 266 */     return true;
/*     */   }
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
/*     */   public List<AbsCondition> getCondition(int type, int conType)
/*     */   {
/* 281 */     List<AbsCondition> conditionList = new ArrayList();
/* 282 */     switch (conType)
/*     */     {
/*     */     case 1: 
/* 285 */       for (AbsCondition condition : this.acceptConMap.values())
/*     */       {
/* 287 */         if (condition.getType() == type)
/*     */         {
/* 289 */           conditionList.add(condition);
/*     */         }
/*     */       }
/* 292 */       break;
/*     */     case 2: 
/* 294 */       for (AbsCondition condition : this.finishConMap.values())
/*     */       {
/* 296 */         if (condition.getType() == type)
/*     */         {
/* 298 */           conditionList.add(condition);
/*     */         }
/*     */       }
/* 301 */       break;
/*     */     }
/*     */     
/*     */     
/* 305 */     return conditionList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AbsCondition getCondition(int conId)
/*     */   {
/* 316 */     if (this.acceptConMap.containsKey(Integer.valueOf(conId)))
/*     */     {
/* 318 */       return (AbsCondition)this.acceptConMap.get(Integer.valueOf(conId));
/*     */     }
/* 320 */     if (this.finishConMap.containsKey(Integer.valueOf(conId)))
/*     */     {
/* 322 */       return (AbsCondition)this.finishConMap.get(Integer.valueOf(conId));
/*     */     }
/* 324 */     return null;
/*     */   }
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
/*     */   public boolean containsCondition(int type, int conType)
/*     */   {
/* 338 */     switch (conType)
/*     */     {
/*     */     case 1: 
/* 341 */       for (AbsCondition condition : this.acceptConMap.values())
/*     */       {
/* 343 */         if (condition.getType() == type)
/*     */         {
/* 345 */           return true;
/*     */         }
/*     */       }
/* 348 */       break;
/*     */     case 2: 
/* 350 */       for (AbsCondition condition : this.finishConMap.values())
/*     */       {
/* 352 */         if (condition.getType() == type)
/*     */         {
/* 354 */           return true;
/*     */         }
/*     */       }
/* 357 */       break;
/*     */     }
/*     */     
/*     */     
/* 361 */     return false;
/*     */   }
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
/*     */   public List<AbsOperation> getOperation(int operType, int teamType)
/*     */   {
/* 375 */     List<AbsOperation> opers = new ArrayList();
/* 376 */     switch (operType)
/*     */     {
/*     */     case 1: 
/* 379 */       for (AbsOperation operation : this.acceptOperMap.values())
/*     */       {
/*     */ 
/* 382 */         opers.add(operation);
/*     */       }
/*     */       
/* 385 */       break;
/*     */     case 2: 
/* 387 */       for (AbsOperation operation : this.finishOperMap.values())
/*     */       {
/*     */ 
/* 390 */         opers.add(operation);
/*     */       }
/*     */       
/* 393 */       break;
/*     */     case 3: 
/* 395 */       for (AbsOperation operation : this.failOperMap.values())
/*     */       {
/*     */ 
/* 398 */         opers.add(operation);
/*     */       }
/*     */       
/* 401 */       break;
/*     */     case 4: 
/* 403 */       for (AbsOperation operation : this.giveUpOperMap.values())
/*     */       {
/*     */ 
/* 406 */         opers.add(operation);
/*     */       }
/*     */       
/* 409 */       break;
/*     */     case 5: 
/* 411 */       for (AbsOperation operation : this.delOperMap.values())
/*     */       {
/* 413 */         opers.add(operation);
/*     */       }
/* 415 */       break;
/*     */     }
/*     */     
/*     */     
/* 419 */     return opers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<AbsOperation> getOperation(int operType, Class<? extends AbsOperation> operClass)
/*     */   {
/* 431 */     List<AbsOperation> opers = new ArrayList();
/* 432 */     switch (operType)
/*     */     {
/*     */     case 1: 
/* 435 */       for (AbsOperation operation : this.acceptOperMap.values())
/*     */       {
/* 437 */         if (operClass.equals(operation.getClass()))
/*     */         {
/* 439 */           opers.add(operation);
/*     */         }
/*     */       }
/* 442 */       break;
/*     */     case 2: 
/* 444 */       for (AbsOperation operation : this.finishOperMap.values())
/*     */       {
/* 446 */         if (operClass.equals(operation.getClass()))
/*     */         {
/* 448 */           opers.add(operation);
/*     */         }
/*     */       }
/* 451 */       break;
/*     */     case 3: 
/* 453 */       for (AbsOperation operation : this.failOperMap.values())
/*     */       {
/* 455 */         if (operClass.equals(operation.getClass()))
/*     */         {
/* 457 */           opers.add(operation);
/*     */         }
/*     */       }
/* 460 */       break;
/*     */     case 4: 
/* 462 */       for (AbsOperation operation : this.giveUpOperMap.values())
/*     */       {
/* 464 */         if (operClass.equals(operation.getClass()))
/*     */         {
/* 466 */           opers.add(operation);
/*     */         }
/*     */       }
/* 469 */       break;
/*     */     case 5: 
/* 471 */       for (AbsOperation operation : this.delOperMap.values())
/*     */       {
/* 473 */         if (operClass.equals(operation.getClass()))
/*     */         {
/* 475 */           opers.add(operation);
/*     */         }
/*     */       }
/* 478 */       break;
/*     */     }
/*     */     
/*     */     
/* 482 */     return opers;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean excuteOperation(long roleId, int operType, int teamType, Map<Integer, Object> operParamsMap, int graphId, boolean isHandUp)
/*     */   {
/* 500 */     List<AbsOperation> opers = getOperation(operType, teamType);
/* 501 */     for (AbsOperation oper : opers)
/*     */     {
/* 503 */       if ((isHandUp) || (
/*     */       
/* 505 */         (!(oper instanceof Oper_TakePets)) && 
/*     */         
/*     */ 
/*     */ 
/* 509 */         (!(oper instanceof Oper_TakeGoods))))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 514 */         if (!oper.execute(roleId, operParamsMap, graphId))
/*     */         {
/* 516 */           return false; }
/*     */       }
/*     */     }
/* 519 */     return true;
/*     */   }
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
/*     */ 
/*     */ 
/*     */   boolean checkOperation(long roleId, int operType, int teamType, Map<Integer, Object> operParamsMap, boolean isHandUp)
/*     */   {
/* 536 */     List<AbsOperation> opers = getOperation(operType, teamType);
/* 537 */     for (AbsOperation oper : opers)
/*     */     {
/* 539 */       if ((isHandUp) || (
/*     */       
/* 541 */         (!(oper instanceof Oper_TakePets)) && 
/*     */         
/*     */ 
/*     */ 
/* 545 */         (!(oper instanceof Oper_TakeGoods))))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 550 */         if (!oper.check(roleId, operParamsMap))
/*     */         {
/* 552 */           return false; }
/*     */       }
/*     */     }
/* 555 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isVisiable(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params)
/*     */   {
/* 568 */     for (AbsCondition condition : this.acceptConMap.values())
/*     */     {
/* 570 */       if (condition.isVisiable(roleId, conMap, params))
/*     */       {
/* 572 */         return true;
/*     */       }
/*     */     }
/* 575 */     return false;
/*     */   }
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
/*     */ 
/*     */ 
/*     */   AcceptTaskCheckResult iscanTake(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*     */   {
/* 592 */     return innerCanTake(roleId, conMap, params, graphId);
/*     */   }
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
/*     */   private AcceptTaskCheckResult innerCanTake(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*     */   {
/* 606 */     AcceptTaskCheckResult acceptTaskCheckResult = new AcceptTaskCheckResult();
/* 607 */     for (Map.Entry<Integer, AbsCondition> entry : this.acceptConMap.entrySet())
/*     */     {
/* 609 */       if (!((AbsCondition)entry.getValue()).isComplete(roleId, conMap, params, graphId))
/*     */       {
/* 611 */         acceptTaskCheckResult.getNoConId().add(Integer.valueOf(((AbsCondition)entry.getValue()).getConId()));
/*     */       }
/*     */     }
/* 614 */     List<Integer> noConIds = acceptTaskCheckResult.getNoConId();
/* 615 */     if (noConIds.size() > 0)
/*     */     {
/* 617 */       acceptTaskCheckResult.setCanTake(false);
/* 618 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 620 */         GameServer.logger().debug(String.format("[Task]Task.innerCanTake@玩家不满足接取条件！ |roleId=%d|graphId=%d|taskId=%d|conId=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(getTaskId()), noConIds.toString() }));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 625 */     return acceptTaskCheckResult;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isCanFinish(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*     */   {
/* 638 */     return innerCanFinish(roleId, conMap, params, graphId);
/*     */   }
/*     */   
/*     */   private boolean innerCanFinish(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*     */   {
/* 643 */     for (Map.Entry<Integer, AbsCondition> entry : this.finishConMap.entrySet())
/*     */     {
/* 645 */       if (!((AbsCondition)entry.getValue()).isComplete(roleId, conMap, params, graphId))
/*     */       {
/* 647 */         if (GameServer.logger().isDebugEnabled())
/*     */         {
/* 649 */           GameServer.logger().debug(String.format("[Task]Task.innerCanFinish@玩家不满足完成条件！ |roleId=%d|graphId=%d|taskId=%d|conId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(getTaskId()), Integer.valueOf(((AbsCondition)entry.getValue()).getConId()) }));
/*     */         }
/*     */         
/*     */ 
/* 653 */         return false;
/*     */       }
/*     */     }
/* 656 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void checkCfg()
/*     */   {
/* 664 */     STask sTask = getStask();
/* 665 */     if (((sTask.finishTaskNPC <= 0) || (sTask.finishTaskNPC == 100) || (
/*     */     
/* 667 */       ((sTask.finishTaskNPC != 101) && (NpcInterface.getNpc(sTask.finishTaskNPC) == null)) && 
/*     */       
/*     */ 
/*     */ 
/* 671 */       (MapInterface.isNpcExist(sTask.finishTaskNPC)))) || (
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 676 */       (sTask.giveTaskNPC > 0) && (sTask.giveTaskNPC != 100)))
/*     */     {
/* 678 */       if ((NpcInterface.getNpc(sTask.giveTaskNPC) == null) && 
/*     */       
/*     */ 
/*     */ 
/* 682 */         (MapInterface.isNpcExist(sTask.giveTaskNPC))) {}
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 687 */     for (AbsCondition condition : this.acceptConMap.values())
/*     */     {
/* 689 */       condition.checkCfg();
/*     */     }
/* 691 */     for (AbsCondition condition : this.finishConMap.values())
/*     */     {
/* 693 */       condition.checkCfg();
/*     */     }
/* 695 */     for (AbsOperation operation : this.acceptOperMap.values())
/*     */     {
/* 697 */       operation.checkCfg();
/*     */     }
/* 699 */     for (AbsOperation operation : this.finishOperMap.values())
/*     */     {
/* 701 */       operation.checkCfg();
/*     */     }
/* 703 */     for (AbsOperation operation : this.failOperMap.values())
/*     */     {
/* 705 */       operation.checkCfg();
/*     */     }
/* 707 */     for (AbsOperation operation : this.giveUpOperMap.values())
/*     */     {
/* 709 */       operation.checkCfg();
/*     */     }
/* 711 */     for (AbsOperation operation : this.delOperMap.values())
/*     */     {
/* 713 */       operation.checkCfg();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isSingleTask()
/*     */   {
/* 719 */     return getStask().teamType == 2;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\Task.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */