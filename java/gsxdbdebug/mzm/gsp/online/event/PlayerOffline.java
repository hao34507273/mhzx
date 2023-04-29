/*    */ package mzm.gsp.online.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PlayerOffline extends mzm.event.BasicEvent<Long>
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
/* 17 */     manager.register(new mzm.gsp.apollo.main.POnRoleLogoff());
/* 18 */     manager.register(new mzm.gsp.apollo.main.POnRoleLogoffVoipRoom());
/* 19 */     manager.register(new mzm.gsp.gm.main.POnRoleLogoff());
/* 20 */     manager.register(new mzm.gsp.masswedding.main.POnRoleOffline());
/* 21 */     manager.register(new mzm.gsp.magicmark.main.POnRoleLogoff());
/* 22 */     manager.register(new mzm.gsp.ladder.main.POnRoleOffline());
/* 23 */     manager.register(new mzm.gsp.fight.main.ROnRoleOffLine());
/* 24 */     manager.register(new mzm.gsp.fight.main.POnRoleLogoffForRoamFightRecord());
/* 25 */     manager.register(new mzm.gsp.couple.main.POnRoleLogoff());
/* 26 */     manager.register(new mzm.gsp.online.main.POnRoleLogoff());
/* 27 */     manager.register(new mzm.gsp.task.main.POnRoleLogoff());
/* 28 */     manager.register(new mzm.gsp.task.main.POnRoleLogoffAsReal());
/* 29 */     manager.register(new mzm.gsp.role.main.POnRoleLogoff());
/* 30 */     manager.register(new mzm.gsp.baitan.main.POnRoleLogoff());
/* 31 */     manager.register(new mzm.gsp.market.main.POnRoleLogoff());
/* 32 */     manager.register(new mzm.gsp.market.search.POnRoleLogoff());
/* 33 */     manager.register(new mzm.gsp.jingji.main.POnRoleLogoff());
/* 34 */     manager.register(new mzm.gsp.team.main.POnRoleLogoff());
/* 35 */     manager.register(new mzm.gsp.competition.main.POnRoleRealOffline());
/* 36 */     manager.register(new mzm.gsp.singlebattle.main.POnRoleLogoff());
/* 37 */     manager.register(new mzm.gsp.corps.main.POnRoleLogoff());
/* 38 */     manager.register(new mzm.gsp.map.main.POnRoleLogoff());
/* 39 */     manager.register(new mzm.gsp.friend.main.POnRoleLogoff());
/* 40 */     manager.register(new mzm.gsp.mail.main.POnRoleLogoff());
/* 41 */     manager.register(new mzm.gsp.buff.main.POnRoleLogoff());
/* 42 */     manager.register(new mzm.gsp.gang.main.POnRoleLogoff());
/* 43 */     manager.register(new mzm.gsp.pet.main.POnRoleLogoff());
/* 44 */     manager.register(new mzm.gsp.title.main.POnRoleLogoff());
/* 45 */     manager.register(new mzm.gsp.teamplatform.match.ROnRoleLogoff());
/* 46 */     manager.register(new mzm.gsp.badge.main.POnRoleLogoff());
/* 47 */     manager.register(new mzm.gsp.instance.main.POnRoleLogoff());
/* 48 */     manager.register(new mzm.gsp.husong.main.POnRoleoffLine());
/* 49 */     manager.register(new mzm.gsp.menpaipvp.main.POnRoleRealOffline());
/* 50 */     manager.register(new mzm.gsp.arena.main.POnRoleRealOffline());
/* 51 */     manager.register(new mzm.gsp.shitu.main.POnRoleLogoff());
/* 52 */     manager.register(new mzm.gsp.idip.main.POnRoleLogoff());
/* 53 */     manager.register(new mzm.gsp.chat.main.ROnRoleRealOffline());
/* 54 */     manager.register(new mzm.gsp.msdkprofile.main.POnRoleLogoff());
/* 55 */     manager.register(new mzm.gsp.homeland.main.POnRoleLogoff());
/* 56 */     manager.register(new mzm.gsp.loginaward.main.ROnRoleLogoff());
/* 57 */     manager.register(new mzm.gsp.chatgift.main.POnRoleLogoff());
/* 58 */     manager.register(new mzm.gsp.group.main.POnRoleLogoff());
/* 59 */     manager.register(new mzm.gsp.massexp.main.POnRoleLogoff());
/* 60 */     manager.register(new mzm.gsp.addiction.main.POnRoleLogoff());
/* 61 */     manager.register(new mzm.gsp.children.main.POnRoleLogoff());
/* 62 */     manager.register(new mzm.gsp.fashiondress.main.POnRoleLogoff());
/* 63 */     manager.register(new mzm.gsp.mounts.main.POnRoleLogoff());
/* 64 */     manager.register(new mzm.gsp.achievement.main.POnRoleLogoff());
/* 65 */     manager.register(new mzm.gsp.children.fetuseducationmusic.POnRoleLogoff());
/* 66 */     manager.register(new mzm.gsp.children.fashion.POnRoleLogoff());
/* 67 */     manager.register(new mzm.gsp.planttree.main.POnRoleLogoff());
/* 68 */     manager.register(new mzm.gsp.avatar.main.POnRoleLogout());
/* 69 */     manager.register(new mzm.gsp.gratefuldelivery.main.POnRoleLogout());
/* 70 */     manager.register(new mzm.gsp.zoo.main.POnRoleLogoff());
/* 71 */     manager.register(new mzm.gsp.fabaolingqi.main.POnRoleLogout());
/* 72 */     manager.register(new mzm.gsp.crossfield.main.ROnRoleLogoff());
/* 73 */     manager.register(new mzm.gsp.crossbattle.bet.ROnRoleLogoff());
/* 74 */     manager.register(new mzm.gsp.pk.main.POnRoleLogout());
/* 75 */     manager.register(new mzm.gsp.backgameactivity.main.POnRoleLogoff());
/* 76 */     manager.register(new mzm.gsp.coupledaily.main.PPlayerRealLogout());
/* 77 */     manager.register(new mzm.gsp.avatar.frame.POnRoleLogout());
/* 78 */     manager.register(new mzm.gsp.partner.main.POnRoleLogoff());
/* 79 */     manager.register(new mzm.gsp.chatbubble.main.POnRoleLogoff());
/* 80 */     manager.register(new mzm.gsp.singlebattle.antiafk.ROnRoleLogoff());
/* 81 */     manager.register(new mzm.gsp.interaction.main.POnRoleLogout());
/* 82 */     manager.register(new mzm.gsp.bandstand.main.POnRoleLogout());
/* 83 */     manager.register(new mzm.gsp.ballbattle.main.ROnRoleLogout());
/* 84 */     manager.register(new mzm.gsp.role.main.POnRoleLogoffTLogPropertyData());
/* 85 */     manager.register(new mzm.gsp.children.main.POnRoleOffLine());
/* 86 */     manager.register(new mzm.gsp.map.main.POnRoleLogoffForClearing());
/* 87 */     manager.register(new mzm.gsp.online.main.PPlayerRealLogout());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\event\PlayerOffline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */