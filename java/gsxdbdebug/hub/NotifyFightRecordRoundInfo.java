/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class NotifyFightRecordRoundInfo implements Marshal
/*    */ {
/*    */   public long recordid;
/*    */   public int round;
/*    */   public Octets round_content;
/*    */   
/*    */   public NotifyFightRecordRoundInfo()
/*    */   {
/* 16 */     this.round_content = new Octets();
/*    */   }
/*    */   
/*    */   public NotifyFightRecordRoundInfo(long _recordid_, int _round_, Octets _round_content_) {
/* 20 */     this.recordid = _recordid_;
/* 21 */     this.round = _round_;
/* 22 */     this.round_content = _round_content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.recordid);
/* 31 */     _os_.marshal(this.round);
/* 32 */     _os_.marshal(this.round_content);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.recordid = _os_.unmarshal_long();
/* 38 */     this.round = _os_.unmarshal_int();
/* 39 */     this.round_content = _os_.unmarshal_Octets();
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 44 */     if (_o1_ == this) return true;
/* 45 */     if ((_o1_ instanceof NotifyFightRecordRoundInfo)) {
/* 46 */       NotifyFightRecordRoundInfo _o_ = (NotifyFightRecordRoundInfo)_o1_;
/* 47 */       if (this.recordid != _o_.recordid) return false;
/* 48 */       if (this.round != _o_.round) return false;
/* 49 */       if (!this.round_content.equals(_o_.round_content)) return false;
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 56 */     int _h_ = 0;
/* 57 */     _h_ += (int)this.recordid;
/* 58 */     _h_ += this.round;
/* 59 */     _h_ += this.round_content.hashCode();
/* 60 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 64 */     StringBuilder _sb_ = new StringBuilder();
/* 65 */     _sb_.append("(");
/* 66 */     _sb_.append(this.recordid).append(",");
/* 67 */     _sb_.append(this.round).append(",");
/* 68 */     _sb_.append("B").append(this.round_content.size()).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\NotifyFightRecordRoundInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */