/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.log.PMergeLogRank;
/*     */ import mzm.gsp.role.multirank.MergeNTRoleMFV;
/*     */ import mzm.gsp.role.multirank.MergeRankBackUp;
/*     */ import mzm.gsp.role.multirank.MergeRoleFightValue;
/*     */ import mzm.gsp.role.multirank.MergeRoleLevel;
/*     */ import mzm.gsp.role.multirank.MergeRoleMFV;
/*     */ import mzm.gsp.role.multirank.MergeRoleNTFightValue;
/*     */ import mzm.gsp.role.multirank.MergeRoleNTLevel;
/*     */ import mzm.gsp.role.multirank.MergeRoleNTOccMFV;
/*     */ import mzm.gsp.role.multirank.MergeRoleOccMFV;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Table;
/*     */ import xtable.Multifightvaluerank;
/*     */ import xtable.Role2daymoneyinfo;
/*     */ import xtable.Role2storageexp;
/*     */ import xtable.Role2totaldata;
/*     */ 
/*     */ public class RoleMerge implements mzm.gsp.MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  26 */     List<Table> tables = new java.util.ArrayList();
/*     */     
/*  28 */     tables.add(xtable.User.getTable());
/*  29 */     tables.add(xtable.Basic.getTable());
/*  30 */     tables.add(xtable.Role2delete.getTable());
/*  31 */     tables.add(xtable.Name2roleid.getTable());
/*  32 */     tables.add(xtable.Role2properties.getTable());
/*  33 */     tables.add(xtable.Role2vigor.getTable());
/*  34 */     tables.add(xtable.Role2offlineexpreward.getTable());
/*  35 */     tables.add(Role2storageexp.getTable());
/*  36 */     tables.add(xtable.Rolechangetable.getTable());
/*  37 */     tables.add(xtable.Role2banquestinfo.getTable());
/*  38 */     tables.add(Role2totaldata.getTable());
/*  39 */     tables.add(xtable.Role2dayclear.getTable());
/*  40 */     tables.add(xtable.Role2alllostexpinfo.getTable());
/*     */     
/*  42 */     tables.add(xtable.Rolelevelrank.getTable());
/*  43 */     tables.add(xtable.Nonerealtimerolelevelrank.getTable());
/*     */     
/*  45 */     tables.add(xtable.Fightvaluerank.getTable());
/*  46 */     tables.add(xtable.Nonerealtimefightvaluerank.getTable());
/*     */     
/*  48 */     tables.add(Multifightvaluerank.getTable());
/*  49 */     tables.add(xtable.Nonerealtimemultifightvaluerank.getTable());
/*     */     
/*  51 */     tables.add(xtable.Occmfvrank.getTable());
/*  52 */     tables.add(xtable.Nonerealtimeoccmfvrank.getTable());
/*     */     
/*  54 */     tables.add(xtable.Nonerealtimerolelevelrankbackup.getTable());
/*  55 */     tables.add(xtable.Nonerealtimefightvaluerankbackup.getTable());
/*  56 */     tables.add(xtable.Nonerealtimemultifightvaluerankbackup.getTable());
/*     */     
/*  58 */     tables.add(xtable.Logrolerank.getTable());
/*     */     
/*  60 */     tables.add(Role2daymoneyinfo.getTable());
/*     */     
/*  62 */     tables.add(xtable.Role2voteinfo.getTable());
/*     */     
/*  64 */     tables.add(xtable.Role2daymoneycostinfo.getTable());
/*     */     
/*  66 */     tables.add(xtable.Role2worldquestion.getTable());
/*     */     
/*  68 */     tables.add(xtable.Role2commonmultiinfo.getTable());
/*     */     
/*  70 */     tables.add(xtable.Nonerealtimeoccmfvrankbackup.getTable());
/*     */     
/*  72 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  78 */     if (!mergeRoleRankTable())
/*     */     {
/*  80 */       GameServer.logger().error(String.format("[roleMerge]RoleMerge.handleMerge@ mergeRoleRankTable fail!", new Object[0]));
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     if (!new PMergeLogRank().call())
/*     */     {
/*  86 */       GameServer.logger().error(String.format("[logrankMerge]RoleMerge.mergeRankLog@ merge rank log fail!", new Object[0]));
/*  87 */       return false;
/*     */     }
/*  89 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean mergeRoleRankTable()
/*     */   {
/*  99 */     boolean ret = true;
/*     */     
/*     */ 
/* 102 */     if (!new MergeRoleLevel().call())
/*     */     {
/* 104 */       GameServer.logger().error(String.format("[roleMerge]RoleMerge.mergeRoleRankTable@ MergeRoleLvRank fail!", new Object[0]));
/* 105 */       ret = false;
/*     */     }
/* 107 */     if (!new MergeRoleNTLevel().call())
/*     */     {
/* 109 */       GameServer.logger().error(String.format("[roleMerge]RoleMerge.mergeRoleRankTable@ MergeRoleNTLvRank fail!", new Object[0]));
/* 110 */       ret = false;
/*     */     }
/*     */     
/*     */ 
/* 114 */     if (!new MergeRoleFightValue().call())
/*     */     {
/* 116 */       GameServer.logger().error(String.format("[roleMerge]RoleMerge.mergeRoleRankTable@ MergeRoleFightRank fail!", new Object[0]));
/* 117 */       ret = false;
/*     */     }
/* 119 */     if (!new MergeRoleNTFightValue().call())
/*     */     {
/* 121 */       GameServer.logger().error(String.format("[roleMerge]RoleMerge.mergeRoleRankTable@ MergeRoleNTFightRank fail!", new Object[0]));
/* 122 */       ret = false;
/*     */     }
/*     */     
/*     */ 
/* 126 */     if (!new MergeRoleMFV().call())
/*     */     {
/* 128 */       GameServer.logger().error(String.format("[roleMerge]RoleMerge.mergeRoleRankTable@ MergeRoleMFVRank fail!", new Object[0]));
/* 129 */       ret = false;
/*     */     }
/* 131 */     if (!new MergeNTRoleMFV().call())
/*     */     {
/* 133 */       GameServer.logger().error(String.format("[roleMerge]RoleMerge.mergeRoleRankTable@ MergeRoleNTMFVRank fail!", new Object[0]));
/* 134 */       ret = false;
/*     */     }
/*     */     
/*     */ 
/* 138 */     if (!new MergeRoleOccMFV().call())
/*     */     {
/* 140 */       GameServer.logger().error(String.format("[roleMerge]RoleMerge.mergeRoleRankTable@ MergeOccMFVRank fail!", new Object[0]));
/* 141 */       ret = false;
/*     */     }
/* 143 */     if (!new MergeRoleNTOccMFV().call())
/*     */     {
/* 145 */       GameServer.logger().error(String.format("[roleMerge]RoleMerge.mergeRoleRankTable@ MergeNTOccMFVLvRank fail!", new Object[0]));
/* 146 */       ret = false;
/*     */     }
/*     */     
/*     */ 
/* 150 */     ret = MergeRankBackUp.getInstance().mergeRoleRankBackUp();
/* 151 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */