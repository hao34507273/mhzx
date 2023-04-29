/*    */ package mzm.gsp.lonngboatrace;
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
/*    */ public class SEntry
/*    */   extends __SEntry__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619265;
/*    */   public int raceid;
/*    */   public long matchbegintimestamp;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12619265;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SEntry() {}
/*    */   
/*    */ 
/*    */   public SEntry(int _raceid_, long _matchbegintimestamp_)
/*    */   {
/* 37 */     this.raceid = _raceid_;
/* 38 */     this.matchbegintimestamp = _matchbegintimestamp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.raceid);
/* 47 */     _os_.marshal(this.matchbegintimestamp);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.raceid = _os_.unmarshal_int();
/* 53 */     this.matchbegintimestamp = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SEntry)) {
/* 63 */       SEntry _o_ = (SEntry)_o1_;
/* 64 */       if (this.raceid != _o_.raceid) return false;
/* 65 */       if (this.matchbegintimestamp != _o_.matchbegintimestamp) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.raceid;
/* 74 */     _h_ += (int)this.matchbegintimestamp;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.raceid).append(",");
/* 82 */     _sb_.append(this.matchbegintimestamp).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SEntry _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.raceid - _o_.raceid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.matchbegintimestamp - _o_.matchbegintimestamp);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\SEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */