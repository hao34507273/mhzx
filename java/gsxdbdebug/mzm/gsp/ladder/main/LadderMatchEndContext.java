/*     */ package mzm.gsp.ladder.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import hub.ExchangeDataHandlerInfo;
/*     */ import hub.FightResult;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LadderMatchEndContext
/*     */ {
/*  20 */   public final List<LadderMatchEnd> matchEndList = new ArrayList();
/*     */   
/*     */   public final int winOrLose;
/*     */   
/*     */   public final FightResult fightResult;
/*     */   
/*  26 */   private final Set<Long> allOnlineRoles = new HashSet();
/*     */   
/*     */   public void addOnlineRole(long roleid) {
/*  29 */     this.allOnlineRoles.add(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */   public boolean isAllOnline() {
/*  33 */     return this.allOnlineRoles.containsAll(getAllRoleList());
/*     */   }
/*     */   
/*     */   public LadderMatchEndContext(int winOrLose, FightResult fightResult) {
/*  37 */     this.winOrLose = winOrLose;
/*  38 */     this.fightResult = fightResult;
/*     */   }
/*     */   
/*     */   public List<Long> getAllRoleList() {
/*  42 */     List<Long> allRoleList = new ArrayList();
/*  43 */     for (LadderMatchEnd ladderMatchEnd : this.matchEndList) {
/*  44 */       allRoleList.add(Long.valueOf(ladderMatchEnd.roleid));
/*     */     }
/*  46 */     return allRoleList;
/*     */   }
/*     */   
/*     */   public List<String> getAllUserList() {
/*  50 */     List<String> allUsers = new ArrayList();
/*  51 */     for (LadderMatchEnd ladderMatchEnd : this.matchEndList) {
/*  52 */       allUsers.add(ladderMatchEnd.userid);
/*     */     }
/*  54 */     return allUsers;
/*     */   }
/*     */   
/*     */   public Map<Long, String> getRole2UserMap() {
/*  58 */     Map<Long, String> role2User = new HashMap();
/*  59 */     for (LadderMatchEnd ladderMatchEnd : this.matchEndList) {
/*  60 */       role2User.put(Long.valueOf(ladderMatchEnd.roleid), ladderMatchEnd.userid);
/*     */     }
/*  62 */     return role2User;
/*     */   }
/*     */   
/*     */   public long getLeaderid() {
/*  66 */     Iterator i$ = this.matchEndList.iterator(); if (i$.hasNext()) { LadderMatchEnd ladderMatchEnd = (LadderMatchEnd)i$.next();
/*  67 */       return ladderMatchEnd.roleid;
/*     */     }
/*  69 */     return -1L;
/*     */   }
/*     */   
/*     */ 
/*     */   public static class LadderMatchEnd
/*     */   {
/*     */     public final String userid;
/*     */     
/*     */     public final long roleid;
/*     */     
/*     */     public final int changeMatchScore;
/*     */     
/*     */     public final long ladderScore;
/*     */     public final Octets token;
/*     */     public final List<Long> petids;
/*     */     public final Map<Long, Integer> childrenLostChaMap;
/*     */     public final ExchangeDataHandlerInfo exchangeDataHandlerInfo;
/*     */     
/*     */     public LadderMatchEnd(String userid, long roleid, int changeMatchScore, long ladderScore, Octets token, List<Long> petids, Map<Long, Integer> childrenLostChaMap, ExchangeDataHandlerInfo exchangeDataHandlerInfo)
/*     */     {
/*  89 */       this.userid = userid;
/*  90 */       this.roleid = roleid;
/*  91 */       this.changeMatchScore = changeMatchScore;
/*  92 */       this.ladderScore = ladderScore;
/*  93 */       if (token == null) {
/*  94 */         this.token = new Octets();
/*     */       } else {
/*  96 */         this.token = token;
/*     */       }
/*  98 */       this.petids = petids;
/*  99 */       this.childrenLostChaMap = childrenLostChaMap;
/* 100 */       this.exchangeDataHandlerInfo = exchangeDataHandlerInfo;
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/* 105 */       StringBuilder stringBuilder = new StringBuilder();
/* 106 */       stringBuilder.append("userid=").append(this.userid).append(":").append("roleid=").append(this.roleid).append(":").append("changeMatchScore=").append(this.changeMatchScore).append(":").append("changeMatchToken=").append(this.ladderScore).append(":").append("token=").append(this.token.getString("UTF-8")).append(":").append("petids=").append(this.petids).append("handler_info_sn=").append(this.exchangeDataHandlerInfo == null ? 0L : this.exchangeDataHandlerInfo.sn);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 111 */       return super.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 118 */     StringBuilder stringBuilder = new StringBuilder();
/* 119 */     for (LadderMatchEnd ladderMatchEnd : this.matchEndList) {
/* 120 */       stringBuilder.append(ladderMatchEnd.toString()).append(",");
/*     */     }
/* 122 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public boolean isWin() {
/* 126 */     if (this.winOrLose == 0)
/* 127 */       return true;
/* 128 */     if (this.winOrLose == 1) {
/* 129 */       return false;
/*     */     }
/* 131 */     GameServer.logger().error(String.format("[Ladder]LadderMatchEndContext.isWin@ladder end error,win enum|enum=%d", new Object[] { Integer.valueOf(this.winOrLose) }));
/*     */     
/*     */ 
/* 134 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\LadderMatchEndContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */