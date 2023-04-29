/*     */ package mzm.gsp.marriage.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.marriage.SSChangeMarriageTitleRes;
/*     */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*     */ import mzm.gsp.marriage.confbean.SMarriageTitileCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Role2marriage;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCChangeMarriageTitleReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int marriagetitlecfgid;
/*     */   
/*     */   public PCChangeMarriageTitleReq(long roleid, int marriagetitlecfgid)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.marriagetitlecfgid = marriagetitlecfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  36 */     SMarriageTitileCfg marriageTitileCfg = SMarriageTitileCfg.get(this.marriagetitlecfgid);
/*  37 */     if (marriageTitileCfg == null) {
/*  38 */       GameServer.logger().info(String.format("[Marriage]PCChangeMarriageTitleReq.processImp@marriage title config not exist|configid=%d", new Object[] { Integer.valueOf(this.marriagetitlecfgid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     List<Long> teamMembers = TeamInterface.getTeamMembersDispositionByLeaderId(this.roleid);
/*  49 */     if (teamMembers.size() != 2) {
/*  50 */       GameServer.logger().info(String.format("[Marriage]PCChangeMarriageTitleReq.processImp@team member number is not 2|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     if (((Long)teamMembers.get(0)).longValue() != this.roleid) {
/*  58 */       GameServer.logger().info(String.format("[Marriage]PCChangeMarriageTitleReq.processImp@player is not team leader|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if (!MapInterface.isNearByNPC(this.roleid, SMarriageConsts.getInstance().marriageNPC)) {
/*  65 */       GameServer.logger().info(String.format("[Marriage]PCChangeMarriageTitleReq.processImp@player is not near npc|roleid=%d|NPCid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(SMarriageConsts.getInstance().marriageNPC) }));
/*     */       
/*     */ 
/*     */ 
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     long otherRoleid = ((Long)teamMembers.get(1)).longValue();
/*     */     
/*     */ 
/*  75 */     String userid = RoleInterface.getUserId(this.roleid);
/*  76 */     lock(xdb.Lockeys.get(User.getTable(), userid));
/*     */     
/*     */ 
/*  79 */     lock(Role2marriage.getTable(), teamMembers);
/*  80 */     Long marriageId = Role2marriage.get(Long.valueOf(this.roleid));
/*  81 */     if (marriageId == null) {
/*  82 */       GameServer.logger().info(String.format("[Marriage]PCChangeMarriageTitleReq.processImp@player is not married|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     xbean.Marriage xMarriage = xtable.Marriage.get(marriageId);
/*  89 */     if (xMarriage == null) {
/*  90 */       GameServer.logger().error(String.format("[Marriage]PCChangeMarriageTitleReq.processImp@marriage data is wrong|roleid=%d|marriageid=%d", new Object[] { Long.valueOf(this.roleid), marriageId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     long roleidA = xMarriage.getRoleida();
/* 101 */     long roleidB = xMarriage.getRoleidb();
/* 102 */     if ((roleidA != otherRoleid) && (roleidB != otherRoleid)) {
/* 103 */       GameServer.logger().info(String.format("[Marriage]PCChangeMarriageTitleReq.processImp@team member and leader are not a couple|roleid=%d|marriageid=%d", new Object[] { Long.valueOf(this.roleid), marriageId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     int oldmarriageTitle = xMarriage.getMarriagetitle();
/* 114 */     if (oldmarriageTitle == this.marriagetitlecfgid) {
/* 115 */       GameServer.logger().info(String.format("[Marriage]PCChangeMarriageTitleReq.processImp@can not change to the same marriage titile |marriagetitlecfgid=%d", new Object[] { Integer.valueOf(this.marriagetitlecfgid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 122 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 126 */     switch (marriageTitileCfg.moneyType) {
/*     */     case 2: 
/* 128 */       long gold = RoleInterface.getGold(this.roleid);
/* 129 */       if (gold < marriageTitileCfg.moneyNum) {
/* 130 */         GameServer.logger().info(String.format("[Marriage]PCChangeMarriageTitleReq.processImp@|player do not has enough glod|needNum=%d", new Object[] { Integer.valueOf(marriageTitileCfg.moneyNum) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 137 */         return false;
/*     */       }
/* 139 */       RoleInterface.cutGold(this.roleid, marriageTitileCfg.moneyNum, new TLogArg(LogReason.MARRIAGE_CHANGE_TITLE_COST));
/*     */       
/* 141 */       break;
/*     */     case 3: 
/* 143 */       long silver = RoleInterface.getSilver(this.roleid);
/* 144 */       if (silver < marriageTitileCfg.moneyNum) {
/* 145 */         GameServer.logger().info(String.format("[Marriage]PCChangeMarriageTitleReq.processImp@|player do not has enough silver|needNum=%d", new Object[] { Integer.valueOf(marriageTitileCfg.moneyNum) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 152 */         return false;
/*     */       }
/* 154 */       RoleInterface.cutSilver(this.roleid, marriageTitileCfg.moneyNum, new TLogArg(LogReason.MARRIAGE_CHANGE_TITLE_COST));
/*     */       
/* 156 */       break;
/*     */     case 1: 
/* 158 */       long yuanbao = QingfuInterface.getBalance(userid, true);
/* 159 */       if (yuanbao < marriageTitileCfg.moneyNum) {
/* 160 */         GameServer.logger().info(String.format("[Marriage]PCChangeMarriageTitleReq.processImp@|player do not has enough yuanbao|needNum=%d", new Object[] { Integer.valueOf(marriageTitileCfg.moneyNum) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 167 */         return false;
/*     */       }
/* 169 */       boolean suc = QingfuInterface.costYuanbao(userid, this.roleid, marriageTitileCfg.moneyNum, CostType.COST_BIND_FIRST_MARRIAGE_CHANGE_TITLE, new TLogArg(LogReason.MARRIAGE_CHANGE_TITLE_COST)) == CostResult.Success;
/*     */       
/* 171 */       if (!suc) {
/* 172 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     case 0: 
/*     */       break;
/*     */     default: 
/* 179 */       GameServer.logger().error(String.format("[Marriage]PCChangeMarriageTitleReq.processImp@|marriageLevelCfg not exist cost moneytype|moneyType=%d", new Object[] { Integer.valueOf(marriageTitileCfg.moneyType) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 186 */       return false;
/*     */     }
/*     */     
/*     */     
/* 190 */     SMarriageTitileCfg oldMarriageTitileCfg = SMarriageTitileCfg.get(oldmarriageTitle);
/* 191 */     TitleInterface.removeAppllation(roleidA, oldMarriageTitileCfg.manTitle);
/* 192 */     TitleInterface.removeAppllation(roleidB, oldMarriageTitileCfg.womenTitle);
/* 193 */     xMarriage.setMarriagetitle(marriageTitileCfg.id);
/* 194 */     TitleInterface.addAppellation(roleidA, marriageTitileCfg.manTitle, Arrays.asList(new String[] { RoleInterface.getName(roleidB) }), true);
/*     */     
/* 196 */     TitleInterface.addAppellation(roleidB, marriageTitileCfg.womenTitle, Arrays.asList(new String[] { RoleInterface.getName(roleidA) }), true);
/*     */     
/*     */ 
/* 199 */     SSChangeMarriageTitleRes ssChangeMarriageTitleRes = new SSChangeMarriageTitleRes();
/* 200 */     ssChangeMarriageTitleRes.marriagetitlecfgid = this.marriagetitlecfgid;
/* 201 */     OnlineManager.getInstance().sendMulti(ssChangeMarriageTitleRes, teamMembers);
/*     */     
/* 203 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PCChangeMarriageTitleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */