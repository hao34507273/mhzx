/*    */ package gnet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class SetServerAttrArg implements Marshal
/*    */ {
/*    */   public Octets gmuserid;
/*    */   public int localsid;
/*    */   public int attribute;
/*    */   public int value;
/*    */   
/*    */   public SetServerAttrArg()
/*    */   {
/* 17 */     this.gmuserid = new Octets();
/*    */   }
/*    */   
/*    */   public SetServerAttrArg(Octets _gmuserid_, int _localsid_, int _attribute_, int _value_) {
/* 21 */     this.gmuserid = _gmuserid_;
/* 22 */     this.localsid = _localsid_;
/* 23 */     this.attribute = _attribute_;
/* 24 */     this.value = _value_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.gmuserid);
/* 33 */     _os_.marshal(this.localsid);
/* 34 */     _os_.marshal(this.attribute);
/* 35 */     _os_.marshal(this.value);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.gmuserid = _os_.unmarshal_Octets();
/* 41 */     this.localsid = _os_.unmarshal_int();
/* 42 */     this.attribute = _os_.unmarshal_int();
/* 43 */     this.value = _os_.unmarshal_int();
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 48 */     if (_o1_ == this) return true;
/* 49 */     if ((_o1_ instanceof SetServerAttrArg)) {
/* 50 */       SetServerAttrArg _o_ = (SetServerAttrArg)_o1_;
/* 51 */       if (!this.gmuserid.equals(_o_.gmuserid)) return false;
/* 52 */       if (this.localsid != _o_.localsid) return false;
/* 53 */       if (this.attribute != _o_.attribute) return false;
/* 54 */       if (this.value != _o_.value) return false;
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 61 */     int _h_ = 0;
/* 62 */     _h_ += this.gmuserid.hashCode();
/* 63 */     _h_ += this.localsid;
/* 64 */     _h_ += this.attribute;
/* 65 */     _h_ += this.value;
/* 66 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 70 */     StringBuilder _sb_ = new StringBuilder();
/* 71 */     _sb_.append("(");
/* 72 */     _sb_.append("B").append(this.gmuserid.size()).append(",");
/* 73 */     _sb_.append(this.localsid).append(",");
/* 74 */     _sb_.append(this.attribute).append(",");
/* 75 */     _sb_.append(this.value).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\SetServerAttrArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */