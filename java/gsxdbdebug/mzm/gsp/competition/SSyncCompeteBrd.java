/*    */ package mzm.gsp.competition;
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
/*    */ 
/*    */ public class SSyncCompeteBrd
/*    */   extends __SSyncCompeteBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12598535;
/*    */   public CompeteFaction faction1;
/*    */   public CompeteFaction faction2;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12598535;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncCompeteBrd()
/*    */   {
/* 34 */     this.faction1 = new CompeteFaction();
/* 35 */     this.faction2 = new CompeteFaction();
/*    */   }
/*    */   
/*    */   public SSyncCompeteBrd(CompeteFaction _faction1_, CompeteFaction _faction2_) {
/* 39 */     this.faction1 = _faction1_;
/* 40 */     this.faction2 = _faction2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     if (!this.faction1._validator_()) return false;
/* 45 */     if (!this.faction2._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.faction1);
/* 51 */     _os_.marshal(this.faction2);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.faction1.unmarshal(_os_);
/* 57 */     this.faction2.unmarshal(_os_);
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SSyncCompeteBrd)) {
/* 67 */       SSyncCompeteBrd _o_ = (SSyncCompeteBrd)_o1_;
/* 68 */       if (!this.faction1.equals(_o_.faction1)) return false;
/* 69 */       if (!this.faction2.equals(_o_.faction2)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.faction1.hashCode();
/* 78 */     _h_ += this.faction2.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.faction1).append(",");
/* 86 */     _sb_.append(this.faction2).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncCompeteBrd _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.faction1.compareTo(_o_.faction1);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.faction2.compareTo(_o_.faction2);
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\SSyncCompeteBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */