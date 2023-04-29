/*     */ package mzm.gsp.petarena.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.PetInfo;
/*     */ import mzm.gsp.pet.main.PetFightTeam;
/*     */ import mzm.gsp.pet.main.PetFightTeam.Position;
/*     */ import mzm.gsp.petarena.PetArenaTeamInfo;
/*     */ import mzm.gsp.petarena.PositionInfo;
/*     */ import mzm.gsp.petarena.SGetDefendPetTeamFailed;
/*     */ import mzm.gsp.petarena.SGetDefendPetTeamSuccess;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetArenaInfo;
/*     */ import xbean.PetArenaRankInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2petarenainfo;
/*     */ 
/*     */ public class PCGetDefendPetTeam extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long targetRoleid;
/*     */   private final int rank;
/*     */   private final int serial;
/*     */   
/*     */   public PCGetDefendPetTeam(long roleid, long targetRoleid, int rank, int serial)
/*     */   {
/*  31 */     this.roleid = roleid;
/*  32 */     this.targetRoleid = targetRoleid;
/*  33 */     this.rank = rank;
/*  34 */     this.serial = serial;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if ((this.targetRoleid < 0L) || (this.rank <= 0))
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!PetArenaManager.canDoAction(this.roleid, 2114))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!PetArenaManager.isFunOpen(this.roleid))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     if (this.targetRoleid > 0L)
/*     */     {
/*  58 */       lock(Lockeys.get(Basic.getTable(), new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.targetRoleid) }));
/*     */     }
/*     */     else
/*     */     {
/*  62 */       lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     }
/*     */     
/*  65 */     PetArenaInfo xPetArenaInfo = Role2petarenainfo.get(Long.valueOf(this.roleid));
/*  66 */     if (xPetArenaInfo == null)
/*     */     {
/*  68 */       onFailed(1);
/*  69 */       return false;
/*     */     }
/*  71 */     PetArenaManager.checkData(xPetArenaInfo);
/*     */     
/*     */ 
/*  74 */     if (this.serial != xPetArenaInfo.getOpponent_serial())
/*     */     {
/*  76 */       PetArenaManager.sendPetAreanInfoMsg(this.roleid, xPetArenaInfo);
/*  77 */       onFailed(-2);
/*  78 */       return true;
/*     */     }
/*     */     
/*  81 */     PetArenaRankInfo xTargetPetArenaRankInfo = null;
/*  82 */     for (PetArenaRankInfo xPetArenaRankInfo : xPetArenaInfo.getOpponent_ranks())
/*     */     {
/*  84 */       if ((xPetArenaRankInfo.getRank() == this.rank) && (xPetArenaRankInfo.getRoleid() == this.targetRoleid))
/*     */       {
/*  86 */         xTargetPetArenaRankInfo = xPetArenaRankInfo;
/*  87 */         break;
/*     */       }
/*     */     }
/*  90 */     if (xTargetPetArenaRankInfo == null)
/*     */     {
/*  92 */       onFailed(6);
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     if (PetArenaRankManager.getInstance().checkRankChanged(this.rank, this.targetRoleid))
/*     */     {
/*  98 */       PetArenaManager.sendPetAreanInfoMsg(this.roleid, xPetArenaInfo);
/*  99 */       onFailed(-3);
/* 100 */       return true;
/*     */     }
/*     */     
/* 103 */     SGetDefendPetTeamSuccess msg = new SGetDefendPetTeamSuccess();
/* 104 */     msg.rank = this.rank;
/* 105 */     msg.target_roleid = this.targetRoleid;
/* 106 */     PetArenaTeamInfo petArenaTeamInfo; if (this.targetRoleid > 0L)
/*     */     {
/* 108 */       PetFightTeam petFightTeam = mzm.gsp.pet.main.PetFightInterface.getPetFightDefenseTeam(this.targetRoleid, true);
/* 109 */       if (petFightTeam == null)
/*     */       {
/* 111 */         onFailed(7);
/* 112 */         return false;
/*     */       }
/*     */       
/* 115 */       petArenaTeamInfo = msg.team_info;
/* 116 */       petArenaTeamInfo.formation = petFightTeam.formationId;
/* 117 */       petArenaTeamInfo.formation_level = petFightTeam.formationLevel;
/*     */       
/* 119 */       for (Map.Entry<Integer, PetFightTeam.Position> entry : petFightTeam.positions.entrySet())
/*     */       {
/* 121 */         PetFightTeam.Position position = (PetFightTeam.Position)entry.getValue();
/* 122 */         long petid = position.petId;
/* 123 */         PetInfo petInfo = mzm.gsp.pet.main.PetInterface.getPetInfo(this.targetRoleid, petid);
/* 124 */         petArenaTeamInfo.pet_infos.put(Long.valueOf(petid), petInfo);
/*     */         
/* 126 */         PositionInfo positionInfo = new PositionInfo();
/* 127 */         positionInfo.pet_fight_skill = position.petFightSkillId;
/* 128 */         positionInfo.petid = position.petId;
/*     */         
/* 130 */         petArenaTeamInfo.position_infos.put(Integer.valueOf(position.positionNumber), positionInfo);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 135 */       RobotPetTeamInfo robotPetTeamInfo = PetArenaTeamManager.getInstance().getPetTeamInfo(this.rank);
/* 136 */       if (robotPetTeamInfo == null)
/*     */       {
/* 138 */         PetArenaTeamManager.asyncGetDefendPetTeamInfo(this.roleid, this.rank);
/* 139 */         GameServer.logger().info(String.format("[petarena]PCGetDefendPetTeam.processImp@async send msg|roleid=%d|rank=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rank), Long.valueOf(this.targetRoleid) }));
/*     */         
/*     */ 
/*     */ 
/* 143 */         return true;
/*     */       }
/* 145 */       robotPetTeamInfo.fillPetArenaTeamInfo(msg.team_info);
/*     */     }
/* 147 */     OnlineManager.getInstance().send(this.roleid, msg);
/*     */     
/* 149 */     GameServer.logger().info(String.format("[petarena]PCGetDefendPetTeam.processImp@get success|roleid=%d|rank=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rank), Long.valueOf(this.targetRoleid) }));
/*     */     
/*     */ 
/* 152 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 157 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 162 */     SGetDefendPetTeamFailed rsp = new SGetDefendPetTeamFailed();
/* 163 */     rsp.retcode = retcode;
/* 164 */     rsp.rank = this.rank;
/* 165 */     rsp.target_roleid = this.targetRoleid;
/* 166 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 168 */     StringBuilder logBuilder = new StringBuilder();
/* 169 */     logBuilder.append("[petarena]PCGetDefendPetTeam.onFailed@failed");
/* 170 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 171 */     logBuilder.append('|').append("target_roleid=").append(this.targetRoleid);
/* 172 */     logBuilder.append('|').append("rank=").append(this.rank);
/* 173 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 175 */     if (extraParams != null)
/*     */     {
/* 177 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 179 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 183 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PCGetDefendPetTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */