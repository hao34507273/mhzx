/*    */ package mzm.gsp.guide;
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
/*    */ 
/*    */ public class CSelectPet
/*    */   extends __CSelectPet__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594950;
/*    */   public int guideid;
/*    */   public int petid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 28 */     return 12594950;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CSelectPet() {}
/*    */   
/*    */ 
/*    */   public CSelectPet(int _guideid_, int _petid_)
/*    */   {
/* 38 */     this.guideid = _guideid_;
/* 39 */     this.petid = _petid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.guideid);
/* 48 */     _os_.marshal(this.petid);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.guideid = _os_.unmarshal_int();
/* 54 */     this.petid = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CSelectPet)) {
/* 64 */       CSelectPet _o_ = (CSelectPet)_o1_;
/* 65 */       if (this.guideid != _o_.guideid) return false;
/* 66 */       if (this.petid != _o_.petid) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.guideid;
/* 75 */     _h_ += this.petid;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.guideid).append(",");
/* 83 */     _sb_.append(this.petid).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CSelectPet _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.guideid - _o_.guideid;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.petid - _o_.petid;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\CSelectPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */