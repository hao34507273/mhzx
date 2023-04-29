/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSyncRecordRoundPlay
/*    */   extends __SSyncRecordRoundPlay__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594214;
/*    */   public long recordid;
/*    */   public int round;
/*    */   public Octets round_play_content;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594214;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSyncRecordRoundPlay()
/*    */   {
/* 35 */     this.round_play_content = new Octets();
/*    */   }
/*    */   
/*    */   public SSyncRecordRoundPlay(long _recordid_, int _round_, Octets _round_play_content_) {
/* 39 */     this.recordid = _recordid_;
/* 40 */     this.round = _round_;
/* 41 */     this.round_play_content = _round_play_content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.recordid);
/* 50 */     _os_.marshal(this.round);
/* 51 */     _os_.marshal(this.round_play_content);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.recordid = _os_.unmarshal_long();
/* 57 */     this.round = _os_.unmarshal_int();
/* 58 */     this.round_play_content = _os_.unmarshal_Octets();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SSyncRecordRoundPlay)) {
/* 68 */       SSyncRecordRoundPlay _o_ = (SSyncRecordRoundPlay)_o1_;
/* 69 */       if (this.recordid != _o_.recordid) return false;
/* 70 */       if (this.round != _o_.round) return false;
/* 71 */       if (!this.round_play_content.equals(_o_.round_play_content)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += (int)this.recordid;
/* 80 */     _h_ += this.round;
/* 81 */     _h_ += this.round_play_content.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.recordid).append(",");
/* 89 */     _sb_.append(this.round).append(",");
/* 90 */     _sb_.append("B").append(this.round_play_content.size()).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SSyncRecordRoundPlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */