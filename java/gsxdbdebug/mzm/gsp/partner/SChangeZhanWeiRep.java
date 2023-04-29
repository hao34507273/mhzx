/*    */ package mzm.gsp.partner;
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
/*    */ public class SChangeZhanWeiRep
/*    */   extends __SChangeZhanWeiRep__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588044;
/*    */   public int lineupnum;
/*    */   public LineUp lineup;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588044;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SChangeZhanWeiRep()
/*    */   {
/* 34 */     this.lineup = new LineUp();
/*    */   }
/*    */   
/*    */   public SChangeZhanWeiRep(int _lineupnum_, LineUp _lineup_) {
/* 38 */     this.lineupnum = _lineupnum_;
/* 39 */     this.lineup = _lineup_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.lineup._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.lineupnum);
/* 49 */     _os_.marshal(this.lineup);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.lineupnum = _os_.unmarshal_int();
/* 55 */     this.lineup.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SChangeZhanWeiRep)) {
/* 65 */       SChangeZhanWeiRep _o_ = (SChangeZhanWeiRep)_o1_;
/* 66 */       if (this.lineupnum != _o_.lineupnum) return false;
/* 67 */       if (!this.lineup.equals(_o_.lineup)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.lineupnum;
/* 76 */     _h_ += this.lineup.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.lineupnum).append(",");
/* 84 */     _sb_.append(this.lineup).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\SChangeZhanWeiRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */