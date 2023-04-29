/*    */ package mzm.gsp.wing;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ModelId2DyeId implements Marshal, Comparable<ModelId2DyeId>
/*    */ {
/*    */   public int modelid;
/*    */   public int dyeid;
/*    */   
/*    */   public ModelId2DyeId() {}
/*    */   
/*    */   public ModelId2DyeId(int _modelid_, int _dyeid_)
/*    */   {
/* 16 */     this.modelid = _modelid_;
/* 17 */     this.dyeid = _dyeid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.modelid);
/* 26 */     _os_.marshal(this.dyeid);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.modelid = _os_.unmarshal_int();
/* 32 */     this.dyeid = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof ModelId2DyeId)) {
/* 39 */       ModelId2DyeId _o_ = (ModelId2DyeId)_o1_;
/* 40 */       if (this.modelid != _o_.modelid) return false;
/* 41 */       if (this.dyeid != _o_.dyeid) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.modelid;
/* 50 */     _h_ += this.dyeid;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.modelid).append(",");
/* 58 */     _sb_.append(this.dyeid).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ModelId2DyeId _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.modelid - _o_.modelid;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.dyeid - _o_.dyeid;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\ModelId2DyeId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */