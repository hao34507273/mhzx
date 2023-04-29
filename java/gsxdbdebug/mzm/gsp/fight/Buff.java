/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Buff
/*    */   implements Marshal, Comparable<Buff>
/*    */ {
/*    */   public static final int DATA_CHANGE_MODEL_CARD = -1;
/*    */   public static final int LIFE_LINK_START = -10;
/*    */   public static final int LIFE_LINK_END = -29;
/*    */   public static final int BLACK_HOLE_START = -30;
/*    */   public static final int BLACK_HOLE_END = -49;
/*    */   public static final int MIRROR_FIGHTER_ID = -60;
/*    */   public static final int SYN_SKILL_KEY = -61;
/*    */   public static final int FIGHT_STATE_GROUP_START = -100;
/*    */   public static final int FIGHT_STATE_GROUP_END = -199;
/*    */   public static final int FIGHT_STATE_START = -300;
/*    */   public static final int FIGHT_STATE_END = -399;
/*    */   public int buffid;
/*    */   public int round;
/*    */   
/*    */   public Buff() {}
/*    */   
/*    */   public Buff(int _buffid_, int _round_)
/*    */   {
/* 30 */     this.buffid = _buffid_;
/* 31 */     this.round = _round_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 39 */     _os_.marshal(this.buffid);
/* 40 */     _os_.marshal(this.round);
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 45 */     this.buffid = _os_.unmarshal_int();
/* 46 */     this.round = _os_.unmarshal_int();
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof Buff)) {
/* 53 */       Buff _o_ = (Buff)_o1_;
/* 54 */       if (this.buffid != _o_.buffid) return false;
/* 55 */       if (this.round != _o_.round) return false;
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     _h_ += this.buffid;
/* 64 */     _h_ += this.round;
/* 65 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuilder _sb_ = new StringBuilder();
/* 70 */     _sb_.append("(");
/* 71 */     _sb_.append(this.buffid).append(",");
/* 72 */     _sb_.append(this.round).append(",");
/* 73 */     _sb_.append(")");
/* 74 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(Buff _o_) {
/* 78 */     if (_o_ == this) return 0;
/* 79 */     int _c_ = 0;
/* 80 */     _c_ = this.buffid - _o_.buffid;
/* 81 */     if (0 != _c_) return _c_;
/* 82 */     _c_ = this.round - _o_.round;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\Buff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */