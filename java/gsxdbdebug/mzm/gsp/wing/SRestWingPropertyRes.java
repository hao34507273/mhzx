/*    */ package mzm.gsp.wing;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SRestWingPropertyRes
/*    */   extends __SRestWingPropertyRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596499;
/*    */   public int index;
/*    */   public ArrayList<WingProperty> propertylist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12596499;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SRestWingPropertyRes()
/*    */   {
/* 32 */     this.propertylist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SRestWingPropertyRes(int _index_, ArrayList<WingProperty> _propertylist_) {
/* 36 */     this.index = _index_;
/* 37 */     this.propertylist = _propertylist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (WingProperty _v_ : this.propertylist)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.index);
/* 48 */     _os_.compact_uint32(this.propertylist.size());
/* 49 */     for (WingProperty _v_ : this.propertylist) {
/* 50 */       _os_.marshal(_v_);
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.index = _os_.unmarshal_int();
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 58 */       WingProperty _v_ = new WingProperty();
/* 59 */       _v_.unmarshal(_os_);
/* 60 */       this.propertylist.add(_v_);
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SRestWingPropertyRes)) {
/* 71 */       SRestWingPropertyRes _o_ = (SRestWingPropertyRes)_o1_;
/* 72 */       if (this.index != _o_.index) return false;
/* 73 */       if (!this.propertylist.equals(_o_.propertylist)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.index;
/* 82 */     _h_ += this.propertylist.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.index).append(",");
/* 90 */     _sb_.append(this.propertylist).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SRestWingPropertyRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */