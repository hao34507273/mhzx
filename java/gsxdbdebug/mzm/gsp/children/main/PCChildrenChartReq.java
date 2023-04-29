/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.ChildrenChartData;
/*     */ import mzm.gsp.children.SChildrenChartRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildInfo;
/*     */ import xtable.Children;
/*     */ 
/*     */ public class PCChildrenChartReq extends LogicProcedure
/*     */ {
/*     */   private final int startPos;
/*     */   private final int endPos;
/*     */   private final long roleId;
/*     */   
/*     */   public PCChildrenChartReq(int startPos, int endPos, long roleId)
/*     */   {
/*  29 */     this.startPos = startPos;
/*  30 */     this.endPos = endPos;
/*  31 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */   {
/*  38 */     if ((this.startPos <= 0) || (this.endPos <= 0) || (this.startPos > this.endPos))
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1391, true))
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!isFunOpen(this.roleId))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     SChildrenChartRes sChildrenChartRes = new SChildrenChartRes();
/*  54 */     sChildrenChartRes.rank_list.addAll(getRankData(this.startPos - 1, this.endPos - 1));
/*  55 */     sChildrenChartRes.my_rank = (ChildrenManager.getBestChildRatingRank(this.roleId) + 1);
/*  56 */     sChildrenChartRes.my_rating = ChildrenManager.getBestChildRating(this.roleId);
/*     */     
/*  58 */     OnlineManager.getInstance().send(this.roleId, sChildrenChartRes);
/*     */     
/*  60 */     GameServer.logger().info(String.format("[children]PCChildrenChartReq.processImp@handle children rating chart req success|role_id=%d|start_pos=%d|end_pos=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.startPos), Integer.valueOf(this.endPos) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  65 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isFunOpen(long roleid)
/*     */   {
/*  76 */     if (!OpenInterface.getOpenStatus(354))
/*     */     {
/*  78 */       return false;
/*     */     }
/*  80 */     if (OpenInterface.isBanPlay(roleid, 354))
/*     */     {
/*  82 */       OpenInterface.sendBanPlayMsg(roleid, 354);
/*  83 */       return false;
/*     */     }
/*  85 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private List<ChildrenChartData> getRankData(int startPos, int endPos)
/*     */   {
/*  98 */     List<ChildrenChartData> res = new LinkedList();
/*  99 */     List<ChildrenRatingChart> childrenRatingChartList = ChildrenRatingRankManager.getInstance().getRankObjs(startPos, endPos);
/*     */     
/* 101 */     int startRank = startPos;
/* 102 */     for (ChildrenRatingChart childrenRatingChart : childrenRatingChartList)
/*     */     {
/* 104 */       long roleId = childrenRatingChart.getRoleid();
/* 105 */       long childId = childrenRatingChart.getChildId();
/* 106 */       Role xRole = RoleInterface.getRole(roleId, false);
/* 107 */       ChildInfo xChildInfo = Children.select(Long.valueOf(childId));
/*     */       
/* 109 */       ChildrenChartData childrenChartData = new ChildrenChartData();
/* 110 */       childrenChartData.rank = (++startRank);
/* 111 */       childrenChartData.child_id = childId;
/* 112 */       childrenChartData.role_id = roleId;
/* 113 */       Octets childNameOctets = new Octets();
/*     */       try
/*     */       {
/* 116 */         childNameOctets.setString(xChildInfo.getChild_name(), "UTF-8");
/*     */       }
/*     */       catch (UnsupportedEncodingException e)
/*     */       {
/* 120 */         GameServer.logger().error("[Children]PCChildrenChartReq.getRankData@transfer child name error", e);
/*     */       }
/* 122 */       childrenChartData.child_name = childNameOctets;
/* 123 */       Octets roleNameOctets = new Octets();
/*     */       try
/*     */       {
/* 126 */         roleNameOctets.setString(xRole.getName(), "UTF-8");
/*     */       }
/*     */       catch (UnsupportedEncodingException e)
/*     */       {
/* 130 */         GameServer.logger().error("[Children]PCChildrenChartReq.getRankData@transfer role name error", e);
/*     */       }
/* 132 */       childrenChartData.role_name = roleNameOctets;
/* 133 */       childrenChartData.rating = childrenRatingChart.getRating();
/* 134 */       res.add(childrenChartData);
/* 135 */       if (startRank > endPos) {
/*     */         break;
/*     */       }
/*     */     }
/*     */     
/* 140 */     return res;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCChildrenChartReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */