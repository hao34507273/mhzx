/*    */ package mzm.gsp.award.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.award.MultiRoleAwardBean;
/*    */ import mzm.gsp.award.main.MultiRoleSelectAwardContext;
/*    */ 
/*    */ 
/*    */ public class MultiRoleSelectArg
/*    */ {
/* 13 */   public final Map<Long, MultiRoleAwardBean> awardRoles = new HashMap();
/* 14 */   public final List<Long> allRoles = new ArrayList();
/*    */   public final MultiRoleSelectAwardContext context;
/*    */   
/*    */   public MultiRoleSelectArg(Map<Long, MultiRoleAwardBean> awardRoles, List<Long> allRoles, MultiRoleSelectAwardContext context)
/*    */   {
/* 19 */     this.awardRoles.putAll(awardRoles);
/* 20 */     this.allRoles.addAll(allRoles);
/* 21 */     this.context = context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\event\MultiRoleSelectArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */