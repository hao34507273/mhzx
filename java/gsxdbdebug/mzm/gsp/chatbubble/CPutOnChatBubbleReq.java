/*    */ package mzm.gsp.chatbubble;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.chatbubble.main.PCPutOnChatBubbleReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CPutOnChatBubbleReq
/*    */   extends __CPutOnChatBubbleReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12621832;
/*    */   public int chatbubblecfgid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId <= 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCPutOnChatBubbleReq(roleId, this.chatbubblecfgid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12621832;
/*    */   }
/*    */   
/*    */ 
/*    */   public CPutOnChatBubbleReq() {}
/*    */   
/*    */ 
/*    */   public CPutOnChatBubbleReq(int _chatbubblecfgid_)
/*    */   {
/* 41 */     this.chatbubblecfgid = _chatbubblecfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.chatbubblecfgid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.chatbubblecfgid = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CPutOnChatBubbleReq)) {
/* 64 */       CPutOnChatBubbleReq _o_ = (CPutOnChatBubbleReq)_o1_;
/* 65 */       if (this.chatbubblecfgid != _o_.chatbubblecfgid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.chatbubblecfgid;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.chatbubblecfgid).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CPutOnChatBubbleReq _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.chatbubblecfgid - _o_.chatbubblecfgid;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatbubble\CPutOnChatBubbleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */