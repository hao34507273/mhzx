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
/*    */ public class SPetFightImproveFormationFail
/*    */   extends __SPetFightImproveFormationFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590694;
/*    */   public static final int INVALID_ITEM = 1;
/*    */   public static final int ITEM_NOT_EXISTS = 2;
/*    */   public static final int REACH_MAX_LEVEL = 3;
/*    */   public static final int USE_FRAGMENT_ON_LOCKED_FORMATION = 4;
/*    */   public int reason;
/*    */   public int formation_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590694;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SPetFightImproveFormationFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SPetFightImproveFormationFail(int _reason_, int _formation_id_)
/*    */   {
/* 42 */     this.reason = _reason_;
/* 43 */     this.formation_id = _formation_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.reason);
/* 52 */     _os_.marshal(this.formation_id);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.reason = _os_.unmarshal_int();
/* 58 */     this.formation_id = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SPetFightImproveFormationFail)) {
/* 68 */       SPetFightImproveFormationFail _o_ = (SPetFightImproveFormationFail)_o1_;
/* 69 */       if (this.reason != _o_.reason) return false;
/* 70 */       if (this.formation_id != _o_.formation_id) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.reason;
/* 79 */     _h_ += this.formation_id;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.reason).append(",");
/* 87 */     _sb_.append(this.formation_id).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SPetFightImproveFormationFail _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.reason - _o_.reason;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.formation_id - _o_.formation_id;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SPetFightImproveFormationFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */