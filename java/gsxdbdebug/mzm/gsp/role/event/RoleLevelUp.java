/*    */ package mzm.gsp.role.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleLevelUp extends mzm.event.BasicEvent<RoleLevelUpArg>
/*    */ {
/*  7 */   private static EventManager<RoleLevelUpArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleLevelUpArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnRoleLevelUp());
/* 16 */     manager.register(new mzm.gsp.task.main.POnRoleLevelUp());
/* 17 */     manager.register(new mzm.gsp.friend.main.POnRoleLevelUp());
/* 18 */     manager.register(new mzm.gsp.children.main.POnRoleLevelUp());
/* 19 */     manager.register(new mzm.gsp.team.main.POnRoleLevelUp());
/* 20 */     manager.register(new mzm.gsp.activity.main.ROnRoleLevelUp());
/* 21 */     manager.register(new mzm.gsp.skill.main.POnRoleLevelUp());
/* 22 */     manager.register(new mzm.gsp.map.main.POnRoleLevelUp());
/* 23 */     manager.register(new mzm.gsp.lifeskill.main.POnRoleLevelUp());
/* 24 */     manager.register(new mzm.gsp.gangskill.main.POnRoleLevelUp());
/* 25 */     manager.register(new mzm.gsp.partner.main.POnRoleLevelUp());
/* 26 */     manager.register(new mzm.gsp.xiulian.main.POnRoleLevelUp());
/* 27 */     manager.register(new mzm.gsp.gang.main.POnRoleLevelUp());
/* 28 */     manager.register(new mzm.gsp.guide.main.POnRoleLevelUp());
/* 29 */     manager.register(new mzm.gsp.teamplatform.match.ROnRoleLevelUp());
/* 30 */     manager.register(new mzm.gsp.baitan.main.POnRoleLevelUp());
/* 31 */     manager.register(new mzm.gsp.grow.main.POnRoleLevelUp());
/* 32 */     manager.register(new mzm.gsp.grow.LevelGuide.POnRoleLevelUp());
/* 33 */     manager.register(new mzm.gsp.online.main.POnRoleLevelUp());
/* 34 */     manager.register(new mzm.gsp.qingyunzhi.main.POnRoleLevelUp());
/* 35 */     manager.register(new mzm.gsp.festival.main.POnRoleLevelUp());
/* 36 */     manager.register(new mzm.gsp.item.main.POnRoleLevelUpEquiptip());
/* 37 */     manager.register(new mzm.gsp.qingfu.main.POnRoleLevelUp());
/* 38 */     manager.register(new mzm.gsp.mail.main.POnRoleLevelUp());
/* 39 */     manager.register(new mzm.gsp.jingji.main.POnRoleLevelUp());
/* 40 */     manager.register(new mzm.gsp.fashiondress.main.POnRoleLevelUp());
/* 41 */     manager.register(new mzm.gsp.fabao.main.POnRoleLevelUp());
/* 42 */     manager.register(new mzm.gsp.storageexp.activity.POnRoleLevelUp());
/* 43 */     manager.register(new mzm.gsp.msdkprofile.main.POnRoleLevelUp());
/* 44 */     manager.register(new mzm.gsp.achievement.main.POnRoleLevelUp());
/* 45 */     manager.register(new mzm.gsp.singletask.level.POnRoleLevelUp());
/* 46 */     manager.register(new mzm.gsp.personal.main.POnRoleLevelUp());
/* 47 */     manager.register(new mzm.gsp.grc.main.ROnRoleLevelUp());
/* 48 */     manager.register(new mzm.gsp.group.main.POnRoleLevelUp());
/* 49 */     manager.register(new mzm.gsp.ladder.main.POnRoleLevelUp());
/* 50 */     manager.register(new mzm.gsp.planttree.main.POnRoleLevelUp());
/* 51 */     manager.register(new mzm.gsp.feisheng.main.POnRoleLevelUp());
/* 52 */     manager.register(new mzm.gsp.mourn.main.POnRoleLevelUp());
/* 53 */     manager.register(new mzm.gsp.corps.main.POnRoleLevelUp());
/* 54 */     manager.register(new mzm.gsp.axe.main.POnRoleLevelUp());
/* 55 */     manager.register(new mzm.gsp.gratefuldelivery.main.ROnRoleLevelUp());
/* 56 */     manager.register(new mzm.gsp.shitu.main.POnRoleLevelUp());
/* 57 */     manager.register(new mzm.gsp.shitu.main.POnRoleLevelUpSyn());
/* 58 */     manager.register(new mzm.gsp.loginaward.main.POnRoleLevelUp());
/* 59 */     manager.register(new mzm.gsp.friendscircle.main.POnRoleLevelUp());
/* 60 */     manager.register(new mzm.gsp.activitycompensate.main.POnRoleLevelUp());
/* 61 */     manager.register(new mzm.gsp.petarena.main.POnRoleLevelUp());
/* 62 */     manager.register(new mzm.gsp.christmasstocking.main.POnRoleLevelUp());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\event\RoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */