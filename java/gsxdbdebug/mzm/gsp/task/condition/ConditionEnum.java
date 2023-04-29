/*     */ package mzm.gsp.task.condition;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum ConditionEnum
/*     */ {
/*  15 */   CON_KILL_MONSTER_MAP_ID(1), 
/*     */   
/*  17 */   CON_KILL_MONSTER_MONSTER_ID(2), 
/*     */   
/*  19 */   CON_KILL_MONSTER_COUNT(3), 
/*     */   
/*     */ 
/*  22 */   CON_KILL_NPC_BATTLE_ID(11), 
/*     */   
/*  24 */   CON_KILL_NPC_PVC_TASK_USE_ID(12), 
/*     */   
/*  26 */   CON_KILL_NPC_PLAYER_ID(13), 
/*     */   
/*     */ 
/*  29 */   CON_NPC_DLG_NPC_ID(21), 
/*     */   
/*     */ 
/*  32 */   CON_TIME_LIMIT_END_SEC(31), 
/*     */   
/*     */ 
/*  35 */   CON_TIME_LIMIT_END_SESSIONID(32), 
/*     */   
/*  37 */   CON_TIME_LIMIT_START_TIME(33), 
/*     */   
/*  39 */   CON_TIME_LIMIT_LEFT_TIME(34), 
/*     */   
/*     */ 
/*  42 */   CON_TO_PLACE_MAP_ID(41), 
/*     */   
/*  44 */   CON_TO_PLACE_X(42), 
/*     */   
/*  46 */   CON_TO_PLACE_Y(43), 
/*     */   
/*  48 */   CON_TO_PLACE_Z(44), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  54 */   CON_WIN_COUNT_COUNT(51), 
/*     */   
/*     */ 
/*  57 */   CON_GATHER_ITEM_COUNT(61), 
/*     */   
/*     */ 
/*  60 */   CON_USE_TASK_GOODS(62), 
/*     */   
/*     */ 
/*  63 */   CON_BAG(71), 
/*     */   
/*     */ 
/*  66 */   CON_LETTAI_WIN_COUNT(81), 
/*     */   
/*     */ 
/*  69 */   CON_ACTIVITY_FINISH_COUNT(91), 
/*     */   
/*     */ 
/*  72 */   CON_ACTIVITY_FINISH_QUESTION(101), 
/*     */   
/*     */ 
/*  75 */   CON_SHARE_PENGYOUQUAN(111);
/*     */   
/*     */ 
/*     */ 
/*     */   private int paramType;
/*     */   
/*     */ 
/*     */   private ConditionEnum(int paramType)
/*     */   {
/*  84 */     this.paramType = paramType;
/*     */   }
/*     */   
/*     */   public int getParamType()
/*     */   {
/*  89 */     return this.paramType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean check()
/*     */   {
/*  99 */     Set<Integer> set = new HashSet();
/* 100 */     for (ConditionEnum conditionEnum : values())
/*     */     {
/* 102 */       if (set.contains(Integer.valueOf(conditionEnum.getParamType())))
/*     */       {
/* 104 */         throw new RuntimeException("条件中不能有重复的内容");
/*     */       }
/* 106 */       set.add(Integer.valueOf(conditionEnum.getParamType()));
/*     */     }
/* 108 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\ConditionEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */