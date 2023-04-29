/*     */ package mzm.gsp.gift.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.gift.SGiveGiftToRoleErrorRes;
/*     */ import mzm.gsp.gift.SGiveGiftToRoleRes;
/*     */ import mzm.gsp.gift.SSynRoleReceiveGiftRes;
/*     */ import mzm.gsp.gift.confbean.SGiftCfg;
/*     */ import mzm.gsp.gift.confbean.SGiftTypeCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.PresentResult;
/*     */ import mzm.gsp.qingfu.main.PresentType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Invitation;
/*     */ import xbean.InvitedRole;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGiveGiftRoleReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long giveGiftToRoleid;
/*     */   private final long invitationid;
/*     */   private final int giftCfgid;
/*     */   
/*     */   public PCGiveGiftRoleReq(long roleid, long giveGiftRoleid, long invitationuuid, int giftcfgid)
/*     */   {
/*  34 */     this.roleid = roleid;
/*  35 */     this.giveGiftToRoleid = giveGiftRoleid;
/*  36 */     this.invitationid = invitationuuid;
/*  37 */     this.giftCfgid = giftcfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  42 */     if (!OpenInterface.getOpenStatus(217)) {
/*  43 */       GameServer.logger().info(String.format("[Gift]PCGiveGiftRoleReq.processImp@switch is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  45 */       return false;
/*     */     }
/*  47 */     if (OpenInterface.isBanPlay(this.roleid, 217)) {
/*  48 */       OpenInterface.sendBanPlayMsg(this.roleid, 217);
/*  49 */       return false;
/*     */     }
/*  51 */     if (OpenInterface.isBanPlay(this.giveGiftToRoleid, 217)) {
/*  52 */       OpenInterface.sendBanPlayMsg(this.roleid, this.giveGiftToRoleid, RoleInterface.getName(this.giveGiftToRoleid), 217);
/*     */       
/*  54 */       return false;
/*     */     }
/*  56 */     String userid = RoleInterface.getUserId(this.roleid);
/*  57 */     String giveGiftToRoleUserid = RoleInterface.getUserId(this.giveGiftToRoleid);
/*  58 */     lock(User.getTable(), Arrays.asList(new String[] { userid, giveGiftToRoleUserid }));
/*  59 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(this.giveGiftToRoleid) }));
/*  60 */     Invitation xInvitation = InvitationManager.getXInvitation(this.invitationid, true);
/*  61 */     if (xInvitation == null) {
/*  62 */       sendErrorRes(2);
/*  63 */       return false;
/*     */     }
/*  65 */     SGiftCfg giftCfg = SGiftCfg.get(this.giftCfgid);
/*  66 */     if (giftCfg == null) {
/*  67 */       GameServer.logger().error(String.format("[Gift]PCGiveGiftRoleReq.processImp@do not exsit gift cfg|roleid=%d|giftCfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.giftCfgid) }));
/*     */       
/*     */ 
/*  70 */       return false;
/*     */     }
/*  72 */     int storeGiftType = xInvitation.getGifttype();
/*  73 */     SGiftTypeCfg giftTypeCfg = SGiftTypeCfg.get(storeGiftType);
/*  74 */     if (giftTypeCfg == null) {
/*  75 */       GameServer.logger().error(String.format("[Gift]PCGiveGiftRoleReq.processImp@do not exsit gift type cfg|roleid=%d|storeGiftType=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(storeGiftType) }));
/*     */       
/*     */ 
/*     */ 
/*  79 */       return false;
/*     */     }
/*  81 */     if (giftTypeCfg.giftType != giftCfg.giftType) {
/*  82 */       GameServer.logger().error(String.format("[Gift]PCGiveGiftRoleReq.processImp@give gift type error|roleid=%d|storeGiftType=%d|giftCfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(storeGiftType), Integer.valueOf(this.giftCfgid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  87 */       return false;
/*     */     }
/*  89 */     long sendInvitationRoleid = xInvitation.getRoleid();
/*  90 */     if (sendInvitationRoleid != this.giveGiftToRoleid) {
/*  91 */       GameServer.logger().error(String.format("[Gift]PCGiveGiftRoleReq.processImp@giveGiftRoleid is not sendInvitationRoleid|sendInvitationRoleid=%d|giveGiftRoleid=%d|roleid=%d|invatationid=%d", new Object[] { Long.valueOf(sendInvitationRoleid), Long.valueOf(this.giveGiftToRoleid), Long.valueOf(this.roleid), Long.valueOf(this.invitationid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  96 */       return false;
/*     */     }
/*  98 */     InvitedRole xInvitedRole = (InvitedRole)xInvitation.getInvitedmap().get(Long.valueOf(this.roleid));
/*  99 */     if (xInvitedRole == null) {
/* 100 */       GameServer.logger().error(String.format("[Gift]PCGiveGiftRoleReq.processImp@do not invited role|roleid=%d|giveGiftRoleid=%d|invatationid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.giveGiftToRoleid), Long.valueOf(this.invitationid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 105 */       return false;
/*     */     }
/* 107 */     if (xInvitedRole.getSendgift()) {
/* 108 */       sendErrorRes(1);
/* 109 */       return false;
/*     */     }
/* 111 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 112 */     if (!InvitationManager.isAvailable(curTime, xInvitation, giftTypeCfg)) {
/* 113 */       sendErrorRes(2);
/* 114 */       return false;
/*     */     }
/*     */     
/* 117 */     switch (giftCfg.moneyType) {
/*     */     case 2: 
/* 119 */       long gold = RoleInterface.getGold(this.roleid);
/* 120 */       if (gold < giftCfg.moneyNum) {
/* 121 */         GameServer.logger().error(String.format("[Gift]PCGiveGiftRoleReq.processImp@player do not has enough glod|needNum=%d|roleid=%d", new Object[] { Integer.valueOf(giftCfg.moneyNum), Long.valueOf(this.roleid) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 126 */         return false;
/*     */       }
/* 128 */       RoleInterface.cutGold(this.roleid, giftCfg.moneyNum, new TLogArg(LogReason.GIVE_GIFT_COST, this.giftCfgid));
/* 129 */       RoleInterface.addGold(this.giveGiftToRoleid, giftCfg.moneyNum, new TLogArg(LogReason.RECEIVE_GIFT_ADD, this.giftCfgid));
/*     */       
/* 131 */       break;
/*     */     case 3: 
/* 133 */       long silver = RoleInterface.getSilver(this.roleid);
/* 134 */       if (silver < giftCfg.moneyNum) {
/* 135 */         GameServer.logger().error(String.format("[Gift]PCGiveGiftRoleReq.processImp@player do not has enough silver|needNum=%d|roleid=%d", new Object[] { Integer.valueOf(giftCfg.moneyNum), Long.valueOf(this.roleid) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 140 */         return false;
/*     */       }
/* 142 */       RoleInterface.cutSilver(this.roleid, giftCfg.moneyNum, new TLogArg(LogReason.GIVE_GIFT_COST, this.giftCfgid));
/* 143 */       RoleInterface.addSilver(this.giveGiftToRoleid, giftCfg.moneyNum, new TLogArg(LogReason.RECEIVE_GIFT_ADD, this.giftCfgid));
/*     */       
/* 145 */       break;
/*     */     case 1: 
/* 147 */       long yuanbao = QingfuInterface.getYuanbao(userid, true);
/* 148 */       if (yuanbao < giftCfg.moneyNum) {
/* 149 */         GameServer.logger().error(String.format("[Gift]PCGiveGiftRoleReq.processImp@player do not has enough yuanbao|needNum=%d|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 154 */         return false;
/*     */       }
/* 156 */       boolean suc = QingfuInterface.costYuanbao(userid, this.roleid, giftCfg.moneyNum, CostType.COST_UNBIND_FIRST_SEND_GIFT, new TLogArg(LogReason.GIVE_GIFT_COST, this.giftCfgid)) == mzm.gsp.qingfu.main.CostResult.Success;
/*     */       
/* 158 */       if (!suc) {
/* 159 */         return false;
/*     */       }
/* 161 */       boolean addRet = QingfuInterface.presentYuanbao(giveGiftToRoleUserid, this.giveGiftToRoleid, giftCfg.moneyNum, PresentType.PRSENT_BIND_RECEIVE_GIFT, new TLogArg(LogReason.RECEIVE_GIFT_ADD, this.giftCfgid)) == PresentResult.Success;
/*     */       
/* 163 */       if (!addRet) {
/* 164 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     default: 
/* 169 */       GameServer.logger().error(String.format("[Gift]PCGiveGiftRoleReq.processImp@not exist moneytype|moneyType=%d|roleid=%d", new Object[] { Integer.valueOf(giftCfg.moneyType), Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/* 172 */       return false;
/*     */     }
/* 174 */     SSynRoleReceiveGiftRes synRoleReceiveGiftRes = new SSynRoleReceiveGiftRes();
/* 175 */     synRoleReceiveGiftRes.giftcfgid = this.giftCfgid;
/* 176 */     synRoleReceiveGiftRes.receivesecs = ((int)(curTime / 1000L));
/* 177 */     InvitationManager.fillRoleInfo(this.roleid, synRoleReceiveGiftRes.roleinfo);
/*     */     
/*     */ 
/* 180 */     xInvitedRole.setGiftcfgid(this.giftCfgid);
/* 181 */     xInvitedRole.setSendgift(true);
/* 182 */     xInvitedRole.setSendgifttimemil(curTime);
/* 183 */     xInvitedRole.setSendgiftnotified(OnlineManager.getInstance().send(this.giveGiftToRoleid, synRoleReceiveGiftRes));
/*     */     
/* 185 */     SGiveGiftToRoleRes giveGiftToRoleRes = new SGiveGiftToRoleRes();
/* 186 */     giveGiftToRoleRes.roleid = this.giveGiftToRoleid;
/* 187 */     giveGiftToRoleRes.invitationuuid = this.invitationid;
/* 188 */     giveGiftToRoleRes.giftcfgid = this.giftCfgid;
/* 189 */     OnlineManager.getInstance().send(this.roleid, giveGiftToRoleRes);
/* 190 */     return true;
/*     */   }
/*     */   
/*     */   void sendErrorRes(int ret) {
/* 194 */     SGiveGiftToRoleErrorRes giveGiftToRoleErrorRes = new SGiveGiftToRoleErrorRes();
/* 195 */     giveGiftToRoleErrorRes.ret = ret;
/* 196 */     OnlineManager.getInstance().sendAtOnce(this.roleid, giveGiftToRoleErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gift\main\PCGiveGiftRoleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */