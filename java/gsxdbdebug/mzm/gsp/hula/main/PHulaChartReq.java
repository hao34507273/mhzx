/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.hula.HulaRankData;
/*    */ import mzm.gsp.hula.SHulaChartRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class PHulaChartReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int startPos;
/*    */   private final int num;
/*    */   
/*    */   public PHulaChartReq(long roleid, int startPos, int num)
/*    */   {
/* 24 */     this.roleid = roleid;
/* 25 */     this.startPos = startPos;
/* 26 */     this.num = num;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     if ((this.startPos <= 0) || (this.num <= 0))
/*    */     {
/*    */ 
/* 35 */       HulaManager.logger.info(String.format("[hula]PHulaChartReq.processImp@parameter error|roleid=%d|start_pos=%d|num=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.startPos), Integer.valueOf(this.num) }));
/*    */       
/*    */ 
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if (!HulaManager.isHulaSwitchOpenForRole(this.roleid))
/*    */     {
/*    */ 
/* 44 */       HulaManager.logger.info(String.format("[hula]PHulaChartReq.processImp@module close or role forbidden|roleid=%d|start_pos=%d|num=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.startPos), Integer.valueOf(this.num) }));
/*    */       
/*    */ 
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 451, true))
/*    */     {
/*    */ 
/* 53 */       HulaManager.logger.info(String.format("[hula]PHulaChartReq.processImp@role status error|roleid=%d|start_pos=%d|num=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.startPos), Integer.valueOf(this.num) }));
/*    */       
/*    */ 
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     List<HulaChartObj> hulaChartObjs = HulaChart.getInstance().getRankObjs(this.startPos - 1, this.startPos - 1 + this.num - 1);
/*    */     
/* 61 */     SHulaChartRes protocol = new SHulaChartRes();
/*    */     
/* 63 */     protocol.point = HulaManager.getRolePoint(this.roleid);
/* 64 */     protocol.myrank = (HulaChart.getInstance().getRank(Long.valueOf(this.roleid)) + 1);
/* 65 */     for (int i = 0; i < hulaChartObjs.size(); i++)
/*    */     {
/* 67 */       HulaChartObj hulaChartObj = (HulaChartObj)hulaChartObjs.get(i);
/* 68 */       HulaRankData hulaRankData = new HulaRankData();
/* 69 */       hulaRankData.rank = (this.startPos + i);
/* 70 */       hulaRankData.roleid = hulaChartObj.getKey().longValue();
/*    */       
/* 72 */       hulaRankData.name.setString(RoleInterface.getName(hulaRankData.roleid), "UTF-8");
/* 73 */       hulaRankData.occupationid = RoleInterface.getOccupationId(hulaRankData.roleid);
/* 74 */       hulaRankData.point = hulaChartObj.getScore();
/* 75 */       protocol.ranklist.add(hulaRankData);
/*    */     }
/* 77 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*    */     
/* 79 */     HulaManager.logger.info(String.format("[hula]PHulaChartReq.processImp@get hula rank success|roleid=%d|start_pos=%d|num=%s|point=%d|myrank=%d|resultnum=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.startPos), Integer.valueOf(this.num), Integer.valueOf(protocol.point), Integer.valueOf(protocol.myrank), Integer.valueOf(protocol.ranklist.size()) }));
/*    */     
/*    */ 
/* 82 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\PHulaChartReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */