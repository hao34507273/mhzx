/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.gang.main.PSendLastReadAnnouncementTime;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSendLastAnnouncementTime
/*    */   extends __CSendLastAnnouncementTime__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589901;
/*    */   public long timestamp;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     new PSendLastReadAnnouncementTime(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589901;
/*    */   }
/*    */   
/*    */ 
/*    */   public CSendLastAnnouncementTime() {}
/*    */   
/*    */ 
/*    */   public CSendLastAnnouncementTime(long _timestamp_)
/*    */   {
/* 36 */     this.timestamp = _timestamp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.timestamp);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.timestamp = _os_.unmarshal_long();
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof CSendLastAnnouncementTime)) {
/* 59 */       CSendLastAnnouncementTime _o_ = (CSendLastAnnouncementTime)_o1_;
/* 60 */       if (this.timestamp != _o_.timestamp) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += (int)this.timestamp;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.timestamp).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CSendLastAnnouncementTime _o_) {
/* 81 */     if (_o_ == this) return 0;
/* 82 */     int _c_ = 0;
/* 83 */     _c_ = Long.signum(this.timestamp - _o_.timestamp);
/* 84 */     if (0 != _c_) return _c_;
/* 85 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CSendLastAnnouncementTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */