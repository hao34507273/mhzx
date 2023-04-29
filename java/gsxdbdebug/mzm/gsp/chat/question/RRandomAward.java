/*    */ package mzm.gsp.chat.question;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class RRandomAward
/*    */ {
/*    */   private final List<Long> roleIds;
/*    */   private final Set<Long> ranRoleIds;
/*    */   
/*    */   public RRandomAward(List<Long> roleIds)
/*    */   {
/* 16 */     this.roleIds = roleIds;
/* 17 */     this.ranRoleIds = new HashSet();
/*    */   }
/*    */   
/*    */   public void doAward()
/*    */   {
/* 22 */     if ((this.roleIds == null) || (this.roleIds.size() == 0))
/*    */     {
/* 24 */       return;
/*    */     }
/* 26 */     int count = 0;
/* 27 */     Collections.shuffle(this.roleIds);
/* 28 */     for (Iterator i$ = this.roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 30 */       if (new DoRandomAward(roleId).call())
/*    */       {
/* 32 */         this.ranRoleIds.add(Long.valueOf(roleId));
/* 33 */         count++;
/*    */       }
/* 35 */       if (count >= WorldQuestion.getInstance().getNeedRandomNum()) {
/*    */         break;
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public Set<Long> getRanRoleIds()
/*    */   {
/* 44 */     return this.ranRoleIds;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\question\RRandomAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */