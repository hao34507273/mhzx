/*    */ package mzm.gsp.online.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PlayerEnterProtect extends mzm.event.BasicEvent<Long>
/*    */ {
/*  7 */   private static EventManager<Long> manager = new EventManager();
/*    */   
/*    */   public EventManager<Long> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.qingfu.main.POnRoleLogoff());
/* 16 */     manager.register(new mzm.gsp.grc.main.POnRoleLogoff());
/* 17 */     manager.register(new mzm.gsp.apollo.main.POnRoleEnterProtect());
/* 18 */     manager.register(new mzm.gsp.apollo.main.POnRoleEnterProtectVoipRoom());
/* 19 */     manager.register(new mzm.gsp.fight.main.POnRoleLogoff());
/* 20 */     manager.register(new mzm.gsp.marriage.main.POnRoleLogoff());
/* 21 */     manager.register(new mzm.gsp.magicmark.main.POnRoleLogoff());
/* 22 */     manager.register(new mzm.gsp.shitu.main.POnRoleLogoff());
/* 23 */     manager.register(new mzm.gsp.gm.main.POnRoleLogoff());
/* 24 */     manager.register(new mzm.gsp.task.main.POnRoleLogoff());
/* 25 */     manager.register(new mzm.gsp.friend.main.POnRoleEnterProtect());
/* 26 */     manager.register(new mzm.gsp.mail.main.POnRoleLogoff());
/* 27 */     manager.register(new mzm.gsp.buff.main.POnRoleLogoff());
/* 28 */     manager.register(new mzm.gsp.title.main.POnRoleLogoff());
/* 29 */     manager.register(new mzm.gsp.badge.main.POnRoleLogoff());
/* 30 */     manager.register(new mzm.gsp.teamplatform.match.ROnRoleLogoff());
/* 31 */     manager.register(new mzm.gsp.idip.main.POnRoleLogoff());
/* 32 */     manager.register(new mzm.gsp.instance.main.POnRoleEnterProtect());
/* 33 */     manager.register(new mzm.gsp.map.main.POnRoleEnterProtect());
/* 34 */     manager.register(new mzm.gsp.group.main.POnRoleEnterProtect());
/* 35 */     manager.register(new mzm.gsp.children.fetuseducationmusic.POnRoleLogoff());
/* 36 */     manager.register(new mzm.gsp.planttree.main.POnRoleLogoff());
/* 37 */     manager.register(new mzm.gsp.avatar.main.POnRoleLogout());
/* 38 */     manager.register(new mzm.gsp.gratefuldelivery.main.POnRoleLogout());
/* 39 */     manager.register(new mzm.gsp.crossfield.main.ROnRoleLogoff());
/* 40 */     manager.register(new mzm.gsp.crossbattle.bet.ROnRoleLogoff());
/* 41 */     manager.register(new mzm.gsp.avatar.frame.POnRoleLogout());
/* 42 */     manager.register(new mzm.gsp.chatbubble.main.POnRoleLogoff());
/* 43 */     manager.register(new mzm.gsp.singlebattle.antiafk.ROnRoleLogoff());
/* 44 */     manager.register(new mzm.gsp.interaction.main.POnRoleLogout());
/* 45 */     manager.register(new mzm.gsp.bandstand.main.POnRoleLogout());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\event\PlayerEnterProtect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */