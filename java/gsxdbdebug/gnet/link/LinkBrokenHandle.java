/*    */ package gnet.link;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LinkBrokenHandle
/*    */   implements Onlines.Handle
/*    */ {
/*    */   public void onLinkBroken(Role role, int reason)
/*    */   {
/* 13 */     if (role == null)
/* 14 */       return;
/* 15 */     OnlineManager.getInstance().OnClientLinkBroken(role.getRoleid(), 1);
/*    */   }
/*    */   
/*    */   public void onManagerBroken(Collection<Role> roles)
/*    */   {
/* 20 */     if (roles == null)
/* 21 */       return;
/* 22 */     OnlineManager.getInstance().OnGsLinkBroken(roles);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\link\LinkBrokenHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */