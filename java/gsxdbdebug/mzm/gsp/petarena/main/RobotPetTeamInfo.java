/*     */ package mzm.gsp.petarena.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.fight.main.FightInterface.PetFightRobotInfo;
/*     */ import mzm.gsp.fight.main.FightInterface.PetFightRobotInfo.PetRobot;
/*     */ import mzm.gsp.pet.main.PetFightTeam;
/*     */ import mzm.gsp.pet.main.PetFightTeam.Position;
/*     */ import mzm.gsp.petarena.OpponentInfo;
/*     */ import mzm.gsp.petarena.PetArenaTeamInfo;
/*     */ import mzm.gsp.petarena.PositionInfo;
/*     */ import mzm.gsp.petarena.confbean.SPetArenaConst;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ 
/*     */ public class RobotPetTeamInfo
/*     */   implements PetTeamInfo
/*     */ {
/*     */   public final int formation;
/*     */   public final int formationLevel;
/*  22 */   private final Map<Integer, RobotPetPositionInfo> positions = new HashMap();
/*  23 */   private final Map<Long, RobotPetInfo> robotPetInfos = new HashMap();
/*     */   
/*     */   private final int score;
/*     */   private final int level;
/*     */   
/*     */   public RobotPetTeamInfo(int formation, int formationLevel, Map<Integer, RobotPetPositionInfo> positions, Map<Long, RobotPetInfo> robotPetInfos, int level)
/*     */   {
/*  30 */     this.formation = formation;
/*  31 */     this.formationLevel = formationLevel;
/*  32 */     if (positions != null)
/*     */     {
/*  34 */       this.positions.putAll(positions);
/*     */     }
/*  36 */     if (robotPetInfos != null)
/*     */     {
/*  38 */       this.robotPetInfos.putAll(robotPetInfos);
/*  39 */       int num = 0;
/*  40 */       for (RobotPetInfo robotPetInfo : robotPetInfos.values())
/*     */       {
/*  42 */         num += robotPetInfo.score;
/*     */       }
/*  44 */       this.score = num;
/*     */     }
/*     */     else
/*     */     {
/*  48 */       this.score = 0;
/*     */     }
/*  50 */     this.level = level;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getScore()
/*     */   {
/*  56 */     return this.score;
/*     */   }
/*     */   
/*     */ 
/*     */   public OpponentInfo getOpponentInfo()
/*     */   {
/*  62 */     OpponentInfo opponentInfo = new OpponentInfo();
/*  63 */     opponentInfo.score = this.score;
/*  64 */     opponentInfo.level = this.level;
/*  65 */     return opponentInfo;
/*     */   }
/*     */   
/*     */   public void fillPetArenaTeamInfo(PetArenaTeamInfo teamInfo)
/*     */   {
/*  70 */     teamInfo.formation = this.formation;
/*  71 */     teamInfo.formation_level = this.formationLevel;
/*     */     
/*  73 */     int petLevel = ServerInterface.getCurrentServerLevel() + SPetArenaConst.getInstance().ROBOT_PET_LEVEL;
/*     */     
/*  75 */     for (Map.Entry<Integer, RobotPetPositionInfo> entry : this.positions.entrySet())
/*     */     {
/*  77 */       RobotPetPositionInfo petPositionInfo = (RobotPetPositionInfo)entry.getValue();
/*  78 */       long petid = petPositionInfo.petid;
/*  79 */       PositionInfo positionInfo = new PositionInfo();
/*  80 */       positionInfo.petid = petid;
/*  81 */       positionInfo.pet_fight_skill = petPositionInfo.petFightSkill;
/*  82 */       positionInfo.properties.putAll(petPositionInfo.properties);
/*  83 */       teamInfo.position_infos.put(Integer.valueOf(petPositionInfo.position), positionInfo);
/*     */       
/*  85 */       RobotPetInfo robotPetInfo = (RobotPetInfo)this.robotPetInfos.get(Long.valueOf(petid));
/*  86 */       mzm.gsp.petarena.RobotPetInfo petInfo = robotPetInfo.buildRobotPetInfo();
/*  87 */       petInfo.level = petLevel;
/*  88 */       teamInfo.robot_infos.put(Long.valueOf(petid), petInfo);
/*     */     }
/*     */   }
/*     */   
/*     */   public void fillPetFightRobotInfo(FightInterface.PetFightRobotInfo robotFightInfo)
/*     */   {
/*  94 */     int petLevel = ServerInterface.getCurrentServerLevel() + SPetArenaConst.getInstance().ROBOT_PET_LEVEL;
/*  95 */     PetFightTeam robotZhenFa = new PetFightTeam(this.formation, this.formationLevel);
/*  96 */     robotFightInfo.zhenfaInfo = robotZhenFa;
/*     */     
/*  98 */     for (Map.Entry<Integer, RobotPetPositionInfo> entry : this.positions.entrySet())
/*     */     {
/* 100 */       int grid = ((Integer)entry.getKey()).intValue();
/* 101 */       RobotPetPositionInfo petPositionInfo = (RobotPetPositionInfo)entry.getValue();
/* 102 */       long petid = petPositionInfo.petid;
/* 103 */       PetFightTeam.Position positionInfo = new PetFightTeam.Position(petid, petPositionInfo.petFightSkill, petPositionInfo.position);
/* 104 */       positionInfo.properties.putAll(petPositionInfo.properties);
/* 105 */       robotZhenFa.positions.put(Integer.valueOf(grid), positionInfo);
/*     */       
/* 107 */       RobotPetInfo robotPetInfo = (RobotPetInfo)this.robotPetInfos.get(Long.valueOf(petid));
/* 108 */       FightInterface.PetFightRobotInfo.PetRobot petRobot = new FightInterface.PetFightRobotInfo.PetRobot();
/* 109 */       petRobot.monsterCfgId = robotPetInfo.monsterCfgid;
/* 110 */       petRobot.level = petLevel;
/* 111 */       robotFightInfo.robots.put(Integer.valueOf(grid), petRobot);
/*     */     }
/*     */   }
/*     */   
/*     */   public void fillPetAreanFightInfos(List<PetArenaFightInfo> infos)
/*     */   {
/* 117 */     for (Map.Entry<Integer, RobotPetPositionInfo> entry : this.positions.entrySet())
/*     */     {
/* 119 */       RobotPetPositionInfo positionInfo = (RobotPetPositionInfo)entry.getValue();
/* 120 */       long petid = positionInfo.petid;
/* 121 */       RobotPetInfo robotPetInfo = (RobotPetInfo)this.robotPetInfos.get(Long.valueOf(petid));
/* 122 */       PetArenaFightInfo petArenaFightInfo = new PetArenaFightInfo(petid, positionInfo.position, 0, robotPetInfo.monsterCfgid, robotPetInfo.name);
/*     */       
/* 124 */       infos.add(petArenaFightInfo);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\RobotPetTeamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */