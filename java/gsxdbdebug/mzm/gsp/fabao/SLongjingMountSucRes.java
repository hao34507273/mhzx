/*    */ package mzm.gsp.fabao;
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
/*    */ public class SLongjingMountSucRes
/*    */   extends __SLongjingMountSucRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596010;
/*    */   public int itemid;
/*    */   public int pos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12596010;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SLongjingMountSucRes() {}
/*    */   
/*    */ 
/*    */   public SLongjingMountSucRes(int _itemid_, int _pos_)
/*    */   {
/* 37 */     this.itemid = _itemid_;
/* 38 */     this.pos = _pos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.itemid);
/* 47 */     _os_.marshal(this.pos);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.itemid = _os_.unmarshal_int();
/* 53 */     this.pos = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SLongjingMountSucRes)) {
/* 63 */       SLongjingMountSucRes _o_ = (SLongjingMountSucRes)_o1_;
/* 64 */       if (this.itemid != _o_.itemid) return false;
/* 65 */       if (this.pos != _o_.pos) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.itemid;
/* 74 */     _h_ += this.pos;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.itemid).append(",");
/* 82 */     _sb_.append(this.pos).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SLongjingMountSucRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.itemid - _o_.itemid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.pos - _o_.pos;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\SLongjingMountSucRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */