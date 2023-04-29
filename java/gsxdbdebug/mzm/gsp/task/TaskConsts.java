/*     */ package mzm.gsp.task;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TaskConsts
/*     */   implements Marshal, Comparable<TaskConsts>
/*     */ {
/*     */   public static final int TASK_TYPE_MAIN = 1;
/*     */   public static final int TASK_TYPE_BRANCH = 2;
/*     */   public static final int TASK_TYPE_INSTANCE = 3;
/*     */   public static final int TASK_TYPE_DAILY = 4;
/*     */   public static final int TASK_TYPE_NORMAL = 5;
/*     */   public static final int TASK_TYPE_ACTIVITY = 6;
/*     */   public static final int TASK_TYPE_TRIAL = 7;
/*     */   public static final int TASK_TYPE_MASTER = 8;
/*     */   public static final int TASK_TYPE_MENPAITIAOZHAN = 9;
/*     */   public static final int TASK_TYPE_ZHIYIN = 10;
/*     */   public static final int TASK_TYPE_FACTION = 11;
/*     */   public static final int TASK_TYPE_FESTIVAL = 12;
/*     */   public static final int TASK_TYPE_FEISHENG = 13;
/*     */   public static final int TASK_TYPE_SURPRISE = 14;
/*     */   public static final int TASK_TYPE_NULL = 100;
/*     */   public static final int LEVEL_TEAM_NO_FALI = 1;
/*     */   public static final int LEVEL_TEAM_TEAMER_FALI = 2;
/*     */   public static final int LEVEL_TEAM_ALL_FALI = 3;
/*     */   public static final int ACCEPT_TASK_DIALOG = 1;
/*     */   public static final int FINISH_TASK_DIALOG = 2;
/*     */   public static final int CAN_NOT_ACCEPT_TASK_DIALOG = 3;
/*     */   public static final int BEFORE_BATTLE_DIALOG = 4;
/*     */   public static final int NOT_FINISH_DIALOG = 5;
/*     */   public static final int TEAM_TYPE_NOMAL = 1;
/*     */   public static final int TEAM_TYPE_SINGLE = 2;
/*     */   public static final int TEAM_TYPE_TEAM = 3;
/*     */   public static final int ROLE_LEVEL_TYPE = 1;
/*     */   public static final int TEAM_LEADER_TYPE = 2;
/*     */   public static final int TEAM_MAX_LEVEL = 3;
/*     */   public static final int TEAM_MIN_LEVEL = 4;
/*     */   public static final int TEAM_AVG_LEVEL = 5;
/*     */   public static final int TEAMER_REL_COUPLE = 1;
/*     */   public static final int TEAMER_REL_TEACHER = 2;
/*     */   public static final int TEAMER_REL_OPPOSITE_SEX = 3;
/*     */   public static final int TEAMER_REL_FRIEND = 4;
/*     */   public static final int TEAMER_REL_CARREAR = 5;
/*     */   public static final int TEAMER_REL_FACTION = 6;
/*     */   public static final int TEAMER_REL_NO_LIMIT = -1;
/*     */   public static final int MALE = 1;
/*     */   public static final int FEMALE = 2;
/*     */   public static final int ITEM_SIGN = 1;
/*     */   public static final int EQUAL_SIGN = 2;
/*     */   public static final int TIMEOUT_HANDLE_TASK_NULL = 0;
/*     */   public static final int TIMEOUT_HANDLE_TASK_SUC = 1;
/*     */   public static final int TIMEOUT_HANDLE_TASK_FAIL = 2;
/*     */   public static final int CON_ACCEPT_TASK_TYPE = 1;
/*     */   public static final int CON_FINISH_TASK_TYPE = 2;
/*     */   public static final int OPER_ACCEPT_TASK_TYPE = 1;
/*     */   public static final int OPER_FINISH_TASK_TYPE = 2;
/*     */   public static final int OPER_FAIL_TASK_TYPE = 3;
/*     */   public static final int OPER_GIVE_UP_TASK_TYPE = 4;
/*     */   public static final int OPER_DEL_TASK_TYPE = 5;
/*     */   public static final int OPER_TEAM_CAPTAIN_TASK_TYPE = 1;
/*     */   public static final int OPER_TEAMER_TASK_TYPE = 2;
/*     */   public static final int OPER_TEAM_ALL_TASK_TYPE = 3;
/*     */   public static final int TASK_STATE_CAN_ACCEPT = 1;
/*     */   public static final int TASK_STATE_ALREADY_ACCEPT = 2;
/*     */   public static final int TASK_STATE_FINISH = 3;
/*     */   public static final int TASK_STATE_DELETE = 4;
/*     */   public static final int TASK_STATE_FAIL = 5;
/*     */   public static final int TASK_STATE_VISIABLE = 6;
/*     */   public static final int TASK_STATE_UN_VISIABLE = 7;
/*     */   public static final int TASK_STATE_HANDUP = 8;
/*     */   public static final int TASK_STATE_GIVEUP = 9;
/*     */   public static final int GRAPH_ACTIVE_NULL = 0;
/*     */   public static final int GRAPH_ACTIVE_CONDITION = 1;
/*     */   public static final int GRAPH_ACTIVE_GRAPHID = 2;
/*     */   public static final int GRAPH_TYPE_NORMAL = 1;
/*     */   public static final int GRAPH_TYPE_TASKSET = 2;
/*     */   public static final int GRAPH_RING_CLEAR_DAY = 1;
/*     */   public static final int GRAPH_RING_CLEAR_WEEK = 2;
/*     */   public static final int GRAPH_RING_CLEAR_MONTH = 3;
/*     */   public static final int GRAPH_RING_CLEAR_NEVER = 4;
/*     */   public static final int GRAPH_CIRCLE_CLEAR_DAY = 1;
/*     */   public static final int GRAPH_CIRCLE_CLEAR_WEEK = 2;
/*     */   public static final int GRAPH_CIRCLE_CLEAR_MONTH = 3;
/*     */   public static final int GRAPH_CIRCLE_CLEAR_NEVER = 4;
/*     */   public static final int TASK_SET_RATE_TOTAL = 100000;
/*     */   public static final int TASK_RANDOM_MAX = 100;
/*     */   public static final int GIVE_UP_TASK_RING_ADD = 1;
/*     */   public static final int GIVE_UP_TASK_RING_UNCHANGE = 2;
/*     */   public static final int GIVE_UP_TASK_END_TURN = 3;
/*     */   public static final int JING_XIANG_FACTION_MEMBER = 1;
/*     */   public static final int JING_XIANG_FACTION_LEADER = 2;
/*     */   public static final int JING_XIANG_FRIEND = 3;
/*     */   public static final int JING_XIANG_RANK = 4;
/*     */   public static final int JOIN_FIGHT_REP__NO = 0;
/*     */   public static final int JOIN_FIGHT_REP__YES = 1;
/*     */   public static final int BAN_TYPE__AWARD = 1;
/*     */   public static final int BAN_TYPE__GO_ON = 2;
/*     */   
/*     */   public final boolean _validator_()
/*     */   {
/* 105 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 109 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 113 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 117 */     if (_o1_ == this) return true;
/* 118 */     if ((_o1_ instanceof TaskConsts)) {
/* 119 */       return true;
/*     */     }
/* 121 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 125 */     int _h_ = 0;
/* 126 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder _sb_ = new StringBuilder();
/* 131 */     _sb_.append("(");
/* 132 */     _sb_.append(")");
/* 133 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(TaskConsts _o_) {
/* 137 */     if (_o_ == this) return 0;
/* 138 */     int _c_ = 0;
/* 139 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\TaskConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */