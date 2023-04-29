/*     */ package mzm.gsp.role.multirank;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.RoleMFVRankData;
/*     */ import mzm.gsp.role.SGetOccupationMFVRankRes;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGetOccupationMFVRankReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int fromNo;
/*     */   private final int toNo;
/*     */   private final int occupationId;
/*     */   
/*     */   public PGetOccupationMFVRankReq(long roleid, int fromNo, int toNo, int occupationId)
/*     */   {
/*  28 */     this.roleid = roleid;
/*  29 */     this.fromNo = fromNo;
/*  30 */     this.toNo = toNo;
/*  31 */     this.occupationId = occupationId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!MultiRankManager.isOccMFVOpen())
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     if (this.fromNo <= 0)
/*     */     {
/*  44 */       return false;
/*     */     }
/*  46 */     if (this.fromNo > this.toNo)
/*     */     {
/*  48 */       return false;
/*     */     }
/*  50 */     SGetOccupationMFVRankRes p = new SGetOccupationMFVRankRes();
/*  51 */     if (!fillProRankList(p.ranklist))
/*     */     {
/*  53 */       GameServer.logger().error(String.format("[MFV]PGetOccupationMFVRankReq.processImp@fillProRankList err!|roleId=%d|occupationId=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.occupationId) }));
/*     */       
/*     */ 
/*  56 */       return false;
/*     */     }
/*  58 */     p.myno = getRoleRank();
/*  59 */     p.myvalue = MultiRankManager.getRoleMFValue(this.roleid);
/*  60 */     p.occupationid = this.occupationId;
/*  61 */     OnlineManager.getInstance().send(this.roleid, p);
/*  62 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean fillProRankList(List<RoleMFVRankData> pRankList)
/*     */   {
/*  73 */     AbsNRealOMFVRankManager noneRealRankManager = AbsNRealOMFVRankManager.getNOMFVRankManagerByOccId(this.occupationId);
/*  74 */     if (noneRealRankManager == null)
/*     */     {
/*  76 */       GameServer.logger().error(String.format("[MFV]PGetOccupationMFVRankReq.processImp@ no rankManager!|occupationId=%d", new Object[] { Integer.valueOf(this.occupationId) }));
/*     */       
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     List<RoleMultiFightValueChart> roleMFVCharts = noneRealRankManager.getRankObjs(this.fromNo - 1, this.toNo - 1);
/*  82 */     Map<Long, Integer> rankChangeMap = noneRealRankManager.getCacheRankChangeMap();
/*  83 */     MultiRankManager.fillProRankList(this.fromNo, roleMFVCharts, rankChangeMap, pRankList);
/*  84 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getRoleRank()
/*     */   {
/*  94 */     int roleOccId = RoleInterface.getOccupationId(this.roleid);
/*  95 */     AbsNRealOMFVRankManager roleRankManager = AbsNRealOMFVRankManager.getNOMFVRankManagerByOccId(roleOccId);
/*  96 */     if (roleRankManager == null)
/*     */     {
/*  98 */       GameServer.logger().error(String.format("[MFV]PGetOccupationMFVRankReq.processImp@ no role rankManager!|occupationId=%d", new Object[] { Integer.valueOf(roleOccId) }));
/*     */       
/* 100 */       return 0;
/*     */     }
/* 102 */     return roleRankManager.getRank(Long.valueOf(this.roleid)) + 1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\PGetOccupationMFVRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */