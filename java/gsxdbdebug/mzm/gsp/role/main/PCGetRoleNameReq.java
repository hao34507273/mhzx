/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.SGetRoleNameRep;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGetRoleNameReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long checkedRoleId;
/*    */   
/*    */   public PCGetRoleNameReq(long roleId, long checkedRoleId)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.checkedRoleId = checkedRoleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     SGetRoleNameRep p = new SGetRoleNameRep();
/* 30 */     p.checkedroleid = this.checkedRoleId;
/*    */     
/* 32 */     if (RoleInterface.isRoleExit(this.checkedRoleId))
/*    */     {
/* 34 */       String name = RoleInterface.getName(this.checkedRoleId);
/*    */       try
/*    */       {
/* 37 */         p.checkedrolename.setString(name, "UTF-8");
/*    */       }
/*    */       catch (UnsupportedEncodingException e) {}
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 44 */     OnlineManager.getInstance().send(this.roleId, p);
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PCGetRoleNameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */