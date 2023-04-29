/*     */ package mzm.gsp.partner.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.partner.confbean.STTask2partner;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*     */ import mzm.gsp.task.main.TaskEventArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnTaskStateChanged
/*     */   extends TaskStateChangeProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  24 */     int partnerId = getPartnerId(((TaskEventArg)this.arg).graphId, ((TaskEventArg)this.arg).taskId);
/*  25 */     if (partnerId < 0)
/*     */     {
/*  27 */       return false;
/*     */     }
/*     */     
/*  30 */     if (((TaskEventArg)this.arg).taskState != 8)
/*     */     {
/*  32 */       return false;
/*     */     }
/*     */     
/*  35 */     long roleId = ((TaskEventArg)this.arg).roleId;
/*     */     
/*  37 */     String userid = RoleInterface.getUserId(roleId);
/*  38 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*     */ 
/*  41 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*     */     
/*  43 */     RolePartner rolePartner = PartnerManager.getRolePartner(roleId, true);
/*  44 */     if (rolePartner == null)
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     if (!getThisPartner(partnerId, roleId, userid, rolePartner))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     new PLineUpPartner(roleId, partnerId).execute();
/*  55 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean lineUpPartner(int partnerId, long roleId, RolePartner rolePartner)
/*     */   {
/*  68 */     int lineUpNum = PartnerManager.getDefLineUp(rolePartner);
/*  69 */     if (lineUpNum < 0)
/*     */     {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     if (!PartnerManager.onAddLineUpPartner(roleId, partnerId, lineUpNum, rolePartner))
/*     */     {
/*  76 */       GameServer.logger().error(String.format("[partner]POnTaskStateChanged.processImp@ try add partner 2 lineUp fail!|roleId=%d|partnerId=%d|lineUpNum", new Object[] { Long.valueOf(roleId), Integer.valueOf(partnerId), Integer.valueOf(lineUpNum) }));
/*     */       
/*     */ 
/*     */ 
/*  80 */       return false;
/*     */     }
/*  82 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean getThisPartner(int partnerId, long roleId, String userid, RolePartner rolePartner)
/*     */   {
/*  96 */     if (rolePartner.ownPartner(partnerId))
/*     */     {
/*  98 */       return true;
/*     */     }
/* 100 */     if (!PartnerManager.onActivePartnerRep(userid, roleId, partnerId, rolePartner))
/*     */     {
/* 102 */       GameServer.logger().error(String.format("[partner]POnTaskStateChanged.processImp@ try get partner fail!|roleId=%d|partnerId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(partnerId) }));
/*     */       
/*     */ 
/* 105 */       return false;
/*     */     }
/* 107 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getPartnerId(int graphId, int taskId)
/*     */   {
/* 119 */     STTask2partner cfg = STTask2partner.get(taskId);
/* 120 */     if (cfg == null)
/*     */     {
/* 122 */       return -1;
/*     */     }
/* 124 */     Integer partnerId = (Integer)cfg.graphId2partner.get(Integer.valueOf(graphId));
/* 125 */     return partnerId == null ? -1 : partnerId.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   class PLineUpPartner
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */ 
/*     */     private final int partnerId;
/*     */     
/*     */ 
/*     */     public PLineUpPartner(long roleId, int partnerId)
/*     */     {
/* 141 */       this.roleId = roleId;
/* 142 */       this.partnerId = partnerId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 149 */       String userid = RoleInterface.getUserId(this.roleId);
/* 150 */       lock(Lockeys.get(User.getTable(), userid));
/*     */       
/*     */ 
/* 153 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */       
/* 155 */       RolePartner rolePartner = PartnerManager.getRolePartner(this.roleId, true);
/* 156 */       if (rolePartner == null)
/*     */       {
/* 158 */         return false;
/*     */       }
/* 160 */       if (rolePartner.getPartnerBag() == null)
/*     */       {
/* 162 */         return false;
/*     */       }
/*     */       
/* 165 */       if (!POnTaskStateChanged.this.lineUpPartner(this.partnerId, this.roleId, rolePartner))
/*     */       {
/* 167 */         return false;
/*     */       }
/* 169 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\POnTaskStateChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */