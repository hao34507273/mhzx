/*    */ package mzm.gsp.xiaohuikuaipao;
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
/*    */ public class SOuterInfoRsp
/*    */   extends __SOuterInfoRsp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12622854;
/*    */   public int activityid;
/*    */   public OuterInfo turninfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12622854;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SOuterInfoRsp()
/*    */   {
/* 32 */     this.turninfo = new OuterInfo();
/*    */   }
/*    */   
/*    */   public SOuterInfoRsp(int _activityid_, OuterInfo _turninfo_) {
/* 36 */     this.activityid = _activityid_;
/* 37 */     this.turninfo = _turninfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.turninfo._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.activityid);
/* 47 */     _os_.marshal(this.turninfo);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.activityid = _os_.unmarshal_int();
/* 53 */     this.turninfo.unmarshal(_os_);
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SOuterInfoRsp)) {
/* 63 */       SOuterInfoRsp _o_ = (SOuterInfoRsp)_o1_;
/* 64 */       if (this.activityid != _o_.activityid) return false;
/* 65 */       if (!this.turninfo.equals(_o_.turninfo)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.activityid;
/* 74 */     _h_ += this.turninfo.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.activityid).append(",");
/* 82 */     _sb_.append(this.turninfo).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SOuterInfoRsp _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.activityid - _o_.activityid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.turninfo.compareTo(_o_.turninfo);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\SOuterInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */