/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.SGetRoleInfoByNameFail;
/*    */ import mzm.gsp.role.SGetRoleInfoRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGetRoleInfoByName
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final Octets name;
/*    */   
/*    */   public PCGetRoleInfoByName(long roleid, Octets name)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.name = name;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     String targetName = this.name.getString("UTF-8");
/* 29 */     if ((targetName == null) || (targetName.isEmpty()))
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     Long targetRoleid = Name2roleid.select(targetName);
/* 34 */     if (targetRoleid == null)
/*    */     {
/* 36 */       SGetRoleInfoByNameFail protocol = new SGetRoleInfoByNameFail();
/* 37 */       protocol.res = 1;
/* 38 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/* 39 */       return false;
/*    */     }
/* 41 */     SGetRoleInfoRes protocol = new SGetRoleInfoRes();
/* 42 */     RoleInterface.fillRoleInfo(targetRoleid.longValue(), protocol.roleinfo);
/* 43 */     OnlineManager.getInstance().send(this.roleid, protocol);
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PCGetRoleInfoByName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */