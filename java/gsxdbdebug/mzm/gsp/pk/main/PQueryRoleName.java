/*    */ package mzm.gsp.pk.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pk.SQueryRoleNameRes;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PQueryRoleName
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long roleIdToQuery;
/*    */   
/*    */   public PQueryRoleName(long roleId, long roleIdToQuery)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.roleIdToQuery = roleIdToQuery;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if (PKManager.isNotEnable()) {
/* 28 */       return false;
/*    */     }
/* 30 */     if (GameServerInfoManager.isRoamServer()) {
/* 31 */       return false;
/*    */     }
/* 33 */     String roleName = RoleInterface.getName(this.roleIdToQuery);
/* 34 */     if (roleName == null) {
/* 35 */       return false;
/*    */     }
/* 37 */     response(roleName);
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   private void response(String roleName)
/*    */   {
/* 43 */     SQueryRoleNameRes sQueryRoleNameRes = new SQueryRoleNameRes();
/*    */     try
/*    */     {
/* 46 */       sQueryRoleNameRes.role_name.setString(roleName, "UTF-8");
/* 47 */       OnlineManager.getInstance().send(this.roleId, sQueryRoleNameRes);
/*    */     }
/*    */     catch (UnsupportedEncodingException e)
/*    */     {
/* 51 */       PKLogManager.error("PQueryRoleName.response()@unsupported encoding exception");
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PQueryRoleName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */