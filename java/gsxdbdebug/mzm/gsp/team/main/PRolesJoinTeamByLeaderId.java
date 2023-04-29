/*     */ package mzm.gsp.team.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.confbean.STeamPlatformMomCfg;
/*     */ import mzm.gsp.team.confbean.TeamConsts;
/*     */ import mzm.gsp.teamplatform.match.MJoinTeamOnNewGuy;
/*     */ import mzm.gsp.teamplatform.match.TeamMatchInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PRolesJoinTeamByLeaderId
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long leaderId;
/*     */   private final List<Long> members;
/*     */   private final int matchCfgId;
/*     */   
/*     */   public PRolesJoinTeamByLeaderId(long leaderId, List<Long> members, int matchCfgId)
/*     */   {
/*  30 */     this.leaderId = leaderId;
/*  31 */     this.members = members;
/*  32 */     this.matchCfgId = matchCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     Xdb.executor().execute(new LogicRunnable()
/*     */     {
/*     */       public void process()
/*     */         throws Exception
/*     */       {
/*  44 */         PRolesJoinTeamByLeaderId.OccupationFrist p = new PRolesJoinTeamByLeaderId.OccupationFrist(PRolesJoinTeamByLeaderId.this, PRolesJoinTeamByLeaderId.this.leaderId, PRolesJoinTeamByLeaderId.this.members, PRolesJoinTeamByLeaderId.this.matchCfgId);
/*  45 */         if (!p.call())
/*     */         {
/*  47 */           return;
/*     */         }
/*  49 */         List<Long> fristMembers = p.fristList;
/*  50 */         List<Long> normalMebers = p.normalList;
/*  51 */         int realNeedNum = p.realNeedNum;
/*  52 */         if (fristMembers.size() > 0)
/*     */         {
/*  54 */           int num = 0;
/*  55 */           Iterator<Long> it = fristMembers.iterator();
/*  56 */           while (it.hasNext())
/*     */           {
/*  58 */             long member = ((Long)it.next()).longValue();
/*  59 */             if (num >= realNeedNum) {
/*     */               break;
/*     */             }
/*     */             
/*  63 */             PJoinTeamByLeaderId pJoinTeamByLeaderId = new PJoinTeamByLeaderId(member, PRolesJoinTeamByLeaderId.this.leaderId, MJoinTeamOnNewGuy.getInstance());
/*     */             
/*  65 */             boolean res = pJoinTeamByLeaderId.call();
/*  66 */             if (!res)
/*     */             {
/*  68 */               switch (pJoinTeamByLeaderId.result)
/*     */               {
/*     */               case 1: 
/*     */               case 2: 
/*     */               case 3: 
/*  73 */                 return;
/*     */               
/*     */               case 0: 
/*     */               case 4: 
/*  77 */                 it.remove();
/*  78 */                 break;
/*     */               
/*     */               default: 
/*  81 */                 it.remove();
/*  82 */                 break;
/*     */               }
/*     */             }
/*     */             else
/*     */             {
/*  87 */               switch (pJoinTeamByLeaderId.result)
/*     */               {
/*     */               case 5: 
/*  90 */                 return;
/*     */               }
/*     */               
/*  93 */               num++;
/*  94 */               it.remove();
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 102 */         if (fristMembers.size() > 0)
/*     */         {
/* 104 */           normalMebers.addAll(fristMembers);
/*     */         }
/* 106 */         for (Iterator i$ = normalMebers.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*     */           
/* 108 */           PJoinTeamByLeaderId pJoinTeamByLeaderId = new PJoinTeamByLeaderId(member, PRolesJoinTeamByLeaderId.this.leaderId, MJoinTeamOnNewGuy.getInstance());
/*     */           
/* 110 */           boolean res = pJoinTeamByLeaderId.call();
/* 111 */           if (!res)
/*     */           {
/* 113 */             switch (pJoinTeamByLeaderId.result)
/*     */             {
/*     */             case 1: 
/*     */             case 2: 
/*     */             case 3: 
/*     */               return;
/*     */             
/*     */ 
/*     */             case 0: 
/*     */             case 4: 
/*     */               break;
/*     */             
/*     */ 
/*     */ 
/*     */             }
/*     */             
/*     */           } else {
/* 130 */             switch (pJoinTeamByLeaderId.result)
/*     */             {
/*     */             case 5: 
/* 133 */               return;
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*     */             }
/*     */             
/*     */           }
/*     */         }
/*     */       }
/* 143 */     });
/* 144 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   class OccupationFrist
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final List<Long> roles;
/*     */     
/*     */     private final long leaderId;
/*     */     
/*     */     private final int matchId;
/*     */     
/*     */     public int realNeedNum;
/*     */     
/*     */     public List<Long> fristList;
/*     */     
/*     */     public List<Long> normalList;
/*     */     
/*     */ 
/*     */     public OccupationFrist(List<Long> arg3, int roles)
/*     */     {
/* 166 */       this.leaderId = leaderId;
/* 167 */       this.roles = roles;
/* 168 */       this.matchId = matchId;
/* 169 */       this.fristList = new ArrayList();
/* 170 */       this.normalList = new ArrayList();
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 176 */       STeamPlatformMomCfg cfg = TeamMatchInterface.getMatchCfg(this.matchId);
/* 177 */       int needNum = cfg.occupationFristCount;
/* 178 */       List<Integer> fristOcc = cfg.occupationFristList;
/* 179 */       if ((fristOcc == null) || (fristOcc.size() == 0) || (needNum <= 0))
/*     */       {
/* 181 */         this.normalList.addAll(this.roles);
/* 182 */         return true;
/*     */       }
/* 184 */       TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.leaderId);
/* 185 */       if (teamInfo == null)
/*     */       {
/* 187 */         return false;
/*     */       }
/*     */       
/* 190 */       if (!teamInfo.isLeader(this.leaderId))
/*     */       {
/* 192 */         return false;
/*     */       }
/*     */       
/* 195 */       List<Long> memberList = teamInfo.getTeamMemberList();
/* 196 */       if (memberList.size() >= TeamConsts.getInstance().TEAM_CAPACITY)
/*     */       {
/* 198 */         return false;
/*     */       }
/*     */       
/* 201 */       for (Iterator i$ = this.roles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 203 */         int roleOccupation = RoleInterface.getOccupationId(roleId);
/* 204 */         if (!fristOcc.contains(Integer.valueOf(roleOccupation)))
/*     */         {
/* 206 */           this.normalList.add(Long.valueOf(roleId));
/*     */         }
/*     */         else
/*     */         {
/* 210 */           this.fristList.add(Long.valueOf(roleId));
/*     */         }
/*     */       }
/*     */       
/* 214 */       int ownNum = 0;
/* 215 */       for (Iterator i$ = memberList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 217 */         int occ = RoleInterface.getOccupationId(roleId);
/* 218 */         if (fristOcc.contains(Integer.valueOf(occ)))
/*     */         {
/* 220 */           ownNum++;
/*     */         }
/*     */       }
/* 223 */       if (ownNum >= needNum)
/*     */       {
/* 225 */         this.normalList.addAll(this.fristList);
/* 226 */         this.fristList.clear();
/* 227 */         this.realNeedNum = 0;
/* 228 */         return true;
/*     */       }
/* 230 */       this.realNeedNum = (needNum - ownNum);
/*     */       
/* 232 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PRolesJoinTeamByLeaderId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */