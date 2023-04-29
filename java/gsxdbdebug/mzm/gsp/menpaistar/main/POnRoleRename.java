/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.Campaign;
/*    */ import xbean.MenPaiStarCampaignInfo;
/*    */ 
/*    */ public class POnRoleRename extends mzm.gsp.role.event.RoleRenameProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleid = ((Long)this.arg).longValue();
/* 12 */     int ocpid = RoleInterface.getOccupationId(roleid);
/* 13 */     if (!CampaignChartManager.canJoin(ocpid))
/*    */     {
/* 15 */       return false;
/*    */     }
/*    */     
/* 18 */     MenPaiStarCampaignInfo xCampaignInfo = xtable.Role2menpaistarcampaign.get(Long.valueOf(roleid));
/* 19 */     if (xCampaignInfo == null)
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     Campaign xCampaign = (Campaign)xCampaignInfo.getCampaigns().get(Integer.valueOf(ocpid));
/* 25 */     if (xCampaign == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     if (xCampaign.getCampaign() != 1)
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     String name = RoleInterface.getName(roleid);
/* 35 */     RUpdateName task = new RUpdateName(roleid, ocpid, name);
/* 36 */     UpdateCampaignOneByOne.getInstance().add(ocpid, task);
/*    */     
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   private static class RUpdateName extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private final long roleid;
/*    */     private final int ocpid;
/*    */     private final String name;
/*    */     
/*    */     public RUpdateName(long roleid, int ocpid, String name)
/*    */     {
/* 49 */       this.roleid = roleid;
/* 50 */       this.ocpid = ocpid;
/* 51 */       this.name = name;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 57 */       if (!CampaignChartManager.canJoin(this.ocpid))
/*    */       {
/* 59 */         return;
/*    */       }
/*    */       
/* 62 */       CampaignChartObj chartObj = CampaignChartManager.getChartObjByRoleid(this.ocpid, this.roleid);
/* 63 */       if (chartObj == null)
/*    */       {
/* 65 */         return;
/*    */       }
/*    */       
/* 68 */       int point = chartObj.getPoint();
/* 69 */       long updatePointTime = chartObj.getUpdatePointTime();
/* 70 */       int award = chartObj.getAward();
/* 71 */       int num = chartObj.getNum();
/* 72 */       MenPaiStarManager.updateCampaignRank(this.roleid, this.name, this.ocpid, point, updatePointTime, award, num);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\POnRoleRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */