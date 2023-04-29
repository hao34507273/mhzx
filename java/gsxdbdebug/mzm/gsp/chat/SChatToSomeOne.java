/*    */ package mzm.gsp.chat;
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
/*    */ public class SChatToSomeOne
/*    */   extends __SChatToSomeOne__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585217;
/*    */   public ChatContent chatcontent;
/*    */   public long senderid;
/*    */   public long listenerid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12585217;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SChatToSomeOne()
/*    */   {
/* 33 */     this.chatcontent = new ChatContent();
/*    */   }
/*    */   
/*    */   public SChatToSomeOne(ChatContent _chatcontent_, long _senderid_, long _listenerid_) {
/* 37 */     this.chatcontent = _chatcontent_;
/* 38 */     this.senderid = _senderid_;
/* 39 */     this.listenerid = _listenerid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.chatcontent._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.chatcontent);
/* 49 */     _os_.marshal(this.senderid);
/* 50 */     _os_.marshal(this.listenerid);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.chatcontent.unmarshal(_os_);
/* 56 */     this.senderid = _os_.unmarshal_long();
/* 57 */     this.listenerid = _os_.unmarshal_long();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SChatToSomeOne)) {
/* 67 */       SChatToSomeOne _o_ = (SChatToSomeOne)_o1_;
/* 68 */       if (!this.chatcontent.equals(_o_.chatcontent)) return false;
/* 69 */       if (this.senderid != _o_.senderid) return false;
/* 70 */       if (this.listenerid != _o_.listenerid) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.chatcontent.hashCode();
/* 79 */     _h_ += (int)this.senderid;
/* 80 */     _h_ += (int)this.listenerid;
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.chatcontent).append(",");
/* 88 */     _sb_.append(this.senderid).append(",");
/* 89 */     _sb_.append(this.listenerid).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SChatToSomeOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */