/*    */ package mzm.gsp.fight;
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
/*    */ public class SDelCommandReq
/*    */   extends __SDelCommandReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594204;
/*    */   public int commandtype;
/*    */   public int commandindex;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594204;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SDelCommandReq() {}
/*    */   
/*    */ 
/*    */   public SDelCommandReq(int _commandtype_, int _commandindex_)
/*    */   {
/* 37 */     this.commandtype = _commandtype_;
/* 38 */     this.commandindex = _commandindex_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.commandtype);
/* 47 */     _os_.marshal(this.commandindex);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.commandtype = _os_.unmarshal_int();
/* 53 */     this.commandindex = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SDelCommandReq)) {
/* 63 */       SDelCommandReq _o_ = (SDelCommandReq)_o1_;
/* 64 */       if (this.commandtype != _o_.commandtype) return false;
/* 65 */       if (this.commandindex != _o_.commandindex) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.commandtype;
/* 74 */     _h_ += this.commandindex;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.commandtype).append(",");
/* 82 */     _sb_.append(this.commandindex).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SDelCommandReq _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.commandtype - _o_.commandtype;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.commandindex - _o_.commandindex;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SDelCommandReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */