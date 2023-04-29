/*    */ package mzm.gsp.indiana;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class IndianaAwardInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int award_number;
/*    */   public long roleid;
/*    */   public Octets role_name;
/*    */   
/*    */   public IndianaAwardInfo()
/*    */   {
/* 14 */     this.role_name = new Octets();
/*    */   }
/*    */   
/*    */   public IndianaAwardInfo(int _award_number_, long _roleid_, Octets _role_name_) {
/* 18 */     this.award_number = _award_number_;
/* 19 */     this.roleid = _roleid_;
/* 20 */     this.role_name = _role_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.award_number);
/* 29 */     _os_.marshal(this.roleid);
/* 30 */     _os_.marshal(this.role_name);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 35 */     this.award_number = _os_.unmarshal_int();
/* 36 */     this.roleid = _os_.unmarshal_long();
/* 37 */     this.role_name = _os_.unmarshal_Octets();
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 42 */     if (_o1_ == this) return true;
/* 43 */     if ((_o1_ instanceof IndianaAwardInfo)) {
/* 44 */       IndianaAwardInfo _o_ = (IndianaAwardInfo)_o1_;
/* 45 */       if (this.award_number != _o_.award_number) return false;
/* 46 */       if (this.roleid != _o_.roleid) return false;
/* 47 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 48 */       return true;
/*    */     }
/* 50 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 54 */     int _h_ = 0;
/* 55 */     _h_ += this.award_number;
/* 56 */     _h_ += (int)this.roleid;
/* 57 */     _h_ += this.role_name.hashCode();
/* 58 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 62 */     StringBuilder _sb_ = new StringBuilder();
/* 63 */     _sb_.append("(");
/* 64 */     _sb_.append(this.award_number).append(",");
/* 65 */     _sb_.append(this.roleid).append(",");
/* 66 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 67 */     _sb_.append(")");
/* 68 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\IndianaAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */