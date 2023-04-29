/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import gnet.link.Role;
/*    */ import java.util.Collection;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class PDisconnectLink
/*    */   extends LogicProcedure
/*    */ {
/*    */   Collection<Role> roles;
/*    */   
/*    */   public PDisconnectLink(Collection<Role> roles)
/*    */   {
/* 15 */     this.roles = roles;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     for (Role role : this.roles) {
/* 21 */       Procedure.execute(new PPlayerPreLogout(role.getRoleid(), 1));
/*    */     }
/*    */     
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PDisconnectLink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */