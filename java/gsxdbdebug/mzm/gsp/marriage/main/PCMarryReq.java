/*     */ package mzm.gsp.marriage.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.marriage.SMarryRes;
/*     */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*     */ import mzm.gsp.marriage.confbean.SMarriageLevelCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Ceremonys;
/*     */ import xtable.Weddingceremony;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCMarryReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int level;
/*     */   private final int useYuanBao;
/*     */   
/*     */   public PCMarryReq(long roleid, int level, int useYuanBao)
/*     */   {
/*  33 */     this.roleid = roleid;
/*  34 */     this.level = level;
/*  35 */     this.useYuanBao = useYuanBao;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  40 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  42 */     List<Long> teamMembers = TeamInterface.getTeamMembersDispositionByLeaderId(this.roleid);
/*  43 */     if (teamMembers.size() != 2) {
/*  44 */       GameServer.logger().info(String.format("[Marriage]PCMarryReq.processImp@team member number is not 2|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     if (((Long)teamMembers.get(0)).longValue() != this.roleid) {
/*  50 */       GameServer.logger().info(String.format("[Marriage]PCMarryReq.processImp@player is not team leader|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!MapInterface.isNearByNPC(this.roleid, SMarriageConsts.getInstance().marriageNPC)) {
/*  56 */       GameServer.logger().info(String.format("[Marriage]PCMarryReq.processImp@player is not near npc|roleid=%d|NPCid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(SMarriageConsts.getInstance().marriageNPC) }));
/*     */       
/*     */ 
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     long roleidB = ((Long)teamMembers.get(1)).longValue();
/*     */     
/*  64 */     int genderA = RoleInterface.getGender(this.roleid);
/*  65 */     int genderB = RoleInterface.getGender(roleidB);
/*  66 */     if (genderA == genderB) {
/*  67 */       GameServer.logger().info(String.format("[Marriage]PCMarryReq.processImp@Marriage needs a man with a women|genderA=%d|genderB=%d", new Object[] { Integer.valueOf(genderA), Integer.valueOf(genderB) }));
/*     */       
/*     */ 
/*     */ 
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     int roleLevelA = RoleInterface.getLevel(this.roleid);
/*  75 */     int roleLevelB = RoleInterface.getLevel(roleidB);
/*  76 */     if ((roleLevelA < SMarriageConsts.getInstance().needLevel) || (roleLevelB < SMarriageConsts.getInstance().needLevel))
/*     */     {
/*  78 */       GameServer.logger().info(String.format("[Marriage]PCMarryReq.processImp@level not enough|levelA=%d|levelB=%d", new Object[] { Integer.valueOf(roleLevelA), Integer.valueOf(roleLevelB) }));
/*     */       
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     int relationValue = FriendInterface.getRelationValue(this.roleid, roleidB, false);
/*  85 */     if (relationValue < SMarriageConsts.getInstance().friendValue) {
/*  86 */       GameServer.logger().info(String.format("[Marriage]PCMarryReq.processImp@relation value not enough|value=%d", new Object[] { Integer.valueOf(relationValue) }));
/*     */       
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     if (MarriageInterface.isMarried(this.roleid)) {
/*  92 */       GameServer.logger().info(String.format("[Marriage]PCMarryReq.processImp@role is not single|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     if (MarriageInterface.isMarried(roleidB)) {
/*  98 */       MarriageManager.sendNormalResult(this.roleid, 0, new String[] { RoleInterface.getName(roleidB) });
/*     */       
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     if (!RoleStatusInterface.checkCansetStatus(teamMembers, 37, true, teamMembers)) {
/* 104 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 108 */     Ceremonys xCeremonys = Weddingceremony.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 109 */     if ((xCeremonys != null) && (xCeremonys.getCeremonys().size() > 0)) {
/* 110 */       MarriageManager.sendNormalResult(this.roleid, 1, new String[0]);
/* 111 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 115 */     SMarriageLevelCfg marriageLevelCfg = SMarriageLevelCfg.get(this.level);
/* 116 */     if (marriageLevelCfg == null) {
/* 117 */       GameServer.logger().info(String.format("[Marriage]PCMarryReq.processImp@marriage level config not exsit|level_config_id=%d", new Object[] { Integer.valueOf(this.level) }));
/*     */       
/*     */ 
/* 120 */       return false;
/*     */     }
/* 122 */     boolean isUseYuanBao = this.useYuanBao == 1;
/*     */     
/*     */ 
/* 125 */     if (marriageLevelCfg.itemOrMoney == 1)
/*     */     {
/* 127 */       int itemNum = ItemInterface.getItemNumberById(this.roleid, 340600000, marriageLevelCfg.itemid, false);
/* 128 */       if (itemNum < marriageLevelCfg.itemNum) {
/* 129 */         if (!isUseYuanBao)
/*     */         {
/* 131 */           GameServer.logger().info(String.format("[Marriage]PCMarryReq.processImp@player donot has enough item!", new Object[0]));
/*     */           
/* 133 */           return false;
/*     */         }
/*     */         
/*     */ 
/* 137 */         int yuanBaoPrice = ItemInterface.getItemYuanBaoPrice(marriageLevelCfg.itemid);
/* 138 */         if (yuanBaoPrice <= 0) {
/* 139 */           GameServer.logger().error(String.format("[Marriage]PCMarryReq.processImp@item do not has yuanbao price|itemid=%d", new Object[] { Integer.valueOf(marriageLevelCfg.itemid) }));
/*     */           
/*     */ 
/*     */ 
/* 143 */           return false;
/*     */         }
/*     */         
/* 146 */         int yuanBaoNum = yuanBaoPrice * marriageLevelCfg.itemNum;
/* 147 */         long yuanBao = QingfuInterface.getBalance(userid, false);
/* 148 */         if (yuanBao < yuanBaoNum) {
/* 149 */           GameServer.logger().error(String.format("[Marriage]PCMarryReq.processImp@item do not has yuanbao price|itemid=%d", new Object[] { Integer.valueOf(marriageLevelCfg.itemid) }));
/*     */           
/*     */ 
/*     */ 
/* 153 */           return false;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/* 158 */     else if (marriageLevelCfg.itemOrMoney == 0)
/*     */     {
/* 160 */       switch (marriageLevelCfg.moneyType) {
/*     */       case 2: 
/* 162 */         long glod = RoleInterface.getGold(this.roleid);
/* 163 */         if (glod < marriageLevelCfg.moneyNum) {
/* 164 */           GameServer.logger().error(String.format("[Marriage]PCMarryReq.processImp@|player do not has enough glod|needNum=%d", new Object[] { Integer.valueOf(marriageLevelCfg.moneyNum) }));
/*     */           
/*     */ 
/* 167 */           return false;
/*     */         }
/*     */         break;
/*     */       case 3: 
/* 171 */         long silverNum = RoleInterface.getSilver(this.roleid);
/* 172 */         if (silverNum < marriageLevelCfg.moneyNum) {
/* 173 */           GameServer.logger().error(String.format("[Marriage]PCMarryReq.processImp@|player do not has enough silver|needNum=%d", new Object[] { Integer.valueOf(marriageLevelCfg.moneyNum) }));
/*     */           
/*     */ 
/*     */ 
/* 177 */           return false;
/*     */         }
/*     */         break;
/*     */       case 1: 
/* 181 */         long yuanbao = QingfuInterface.getBalance(userid, false);
/* 182 */         if (yuanbao < marriageLevelCfg.moneyNum) {
/* 183 */           GameServer.logger().error(String.format("[Marriage]PCMarryReq.processImp@|player do not has enough yuanbao|needNum=%d", new Object[] { Integer.valueOf(marriageLevelCfg.moneyNum) }));
/*     */           
/*     */ 
/*     */ 
/* 187 */           return false;
/*     */         }
/*     */         
/*     */         break;
/*     */       default: 
/* 192 */         GameServer.logger().error(String.format("[Marriage]PCMarryReq.processImp@|marriageLevelCfg not exist cost moneytype|moneyType=%d", new Object[] { Integer.valueOf(marriageLevelCfg.moneyType) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 199 */         return false;
/*     */       }
/*     */       
/*     */     }
/*     */     
/* 204 */     long sessionid = new MarryReqSession(SMarriageConsts.getInstance().refuseMarriageSec, this.roleid, roleidB, isUseYuanBao, this.level).getSessionId();
/*     */     
/* 206 */     SMarryRes sMarryRes = new SMarryRes();
/* 207 */     sMarryRes.level = this.level;
/* 208 */     sMarryRes.roleid = this.roleid;
/* 209 */     sMarryRes.rolename = RoleInterface.getName(this.roleid);
/* 210 */     sMarryRes.sessionid = sessionid;
/* 211 */     OnlineManager.getInstance().sendMulti(sMarryRes, teamMembers);
/* 212 */     GameServer.logger().info(String.format("[Marriage]PCMarryReq.processImp@marry request success|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */     
/* 214 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PCMarryReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */