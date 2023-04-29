/*    */ package mzm.gsp.activity;
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
/*    */ public class SynLimitTimeActivityOpened
/*    */   extends __SynLimitTimeActivityOpened__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587560;
/*    */   public HashSet<Integer> activityids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12587560;
/*    */   }
/*    */   
/*    */ 
/*    */   public SynLimitTimeActivityOpened()
/*    */   {
/* 31 */     this.activityids = new HashSet();
/*    */   }
/*    */   
/*    */   public SynLimitTimeActivityOpened(HashSet<Integer> _activityids_) {
/* 35 */     this.activityids = _activityids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 43 */     _os_.compact_uint32(this.activityids.size());
/* 44 */     for (Integer _v_ : this.activityids) {
/* 45 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 53 */       int _v_ = _os_.unmarshal_int();
/* 54 */       this.activityids.add(Integer.valueOf(_v_));
/*    */     }
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SynLimitTimeActivityOpened)) {
/* 65 */       SynLimitTimeActivityOpened _o_ = (SynLimitTimeActivityOpened)_o1_;
/* 66 */       if (!this.activityids.equals(_o_.activityids)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.activityids.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.activityids).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SynLimitTimeActivityOpened.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */