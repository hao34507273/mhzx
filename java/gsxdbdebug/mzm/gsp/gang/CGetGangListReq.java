/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.gang.main.PGetGangListReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetGangListReq
/*    */   extends __CGetGangListReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589880;
/*    */   public long lastid;
/*    */   public int size;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     new PGetGangListReq(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589880;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetGangListReq() {}
/*    */   
/*    */ 
/*    */   public CGetGangListReq(long _lastid_, int _size_)
/*    */   {
/* 37 */     this.lastid = _lastid_;
/* 38 */     this.size = _size_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.lastid);
/* 47 */     _os_.marshal(this.size);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.lastid = _os_.unmarshal_long();
/* 53 */     this.size = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof CGetGangListReq)) {
/* 63 */       CGetGangListReq _o_ = (CGetGangListReq)_o1_;
/* 64 */       if (this.lastid != _o_.lastid) return false;
/* 65 */       if (this.size != _o_.size) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.lastid;
/* 74 */     _h_ += this.size;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.lastid).append(",");
/* 82 */     _sb_.append(this.size).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetGangListReq _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.lastid - _o_.lastid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.size - _o_.size;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CGetGangListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */