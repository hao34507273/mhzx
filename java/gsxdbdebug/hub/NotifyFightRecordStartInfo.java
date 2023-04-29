/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class NotifyFightRecordStartInfo implements Marshal
/*    */ {
/*    */   public long recordid;
/*    */   public Octets start_content;
/*    */   
/*    */   public NotifyFightRecordStartInfo()
/*    */   {
/* 15 */     this.start_content = new Octets();
/*    */   }
/*    */   
/*    */   public NotifyFightRecordStartInfo(long _recordid_, Octets _start_content_) {
/* 19 */     this.recordid = _recordid_;
/* 20 */     this.start_content = _start_content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.recordid);
/* 29 */     _os_.marshal(this.start_content);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.recordid = _os_.unmarshal_long();
/* 35 */     this.start_content = _os_.unmarshal_Octets();
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 40 */     if (_o1_ == this) return true;
/* 41 */     if ((_o1_ instanceof NotifyFightRecordStartInfo)) {
/* 42 */       NotifyFightRecordStartInfo _o_ = (NotifyFightRecordStartInfo)_o1_;
/* 43 */       if (this.recordid != _o_.recordid) return false;
/* 44 */       if (!this.start_content.equals(_o_.start_content)) return false;
/* 45 */       return true;
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 51 */     int _h_ = 0;
/* 52 */     _h_ += (int)this.recordid;
/* 53 */     _h_ += this.start_content.hashCode();
/* 54 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 58 */     StringBuilder _sb_ = new StringBuilder();
/* 59 */     _sb_.append("(");
/* 60 */     _sb_.append(this.recordid).append(",");
/* 61 */     _sb_.append("B").append(this.start_content.size()).append(",");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\NotifyFightRecordStartInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */