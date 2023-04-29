/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.paraselene.confbean.SParaseleneActivitySeq;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.Paraselene;
/*    */ import xtable.Role2paraselene;
/*    */ 
/*    */ public class Pgm_Transferto extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int layer;
/*    */   
/*    */   public Pgm_Transferto(long roleid, int layer)
/*    */   {
/* 18 */     this.roleId = roleid;
/* 19 */     this.layer = layer;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     Long teamid = TeamInterface.getTeamidByRoleid(this.roleId, false);
/* 27 */     if (teamid == null)
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     if (!ParaseleneManager.checkTeam(this.roleId, teamid.longValue()))
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     SParaseleneActivitySeq seq = ParaseleneManager.getParaseleneActivityBylayer(this.layer);
/* 38 */     if (seq == null)
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     long worldid = ParaseleneManager.getWorldidByteamid(teamid.longValue());
/* 43 */     for (Iterator i$ = TeamInterface.getNormalRoleList(this.roleId).iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*    */       
/*    */ 
/* 46 */       Paraselene paraselene = ParaseleneManager.getParaselene(r, true);
/* 47 */       if (paraselene == null)
/*    */       {
/* 49 */         paraselene = xbean.Pod.newParaselene();
/*    */         
/* 51 */         Role2paraselene.insert(Long.valueOf(r), paraselene);
/*    */       }
/* 53 */       if (paraselene.getLayers().isEmpty())
/*    */       {
/* 55 */         paraselene.setStarttime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*    */       }
/* 57 */       for (int i = 1; i < this.layer; i++)
/*    */       {
/* 59 */         if (!paraselene.getLayers().contains(Integer.valueOf(i)))
/*    */         {
/* 61 */           paraselene.getLayers().add(Integer.valueOf(i));
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 68 */     MapInterface.transferToScene(TeamInterface.getTeamLeaderByRoleid(this.roleId, true, true), worldid, seq.mapid);
/*    */     
/* 70 */     mzm.gsp.status.main.RoleStatusInterface.setStatus(TeamInterface.getNormalRoleList(this.roleId), 12, false);
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\Pgm_Transferto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */