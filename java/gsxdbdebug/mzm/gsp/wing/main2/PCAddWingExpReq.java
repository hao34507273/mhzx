/*     */ package mzm.gsp.wing.main2;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.confbean.SWingExpItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.WingPlan;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCAddWingExpReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long uuid;
/*     */   private final int num;
/*     */   
/*     */   public PCAddWingExpReq(long roleId, long uuid, int num)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.uuid = uuid;
/*  33 */     this.num = num;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!isValid())
/*     */     {
/*  41 */       return false;
/*     */     }
/*  43 */     lock(Lockeys.get(User.getTable(), RoleInterface.getUserId(this.roleId)));
/*  44 */     RoleWingInfo roleWingInfo = new RoleWingInfo(this.roleId, true);
/*  45 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/*  46 */     if (xWingPlan == null)
/*     */     {
/*  48 */       GameServer.logger().error(String.format("[wing]PCAddWingExpReq.processImp@ wing plan not open!|roleId=%d|plan=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1) }));
/*     */       
/*     */ 
/*  51 */       WingManager.sendWingNotice(this.roleId, 11, new String[0]);
/*  52 */       return false;
/*     */     }
/*  54 */     RoleWingPlan xPlan = new RoleWingPlan(this.roleId, 1, xWingPlan);
/*     */     
/*  56 */     ItemAddExp addInfo = getAddExpInfo();
/*  57 */     if (!addInfo.isSuc())
/*     */     {
/*  59 */       return false;
/*     */     }
/*  61 */     if (!WingManager.addExp(xPlan, addInfo.getSingleAddExp(), addInfo.getNeedUseItemNum(), addInfo.getItemId(), roleWingInfo.getEffectWingOccId()))
/*     */     {
/*  63 */       GameServer.logger().error(String.format("[wing]PCAddWingExpReq.processImp@ add exp error!|roleId=%d|plan=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1) }));
/*     */       
/*     */ 
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private ItemAddExp getAddExpInfo()
/*     */   {
/*  79 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, this.uuid);
/*  80 */     if ((basicItem == null) || (basicItem.getNumber() <= 0))
/*     */     {
/*  82 */       ItemInterface.sendWrongInfo(this.roleId, 102, new String[0]);
/*  83 */       return new ItemAddExp();
/*     */     }
/*  85 */     SWingExpItem itemCfg = SWingExpItem.get(basicItem.getCfgId());
/*  86 */     if ((itemCfg == null) || (itemCfg.type != 61))
/*     */     {
/*  88 */       ItemInterface.sendWrongInfo(this.roleId, 101, new String[0]);
/*  89 */       return new ItemAddExp();
/*     */     }
/*     */     
/*  92 */     int ownItemNum = basicItem.getNumber();
/*  93 */     if (ownItemNum < 1)
/*     */     {
/*  95 */       GameServer.logger().error(String.format("[wing]PCAddWingExpReq.getAddExp@ exp item num not enough!|roleId=%d|needNum=%d|ownNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.num), Integer.valueOf(basicItem.getNumber()) }));
/*     */       
/*     */ 
/*  98 */       return new ItemAddExp();
/*     */     }
/*     */     
/* 101 */     return getFinalRes(itemCfg, ownItemNum);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private ItemAddExp getFinalRes(SWingExpItem itemCfg, int ownItemNum)
/*     */   {
/* 113 */     if (this.num == 0)
/*     */     {
/* 115 */       GameServer.logger().error(String.format("[wing]PCAddWingExpReq.getFinalRes@ add expitem num illegal!|roleId=%d|needNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.num) }));
/*     */       
/*     */ 
/* 118 */       return new ItemAddExp();
/*     */     }
/*     */     
/* 121 */     int needAddItem = 0;
/* 122 */     if (this.num < 0)
/*     */     {
/* 124 */       needAddItem = ownItemNum;
/*     */     }
/*     */     else
/*     */     {
/* 128 */       if (this.num > ownItemNum)
/*     */       {
/* 130 */         GameServer.logger().error(String.format("[wing]PCAddWingExpReq.getFinalRes@ add expitem num too large!|roleId=%d|needNum=%d|ownNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.num), Integer.valueOf(ownItemNum) }));
/*     */         
/*     */ 
/*     */ 
/* 134 */         return new ItemAddExp();
/*     */       }
/*     */       
/*     */ 
/* 138 */       needAddItem = this.num;
/*     */     }
/*     */     
/* 141 */     return new ItemAddExp(itemCfg.addExpNum, needAddItem, itemCfg.id);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isValid()
/*     */   {
/* 152 */     if (!canActiveAddWingExpInStatus(this.roleId))
/*     */     {
/* 154 */       return false;
/*     */     }
/* 156 */     if (RoleInterface.getLevel(this.roleId) < WingInterface.getMinRoleLvForWing())
/*     */     {
/* 158 */       WingManager.sendWingNotice(this.roleId, 8, new String[0]);
/* 159 */       return false;
/*     */     }
/*     */     
/* 162 */     if (!WingManager.isWingAddExpSwitchOpenForRole(this.roleId))
/*     */     {
/* 164 */       return false;
/*     */     }
/*     */     
/* 167 */     return true;
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
/*     */ 
/*     */   private boolean canActiveAddWingExpInStatus(long roleId)
/*     */   {
/* 181 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 53, true))
/*     */     {
/* 183 */       GameServer.logger().error(String.format("[wing]PCAddWingExpReq.canActiveAddWingExpInStatus@ active AddWingExp is forbiddened!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*     */ 
/* 187 */       return false;
/*     */     }
/* 189 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   class ItemAddExp
/*     */   {
/*     */     private final int singleAddExp;
/*     */     
/*     */ 
/*     */     private final int needUseItemNum;
/*     */     
/*     */     private final int itemId;
/*     */     
/*     */     private final boolean suc;
/*     */     
/*     */ 
/*     */     public ItemAddExp(int singleAddExp, int needUseItemNum, int itemId)
/*     */     {
/* 208 */       this.singleAddExp = singleAddExp;
/* 209 */       this.needUseItemNum = needUseItemNum;
/* 210 */       this.itemId = itemId;
/* 211 */       this.suc = true;
/*     */     }
/*     */     
/*     */     public ItemAddExp()
/*     */     {
/* 216 */       this.singleAddExp = -1;
/* 217 */       this.needUseItemNum = -1;
/* 218 */       this.itemId = -1;
/* 219 */       this.suc = false;
/*     */     }
/*     */     
/*     */     public int getSingleAddExp()
/*     */     {
/* 224 */       return this.singleAddExp;
/*     */     }
/*     */     
/*     */     public int getNeedUseItemNum()
/*     */     {
/* 229 */       return this.needUseItemNum;
/*     */     }
/*     */     
/*     */     public boolean isSuc()
/*     */     {
/* 234 */       return this.suc;
/*     */     }
/*     */     
/*     */     public int getItemId()
/*     */     {
/* 239 */       return this.itemId;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PCAddWingExpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */