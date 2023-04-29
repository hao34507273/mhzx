/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SGrcReceiveAllGiftResp
/*    */   extends __SGrcReceiveAllGiftResp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600331;
/*    */   public int retcode;
/*    */   public LinkedList<GrcReceivedGiftInfos> receive_gifts;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600331;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGrcReceiveAllGiftResp()
/*    */   {
/* 34 */     this.receive_gifts = new LinkedList();
/*    */   }
/*    */   
/*    */   public SGrcReceiveAllGiftResp(int _retcode_, LinkedList<GrcReceivedGiftInfos> _receive_gifts_) {
/* 38 */     this.retcode = _retcode_;
/* 39 */     this.receive_gifts = _receive_gifts_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (GrcReceivedGiftInfos _v_ : this.receive_gifts)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.retcode);
/* 50 */     _os_.compact_uint32(this.receive_gifts.size());
/* 51 */     for (GrcReceivedGiftInfos _v_ : this.receive_gifts) {
/* 52 */       _os_.marshal(_v_);
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.retcode = _os_.unmarshal_int();
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 60 */       GrcReceivedGiftInfos _v_ = new GrcReceivedGiftInfos();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.receive_gifts.add(_v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SGrcReceiveAllGiftResp)) {
/* 73 */       SGrcReceiveAllGiftResp _o_ = (SGrcReceiveAllGiftResp)_o1_;
/* 74 */       if (this.retcode != _o_.retcode) return false;
/* 75 */       if (!this.receive_gifts.equals(_o_.receive_gifts)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.retcode;
/* 84 */     _h_ += this.receive_gifts.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.retcode).append(",");
/* 92 */     _sb_.append(this.receive_gifts).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SGrcReceiveAllGiftResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */