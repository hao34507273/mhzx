/*     */ package mzm.gsp.team;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class STeamNormalResult extends __STeamNormalResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588316;
/*     */   public static final int INVITE_TEAM__INVITEE_IN_TEAM = 1;
/*     */   public static final int INVITE_TEAM__SUCCESS = 2;
/*     */   public static final int INVITE_TEAM__INVITEE_NOT_ONLINE = 3;
/*     */   public static final int INVITE_TEAM__INVITEE_IN_OUR_TEAM_ALREADY = 4;
/*     */   public static final int INVITE_TEAM__INVITEE_IN_APPLYLIST_ALREADY = 5;
/*     */   public static final int INVITE_TEAM_REP__INVITER_IN_OTHER_TEAM = 11;
/*     */   public static final int INVITE_TEAM_REP__REFUSE = 12;
/*     */   public static final int INVITE_TEAM_REP__TIMEOUT = 13;
/*     */   public static final int INVITE_TEAM_REP__FULL = 14;
/*     */   public static final int INVITE_TEAM_REP__REPEAT = 15;
/*     */   public static final int INVITE_TEAM_FORBID_BE_INVITED = 16;
/*     */   public static final int INVITE_TEAM_INTERCAPT = 17;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12588316;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int APPLY_TEAM_BY_MEMBER__ALREADY = 21;
/*     */   
/*     */   public static final int APPLY_TEAM_BY_MEMBER__SUCCESS = 22;
/*     */   
/*     */   public static final int APPLY_TEAM_REP__TIMEOUT = 23;
/*     */   
/*     */   public static final int APPLY_TEAM_ERROR__IN_TEAM = 24;
/*     */   
/*     */   public static final int APPLY_TEAM_REP__FULL = 31;
/*     */   
/*     */   public static final int APPLY_TEAM_REP__REFUSE = 32;
/*     */   
/*     */   public static final int APPLY_TEAM_REP__CHANGE = 33;
/*     */   
/*     */   public static final int APPLY_TEAM_REP__OFFLINE = 34;
/*     */   
/*     */   public static final int APPLY_TEAM__NULL = 35;
/*     */   
/*     */   public static final int EFFECT_AFTER_FIGHT = 41;
/*     */   
/*     */   public static final int RETURN_TEAM_AFTER_FIGHT = 42;
/*     */   
/*     */   public static final int CHANGE_LEADER__TEMPLEAVE = 51;
/*     */   
/*     */   public static final int CHANGE_LEADER__OFFLINE = 52;
/*     */   public static final int JOIN_TEAM__FULL = 61;
/*     */   public static final int JOIN_TEAM__NULL = 62;
/*     */   public static final int TRY_RETURN_AFTER_OBSERVE_END = 71;
/*     */   public static final int APPOINT_LEADER__FORBID_WHILE_OBSERVE = 72;
/*     */   public static final int TRY_AFTER_FLY = 80;
/*     */   public static final int TRY_AFTER_LEADER_FLY = 81;
/*     */   public static final int APPOINT_LEADER__FORBID_WHILE_FLYING = 82;
/*     */   public static final int RETURN_TEAM_AFTER_FLY_END = 83;
/*     */   public static final int FIRE_MEMBER_AFTER_FLY_END = 84;
/*     */   public static final int TEMP_LEAVE_AFTER_FLY_END = 84;
/*     */   public static final int ACTIVITY_TEAM__NO_TEAMS = 90;
/*     */   public static final int ACTIVITY_TEAM__NO_MEMBERS = 91;
/*     */   public static final int JOIN_TEAM__SUC = 100;
/*     */   public static final int JOIN_TEAM__INSTACNE_IN_INSTANCE = 101;
/*     */   public static final int JOIN_TEAM__INSTACNE_TEAM_IN_INSTANCE = 102;
/*     */   public static final int JOIN_TEAM__INSTACNE_XXX_IN_INSTANCE = 103;
/*     */   public static final int JOIN_TEAM__MULTI_INSTANCE_IN_MULTI = 104;
/*     */   public static final int JOIN_TEAM__MULTI_INSTANCE_TEAM_IN_MULTI = 105;
/*     */   public static final int JOIN_TEAM__MULTI_INSTANCE_XXX_IN_MULTI = 106;
/*     */   public static final int IN_SINGLE_INSTANCE = 107;
/*     */   public static final int JOIN_TEAM__ARENA_NOT_SAME_WORLD_INVITE_MEMBER = 110;
/*     */   public static final int JOIN_TEAM__ARENA_NOT_SAME_WORLD_APPLY_LEADER = 111;
/*     */   public static final int JOIN_TEAM__ARENA_NOT_SAME_CAMP_INVITE_MEMBER = 112;
/*     */   public static final int JOIN_TEAM__ARENA_NOT_SAME_CAMP_APPLY_LEADER = 113;
/*     */   public static final int JOIN_TEAM__ARENA_FULL_INVITE_MEMBER = 114;
/*     */   public static final int JOIN_TEAM__ARENA_FULL_APPLY_LEADER = 115;
/*     */   public static final int JOIN_TEAM__JIU_XIAO_LEADER = 121;
/*     */   public static final int JOIN_TEAM__JIU_XIAO_MEMBER = 122;
/*     */   public static final int JOIN_TEAM__JIU_XIAO_LEADER_MEMBER_STATUS = 123;
/*     */   public static final int JOIN_TEAM__JIU_XIAO_MEMBER_MEMBER_STATUS = 124;
/*     */   public static final int RETURN_TEAM_JIU_XIAO_MEMBER_STATUS_WRONG = 125;
/*     */   public static final int JOIN_TEAM__COMPETITION_NOT_SAME_FACTION_INVITE_MEMBER = 130;
/*     */   public static final int JOIN_TEAM__COMPETITION_NOT_SAME_FACTION_APPLY_LEADER = 131;
/*     */   public static final int JOIN_TEAM__COMPETITION_NOT_SAME_WORLD_INVITE_MEMBER = 132;
/*     */   public static final int JOIN_TEAM__COMPETITION_NOT_SAME_WORLD_APPLY_LEADER = 133;
/*     */   public static final int JOIN_TEAM__QMHW_LEADER = 141;
/*     */   public static final int JOIN_TEAM__QMHW_MEMBER = 142;
/*     */   public static final int JOIN_TEAM__QMHW_LEADER_MEMBER_STATUS = 143;
/*     */   public static final int JOIN_TEAM__QMHW_MEMBER_MEMBER_STATUS = 144;
/*     */   public static final int RETURN_TEAM_QMHW_MEMBER_STATUS_WRONG = 145;
/*     */   public static final int JOIN_TEAM__MASSWEDDING_LEADER = 161;
/*     */   public static final int JOIN_TEAM__MASSWEDDING_MEMBER = 162;
/*     */   public static final int JOIN_TEAM__MASSWEDDING_LEADER_SIGN_UP_LEADER = 163;
/*     */   public static final int JOIN_TEAM__MASSWEDDING_MEMBER_SIGN_UP_LEADER = 164;
/*     */   public static final int JOIN_TEAM__MASSWEDDING_LEADER_SIGN_UP_MEMBER = 165;
/*     */   public static final int JOIN_TEAM__MASSWEDDING_MEMBER_SIGN_UP_MEMBER = 166;
/*     */   public static final int LEAVE_TEAM__SUC = 1000;
/*     */   public static final int TEMP_LEAVE_TEAM__SUC = 2000;
/*     */   public static final int RETURN_TEAM__SUC = 3000;
/*     */   public static final int RETURN_TEAM__ERR_DIFF_WORLD = 3001;
/*     */   public static final int RETURN_TEAM__COMPETITION_NOT_SAME_WORLD = 3010;
/*     */   public static final int RETURN_TEAM__COMPETITION_NOT_SAME_FACTION = 3011;
/*     */   public static final int RETURN_TEAM__ARENA_NOT_SAME_WORLD = 3020;
/*     */   public static final int RETURN_TEAM__ARENA_NOT_SAME_CAMP = 3021;
/*     */   public static final int RETURN_TEAM__ARENA_FULL = 3022;
/*     */   public static final int RETURN_TEAM__MASSWEDDING_LEADER = 3030;
/*     */   public static final int DISMISS_TEAM__SUC = 4000;
/*     */   public static final int APPLY_TEAM__SUC = 5000;
/*     */   public static final int APPLY_TEAM__REFUSED_LEADER_ESCORT = 5001;
/*     */   public static final int APPLY_TEAM__REFUSED_YOU_ESCORT = 5002;
/*     */   public static final int INVITE_TEAM__SUC = 6000;
/*     */   public static final int INVITE_TEAM__REFUSED_ROLE_ESCORT = 6001;
/*     */   public static final int INVITE_TEAM__REFUSED_YOU_ESCORT = 6002;
/*     */   public static final int JOIN_TEAM__IN_ZHU_XIAN_JIAN_ZHEN = 7000;
/*     */   public static final int JOIN_TEAM__XXX_IN_ZHU_XIAN_JIAN_ZHEN = 7001;
/*     */   public static final int JOIN_TEAM__FACTION_PVE_NOT_SAME_WORLD_INVITE_MEMBER = 8000;
/*     */   public static final int JOIN_TEAM__FACTION_PVE_NOT_SAME_WORLD_APPLY_LEADER = 8001;
/*     */   public static final int RETURN_TEAM__FACTION_PVE_NOT_SAME_WORLD = 8002;
/*     */   public static final int JOIN_TEAM__IN_CROSS_BATTLE_ROUND_ROBIN = 8100;
/*     */   public static final int JOIN_TEAM__XXX_IN_CROSS_BATTLE_ROUND_ROBIN = 8101;
/*     */   public static final int JOIN_TEAM__CROSS_COMPETE_NOT_SAME_FACTION_INVITE_MEMBER = 8200;
/*     */   public static final int JOIN_TEAM__CROSS_COMPETE_NOT_SAME_FACTION_APPLY_LEADER = 8201;
/*     */   public static final int JOIN_TEAM__CROSS_COMPETE_NOT_SAME_WORLD_INVITE_MEMBER = 8202;
/*     */   public static final int JOIN_TEAM__CROSS_COMPETE_NOT_SAME_WORLD_APPLY_LEADER = 8203;
/*     */   public static final int RETURN_TEAM__CROSS_COMPETE_SAME_WORLD = 8250;
/*     */   public static final int RETURN_TEAM__CROSS_COMPETE_SAME_FACTION = 8251;
/*     */   public static final int JOIN_TEAM__PRISON_NOT_IN_JAIL_WORLD = 8300;
/*     */   public static final int JOIN_TEAM__PRISON_XXX_NOT_IN_JAIL_WORLD = 8301;
/*     */   public static final int JOIN_TEAM_PRISON_NOT_IN_SAME_AREA = 8302;
/*     */   public static final int JOIN_TEAM_PRISON_XXX_NOT_IN_SAME_AREA = 8303;
/*     */   public int result;
/*     */   public ArrayList<String> args;
/*     */   public STeamNormalResult()
/*     */   {
/* 140 */     this.args = new ArrayList();
/*     */   }
/*     */   
/*     */   public STeamNormalResult(int _result_, ArrayList<String> _args_) {
/* 144 */     this.result = _result_;
/* 145 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/* 149 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 153 */     _os_.marshal(this.result);
/* 154 */     _os_.compact_uint32(this.args.size());
/* 155 */     for (String _v_ : this.args) {
/* 156 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/* 158 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 162 */     this.result = _os_.unmarshal_int();
/* 163 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 165 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 166 */       this.args.add(_v_);
/*     */     }
/* 168 */     if (!_validator_()) {
/* 169 */       throw new VerifyError("validator failed");
/*     */     }
/* 171 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 175 */     if (_o1_ == this) return true;
/* 176 */     if ((_o1_ instanceof STeamNormalResult)) {
/* 177 */       STeamNormalResult _o_ = (STeamNormalResult)_o1_;
/* 178 */       if (this.result != _o_.result) return false;
/* 179 */       if (!this.args.equals(_o_.args)) return false;
/* 180 */       return true;
/*     */     }
/* 182 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 186 */     int _h_ = 0;
/* 187 */     _h_ += this.result;
/* 188 */     _h_ += this.args.hashCode();
/* 189 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 193 */     StringBuilder _sb_ = new StringBuilder();
/* 194 */     _sb_.append("(");
/* 195 */     _sb_.append(this.result).append(",");
/* 196 */     _sb_.append(this.args).append(",");
/* 197 */     _sb_.append(")");
/* 198 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\STeamNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */