/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ public class GrcReceivedGiftInfos implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int gift_type;
/*    */   public int receive_times;
/*    */   public LinkedList<Long> serialids;
/*    */   
/*    */   public GrcReceivedGiftInfos()
/*    */   {
/* 14 */     this.serialids = new LinkedList();
/*    */   }
/*    */   
/*    */   public GrcReceivedGiftInfos(int _gift_type_, int _receive_times_, LinkedList<Long> _serialids_) {
/* 18 */     this.gift_type = _gift_type_;
/* 19 */     this.receive_times = _receive_times_;
/* 20 */     this.serialids = _serialids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.gift_type);
/* 29 */     _os_.marshal(this.receive_times);
/* 30 */     _os_.compact_uint32(this.serialids.size());
/* 31 */     for (Long _v_ : this.serialids) {
/* 32 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     this.gift_type = _os_.unmarshal_int();
/* 39 */     this.receive_times = _os_.unmarshal_int();
/* 40 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 42 */       long _v_ = _os_.unmarshal_long();
/* 43 */       this.serialids.add(Long.valueOf(_v_));
/*    */     }
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof GrcReceivedGiftInfos)) {
/* 51 */       GrcReceivedGiftInfos _o_ = (GrcReceivedGiftInfos)_o1_;
/* 52 */       if (this.gift_type != _o_.gift_type) return false;
/* 53 */       if (this.receive_times != _o_.receive_times) return false;
/* 54 */       if (!this.serialids.equals(_o_.serialids)) return false;
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 61 */     int _h_ = 0;
/* 62 */     _h_ += this.gift_type;
/* 63 */     _h_ += this.receive_times;
/* 64 */     _h_ += this.serialids.hashCode();
/* 65 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuilder _sb_ = new StringBuilder();
/* 70 */     _sb_.append("(");
/* 71 */     _sb_.append(this.gift_type).append(",");
/* 72 */     _sb_.append(this.receive_times).append(",");
/* 73 */     _sb_.append(this.serialids).append(",");
/* 74 */     _sb_.append(")");
/* 75 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\GrcReceivedGiftInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */