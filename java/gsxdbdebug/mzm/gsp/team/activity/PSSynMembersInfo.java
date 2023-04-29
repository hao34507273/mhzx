/*    */ package mzm.gsp.team.activity;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.RoleInfo;
/*    */ import mzm.gsp.team.SSynMembersInfo;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PSSynMembersInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final List<Long> members;
/*    */   
/*    */   public PSSynMembersInfo(long roleId, List<Long> members)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.members = members;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 27 */     List<Long> membersSelect = TeamActivityManager.getRefreshMembers(this.members, this.roleId);
/* 28 */     if (membersSelect == null) {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     SSynMembersInfo pro = new SSynMembersInfo();
/* 33 */     for (Iterator i$ = membersSelect.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/* 34 */       RoleInfo roleInfo = new RoleInfo();
/* 35 */       TeamActivityManager.fillRoleInfo(member, roleInfo);
/*    */       
/* 37 */       pro.members.add(roleInfo);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 45 */     OnlineManager.getInstance().send(this.roleId, pro);
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\activity\PSSynMembersInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */