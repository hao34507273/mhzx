/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SAutoBreedBabyRes;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BabyPeriodInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Children;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PAutoBreedBabyReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childid;
/*     */   private final long clientYuanBao;
/*     */   
/*     */   public PAutoBreedBabyReq(long roleid, long childid, long clientYuanBao)
/*     */   {
/*  40 */     this.roleid = roleid;
/*  41 */     this.childid = childid;
/*  42 */     this.clientYuanBao = clientYuanBao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleid))
/*     */     {
/*  50 */       ChildrenInterface.syncChildNormalFail(this.roleid, 21);
/*  51 */       GameServer.logger().error(String.format("PAutoBreedBabyReq.processImp@low level|roleid=%d|childid=%d|client_yuanbao=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Long.valueOf(this.clientYuanBao) }));
/*     */       
/*     */ 
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     if (!ChildrenManager.isFunOpen(this.roleid))
/*     */     {
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  63 */     if (!OpenInterface.getOpenStatus(524))
/*     */     {
/*  65 */       GameServer.logger().error(String.format("PAutoBreedBabyReq.processImp@auto breed not open|roleid=%d|childid=%d|client_yuanbao=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Long.valueOf(this.clientYuanBao) }));
/*     */       
/*     */ 
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     if (!ChildrenManager.canDoAction(this.roleid, 844))
/*     */     {
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  79 */     long yuanbao = QingfuInterface.getBalance(userid, true);
/*  80 */     if (this.clientYuanBao != yuanbao)
/*     */     {
/*  82 */       ChildrenInterface.syncChildNormalFail(this.roleid, 63);
/*  83 */       GameServer.logger().error(String.format("PAutoBreedBabyReq.processImp@child not exist|roleid=%d|childid=%d|client_yuanbao=%d|server_yuanbao=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Long.valueOf(this.clientYuanBao), Long.valueOf(yuanbao) }));
/*     */       
/*     */ 
/*     */ 
/*  87 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  91 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*     */ 
/*  94 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childid));
/*  95 */     if (xChildInfo == null)
/*     */     {
/*  97 */       ChildrenInterface.syncChildNormalFail(this.roleid, 2);
/*  98 */       GameServer.logger().error(String.format("PAutoBreedBabyReq.processImp@child not exist|roleid=%d|childid=%d|client_yuanbao=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Long.valueOf(this.clientYuanBao) }));
/*     */       
/*     */ 
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleid, xChildInfo))
/*     */     {
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     if ((xChildInfo.getOwn_role_id() != this.roleid) && (xChildInfo.getAnother_parent_role_id() != this.roleid))
/*     */     {
/* 111 */       ChildrenInterface.syncChildNormalFail(this.roleid, 1);
/* 112 */       GameServer.logger().error(String.format("PAutoBreedBabyReq.processImp@not contain child|roleid=%d|childid=%d|client_yuanbao=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Long.valueOf(this.clientYuanBao) }));
/*     */       
/*     */ 
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     BabyPeriodInfo xBabyPeriodInfo = xChildInfo.getBaby_period_info();
/* 119 */     if (xBabyPeriodInfo.getAuto_breed())
/*     */     {
/*     */ 
/* 122 */       ChildrenInterface.syncChildNormalFail(this.roleid, 64);
/* 123 */       GameServer.logger().error(String.format("PAutoBreedBabyReq.processImp@already auto breed|roleid=%d|childid=%d|client_yuanbao=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Long.valueOf(this.clientYuanBao) }));
/*     */       
/*     */ 
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 130 */     int healthValue = ChildrenManager.refreshAndGetHealthValue(this.roleid, this.childid, xBabyPeriodInfo, now);
/* 131 */     int leftHealthValue = SChildrenConsts.getInstance().baby_to_childhood_need_health_value - healthValue;
/* 132 */     if (leftHealthValue <= 0)
/*     */     {
/*     */ 
/* 135 */       ChildrenInterface.syncChildNormalFail(this.roleid, 62);
/* 136 */       GameServer.logger().error(String.format("PAutoBreedBabyReq.processImp@no need|roleid=%d|childid=%d|client_yuanbao=%d|health_value=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Long.valueOf(this.clientYuanBao), Integer.valueOf(healthValue) }));
/*     */       
/*     */ 
/*     */ 
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     int costYuanbao = leftHealthValue * SChildrenConsts.getInstance().auto_breed_cost_yuanbao_per_health_point;
/* 144 */     if (costYuanbao <= 0)
/*     */     {
/* 146 */       GameServer.logger().error(String.format("PAutoBreedBabyReq.processImp@invalid cost yuanbao|roleid=%d|childid=%d|client_yuanbao=%d|cost_yuanbao=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Long.valueOf(this.clientYuanBao), Integer.valueOf(costYuanbao) }));
/*     */       
/*     */ 
/*     */ 
/* 150 */       return false;
/*     */     }
/*     */     
/* 153 */     if (yuanbao < costYuanbao)
/*     */     {
/* 155 */       ChildrenInterface.syncChildNormalFail(this.roleid, 61);
/* 156 */       GameServer.logger().error(String.format("PAutoBreedBabyReq.processImp@invalid cost yuanbao|roleid=%d|childid=%d|client_yuanbao=%d|cost_yuanbao=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Long.valueOf(this.clientYuanBao), Integer.valueOf(costYuanbao) }));
/*     */       
/*     */ 
/*     */ 
/* 160 */       return false;
/*     */     }
/*     */     
/* 163 */     TLogArg tLogArg = new TLogArg(LogReason.CHILDREN_AUTO_BREED);
/* 164 */     CostResult costResult = QingfuInterface.costYuanbao(userid, this.roleid, costYuanbao, CostType.COST_CHILDREN_AUTO_BREED, tLogArg);
/*     */     
/* 166 */     if (!costResult.equals(CostResult.Success))
/*     */     {
/* 168 */       ChildrenInterface.syncChildNormalFail(this.roleid, 61);
/* 169 */       GameServer.logger().error(String.format("PAutoBreedBabyReq.processImp@cost yuanbao failed|roleid=%d|childid=%d|client_yuanbao=%d|code=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Long.valueOf(this.clientYuanBao), Integer.valueOf(costResult.code) }));
/*     */       
/*     */ 
/*     */ 
/* 173 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 177 */     xBabyPeriodInfo.setAuto_breed(true);
/* 178 */     xBabyPeriodInfo.getBaby_property_info_map().put(Integer.valueOf(0), Integer.valueOf(SChildrenConsts.getInstance().baby_auto_bao_shi_value));
/*     */     
/* 180 */     xBabyPeriodInfo.getBaby_property_info_map().put(Integer.valueOf(2), Integer.valueOf(SChildrenConsts.getInstance().baby_auto_clean_value));
/*     */     
/* 182 */     xBabyPeriodInfo.getBaby_property_info_map().put(Integer.valueOf(1), Integer.valueOf(SChildrenConsts.getInstance().baby_auto_mood_value));
/*     */     
/* 184 */     xBabyPeriodInfo.getBaby_property_info_map().put(Integer.valueOf(3), Integer.valueOf(SChildrenConsts.getInstance().baby_auto_tired_value));
/*     */     
/*     */ 
/* 187 */     SAutoBreedBabyRes res = new SAutoBreedBabyRes();
/* 188 */     res.childid = this.childid;
/*     */     
/* 190 */     List<Long> parents = new ArrayList();
/* 191 */     parents.add(Long.valueOf(xChildInfo.getOwn_role_id()));
/*     */     
/* 193 */     long anotherParent = xChildInfo.getAnother_parent_role_id();
/* 194 */     if (anotherParent != -1L)
/*     */     {
/* 196 */       parents.add(Long.valueOf(anotherParent));
/*     */     }
/* 198 */     OnlineManager.getInstance().sendMulti(res, parents);
/*     */     
/*     */ 
/* 201 */     ChildrenManager.cancelBreedChildObserver(this.childid);
/*     */     
/*     */ 
/* 204 */     ChildrenInterface.fillChildGrowthDiary(this.childid, null, null, 4);
/*     */     
/*     */ 
/*     */ 
/* 208 */     int level = RoleInterface.getLevel(this.roleid);
/* 209 */     ChildrenManager.tlogBabyAutoBreed(userid, this.roleid, level, this.childid, healthValue);
/*     */     
/* 211 */     GameServer.logger().info(String.format("PAutoBreedBabyReq.processImp@succeed|roleid=%d|health_value=%d|cost_yuanbao=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(healthValue), Integer.valueOf(costYuanbao) }));
/*     */     
/*     */ 
/*     */ 
/* 215 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PAutoBreedBabyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */