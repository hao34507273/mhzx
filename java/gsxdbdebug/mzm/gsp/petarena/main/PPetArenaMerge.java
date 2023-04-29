/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.PetArenaRank;
/*    */ import xbean.PetArenaRankBackup;
/*    */ import xtable.Petarenarank;
/*    */ import xtable.Petarenarankbackup;
/*    */ 
/*    */ public class PPetArenaMerge extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long mainKey = mzm.gsp.MergeMain.getMainZoneid();
/* 14 */     long viceKey = mzm.gsp.MergeMain.getViceZoneid();
/*    */     
/*    */ 
/* 17 */     lock(xdb.Lockeys.get(Petarenarank.getTable(), new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */     
/*    */ 
/* 20 */     PetArenaRank xMainPetArenaRank = Petarenarank.get(Long.valueOf(mainKey));
/* 21 */     if (xMainPetArenaRank != null)
/*    */     {
/* 23 */       xMainPetArenaRank.getMerged_roles().addAll(xMainPetArenaRank.getRoles().keySet());
/* 24 */       xMainPetArenaRank.getRanks().clear();
/* 25 */       xMainPetArenaRank.getRoles().clear();
/*    */     }
/* 27 */     PetArenaRank xVicePetArenaRank = Petarenarank.get(Long.valueOf(viceKey));
/* 28 */     if (xVicePetArenaRank != null)
/*    */     {
/* 30 */       if (xMainPetArenaRank == null)
/*    */       {
/* 32 */         xMainPetArenaRank = xbean.Pod.newPetArenaRank();
/* 33 */         Petarenarank.insert(Long.valueOf(mainKey), xMainPetArenaRank);
/*    */       }
/* 35 */       xMainPetArenaRank.getMerged_roles().addAll(xVicePetArenaRank.getRoles().keySet());
/* 36 */       Petarenarank.remove(Long.valueOf(viceKey));
/*    */     }
/*    */     
/*    */ 
/* 40 */     PetArenaRankBackup xVicePetArenaRankBackup = Petarenarankbackup.get(Long.valueOf(viceKey));
/* 41 */     if (xVicePetArenaRankBackup != null)
/*    */     {
/* 43 */       PetArenaRankBackup xMainPetArenaRankBackup = Petarenarankbackup.get(Long.valueOf(mainKey));
/* 44 */       if (xMainPetArenaRankBackup == null)
/*    */       {
/* 46 */         xMainPetArenaRankBackup = xbean.Pod.newPetArenaRankBackup();
/* 47 */         Petarenarankbackup.insert(Long.valueOf(mainKey), xMainPetArenaRankBackup);
/*    */       }
/* 49 */       xMainPetArenaRankBackup.getAwards().putAll(xVicePetArenaRankBackup.getAwards());
/* 50 */       xMainPetArenaRankBackup.getRole_ranks().putAll(xVicePetArenaRankBackup.getRole_ranks());
/*    */       
/* 52 */       Petarenarankbackup.remove(Long.valueOf(viceKey));
/*    */     }
/*    */     
/* 55 */     mzm.gsp.GameServer.logger().info("[petarena]PPetArenaMerge.processImp@handle success");
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PPetArenaMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */