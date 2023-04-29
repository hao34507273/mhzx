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
/*    */ 
/*    */ 
/*    */ public class SPetFightSetDefenseTeamFail
/*    */   extends __SPetFightSetDefenseTeamFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590684;
/*    */   public static final int EMPTY_TEAM = 1;
/*    */   public int reason;
/*    */   public int team;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590684;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SPetFightSetDefenseTeamFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public SPetFightSetDefenseTeamFail(int _reason_, int _team_)
/*    */   {
/* 39 */     this.reason = _reason_;
/* 40 */     this.team = _team_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.reason);
/* 49 */     _os_.marshal(this.team);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.reason = _os_.unmarshal_int();
/* 55 */     this.team = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SPetFightSetDefenseTeamFail)) {
/* 65 */       SPetFightSetDefenseTeamFail _o_ = (SPetFightSetDefenseTeamFail)_o1_;
/* 66 */       if (this.reason != _o_.reason) return false;
/* 67 */       if (this.team != _o_.team) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.reason;
/* 76 */     _h_ += this.team;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.reason).append(",");
/* 84 */     _sb_.append(this.team).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SPetFightSetDefenseTeamFail _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.reason - _o_.reason;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.team - _o_.team;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SPetFightSetDefenseTeamFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */