/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
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
/*    */ public class SSynObserveEnd
/*    */   extends __SSynObserveEnd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594194;
/*    */   public HashSet<Long> roleids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594194;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynObserveEnd()
/*    */   {
/* 33 */     this.roleids = new HashSet();
/*    */   }
/*    */   
/*    */   public SSynObserveEnd(HashSet<Long> _roleids_) {
/* 37 */     this.roleids = _roleids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.roleids.size());
/* 46 */     for (Long _v_ : this.roleids) {
/* 47 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 55 */       long _v_ = _os_.unmarshal_long();
/* 56 */       this.roleids.add(Long.valueOf(_v_));
/*    */     }
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SSynObserveEnd)) {
/* 67 */       SSynObserveEnd _o_ = (SSynObserveEnd)_o1_;
/* 68 */       if (!this.roleids.equals(_o_.roleids)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.roleids.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.roleids).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SSynObserveEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */