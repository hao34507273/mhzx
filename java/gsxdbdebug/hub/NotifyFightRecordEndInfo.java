/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class NotifyFightRecordEndInfo implements Marshal
/*    */ {
/*    */   public long recordid;
/*    */   public int max_round;
/*    */   public Octets end_content;
/*    */   
/*    */   public NotifyFightRecordEndInfo()
/*    */   {
/* 16 */     this.end_content = new Octets();
/*    */   }
/*    */   
/*    */   public NotifyFightRecordEndInfo(long _recordid_, int _max_round_, Octets _end_content_) {
/* 20 */     this.recordid = _recordid_;
/* 21 */     this.max_round = _max_round_;
/* 22 */     this.end_content = _end_content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.recordid);
/* 31 */     _os_.marshal(this.max_round);
/* 32 */     _os_.marshal(this.end_content);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.recordid = _os_.unmarshal_long();
/* 38 */     this.max_round = _os_.unmarshal_int();
/* 39 */     this.end_content = _os_.unmarshal_Octets();
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 44 */     if (_o1_ == this) return true;
/* 45 */     if ((_o1_ instanceof NotifyFightRecordEndInfo)) {
/* 46 */       NotifyFightRecordEndInfo _o_ = (NotifyFightRecordEndInfo)_o1_;
/* 47 */       if (this.recordid != _o_.recordid) return false;
/* 48 */       if (this.max_round != _o_.max_round) return false;
/* 49 */       if (!this.end_content.equals(_o_.end_content)) return false;
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 56 */     int _h_ = 0;
/* 57 */     _h_ += (int)this.recordid;
/* 58 */     _h_ += this.max_round;
/* 59 */     _h_ += this.end_content.hashCode();
/* 60 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 64 */     StringBuilder _sb_ = new StringBuilder();
/* 65 */     _sb_.append("(");
/* 66 */     _sb_.append(this.recordid).append(",");
/* 67 */     _sb_.append(this.max_round).append(",");
/* 68 */     _sb_.append("B").append(this.end_content.size()).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\NotifyFightRecordEndInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */