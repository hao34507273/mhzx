/*    */ package mzm.gsp.skill.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleSkillArg
/*    */ {
/*    */   public static final int MEN_PAI = 1;
/*    */   public static final int GANE = 2;
/*    */   public int skillType;
/*    */   public long roleId;
/* 22 */   public List<Integer> skillBagList = new ArrayList();
/*    */   
/*    */ 
/*    */ 
/* 26 */   public Map<Integer, Integer> newLevelMap = new HashMap();
/*    */   
/*    */ 
/*    */ 
/* 30 */   public Map<Integer, Integer> oldLevelMap = new HashMap();
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\event\RoleSkillArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */