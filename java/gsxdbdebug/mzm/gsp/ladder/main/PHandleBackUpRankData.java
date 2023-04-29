/*     */ package mzm.gsp.ladder.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.LadderRankBackUp;
/*     */ import xbean.LadderRankRole;
/*     */ import xbean.Pod;
/*     */ import xtable.Ladderrank;
/*     */ import xtable.Ladderrankbackup;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PHandleBackUpRankData
/*     */   extends LogicProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/* 305 */     long viceZoneid = MergeMain.getViceZoneid();
/* 306 */     long mainZoneid = MergeMain.getMainZoneid();
/* 307 */     lock(Ladderrankbackup.getTable(), Arrays.asList(new Long[] { Long.valueOf(viceZoneid), Long.valueOf(mainZoneid) }));
/* 308 */     LadderRankBackUp xViceLadderRankBackUp = Ladderrankbackup.get(Long.valueOf(viceZoneid));
/* 309 */     if (xViceLadderRankBackUp == null) {
/* 310 */       return false;
/*     */     }
/* 312 */     LadderRankBackUp xMainLadderRankBackUp = Ladderrankbackup.get(Long.valueOf(mainZoneid));
/* 313 */     if (xMainLadderRankBackUp == null) {
/* 314 */       xMainLadderRankBackUp = Pod.newLadderRankBackUp();
/* 315 */       Ladderrankbackup.insert(Long.valueOf(mainZoneid), xMainLadderRankBackUp);
/*     */     }
/* 317 */     long mainBackUpTime = xMainLadderRankBackUp.getBackuptime();
/* 318 */     long subBackUpTime = xViceLadderRankBackUp.getBackuptime();
/* 319 */     if (mainBackUpTime == 0L) {
/* 320 */       xMainLadderRankBackUp.setBackuptime(subBackUpTime);
/*     */     }
/* 322 */     else if (mainBackUpTime > subBackUpTime) {
/* 323 */       xMainLadderRankBackUp.setBackuptime(subBackUpTime);
/*     */     }
/*     */     
/* 326 */     xMainLadderRankBackUp.getRemoteawardroles().addAll(xViceLadderRankBackUp.getRemoteawardroles());
/* 327 */     Iterator<LadderRankRole> rankIterator = xViceLadderRankBackUp.getRanklist().iterator();
/* 328 */     while (rankIterator.hasNext()) {
/* 329 */       LadderRankRole xLadderRankRole = (LadderRankRole)rankIterator.next();
/* 330 */       rankIterator.remove();
/* 331 */       xMainLadderRankBackUp.getRanklist().add(xLadderRankRole);
/*     */     }
/*     */     
/*     */ 
/* 335 */     Ladderrank.remove(Long.valueOf(viceZoneid));
/* 336 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PHandleBackUpRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */