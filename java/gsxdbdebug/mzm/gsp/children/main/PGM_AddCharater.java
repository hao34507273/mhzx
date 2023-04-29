/*    */ package mzm.gsp.children.main;
/*    */ 
/*    */ import mzm.gsp.children.confbean.SChildrenConsts;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.AdulthoodInfo;
/*    */ import xbean.ChildInfo;
/*    */ 
/*    */ public class PGM_AddCharater extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final long childid;
/*    */   private final int num;
/*    */   
/*    */   public PGM_AddCharater(long gmRoleid, long roleid, long childid, int num)
/*    */   {
/* 18 */     this.gmRoleid = gmRoleid;
/* 19 */     this.roleid = roleid;
/* 20 */     this.childid = childid;
/* 21 */     this.num = num;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     if (!ChildrenInterface.getRoleBagChilds(this.roleid, true).contains(Long.valueOf(this.childid))) {
/* 27 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("玩家包裹中没有该child:", new Object[] { Long.valueOf(this.childid) }));
/* 28 */       return false;
/*    */     }
/* 30 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childid));
/* 31 */     if (xChildInfo == null) {
/* 32 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("不存在改child:", new Object[] { Long.valueOf(this.childid) }));
/* 33 */       return false;
/*    */     }
/* 35 */     if (xChildInfo.getChild_period() != 2) {
/* 36 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("child不是成年期", new Object[] { Long.valueOf(this.childid) }));
/* 37 */       return false;
/*    */     }
/* 39 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/* 40 */     int character = xAdulthoodInfo.getCharacter();
/* 41 */     character += this.num;
/* 42 */     character = Math.max(0, character);
/* 43 */     character = Math.min(character, SChildrenConsts.getInstance().child_grow_character_max);
/* 44 */     xAdulthoodInfo.setCharacter(character);
/* 45 */     mzm.gsp.children.SSynChildrenCharacterRes synChildrenCharacterRes = new mzm.gsp.children.SSynChildrenCharacterRes();
/* 46 */     synChildrenCharacterRes.character = character;
/* 47 */     synChildrenCharacterRes.childrenid = this.childid;
/* 48 */     OnlineManager.getInstance().send(this.roleid, synChildrenCharacterRes);
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PGM_AddCharater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */