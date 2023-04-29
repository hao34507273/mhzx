/*    */ package mzm.gsp.partneryuanshen;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class PartnerYuanshenPositionInfo
/*    */   implements Marshal, Comparable<PartnerYuanshenPositionInfo>
/*    */ {
/*    */   public int attached_partner_id;
/*    */   public int level;
/*    */   public int property;
/*    */   
/*    */   public PartnerYuanshenPositionInfo() {}
/*    */   
/*    */   public PartnerYuanshenPositionInfo(int _attached_partner_id_, int _level_, int _property_)
/*    */   {
/* 19 */     this.attached_partner_id = _attached_partner_id_;
/* 20 */     this.level = _level_;
/* 21 */     this.property = _property_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.attached_partner_id);
/* 30 */     _os_.marshal(this.level);
/* 31 */     _os_.marshal(this.property);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.attached_partner_id = _os_.unmarshal_int();
/* 37 */     this.level = _os_.unmarshal_int();
/* 38 */     this.property = _os_.unmarshal_int();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof PartnerYuanshenPositionInfo)) {
/* 45 */       PartnerYuanshenPositionInfo _o_ = (PartnerYuanshenPositionInfo)_o1_;
/* 46 */       if (this.attached_partner_id != _o_.attached_partner_id) return false;
/* 47 */       if (this.level != _o_.level) return false;
/* 48 */       if (this.property != _o_.property) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.attached_partner_id;
/* 57 */     _h_ += this.level;
/* 58 */     _h_ += this.property;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.attached_partner_id).append(",");
/* 66 */     _sb_.append(this.level).append(",");
/* 67 */     _sb_.append(this.property).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(PartnerYuanshenPositionInfo _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = this.attached_partner_id - _o_.attached_partner_id;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.level - _o_.level;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = this.property - _o_.property;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\PartnerYuanshenPositionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */