/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SBreedBabyChildEnd;
/*     */ import mzm.gsp.children.confbean.SBabyOperatorCfg;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BabyPeriodInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Children;
/*     */ import xtable.User;
/*     */ 
/*     */ public class BabyPeriodBreedObserver extends MilliObserver
/*     */ {
/*     */   private final long roleId;
/*     */   private final long childId;
/*     */   private final int operator;
/*     */   private final long babyPeriodOperatorStartTime;
/*     */   
/*     */   public BabyPeriodBreedObserver(long intervalMilliSeconds, long roleId, long childId, int operator, long babyPeriodOperatorStartTime)
/*     */   {
/*  30 */     super(intervalMilliSeconds);
/*  31 */     this.roleId = roleId;
/*  32 */     this.childId = childId;
/*  33 */     this.operator = operator;
/*  34 */     this.babyPeriodOperatorStartTime = babyPeriodOperatorStartTime;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  40 */     new PBabyPeriodBreedObserver(this.roleId, this.childId, this.operator, this.babyPeriodOperatorStartTime).execute();
/*  41 */     return false;
/*     */   }
/*     */   
/*     */   private static class PBabyPeriodBreedObserver
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final long childId;
/*     */     private final int operator;
/*     */     private final long babyPeriodOperatorStartTime;
/*     */     
/*     */     public PBabyPeriodBreedObserver(long roleId, long childId, int operator, long babyPeriodOperatorStartTime)
/*     */     {
/*  54 */       this.roleId = roleId;
/*  55 */       this.childId = childId;
/*  56 */       this.operator = operator;
/*  57 */       this.babyPeriodOperatorStartTime = babyPeriodOperatorStartTime;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  63 */       long marriedRoleId = MarriageInterface.getMarriedRoleid(this.roleId, false);
/*     */       
/*     */ 
/*  66 */       String userId = RoleInterface.getUserId(this.roleId);
/*  67 */       lock(Lockeys.get(User.getTable(), userId));
/*  68 */       lock(Lockeys.get(xtable.Role2properties.getTable(), Long.valueOf(this.roleId)));
/*     */       
/*     */ 
/*  71 */       ChildInfo xChildInfo = Children.get(Long.valueOf(this.childId));
/*  72 */       if (xChildInfo == null)
/*     */       {
/*  74 */         return false;
/*     */       }
/*     */       
/*  77 */       if (xChildInfo.getChild_period() != 0)
/*     */       {
/*  79 */         return false;
/*     */       }
/*     */       
/*  82 */       BabyPeriodInfo xBabyPeriodInfo = xChildInfo.getBaby_period_info();
/*  83 */       if (xBabyPeriodInfo.getBaby_period_operator() != this.operator)
/*     */       {
/*  85 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  89 */       if (xBabyPeriodInfo.getAuto_breed())
/*     */       {
/*  91 */         GameServer.logger().error(String.format("PBabyPeriodBreedObserver.processImp@auto breed|roleid=%d|childid=%d|operator=%d|start_time=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.childId), Integer.valueOf(this.operator), Long.valueOf(this.babyPeriodOperatorStartTime) }));
/*     */         
/*     */ 
/*     */ 
/*  95 */         return false;
/*     */       }
/*     */       
/*  98 */       if (xBabyPeriodInfo.getBaby_period_operator_start_time() != this.babyPeriodOperatorStartTime)
/*     */       {
/* 100 */         return false;
/*     */       }
/*     */       
/* 103 */       SBabyOperatorCfg sBabyOperatorCfg = SBabyOperatorCfg.get(this.operator);
/* 104 */       if (sBabyOperatorCfg == null)
/*     */       {
/* 106 */         return false;
/*     */       }
/*     */       
/* 109 */       long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 110 */       ChildrenManager.refreshAndGetHealthValue(this.roleId, this.childId, xBabyPeriodInfo, currentTimeMillis);
/*     */       
/* 112 */       ChildrenManager.handleBabyPeriodObserverEnd(this.roleId, this.childId, this.operator, xBabyPeriodInfo);
/*     */       
/*     */ 
/* 115 */       xtable.Breedobservers.remove(Long.valueOf(this.childId));
/*     */       
/* 117 */       Map<Integer, Integer> xBabyPeriodPropertyMap = xBabyPeriodInfo.getBaby_property_info_map();
/* 118 */       SBreedBabyChildEnd sBreedBabyChildEnd = new SBreedBabyChildEnd();
/* 119 */       sBreedBabyChildEnd.operator = this.operator;
/* 120 */       sBreedBabyChildEnd.child_id = this.childId;
/*     */       
/* 122 */       for (Map.Entry<Integer, Integer> propertyEntry : xBabyPeriodPropertyMap.entrySet())
/*     */       {
/* 124 */         sBreedBabyChildEnd.now_baby_property.put(propertyEntry.getKey(), propertyEntry.getValue());
/*     */       }
/* 126 */       xBabyPeriodInfo.setBaby_period_operator(-1);
/* 127 */       xBabyPeriodInfo.setBaby_period_operator_start_time(0L);
/*     */       
/* 129 */       OnlineManager.getInstance().send(this.roleId, sBreedBabyChildEnd);
/*     */       
/* 131 */       if (marriedRoleId > 0L)
/*     */       {
/* 133 */         OnlineManager.getInstance().send(marriedRoleId, sBreedBabyChildEnd);
/*     */       }
/* 135 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\BabyPeriodBreedObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */