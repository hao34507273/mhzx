/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.item.ReceiveFlowerPointRankData;
/*    */ import mzm.gsp.item.SGetReceiveFlowerPointRankRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.Role;
/*    */ 
/*    */ public class PGetReceiveFlowerRank extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int startpos;
/*    */   private int num;
/*    */   
/*    */   public PGetReceiveFlowerRank(long roleid, int startpos, int num)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.startpos = startpos;
/* 19 */     this.num = num;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 24 */     java.util.List<RoleReceiveFlowerChart> receiveFlowerCharts = ItemGiveManager.getReceiveFlowerRankData(this.startpos, this.num);
/* 25 */     SGetReceiveFlowerPointRankRes res = new SGetReceiveFlowerPointRankRes();
/* 26 */     int i = this.startpos;
/* 27 */     for (RoleReceiveFlowerChart r : receiveFlowerCharts) {
/* 28 */       ReceiveFlowerPointRankData d = new ReceiveFlowerPointRankData();
/* 29 */       Role role = mzm.gsp.role.main.RoleInterface.getRole(r.getKey().longValue(), false);
/* 30 */       d.name = role.getName();
/* 31 */       d.occupationid = role.getOccupationId();
/* 32 */       d.point = r.getReceivePoint();
/* 33 */       d.roleid = r.getKey().longValue();
/*    */       
/* 35 */       d.no = (i++);
/* 36 */       res.ranklist.add(d);
/*    */     }
/* 38 */     res.mypoint = ItemGiveManager.getReceiveFlowerPoint(this.roleid);
/* 39 */     res.myrank = ItemGiveManager.getReceiveFlowerRank(this.roleid);
/* 40 */     OnlineManager.getInstance().send(this.roleid, res);
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGetReceiveFlowerRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */