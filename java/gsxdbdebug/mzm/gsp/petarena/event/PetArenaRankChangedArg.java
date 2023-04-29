/*    */ package mzm.gsp.petarena.event;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.petarena.main.PetArenaFightInfo;
/*    */ import mzm.gsp.petarena.main.PetArenaFightResultContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PetArenaRankChangedArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final long opponentRoleid;
/*    */   public final boolean win;
/*    */   public final int type;
/*    */   public final int oldRank;
/*    */   public final int newRank;
/*    */   public final boolean changed;
/*    */   public final boolean send;
/*    */   public final List<PetArenaFightInfo> activeInfos;
/*    */   public final List<PetArenaFightInfo> passiveInfos;
/*    */   public final PetArenaFightResultContext resultContext;
/*    */   
/*    */   public PetArenaRankChangedArg(long roleid, long opponentRoleid, boolean win, int type, int oldRank, int newRank, boolean changed, boolean send, List<PetArenaFightInfo> activeInfos, List<PetArenaFightInfo> passiveInfos, PetArenaFightResultContext resultContext)
/*    */   {
/* 27 */     this.roleid = roleid;
/* 28 */     this.opponentRoleid = opponentRoleid;
/* 29 */     this.win = win;
/* 30 */     this.type = type;
/* 31 */     this.oldRank = oldRank;
/* 32 */     this.newRank = newRank;
/* 33 */     this.changed = changed;
/* 34 */     this.send = send;
/* 35 */     this.activeInfos = activeInfos;
/* 36 */     this.passiveInfos = passiveInfos;
/* 37 */     this.resultContext = resultContext;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\event\PetArenaRankChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */