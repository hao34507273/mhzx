/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.item.GiveFlowerPointRankData;
/*    */ import mzm.gsp.item.SGetGiveFlowerPointRankRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.Role;
/*    */ 
/*    */ public class PGetGiveFlowerRank extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int startpos;
/*    */   private int num;
/*    */   
/*    */   public PGetGiveFlowerRank(long roleid, int startpos, int num)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.startpos = startpos;
/* 19 */     this.num = num;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 24 */     java.util.List<RoleGiveFlowerChart> giveFlowerCharts = ItemGiveManager.getGiveFlowerRankData(this.startpos, this.num);
/* 25 */     SGetGiveFlowerPointRankRes res = new SGetGiveFlowerPointRankRes();
/* 26 */     int i = this.startpos;
/* 27 */     for (RoleGiveFlowerChart r : giveFlowerCharts) {
/* 28 */       GiveFlowerPointRankData d = new GiveFlowerPointRankData();
/* 29 */       Role role = mzm.gsp.role.main.RoleInterface.getRole(r.getKey().longValue(), false);
/* 30 */       d.name = role.getName();
/* 31 */       d.occupationid = role.getOccupationId();
/* 32 */       d.point = r.getGivePoint();
/* 33 */       d.roleid = r.getKey().longValue();
/*    */       
/* 35 */       d.no = (i++);
/* 36 */       res.ranklist.add(d);
/*    */     }
/* 38 */     res.mypoint = ItemGiveManager.getGiveFlowerPoint(this.roleid);
/* 39 */     res.myrank = ItemGiveManager.getGiveFlowerRank(this.roleid);
/* 40 */     OnlineManager.getInstance().send(this.roleid, res);
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGetGiveFlowerRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */