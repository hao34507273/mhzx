/*    */ package mzm.gsp.homeland;
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
/*    */ public class SMoveFurnitureRes
/*    */   extends __SMoveFurnitureRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605463;
/*    */   public long furnitureuuid;
/*    */   public DisplayFurnitureInfo furnitureinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12605463;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SMoveFurnitureRes()
/*    */   {
/* 34 */     this.furnitureinfo = new DisplayFurnitureInfo();
/*    */   }
/*    */   
/*    */   public SMoveFurnitureRes(long _furnitureuuid_, DisplayFurnitureInfo _furnitureinfo_) {
/* 38 */     this.furnitureuuid = _furnitureuuid_;
/* 39 */     this.furnitureinfo = _furnitureinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.furnitureinfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.furnitureuuid);
/* 49 */     _os_.marshal(this.furnitureinfo);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.furnitureuuid = _os_.unmarshal_long();
/* 55 */     this.furnitureinfo.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SMoveFurnitureRes)) {
/* 65 */       SMoveFurnitureRes _o_ = (SMoveFurnitureRes)_o1_;
/* 66 */       if (this.furnitureuuid != _o_.furnitureuuid) return false;
/* 67 */       if (!this.furnitureinfo.equals(_o_.furnitureinfo)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.furnitureuuid;
/* 76 */     _h_ += this.furnitureinfo.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.furnitureuuid).append(",");
/* 84 */     _sb_.append(this.furnitureinfo).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SMoveFurnitureRes _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = Long.signum(this.furnitureuuid - _o_.furnitureuuid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.furnitureinfo.compareTo(_o_.furnitureinfo);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SMoveFurnitureRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */