/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class NotifyCrossCompeteAgainstReq implements Marshal
/*    */ {
/*    */   public long start_millis;
/*    */   public ArrayList<CrossCompeteAgainst> againsts;
/*    */   
/*    */   public NotifyCrossCompeteAgainstReq()
/*    */   {
/* 15 */     this.againsts = new ArrayList();
/*    */   }
/*    */   
/*    */   public NotifyCrossCompeteAgainstReq(long _start_millis_, ArrayList<CrossCompeteAgainst> _againsts_) {
/* 19 */     this.start_millis = _start_millis_;
/* 20 */     this.againsts = _againsts_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     for (CrossCompeteAgainst _v_ : this.againsts)
/* 25 */       if (!_v_._validator_()) return false;
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.start_millis);
/* 31 */     _os_.compact_uint32(this.againsts.size());
/* 32 */     for (CrossCompeteAgainst _v_ : this.againsts) {
/* 33 */       _os_.marshal(_v_);
/*    */     }
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 39 */     this.start_millis = _os_.unmarshal_long();
/* 40 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 41 */       CrossCompeteAgainst _v_ = new CrossCompeteAgainst();
/* 42 */       _v_.unmarshal(_os_);
/* 43 */       this.againsts.add(_v_);
/*    */     }
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof NotifyCrossCompeteAgainstReq)) {
/* 51 */       NotifyCrossCompeteAgainstReq _o_ = (NotifyCrossCompeteAgainstReq)_o1_;
/* 52 */       if (this.start_millis != _o_.start_millis) return false;
/* 53 */       if (!this.againsts.equals(_o_.againsts)) return false;
/* 54 */       return true;
/*    */     }
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 60 */     int _h_ = 0;
/* 61 */     _h_ += (int)this.start_millis;
/* 62 */     _h_ += this.againsts.hashCode();
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this.start_millis).append(",");
/* 70 */     _sb_.append(this.againsts).append(",");
/* 71 */     _sb_.append(")");
/* 72 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\NotifyCrossCompeteAgainstReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */