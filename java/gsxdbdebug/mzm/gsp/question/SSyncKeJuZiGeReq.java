/*    */ package mzm.gsp.question;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
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
/*    */ public class SSyncKeJuZiGeReq
/*    */   extends __SSyncKeJuZiGeReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594713;
/*    */   public ArrayList<KeJuState> kejustate;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594713;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSyncKeJuZiGeReq()
/*    */   {
/* 33 */     this.kejustate = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSyncKeJuZiGeReq(ArrayList<KeJuState> _kejustate_) {
/* 37 */     this.kejustate = _kejustate_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (KeJuState _v_ : this.kejustate)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.kejustate.size());
/* 48 */     for (KeJuState _v_ : this.kejustate) {
/* 49 */       _os_.marshal(_v_);
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 56 */       KeJuState _v_ = new KeJuState();
/* 57 */       _v_.unmarshal(_os_);
/* 58 */       this.kejustate.add(_v_);
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SSyncKeJuZiGeReq)) {
/* 69 */       SSyncKeJuZiGeReq _o_ = (SSyncKeJuZiGeReq)_o1_;
/* 70 */       if (!this.kejustate.equals(_o_.kejustate)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.kejustate.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.kejustate).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\SSyncKeJuZiGeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */