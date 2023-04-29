/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSynOfflineChatContents
/*    */   extends __SSynOfflineChatContents__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585275;
/*    */   public int channel_type;
/*    */   public long ownerid;
/*    */   public LinkedList<Octets> contents;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12585275;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSynOfflineChatContents()
/*    */   {
/* 35 */     this.contents = new LinkedList();
/*    */   }
/*    */   
/*    */   public SSynOfflineChatContents(int _channel_type_, long _ownerid_, LinkedList<Octets> _contents_) {
/* 39 */     this.channel_type = _channel_type_;
/* 40 */     this.ownerid = _ownerid_;
/* 41 */     this.contents = _contents_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.channel_type);
/* 50 */     _os_.marshal(this.ownerid);
/* 51 */     _os_.compact_uint32(this.contents.size());
/* 52 */     for (Octets _v_ : this.contents) {
/* 53 */       _os_.marshal(_v_);
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.channel_type = _os_.unmarshal_int();
/* 60 */     this.ownerid = _os_.unmarshal_long();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       Octets _v_ = _os_.unmarshal_Octets();
/* 64 */       this.contents.add(_v_);
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SSynOfflineChatContents)) {
/* 75 */       SSynOfflineChatContents _o_ = (SSynOfflineChatContents)_o1_;
/* 76 */       if (this.channel_type != _o_.channel_type) return false;
/* 77 */       if (this.ownerid != _o_.ownerid) return false;
/* 78 */       if (!this.contents.equals(_o_.contents)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.channel_type;
/* 87 */     _h_ += (int)this.ownerid;
/* 88 */     _h_ += this.contents.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.channel_type).append(",");
/* 96 */     _sb_.append(this.ownerid).append(",");
/* 97 */     _sb_.append(this.contents).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SSynOfflineChatContents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */