/*     */ package mzm.gsp.huanhun.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.huanhun.SAddXItemInfoRep;
/*     */ import mzm.gsp.huanhun.SGangHelpAddItemSuc;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GangHelpInfo;
/*     */ import xbean.HanhunInfo;
/*     */ import xbean.ItemInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Gang;
/*     */ import xtable.Gang2hunhelp;
/*     */ import xtable.Role2huanhun;
/*     */ 
/*     */ 
/*     */ public class PRmRoleGangHelp
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleIdCall;
/*     */   private final long roleIdAdd;
/*     */   private final int boxIndex;
/*     */   private final SAddXItemInfoRep sAddXItemInfoRep;
/*  30 */   private boolean sameGuy = false;
/*     */   
/*     */   public PRmRoleGangHelp(long roleIdCall, long roleAdd, int boxIndex, SAddXItemInfoRep sAddXItemInfoRep)
/*     */   {
/*  34 */     this.roleIdAdd = roleAdd;
/*  35 */     this.roleIdCall = roleIdCall;
/*  36 */     this.boxIndex = boxIndex;
/*  37 */     this.sAddXItemInfoRep = sAddXItemInfoRep;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if (this.roleIdAdd == this.roleIdCall)
/*     */     {
/*  45 */       this.sameGuy = true;
/*     */     }
/*  47 */     Set<Long> lockRoles = new HashSet();
/*  48 */     lockRoles.add(Long.valueOf(this.roleIdAdd));
/*  49 */     lockRoles.add(Long.valueOf(this.roleIdCall));
/*     */     
/*     */ 
/*  52 */     lock(Basic.getTable(), lockRoles);
/*  53 */     long gangId = GangInterface.getGangId(this.roleIdCall);
/*  54 */     if (gangId <= 0L)
/*     */     {
/*  56 */       GameServer.logger().info(String.format("[hun]PRmRoleGangHelp.processImp@ no gang!|roleId=%d|boxIndexs=%s", new Object[] { Long.valueOf(this.roleIdCall), Integer.valueOf(this.boxIndex) }));
/*     */       
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     lock(Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(gangId) }));
/*  62 */     if (gangId != GangInterface.getGangId(this.roleIdCall))
/*     */     {
/*     */ 
/*  65 */       GameServer.logger().info(String.format("[hun]PRmRoleGangHelp.processImp@ gang change!|roleId=%d|boxIndexs=%s|gangId=%d", new Object[] { Long.valueOf(this.roleIdCall), Integer.valueOf(this.boxIndex), Long.valueOf(gangId) }));
/*     */       
/*     */ 
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     GangHelpInfo xHelpInfo = Gang2hunhelp.get(Long.valueOf(gangId));
/*  72 */     if (xHelpInfo == null)
/*     */     {
/*  74 */       GameServer.logger().error(String.format("[hun]PRmRoleGangHelp.processImp@ no xHelpInfo!|roleId=%d|boxIndexs=%s|gangId=%d", new Object[] { Long.valueOf(this.roleIdCall), Integer.valueOf(this.boxIndex), Long.valueOf(gangId) }));
/*     */       
/*     */ 
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     HanhunInfo xHunInfo = Role2huanhun.get(Long.valueOf(this.roleIdCall));
/*  81 */     if (xHunInfo == null)
/*     */     {
/*  83 */       GameServer.logger().error(String.format("[hun]PRmRoleGangHelp.processImp@ xHunInfo is null!|roleId=%d|boxIndexs=%s|gangId=%d", new Object[] { Long.valueOf(this.roleIdCall), Integer.valueOf(this.boxIndex), Long.valueOf(gangId) }));
/*     */       
/*     */ 
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     ItemInfo xInfo = (ItemInfo)xHunInfo.getIteminfos().get(Integer.valueOf(this.boxIndex));
/*  90 */     if (xInfo == null)
/*     */     {
/*  92 */       GameServer.logger().error(String.format("[hun]PRmRoleGangHelp.processImp@ xInfo is null!|roleId=%d|boxIndexs=%s|gangId=%d", new Object[] { Long.valueOf(this.roleIdCall), Integer.valueOf(this.boxIndex), Long.valueOf(gangId) }));
/*     */       
/*     */ 
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     if (!xInfo.getTaskstate())
/*     */     {
/* 100 */       GameServer.logger().error(String.format("[hun]PRmRoleGangHelp.processImp@ box is not full!|roleId=%d|boxIndexs=%s|gangId=%d", new Object[] { Long.valueOf(this.roleIdCall), Integer.valueOf(this.boxIndex), Long.valueOf(gangId) }));
/*     */       
/*     */ 
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     if (!xInfo.getGanghelpstate())
/*     */     {
/* 108 */       GameServer.logger().info(String.format("[hun]PRmRoleGangHelp.processImp@ box not call help!|roleId=%d|boxIndexs=%s|gangId=%d", new Object[] { Long.valueOf(this.roleIdCall), Integer.valueOf(this.boxIndex), Long.valueOf(gangId) }));
/*     */       
/*     */ 
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     GangHelpManager.rmRoleGangHelp(gangId, xHelpInfo, this.roleIdCall, this.boxIndex);
/*     */     
/* 116 */     xInfo.setGanghelpstate(false);
/*     */     
/* 118 */     broGangHelpSuc(gangId, xInfo.getItemcfgid(), xInfo.getItemnum());
/* 119 */     return true;
/*     */   }
/*     */   
/*     */   private void broGangHelpSuc(long gangId, int itemId, int num)
/*     */   {
/* 124 */     if (this.sAddXItemInfoRep != null)
/*     */     {
/* 126 */       GangInterface.brocastInGang(this.sAddXItemInfoRep, gangId);
/*     */     }
/* 128 */     if (!this.sameGuy)
/*     */     {
/* 130 */       SGangHelpAddItemSuc p = new SGangHelpAddItemSuc();
/* 131 */       p.itemcfgid = itemId;
/* 132 */       p.itemnum = num;
/* 133 */       p.rolenameofferhelp = RoleInterface.getName(this.roleIdAdd);
/* 134 */       p.rolenameseekhelp = RoleInterface.getName(this.roleIdCall);
/* 135 */       GangInterface.brocastInGang(p, gangId);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\PRmRoleGangHelp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */