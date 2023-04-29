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
/*    */ public class SPacketInChatInfo
/*    */   extends __SPacketInChatInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585229;
/*    */   public long checkedroleid;
/*    */   public int packettype;
/*    */   public Octets checkinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12585229;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SPacketInChatInfo()
/*    */   {
/* 35 */     this.checkinfo = new Octets();
/*    */   }
/*    */   
/*    */   public SPacketInChatInfo(long _checkedroleid_, int _packettype_, Octets _checkinfo_) {
/* 39 */     this.checkedroleid = _checkedroleid_;
/* 40 */     this.packettype = _packettype_;
/* 41 */     this.checkinfo = _checkinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.checkedroleid);
/* 50 */     _os_.marshal(this.packettype);
/* 51 */     _os_.marshal(this.checkinfo);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.checkedroleid = _os_.unmarshal_long();
/* 57 */     this.packettype = _os_.unmarshal_int();
/* 58 */     this.checkinfo = _os_.unmarshal_Octets();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SPacketInChatInfo)) {
/* 68 */       SPacketInChatInfo _o_ = (SPacketInChatInfo)_o1_;
/* 69 */       if (this.checkedroleid != _o_.checkedroleid) return false;
/* 70 */       if (this.packettype != _o_.packettype) return false;
/* 71 */       if (!this.checkinfo.equals(_o_.checkinfo)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += (int)this.checkedroleid;
/* 80 */     _h_ += this.packettype;
/* 81 */     _h_ += this.checkinfo.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.checkedroleid).append(",");
/* 89 */     _sb_.append(this.packettype).append(",");
/* 90 */     _sb_.append("B").append(this.checkinfo.size()).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SPacketInChatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */