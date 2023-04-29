/*     */ package mzm.gsp.sworn.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import xbean.SwornNewMember;
/*     */ import xbean.SwornNewName;
/*     */ 
/*     */ public class SwornVoteSession extends mzm.gsp.timer.main.Session
/*     */ {
/*     */   private final long overTime;
/*     */   private final int voteType;
/*     */   
/*     */   SwornVoteSession(long _swornid, long _time, long _overTime, int _type)
/*     */   {
/*  16 */     super(_time, _swornid);
/*  17 */     this.overTime = _overTime;
/*  18 */     this.voteType = _type;
/*     */   }
/*     */   
/*     */   protected void onTimeOut()
/*     */   {
/*  23 */     final long swornid = getOwerId();
/*     */     
/*  25 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  30 */         SwornManager.delSwornVoteSession(swornid);
/*  31 */         SwornManager.logInfo(String.format("SwornVoteSession timeout:id=%d", new Object[] { Long.valueOf(swornid) }), new Object[0]);
/*     */         
/*  33 */         xbean.Sworn sworn = xtable.Sworn.select(Long.valueOf(swornid));
/*  34 */         if (sworn == null) {
/*  35 */           return false;
/*     */         }
/*     */         
/*  38 */         List<Long> roleids = new java.util.ArrayList();
/*  39 */         roleids.addAll(sworn.getMembers());
/*  40 */         if ((SwornVoteSession.this.voteType == 1) && 
/*  41 */           (!sworn.getNewmember().isEmpty())) {
/*  42 */           SwornNewMember newMember = (SwornNewMember)((Map.Entry)sworn.getNewmember().entrySet().iterator().next()).getValue();
/*  43 */           long newMemberId = newMember.getNewmemberid();
/*  44 */           roleids.add(Long.valueOf(newMemberId));
/*     */         }
/*     */         
/*  47 */         if (SwornVoteSession.this.voteType == 2) {
/*  48 */           SwornNewName newName = sworn.getNewname();
/*  49 */           if ((newName.getRoleid() > 0L) && (!sworn.getMembers().contains(Long.valueOf(newName.getRoleid()))))
/*  50 */             roleids.add(Long.valueOf(newName.getRoleid()));
/*     */         }
/*  52 */         xdb.Lockeys.lock(xtable.Role2swornmember.getTable(), roleids);
/*     */         
/*     */ 
/*  55 */         xbean.Sworn sworn = xtable.Sworn.get(Long.valueOf(swornid));
/*     */         
/*  57 */         switch (SwornVoteSession.this.voteType) {
/*     */         case 1: 
/*  59 */           return SwornVoteSession.this.addNewMember(swornid, sworn);
/*     */         case 3: 
/*  61 */           return SwornVoteSession.this.kickout(swornid, sworn);
/*     */         case 2: 
/*  63 */           return SwornVoteSession.this.changeName(swornid, sworn);
/*     */         }
/*     */         
/*  66 */         return false;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private boolean addNewMember(long _swornid, xbean.Sworn _sworn) {
/*  72 */     if (_sworn.getNewmember().isEmpty()) {
/*  73 */       SwornManager.logInfo(String.format("SwornVoteSession addNewMember info not exsit,id=", new Object[] { Long.valueOf(_swornid) }), new Object[0]);
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     SwornNewMember newMemberInfo = (SwornNewMember)((Map.Entry)_sworn.getNewmember().entrySet().iterator().next()).getValue();
/*  78 */     if (newMemberInfo.getVerifytime() != this.overTime) {
/*  79 */       SwornManager.logInfo(String.format("SwornVoteSession addNewMember verifyTime error,id=", new Object[] { Long.valueOf(_swornid) }), new Object[0]);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     return SwornManager.addNewMember(_swornid, _sworn);
/*     */   }
/*     */   
/*     */   private boolean kickout(long _swornid, xbean.Sworn _sworn) {
/*  87 */     return SwornManager.kickOutSwornMemberOverTime(_swornid, _sworn);
/*     */   }
/*     */   
/*     */   private boolean changeName(long _swornid, xbean.Sworn _sworn) {
/*  91 */     SwornNewName newName = _sworn.getNewname();
/*  92 */     long verifyTime = newName.getVerifytime();
/*  93 */     if (verifyTime <= 0L) {
/*  94 */       SwornManager.logInfo(String.format("SwornVoteSession changeName info not exsit,id=", new Object[] { Long.valueOf(_swornid) }), new Object[0]);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     if (verifyTime != this.overTime) {
/*  99 */       SwornManager.logInfo(String.format("SwornVoteSession changeName verifyTime error,id=", new Object[] { Long.valueOf(_swornid) }), new Object[0]);
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     return SwornManager.changeSwornNewName(_swornid, _sworn);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\SwornVoteSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */