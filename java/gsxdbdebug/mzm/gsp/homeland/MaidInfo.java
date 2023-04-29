/*    */ package mzm.gsp.homeland;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class MaidInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int maidid;
/*    */   public Octets name;
/*    */   
/*    */   public MaidInfo()
/*    */   {
/* 13 */     this.name = new Octets();
/*    */   }
/*    */   
/*    */   public MaidInfo(int _maidid_, Octets _name_) {
/* 17 */     this.maidid = _maidid_;
/* 18 */     this.name = _name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.marshal(this.maidid);
/* 27 */     _os_.marshal(this.name);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 32 */     this.maidid = _os_.unmarshal_int();
/* 33 */     this.name = _os_.unmarshal_Octets();
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 38 */     if (_o1_ == this) return true;
/* 39 */     if ((_o1_ instanceof MaidInfo)) {
/* 40 */       MaidInfo _o_ = (MaidInfo)_o1_;
/* 41 */       if (this.maidid != _o_.maidid) return false;
/* 42 */       if (!this.name.equals(_o_.name)) return false;
/* 43 */       return true;
/*    */     }
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 49 */     int _h_ = 0;
/* 50 */     _h_ += this.maidid;
/* 51 */     _h_ += this.name.hashCode();
/* 52 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 56 */     StringBuilder _sb_ = new StringBuilder();
/* 57 */     _sb_.append("(");
/* 58 */     _sb_.append(this.maidid).append(",");
/* 59 */     _sb_.append("B").append(this.name.size()).append(",");
/* 60 */     _sb_.append(")");
/* 61 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\MaidInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */