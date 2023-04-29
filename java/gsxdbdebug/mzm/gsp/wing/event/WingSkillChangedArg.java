/*    */ package mzm.gsp.wing.event;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.wing.main2.WingChangeReasonEnum;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WingSkillChangedArg
/*    */ {
/*    */   private final long roleid;
/*    */   private final WingChangeReasonEnum changeReasonEnum;
/*    */   
/*    */   public WingSkillChangedArg(long roleid, Map<Integer, List<Integer>> oldmainSkill2SubSkill, Map<Integer, List<Integer>> newmainSkill2SubSkill)
/*    */   {
/* 25 */     this.roleid = roleid;
/* 26 */     this.changeReasonEnum = WingChangeReasonEnum.NORMAL;
/*    */   }
/*    */   
/*    */   public WingSkillChangedArg(long roleId)
/*    */   {
/* 31 */     this.roleid = roleId;
/* 32 */     this.changeReasonEnum = WingChangeReasonEnum.NORMAL;
/*    */   }
/*    */   
/*    */   public WingSkillChangedArg(long roleId, WingChangeReasonEnum changeReasonEnum)
/*    */   {
/* 37 */     this.roleid = roleId;
/* 38 */     this.changeReasonEnum = changeReasonEnum;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleid()
/*    */   {
/* 48 */     return this.roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public WingChangeReasonEnum getWingChangeReasonEnum()
/*    */   {
/* 58 */     return this.changeReasonEnum;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\event\WingSkillChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */