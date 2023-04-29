/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.cat.main.CatInterface;
/*     */ import mzm.gsp.marriage.event.MarriageArg;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
/*     */ import xbean.HomeOwners;
/*     */ import xtable.Homeworld2roles;
/*     */ import xtable.Role2homeinfo;
/*     */ import xtable.Role2homeworldid;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnMarraige extends mzm.gsp.marriage.event.MarriageEventProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  24 */     String userIdA = RoleInterface.getUserId(((MarriageArg)this.arg).roleidA);
/*  25 */     String userIdB = RoleInterface.getUserId(((MarriageArg)this.arg).roleidB);
/*     */     
/*  27 */     lock(User.getTable(), Arrays.asList(new String[] { userIdA, userIdB }));
/*  28 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(((MarriageArg)this.arg).roleidA), Long.valueOf(((MarriageArg)this.arg).roleidB) }));
/*     */     
/*  30 */     if (!MarriageInterface.isMarriageRelation(((MarriageArg)this.arg).roleidA, ((MarriageArg)this.arg).roleidB))
/*     */     {
/*  32 */       String logString = String.format("[home]POnMarraige.processImp@marriage relation error|roleIdA=%d|roleIdB=%d", new Object[] { Long.valueOf(((MarriageArg)this.arg).roleidA), Long.valueOf(((MarriageArg)this.arg).roleidB) });
/*     */       
/*     */ 
/*  35 */       HomelandManager.logger.error(logString);
/*     */       
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     HomeInfo xHomeInfoA = Role2homeinfo.get(Long.valueOf(((MarriageArg)this.arg).roleidA));
/*  41 */     HomeInfo xHomeInfoB = Role2homeinfo.get(Long.valueOf(((MarriageArg)this.arg).roleidB));
/*  42 */     if ((xHomeInfoA == null) && (xHomeInfoB == null))
/*     */     {
/*  44 */       String logString = String.format("[home]POnMarraige.processImp@no home|roleIdA=%d|roleIdB=%d", new Object[] { Long.valueOf(((MarriageArg)this.arg).roleidA), Long.valueOf(((MarriageArg)this.arg).roleidB) });
/*     */       
/*     */ 
/*  47 */       HomelandManager.logger.info(logString);
/*     */       
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (xHomeInfoA == null)
/*     */     {
/*     */ 
/*  55 */       setMainViceHome(xHomeInfoB, ((MarriageArg)this.arg).roleidB, null, ((MarriageArg)this.arg).roleidA);
/*     */ 
/*     */ 
/*     */     }
/*  59 */     else if (xHomeInfoB == null)
/*     */     {
/*     */ 
/*  62 */       setMainViceHome(xHomeInfoA, ((MarriageArg)this.arg).roleidA, null, ((MarriageArg)this.arg).roleidB);
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*  67 */     else if (xHomeInfoA.getHomelevel() == xHomeInfoB.getHomelevel())
/*     */     {
/*  69 */       if (RoleInterface.getGender(((MarriageArg)this.arg).roleidA) == 1)
/*     */       {
/*     */ 
/*  72 */         setMainViceHome(xHomeInfoA, ((MarriageArg)this.arg).roleidA, xHomeInfoB, ((MarriageArg)this.arg).roleidB);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  77 */         setMainViceHome(xHomeInfoB, ((MarriageArg)this.arg).roleidB, xHomeInfoA, ((MarriageArg)this.arg).roleidA);
/*     */       }
/*     */     }
/*  80 */     else if (xHomeInfoA.getHomelevel() > xHomeInfoB.getHomelevel())
/*     */     {
/*     */ 
/*  83 */       setMainViceHome(xHomeInfoA, ((MarriageArg)this.arg).roleidA, xHomeInfoB, ((MarriageArg)this.arg).roleidB);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/*  89 */       setMainViceHome(xHomeInfoB, ((MarriageArg)this.arg).roleidB, xHomeInfoA, ((MarriageArg)this.arg).roleidA);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  96 */     return true;
/*     */   }
/*     */   
/*     */   private void setMainViceHome(HomeInfo xMainHomeInfo, long mainRoleId, HomeInfo xViceHomeInfo, long viceRoleId)
/*     */     throws java.io.UnsupportedEncodingException
/*     */   {
/* 102 */     xMainHomeInfo.setIsmainhome(true);
/*     */     
/* 104 */     int oldViceRoleState = 0;
/*     */     
/* 106 */     HomeOperate xViceFurnitures = HomelandManager.getXHomeOperate(viceRoleId);
/* 107 */     xViceFurnitures.setHomestate(4);
/*     */     
/* 109 */     if (xViceHomeInfo != null)
/*     */     {
/* 111 */       oldViceRoleState = 2;
/* 112 */       HomelandManager.removeAllMyFurnitureFromWorld(xViceHomeInfo);
/* 113 */       HomelandManager.moveAllFurnitureFromHome2Bag(xViceHomeInfo, true, xViceFurnitures, true);
/* 114 */       HomelandManager.computeFurnitureFengShui(xViceHomeInfo);
/* 115 */       HomelandRankManager.getInstance().delete(Long.valueOf(viceRoleId));
/* 116 */       HomelandManager.removeRoleNameFromWorld(viceRoleId, RoleInterface.getName(viceRoleId));
/* 117 */       CatInterface.removeCatByRoleid(viceRoleId, true);
/*     */     }
/*     */     else
/*     */     {
/* 121 */       oldViceRoleState = 1;
/*     */     }
/*     */     
/* 124 */     HomelandManager.sendSSynOwnFurnitureRes(viceRoleId, xViceFurnitures);
/*     */     
/* 126 */     HomelandManager.sendSSynHomelandRes(viceRoleId, false, xMainHomeInfo, xViceFurnitures);
/*     */     
/* 128 */     List<Long> worldList = new ArrayList();
/* 129 */     Long viceWorldid = Role2homeworldid.get(Long.valueOf(viceRoleId));
/* 130 */     if (viceWorldid != null)
/*     */     {
/* 132 */       long viceWroldKey = GameServerInfoManager.toGlobalId(viceWorldid.longValue());
/* 133 */       worldList.add(Long.valueOf(viceWroldKey));
/*     */     }
/*     */     
/* 136 */     Long mainWorldId = Role2homeworldid.get(Long.valueOf(mainRoleId));
/* 137 */     if (mainWorldId != null)
/*     */     {
/* 139 */       long mainWroldKey = GameServerInfoManager.toGlobalId(mainWorldId.longValue());
/* 140 */       worldList.add(Long.valueOf(mainWroldKey));
/*     */     }
/* 142 */     xdb.Lockeys.lock(Homeworld2roles.getTable(), worldList);
/* 143 */     if (viceWorldid != null)
/*     */     {
/* 145 */       HomelandManager.forceDestroyHomeWorld(viceRoleId, -1L, viceWorldid.longValue());
/*     */     }
/* 147 */     if (mainWorldId != null)
/*     */     {
/* 149 */       Role2homeworldid.insert(Long.valueOf(viceRoleId), mainWorldId);
/* 150 */       long globalhomeid = GameServerInfoManager.toGlobalId(mainWorldId.longValue());
/* 151 */       HomeOwners xHomeOwners = Homeworld2roles.get(Long.valueOf(globalhomeid));
/* 152 */       if (xHomeOwners != null)
/*     */       {
/* 154 */         xHomeOwners.setPartnerroleid(viceRoleId);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 159 */       mainWorldId = Long.valueOf(-1L);
/*     */     }
/*     */     
/* 162 */     int courtMapId = HomelandManager.getHomelandCourtyardMapId(xMainHomeInfo.getCourtyardlevel());
/* 163 */     if (courtMapId != -1)
/*     */     {
/* 165 */       HomelandManager.addPartnerNameIntoWorld(mainRoleId, viceRoleId, RoleInterface.getName(viceRoleId));
/* 166 */       CatInterface.addCatIntoWorld(viceRoleId, mainWorldId.longValue(), courtMapId, false);
/*     */     }
/* 168 */     int roomMapCfgId = HomelandManager.getHomelandRoomMapId(xMainHomeInfo.getHomelevel());
/*     */     
/*     */ 
/* 171 */     mzm.gsp.children.main.ChildrenInterface.addChildrenByRoleId(viceRoleId, mainWorldId.longValue(), courtMapId, roomMapCfgId);
/*     */     
/*     */ 
/* 174 */     mzm.gsp.zoo.main.ZooInterface.onMarriage(viceRoleId, mainWorldId.longValue(), courtMapId);
/*     */     
/* 176 */     mzm.gsp.homeland.mysteryvisitor.MysteryVisitorInterface.addMysteryVisitorIntoCourtyard(viceRoleId, mainWorldId.longValue(), courtMapId);
/*     */     
/* 178 */     HomelandManager.triggerHomeStateChangedEvent(viceRoleId, mainRoleId, oldViceRoleState, xViceFurnitures.getHomestate());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnMarraige.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */