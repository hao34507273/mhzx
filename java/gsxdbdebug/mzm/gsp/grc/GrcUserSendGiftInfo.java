/*    */ package mzm.gsp.grc;
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
/* 13 */     this.today_send_gift_infos = new ArrayList();
/*    */   }
/*    */   
/*    */   public GrcUserSendGiftInfo(int _gift_type_, ArrayList<GrcSendGiftInfo> _today_send_gift_infos_) {
/* 17 */     this.gift_type = _gift_type_;
/* 18 */     this.today_send_gift_infos = _today_send_gift_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     for (GrcSendGiftInfo _v_ : this.today_send_gift_infos)
/* 23 */       if (!_v_._validator_()) return false;
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.gift_type);
/* 29 */     _os_.compact_uint32(this.today_send_gift_infos.size());
/* 30 */     for (GrcSendGiftInfo _v_ : this.today_send_gift_infos) {
/* 31 */       _os_.marshal(_v_);
/*    */     }
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 37 */     this.gift_type = _os_.unmarshal_int();
/* 38 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 39 */       GrcSendGiftInfo _v_ = new GrcSendGiftInfo();
/* 40 */       _v_.unmarshal(_os_);
/* 41 */       this.today_send_gift_infos.add(_v_);
/*    */     }
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof GrcUserSendGiftInfo)) {
/* 49 */       GrcUserSendGiftInfo _o_ = (GrcUserSendGiftInfo)_o1_;
/* 50 */       if (this.gift_type != _o_.gift_type) return false;
/* 51 */       if (!this.today_send_gift_infos.equals(_o_.today_send_gift_infos)) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.gift_type;
/* 60 */     _h_ += this.today_send_gift_infos.hashCode();
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.gift_type).append(",");
/* 68 */     _sb_.append(this.today_send_gift_infos).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\GrcUserSendGiftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */