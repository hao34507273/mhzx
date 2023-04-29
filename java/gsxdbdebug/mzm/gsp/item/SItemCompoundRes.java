/*    */ package mzm.gsp.item;
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
/*    */ public class SItemCompoundRes
/*    */   extends __SItemCompoundRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584753;
/*    */   public int itemid;
/*    */   public int itemkey;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584753;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SItemCompoundRes() {}
/*    */   
/*    */ 
/*    */   public SItemCompoundRes(int _itemid_, int _itemkey_)
/*    */   {
/* 35 */     this.itemid = _itemid_;
/* 36 */     this.itemkey = _itemkey_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.itemid);
/* 45 */     _os_.marshal(this.itemkey);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.itemid = _os_.unmarshal_int();
/* 51 */     this.itemkey = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SItemCompoundRes)) {
/* 61 */       SItemCompoundRes _o_ = (SItemCompoundRes)_o1_;
/* 62 */       if (this.itemid != _o_.itemid) return false;
/* 63 */       if (this.itemkey != _o_.itemkey) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.itemid;
/* 72 */     _h_ += this.itemkey;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.itemid).append(",");
/* 80 */     _sb_.append(this.itemkey).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SItemCompoundRes _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.itemid - _o_.itemid;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.itemkey - _o_.itemkey;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SItemCompoundRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */