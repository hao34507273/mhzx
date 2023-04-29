/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SPetFightSetPositionFail
/*    */   extends __SPetFightSetPositionFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590701;
/*    */   public static final int PET_NOT_EXISTS = 1;
/*    */   public static final int PET_NOT_BOUND = 2;
/*    */   public static final int REMOVE_LAST_PET_IN_DEFENSE_TEAM = 3;
/*    */   public int reason;
/*    */   public int team;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590701;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SPetFightSetPositionFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SPetFightSetPositionFail(int _reason_, int _team_)
/*    */   {
/* 41 */     this.reason = _reason_;
/* 42 */     this.team = _team_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.reason);
/* 51 */     _os_.marshal(this.team);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.reason = _os_.unmarshal_int();
/* 57 */     this.team = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SPetFightSetPositionFail)) {
/* 67 */       SPetFightSetPositionFail _o_ = (SPetFightSetPositionFail)_o1_;
/* 68 */       if (this.reason != _o_.reason) return false;
/* 69 */       if (this.team != _o_.team) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.reason;
/* 78 */     _h_ += this.team;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.reason).append(",");
/* 86 */     _sb_.append(this.team).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SPetFightSetPositionFail _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.reason - _o_.reason;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.team - _o_.team;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SPetFightSetPositionFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */