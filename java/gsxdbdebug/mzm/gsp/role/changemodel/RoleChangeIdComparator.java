/*    */ package mzm.gsp.role.changemodel;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import mzm.gsp.util.confbean.SRoleChangeOutlookCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleChangeIdComparator
/*    */   implements Comparator<Integer>
/*    */ {
/*    */   public int compare(Integer o1, Integer o2)
/*    */   {
/* 13 */     SRoleChangeOutlookCfg cfg1 = SRoleChangeOutlookCfg.get(o1.intValue());
/* 14 */     SRoleChangeOutlookCfg cfg2 = SRoleChangeOutlookCfg.get(o2.intValue());
/* 15 */     return cfg2.priority - cfg1.priority;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\changemodel\RoleChangeIdComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */