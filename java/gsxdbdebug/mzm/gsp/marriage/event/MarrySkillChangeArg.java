/*    */ package mzm.gsp.marriage.event;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class MarrySkillChangeArg
/*    */ {
/*    */   public final long roleid;
/* 10 */   public final Map<Integer, Integer> skill2Lv = new HashMap();
/*    */   
/*    */   public MarrySkillChangeArg(long roleid) {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\event\MarrySkillChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */