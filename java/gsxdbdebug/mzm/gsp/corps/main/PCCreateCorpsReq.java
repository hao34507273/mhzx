/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.corps.SCreateCorpsConfirmTip;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.CreateCorpsConfBean;
/*    */ import xbean.Pod;
/*    */ import xtable.Role2createcorpsconf;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCCreateCorpsReq
/*    */   extends PCreateCorps
/*    */ {
/*    */   public PCCreateCorpsReq(long roleId, Octets corpsNameOctets, Octets declarationOctets, int badgeId)
/*    */   {
/* 19 */     super(roleId, corpsNameOctets, declarationOctets, badgeId);
/*    */   }
/*    */   
/*    */   boolean doAction()
/*    */   {
/* 24 */     if (this.lockRoleIds.size() == 1)
/*    */     {
/* 26 */       return super.doAction();
/*    */     }
/*    */     
/* 29 */     CreateCorpsConfirmSession session = new CreateCorpsConfirmSession(this.roleId);
/*    */     
/* 31 */     initConfData(session.getSessionId());
/*    */     
/* 33 */     OnlineManager.getInstance().sendMulti(new SCreateCorpsConfirmTip(this.roleId, this.nameOctets, this.declarationOctets, this.badgeId, session.getSessionId()), this.lockRoleIds);
/*    */     
/*    */ 
/*    */ 
/* 37 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void initConfData(long sessionId)
/*    */   {
/* 47 */     CreateCorpsConfBean xConfBean = Role2createcorpsconf.get(Long.valueOf(this.roleId));
/* 48 */     if (xConfBean == null)
/*    */     {
/* 50 */       xConfBean = Pod.newCreateCorpsConfBean();
/* 51 */       Role2createcorpsconf.insert(Long.valueOf(this.roleId), xConfBean);
/*    */     }
/* 53 */     xConfBean.getAllroles().clear();
/* 54 */     xConfBean.getAcceptroles().clear();
/* 55 */     xConfBean.setSessionid(sessionId);
/* 56 */     xConfBean.setCorpsname(this.nameOctets);
/* 57 */     xConfBean.setCorpsdeclaration(this.declarationOctets);
/* 58 */     xConfBean.setCorpsbadge(this.badgeId);
/* 59 */     xConfBean.getAllroles().addAll(this.lockRoleIds);
/* 60 */     xConfBean.getAcceptroles().add(Long.valueOf(this.roleId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PCCreateCorpsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */