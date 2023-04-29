/*    */ package mzm.gsp.superequipment;
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
/*    */ public class SUseWuShiItemResponse
/*    */   extends __SUseWuShiItemResponse__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618771;
/*    */   public static final int GET_WU_SHI = 1;
/*    */   public static final int SHOW_WU_SHI = 2;
/*    */   public int opt;
/*    */   public int wushicfgid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12618771;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUseWuShiItemResponse() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUseWuShiItemResponse(int _opt_, int _wushicfgid_)
/*    */   {
/* 40 */     this.opt = _opt_;
/* 41 */     this.wushicfgid = _wushicfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.opt);
/* 50 */     _os_.marshal(this.wushicfgid);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.opt = _os_.unmarshal_int();
/* 56 */     this.wushicfgid = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SUseWuShiItemResponse)) {
/* 66 */       SUseWuShiItemResponse _o_ = (SUseWuShiItemResponse)_o1_;
/* 67 */       if (this.opt != _o_.opt) return false;
/* 68 */       if (this.wushicfgid != _o_.wushicfgid) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.opt;
/* 77 */     _h_ += this.wushicfgid;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.opt).append(",");
/* 85 */     _sb_.append(this.wushicfgid).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUseWuShiItemResponse _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.opt - _o_.opt;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.wushicfgid - _o_.wushicfgid;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\SUseWuShiItemResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */