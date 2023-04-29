/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class GrcUserSendGiftInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int gift_type;
/*    */   public ArrayList<GrcSendGiftInfo> today_send_gift_infos;
/*    */   
/*    */   public GrcUserSendGiftInfo()
/*    */   {
/* 13 */     this.gift_type = 1;
/* 14 */     this.today_send_gift_infos = new ArrayList();
/*    */   }
/*    */   
/*    */   public GrcUserSendGiftInfo(int _gift_type_, ArrayList<GrcSendGiftInfo> _today_send_gift_infos_) {
/* 18 */     this.gift_type = _gift_type_;
/* 19 */     this.today_send_gift_infos = _today_send_gift_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     for (GrcSendGiftInfo _v_ : this.today_send_gift_infos)
/* 24 */       if (!_v_._validator_()) return false;
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.gift_type);
/* 30 */     _os_.compact_uint32(this.today_send_gift_infos.size());
/* 31 */     for (GrcSendGiftInfo _v_ : this.today_send_gift_infos) {
/* 32 */       _os_.marshal(_v_);
/*    */     }
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     this.gift_type = _os_.unmarshal_int();
/* 39 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 40 */       GrcSendGiftInfo _v_ = new GrcSendGiftInfo();
/* 41 */       _v_.unmarshal(_os_);
/* 42 */       this.today_send_gift_infos.add(_v_);
/*    */     }
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 48 */     if (_o1_ == this) return true;
/* 49 */     if ((_o1_ instanceof GrcUserSendGiftInfo)) {
/* 50 */       GrcUserSendGiftInfo _o_ = (GrcUserSendGiftInfo)_o1_;
/* 51 */       if (this.gift_type != _o_.gift_type) return false;
/* 52 */       if (!this.today_send_gift_infos.equals(_o_.today_send_gift_infos)) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += this.gift_type;
/* 61 */     _h_ += this.today_send_gift_infos.hashCode();
/* 62 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 66 */     StringBuilder _sb_ = new StringBuilder();
/* 67 */     _sb_.append("(");
/* 68 */     _sb_.append(this.gift_type).append(",");
/* 69 */     _sb_.append(this.today_send_gift_infos).append(",");
/* 70 */     _sb_.append(")");
/* 71 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcUserSendGiftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */