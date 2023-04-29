/*    */ package mzm.gsp.team;
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
/*    */ public class SReqChangeZhenfa
/*    */   extends __SReqChangeZhenfa__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588320;
/*    */   public int changedzhenfaid;
/*    */   public int zhenfalevel;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588320;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SReqChangeZhenfa() {}
/*    */   
/*    */ 
/*    */   public SReqChangeZhenfa(int _changedzhenfaid_, int _zhenfalevel_)
/*    */   {
/* 37 */     this.changedzhenfaid = _changedzhenfaid_;
/* 38 */     this.zhenfalevel = _zhenfalevel_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.changedzhenfaid);
/* 47 */     _os_.marshal(this.zhenfalevel);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.changedzhenfaid = _os_.unmarshal_int();
/* 53 */     this.zhenfalevel = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SReqChangeZhenfa)) {
/* 63 */       SReqChangeZhenfa _o_ = (SReqChangeZhenfa)_o1_;
/* 64 */       if (this.changedzhenfaid != _o_.changedzhenfaid) return false;
/* 65 */       if (this.zhenfalevel != _o_.zhenfalevel) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.changedzhenfaid;
/* 74 */     _h_ += this.zhenfalevel;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.changedzhenfaid).append(",");
/* 82 */     _sb_.append(this.zhenfalevel).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SReqChangeZhenfa _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.changedzhenfaid - _o_.changedzhenfaid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.zhenfalevel - _o_.zhenfalevel;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\SReqChangeZhenfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */