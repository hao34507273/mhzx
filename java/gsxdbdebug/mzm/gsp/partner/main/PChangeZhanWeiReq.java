/*     */ package mzm.gsp.partner.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.partner.event.PartnerPositionChange;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LineUp;
/*     */ import xbean.PartnerBag;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2partnerbag;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PChangeZhanWeiReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int lineUpNum;
/*     */   private int srcpos;
/*     */   private int dstpos;
/*     */   
/*     */   public PChangeZhanWeiReq(long roleId, int lineUpNum, int srcpos, int dstpos)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.lineUpNum = lineUpNum;
/*  33 */     this.srcpos = srcpos;
/*  34 */     this.dstpos = dstpos;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 391, true))
/*     */     {
/*  42 */       GameServer.logger().info(String.format("[team]PChangeZhanWeiReq.processImp@ can not adjust disposition!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if ((this.lineUpNum < 0) || (this.lineUpNum > 2))
/*     */     {
/*  49 */       GameServer.logger().error(String.format("[partner]PChangeZhanWeiReq.processImp@client data error|roleId=%d|lineUpNum=%d|srcpos=%d|dstpos=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.lineUpNum), Integer.valueOf(this.srcpos), Integer.valueOf(this.dstpos) }));
/*     */       
/*     */ 
/*     */ 
/*  53 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  57 */     lock(Lockeys.get(User.getTable(), RoleInterface.getUserId(this.roleId)));
/*     */     
/*  59 */     PartnerBag partnerBag = Role2partnerbag.get(Long.valueOf(this.roleId));
/*  60 */     if (partnerBag == null)
/*     */     {
/*  62 */       GameServer.logger().error(String.format("[partner]PChangeZhanWeiReq.processImp@ partner xdb date not exist!|roleId=%d|lineUpNum=%d|srcpos=%d|dstpos=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.lineUpNum), Integer.valueOf(this.srcpos), Integer.valueOf(this.dstpos) }));
/*     */       
/*     */ 
/*     */ 
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (!canActiveChangeZhanweiInStatus(this.roleId))
/*     */     {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     LineUp xLineUp = (LineUp)partnerBag.getLineups().get(Integer.valueOf(this.lineUpNum));
/*  75 */     if (xLineUp == null)
/*     */     {
/*  77 */       GameServer.logger().error(String.format("[partner]PChangeZhanWeiReq.processImp@ lineUp not exist!|roleId=%d|lineUpNum=%d|srcpos=%d|dstpos=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.lineUpNum), Integer.valueOf(this.srcpos), Integer.valueOf(this.dstpos) }));
/*     */       
/*     */ 
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     Map<Integer, Integer> pos = xLineUp.getPositions();
/*  85 */     if (pos == null)
/*     */     {
/*  87 */       GameServer.logger().error(String.format("[partner]PChangeZhanWeiReq.processImp@ position not exist!|roleId=%d|lineUpNum=%d|srcpos=%d|dstpos=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.lineUpNum), Integer.valueOf(this.srcpos), Integer.valueOf(this.dstpos) }));
/*     */       
/*     */ 
/*     */ 
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     int oldIndex_real = this.srcpos - 1;
/*  95 */     int newIndex_real = this.dstpos - 1;
/*  96 */     Integer oldPartnerId = (Integer)pos.get(Integer.valueOf(oldIndex_real));
/*  97 */     Integer newPartnerId = (Integer)pos.get(Integer.valueOf(newIndex_real));
/*     */     
/*  99 */     if ((oldPartnerId == null) || (newPartnerId == null))
/*     */     {
/* 101 */       GameServer.logger().error(String.format("[partner]PChangeZhanWeiReq.processImp@ partner not exist!|roleId=%d|lineUpNum=%d|srcpos=%d|dstpos=%d|oldPartner=%d|newPartner=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.lineUpNum), Integer.valueOf(this.srcpos), Integer.valueOf(this.dstpos), Integer.valueOf(oldPartnerId == null ? 0 : oldPartnerId.intValue()), Integer.valueOf(newPartnerId == null ? 0 : newPartnerId.intValue()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     xLineUp.getPositions().put(Integer.valueOf(newIndex_real), oldPartnerId);
/* 110 */     xLineUp.getPositions().put(Integer.valueOf(oldIndex_real), newPartnerId);
/*     */     
/* 112 */     PartnerManager.sendLineUpChangePro(this.roleId, this.lineUpNum, xLineUp);
/*     */     
/* 114 */     if (partnerBag.getDefaultlineupnum() == this.lineUpNum)
/*     */     {
/* 116 */       TriggerEventsManger.getInstance().triggerEvent(new PartnerPositionChange(), new PartnerPositionChangeEventArg(this.roleId, PartnerPositionChangeEventArg.PositionChangeTye.CHANGE_ZHAN_WEI));
/*     */     }
/*     */     
/* 119 */     return true;
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
/*     */   private boolean canActiveChangeZhanweiInStatus(long roleId)
/*     */   {
/* 133 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 64, true))
/*     */     {
/* 135 */       GameServer.logger().error(String.format("[parnter]PChangeZhanWeiReq.canActiveChangeZhanweiInStatus@ active ChangeZhanwei is forbiddened!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*     */ 
/* 139 */       return false;
/*     */     }
/* 141 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PChangeZhanWeiReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */