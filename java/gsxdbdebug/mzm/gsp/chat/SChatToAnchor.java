/*    */ package mzm.gsp.chat;
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
/*    */ public class SChatToAnchor
/*    */   extends __SChatToAnchor__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585242;
/*    */   public int senderzoneid;
/*    */   public int senderroomtype;
/*    */   public Octets chatcontent;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12585242;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SChatToAnchor()
/*    */   {
/* 35 */     this.chatcontent = new Octets();
/*    */   }
/*    */   
/*    */   public SChatToAnchor(int _senderzoneid_, int _senderroomtype_, Octets _chatcontent_) {
/* 39 */     this.senderzoneid = _senderzoneid_;
/* 40 */     this.senderroomtype = _senderroomtype_;
/* 41 */     this.chatcontent = _chatcontent_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.senderzoneid);
/* 50 */     _os_.marshal(this.senderroomtype);
/* 51 */     _os_.marshal(this.chatcontent);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.senderzoneid = _os_.unmarshal_int();
/* 57 */     this.senderroomtype = _os_.unmarshal_int();
/* 58 */     this.chatcontent = _os_.unmarshal_Octets();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SChatToAnchor)) {
/* 68 */       SChatToAnchor _o_ = (SChatToAnchor)_o1_;
/* 69 */       if (this.senderzoneid != _o_.senderzoneid) return false;
/* 70 */       if (this.senderroomtype != _o_.senderroomtype) return false;
/* 71 */       if (!this.chatcontent.equals(_o_.chatcontent)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.senderzoneid;
/* 80 */     _h_ += this.senderroomtype;
/* 81 */     _h_ += this.chatcontent.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.senderzoneid).append(",");
/* 89 */     _sb_.append(this.senderroomtype).append(",");
/* 90 */     _sb_.append("B").append(this.chatcontent.size()).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SChatToAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */