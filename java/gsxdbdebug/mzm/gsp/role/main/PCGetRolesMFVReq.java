/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.SGetRoleMFVRep;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGetRolesMFVReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final Collection<Long> checkMembers;
/*    */   
/*    */   public PCGetRolesMFVReq(long roleId, Collection<Long> checkMembers)
/*    */   {
/* 26 */     this.roleId = roleId;
/* 27 */     this.checkMembers = checkMembers;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if ((this.checkMembers == null) || (this.checkMembers.size() == 0))
/*    */     {
/* 35 */       GameServer.logger().error(String.format("[role]PCGetRolesMFVReq.processImp@ checkMembers is null!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     Map<Long, Integer> mfvInfo = new HashMap();
/* 41 */     for (Iterator i$ = this.checkMembers.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*    */       
/* 43 */       if (!RoleInterface.isRoleExist(member, false))
/*    */       {
/* 45 */         GameServer.logger().error(String.format("[role]PCGetRolesMFVReq.processImp@ checkMembers is not exist!|roleId=%d|notExistMember=%d|checkMemebrs=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(member), this.checkMembers }));
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/*    */ 
/* 51 */         mfvInfo.put(Long.valueOf(member), Integer.valueOf(RoleInterface.getRoleMFValue(member)));
/*    */       }
/*    */     }
/* 54 */     SGetRoleMFVRep rep = new SGetRoleMFVRep();
/* 55 */     rep.roleids.addAll(this.checkMembers);
/* 56 */     rep.rolemfvinfo.putAll(mfvInfo);
/* 57 */     OnlineManager.getInstance().send(this.roleId, rep);
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PCGetRolesMFVReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */